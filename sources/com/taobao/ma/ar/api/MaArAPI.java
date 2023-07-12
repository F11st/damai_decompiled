package com.taobao.ma.ar.api;

import com.taobao.ma.ar.ARInputParam;
import com.taobao.ma.ar.ARResult;
import com.taobao.ma.decode.MaDecode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaArAPI {
    public static ARResult detectGen3Markers(ARInputParam aRInputParam) {
        return MaDecode.detectGen3Markers(aRInputParam);
    }
}
