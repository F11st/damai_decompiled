package com.taobao.android.dinamic;

import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tb.a90;
import tb.f90;
import tb.s80;
import tb.v80;
import tb.x80;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.c */
/* loaded from: classes12.dex */
public final class C6314c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, v80 v80Var) {
        x80 c = f90.c(view);
        Map<String, String> map = c.c;
        Map<String, String> map2 = c.d;
        DinamicViewAdvancedConstructor d = C6313b.d(c.a);
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList<String> arrayList = new ArrayList<>(10);
            for (String str : map.keySet()) {
                Object a = s80.a(map.get(str), c.a, v80Var);
                hashMap.put(str, a);
                if (a == null && C6313b.e()) {
                    DinamicLog.e(C6313b.TAG, String.format("表达式 %s=%s 解析出来的结果为null", str, map.get(str)));
                }
            }
            arrayList.addAll(hashMap.keySet());
            hashMap.putAll(c.b);
            d.bindDataImpl(view, hashMap, arrayList, v80Var);
        }
        if (map2.isEmpty()) {
            return;
        }
        view.setTag(a90.SUBDATA, v80Var.a());
        d.setEvents(view, v80Var);
    }
}
