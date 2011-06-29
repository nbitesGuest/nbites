
MAX_PAN_SPEED = 200.0              # deg/sec

TRACKER_FRAMES_ON_TRACK_THRESH = 2 # ** # look into
TRACKER_FRAMES_OFF_REFIND_THRESH = 4 # ** # look into
ACTIVE_LOC_STARE_THRESH = 45
ACTIVE_LOC_STARE_GOALIE_THRESH = 15
ACTIVE_LOC_OFF_REFIND_THRESH = 40
LOOK_TO_TIME_TO_FIND = 45
TRACKER_FRAMES_SEARCH_THRESH = 15 # ** # debugging values
TRACKER_FRAMES_STARE_THRESH = 20 # ** # debugging values
TRACKER_BALL_STARE_THRESH = 20 # ** # debugging values

MAX_ACTIVE_TRACKING_DIST = 80

NUM_ACTIVE_PANS = 2
(PAN_LEFT,
 PAN_RIGHT) = range(NUM_ACTIVE_PANS)

PAN_UP_PITCH_THRESH = 10

NUM_LOOK_DIRS = 4
(LOOK_LEFT,
 LOOK_UP,
 LOOK_RIGHT,
 LOOK_DOWN) = range(NUM_LOOK_DIRS)

FITNESS_THRESHOLD = 400
BEARING_THRESHOLD = 90
ELEVATION_OFFSET_LIMIT = 20
BEARING_OFFSET_LIMIT = 25 # ** # might need to go up slightly?
