package com.taobao.monitor.impl.trace;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.impl.trace.a */
/* loaded from: classes11.dex */
public class C6805a extends AbsDispatcher<FragmentFunctionListener> implements FragmentFunctionListener {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.a$a */
    /* loaded from: classes11.dex */
    class C6806a implements AbsDispatcher.ListenerCaller<FragmentFunctionListener> {
        final /* synthetic */ Activity a;
        final /* synthetic */ Fragment b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;

        C6806a(C6805a c6805a, Activity activity, Fragment fragment, String str, long j) {
            this.a = activity;
            this.b = fragment;
            this.c = str;
            this.d = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(FragmentFunctionListener fragmentFunctionListener) {
            fragmentFunctionListener.onFunction(this.a, this.b, this.c, this.d);
        }
    }

    @Override // com.taobao.monitor.impl.trace.FragmentFunctionListener
    public void onFunction(Activity activity, Fragment fragment, String str, long j) {
        c(new C6806a(this, activity, fragment, str, j));
    }
}
