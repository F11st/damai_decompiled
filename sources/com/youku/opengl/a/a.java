package com.youku.opengl.a;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    private static InterfaceC0397a f;

    /* compiled from: Taobao */
    /* renamed from: com.youku.opengl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0397a {
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
        InterfaceC0397a interfaceC0397a = f;
        if (interfaceC0397a != null) {
            interfaceC0397a.a("YkGLWidget", str, str2);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        Log.e(str, str2);
    }
}
