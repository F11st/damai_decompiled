package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.taobao.weex.common.Constants;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fx extends fv<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> h;
    private Handler i;
    private int j;
    private int k;
    private String l;

    public fx(Context context, Handler handler, List<TraceLocation> list, int i, String str, int i2, int i3) {
        super(context, list);
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.h = list;
        this.i = handler;
        this.k = i2;
        this.j = i3;
        this.l = str;
    }

    @Override // com.amap.api.mapcore.util.fv, com.amap.api.mapcore.util.fu
    protected String a() {
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        for (int i = 0; i < this.h.size(); i++) {
            TraceLocation traceLocation = this.h.get(i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.Name.X, traceLocation.getLongitude());
                jSONObject.put(Constants.Name.Y, traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put(U4WPKAdapter.KEY_TM, time / 1000);
                } else {
                    if (time != 0) {
                        long j2 = time - j;
                        if (j2 >= 1000) {
                            jSONObject.put(U4WPKAdapter.KEY_TM, j2 / 1000);
                        }
                    }
                    jSONObject.put(U4WPKAdapter.KEY_TM, 1);
                }
                j = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.g = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        String str = "key=" + gc.f(this.f);
        String a = gf.a();
        return "http://restapi.amap.com/v4/grasproad/driving?" + str + ("&ts=" + a) + ("&scode=" + gf.a(this.f, a, str));
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        new ArrayList();
        try {
            try {
                fz.a().a(this.l, this.j, e());
                fz.a().a(this.l).a(this.i);
            } catch (ft e) {
                fz.a().a(this.i, this.k, e.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fv, com.amap.api.mapcore.util.fu
    /* renamed from: a */
    public List<LatLng> b(String str) throws ft {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString(Constants.Name.Y)), Double.parseDouble(optJSONObject.optString(Constants.Name.X))));
            }
            return arrayList;
        }
        return arrayList;
    }
}
