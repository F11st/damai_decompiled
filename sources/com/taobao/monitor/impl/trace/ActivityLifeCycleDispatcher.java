package com.taobao.monitor.impl.trace;

import android.app.Activity;
import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ActivityLifeCycleDispatcher extends AbsDispatcher<IActivityLifeCycle> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IActivityLifeCycle {
        void onActivityCreated(Activity activity, Map<String, Object> map, long j);

        void onActivityDestroyed(Activity activity, long j);

        void onActivityPaused(Activity activity, long j);

        void onActivityResumed(Activity activity, long j);

        void onActivityStarted(Activity activity, long j);

        void onActivityStopped(Activity activity, long j);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher$a */
    /* loaded from: classes11.dex */
    class C6768a implements AbsDispatcher.ListenerCaller<IActivityLifeCycle> {
        final /* synthetic */ Activity a;
        final /* synthetic */ Map b;
        final /* synthetic */ long c;

        C6768a(ActivityLifeCycleDispatcher activityLifeCycleDispatcher, Activity activity, Map map, long j) {
            this.a = activity;
            this.b = map;
            this.c = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IActivityLifeCycle iActivityLifeCycle) {
            iActivityLifeCycle.onActivityCreated(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher$b */
    /* loaded from: classes11.dex */
    class C6769b implements AbsDispatcher.ListenerCaller<IActivityLifeCycle> {
        final /* synthetic */ Activity a;
        final /* synthetic */ long b;

        C6769b(ActivityLifeCycleDispatcher activityLifeCycleDispatcher, Activity activity, long j) {
            this.a = activity;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IActivityLifeCycle iActivityLifeCycle) {
            iActivityLifeCycle.onActivityStarted(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher$c */
    /* loaded from: classes11.dex */
    class C6770c implements AbsDispatcher.ListenerCaller<IActivityLifeCycle> {
        final /* synthetic */ Activity a;
        final /* synthetic */ long b;

        C6770c(ActivityLifeCycleDispatcher activityLifeCycleDispatcher, Activity activity, long j) {
            this.a = activity;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IActivityLifeCycle iActivityLifeCycle) {
            iActivityLifeCycle.onActivityResumed(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher$d */
    /* loaded from: classes11.dex */
    class C6771d implements AbsDispatcher.ListenerCaller<IActivityLifeCycle> {
        final /* synthetic */ Activity a;
        final /* synthetic */ long b;

        C6771d(ActivityLifeCycleDispatcher activityLifeCycleDispatcher, Activity activity, long j) {
            this.a = activity;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IActivityLifeCycle iActivityLifeCycle) {
            iActivityLifeCycle.onActivityPaused(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher$e */
    /* loaded from: classes11.dex */
    class C6772e implements AbsDispatcher.ListenerCaller<IActivityLifeCycle> {
        final /* synthetic */ Activity a;
        final /* synthetic */ long b;

        C6772e(ActivityLifeCycleDispatcher activityLifeCycleDispatcher, Activity activity, long j) {
            this.a = activity;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IActivityLifeCycle iActivityLifeCycle) {
            iActivityLifeCycle.onActivityStopped(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher$f */
    /* loaded from: classes11.dex */
    class C6773f implements AbsDispatcher.ListenerCaller<IActivityLifeCycle> {
        final /* synthetic */ Activity a;
        final /* synthetic */ long b;

        C6773f(ActivityLifeCycleDispatcher activityLifeCycleDispatcher, Activity activity, long j) {
            this.a = activity;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IActivityLifeCycle iActivityLifeCycle) {
            iActivityLifeCycle.onActivityDestroyed(this.a, this.b);
        }
    }

    public void f(Activity activity, Map<String, Object> map, long j) {
        c(new C6768a(this, activity, map, j));
    }

    public void g(Activity activity, long j) {
        c(new C6773f(this, activity, j));
    }

    public void h(Activity activity, long j) {
        c(new C6771d(this, activity, j));
    }

    public void i(Activity activity, long j) {
        c(new C6770c(this, activity, j));
    }

    public void j(Activity activity, long j) {
        c(new C6769b(this, activity, j));
    }

    public void k(Activity activity, long j) {
        c(new C6772e(this, activity, j));
    }
}
