package com.meizu.cloud.pushsdk.c.c;

import android.net.TrafficStats;
import anet.channel.request.C0193a;
import com.meizu.cloud.pushsdk.c.a.C5944a;
import com.meizu.cloud.pushsdk.c.c.C5971k;
import com.meizu.cloud.pushsdk.c.g.C5987g;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5983c;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5984d;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.e */
/* loaded from: classes10.dex */
public class C5960e implements InterfaceC5954a {
    private static AbstractC5973l a(final HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getDoInput()) {
            final InterfaceC5984d a = C5987g.a(C5987g.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
            return new AbstractC5973l() { // from class: com.meizu.cloud.pushsdk.c.c.e.1
                @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5973l
                public InterfaceC5984d a() {
                    return a;
                }
            };
        }
        return null;
    }

    private static void a(HttpURLConnection httpURLConnection, C5968i c5968i) throws IOException {
        String str;
        String str2;
        int c = c5968i.c();
        if (c != 0) {
            if (c == 1) {
                str2 = "POST";
            } else if (c == 2) {
                str2 = C0193a.C0196c.PUT;
            } else if (c == 3) {
                str = C0193a.C0196c.DELETE;
            } else if (c == 4) {
                str = C0193a.C0196c.HEAD;
            } else if (c != 5) {
                throw new IllegalStateException("Unknown method type.");
            } else {
                str2 = "PATCH";
            }
            httpURLConnection.setRequestMethod(str2);
            b(httpURLConnection, c5968i);
            return;
        }
        str = "GET";
        httpURLConnection.setRequestMethod(str);
    }

    protected static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private HttpURLConnection b(C5968i c5968i) throws IOException {
        URL url = new URL(c5968i.a().toString());
        if (MinSdkChecker.isSupportNotificationChannel()) {
            TrafficStats.setThreadStatsTag(2006537699);
        }
        HttpURLConnection a = a(url);
        a.setConnectTimeout(60000);
        a.setReadTimeout(60000);
        a.setUseCaches(false);
        a.setDoInput(true);
        return a;
    }

    private static void b(HttpURLConnection httpURLConnection, C5968i c5968i) throws IOException {
        AbstractC5970j e = c5968i.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e.a().toString());
            InterfaceC5983c a = C5987g.a(C5987g.a(httpURLConnection.getOutputStream()));
            e.a(a);
            a.close();
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.c.InterfaceC5954a
    public C5971k a(C5968i c5968i) throws IOException {
        HttpURLConnection b = b(c5968i);
        for (String str : c5968i.d().b()) {
            String a = c5968i.a(str);
            C5944a.b("current header name " + str + " value " + a);
            b.addRequestProperty(str, a);
        }
        a(b, c5968i);
        int responseCode = b.getResponseCode();
        return new C5971k.C5972a().a(responseCode).a(c5968i.d()).a(b.getResponseMessage()).a(c5968i).a(a(b)).a();
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
