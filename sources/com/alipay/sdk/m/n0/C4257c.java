package com.alipay.sdk.m.n0;

import android.content.Context;
import com.alipay.sdk.m.l0.C4239d;
import com.alipay.sdk.m.l0.C4243f;
import java.util.zip.Adler32;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.n0.c */
/* loaded from: classes12.dex */
public class C4257c {
    public static C4256b a;
    public static final Object b = new Object();

    public static long a(C4256b c4256b) {
        if (c4256b != null) {
            String format = String.format("%s%s%s%s%s", c4256b.c(), c4256b.d(), Long.valueOf(c4256b.a()), c4256b.e(), c4256b.b());
            if (C4243f.m215a(format)) {
                return 0L;
            }
            Adler32 adler32 = new Adler32();
            adler32.reset();
            adler32.update(format.getBytes());
            return adler32.getValue();
        }
        return 0L;
    }

    public static synchronized C4256b b(Context context) {
        synchronized (C4257c.class) {
            C4256b c4256b = a;
            if (c4256b != null) {
                return c4256b;
            }
            if (context != null) {
                C4256b a2 = a(context);
                a = a2;
                return a2;
            }
            return null;
        }
    }

    public static C4256b a(Context context) {
        if (context != null) {
            synchronized (b) {
                String b2 = C4258d.a(context).b();
                if (C4243f.m215a(b2)) {
                    return null;
                }
                if (b2.endsWith(StringUtils.LF)) {
                    b2 = b2.substring(0, b2.length() - 1);
                }
                C4256b c4256b = new C4256b();
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = C4239d.a(context);
                String b3 = C4239d.b(context);
                c4256b.c(a2);
                c4256b.a(a2);
                c4256b.b(currentTimeMillis);
                c4256b.b(b3);
                c4256b.d(b2);
                c4256b.a(a(c4256b));
                return c4256b;
            }
        }
        return null;
    }
}
