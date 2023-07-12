package com.taobao.monitor.impl.data.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.taobao.monitor.impl.trace.C6805a;
import com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.procedure.IPage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.C8934b0;
import tb.ca0;
import tb.e30;
import tb.ho2;
import tb.m3;
import tb.mp0;
import tb.pp1;
import tb.rp1;
import tb.uu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FragmentLifecycle extends FragmentManager.FragmentLifecycleCallbacks {
    private static final Map<WeakReference<Fragment>, Long> f = new ConcurrentHashMap();
    private final Map<Fragment, IPage> a = new HashMap();
    private FragmentLifecycleDispatcher b;
    private C6805a c;
    private final Activity d;
    private final String e;

    public FragmentLifecycle(Activity activity, String str) {
        this.d = activity;
        this.e = str;
        IDispatcher a = C8934b0.a(C8934b0.FRAGMENT_LIFECYCLE_DISPATCHER);
        if (a instanceof FragmentLifecycleDispatcher) {
            this.b = (FragmentLifecycleDispatcher) a;
        }
        IDispatcher a2 = C8934b0.a(C8934b0.FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER);
        if (a2 instanceof C6805a) {
            this.c = (C6805a) a2;
        }
    }

    public static long a(Fragment fragment) {
        Fragment fragment2;
        for (Map.Entry<WeakReference<Fragment>, Long> entry : f.entrySet()) {
            if (entry.getKey() != null && (fragment2 = entry.getKey().get()) != null && fragment2 == fragment) {
                return entry.getValue().longValue();
            }
        }
        return -1L;
    }

    private Map<String, Object> b(Activity activity, Fragment fragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("schemaUrl", m3.c(activity));
        hashMap.put("activityName", m3.d(activity));
        hashMap.put("fullPageName", mp0.a(fragment));
        return hashMap;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentActivityCreated", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentActivityCreated", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.f(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentAttached", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentAttached", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.g(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentCreated", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentCreated", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.h(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentDestroyed", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentDestroyed", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.i(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        IPage iPage = this.a.get(fragment);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageDestroy();
            uu1.PROCEDURE_MANAGER.p(iPage);
            this.a.remove(fragment);
        }
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentDetached", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentDetached", fragment.getClass().getSimpleName());
        if (!ca0.c(this.b)) {
            this.b.j(fragment, ho2.a());
        }
        Iterator<Map.Entry<WeakReference<Fragment>, Long>> it = f.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<WeakReference<Fragment>, Long> next = it.next();
            if (next.getKey() == null || next.getKey().get() == null || next.getKey().get() == fragment) {
                it.remove();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentPaused", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentPaused", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.k(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentPreAttached(fragmentManager, fragment, context);
        e30.a("FragmentLifecycle", "onFragmentPreAttached", fragment.getClass().getSimpleName());
        IPage a = new rp1().c(fragment).j(this.d.getWindow()).d(this.e).a();
        this.a.put(fragment, a);
        a.getPageLifecycleCallback().onPageCreate(mp0.b(fragment), m3.c(this.d), b(this.d, fragment));
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentPreAttached", ho2.a());
        }
        if (!ca0.c(this.b)) {
            this.b.l(fragment, ho2.a());
        }
        f.put(new WeakReference<>(fragment), Long.valueOf(ho2.a()));
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentPreCreated(fragmentManager, fragment, bundle);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentPreCreated", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentPreCreated", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.m(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        IPage iPage = this.a.get(fragment);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageAppear();
        }
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentResumed", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentResumed", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.n(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentSaveInstanceState", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentSaveInstanceState", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.o(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentStarted", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentStarted", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.p(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        IPage iPage = this.a.get(fragment);
        if (iPage instanceof pp1) {
            iPage.getPageLifecycleCallback().onPageDisappear();
        }
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentStopped", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentStopped", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.q(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentViewCreated", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentViewCreated", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.r(fragment, ho2.a());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentViewDestroyed(fragmentManager, fragment);
        if (!ca0.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentViewDestroyed", ho2.a());
        }
        e30.a("FragmentLifecycle", "onFragmentViewDestroyed", fragment.getClass().getSimpleName());
        if (ca0.c(this.b)) {
            return;
        }
        this.b.s(fragment, ho2.a());
    }
}
