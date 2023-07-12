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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$a */
    /* loaded from: classes11.dex */
    class C6781a implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6781a(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$b */
    /* loaded from: classes11.dex */
    class C6782b implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6782b(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$c */
    /* loaded from: classes11.dex */
    class C6783c implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6783c(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$d */
    /* loaded from: classes11.dex */
    class C6784d implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6784d(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$e */
    /* loaded from: classes11.dex */
    class C6785e implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6785e(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$f */
    /* loaded from: classes11.dex */
    class C6786f implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6786f(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$g */
    /* loaded from: classes11.dex */
    class C6787g implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6787g(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$h */
    /* loaded from: classes11.dex */
    class C6788h implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6788h(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$i */
    /* loaded from: classes11.dex */
    class C6789i implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6789i(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$j */
    /* loaded from: classes11.dex */
    class C6790j implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6790j(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$k */
    /* loaded from: classes11.dex */
    class C6791k implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6791k(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$l */
    /* loaded from: classes11.dex */
    class C6792l implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6792l(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$m */
    /* loaded from: classes11.dex */
    class C6793m implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6793m(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher$n */
    /* loaded from: classes11.dex */
    class C6794n implements AbsDispatcher.ListenerCaller<IFragmentLifeCycle> {
        final /* synthetic */ Fragment a;
        final /* synthetic */ long b;

        C6794n(FragmentLifecycleDispatcher fragmentLifecycleDispatcher, Fragment fragment, long j) {
            this.a = fragment;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IFragmentLifeCycle iFragmentLifeCycle) {
            iFragmentLifeCycle.onFragmentPaused(this.a, this.b);
        }
    }

    public void f(Fragment fragment, long j) {
        c(new C6790j(this, fragment, j));
    }

    public void g(Fragment fragment, long j) {
        c(new C6787g(this, fragment, j));
    }

    public void h(Fragment fragment, long j) {
        c(new C6789i(this, fragment, j));
    }

    public void i(Fragment fragment, long j) {
        c(new C6784d(this, fragment, j));
    }

    public void j(Fragment fragment, long j) {
        c(new C6785e(this, fragment, j));
    }

    public void k(Fragment fragment, long j) {
        c(new C6794n(this, fragment, j));
    }

    public void l(Fragment fragment, long j) {
        c(new C6786f(this, fragment, j));
    }

    public void m(Fragment fragment, long j) {
        c(new C6788h(this, fragment, j));
    }

    public void n(Fragment fragment, long j) {
        c(new C6793m(this, fragment, j));
    }

    public void o(Fragment fragment, long j) {
        c(new C6782b(this, fragment, j));
    }

    public void p(Fragment fragment, long j) {
        c(new C6792l(this, fragment, j));
    }

    public void q(Fragment fragment, long j) {
        c(new C6781a(this, fragment, j));
    }

    public void r(Fragment fragment, long j) {
        c(new C6791k(this, fragment, j));
    }

    public void s(Fragment fragment, long j) {
        c(new C6783c(this, fragment, j));
    }
}
