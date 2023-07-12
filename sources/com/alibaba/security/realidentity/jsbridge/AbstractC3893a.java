package com.alibaba.security.realidentity.jsbridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.jsbridge.a */
/* loaded from: classes8.dex */
public abstract class AbstractC3893a {
    public static final String A = "useAlbum";
    public static final String B = "urlArray";
    public static final String C = "typeArray";
    public static final String D = "errorCode";
    public static final String E = "localModelPath";
    public static final String F = "auditStatus";
    public static final String G = "clientType";
    public static final String H = "appInfo";
    public static final String I = "deviceInfo";
    public static final String J = "FilterName";
    public static final String K = "imageList";
    public static final String L = "pageName";
    public static final String M = "eventId";
    public static final String N = "photoType";
    public static final String O = "ossUploadToken";
    public static final String P = "key";
    public static final String Q = "secret";
    public static final String R = "token";
    public static final String S = "expired";
    public static final String T = "endPoint";
    public static final String U = "bucket";
    public static final String V = "path";
    public static final String W = "gestureUrl";
    public static final String X = "callBackPhoto_";
    public static final String Y = "urlPhoto";
    public static final String Z = "photoSource";
    protected static final String a = "AbsJavaScriptExecuter";
    public static final String aa = "totalBytesSent";
    public static final String ab = "totalBytesExpectedToSend";
    public static final String ac = "nameCancel";
    public static final String ad = "skinInfo";
    public static final String ae = "sensorInfo";
    public static final String af = "exitInfo";
    public static final String ag = "INPUT_PARAM_ERROR";
    public static final String ah = "PARAMS_MISSING";
    public static final String ai = "WirelessH5";
    public static final String aj = "NO_PHOTO";
    public static final String ak = "success";
    public static final String al = "NO_PERMISSION";
    public static final String am = "NO_SDK_INIT";
    protected static Bitmap ap = null;
    protected static ThreadPoolExecutor aq = null;
    protected static final String b = "NO_INFO";
    protected static final String c = "UNKNOWN_ERROR";
    public static final String d = "verifyToken";
    public static final String e = "navTitle";
    public static final String f = "clientInfo";
    public static final String g = "errorMsg";
    public static final String h = "message";
    public static final String i = "url";
    public static final String j = "method";
    public static final String k = "params";
    public static final String l = "response";
    public static final String m = "status";
    public static final String n = "code";
    public static final String o = "mainCode";
    public static final String p = "subCode";
    public static final String q = "display";
    public static final String r = "photoId";
    public static final String s = "wuaToken";
    public static final String t = "rpSdkName";
    public static final String u = "rpSdkVersion";
    public static final String v = "livenessSdkName";
    public static final String w = "livenessSdkVersion";
    public static final String x = "sdkNoUI";
    public static final String y = "takePhotoType";
    public static final String z = "gestureUrlArray";
    public AbstractC3907h an;
    public Context ao;
    protected HandlerC3894a ar = new HandlerC3894a(this);
    private String as;
    private long at;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.jsbridge.a$a */
    /* loaded from: classes8.dex */
    static class HandlerC3894a extends Handler {
        private final AbstractC3893a a;

        public HandlerC3894a(AbstractC3893a abstractC3893a) {
            super(Looper.getMainLooper());
            this.a = abstractC3893a;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            this.a.b(message);
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.jsbridge.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-js-executor");
            }
        });
        aq = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void b(String str) {
        C3847g.C3848a.a.a(TrackLog.createSdkExceptionLog(str, "", ""));
    }

    protected abstract String a();

    public final boolean a(Context context, String str, AbstractC3907h abstractC3907h) {
        this.an = abstractC3907h;
        this.as = str;
        this.at = System.currentTimeMillis();
        this.ao = context;
        return a(str, abstractC3907h);
    }

    protected abstract boolean a(String str, AbstractC3907h abstractC3907h);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Message message) {
    }

    protected boolean b() {
        return true;
    }

    protected boolean c() {
        return true;
    }

    public final void a(WVResult wVResult, boolean z2) {
        if (c()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer(C3834a.C3835a.a);
            trackLog.setService(C3834a.C3837c.d);
            trackLog.setMethod(a());
            trackLog.setParams(this.as);
            trackLog.setMsg("");
            trackLog.setRt(System.currentTimeMillis() - this.at);
            if (wVResult != null) {
                trackLog.setResult(wVResult.toJsonString());
            } else {
                trackLog.setResult("result is null");
            }
            trackLog.setCode(z2 ? 0 : -1);
            C3847g.C3848a.a.a(trackLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        if (c()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer(C3834a.C3835a.a);
            trackLog.setService(C3834a.C3837c.d);
            trackLog.setMethod(a());
            trackLog.setParams(this.as);
            trackLog.setMsg("");
            trackLog.setRt(System.currentTimeMillis() - this.at);
            trackLog.setResult(str);
            trackLog.setCode(0);
            C3847g.C3848a.a.a(trackLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Message message) {
        HandlerC3894a handlerC3894a = this.ar;
        if (handlerC3894a != null) {
            handlerC3894a.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2) {
        C3847g.C3848a.a.a(TrackLog.createSdkExceptionLog(str, str2, ""));
    }

    public static void a(String str, Exception exc) {
        C3847g.C3848a.a.a(TrackLog.createSdkExceptionLog(str, C3805b.a(exc), ""));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static WVResult a(AbstractC3907h abstractC3907h) {
        WVResult wVResult = new WVResult();
        wVResult.addData("errorMsg", c);
        abstractC3907h.a(wVResult);
        return wVResult;
    }

    public static WVResult a(AbstractC3907h abstractC3907h, String str) {
        WVResult wVResult = new WVResult();
        wVResult.addData("errorMsg", str);
        abstractC3907h.a(wVResult);
        return wVResult;
    }

    private static void a(TrackLog trackLog) {
        C3847g.C3848a.a.a(trackLog);
    }
}
