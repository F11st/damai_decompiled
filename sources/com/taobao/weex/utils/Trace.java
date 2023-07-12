package com.taobao.weex.utils;

import android.annotation.TargetApi;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Trace {
    private static final AbstractTrace a = new TraceDummy();
    private static final boolean b = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static abstract class AbstractTrace {
        private AbstractTrace() {
        }

        abstract void a(String str);

        abstract void b();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class TraceDummy extends AbstractTrace {
        private TraceDummy() {
            super();
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void a(String str) {
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void b() {
        }
    }

    /* compiled from: Taobao */
    @TargetApi(18)
    /* loaded from: classes11.dex */
    private static final class TraceJBMR2 extends AbstractTrace {
        private TraceJBMR2() {
            super();
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void a(String str) {
            android.os.Trace.beginSection(str);
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void b() {
            android.os.Trace.endSection();
        }
    }

    public static void beginSection(String str) {
        Log.i("Weex_Trace", "beginSection() " + str);
        a.a(str);
    }

    public static void endSection() {
        a.b();
        Log.i("Weex_Trace", "endSection()");
    }

    public static final boolean getTraceEnabled() {
        return b;
    }
}
