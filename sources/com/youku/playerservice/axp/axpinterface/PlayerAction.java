package com.youku.playerservice.axp.axpinterface;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public enum PlayerAction {
    IS_SUPPORT_AUDIO_ENHANCE("is_support_audio_enhance"),
    OPEN_AUDIO_ENHANCE("open_audio_enhance"),
    GET_PLAYER_HASHCODE("get_player_hashcode"),
    SWITCH_PLAYER_MODE("switch_player_mode"),
    SET_BINOCULAR_MODE("set_binocular_mode"),
    GET_RENDER_TYPE("get_render_type"),
    SCREENSHOT_ONE_FRAME("screenshot_one_frame"),
    SCREENSHOT_MULTI_FRAMES_BEGIN("screenshot_multi_frames_begin"),
    SCREENSHOT_MULTI_FRAMES_END("screenshot_multi_frames_end"),
    SET_NOTSTOPFLAG("set_notstopflag"),
    QUERY_SIX_DOF_ANGLE("get_six_dof_angle"),
    RAPHAEL_SET_PARAMS("raphael_set_params"),
    DO_AD("do_ad");
    
    private String action;

    PlayerAction(String str) {
        this.action = str;
    }
}
