package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.mapcore.util.AbstractC4517dp;
import com.amap.api.mapcore.util.C4554gc;
import com.amap.api.mapcore.util.Cif;
import com.amap.api.mapcore.util.eq;
import com.amap.api.mapcore.util.gf;
import com.amap.api.mapcore.util.gg;
import com.amap.api.mapcore.util.gm;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapEngine;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapLoader implements Cif.InterfaceC4587a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private static String mDiu;
    private Cif downloadManager;
    private volatile boolean isCanceled = false;
    public boolean isFinish = false;
    ADataRequestParam mDataRequestParam;
    private int mEngineID;
    GLMapEngine mGLMapEngine;
    private boolean mRequestCancel;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class AMapGridDownloadRequest extends AbstractC4517dp {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.mapcore.util.ii
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getIPV6URL() {
            return eq.a(getURL());
        }

        @Override // com.amap.api.mapcore.util.AbstractC4517dp, com.amap.api.mapcore.util.ii
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            gm e = eq.e();
            String b = e != null ? e.b() : null;
            String f = C4554gc.f(this.mContext);
            try {
                f = URLEncoder.encode(f, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put(IRequestConst.USER_AGENT, this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
            hashtable.put("x-INFO", gf.a(this.mContext));
            hashtable.put("key", f);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            return this.sUrl;
        }

        @Override // com.amap.api.mapcore.util.ii
        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(int i, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mEngineID = 0;
        this.mRequestCancel = false;
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i;
        this.mGLMapEngine = gLMapEngine;
        this.mRequestCancel = false;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String f = C4554gc.f(this.mGLMapEngine.getContext());
        try {
            f = URLEncoder.encode(f, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(f);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a = gf.a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + gf.a(context, a, sortReEncoderParams));
        stringBuffer.append("&dip=");
        stringBuffer.append("16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            hd.c(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            hd.c(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
                this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
            }
        }
    }

    public void doRequest() {
        if (this.mRequestCancel) {
            return;
        }
        ADataRequestParam aDataRequestParam = this.mDataRequestParam;
        String str = aDataRequestParam.requestBaseUrl;
        String str2 = aDataRequestParam.requestUrl;
        if (!str.endsWith("?")) {
            str = str + "?";
        }
        String requestParams = getRequestParams(str2.replaceAll(";", getEncodeRequestParams(";").toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mDataRequestParam.nRequestType == 0) {
            stringBuffer.append(requestParams);
            stringBuffer.append("&csid=" + UUID.randomUUID().toString());
        } else {
            stringBuffer.append("csid=" + UUID.randomUUID().toString());
        }
        try {
            AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
            aMapGridDownloadRequest.setConnectionTimeout(30000);
            aMapGridDownloadRequest.setSoTimeout(30000);
            if (this.mDataRequestParam.nRequestType != 0) {
                aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
            }
            Cif cif = new Cif(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
            this.downloadManager = cif;
            cif.a(this);
        } finally {
            try {
            } finally {
            }
        }
    }

    public String getDeviceId(Context context) {
        if (context != null) {
            return gg.w(context);
        }
        return null;
    }

    protected String getRequestParams(String str, boolean z, int i) {
        if (mDiu == null) {
            mDiu = getDeviceId(this.mGLMapEngine.getContext());
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
            stringBuffer.append("&diu=");
            stringBuffer.append(mDiu);
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
            stringBuffer.append("&diu=");
            stringBuffer.append(mDiu);
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onDownload(byte[] bArr, long j) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        if (bArr == null || (gLMapEngine = this.mGLMapEngine) == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onException(Throwable th) {
        ADataRequestParam aDataRequestParam;
        ADataRequestParam aDataRequestParam2;
        int indexOf;
        try {
            String str = new String(th.getMessage().getBytes("UTF-8"), "UTF-8");
            int parseInt = (TextUtils.isEmpty(str) || (indexOf = str.indexOf(NETWORK_RESPONSE_CODE_STRING)) == -1) ? -1 : Integer.parseInt(str.substring(indexOf + 8));
            GLMapEngine gLMapEngine = this.mGLMapEngine;
            if (gLMapEngine != null && (aDataRequestParam2 = this.mDataRequestParam) != null) {
                gLMapEngine.netError(this.mEngineID, aDataRequestParam2.handler, -1, parseInt);
            }
        } catch (Throwable unused) {
            GLMapEngine gLMapEngine2 = this.mGLMapEngine;
            if (gLMapEngine2 != null && (aDataRequestParam = this.mDataRequestParam) != null) {
                gLMapEngine2.netError(this.mEngineID, aDataRequestParam.handler, -1, -1);
            }
        }
        hd.c(th, "AMapLoader", "download onException");
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onFinish() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
    }

    @Override // com.amap.api.mapcore.util.Cif.InterfaceC4587a
    public void onStop() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.netStop(this.mEngineID, aDataRequestParam.handler, -1);
    }
}
