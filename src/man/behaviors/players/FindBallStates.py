import ChaseBallConstants as constants
import ChaseBallTransitions as transitions
from ..util import *
from objects import Location

@superState('gameControllerResponder')
def findBall(player):
    """
    State to stop all activity and begin finding the ball
    """
    if transitions.shouldChaseBall(player):
        # TODO
        if not player.brain.playerNumber == 4:
            return player.goLater('planner')
        else:
            return player.goLater('approachBall')

    return player.goNow('spinFindBall')

@superState('gameControllerResponder')
def spinFindBall(player):
    """
    State to spin to find the ball. If we find the ball, we
    move to align on it. If we don't find it, we walk to look for it
    """
    if transitions.shouldChaseBall(player):
        player.stopWalking()
        player.brain.tracker.trackBall()
        return player.goLater('findBall')

    if player.firstFrame():
        player.brain.tracker.stopHeadMoves()
        player.stopWalking()

    if player.brain.nav.isStopped() and player.brain.tracker.isStopped():
        my = player.brain.loc
        ball = Location(player.brain.ball.x, player.brain.ball.y)
        spinDir = my.spinDirToPoint(ball)
        player.setWalk(0, 0, spinDir*constants.FIND_BALL_SPIN_SPEED)

        player.brain.tracker.spinPan()

    # TODO
    if ((player.brain.playerNumber == 4 and transitions.shouldWalkFindBall(player))
        or (not player.brain.playerNumber == 4 and transitions.spunOnce(player))):
        return player.goLater('planner')

    return player.stay()
