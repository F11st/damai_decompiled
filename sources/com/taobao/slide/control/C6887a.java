package com.taobao.slide.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.da1;
import tb.m42;

/* compiled from: Taobao */
/* renamed from: com.taobao.slide.control.a */
/* loaded from: classes11.dex */
public class C6887a {
    private static Map<String, da1> c = new ConcurrentHashMap();
    private List<UnitParse> a = new ArrayList();
    public boolean b;

    private C6887a(String str) {
        this.b = false;
        try {
            for (String str2 : str.split("&")) {
                this.a.add(UnitParse.a(str2));
            }
        } catch (Throwable th) {
            this.b = true;
            m42.d("ExpParse", "ExpParse", th, new Object[0]);
        }
    }

    public static void a(da1... da1VarArr) {
        if (da1VarArr == null) {
            return;
        }
        for (da1 da1Var : da1VarArr) {
            m42.c("ExpParse", "addProperty", "prop", da1Var);
            if (c.put(da1Var.b(), da1Var) != null) {
                m42.i("ExpParse", "addProperty", "replace prop", da1Var);
            }
        }
    }

    public static C6887a b(String str) {
        return new C6887a(str);
    }

    public static List<da1> c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, da1> entry : c.entrySet()) {
            if (!entry.getValue().d()) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public static String d(String str) {
        da1 da1Var = c.get(str);
        if (da1Var == null) {
            m42.c("ExpParse", "getProperty null", "key", str);
            return null;
        }
        return da1Var.c();
    }

    public boolean e() {
        if (this.b) {
            m42.e("ExpParse", "match error", new Object[0]);
            return false;
        }
        try {
            for (UnitParse unitParse : this.a) {
                if (!unitParse.b(c.get(unitParse.a))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            m42.j("ExpParse", "match", th, new Object[0]);
            return false;
        }
    }
}
