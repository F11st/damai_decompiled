package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kf {
    private static kf b;
    private kj c = null;
    private long d = 0;
    private long e = 0;
    long a = 0;

    private kf() {
    }

    public static synchronized kf a() {
        kf kfVar;
        synchronized (kf.class) {
            if (b == null) {
                b = new kf();
            }
            kfVar = b;
        }
        return kfVar;
    }

    public final kj a(kj kjVar) {
        int i;
        if (kc.b() - this.a > 30000) {
            this.c = kjVar;
            this.a = kc.b();
            return this.c;
        }
        this.a = kc.b();
        if (!kn.a(this.c) || !kn.a(kjVar)) {
            this.d = kc.b();
            this.c = kjVar;
            return kjVar;
        } else if (kjVar.getTime() != this.c.getTime() || kjVar.getAccuracy() >= 300.0f) {
            if (kjVar.getProvider().equalsIgnoreCase(GeocodeSearch.GPS)) {
                this.d = kc.b();
                this.c = kjVar;
                return kjVar;
            } else if (kjVar.c() != this.c.c()) {
                this.d = kc.b();
                this.c = kjVar;
                return kjVar;
            } else if (!kjVar.getBuildingId().equals(this.c.getBuildingId()) && !TextUtils.isEmpty(kjVar.getBuildingId())) {
                this.d = kc.b();
                this.c = kjVar;
                return kjVar;
            } else {
                float a = kc.a(new double[]{kjVar.getLatitude(), kjVar.getLongitude(), this.c.getLatitude(), this.c.getLongitude()});
                float accuracy = this.c.getAccuracy();
                float accuracy2 = kjVar.getAccuracy();
                float f = accuracy2 - accuracy;
                long b2 = kc.b();
                long j = b2 - this.d;
                if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
                    long j2 = this.e;
                    if (j2 == 0) {
                        this.e = b2;
                    } else if (b2 - j2 > 30000) {
                        this.d = b2;
                        this.c = kjVar;
                        this.e = 0L;
                        return kjVar;
                    }
                    return this.c;
                } else if (accuracy2 < 101.0f && i > 0) {
                    this.d = b2;
                    this.c = kjVar;
                    this.e = 0L;
                    return kjVar;
                } else {
                    if (accuracy2 <= 299.0f) {
                        this.e = 0L;
                    }
                    if (a < 10.0f && a > 0.1d && accuracy2 > 5.0f) {
                        if (f < -300.0f && accuracy / accuracy2 >= 2.0f) {
                            this.d = b2;
                            this.c = kjVar;
                            return kjVar;
                        }
                        return this.c;
                    } else if (f < 300.0f) {
                        this.d = kc.b();
                        this.c = kjVar;
                        return kjVar;
                    } else if (j >= 30000) {
                        this.d = kc.b();
                        this.c = kjVar;
                        return kjVar;
                    } else {
                        return this.c;
                    }
                }
            }
        } else {
            return kjVar;
        }
    }
}
