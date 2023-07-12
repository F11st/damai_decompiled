package com.baseproject.utils.speedtest;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.baseproject.utils.speedtest.j;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import com.youku.ups.data.RequestParams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.android.spdy.TnetStatusCode;
import tb.n83;
import tb.q43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final String c = "b";
    private int a = 1000;
    private int b = 2000;

    private String b(String str, q43 q43Var) {
        StringBuilder sb = new StringBuilder(str);
        c(sb, RequestParams.client_ip, q43Var.c);
        c(sb, RequestParams.client_ts, q43Var.d);
        c(sb, "utdid", q43Var.e);
        c(sb, "ccode", q43Var.f);
        c(sb, IRequestConst.STOKEN, q43Var.g);
        c(sb, "pid", q43Var.h);
        c(sb, "network", q43Var.i);
        c(sb, "app_ver", q43Var.j);
        c(sb, "version", q43Var.k);
        c(sb, "brand", q43Var.o);
        c(sb, IRequestConst.ISP, q43Var.l);
        c(sb, "mac", q43Var.m);
        c(sb, OConstant.CANDIDATE_OSVER, q43Var.n);
        return sb.toString();
    }

    private void c(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        sb.append("&");
    }

    public int a(String str, j.a aVar) {
        q43 q43Var;
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            if (aVar.a.b == 1) {
                com.youku.b.a.a.a(c, "use pre-host cmd url");
                str = "https://106.11.46.130/speed/get?";
            } else {
                com.youku.b.a.a.a(c, "use official cmd url");
                str = "https://connectivity.youku.com/speed/get?";
            }
        }
        try {
            this.a = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_connect_timeout", "10")) * 1000;
            this.b = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_read_timeout", "10")) * 1000;
        } catch (NumberFormatException unused) {
            com.youku.b.a.a.b(c, "orange_timeout_wrong_format");
        }
        String str4 = c;
        com.youku.b.a.a.a(str4, "requestCmdInfo time limit:" + this.a + "," + this.b);
        if (aVar == null || (q43Var = aVar.a) == null) {
            com.youku.b.a.a.a(str4, "cmd url or reqinfo is empty");
            return -2001;
        }
        InputStream inputStream = null;
        try {
            String b = b(str, q43Var);
            URL url = new URL(b);
            com.youku.b.a.a.a(str4, "com.baseproject.utils.speedtest cmd request:" + b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.a);
            httpURLConnection.setReadTimeout(this.b);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            if (aVar.a.b == 1) {
                httpURLConnection.setRequestProperty(BizTime.HOST, "pre-connectivity.youku.com");
            }
            if (url.getProtocol().equals("https")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new n83());
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    a aVar2 = (a) JSON.parseObject(stringBuffer.toString(), a.class);
                    aVar.b = aVar2;
                    if (aVar2.f >= 0) {
                        try {
                            inputStream.close();
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                        return 0;
                    }
                    if (aVar2.e != null) {
                        str2 = c;
                        str3 = "cmd ups error:" + aVar.b.e;
                    } else {
                        str2 = c;
                        str3 = "cmd ups error with empty msg";
                    }
                    com.youku.b.a.a.a(str2, str3);
                    int i = aVar.b.f;
                    try {
                        inputStream.close();
                        httpURLConnection.disconnect();
                    } catch (Exception unused3) {
                    }
                    return i;
                } catch (JSONException e) {
                    e.printStackTrace();
                    try {
                        inputStream.close();
                        httpURLConnection.disconnect();
                    } catch (Exception unused4) {
                    }
                    return TnetStatusCode.EASY_REASON_CONN_TIMEOUT;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        inputStream.close();
                        httpURLConnection.disconnect();
                    } catch (Exception unused5) {
                    }
                    return TnetStatusCode.EASY_REASON_DISCONNECT;
                }
            }
            return TnetStatusCode.EASY_REASON_SESSION_TIMEOUT;
        } catch (IOException e3) {
            e3.printStackTrace();
            return TnetStatusCode.EASY_REASON_SESSION_TIMEOUT;
        }
    }
}
