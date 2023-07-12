package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cs {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cr> f176a = new ArrayList<>();

    public cs() {
    }

    public cs(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized cr a() {
        for (int size = this.f176a.size() - 1; size >= 0; size--) {
            cr crVar = this.f176a.get(size);
            if (crVar.m744a()) {
                cv.a().m754a(crVar.a());
                return crVar;
            }
        }
        return null;
    }

    public synchronized cs a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f176a.add(new cr(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m745a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cr> m746a() {
        return this.f176a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m747a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cr> it = this.f176a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m742a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cr crVar) {
        int i = 0;
        while (true) {
            if (i >= this.f176a.size()) {
                break;
            } else if (this.f176a.get(i).a(crVar)) {
                this.f176a.set(i, crVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f176a.size()) {
            this.f176a.add(crVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<cr> arrayList;
        for (int size = this.f176a.size() - 1; size >= 0; size--) {
            cr crVar = this.f176a.get(size);
            if (z) {
                if (crVar.c()) {
                    arrayList = this.f176a;
                    arrayList.remove(size);
                }
            } else if (!crVar.b()) {
                arrayList = this.f176a;
                arrayList.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(StringUtils.LF);
        Iterator<cr> it = this.f176a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
