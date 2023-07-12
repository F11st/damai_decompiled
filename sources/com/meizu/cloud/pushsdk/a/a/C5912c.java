package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.a.a.c */
/* loaded from: classes10.dex */
public class C5912c {
    private final int a;
    private final String b;

    public C5912c(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.a);
            jSONObject.put("body", this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
