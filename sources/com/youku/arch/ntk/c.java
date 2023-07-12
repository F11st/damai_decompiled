package com.youku.arch.ntk;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import com.youku.arch.ntk.a.f;
import com.youku.arch.ntk.a.h;
import com.youku.arch.ntk.a.i;
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
/* loaded from: classes2.dex */
public class c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a = com.baseproject.utils.speedtest.b.class.getSimpleName();
    private int b = 10000;
    private int c = 10000;

    private String a(String str, h hVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654152754")) {
            return (String) ipChange.ipc$dispatch("654152754", new Object[]{this, str, hVar});
        }
        StringBuilder sb = new StringBuilder(str);
        a(sb, RequestParams.client_ip, hVar.c);
        a(sb, RequestParams.client_ts, hVar.d);
        a(sb, "utdid", hVar.e);
        a(sb, "ccode", hVar.f);
        a(sb, IRequestConst.STOKEN, hVar.g);
        a(sb, "pid", hVar.h);
        a(sb, "network", hVar.i);
        a(sb, "app_ver", hVar.j);
        a(sb, "version", hVar.k);
        a(sb, "brand", hVar.o);
        a(sb, IRequestConst.ISP, hVar.l);
        a(sb, "mac", hVar.m);
        a(sb, OConstant.CANDIDATE_OSVER, hVar.n);
        a(sb, "triggerType", hVar.t);
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

    public int a(f fVar) {
        String str;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861451161")) {
            return ((Integer) ipChange.ipc$dispatch("1861451161", new Object[]{this, fVar})).intValue();
        }
        if (fVar.b.b == 1) {
            com.youku.b.a.a.a(a, "use pre-host cmd url");
            str = "https://pre-connectivity.youku.com/speed/getGroupTask?";
        } else {
            com.youku.b.a.a.a(a, "use official cmd url");
            str = "https://connectivity.youku.com/speed/getGroupTask?";
        }
        try {
            this.b = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_connect_timeout", "10")) * 1000;
            this.c = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_read_timeout", "10")) * 1000;
        } catch (NumberFormatException unused) {
            com.youku.b.a.a.b(a, "orange_timeout_wrong_format");
        }
        String str4 = a;
        com.youku.b.a.a.a(str4, "requestCmdInfo time limit:" + this.b + "," + this.c);
        h hVar = fVar.b;
        if (hVar == null) {
            com.youku.b.a.a.a(str4, "cmd url or reqinfo is empty");
            return -2001;
        }
        InputStream inputStream = null;
        try {
            URL url = new URL(a(str, hVar));
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.b);
            httpURLConnection.setReadTimeout(this.c);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            if (fVar.b.b == 1) {
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
                    fVar.a = intValue == 0 ? (i) JSON.parseObject(parseObject.getJSONObject("data").toJSONString(), i.class) : new i();
                    i iVar = fVar.a;
                    iVar.b = intValue;
                    iVar.c = parseObject.getString("message");
                    if (intValue >= 0) {
                        try {
                            inputStream.close();
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                        return 0;
                    }
                    if (fVar.a.c != null) {
                        str2 = a;
                        str3 = "cmd ups error:" + fVar.a.c;
                    } else {
                        str2 = a;
                        str3 = "cmd ups error with empty msg";
                    }
                    com.youku.b.a.a.a(str2, str3);
                    int i = fVar.a.b;
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
