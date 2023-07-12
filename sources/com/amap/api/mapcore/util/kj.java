package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kj extends Inner_3dMap_location {
    boolean a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private JSONObject g;
    private String h;
    private String i;
    private long j;
    private String k;

    public kj(String str) {
        super(str);
        this.b = null;
        this.c = "";
        this.e = "";
        this.f = "new";
        this.g = null;
        this.h = "";
        this.a = true;
        this.i = "";
        this.j = 0L;
        this.k = null;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int c() {
        return this.d;
    }

    public final void c(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            if (getProvider().equals(GeocodeSearch.GPS)) {
                this.d = 0;
                return;
            } else if (str.equals("0")) {
                this.d = 0;
                return;
            } else if (str.equals("1")) {
                i = 1;
                this.d = i;
            }
        }
        i = -1;
        this.d = i;
    }

    public final String d() {
        return this.e;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final JSONObject e() {
        return this.g;
    }

    public final void e(String str) {
        this.desc = str;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace(UTConstant.Args.UT_SUCCESS_F, "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                jy.a(th, "MapLocationModel", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final JSONObject toJson(int i) {
        try {
            JSONObject json = super.toJson(i);
            if (i == 1) {
                json.put("retype", this.e);
                json.put("cens", this.i);
                json.put("poiid", this.buildingId);
                json.put("floor", this.floor);
                json.put("coord", this.d);
                json.put("mcell", this.h);
                json.put(SocialConstants.PARAM_APP_DESC, this.desc);
                json.put(ILocatable.ADDRESS, getAddress());
                if (this.g != null && kc.a(json, "offpct")) {
                    json.put("offpct", this.g.getString("offpct"));
                }
            } else if (i != 2 && i != 3) {
                return json;
            }
            json.put("type", this.f);
            json.put("isReversegeo", this.a);
            return json;
        } catch (Throwable th) {
            jy.a(th, "MapLocationModel", "toStr");
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final String toStr(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = super.toJson(i);
            jSONObject.put("nb", this.k);
        } catch (Throwable th) {
            jy.a(th, "MapLocationModel", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
