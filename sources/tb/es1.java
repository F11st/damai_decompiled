package tb;

import android.content.Context;
import com.alibaba.analytics.utils.C3141a;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class es1 {
    public static String a(Context context) {
        String c = fs1.c(context);
        return yh2.f(c) ? c() : c;
    }

    public static String b(Context context) {
        String e = fs1.e(context);
        return yh2.f(e) ? c() : e;
    }

    public static final String c() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a = p31.a(currentTimeMillis);
        byte[] a2 = p31.a(nanoTime);
        byte[] a3 = p31.a(nextInt);
        byte[] a4 = p31.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a, 0, bArr, 0, 4);
        System.arraycopy(a2, 0, bArr, 4, 4);
        System.arraycopy(a3, 0, bArr, 8, 4);
        System.arraycopy(a4, 0, bArr, 12, 4);
        return C3141a.i(bArr);
    }
}
