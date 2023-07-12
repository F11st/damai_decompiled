package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.gd;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class by<T, V> {
    protected T a;
    protected int b = 3;
    protected Context c;

    public by(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.c = context;
        this.a = t;
    }

    protected abstract String a();

    protected abstract JSONObject a(gd.a aVar);

    protected abstract V b(JSONObject jSONObject) throws AMapException;

    protected abstract Map<String, String> b();

    public V c() throws AMapException {
        if (this.a != null) {
            return d();
        }
        return null;
    }

    protected V d() throws AMapException {
        int i;
        String str;
        AMapException aMapException;
        int i2 = 0;
        V v = null;
        gd.a aVar = null;
        while (i2 < this.b) {
            try {
                aVar = gd.a(this.c, eq.e(), a(), b());
                v = b(a(aVar));
                i2 = this.b;
            } finally {
                if (i2 < i) {
                    continue;
                }
            }
        }
        return v;
    }
}
