package tb;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class gd0 {
    private static final boolean a = false;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal();
        }
    }

    public static final boolean a() {
        return a;
    }
}
