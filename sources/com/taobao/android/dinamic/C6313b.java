package com.taobao.android.dinamic;

import android.content.Context;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import java.util.HashMap;
import java.util.Map;
import tb.ah1;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.b */
/* loaded from: classes12.dex */
public final class C6313b {
    public static final String TAG = "Dinamic";
    private static boolean a;
    private static Map<String, ah1> b = new HashMap();
    private static Context c;

    public static Context a() {
        return c;
    }

    public static DinamicEventHandler b(String str) {
        return DinamicViewHelper.getEventHandler(str);
    }

    public static ah1 c(String str) {
        if (b.containsKey(str)) {
            return b.get(str);
        }
        ah1 a2 = ah1.a(str);
        b.put(str, a2);
        return a2;
    }

    public static DinamicViewAdvancedConstructor d(String str) {
        return DinamicViewHelper.getViewConstructor(str);
    }

    public static boolean e() {
        return a;
    }

    public static void f(Context context) {
        c = context;
    }
}
