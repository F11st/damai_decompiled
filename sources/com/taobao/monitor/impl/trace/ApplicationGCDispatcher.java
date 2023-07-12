package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplicationGCDispatcher extends AbsDispatcher<ApplicationGCListener> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ApplicationGCListener {
        void gc();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements AbsDispatcher.ListenerCaller<ApplicationGCListener> {
        a(ApplicationGCDispatcher applicationGCDispatcher) {
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(ApplicationGCListener applicationGCListener) {
            applicationGCListener.gc();
        }
    }

    public void f() {
        c(new a(this));
    }
}
