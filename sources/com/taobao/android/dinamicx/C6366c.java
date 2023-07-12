package com.taobao.android.dinamicx;

import tb.fy;
import tb.wt;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.c */
/* loaded from: classes12.dex */
public class C6366c {
    static IDXElderInterface a;
    static fy b;

    public static float a(float f) {
        return f() ? c(f) : f;
    }

    public static float b(DXRuntimeContext dXRuntimeContext, float f) {
        return f() ? d(dXRuntimeContext, f) : f;
    }

    public static float c(float f) {
        fy fyVar = b;
        return fyVar == null ? f : fyVar.a(Float.valueOf(f)).floatValue();
    }

    public static float d(DXRuntimeContext dXRuntimeContext, float f) {
        fy e = e(dXRuntimeContext.config);
        return e == null ? f : e.a(Float.valueOf(f)).floatValue();
    }

    private static fy e(DXEngineConfig dXEngineConfig) {
        if (dXEngineConfig == null) {
            return null;
        }
        return dXEngineConfig.d();
    }

    public static boolean f() {
        IDXElderInterface iDXElderInterface = a;
        if (iDXElderInterface == null) {
            return false;
        }
        return iDXElderInterface.isElder();
    }

    public static boolean g(String str) {
        return wt.m0(str);
    }
}
