package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ae {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f84a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f85a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = ah.f86a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f84a = str;
        boolean contains = str.contains("2A2FE0D7");
        f85a = contains;
        b = contains || "DEBUG".equalsIgnoreCase(str);
        c = "LOGABLE".equalsIgnoreCase(str);
        d = str.contains("YY");
        e = str.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(str);
        g = str.startsWith("RC");
        a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!str.equalsIgnoreCase("ONEBOX")) {
            a = 1;
            return;
        } else {
            i = 3;
        }
        a = i;
    }

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m661a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}
