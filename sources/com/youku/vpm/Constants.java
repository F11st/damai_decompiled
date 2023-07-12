package com.youku.vpm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Constants {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class AD {
        public static final int TYPE_MID = 2;
        public static final int TYPE_POST = 1;
        public static final int TYPE_PRE = 0;
        public static final int TYPE_STREAM = 3;
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Extras {
        public static final String EXTRAS_ABR_INFO = "extras_abr_info";
        public static final String EXTRAS_NETM3S_INFO = "extras_netm3s_info";
        public static final String EXTRAS_PLAYER_INFO = "extras_player_info";
        public static final String EXTRAS_VIDEO_INFO = "extras_video_info";
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface PlayCode {
        public static final int HTTP_EXCEPTION = 101;
        public static final int RETURN_WHEN_AD = -995;
        public static final int RETURN_WHEN_BUFFERING = -994;
        public static final int RETURN_WHEN_MID_AD = -992;
        public static final int RETURN_WHEN_SEEKING = -993;
        public static final int RETURN_WHEN_VIDEO_REAL_PLAYING = -991;
        public static final int USER_DLNA_RETURN = -990;
        public static final int USER_LOADING_RETURN = -997;
        public static final int USER_RETURN = -998;
        public static final int VIDEO_LOADING_FAIL = -996;
        public static final int VIDEO_NOT_EXIST = -106;
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class UserAction {
        public static final String AIRPLAY = "airplay";
        public static final String BACKSTAGE = "backstage";
        public static final String BLOCKED = "blocked";
        public static final String LOW_SPEED = "lowspeed";
        public static final String QUIT = "quit";
        public static final String RELEASE = "release";
        public static final String SEEK = "seek";
        public static final String SHIFT_AUDIO = "shiftaudio";
        public static final String SHIFT_DOWN = "shiftdown";
        public static final String SHIFT_LANG = "shiftlang";
        public static final String SHIFT_VIDEO = "shiftvideo";
        public static final String TUNE = "tune";
        public static final String VIDEO_START = "videostart";
        public static final String WAITING = "waiting";
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class VPM {
        public static final String PLAYER_CORE = "alix";
    }
}
