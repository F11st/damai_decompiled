package com.taobao.monitor.impl.trace;

import androidx.fragment.app.Fragment;
import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FragmentLifecycleDispatcher extends AbsDispatcher<IFragmentLifeCycle> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IFragmentLifeCycle {
        void onFragmentActivityCreated(Fragment fragment, long j);

        void onFragmentAttached(Fragment fragment, long j);

        void onFragmentCreated(Fragment fragment, long j);

        void onFragmentDestroyed(Fragment fragment, long j);

        void onFragmentDetached(Fragment fragment, long j);

        void onFragmentPaused(Fragment fragment, long j);

        void onFragmentPreAttached(Fragment fragment, long j);

        void onFragmentPreCreated(Fragment fragment, long j);

        void onFragmentResumed(Fragment fragment, long j);

        void onFragmentSaveInstanceState(Fragment fragment, long j);

        void onFragmentStarted(Fragment fragment, long j);

        void onFragmentStopped(Fragment fragment, long j);

        void onFragmentViewCreated(Fragment fragment, long j);

        void onFragmentViewDestroyed(Fragment fragment, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        a(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentStopped(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        b(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentSaveInstanceState(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class c implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        c(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentViewDestroyed(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class d implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        d(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentDestroyed(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class e implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        e(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentDetached(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class f implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        f(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentPreAttached(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class g implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        g(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentAttached(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class h implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        h(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentPreCreated(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class i implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        i(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentCreated(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class j implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        j(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentActivityCreated(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class k implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        k(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentViewCreated(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class l implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        l(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentStarted(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class m implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        m(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentResumed(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class n implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        n(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentPaused(this.a, this.b);
        }
    }

    public void f(Fragment fragment, long j2) {
        c(new j(this, fragment, j2));
    }

    public void g(Fragment fragment, long j2) {
        c(new g(this, fragment, j2));
    }

    public void h(Fragment fragment, long j2) {
        c(new i(this, fragment, j2));
    }

    public void i(Fragment fragment, long j2) {
        c(new d(this, fragment, j2));
    }

    public void j(Fragment fragment, long j2) {
        c(new e(this, fragment, j2));
    }

    public void k(Fragment fragment, long j2) {
        c(new n(this, fragment, j2));
    }

    public void l(Fragment fragment, long j2) {
        c(new f(this, fragment, j2));
    }

    public void m(Fragment fragment, long j2) {
        c(new h(this, fragment, j2));
    }

    public void n(Fragment fragment, long j2) {
        c(new m(this, fragment, j2));
    }

    public void o(Fragment fragment, long j2) {
        c(new b(this, fragment, j2));
    }

    public void p(Fragment fragment, long j2) {
        c(new l(this, fragment, j2));
    }

    public void q(Fragment fragment, long j2) {
        c(new a(this, fragment, j2));
    }

    public void r(Fragment fragment, long j2) {
        c(new k(this, fragment, j2));
    }

    public void s(Fragment fragment, long j2) {
        c(new c(this, fragment, j2));
    }
}
