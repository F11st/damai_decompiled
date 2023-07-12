package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.analysis.net.b */
/* loaded from: classes11.dex */
public class C7810b {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private int d;
    private double e;
    private double f;
    private double g;
    private double h;
    private String i;
    private String j;
    private int k;
    private List<Integer> l;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.analysis.net.b$a */
    /* loaded from: classes11.dex */
    private static class C7811a {
        private static final C7810b a = new C7810b();
    }

    private C7810b() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 1.0d;
        this.f = 2.0d;
        this.g = 2.0d;
        this.h = 1.0d;
        this.k = 0;
        this.l = new ArrayList();
    }

    private int a(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "923607165") ? ((Integer) ipChange.ipc$dispatch("923607165", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue() : i == 0 ? i2 : i2 == 0 ? i : Math.min(i, i2);
    }

    public static C7810b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1971820263") ? (C7810b) ipChange.ipc$dispatch("-1971820263", new Object[0]) : C7811a.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 943
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.analysis.net.C7810b.d():void");
    }

    public int b() {
        int a;
        IpChange ipChange = $ipChange;
        int i = 1;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-316328196")) {
            return ((Integer) ipChange.ipc$dispatch("-316328196", new Object[]{this})).intValue();
        }
        try {
            d();
            double d = this.f;
            double d2 = this.g;
            if (d > d2) {
                a = this.b;
            } else if (d < d2) {
                a = this.c;
            } else {
                a = a(this.b, this.c);
                if (this.f < 1.0d && this.g < 1.0d) {
                    a = 0;
                }
            }
            if (a(a(this.a, a), this.d) != 1) {
                if (a == 0) {
                    a = Math.max(this.a, this.d);
                }
                i = a;
            }
            try {
                double d3 = this.f;
                double d4 = this.g;
                this.e = 1.0d;
                this.f = 2.0d;
                this.g = 2.0d;
                this.h = 1.0d;
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(this.b);
                sb.append(this.c);
                sb.append(this.d);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("newNetScore:");
                sb3.append(i);
                sb3.append(",detailQuality:");
                sb3.append(sb2);
                sb3.append(",scoreWeight:");
                sb3.append(d3);
                sb3.append(JSMethod.NOT_SET);
                sb3.append(d4);
                sb3.append(this.j);
                this.l.add(Integer.valueOf(i));
                if (this.l.size() > 10) {
                    this.l.remove(0);
                }
                sb3.append(",scoreList:");
                for (Integer num : this.l) {
                    sb3.append(num.intValue());
                }
                String sb4 = sb3.toString();
                this.i = sb4;
                this.k = i;
                AdapterForTLog.loge("NewNetScore", sb4);
                return i;
            } catch (Exception e) {
                e = e;
                i2 = i;
                e.printStackTrace();
                return i2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-316298405") ? ((Integer) ipChange.ipc$dispatch("-316298405", new Object[]{this})).intValue() : this.k;
    }
}
