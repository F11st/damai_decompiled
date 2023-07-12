package com.taobao.ma.analyze.api;

import com.taobao.ma.decode.MaDecode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaMemoryAPI {
    public static void ReleaseCameraMemory() {
        MaDecode.releaseStaticMemory();
    }
}
