package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.util.Map;
import tb.pp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CustomPageLifecycleDispatcher extends AbsDispatcher<CustomPageLifecycle> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface CustomPageLifecycle {
        void onPageAppear(pp1 pp1Var);

        void onPageCreate(pp1 pp1Var, Map<String, Object> map);

        void onPageDestroy(pp1 pp1Var);

        void onPageDisappear(pp1 pp1Var);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher$a */
    /* loaded from: classes11.dex */
    class C6777a implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ Map b;

        C6777a(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, pp1 pp1Var, Map map) {
            this.a = pp1Var;
            this.b = map;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageCreate(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher$b */
    /* loaded from: classes11.dex */
    class C6778b implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ pp1 a;

        C6778b(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, pp1 pp1Var) {
            this.a = pp1Var;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageAppear(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher$c */
    /* loaded from: classes11.dex */
    class C6779c implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ pp1 a;

        C6779c(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, pp1 pp1Var) {
            this.a = pp1Var;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageDisappear(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher$d */
    /* loaded from: classes11.dex */
    class C6780d implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ pp1 a;

        C6780d(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, pp1 pp1Var) {
            this.a = pp1Var;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageDestroy(this.a);
        }
    }

    public void f(pp1 pp1Var) {
        c(new C6778b(this, pp1Var));
    }

    public void g(pp1 pp1Var, Map<String, Object> map) {
        c(new C6777a(this, pp1Var, map));
    }

    public void h(pp1 pp1Var) {
        c(new C6780d(this, pp1Var));
    }

    public void i(pp1 pp1Var) {
        c(new C6779c(this, pp1Var));
    }
}
