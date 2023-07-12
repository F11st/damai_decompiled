package com.youku.uplayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RegisterCodec {
    public RegisterCodec() {
        native_avcodec_register_all();
        native_av_register_all();
    }

    private native void native_av_register_all();

    private native void native_avcodec_register_all();
}
