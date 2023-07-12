package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    public ArrayList a;

    public a() {
        this.a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.a.add(Array.get(obj, i));
        }
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c;
        ArrayList arrayList;
        Object d;
        char c2 = cVar.c();
        if (c2 == '[') {
            c = jn1.ARRAY_END;
        } else if (c2 != '(') {
            throw cVar.a("A JSONArray text must start with '['");
        } else {
            c = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c3 = cVar.c();
            cVar.a();
            if (c3 == ',') {
                arrayList = this.a;
                d = null;
            } else {
                arrayList = this.a;
                d = cVar.d();
            }
            arrayList.add(d);
            char c4 = cVar.c();
            if (c4 != ')') {
                if (c4 != ',' && c4 != ';') {
                    if (c4 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c == c4) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c) + "'");
        } while (cVar.c() != ']');
    }

    private String a(String str) {
        int size = this.a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.a.size();
    }

    public final Object a(int i) {
        Object obj = (i < 0 || i >= this.a.size()) ? null : this.a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return jn1.ARRAY_START_STR + a(",") + jn1.ARRAY_END;
        } catch (Exception unused) {
            return null;
        }
    }
}
