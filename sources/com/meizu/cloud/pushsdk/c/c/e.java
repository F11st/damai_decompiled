package com.meizu.cloud.pushsdk.c.c;

import android.net.TrafficStats;
import anet.channel.request.a;
import com.meizu.cloud.pushsdk.c.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e implements a {
    private static l a(final HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getDoInput()) {
            final com.meizu.cloud.pushsdk.c.g.d a = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
            return new l() { // from class: com.meizu.cloud.pushsdk.c.c.e.1
                @Override // com.meizu.cloud.pushsdk.c.c.l
                public com.meizu.cloud.pushsdk.c.g.d a() {
                    return a;
                }
            };
        }
        return null;
    }

    private static void a(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        String str;
        String str2;
        int c = iVar.c();
        if (c != 0) {
            if (c == 1) {
                str2 = "POST";
            } else if (c == 2) {
                str2 = a.c.PUT;
            } else if (c == 3) {
                str = a.c.DELETE;
            } else if (c == 4) {
                str = a.c.HEAD;
            } else if (c != 5) {
                throw new IllegalStateException("Unknown method type.");
            } else {
                str2 = "PATCH";
            }
            httpURLConnection.setRequestMethod(str2);
            b(httpURLConnection, iVar);
            return;
        }
        str = "GET";
        httpURLConnection.setRequestMethod(str);
    }

    protected static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private HttpURLConnection b(i iVar) throws IOException {
        URL url = new URL(iVar.a().toString());
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

    private static void b(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        j e = iVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e.a().toString());
            com.meizu.cloud.pushsdk.c.g.c a = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(httpURLConnection.getOutputStream()));
            e.a(a);
            a.close();
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.c.a
    public k a(i iVar) throws IOException {
        HttpURLConnection b = b(iVar);
        for (String str : iVar.d().b()) {
            String a = iVar.a(str);
            com.meizu.cloud.pushsdk.c.a.a.b("current header name " + str + " value " + a);
            b.addRequestProperty(str, a);
        }
        a(b, iVar);
        int responseCode = b.getResponseCode();
        return new k.a().a(responseCode).a(iVar.d()).a(b.getResponseMessage()).a(iVar).a(a(b)).a();
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
