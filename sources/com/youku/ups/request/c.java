package com.youku.ups.request;

import android.content.Context;
import android.text.TextUtils;
import com.youku.antitheftchain.exception.AntiTheftChainException;
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
/* loaded from: classes3.dex */
public class c {
    private static final ExecutorService d = Executors.newCachedThreadPool();
    private final Context b;
    private final INetworkTask c;
    private a<List<VideoCacheInfo>> e;
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
            a aVar;
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
            a aVar2;
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
            a aVar3;
            RequestData requestData15;
            requestData = c.this.f;
            requestData.upsTimeTraceBean = new UpsTimeTraceBean();
            try {
                context = c.this.b;
                requestParams = c.this.g;
                String a2 = com.youku.ups.a.a.a(context, requestParams, false);
                c cVar = c.this;
                requestParams2 = cVar.g;
                a = cVar.a(requestParams2, a2);
                if (TextUtils.isEmpty(a)) {
                    aVar3 = c.this.e;
                    requestData15 = c.this.f;
                    aVar3.onFailure(new com.youku.ups.data.a(28001, "invalid url", requestData15));
                    return;
                }
                Logger.d("UpsPlayer", "ups url=" + a);
                requestData3 = c.this.f;
                requestData3.url = a;
                requestData4 = c.this.f;
                str = c.this.i;
                requestData4.host = str;
                requestData5 = c.this.f;
                str2 = c.this.j;
                requestData5.ip = str2;
                networkParameter = c.this.h;
                if (networkParameter != null) {
                    requestData11 = c.this.f;
                    networkParameter2 = c.this.h;
                    requestData11.cookie = networkParameter2.cookie;
                    requestData12 = c.this.f;
                    networkParameter3 = c.this.h;
                    requestData12.agent = networkParameter3.userAgent;
                    requestData13 = c.this.f;
                    networkParameter4 = c.this.h;
                    requestData13.connect_timeout = networkParameter4.connect_timeout;
                    requestData14 = c.this.f;
                    networkParameter5 = c.this.h;
                    requestData14.read_timeout = networkParameter5.read_timeout;
                }
                requestData6 = c.this.f;
                if (requestData6.connect_timeout == 0) {
                    requestData10 = c.this.f;
                    requestData10.connect_timeout = 15000;
                }
                requestData7 = c.this.f;
                if (requestData7.read_timeout == 0) {
                    requestData9 = c.this.f;
                    requestData9.read_timeout = 15000;
                }
                iNetworkTask = c.this.c;
                requestData8 = c.this.f;
                GetInfoResult data = iNetworkTask.getData(requestData8);
                List<VideoCacheInfo> a3 = c.this.a(data);
                data.connectStat.rawUpsData = data.data;
                com.youku.ups.data.b bVar = new com.youku.ups.data.b(a3);
                aVar2 = c.this.e;
                aVar2.onSuccess(bVar, data.connectStat);
            } catch (AntiTheftChainException e) {
                String str3 = "ckey构建失败：" + e.getMessage();
                aVar = c.this.e;
                int errorCode = e.getErrorCode();
                requestData2 = c.this.f;
                aVar.onFailure(new com.youku.ups.data.a(errorCode, str3, requestData2));
            }
        }
    };

    public c(Context context, INetworkTask iNetworkTask) {
        this.b = context;
        this.c = iNetworkTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(RequestParams requestParams, String str) {
        StringBuilder sb = new StringBuilder(this.a);
        sb.append(GetUps.UPS_MULTI_UPSIFO_PATH_NEW);
        this.f.ckey = str;
        com.youku.ups.a.b.a(sb, "ckey", str);
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String value = entry.getValue();
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(value)) {
                com.youku.ups.a.b.a(sb, entry.getKey(), entry.getValue());
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

    public void a(RequestParams requestParams, NetworkParameter networkParameter, a<List<VideoCacheInfo>> aVar) {
        RequestData requestData = new RequestData();
        this.f = requestData;
        if (networkParameter == null || requestParams == null) {
            aVar.onFailure(new com.youku.ups.data.a(0, "invalid parameter", requestData));
            return;
        }
        this.g = requestParams;
        this.h = networkParameter;
        this.e = aVar;
        d.submit(this.k);
    }
}
