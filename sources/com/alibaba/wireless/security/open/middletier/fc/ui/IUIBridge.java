package com.alibaba.wireless.security.open.middletier.fc.ui;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IUIBridge {
    public static final String INTENT_ACTIVITY_CREATE = "com.alibaba.wireless.security.open.middletier.fc.ui.BXIntentCreate4323";
    public static final String INTENT_ACTIVITY_RESULT = "com.alibaba.wireless.security.open.middletier.fc.ui.BXIntentResult4323";
    public static final String INTENT_SEND_LOG = "com.alibaba.wireless.security.open.middletier.fc.ui.BXIntentLog4323";
    public static final String KEY_IS_SAMPLE = "BXExtraInfoUIIsSample4323";
    public static final String KEY_SESSION_ID = "BXExtraInfoSession4323";
    public static final String KEY_UI_INFO = "BXExtraInfoUIInfo4323";
    public static final String KEY_UI_LOG = "BXExtraInfoUILog4323";
    public static final String KEY_UI_LOG_SEND = "BXExtraInfoUILogSend4323";
    public static final String KEY_UI_LOG_WAY = "BXExtraInfoUILogWay4323";
    public static final String KEY_UI_RESULT = "BXExtraInfoUIResult4323";
    public static final int UI_CANCEL = 4;
    public static final int UI_FAIL = 2;
    public static final int UI_INFO_0_RESET = 0;
    public static final int UI_INFO_11_ON_CREATE = 11;
    public static final int UI_INFO_12_ON_CREATE_EXCEPTION = 12;
    public static final int UI_INFO_13_ON_RESUME = 13;
    public static final int UI_INFO_14_ON_PAUSE = 14;
    public static final int UI_INFO_15_UI_SUCCESS = 15;
    public static final int UI_INFO_16_UI_CLOSE = 16;
    public static final int UI_INFO_17_UI_FAIL = 17;
    public static final int UI_INFO_18_DESTROY3_TIMEOUT = 18;
    public static final int UI_INFO_19_DESTROY4_ON_BACK_PRESSED = 19;
    public static final int UI_INFO_1_START = 1;
    public static final int UI_INFO_20_DESTROY5_ON_PAUSE_OVERLAY = 20;
    public static final int UI_INFO_21_TOUCH = 21;
    public static final int UI_INFO_22_ON_DESTROY = 22;
    public static final int UI_INFO_2_START2 = 2;
    public static final int UI_INFO_3_TIMEOUT = 3;
    public static final int UI_INFO_4_TIMEOUT = 4;
    public static final int UI_SUCCESS = 1;
    public static final int UI_TIMEOUT = 8;

    void addUIItem(long j, Object obj);

    void clearTimeoutItem(long j);

    void removeUIItem(long j);
}
