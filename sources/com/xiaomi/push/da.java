package com.xiaomi.push;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class da implements Comparable<da> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    private long f190a;

    /* renamed from: a  reason: collision with other field name */
    String f191a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cq> f192a;

    public da() {
        this(null, 0);
    }

    public da(String str) {
        this(str, 0);
    }

    public da(String str, int i) {
        this.f192a = new LinkedList<>();
        this.f190a = 0L;
        this.f191a = str;
        this.a = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(da daVar) {
        if (daVar == null) {
            return 1;
        }
        return daVar.a - this.a;
    }

    public synchronized da a(JSONObject jSONObject) {
        this.f190a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.a = jSONObject.getInt(IRequestConst.WT);
        this.f191a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f192a.add(new cq().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f190a);
        jSONObject.put(IRequestConst.WT, this.a);
        jSONObject.put("host", this.f191a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cq> it = this.f192a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m740a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cq cqVar) {
        if (cqVar != null) {
            this.f192a.add(cqVar);
            int a = cqVar.a();
            if (a > 0) {
                this.a += cqVar.a();
            } else {
                int i = 0;
                for (int size = this.f192a.size() - 1; size >= 0 && this.f192a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f192a.size() > 30) {
                this.a -= this.f192a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f191a + ":" + this.a;
    }
}
