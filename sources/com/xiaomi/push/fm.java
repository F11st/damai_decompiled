package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.fp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fm {
    private static final boolean a = Log.isLoggable("BCompressed", 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(fl flVar, byte[] bArr) {
        try {
            byte[] a2 = fp.C7655a.a(bArr);
            if (a) {
                AbstractC7535b.m587a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + flVar);
                if (flVar.f362a == 1) {
                    AbstractC7535b.m587a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e) {
            AbstractC7535b.m587a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
