package com.taobao.analysis.v3;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public final class FalcoGlobalTracer {
    private static FalcoTracer sTracer;

    private FalcoGlobalTracer() {
    }

    public static FalcoTracer get() {
        return sTracer;
    }

    static void setTracerDelegate(FalcoTracer falcoTracer) {
        sTracer = falcoTracer;
    }
}
