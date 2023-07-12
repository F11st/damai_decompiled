package com.sina.weibo.sdk.net;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.net.b */
/* loaded from: classes7.dex */
public final class C6218b implements InterfaceC6217a {
    @Override // com.sina.weibo.sdk.net.InterfaceC6217a
    public final InterfaceC6223f a(InterfaceC6220d interfaceC6220d) {
        InputStream errorStream;
        String url = interfaceC6220d.getUrl();
        Bundle params = interfaceC6220d.getParams();
        if (params != null && params.size() != 0 && !TextUtils.isEmpty(url)) {
            Uri parse = Uri.parse(url);
            if (!params.isEmpty()) {
                Uri.Builder buildUpon = parse.buildUpon();
                for (String str : params.keySet()) {
                    buildUpon.appendQueryParameter(str, String.valueOf(params.get(str)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                url = parse.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                Bundle bundle = new Bundle();
                bundle.putString("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                a(httpURLConnection, bundle);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(interfaceC6220d.getReadTimeout());
                httpURLConnection.setConnectTimeout(interfaceC6220d.getConnectTimeout());
                httpURLConnection.connect();
                a(httpURLConnection.getOutputStream(), interfaceC6220d);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                C6224g c6224g = new C6224g(responseCode, errorStream);
                httpURLConnection.disconnect();
                return c6224g;
            } catch (Exception e) {
                throw new Throwable(e.getMessage());
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }

    private static void a(OutputStream outputStream, InterfaceC6220d interfaceC6220d) {
        Bundle d = interfaceC6220d.d();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : d.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String valueOf = String.valueOf(d.get(str));
            try {
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(valueOf, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
