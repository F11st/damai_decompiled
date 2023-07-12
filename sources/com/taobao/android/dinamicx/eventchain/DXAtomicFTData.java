package com.taobao.android.dinamicx.eventchain;

import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXAtomicFTData {
    public static final String FT_ACTION_FINISH = "finish";
    public static final String FT_ACTION_NONE = "none";
    public static final String FT_ACTION_START = "start";
    private String a;
    private String b;
    private String c;
    private JSONObject d;
    private boolean e;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface FTAction {
    }

    public DXAtomicFTData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.getString("scene");
        this.a = a(jSONObject.getString("action"));
        this.c = jSONObject.getString(TLogEventConst.PARAM_UPLOAD_STAGE);
        this.e = "true".equals(jSONObject.getString("forceParamsLog"));
        this.d = jSONObject;
    }

    private String a(String str) {
        if (str == null) {
            return "none";
        }
        String str2 = "finish";
        if (!str.equals("finish")) {
            str2 = "start";
            if (!str.equals("start")) {
                return "none";
            }
        }
        return str2;
    }

    public String b() {
        return this.a;
    }

    public JSONObject c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }
}
