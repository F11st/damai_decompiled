package com.youku.live.animation;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnimationError {
    public static final int CODE_NO_RESOURCE = 10001;
    public static final String MSG_NO_RESOURCE = "resource no found";
    public int errorCode;
    public String errorMessage;

    public AnimationError() {
        this.errorCode = 10001;
        this.errorMessage = MSG_NO_RESOURCE;
    }

    public AnimationError(int i, String str) {
        this.errorCode = 10001;
        this.errorMessage = MSG_NO_RESOURCE;
        this.errorCode = i;
        this.errorMessage = str;
    }
}
