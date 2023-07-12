package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.cp0;
import tb.hd1;
import tb.jc1;
import tb.kb1;
import tb.xo0;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.a */
/* loaded from: classes17.dex */
public class C2821a {
    private Map<String, List<Layer>> c;
    private Map<String, jc1> d;
    private Map<String, xo0> e;
    private List<hd1> f;
    private SparseArrayCompat<cp0> g;
    private LongSparseArray<Layer> h;
    private List<Layer> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private final PerformanceTracker a = new PerformanceTracker();
    private final HashSet<String> b = new HashSet<>();
    private int o = 0;

    /* compiled from: Taobao */
    @Deprecated
    /* renamed from: com.airbnb.lottie.a$b */
    /* loaded from: classes17.dex */
    public static class C2823b {

        /* compiled from: Taobao */
        /* renamed from: com.airbnb.lottie.a$b$a */
        /* loaded from: classes9.dex */
        private static final class C2824a implements LottieListener<C2821a>, Cancellable {
            private final OnCompositionLoadedListener a;
            private boolean b;

            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: a */
            public void onResult(C2821a c2821a) {
                if (this.b) {
                    return;
                }
                this.a.onCompositionLoaded(c2821a);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.b = true;
            }

            private C2824a(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.b = false;
                this.a = onCompositionLoadedListener;
            }
        }

        @Deprecated
        public static Cancellable a(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            C2824a c2824a = new C2824a(onCompositionLoadedListener);
            C2861b.d(context, str).f(c2824a);
            return c2824a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        kb1.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public SparseArrayCompat<cp0> c() {
        return this.g;
    }

    public float d() {
        return (e() / this.m) * 1000.0f;
    }

    public float e() {
        return this.l - this.k;
    }

    public float f() {
        return this.l;
    }

    public Map<String, xo0> g() {
        return this.e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, jc1> i() {
        return this.d;
    }

    public List<Layer> j() {
        return this.i;
    }

    @Nullable
    public hd1 k(String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            hd1 hd1Var = this.f.get(i);
            if (hd1Var.a(str)) {
                return hd1Var;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int l() {
        return this.o;
    }

    public PerformanceTracker m() {
        return this.a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> n(String str) {
        return this.c.get(str);
    }

    public float o() {
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean p() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void q(int i) {
        this.o += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, jc1> map2, SparseArrayCompat<cp0> sparseArrayCompat, Map<String, xo0> map3, List<hd1> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = longSparseArray;
        this.c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer s(long j) {
        return this.h.get(j);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.i) {
            sb.append(layer.w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
