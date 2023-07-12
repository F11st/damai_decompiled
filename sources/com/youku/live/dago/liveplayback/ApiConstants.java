package com.youku.live.dago.liveplayback;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ApiConstants {
    public static final int PAYTYPE_HBR = 3;
    public static final int PAYTYPE_TRAIL_FINISH = 1;
    public static final int PAYTYPE_TRAIL_NOTFINISH = 2;
    public static final int PAYTYPE_UNKNOWN = 0;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface EventParams {
        public static final String ARG1 = "arg1";
        public static final String ARG2 = "arg2";
        public static final String EXTRA = "extra";
        public static final String KEY_CODE = "key_code";
        public static final String KEY_EVENT = "key_event";
        public static final String MESSAGE = "msg";
        public static final String OBJECT = "object";
        public static final String TYPE = "type";
        public static final String VISIBLE = "visible";
        public static final String WHAT = "what";
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface EventType {
        public static final String CLOSE_DLNA_MODE = "kubus://dlna/dago_notification/request_dlna_quit";
        public static final String DLNA_PLAYER_PAUSE = "kubus://player/notification/on_dlna_player_pause";
        public static final String DLNA_PLAYER_START = "kubus://player/notification/on_dlna_player_start";
        public static final String ENGINE_PUT_DATA = "kubus://player/notification/engine_put_data";
        public static final String HBR_QUALITY_CHANGE_CANCEL = "kubus://player/notification/dago_frame_quality_cancel";
        public static final String HBR_QUALITY_CHANGE_CLICK = "kubus://player/notification/dago_frame_quality_change_click";
        public static final String HBR_QUALITY_CHANGE_FINISHED = "kubus://player/notification/dago_frame_quality_finished";
        public static final String HBR_QUALITY_CHANGING = "kubus://player/notification/dago_frame_quality_changing";
        public static final String HIDE_CONTROL = "kubus://player/request/dago_hide_control";
        public static final String INTERACT_SEI_NOTIFY = "kubus://player/notification/interact_sei_notify";
        public static final String IS_CHANGE_QUALITY_TIP_SHOWING = "kubus://quality/request/dago_is_showing_change_quality_tip";
        public static final String IS_PLAYER_3G_DATA_TIP_SHOWING = "kubus://tip3g/request/dago_is_showing_player_3g_data_tip";
        public static final String ON_ACTIVITY_KEY_DOWN = "kubus://activity/notification/dago_on_activity_key_down";
        public static final String ON_CONTROL_VISIBILITY_CHANGE = "kubus://player/notification/dago_notify_control_show_change";
        public static final String ON_GESTURE_SCROLL = "kubus://gesture/notification/dago_on_gesture_scroll";
        public static final String ON_GESTURE_SCROLL_END = "kubus://gesture/notification/dago_on_gesture_scroll_end";
        public static final String ON_GESTURE_SCROLL_START = "kubus://gesture/notification/dago_on_gesture_scroll_start";
        public static final String ON_QUALITY_TIP_VISIBILITY_CHANGE = "kubus://quality/notification/dago_quality_tip_visible_changed";
        public static final String ON_SCREEN_MODE_CHANGE = "kubus://player/notification/dago_on_screen_mode_changed";
        public static final String ON_SEEK_STOP = "kubus://player/notification/dago_on_seek_stop";
        public static final String ON_SINGLE_TAP = "kubus://player/notification/dago_single_tap";
        public static final String ORIENTATION_DISABLE = "kubus://screen/notification/dago_orientation_disable";
        public static final String ORIENTATION_ENABLE = "kubus://screen/notification/dago_orientation_enable";
        public static final String REFRESH_CONTROL_VIEW = "kubus://player/notification/dago_refresh_control";
        public static final String REQUEST_CLOSE_HBR = "kubus://player/notification/dago_close_hbr";
        public static final String REQUEST_DLNA_SHOW_FULLSCREEN = "kubus://dlna/notification/dago_request_dlna_show_fullscreen";
        public static final String REQUEST_DLNA_SHOW_SMALL = "kubus://dlna/notification/dago_request_dlna_show_small";
        public static final String REQUEST_IS_CHANGING_HBR = "kubus://player/notification/dago_is_changing_hbr";
        public static final String REQUEST_IS_TOP_TIP_SHOWING = "kubus://player/request/dago_request_is_top_tip_showing";
        public static final String REQUEST_OPEN_HBR = "kubus://player/notification/dago_open_hbr";
        public static final String REQUEST_QUALITY_VIEW_HIDE = "kubus://cover/request/dago_request_quality_view_hide";
        public static final String REQUEST_TOP_TIP_HIDE = "kubus://player/request/dago_request_toptip_hide";
        public static final String REQUEST_TOP_TIP_SHOW = "kubus://player/request/dago_request_toptip_show";
        public static final String ROTATE_FINISH = "kubus://player/notification/rotate_finish";
        public static final String ROTATE_START = "kubus://player/notification/rotate_start";
        public static final String SHOW_BUY_VIEW = "kubus://player/notification/show_buy_view";
        public static final String SHOW_CONTROL = "kubus://player/request/dago_show_control";
        public static final String SHOW_DLNA_NOTIFY_TIP = "kubus://dlna/notification/dago_show_dlna_notify_tip";
        public static final String SHOW_ERROR = "kubus://player/notification/show_error";
        public static final String SHOW_FREE_FLOW = "kubus://player/notification/show_free_flow";
        public static final String SHOW_HBR_INSTRUCTION = "kubus://player/request/dago_show_hbr_introduction";
        public static final String SHOW_QUALITY = "kubus://player/notification/dago_show_quality";
        public static final String TOGGLE_DLNA_PLAY_PAUSE_STATUS = "kubus://dlna/request/dago_toggle_dlna_play_pause_status";
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface GestureScrollMode {
        public static final int MODE_HORIZONTAL = 1;
        public static final int MODE_VERTICAL_CENTER = 4;
        public static final int MODE_VERTICAL_LEFT = 2;
        public static final int MODE_VERTICAL_RIGHT = 3;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ScreenMode {
        public static final int MODE_FULL_SCREEN = 1;
        public static final int MODE_FULL_SCREEN_VERTICAL = 2;
        public static final int MODE_PICTURE_IN_PICTURE = 3;
        public static final int MODE_SMALL = 0;
    }
}
