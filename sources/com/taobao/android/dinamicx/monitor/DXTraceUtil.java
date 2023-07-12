package com.taobao.android.dinamicx.monitor;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXTraceUtil {
    public static final int TYPE_COMMON_INT = 1;
    public static final String TYPE_COMMON_STRING = "common";
    public static final int TYPE_EVENT_CHAIN_INT = 2;
    public static final String TYPE_EVENT_CHAIN_STRING = "eventChain";
    public static final int TYPE_EXPRESSION_INT = 3;
    public static final String TYPE_EXPRESSION_STRING = "expression";
    private static boolean a;
    private static final List<Integer> b = new ArrayList<Integer>() { // from class: com.taobao.android.dinamicx.monitor.DXTraceUtil.1
        {
            add(1);
            add(2);
            add(3);
        }
    };

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXTraceSupportType {
    }

    public static void a(int i, @NonNull String... strArr) {
        if (g(i) && Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(f(strArr));
        }
    }

    public static void b(@NonNull String... strArr) {
        a(1, strArr);
    }

    public static void c() {
        d(1);
    }

    public static void d(int i) {
        if (g(i) && Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean e() {
        return a;
    }

    private static String f(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static boolean g(int i) {
        return a && b.contains(Integer.valueOf(i));
    }
}
