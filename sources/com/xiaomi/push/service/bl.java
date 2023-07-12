package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.cv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.ez;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fw;
import com.xiaomi.push.gy;
import com.xiaomi.push.service.bv;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bl extends bv.AbstractC7745a implements cv.InterfaceC7623a {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.bl$a */
    /* loaded from: classes11.dex */
    public static class C7742a implements cv.InterfaceC7624b {
        C7742a() {
        }

        @Override // com.xiaomi.push.cv.InterfaceC7624b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", gy.a(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL() + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C7786v.a()));
            String builder = buildUpon.toString();
            AbstractC7535b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.push.bj.a(C7786v.m1245a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                fj.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                return a;
            } catch (IOException e) {
                fj.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.bl$b */
    /* loaded from: classes11.dex */
    static class C7743b extends cv {
        protected C7743b(Context context, com.xiaomi.push.cu cuVar, cv.InterfaceC7624b interfaceC7624b, String str) {
            super(context, cuVar, interfaceC7624b, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.push.cv
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (fh.m881a().m886a()) {
                    str2 = bv.m1206a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                fj.a(0, ez.GSLB_ERR.a(), 1, null, com.xiaomi.push.bj.c(cv.a) ? 1 : 0);
                throw e;
            }
        }
    }

    bl(XMPushService xMPushService) {
        this.f934a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        bl blVar = new bl(xMPushService);
        bv.a().a(blVar);
        synchronized (cv.class) {
            cv.a(blVar);
            cv.a(xMPushService, null, new C7742a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cv.InterfaceC7623a
    public cv a(Context context, com.xiaomi.push.cu cuVar, cv.InterfaceC7624b interfaceC7624b, String str) {
        return new C7743b(context, cuVar, interfaceC7624b, str);
    }

    @Override // com.xiaomi.push.service.bv.AbstractC7745a
    public void a(dw.C7634a c7634a) {
    }

    @Override // com.xiaomi.push.service.bv.AbstractC7745a
    public void a(dx.C7636b c7636b) {
        com.xiaomi.push.cr b;
        if (c7636b.m796b() && c7636b.m795a() && System.currentTimeMillis() - this.a > DateUtils.MILLIS_PER_HOUR) {
            AbstractC7535b.m586a("fetch bucket :" + c7636b.m795a());
            this.a = System.currentTimeMillis();
            cv a = cv.a();
            a.m753a();
            a.m756b();
            fw m1147a = this.f934a.m1147a();
            if (m1147a == null || (b = a.b(m1147a.m909a().c())) == null) {
                return;
            }
            ArrayList<String> m741a = b.m741a();
            boolean z = true;
            Iterator<String> it = m741a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m1147a.mo910a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m741a.isEmpty()) {
                return;
            }
            AbstractC7535b.m586a("bucket changed, force reconnect");
            this.f934a.a(0, (Exception) null);
            this.f934a.a(false);
        }
    }
}
