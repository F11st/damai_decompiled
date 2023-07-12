package com.taobao.android.riverlogger;

import org.json.JSONException;
import org.json.JSONStringer;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class c {
    public RVLLevel a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String i;
    private String k;
    public long h = System.currentTimeMillis();
    public boolean j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RVLLevel rVLLevel, String str) {
        this.a = rVLLevel;
        this.b = str;
    }

    public String a() {
        if (this.k == null) {
            if (this.j) {
                try {
                    JSONStringer object = new JSONStringer().object();
                    if (this.e != null) {
                        object.key("event").value(this.e);
                    }
                    if (this.c != null) {
                        object.key("id").value(this.c);
                    }
                    if (this.d != null) {
                        object.key("parentId").value(this.d);
                    }
                    object.key("time").value(this.h);
                    if (this.f != null) {
                        object.key("errorCode").value(this.f);
                    }
                    if (this.g != null) {
                        object.key("errorMsg").value(this.g);
                    }
                    if (this.i == null) {
                        object.endObject();
                        this.k = object.toString();
                    } else {
                        this.k = object.toString() + ",\"ext\":" + this.i + "}";
                    }
                } catch (JSONException unused) {
                }
            } else {
                this.k = this.i;
            }
        }
        return this.k;
    }
}
