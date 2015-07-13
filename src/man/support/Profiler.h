#ifndef _Profiler_h_DEFINED
#define _Profiler_h_DEFINED

#include <algorithm>
#include <boost/shared_ptr.hpp>
#include "Common.h"
#include "DebugConfig.h"
#include "iostream"
class Profiler;

#ifdef USE_TIME_PROFILING
#  define PROF_NFRAME()  (Profiler::getInstance()->nextFrame());
#  define PROF_ENTER(c) (Profiler::getInstance()->enterComponent(c));
#  define PROF_EXIT(c)  (Profiler::getInstance()->exitComponent(c));
#  define PROF_ENTER2(c1, c2, first) (Profiler::getInstance()->enterDoubleComponent(c1, c2, first));
#  define PROF_EXIT2(c1, c2, first) (Profiler::getInstance()->exitDoubleComponent(c1, c2, first));
#else
#  define PROF_NFRAME()
#  define PROF_ENTER(c)
#  define PROF_EXIT(c)
#  define PROF_ENTER2(c1, c2, first)
#  define PROF_EXIT2(c1, c2, first)
#endif

enum ProfiledComponent {
    // COGNITION THREAD
    P_COGNITION_THREAD = 0,

    P_TOP_DQBUF,
    P_BOT_DQBUF,
    P_ACQUIRE_IMAGE,

    P_VISION,
    P_VISION_TOP,
    P_FRONT_TOP,
    P_GRAD_TOP,
    P_FIELD_TOP,
    P_EDGE_TOP,
    P_HOUGH_TOP,
    P_EDGEMAP_TOP,
    P_CIRCLE_TOP,
    P_LINES_TOP,
    P_LINECLASS_TOP,
    P_BALL_TOP,
    P_VISION_BOT,
    P_FRONT_BOT,
    P_GRAD_BOT,
    P_FIELD_BOT,
    P_EDGE_BOT,
    P_HOUGH_BOT,
    P_EDGEMAP_BOT,
    P_CIRCLE_BOT,
    P_LINES_BOT,
    P_LINECLASS_BOT,
    P_BALL_BOT,
    P_OBSTACLE,

    P_SELF_LOC,
    P_LOC_MOTION,
    P_LOC_VISION,
    P_LOCV_SCORING,
    P_LOCV_INJECTION,
    P_LOC_RESAMPLE,
    P_BALL_TRACK,

    P_BEHAVIORS,
    P_PYTHON,

    P_LIGHTS,

    // MOTION THREAD
    P_MOTION_THREAD,

    P_JOINT_ENACTOR,
    P_PRE_PROCESS,
    P_SEND_JOINTS,
    P_SEND_HARDNESS,

    P_MOTION,
    P_SCRIPTED,
    P_CHOPPED,
    P_WALK,
    P_HEAD,

    // COMM THREAD
    P_COMM_THREAD,
    P_COMM_RECEIVE,
    P_COMM_SEND,
    P_COMM_BUILD_PACKET,
    P_COMM_SERIALIZE_PACKET,
    P_COMM_TO_SOCKET,
    P_COMM_TIMER,

    // GUARDIAN THREAD
    P_GUARDIAN_THREAD,

    P_GUARDIAN,
    P_AUDIO,

    P_TOTAL
};

static const int NUM_PCOMPONENTS = P_TOTAL + 1;

class Profiler {
  public:

    Profiler(long long (*thread_time_f)(),
             long long (*process_time_f)(),
             long long (*global_time_f)());
    ~Profiler();

    void profileFrames(int num_frames);
    void reset();

    void printCurrent();
    void printSummary();
    void printCSVSummary();
    void printIndentedSummary();

    bool nextFrame();

    static Profiler* getInstance();

    inline void enterComponent(ProfiledComponent c) {
        if (!profiling)
            return;
        if (enterTime[c] != 0)
            std::cout << "ERROR: PROF Entered twice on: " << c << " without exiting" << std::endl;
        enterTime[c] = thread_timeFunction();
    }
    inline void exitComponent(ProfiledComponent c) {
        if (!profiling)
            return;
        lastTime[c] = thread_timeFunction() - enterTime[c];
        enterTime[c] = 0;
        minTime[c] = std::min(lastTime[c], minTime[c]);
        maxTime[c] = std::max(lastTime[c], maxTime[c]);
    }

    inline void enterDoubleComponent(ProfiledComponent c1,
                                     ProfiledComponent c2,
                                     bool first) {
        if (first) {
            enterComponent(c1);
        }
        else {
            enterComponent(c2);
        }
    }

    inline void exitDoubleComponent(ProfiledComponent c1,
                                    ProfiledComponent c2,
                                    bool first) {
        if (first) {
            exitComponent(c1);
        }
        else {
            exitComponent(c2);
        }
    }

    inline bool shouldNotPrintLine(int i) {
        // Don't print those times which are zero, i.e. they weren't run.
        return (!printEmpty && sumTime[i] == 0);
    }

  public:
    enum { PRINT_ALL_DEPTHS = -1 };

  private:

    bool profiling;
    bool printEmpty;
    int maxPrintDepth;

    long long (*thread_timeFunction) ();
    long long (*process_timeFunction) ();
    long long (*global_timeFunction) ();

    bool start_next_frame;
    int num_profile_frames;
    int current_frame;
    long long enterTime[NUM_PCOMPONENTS];
    long long lastTime[NUM_PCOMPONENTS];
    long long profile_process_start_time;
    long long profile_global_start_time;

    bool verbose;

public:
    long long minTime[NUM_PCOMPONENTS];
    long long maxTime[NUM_PCOMPONENTS];
    long long sumTime[NUM_PCOMPONENTS];
};

#endif
