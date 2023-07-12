package com.youku.ups.request;

import android.content.Context;
import android.text.TextUtils;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.ups.a.C8083a;
import com.youku.ups.a.C8084b;
import com.youku.ups.data.C8085a;
import com.youku.ups.data.C8086b;
import com.youku.ups.data.RequestParams;
import com.youku.upsplayer.GetUps;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.VideoCacheInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.util.Logger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* renamed from: com.youku.ups.request.c */
/* loaded from: classes3.dex */
public class C8089c {
    private static final ExecutorService d = Executors.newCachedThreadPool();
    private final Context b;
    private final INetworkTask c;
    private InterfaceC8087a<List<VideoCacheInfo>> e;
    private RequestParams g;
    private NetworkParameter h;
    private String i;
    private String j;
    public String a = "http://ups.youku.com";
    private RequestData f = null;
    private final Runnable k = new Runnable() { // from class: com.youku.ups.request.UpsQGetRequest$1
        @Override // java.lang.Runnable
        public void run() {
            RequestData requestData;
            InterfaceC8087a interfaceC8087a;
            RequestData requestData2;
            Context context;
            RequestParams requestParams;
            RequestParams requestParams2;
            String a;
            RequestData requestData3;
            RequestData requestData4;
            String str;
            RequestData requestData5;
            String str2;
            NetworkParameter networkParameter;
            RequestData requestData6;
            RequestData requestData7;
            INetworkTask iNetworkTask;
            RequestData requestData8;
            InterfaceC8087a interfaceC8087a2;
            RequestData requestData9;
            RequestData requestData10;
            RequestData requestData11;
            NetworkParameter networkParameter2;
            RequestData requestData12;
            NetworkParameter networkParameter3;
            RequestData requestData13;
            NetworkParameter networkParameter4;
            RequestData requestData14;
            NetworkParameter networkParameter5;
            InterfaceC8087a interfaceC8087a3;
            RequestData requestData15;
            requestData = C8089c.this.f;
            requestData.upsTimeTraceBean = new UpsTimeTraceBean();
            try {
                context = C8089c.this.b;
                requestParams = C8089c.this.g;
                String a2 = C8083a.a(context, requestParams, false);
                C8089c c8089c = C8089c.this;
                requestParams2 = c8089c.g;
                a = c8089c.a(requestParams2, a2);
                if (TextUtils.isEmpty(a)) {
                    interfaceC8087a3 = C8089c.this.e;
                    requestData15 = C8089c.this.f;
                    interfaceC8087a3.onFailure(new C8085a(28001, "invalid url", requestData15));
                    return;
                }
                Logger.d("UpsPlayer", "ups url=" + a);
                requestData3 = C8089c.this.f;
                requestData3.url = a;
                requestData4 = C8089c.this.f;
                str = C8089c.this.i;
                requestData4.host = str;
                requestData5 = C8089c.this.f;
                str2 = C8089c.this.j;
                requestData5.ip = str2;
                networkParameter = C8089c.this.h;
                if (networkParameter != null) {
                    requestData11 = C8089c.this.f;
                    networkParameter2 = C8089c.this.h;
                    requestData11.cookie = networkParameter2.cookie;
                    requestData12 = C8089c.this.f;
                    networkParameter3 = C8089c.this.h;
                    requestData12.agent = networkParameter3.userAgent;
                    requestData13 = C8089c.this.f;
                    networkParameter4 = C8089c.this.h;
                    requestData13.connect_timeout = networkParameter4.connect_timeout;
                    requestData14 = C8089c.this.f;
                    networkParameter5 = C8089c.this.h;
                    requestData14.read_timeout = networkParameter5.read_timeout;
                }
                requestData6 = C8089c.this.f;
                if (requestData6.connect_timeout == 0) {
                    requestData10 = C8089c.this.f;
                    requestData10.connect_timeout = 15000;
                }
                requestData7 = C8089c.this.f;
                if (requestData7.read_timeout == 0) {
                    requestData9 = C8089c.this.f;
                    requestData9.read_timeout = 15000;
                }
                iNetworkTask = C8089c.this.c;
                requestData8 = C8089c.this.f;
                GetInfoResult data = iNetworkTask.getData(requestData8);
                List<VideoCacheInfo> a3 = C8089c.this.a(data);
                data.connectStat.rawUpsData = data.data;
                C8086b c8086b = new C8086b(a3);
                interfaceC8087a2 = C8089c.this.e;
                interfaceC8087a2.onSuccess(c8086b, data.connectStat);
            } catch (AntiTheftChainException e) {
                String str3 = "ckey构建失败：" + e.getMessage();
                interfaceC8087a = C8089c.this.e;
                int errorCode = e.getErrorCode();
                requestData2 = C8089c.this.f;
                interfaceC8087a.onFailure(new C8085a(errorCode, str3, requestData2));
            }
        }
    };

    public C8089c(Context context, INetworkTask iNetworkTask) {
        this.b = context;
        this.c = iNetworkTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(RequestParams requestParams, String str) {
        StringBuilder sb = new StringBuilder(this.a);
        sb.append(GetUps.UPS_MULTI_UPSIFO_PATH_NEW);
        this.f.ckey = str;
        C8084b.a(sb, "ckey", str);
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String value = entry.getValue();
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(value)) {
                C8084b.a(sb, entry.getKey(), entry.getValue());
            }
        }
        return sb.toString();
    }

    public List<VideoCacheInfo> a(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        ConnectStat connectStat2;
        int i;
        if (getInfoResult == null || (connectStat = getInfoResult.connectStat) == null || !connectStat.connect_success) {
            return null;
        }
        try {
            return ParseResult.parseMulUPSJSon(getInfoResult.data);
        } catch (Exception unused) {
            String str = getInfoResult.data;
            if (str != null) {
                if (str.contains("yk_web_anti_flow_limit_captcha_20171111")) {
                    connectStat2 = getInfoResult.connectStat;
                    connectStat2.connect_success = false;
                    i = ErrorConstants.ERROR_UPS_WEB_ANTI;
                } else if (!getInfoResult.data.contains("yk_web_anti_flow_limit_wait_20171111")) {
                    return null;
                } else {
                    connectStat2 = getInfoResult.connectStat;
                    connectStat2.connect_success = false;
                    i = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                }
                connectStat2.response_code = i;
                return null;
            }
            return null;
        }
    }

    public void a(RequestParams requestParams, NetworkParameter networkParameter, InterfaceC8087a<List<VideoCacheInfo>> interfaceC8087a) {
        RequestData requestData = new RequestData();
        this.f = requestData;
        if (networkParameter == null || requestParams == null) {
            interfaceC8087a.onFailure(new C8085a(0, "invalid parameter", requestData));
            return;
        }
        this.g = requestParams;
        this.h = networkParameter;
        this.e = interfaceC8087a;
        d.submit(this.k);
    }
}
