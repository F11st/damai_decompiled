package com.huawei.hms.framework.network.grs.h.f;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static HttpsURLConnection a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (!(openConnection instanceof HttpsURLConnection)) {
            Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.h.g.a.a(context));
            httpsURLConnection.setHostnameVerifier(com.huawei.hms.framework.network.grs.h.g.a.a());
        } catch (IllegalArgumentException unused) {
            Logger.w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        String b = com.huawei.hms.framework.network.grs.h.a.b(context, "NetworkKit-grs", str2);
        Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is:" + b);
        httpsURLConnection.setRequestProperty(IRequestConst.USER_AGENT, b);
        return httpsURLConnection;
    }

    public static void a(HttpsURLConnection httpsURLConnection, String str) {
        String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else if (httpsURLConnection != null) {
            OutputStream outputStream = null;
            try {
                outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(str.getBytes("UTF-8"));
                outputStream.flush();
                return;
            } finally {
                IoUtils.closeSecure(outputStream);
            }
        } else {
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        }
        Logger.i("URLConnectionHelper", str2);
    }
}
