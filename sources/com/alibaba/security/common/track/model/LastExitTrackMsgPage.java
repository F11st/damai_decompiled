package com.alibaba.security.common.track.model;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum LastExitTrackMsgPage {
    H5("h5"),
    BIO("bio"),
    TAKE_PHOTO("takephoto");
    
    private String msg;

    LastExitTrackMsgPage(String str) {
        this.msg = str;
    }

    public final String getMsg() {
        return this.msg;
    }
}
