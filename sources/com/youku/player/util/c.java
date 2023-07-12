package com.youku.player.util;

import android.annotation.TargetApi;
import android.os.Looper;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.player.util.b;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class c {
    public static String a = "PLAYER";
    public static int b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public static boolean g;

    static {
        a(a());
    }

    public static void a(String str) {
        if (d) {
            b.InterfaceC0398b b2 = b.a().b();
            String str2 = a;
            if (str == null) {
                str = "";
            }
            b2.a(str2, str);
        }
    }

    public static void a(String str, String str2) {
        if (d) {
            if (str.contains("PlayFlow")) {
                str2 = str2 + " --isMainthread:" + c();
            }
            b.InterfaceC0398b b2 = b.a().b();
            if (str2 == null) {
                str2 = "";
            }
            b2.a(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (d) {
            b.InterfaceC0398b b2 = b.a().b();
            if (str2 == null) {
                str2 = "";
            }
            b2.a(str, str2, th);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (d) {
            b.a().b().a(str, String.format(str2, objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (g) {
            b.InterfaceC0398b b2 = b.a().b();
            String str2 = a;
            if (str == null) {
                str = "";
            }
            b2.b(str2, str, th);
        }
    }

    public static void a(boolean z) {
        int i = z ? 5 : 1;
        b = i;
        c = i > 4;
        d = i > 3;
        e = i > 2;
        f = i > 1;
        g = i > 0;
    }

    public static boolean a() {
        return b() == 1;
    }

    private static int b() {
        return e.a(Logger.SYSTEM_PROP_KEY_LOG_LEVEL, 0);
    }

    public static void b(String str, String str2) {
        if (g) {
            if (str.contains("PlayFlow")) {
                str2 = str2 + " --isMainthread:" + c();
            }
            b.InterfaceC0398b b2 = b.a().b();
            if (str2 == null) {
                str2 = "";
            }
            b2.b(str, str2);
        }
    }

    @TargetApi(3)
    private static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
