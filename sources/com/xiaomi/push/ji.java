package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ji {
    private static int a = Integer.MAX_VALUE;

    public static void a(jf jfVar, byte b) {
        a(jfVar, b, a);
    }

    public static void a(jf jfVar, byte b, int i) {
        if (i <= 0) {
            throw new iz("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                jfVar.mo1112a();
                return;
            case 3:
                jfVar.a();
                return;
            case 4:
                jfVar.mo1099a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jfVar.mo1109a();
                return;
            case 8:
                jfVar.mo1100a();
                return;
            case 10:
                jfVar.mo1101a();
                return;
            case 11:
                jfVar.mo1108a();
                return;
            case 12:
                jfVar.mo1106a();
                while (true) {
                    byte b2 = jfVar.mo1102a().a;
                    if (b2 == 0) {
                        jfVar.f();
                        return;
                    } else {
                        a(jfVar, b2, i - 1);
                        jfVar.g();
                    }
                }
            case 13:
                je mo1104a = jfVar.mo1104a();
                while (i2 < mo1104a.f803a) {
                    int i3 = i - 1;
                    a(jfVar, mo1104a.a, i3);
                    a(jfVar, mo1104a.b, i3);
                    i2++;
                }
                jfVar.h();
                return;
            case 14:
                jj mo1105a = jfVar.mo1105a();
                while (i2 < mo1105a.f804a) {
                    a(jfVar, mo1105a.a, i - 1);
                    i2++;
                }
                jfVar.j();
                return;
            case 15:
                jd mo1103a = jfVar.mo1103a();
                while (i2 < mo1103a.f802a) {
                    a(jfVar, mo1103a.a, i - 1);
                    i2++;
                }
                jfVar.i();
                return;
        }
    }
}
