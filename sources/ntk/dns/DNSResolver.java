package ntk.dns;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DNSResolver {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static C8728a[] b = new C8728a[10];
    private static int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: ntk.dns.DNSResolver$a */
    /* loaded from: classes2.dex */
    public static class C8728a {
        String a;
        volatile String[] b;
        long c;

        C8728a() {
        }

        String[] a() {
            if (this.b == null || this.c < System.currentTimeMillis()) {
                DNSResolver.e(this);
            }
            return this.b;
        }
    }

    public static String[] c(String str) {
        int i = 0;
        while (true) {
            C8728a[] c8728aArr = b;
            if (i >= c8728aArr.length) {
                C8728a c8728a = new C8728a();
                c8728a.a = str;
                C8728a[] c8728aArr2 = b;
                int i2 = c;
                c = i2 + 1;
                c8728aArr2[i2 % c8728aArr2.length] = c8728a;
                return c8728a.a();
            }
            C8728a c8728a2 = c8728aArr[i];
            if (c8728a2 != null && c8728a2.a.equals(str)) {
                return c8728a2.a();
            }
            i++;
        }
    }

    private static ArrayList<String> d(String str) {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final C8728a c8728a) {
        a.execute(new Runnable() { // from class: ntk.dns.DNSResolver.1
            @Override // java.lang.Runnable
            public void run() {
                DNSResolver.f(C8728a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(C8728a c8728a) {
        if (c8728a != null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(c8728a.a);
                String[] strArr = new String[allByName.length];
                for (int i = 0; i < allByName.length; i++) {
                    strArr[i] = allByName[i].getHostAddress();
                }
                c8728a.b = strArr;
                if (NetworkUtil.d() == 1) {
                    ArrayList<String> d = d(c8728a.a);
                    if (!d.isEmpty()) {
                        String[] strArr2 = (String[]) d.toArray(new String[d.size()]);
                    }
                }
                c8728a.c = System.currentTimeMillis() + 300000;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
