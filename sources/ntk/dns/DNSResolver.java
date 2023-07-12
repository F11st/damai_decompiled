package ntk.dns;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DNSResolver {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static a[] b = new a[10];
    private static int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a {
        String a;
        volatile String[] b;
        long c;

        a() {
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
            a[] aVarArr = b;
            if (i >= aVarArr.length) {
                a aVar = new a();
                aVar.a = str;
                a[] aVarArr2 = b;
                int i2 = c;
                c = i2 + 1;
                aVarArr2[i2 % aVarArr2.length] = aVar;
                return aVar.a();
            }
            a aVar2 = aVarArr[i];
            if (aVar2 != null && aVar2.a.equals(str)) {
                return aVar2.a();
            }
            i++;
        }
    }

    private static ArrayList<String> d(String str) {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final a aVar) {
        a.execute(new Runnable() { // from class: ntk.dns.DNSResolver.1
            @Override // java.lang.Runnable
            public void run() {
                DNSResolver.f(a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(a aVar) {
        if (aVar != null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(aVar.a);
                String[] strArr = new String[allByName.length];
                for (int i = 0; i < allByName.length; i++) {
                    strArr[i] = allByName[i].getHostAddress();
                }
                aVar.b = strArr;
                if (NetworkUtil.d() == 1) {
                    ArrayList<String> d = d(aVar.a);
                    if (!d.isEmpty()) {
                        String[] strArr2 = (String[]) d.toArray(new String[d.size()]);
                    }
                }
                aVar.c = System.currentTimeMillis() + 300000;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
