package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import tb.fw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopRequest {
    private Status a = Status.WAITTING;
    private final int b;
    private final String c;
    private View d;
    private View e;
    private a f;
    private Object g;
    private PopRequestStatusCallBack h;
    public WeakReference<View> i;
    public WeakReference<Activity> j;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface PopRequestStatusCallBack {
        void onForceRemoved(PopRequest popRequest);

        void onReady(PopRequest popRequest);

        void onRecovered(PopRequest popRequest);

        void onSuspended(PopRequest popRequest);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum Status {
        WAITTING,
        READY,
        REMOVED,
        SUSPENDED,
        SHOWING
    }

    public PopRequest(int i, String str, Activity activity, PopRequestStatusCallBack popRequestStatusCallBack, int i2, boolean z, boolean z2, boolean z3) {
        this.b = i;
        this.c = str;
        this.h = popRequestStatusCallBack;
        k(activity);
        p(new a(i2, z, z2, z3));
    }

    public Activity a() {
        return (Activity) fw2.c(this.j);
    }

    public int b() {
        return this.b;
    }

    public Object c() {
        return this.g;
    }

    public View d() {
        return this.e;
    }

    public View e() {
        return this.d;
    }

    public String f() {
        return this.c;
    }

    public View g() {
        return (View) fw2.c(this.i);
    }

    public a h() {
        return this.f;
    }

    public Status i() {
        return this.a;
    }

    public PopRequestStatusCallBack j() {
        return this.h;
    }

    public void k(Activity activity) {
        this.j = new WeakReference<>(activity);
    }

    public void l(Object obj) {
        this.g = obj;
    }

    public void m(View view) {
        this.e = view;
    }

    public void n(View view) {
        this.d = view;
    }

    public void o(View view) {
        this.i = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(a aVar) {
        this.f = aVar;
    }

    public void q(Status status) {
        this.a = status;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        public a(int i, boolean z, boolean z2, boolean z3) {
            this.a = i;
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        public a() {
        }
    }
}
