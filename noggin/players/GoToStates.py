import man.motion.SweetMoves as SweetMoves
from .. import NogginConstants as FC

POINTS_FILE = "/media/userdata/points.cfg"
GOTO_POINTS = [(FC.CENTER_FIELD_X, FC.CENTER_FIELD_Y, FC.OPP_GOAL_HEADING),
               (FC.OPP_GOALBOX_LEFT_X, FC.FIELD_HEIGHT*0.75, FC.MY_GOAL_HEADING),
               (FC.OPP_GOALBOX_LEFT_X, FC.FIELD_HEIGHT*0.25, FC.MY_GOAL_HEADING),
               (FC.MY_GOALBOX_RIGHT_X, FC.FIELD_HEIGHT*0.25, FC.OPP_GOAL_HEADING),
               (FC.MY_GOALBOX_RIGHT_X, FC.FIELD_HEIGHT*0.75, FC.OPP_GOAL_HEADING),
               (FC.CENTER_FIELD_X, FC.CENTER_FIELD_Y, FC.OPP_GOAL_HEADING)]

def gameReady(player):
    if player.firstFrame():
        player.brain.tracker.locPans()
    return player.stay()

def convertCoords(x):
    x[0] = x[0] + FC.CENTER_FIELD_X
    x[1] = x[1] + FC.CENTER_FIELD_Y
    return x

def gamePlaying(player):
    f = open(POINTS_FILE, 'r')
    player.GOTO_POINTS = [convertCoords(x) for x in
                          [[float(i) for i in l.split()] for l in f.readlines()]]
    player.goToPoint = player.GOTO_POINTS[0]
    player.goToCounter = 0
    return player.goNow('goToPoint')

def goToPoint(player):
    if player.firstFrame():
        player.brain.tracker.locPans()
        player.brain.nav.goTo(player.GOTO_POINTS[player.goToCounter])
    if player.brain.nav.isStopped() and not player.firstFrame():
        return player.goLater('atPoint')

    return player.stay()

def atPoint(player):
    if player.firstFrame():
        player.goToCounter += 1
        player.executeMove(SweetMoves.SAVE_CENTER_DEBUG)
    elif player.stateTime >= SweetMoves.getMoveTime(SweetMoves.SAVE_CENTER_DEBUG):
        if player.goToCounter >= len(GOTO_POINTS):
            return player.goLater('atFinalPoint')
        else:
            return player.goLater('goToPoint')
    return player.stay()

def atFinalPoint(player):
    if player.firstFrame():
        player.executeMove(SweetMoves.SIT_POS)
        player.brain.tracker.stopHeadMoves()

    return player.stay()
