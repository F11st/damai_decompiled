package com.taobao.power_image.loader;

import tb.vt1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface PowerImageLoaderProtocol {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PowerImageResponse {
        void onResult(PowerImageResult powerImageResult);
    }

    void handleRequest(vt1 vt1Var, PowerImageResponse powerImageResponse);
}
