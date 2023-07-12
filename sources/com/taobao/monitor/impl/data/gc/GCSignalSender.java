package com.taobao.monitor.impl.data.gc;

import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import tb.b0;
import tb.e30;
import tb.fu0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class GCSignalSender {
    private static InnerRunnable a = new InnerRunnable();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class InnerRunnable implements Runnable {
        private InnerRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fu0.e().d().removeCallbacks(GCSignalSender.a);
            IDispatcher a = b0.a(b0.APPLICATION_GC_DISPATCHER);
            if (a instanceof ApplicationGCDispatcher) {
                ((ApplicationGCDispatcher) a).f();
            }
            e30.a("gc", new Object[0]);
        }
    }
}
