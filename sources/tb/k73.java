package tb;

import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.maps.model.MyLocationStyle;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class k73 {
    public int a = 0;
    public double b = 0.0d;
    public double c = 0.0d;
    public long d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 63;
    public int h = 0;

    public final String a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("time", this.d);
            jSONObject.put("lon", this.c);
            jSONObject.put("lat", this.b);
            jSONObject.put(BQCCameraParam.FOCUS_AREA_RADIUS, this.e);
            jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.a);
            jSONObject.put("reType", this.g);
            jSONObject.put("reSubType", this.h);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final void b(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optDouble("lat", this.b);
            this.c = jSONObject.optDouble("lon", this.c);
            this.a = jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, this.a);
            this.g = jSONObject.optInt("reType", this.g);
            this.h = jSONObject.optInt("reSubType", this.h);
            this.e = jSONObject.optInt(BQCCameraParam.FOCUS_AREA_RADIUS, this.e);
            this.d = jSONObject.optLong("time", this.d);
        } catch (Throwable th) {
            com.loc.j1.h(th, "CoreUtil", "transformLocation");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k73.class == obj.getClass()) {
            k73 k73Var = (k73) obj;
            if (this.a == k73Var.a && Double.compare(k73Var.b, this.b) == 0 && Double.compare(k73Var.c, this.c) == 0 && this.d == k73Var.d && this.e == k73Var.e && this.f == k73Var.f && this.g == k73Var.g && this.h == k73Var.h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h));
    }
}
