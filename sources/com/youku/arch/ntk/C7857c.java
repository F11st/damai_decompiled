package com.youku.arch.ntk;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.C4668b;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import com.youku.arch.ntk.a.C7832f;
import com.youku.arch.ntk.a.C7834h;
import com.youku.arch.ntk.a.C7835i;
import com.youku.b.a.C7892a;
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

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.c */
/* loaded from: classes2.dex */
public class C7857c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a = C4668b.class.getSimpleName();
    private int b = 10000;
    private int c = 10000;

    private String a(String str, C7834h c7834h) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654152754")) {
            return (String) ipChange.ipc$dispatch("654152754", new Object[]{this, str, c7834h});
        }
        StringBuilder sb = new StringBuilder(str);
        a(sb, RequestParams.client_ip, c7834h.c);
        a(sb, RequestParams.client_ts, c7834h.d);
        a(sb, "utdid", c7834h.e);
        a(sb, "ccode", c7834h.f);
        a(sb, IRequestConst.STOKEN, c7834h.g);
        a(sb, "pid", c7834h.h);
        a(sb, "network", c7834h.i);
        a(sb, "app_ver", c7834h.j);
        a(sb, "version", c7834h.k);
        a(sb, "brand", c7834h.o);
        a(sb, IRequestConst.ISP, c7834h.l);
        a(sb, "mac", c7834h.m);
        a(sb, OConstant.CANDIDATE_OSVER, c7834h.n);
        a(sb, "triggerType", c7834h.t);
        return sb.toString();
    }

    private void a(StringBuilder sb, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897227135")) {
            ipChange.ipc$dispatch("897227135", new Object[]{this, sb, str, str2});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            sb.append(str);
            sb.append("=");
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
            sb.append("&");
        }
    }

    public int a(C7832f c7832f) {
        String str;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861451161")) {
            return ((Integer) ipChange.ipc$dispatch("1861451161", new Object[]{this, c7832f})).intValue();
        }
        if (c7832f.b.b == 1) {
            C7892a.a(a, "use pre-host cmd url");
            str = "https://pre-connectivity.youku.com/speed/getGroupTask?";
        } else {
            C7892a.a(a, "use official cmd url");
            str = "https://connectivity.youku.com/speed/getGroupTask?";
        }
        try {
            this.b = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_connect_timeout", "10")) * 1000;
            this.c = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_read_timeout", "10")) * 1000;
        } catch (NumberFormatException unused) {
            C7892a.b(a, "orange_timeout_wrong_format");
        }
        String str4 = a;
        C7892a.a(str4, "requestCmdInfo time limit:" + this.b + "," + this.c);
        C7834h c7834h = c7832f.b;
        if (c7834h == null) {
            C7892a.a(str4, "cmd url or reqinfo is empty");
            return -2001;
        }
        InputStream inputStream = null;
        try {
            URL url = new URL(a(str, c7834h));
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.b);
            httpURLConnection.setReadTimeout(this.c);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            if (c7832f.b.b == 1) {
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
                    JSONObject parseObject = JSON.parseObject(stringBuffer.toString());
                    int intValue = parseObject.getIntValue("errorCode");
                    c7832f.a = intValue == 0 ? (C7835i) JSON.parseObject(parseObject.getJSONObject("data").toJSONString(), C7835i.class) : new C7835i();
                    C7835i c7835i = c7832f.a;
                    c7835i.b = intValue;
                    c7835i.c = parseObject.getString("message");
                    if (intValue >= 0) {
                        try {
                            inputStream.close();
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                        return 0;
                    }
                    if (c7832f.a.c != null) {
                        str2 = a;
                        str3 = "cmd ups error:" + c7832f.a.c;
                    } else {
                        str2 = a;
                        str3 = "cmd ups error with empty msg";
                    }
                    C7892a.a(str2, str3);
                    int i = c7832f.a.b;
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
