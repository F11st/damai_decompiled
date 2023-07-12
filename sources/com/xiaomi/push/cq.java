package com.xiaomi.push;

import com.alimm.xadsdk.request.builder.IRequestConst;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cq {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f170a;

    /* renamed from: a  reason: collision with other field name */
    private String f171a;
    private long b;
    private long c;

    public cq() {
        this(0, 0L, 0L, null);
    }

    public cq(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f170a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f171a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cq a(JSONObject jSONObject) {
        this.f170a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt(IRequestConst.WT);
        this.f171a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m740a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f170a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put(IRequestConst.WT, this.a);
        jSONObject.put("expt", this.f171a);
        return jSONObject;
    }
}
