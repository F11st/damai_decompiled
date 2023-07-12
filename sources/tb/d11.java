package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d11 {
    private static int a;

    public static synchronized int a() {
        int i;
        synchronized (d11.class) {
            if (a >= Integer.MAX_VALUE) {
                a = 0;
            }
            i = a;
            a = i + 1;
        }
        return i;
    }
}
