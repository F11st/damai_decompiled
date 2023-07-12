package com.taobao.mtop.wvplugin;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.taobao.mtop.wvplugin.b */
/* loaded from: classes11.dex */
public class C6824b {
    private WVCallBackContext a;
    private boolean b;
    private JSONObject c;
    private String d;

    public C6824b() {
        this.a = null;
        this.b = false;
        this.c = new JSONObject();
        this.d = null;
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            this.c.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void b(String str, JSONArray jSONArray) {
        if (str == null || jSONArray == null) {
            return;
        }
        try {
            this.c.put(str, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public WVCallBackContext c() {
        return this.a;
    }

    public boolean d() {
        return this.b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.c = jSONObject;
        }
    }

    public void f(WVCallBackContext wVCallBackContext) {
        this.a = wVCallBackContext;
    }

    public void g(boolean z) {
        this.b = z;
    }

    public String toString() {
        String str = this.d;
        return str != null ? str : this.c.toString();
    }

    public C6824b(WVCallBackContext wVCallBackContext) {
        this.a = null;
        this.b = false;
        this.c = new JSONObject();
        this.d = null;
        this.a = wVCallBackContext;
    }
}
