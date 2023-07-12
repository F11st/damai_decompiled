package com.youku.opengl.a;

import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.a.a */
/* loaded from: classes13.dex */
public class C8013a {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    private static InterfaceC8014a f;

    /* compiled from: Taobao */
    /* renamed from: com.youku.opengl.a.a$a */
    /* loaded from: classes13.dex */
    public interface InterfaceC8014a {
        void a(String str, String str2, String str3);
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Log.d(str, str2);
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        InterfaceC8014a interfaceC8014a = f;
        if (interfaceC8014a != null) {
            interfaceC8014a.a("YkGLWidget", str, str2);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        Log.e(str, str2);
    }
}
