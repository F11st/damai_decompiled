package com.taobao.monitor.impl.trace;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.taobao.monitor.impl.trace.AbsDispatcher;
import tb.e30;
import tb.fu0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplicationLowMemoryDispatcher extends AbsDispatcher<LowMemoryListener> implements ComponentCallbacks {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface LowMemoryListener {
        void onLowMemory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher$a */
    /* loaded from: classes11.dex */
    public class C6776a implements AbsDispatcher.ListenerCaller<LowMemoryListener> {
        C6776a(ApplicationLowMemoryDispatcher applicationLowMemoryDispatcher) {
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(LowMemoryListener lowMemoryListener) {
            lowMemoryListener.onLowMemory();
        }
    }

    public ApplicationLowMemoryDispatcher() {
        fu0.e().a().registerComponentCallbacks(this);
    }

    public void f() {
        c(new C6776a(this));
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        e30.a("ApplicationLowMemory", "onLowMemory");
        f();
    }
}
