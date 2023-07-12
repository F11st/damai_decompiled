package tb;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j73 {
    com.loc.eo a = null;
    long b = 0;
    long c = 0;
    private boolean d = true;
    int e = 0;
    long f = 0;
    AMapLocation g = null;
    long h = 0;

    private com.loc.eo e(com.loc.eo eoVar) {
        int i;
        if (com.loc.m1.r(eoVar)) {
            if (!this.d || !com.loc.i1.f(eoVar.getTime())) {
                i = this.e;
            } else if (eoVar.getLocationType() == 5 || eoVar.getLocationType() == 6) {
                i = 4;
            }
            eoVar.setLocationType(i);
        }
        return eoVar;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation)) {
            long B = com.loc.m1.B() - this.h;
            this.h = com.loc.m1.B();
            if (B > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                return aMapLocation;
            }
            AMapLocation aMapLocation2 = this.g;
            if (aMapLocation2 == null) {
                this.g = aMapLocation;
                return aMapLocation;
            } else if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.g.getProvider())) {
                this.g = aMapLocation;
                return aMapLocation;
            } else if (this.g.getAltitude() == aMapLocation.getAltitude() && this.g.getLongitude() == aMapLocation.getLongitude()) {
                this.g = aMapLocation;
                return aMapLocation;
            } else {
                long abs = Math.abs(aMapLocation.getTime() - this.g.getTime());
                if (30000 < abs) {
                    this.g = aMapLocation;
                    return aMapLocation;
                } else if (com.loc.m1.c(aMapLocation, this.g) > (((this.g.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.g.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                    return this.g;
                } else {
                    this.g = aMapLocation;
                    return aMapLocation;
                }
            }
        }
        return aMapLocation;
    }

    public final com.loc.eo b(com.loc.eo eoVar) {
        if (com.loc.m1.B() - this.f > 30000) {
            this.a = eoVar;
            this.f = com.loc.m1.B();
            return this.a;
        }
        this.f = com.loc.m1.B();
        if (!com.loc.m1.r(this.a) || !com.loc.m1.r(eoVar)) {
            this.b = com.loc.m1.B();
            this.a = eoVar;
            return eoVar;
        } else if (eoVar.getTime() != this.a.getTime() || eoVar.getAccuracy() >= 300.0f) {
            if (GeocodeSearch.GPS.equals(eoVar.getProvider())) {
                this.b = com.loc.m1.B();
                this.a = eoVar;
                return eoVar;
            } else if (eoVar.c() != this.a.c()) {
                this.b = com.loc.m1.B();
                this.a = eoVar;
                return eoVar;
            } else if (eoVar.getBuildingId() != null && !eoVar.getBuildingId().equals(this.a.getBuildingId()) && !TextUtils.isEmpty(eoVar.getBuildingId())) {
                this.b = com.loc.m1.B();
                this.a = eoVar;
                return eoVar;
            } else {
                this.e = eoVar.getLocationType();
                float c = com.loc.m1.c(eoVar, this.a);
                float accuracy = this.a.getAccuracy();
                float accuracy2 = eoVar.getAccuracy();
                float f = accuracy2 - accuracy;
                long B = com.loc.m1.B();
                long j = B - this.b;
                boolean z = true;
                boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                int i = (accuracy > 299.0f ? 1 : (accuracy == 299.0f ? 0 : -1));
                z = (i <= 0 || accuracy2 <= 299.0f) ? false : false;
                if (z2 || z) {
                    long j2 = this.c;
                    if (j2 == 0) {
                        this.c = B;
                    } else if (B - j2 > 30000) {
                        this.b = B;
                        this.a = eoVar;
                        this.c = 0L;
                        return eoVar;
                    }
                    com.loc.eo e = e(this.a);
                    this.a = e;
                    return e;
                } else if (accuracy2 < 100.0f && i > 0) {
                    this.b = B;
                    this.a = eoVar;
                    this.c = 0L;
                    return eoVar;
                } else {
                    if (accuracy2 <= 299.0f) {
                        this.c = 0L;
                    }
                    if (c >= 10.0f || c <= 0.1d || accuracy2 <= 5.0f) {
                        if (f < 300.0f) {
                            this.b = com.loc.m1.B();
                            this.a = eoVar;
                            return eoVar;
                        } else if (j >= 30000) {
                            this.b = com.loc.m1.B();
                            this.a = eoVar;
                            return eoVar;
                        } else {
                            com.loc.eo e2 = e(this.a);
                            this.a = e2;
                            return e2;
                        }
                    } else if (f >= -300.0f) {
                        com.loc.eo e3 = e(this.a);
                        this.a = e3;
                        return e3;
                    } else if (accuracy / accuracy2 >= 2.0f) {
                        this.b = B;
                        this.a = eoVar;
                        return eoVar;
                    } else {
                        com.loc.eo e4 = e(this.a);
                        this.a = e4;
                        return e4;
                    }
                }
            }
        } else {
            return eoVar;
        }
    }

    public final void c() {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.g = null;
        this.h = 0L;
    }

    public final void d(boolean z) {
        this.d = z;
    }
}
