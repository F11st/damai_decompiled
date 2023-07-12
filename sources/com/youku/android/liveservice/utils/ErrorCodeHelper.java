package com.youku.android.liveservice.utils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ErrorCodeHelper {
    public static final int LIVE_ERROR_BASE = 70000;
    public static final int LIVE_ERROR_PLAYCONTROL_LIVE_COMPLETE = 48704;
    public static final int LIVE_ERROR_PLAYCONTROL_LIVE_NOT_BEGIN = 48703;
    public static final int LIVE_ERROR_PLAYCONTROL_REQUEST_ERROR = 48702;
    public static final int LIVE_ERROR_PLAYCONTROL_REQUEST_SYSTEM_ERROR = 48701;
    public static final int LIVE_ERROR_PLAYCONTROL_UNPARSABLE = 48700;
    public static final int LIVE_ERROR_UNDO_AUDIO_MICMODE = 48706;
    public static final int LIVE_ERROR_UNDO_PK_MCU_0 = 48710;
    public static final int LIVE_ERROR_UNDO_UNKNOWN_MICMODE = 48707;
    public static final int LIVE_ERROR_UNDO_VIDEO_MCU_0 = 48708;
    public static final int LIVE_ERROR_UNDO_VIDEO_MCU_1_NOTONMIC = 48709;
    public static final int LIVE_ERROR_UNKNOWN_STREAMMODE = 48705;
    public static final int LIVE_STATUS_OK = 0;
    public static final int PLAYCONTROL_STATUS_OK_END = 299;
    public static final int PLAYCONTROL_STATUS_OK_FIRST = 200;

    public static int errorFromPlayControl(int i) {
        if (i < 200 || i > 299) {
            return i < 10000 ? Math.abs(i) + 70000 : i;
        }
        return 0;
    }

    public static int errorFromPlayControlQuality(int i) {
        return i < 10000 ? Math.abs(i) + 70000 : i;
    }

    public static boolean statusFromPlayControlIsOK(int i) {
        return (i >= 200 && i <= 299) || i == 2002 || i == 2001;
    }

    public static boolean statusFromQualityIsOK(int i) {
        return i >= 200 && i <= 299;
    }
}
