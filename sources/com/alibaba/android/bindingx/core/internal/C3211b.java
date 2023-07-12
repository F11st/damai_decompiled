package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.OrientationDetector;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.bb1;
import tb.jn1;
import tb.xg0;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.b */
/* loaded from: classes5.dex */
public class C3211b extends AbstractEventHandler implements OrientationDetector.OnOrientationChangedListener {
    private C3228p A;
    private C3228p B;
    private C3212a C;
    private boolean n;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private double t;
    private OrientationDetector u;
    private C3221k v;
    private C3221k w;
    private C3221k x;
    private String y;
    private LinkedList<Double> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.b$a */
    /* loaded from: classes5.dex */
    public static class C3212a {
        double a;
        double b;
        double c;

        C3212a(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }
    }

    public C3211b(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.n = false;
        this.z = new LinkedList<>();
        this.A = new C3228p(0.0d, 0.0d, 1.0d);
        this.B = new C3228p(0.0d, 1.0d, 1.0d);
        this.C = new C3212a(0.0d, 0.0d, 0.0d);
        if (context != null) {
            this.u = OrientationDetector.f(context);
        }
    }

    private boolean i(double d, double d2, double d3) {
        if (this.v != null && this.w != null) {
            this.z.add(Double.valueOf(d));
            if (this.z.size() > 5) {
                this.z.removeFirst();
            }
            l(this.z, 360);
            LinkedList<Double> linkedList = this.z;
            double doubleValue = (linkedList.get(linkedList.size() - 1).doubleValue() - this.o) % 360.0d;
            C3222l a = this.v.a(d, d2, d3, doubleValue);
            C3222l a2 = this.w.a(d, d2, d3, doubleValue);
            this.A.b(0.0d, 0.0d, 1.0d);
            this.A.a(a);
            this.B.b(0.0d, 1.0d, 1.0d);
            this.B.a(a2);
            double degrees = Math.toDegrees(Math.acos(this.A.a)) - 90.0d;
            double degrees2 = Math.toDegrees(Math.acos(this.B.b)) - 90.0d;
            if (Double.isNaN(degrees) || Double.isNaN(degrees2) || Double.isInfinite(degrees) || Double.isInfinite(degrees2)) {
                return false;
            }
            C3212a c3212a = this.C;
            c3212a.a = Math.round(degrees);
            c3212a.b = Math.round(degrees2);
        }
        return true;
    }

    private boolean j(double d, double d2, double d3) {
        if (this.x != null) {
            this.z.add(Double.valueOf(d));
            if (this.z.size() > 5) {
                this.z.removeFirst();
            }
            l(this.z, 360);
            LinkedList<Double> linkedList = this.z;
            C3222l a = this.x.a(d, d2, d3, (linkedList.get(linkedList.size() - 1).doubleValue() - this.o) % 360.0d);
            if (Double.isNaN(a.a) || Double.isNaN(a.b) || Double.isNaN(a.c) || Double.isInfinite(a.a) || Double.isInfinite(a.b) || Double.isInfinite(a.c)) {
                return false;
            }
            C3212a c3212a = this.C;
            c3212a.a = a.a;
            c3212a.b = a.b;
            c3212a.c = a.c;
        }
        return true;
    }

    private void k(String str, double d, double d2, double d3, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("alpha", Double.valueOf(d));
            hashMap.put("beta", Double.valueOf(d2));
            hashMap.put("gamma", Double.valueOf(d3));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            bb1.a(">>>>>>>>>>>fire event:(" + str + "," + d + "," + d2 + "," + d3 + jn1.BRACKET_END_STR);
        }
    }

    private void l(List<Double> list, int i) {
        int size = list.size();
        if (size > 1) {
            for (int i2 = 1; i2 < size; i2++) {
                int i3 = i2 - 1;
                if (list.get(i3) != null && list.get(i2) != null) {
                    if (list.get(i2).doubleValue() - list.get(i3).doubleValue() < (-i) / 2) {
                        double d = i;
                        list.set(i2, Double.valueOf(list.get(i2).doubleValue() + ((Math.floor(list.get(i3).doubleValue() / d) + 1.0d) * d)));
                    }
                    if (list.get(i2).doubleValue() - list.get(i3).doubleValue() > i / 2) {
                        list.set(i2, Double.valueOf(list.get(i2).doubleValue() - i));
                    }
                }
            }
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void e(@NonNull Map<String, Object> map) {
        k("exit", ((Double) map.get("alpha")).doubleValue(), ((Double) map.get("beta")).doubleValue(), ((Double) map.get("gamma")).doubleValue(), new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void f(String str, @NonNull Map<String, Object> map) {
        k("interceptor", ((Double) map.get("alpha")).doubleValue(), ((Double) map.get("beta")).doubleValue(), ((Double) map.get("gamma")).doubleValue(), Collections.singletonMap("interceptor", str));
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector != null) {
            orientationDetector.q();
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector != null) {
            orientationDetector.p(1);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable xg0 xg0Var, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        String str2;
        super.onBindExpression(str, map, xg0Var, list, javaScriptCallback);
        if (map != null) {
            String str3 = (String) map.get("sceneType");
            str2 = TextUtils.isEmpty(str3) ? "2d" : str3.toLowerCase();
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2) || (!"2d".equals(str2) && !"3d".equals(str2))) {
            str2 = "2d";
        }
        this.y = str2;
        bb1.a("[ExpressionOrientationHandler] sceneType is " + str2);
        if ("2d".equals(str2)) {
            this.v = new C3221k(null, Double.valueOf(90.0d), null);
            this.w = new C3221k(Double.valueOf(0.0d), null, Double.valueOf(90.0d));
        } else if ("3d".equals(str2)) {
            this.x = new C3221k(null, null, null);
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector == null) {
            return false;
        }
        orientationDetector.a(this);
        return this.u.p(1);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector != null) {
            orientationDetector.n(this);
            this.u.q();
        }
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        b();
        if (this.u == null) {
            return false;
        }
        k("end", this.r, this.s, this.t, new Object[0]);
        return this.u.n(this);
    }

    @Override // com.alibaba.android.bindingx.core.internal.OrientationDetector.OnOrientationChangedListener
    public void onOrientationChanged(double d, double d2, double d3) {
        double d4;
        char c;
        boolean j;
        double round = Math.round(d);
        double round2 = Math.round(d2);
        double round3 = Math.round(d3);
        if (round == this.r && round2 == this.s && round3 == this.t) {
            return;
        }
        if (this.n) {
            d4 = round3;
            c = 0;
        } else {
            this.n = true;
            c = 0;
            k("start", round, round2, round3, new Object[0]);
            this.o = round;
            this.p = round2;
            d4 = round3;
            this.q = d4;
        }
        if ("2d".equals(this.y)) {
            j = i(round, round2, d4);
        } else {
            j = "3d".equals(this.y) ? j(round, round2, d4) : false;
        }
        if (j) {
            C3212a c3212a = this.C;
            double d5 = c3212a.a;
            double d6 = c3212a.b;
            double d7 = c3212a.c;
            this.r = round;
            this.s = round2;
            this.t = d4;
            try {
                if (bb1.a) {
                    Locale locale = Locale.getDefault();
                    Object[] objArr = new Object[6];
                    objArr[c] = Double.valueOf(round);
                    objArr[1] = Double.valueOf(round2);
                    objArr[2] = Double.valueOf(d4);
                    objArr[3] = Double.valueOf(d5);
                    objArr[4] = Double.valueOf(d6);
                    objArr[5] = Double.valueOf(d7);
                    bb1.a(String.format(locale, "[OrientationHandler] orientation changed. (alpha:%f,beta:%f,gamma:%f,x:%f,y:%f,z:%f)", objArr));
                }
                JSMath.applyOrientationValuesToScope(this.d, round, round2, d4, this.o, this.p, this.q, d5, d6, d7);
                if (d(this.j, this.d)) {
                    return;
                }
                c(this.a, this.d, "orientation");
            } catch (Exception e) {
                bb1.c("runtime error", e);
            }
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }
}
