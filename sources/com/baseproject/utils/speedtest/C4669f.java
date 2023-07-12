package com.baseproject.utils.speedtest;

import com.youku.b.a.C7892a;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* renamed from: com.baseproject.utils.speedtest.f */
/* loaded from: classes10.dex */
public class C4669f {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static C4670a[] b = new C4670a[10];
    private static int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.baseproject.utils.speedtest.f$a */
    /* loaded from: classes10.dex */
    public static class C4670a {
        String a;
        volatile String[] b;
        long c;
        int d;

        C4670a() {
        }

        String a() {
            if (this.b == null || this.c < System.currentTimeMillis()) {
                C4669f.c(this);
            }
            String[] strArr = this.b;
            int i = this.d;
            this.d = i + 1;
            return strArr[i % this.b.length];
        }
    }

    public static String a(String str) {
        int i = 0;
        while (true) {
            C4670a[] c4670aArr = b;
            if (i >= c4670aArr.length) {
                C4670a c4670a = new C4670a();
                c4670a.a = str;
                C4670a[] c4670aArr2 = b;
                int i2 = c;
                c = i2 + 1;
                c4670aArr2[i2 % c4670aArr2.length] = c4670a;
                return c4670a.a();
            }
            C4670a c4670a2 = c4670aArr[i];
            if (c4670a2 != null && c4670a2.a.equals(str)) {
                return c4670a2.a();
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(C4670a c4670a) {
        C7892a.a("SmartDns", "updateDnsRecord begin");
        if (c4670a != null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(c4670a.a);
                String[] strArr = new String[allByName.length];
                for (int i = 0; i < allByName.length; i++) {
                    strArr[i] = allByName[i].getHostAddress();
                }
                c4670a.b = strArr;
                c4670a.d = 0;
                c4670a.c = System.currentTimeMillis() + 300000;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        C7892a.a("SmartDns", "updateDnsRecord end");
    }
}
