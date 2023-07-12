package com.taobao.android.dinamicx.widget.recycler.expose;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import tb.pz1;
import tb.r00;
import tb.vg0;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.recycler.expose.a */
/* loaded from: classes11.dex */
class C6511a implements ExposureLifecycle<Integer, WeakReference<View>> {
    private final C6514c a;
    private final IExposureEngine<Integer, WeakReference<View>> b;
    private final HashSet<String> c = new HashSet<>();
    private final RecyclerView d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.expose.a$a */
    /* loaded from: classes11.dex */
    class C6512a extends r00 {
        C6512a(IDXVideoController iDXVideoController) {
            super(iDXVideoController);
        }

        @Override // tb.r00, com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
        public void onScrollExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i, int i2) {
            C6511a.this.b();
        }

        @Override // tb.r00, com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
        public void onScrollStateChangeExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i) {
        }
    }

    public C6511a(RecyclerView recyclerView, C6514c c6514c) {
        this.a = c6514c;
        this.d = recyclerView;
        pz1.C9584b c9584b = new pz1.C9584b(recyclerView, new C6512a(null));
        long e = c6514c.e();
        c9584b.d(this, e, "recyclerLayoutExpose" + recyclerView.hashCode());
        this.b = c9584b.a();
    }

    public void a() {
        this.c.clear();
    }

    public void b() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine == null) {
            return;
        }
        iExposureEngine.exposeCache();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnAfterCancelDataExposeListener
    /* renamed from: c */
    public void onAfterCancelDataExpose(Integer num, WeakReference<View> weakReference, String str) {
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnBeforeDataExposeListener
    /* renamed from: d */
    public boolean onBeforeExposeData(Integer num, WeakReference<View> weakReference, String str) {
        C6514c c6514c = this.a;
        if (c6514c == null || c6514c.h() == null) {
            return false;
        }
        return this.a.h().filter(num.intValue());
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnDataExposeListener
    /* renamed from: e */
    public void onDataExpose(Integer num, WeakReference<View> weakReference, String str) {
        C6514c c6514c = this.a;
        if (c6514c == null || c6514c.g() == null) {
            return;
        }
        this.a.g().expose(num.intValue());
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnValidateExposeDataListener
    /* renamed from: f */
    public boolean onValidateExposeData(Integer num, WeakReference<View> weakReference, String str, Map<Integer, WeakReference<View>> map) {
        View findViewByPosition;
        C6514c c6514c = this.a;
        if (c6514c == null || c6514c.f() == null || this.c.contains(String.valueOf(num)) || (findViewByPosition = this.d.getLayoutManager().findViewByPosition(num.intValue())) == null || this.a.j() == null) {
            return false;
        }
        boolean b = vg0.b(findViewByPosition, this.a.j().visiblePercent());
        if (b) {
            this.c.add(String.valueOf(num));
        }
        return b;
    }

    public void g() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine == null) {
            return;
        }
        iExposureEngine.runZone();
    }

    public void h() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine == null) {
            return;
        }
        iExposureEngine.stopZone();
    }

    public void i() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine == null) {
            return;
        }
        iExposureEngine.exposeCache();
        this.b.triggerExpose();
    }
}
