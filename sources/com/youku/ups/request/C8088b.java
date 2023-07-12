package com.youku.ups.request;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.ups.a.C8083a;
import com.youku.ups.a.C8084b;
import com.youku.ups.data.C8085a;
import com.youku.ups.data.C8086b;
import com.youku.ups.data.RequestParams;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.MTopUpsRequest;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.util.Logger;
import com.youku.upsplayer.util.PlayStageTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* renamed from: com.youku.ups.request.b */
/* loaded from: classes3.dex */
public class C8088b {
    private static Set<String> d = new HashSet<String>() { // from class: com.youku.ups.request.UpsGetRequest$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            add(IRequestConst.MDL);
            add("device_brand");
            add(IRequestConst.OSV);
            add("ua");
        }
    };
    private static ExecutorService m = Executors.newCachedThreadPool();
    public String a;
    protected final int b;
    protected final int c;
    private INetworkTask e;
    private NetworkParameter f;
    private RequestParams g;
    private RequestParams h;
    private InterfaceC8087a<VideoInfo> i;
    private String j;
    private String k;
    private RequestData l;
    private boolean n;
    private Context o;
    private final Runnable p;

    public C8088b(Context context, INetworkTask iNetworkTask, boolean z) {
        this.a = "http://ups.youku.com";
        this.b = 15000;
        this.c = 15000;
        this.l = null;
        this.p = new Runnable() { // from class: com.youku.ups.request.UpsGetRequest$2
            @Override // java.lang.Runnable
            public void run() {
                RequestData requestData;
                RequestData requestData2;
                InterfaceC8087a interfaceC8087a;
                RequestData requestData3;
                Context context2;
                RequestParams requestParams;
                boolean z2;
                RequestParams requestParams2;
                String a;
                RequestData requestData4;
                RequestData requestData5;
                RequestData requestData6;
                MTopUpsRequest a2;
                RequestData requestData7;
                RequestData requestData8;
                String str;
                RequestData requestData9;
                String str2;
                NetworkParameter networkParameter;
                RequestData requestData10;
                RequestData requestData11;
                RequestData requestData12;
                INetworkTask iNetworkTask2;
                RequestData requestData13;
                RequestData requestData14;
                VideoInfo a3;
                RequestData requestData15;
                RequestData requestData16;
                InterfaceC8087a interfaceC8087a2;
                RequestData requestData17;
                RequestData requestData18;
                RequestData requestData19;
                RequestData requestData20;
                RequestData requestData21;
                RequestData requestData22;
                RequestData requestData23;
                RequestData requestData24;
                RequestData requestData25;
                RequestData requestData26;
                RequestData requestData27;
                RequestData requestData28;
                RequestData requestData29;
                RequestData requestData30;
                NetworkParameter networkParameter2;
                RequestData requestData31;
                NetworkParameter networkParameter3;
                RequestData requestData32;
                NetworkParameter networkParameter4;
                RequestData requestData33;
                NetworkParameter networkParameter5;
                InterfaceC8087a interfaceC8087a3;
                RequestData requestData34;
                requestData = C8088b.this.l;
                requestData.upsTimeTraceBean = new UpsTimeTraceBean();
                requestData2 = C8088b.this.l;
                requestData2.upsTimeTraceBean.startTrace();
                try {
                    context2 = C8088b.this.o;
                    requestParams = C8088b.this.g;
                    z2 = C8088b.this.n;
                    String a4 = C8083a.a(context2, requestParams, z2);
                    C8088b c8088b = C8088b.this;
                    requestParams2 = c8088b.g;
                    a = c8088b.a(requestParams2, a4);
                    requestData4 = C8088b.this.l;
                    requestData4.upsTimeTraceBean.traceTimeGetCkey();
                    if (TextUtils.isEmpty(a)) {
                        Logger.d("UpsGetRequest", "invalid url");
                        interfaceC8087a3 = C8088b.this.i;
                        requestData34 = C8088b.this.l;
                        interfaceC8087a3.onFailure(new C8085a(28001, "invalid url", requestData34));
                        return;
                    }
                    Logger.d("UpsPlayer", "ups url=" + a);
                    requestData5 = C8088b.this.l;
                    requestData5.url = a;
                    requestData6 = C8088b.this.l;
                    a2 = C8088b.this.a(a4);
                    requestData6.mTopUpsRequest = a2;
                    requestData7 = C8088b.this.l;
                    requestData7.upsType = 1;
                    requestData8 = C8088b.this.l;
                    str = C8088b.this.j;
                    requestData8.host = str;
                    requestData9 = C8088b.this.l;
                    str2 = C8088b.this.k;
                    requestData9.ip = str2;
                    networkParameter = C8088b.this.f;
                    if (networkParameter != null) {
                        requestData30 = C8088b.this.l;
                        networkParameter2 = C8088b.this.f;
                        requestData30.cookie = networkParameter2.cookie;
                        requestData31 = C8088b.this.l;
                        networkParameter3 = C8088b.this.f;
                        requestData31.agent = networkParameter3.userAgent;
                        requestData32 = C8088b.this.l;
                        networkParameter4 = C8088b.this.f;
                        requestData32.connect_timeout = networkParameter4.connect_timeout;
                        requestData33 = C8088b.this.l;
                        networkParameter5 = C8088b.this.f;
                        requestData33.read_timeout = networkParameter5.read_timeout;
                    }
                    requestData10 = C8088b.this.l;
                    if (requestData10.connect_timeout == 0) {
                        requestData29 = C8088b.this.l;
                        requestData29.connect_timeout = 15000;
                    }
                    requestData11 = C8088b.this.l;
                    if (requestData11.read_timeout == 0) {
                        requestData28 = C8088b.this.l;
                        requestData28.read_timeout = 15000;
                    }
                    Logger.d("UpsGetRequest", "run start");
                    PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
                    upsRequest.beginSection("apiRequest");
                    requestData12 = C8088b.this.l;
                    if (requestData12 != null) {
                        requestData26 = C8088b.this.l;
                        if (requestData26.upsTimeTraceBean != null) {
                            requestData27 = C8088b.this.l;
                            requestData27.upsTimeTraceBean.traceTimeStartRequest();
                        }
                    }
                    iNetworkTask2 = C8088b.this.e;
                    requestData13 = C8088b.this.l;
                    GetInfoResult data = iNetworkTask2.getData(requestData13);
                    upsRequest.endSection();
                    requestData14 = C8088b.this.l;
                    if (requestData14 != null) {
                        requestData24 = C8088b.this.l;
                        if (requestData24.upsTimeTraceBean != null) {
                            requestData25 = C8088b.this.l;
                            requestData25.upsTimeTraceBean.traceTimeStartParseResult();
                        }
                    }
                    a3 = C8088b.this.a(data);
                    requestData15 = C8088b.this.l;
                    if (requestData15 != null) {
                        requestData19 = C8088b.this.l;
                        if (requestData19.upsTimeTraceBean != null) {
                            requestData20 = C8088b.this.l;
                            requestData20.upsTimeTraceBean.traceTimeEndParse();
                            StringBuilder sb = new StringBuilder();
                            requestData21 = C8088b.this.l;
                            sb.append(requestData21.vid);
                            sb.append(" total ups parse cost:");
                            requestData22 = C8088b.this.l;
                            sb.append(requestData22.upsTimeTraceBean.timeEndParse);
                            sb.append("; compress:");
                            requestData23 = C8088b.this.l;
                            sb.append(requestData23.compress);
                            Logger.d("UpsPlayer", sb.toString());
                        }
                    }
                    if (a3 != null) {
                        C8088b.this.a(a3, data);
                    }
                    Logger.d("UpsPlayer", "call back result");
                    requestData16 = C8088b.this.l;
                    if (requestData16 != null) {
                        requestData17 = C8088b.this.l;
                        if (requestData17.upsTimeTraceBean != null) {
                            ConnectStat connectStat = data.connectStat;
                            requestData18 = C8088b.this.l;
                            connectStat.mUpsTimeTraceBean = requestData18.upsTimeTraceBean;
                            data.connectStat.rawUpsData = data.data;
                        }
                    }
                    C8086b c8086b = new C8086b(a3);
                    interfaceC8087a2 = C8088b.this.i;
                    interfaceC8087a2.onSuccess(c8086b, data.connectStat);
                    Logger.d("UpsGetRequest", "run finish");
                } catch (AntiTheftChainException e) {
                    String str3 = "ckey构建失败：" + e.getMessage();
                    interfaceC8087a = C8088b.this.i;
                    int errorCode = e.getErrorCode();
                    requestData3 = C8088b.this.l;
                    interfaceC8087a.onFailure(new C8085a(errorCode, str3, requestData3));
                }
            }
        };
        this.o = context;
        this.e = iNetworkTask;
        this.n = z;
    }

    public C8088b(Context context, INetworkTask iNetworkTask, boolean z, String str, String str2) {
        this.a = "http://ups.youku.com";
        this.b = 15000;
        this.c = 15000;
        this.l = null;
        this.p = new Runnable() { // from class: com.youku.ups.request.UpsGetRequest$2
            @Override // java.lang.Runnable
            public void run() {
                RequestData requestData;
                RequestData requestData2;
                InterfaceC8087a interfaceC8087a;
                RequestData requestData3;
                Context context2;
                RequestParams requestParams;
                boolean z2;
                RequestParams requestParams2;
                String a;
                RequestData requestData4;
                RequestData requestData5;
                RequestData requestData6;
                MTopUpsRequest a2;
                RequestData requestData7;
                RequestData requestData8;
                String str3;
                RequestData requestData9;
                String str22;
                NetworkParameter networkParameter;
                RequestData requestData10;
                RequestData requestData11;
                RequestData requestData12;
                INetworkTask iNetworkTask2;
                RequestData requestData13;
                RequestData requestData14;
                VideoInfo a3;
                RequestData requestData15;
                RequestData requestData16;
                InterfaceC8087a interfaceC8087a2;
                RequestData requestData17;
                RequestData requestData18;
                RequestData requestData19;
                RequestData requestData20;
                RequestData requestData21;
                RequestData requestData22;
                RequestData requestData23;
                RequestData requestData24;
                RequestData requestData25;
                RequestData requestData26;
                RequestData requestData27;
                RequestData requestData28;
                RequestData requestData29;
                RequestData requestData30;
                NetworkParameter networkParameter2;
                RequestData requestData31;
                NetworkParameter networkParameter3;
                RequestData requestData32;
                NetworkParameter networkParameter4;
                RequestData requestData33;
                NetworkParameter networkParameter5;
                InterfaceC8087a interfaceC8087a3;
                RequestData requestData34;
                requestData = C8088b.this.l;
                requestData.upsTimeTraceBean = new UpsTimeTraceBean();
                requestData2 = C8088b.this.l;
                requestData2.upsTimeTraceBean.startTrace();
                try {
                    context2 = C8088b.this.o;
                    requestParams = C8088b.this.g;
                    z2 = C8088b.this.n;
                    String a4 = C8083a.a(context2, requestParams, z2);
                    C8088b c8088b = C8088b.this;
                    requestParams2 = c8088b.g;
                    a = c8088b.a(requestParams2, a4);
                    requestData4 = C8088b.this.l;
                    requestData4.upsTimeTraceBean.traceTimeGetCkey();
                    if (TextUtils.isEmpty(a)) {
                        Logger.d("UpsGetRequest", "invalid url");
                        interfaceC8087a3 = C8088b.this.i;
                        requestData34 = C8088b.this.l;
                        interfaceC8087a3.onFailure(new C8085a(28001, "invalid url", requestData34));
                        return;
                    }
                    Logger.d("UpsPlayer", "ups url=" + a);
                    requestData5 = C8088b.this.l;
                    requestData5.url = a;
                    requestData6 = C8088b.this.l;
                    a2 = C8088b.this.a(a4);
                    requestData6.mTopUpsRequest = a2;
                    requestData7 = C8088b.this.l;
                    requestData7.upsType = 1;
                    requestData8 = C8088b.this.l;
                    str3 = C8088b.this.j;
                    requestData8.host = str3;
                    requestData9 = C8088b.this.l;
                    str22 = C8088b.this.k;
                    requestData9.ip = str22;
                    networkParameter = C8088b.this.f;
                    if (networkParameter != null) {
                        requestData30 = C8088b.this.l;
                        networkParameter2 = C8088b.this.f;
                        requestData30.cookie = networkParameter2.cookie;
                        requestData31 = C8088b.this.l;
                        networkParameter3 = C8088b.this.f;
                        requestData31.agent = networkParameter3.userAgent;
                        requestData32 = C8088b.this.l;
                        networkParameter4 = C8088b.this.f;
                        requestData32.connect_timeout = networkParameter4.connect_timeout;
                        requestData33 = C8088b.this.l;
                        networkParameter5 = C8088b.this.f;
                        requestData33.read_timeout = networkParameter5.read_timeout;
                    }
                    requestData10 = C8088b.this.l;
                    if (requestData10.connect_timeout == 0) {
                        requestData29 = C8088b.this.l;
                        requestData29.connect_timeout = 15000;
                    }
                    requestData11 = C8088b.this.l;
                    if (requestData11.read_timeout == 0) {
                        requestData28 = C8088b.this.l;
                        requestData28.read_timeout = 15000;
                    }
                    Logger.d("UpsGetRequest", "run start");
                    PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
                    upsRequest.beginSection("apiRequest");
                    requestData12 = C8088b.this.l;
                    if (requestData12 != null) {
                        requestData26 = C8088b.this.l;
                        if (requestData26.upsTimeTraceBean != null) {
                            requestData27 = C8088b.this.l;
                            requestData27.upsTimeTraceBean.traceTimeStartRequest();
                        }
                    }
                    iNetworkTask2 = C8088b.this.e;
                    requestData13 = C8088b.this.l;
                    GetInfoResult data = iNetworkTask2.getData(requestData13);
                    upsRequest.endSection();
                    requestData14 = C8088b.this.l;
                    if (requestData14 != null) {
                        requestData24 = C8088b.this.l;
                        if (requestData24.upsTimeTraceBean != null) {
                            requestData25 = C8088b.this.l;
                            requestData25.upsTimeTraceBean.traceTimeStartParseResult();
                        }
                    }
                    a3 = C8088b.this.a(data);
                    requestData15 = C8088b.this.l;
                    if (requestData15 != null) {
                        requestData19 = C8088b.this.l;
                        if (requestData19.upsTimeTraceBean != null) {
                            requestData20 = C8088b.this.l;
                            requestData20.upsTimeTraceBean.traceTimeEndParse();
                            StringBuilder sb = new StringBuilder();
                            requestData21 = C8088b.this.l;
                            sb.append(requestData21.vid);
                            sb.append(" total ups parse cost:");
                            requestData22 = C8088b.this.l;
                            sb.append(requestData22.upsTimeTraceBean.timeEndParse);
                            sb.append("; compress:");
                            requestData23 = C8088b.this.l;
                            sb.append(requestData23.compress);
                            Logger.d("UpsPlayer", sb.toString());
                        }
                    }
                    if (a3 != null) {
                        C8088b.this.a(a3, data);
                    }
                    Logger.d("UpsPlayer", "call back result");
                    requestData16 = C8088b.this.l;
                    if (requestData16 != null) {
                        requestData17 = C8088b.this.l;
                        if (requestData17.upsTimeTraceBean != null) {
                            ConnectStat connectStat = data.connectStat;
                            requestData18 = C8088b.this.l;
                            connectStat.mUpsTimeTraceBean = requestData18.upsTimeTraceBean;
                            data.connectStat.rawUpsData = data.data;
                        }
                    }
                    C8086b c8086b = new C8086b(a3);
                    interfaceC8087a2 = C8088b.this.i;
                    interfaceC8087a2.onSuccess(c8086b, data.connectStat);
                    Logger.d("UpsGetRequest", "run finish");
                } catch (AntiTheftChainException e) {
                    String str32 = "ckey构建失败：" + e.getMessage();
                    interfaceC8087a = C8088b.this.i;
                    int errorCode = e.getErrorCode();
                    requestData3 = C8088b.this.l;
                    interfaceC8087a.onFailure(new C8085a(errorCode, str32, requestData3));
                }
            }
        };
        this.o = context;
        this.e = iNetworkTask;
        this.n = z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("/")) {
            String str3 = this.j;
            str = str3.substring(0, str3.length() - 1);
        }
        this.a = str;
        this.j = Uri.parse(str).getHost();
        this.k = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MTopUpsRequest a(String str) {
        MTopUpsRequest mTopUpsRequest = new MTopUpsRequest();
        mTopUpsRequest.API_NAME = "mtop.youku.play.ups.appinfo.get";
        mTopUpsRequest.VERSION = "1.1";
        mTopUpsRequest.NEED_ECODE = true;
        a(mTopUpsRequest, str);
        return mTopUpsRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoInfo a(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        int i;
        Logger.d("UpsGetRequest", "processData");
        VideoInfo videoInfo = null;
        if (getInfoResult == null || getInfoResult.connectStat == null) {
            return null;
        }
        Logger.d("UpsGetRequest", "http connect=" + getInfoResult.connectStat.connect_success + " response code=" + getInfoResult.connectStat.response_code);
        StringBuilder sb = new StringBuilder();
        sb.append("http result data =");
        sb.append(getInfoResult.data);
        Logger.d("UpsGetRequest", sb.toString());
        if (getInfoResult.connectStat.connect_success) {
            try {
                if (TextUtils.isEmpty(getInfoResult.data)) {
                    return null;
                }
                videoInfo = ParseResult.parseData(getInfoResult.data);
                videoInfo.setStream(a(videoInfo.getStreamJson()));
                return videoInfo;
            } catch (Exception e) {
                Logger.e("UpsGetRequest", e.toString());
                String str = getInfoResult.data;
                if (str != null) {
                    if (str.contains("yk_web_anti_flow_limit_captcha_20171111")) {
                        connectStat = getInfoResult.connectStat;
                        connectStat.connect_success = false;
                        i = ErrorConstants.ERROR_UPS_WEB_ANTI;
                    } else if (!getInfoResult.data.contains("yk_web_anti_flow_limit_wait_20171111")) {
                        return videoInfo;
                    } else {
                        connectStat = getInfoResult.connectStat;
                        connectStat.connect_success = false;
                        i = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                    }
                    connectStat.response_code = i;
                    return videoInfo;
                }
                return videoInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(RequestParams requestParams, String str) {
        StringBuilder sb = new StringBuilder(this.a);
        sb.append("/ups/get.json?");
        C8084b.a(sb, "ckey", str);
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                C8084b.a(sb, key, value);
            }
        }
        RequestParams requestParams2 = this.h;
        if (requestParams2 != null) {
            for (String str2 : requestParams2.keySet()) {
                String str3 = (String) requestParams2.get(str2);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    C8084b.a(sb, str2, str3);
                }
            }
        }
        return sb.toString();
    }

    private void a(MTopUpsRequest mTopUpsRequest, String str) {
        RequestParams requestParams = this.g;
        mTopUpsRequest.stealParamsMap.put("ckey", str);
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ip, requestParams.get(RequestParams.client_ip));
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ts, requestParams.get(RequestParams.client_ts));
        mTopUpsRequest.stealParamsMap.put(RequestParams.utid, requestParams.get(RequestParams.utid));
        mTopUpsRequest.stealParamsMap.put("vid", requestParams.get("vid"));
        mTopUpsRequest.stealParamsMap.put("ccode", requestParams.get("ccode"));
        if ("01010301".equals(requestParams.get("ccode")) && !TextUtils.isEmpty(requestParams.get("p_device"))) {
            mTopUpsRequest.stealParamsMap.put("p_device", C8084b.b(requestParams.get("p_device")));
        }
        for (String str2 : requestParams.keySet()) {
            String str3 = requestParams.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                mTopUpsRequest.bizParamsMap.put(str2, str3);
            }
        }
        RequestParams requestParams2 = this.h;
        if (requestParams2 != null) {
            for (String str4 : requestParams2.keySet()) {
                String str5 = requestParams2.get(str4);
                if (!TextUtils.isEmpty(str5)) {
                    if (d.contains(str4)) {
                        str5 = C8084b.c(str5);
                    }
                    mTopUpsRequest.adParamsMap.put(str4, str5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(VideoInfo videoInfo, GetInfoResult getInfoResult) {
        UtAntiTheaftBean utAntiTheaftBean;
        int i;
        getInfoResult.connectStat.utMsg = new UtAntiTheaftBean();
        UtAntiTheaftBean utAntiTheaftBean2 = getInfoResult.connectStat.utMsg;
        RequestData requestData = this.l;
        utAntiTheaftBean2.ccode = requestData.ccode;
        utAntiTheaftBean2.ckey = requestData.ckey;
        utAntiTheaftBean2.isCkeyError = requestData.isCkeyError;
        utAntiTheaftBean2.ckeyErrorMsg = requestData.ckeyErrorMsg;
        if (videoInfo.getUps() != null) {
            getInfoResult.connectStat.utMsg.psid = videoInfo.getUps().psid;
            getInfoResult.connectStat.utMsg.upsClientNetip = videoInfo.getUps().ups_client_netip;
        } else {
            UtAntiTheaftBean utAntiTheaftBean3 = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean3.psid = null;
            utAntiTheaftBean3.upsClientNetip = null;
        }
        if (videoInfo.getVideo() != null) {
            getInfoResult.connectStat.utMsg.title = C8084b.b(videoInfo.getVideo().title);
        } else {
            getInfoResult.connectStat.utMsg.title = null;
        }
        if (videoInfo.getUser() != null) {
            getInfoResult.connectStat.utMsg.uid = videoInfo.getUser().uid.isEmpty() ? null : videoInfo.getUser().uid;
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            i = videoInfo.getUser().vip;
        } else {
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean.uid = null;
            i = 0;
        }
        utAntiTheaftBean.vip = i;
        ConnectStat connectStat = getInfoResult.connectStat;
        UtAntiTheaftBean utAntiTheaftBean4 = connectStat.utMsg;
        RequestData requestData2 = this.l;
        utAntiTheaftBean4.utid = requestData2.utid;
        utAntiTheaftBean4.vid = requestData2.vid;
        utAntiTheaftBean4.log_type = 5;
        utAntiTheaftBean4.clientid = requestData2.clientid;
        videoInfo.setConnectStat(connectStat);
    }

    private Stream[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        Stream[] streamArr = new Stream[size];
        for (int i = 0; i < size; i++) {
            streamArr[i] = (Stream) ((JSONObject) jSONArray.get(i)).toJavaObject(Stream.class);
        }
        return streamArr;
    }

    public void a(RequestParams requestParams, RequestParams requestParams2, NetworkParameter networkParameter, InterfaceC8087a<VideoInfo> interfaceC8087a) {
        Logger.d("UpsGetRequest", "getUrlInfo");
        this.l = new RequestData();
        if (networkParameter == null || requestParams == null) {
            Logger.d("UpsGetRequest", "invalid parameter");
            interfaceC8087a.onFailure(new C8085a(0, "invalid parameter", this.l));
            return;
        }
        this.g = requestParams;
        this.h = requestParams2;
        this.f = networkParameter;
        this.i = interfaceC8087a;
        m.submit(this.p);
    }
}
