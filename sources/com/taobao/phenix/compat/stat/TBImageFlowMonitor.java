package com.taobao.phenix.compat.stat;

import android.os.Build;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.phenix.cache.disk.OnlyCacheFailedException;
import com.taobao.phenix.decode.DecodeException;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.loader.network.IncompleteResponseException;
import com.taobao.phenix.loader.network.NetworkResponseException;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;
import tb.cg2;
import tb.h42;
import tb.jg1;
import tb.jn1;
import tb.op0;
import tb.rm2;
import tb.ur1;
import tb.vj2;
import tb.xt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBImageFlowMonitor extends vj2 implements Pexode.ForcedDegradationListener, ImageFlowMonitor, PairingThrottlingScheduler.DegradationListener {
    private boolean c;
    private boolean d;
    private final NetworkAnalyzer e;
    private boolean f;
    private NavigationInfoObtainer g;
    private NonCriticalErrorReporter h;
    private int i;
    protected int j;
    private int k;
    private TBImageRetrieveABListener l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ImageSizeWarningException extends NetworkResponseException {
        private static int sImageWarningSize;
        private final int exceededTimes;

        public ImageSizeWarningException(int i) {
            super(200, "image size[" + i + "] exceeded " + (i / sImageWarningSize) + " times");
            this.exceededTimes = i / sImageWarningSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ImageSizeWarningException newWarningExceptionIfExceeded(int i) {
            int i2 = sImageWarningSize;
            if (i2 <= 0 || i < i2) {
                return null;
            }
            return new ImageSizeWarningException(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.phenix.compat.stat.TBImageFlowMonitor$a */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class C6857a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageStatistics.FromType.values().length];
            a = iArr;
            try {
                iArr[ImageStatistics.FromType.FROM_LOCAL_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageStatistics.FromType.FROM_DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageStatistics.FromType.FROM_LARGE_SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageStatistics.FromType.FROM_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TBImageFlowMonitor(int i, int i2, NetworkAnalyzer networkAnalyzer, TBImageRetrieveABListener tBImageRetrieveABListener) {
        this.e = networkAnalyzer;
        this.j = i;
        this.k = i2;
        this.l = tBImageRetrieveABListener;
    }

    private void D(ImageStatistics imageStatistics) {
        if (imageStatistics == null || imageStatistics.i() == null) {
            return;
        }
        try {
            Map<String, Integer> e = imageStatistics.e();
            String str = imageStatistics.i().get("DXImageViewOnCreateTimestampKey");
            String str2 = imageStatistics.i().get("DXImageViewOnRenderTimestampKey");
            String str3 = imageStatistics.i().get("DXImageViewIsReuseKey");
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            boolean booleanValue = Boolean.valueOf(str3).booleanValue();
            long longValue = Long.valueOf(str).longValue();
            long longValue2 = Long.valueOf(str2).longValue();
            long n = imageStatistics.n();
            if (booleanValue) {
                longValue = longValue2;
            }
            int i = longValue > 0 ? (int) (n - longValue) : 0;
            int o = o(e, ImageStatistics.KEY_TOTAL_TIME) + i;
            e.put("processTimeOfContainer", Integer.valueOf(i));
            e.put("totalTimeOfContainer", Integer.valueOf(o));
            e.put("isReuseOfContainer", Integer.valueOf(booleanValue ? 1 : 0));
        } catch (Exception unused) {
        }
    }

    private int E(MeasureValueSet measureValueSet, String str, Map<String, Integer> map) {
        Integer num = map.get(str);
        if (num != null) {
            measureValueSet.setValue(str, num.intValue());
            return num.intValue();
        }
        return 0;
    }

    private String g(Throwable th) {
        if (th instanceof IncompleteResponseException) {
            return "101010";
        }
        if (th instanceof HttpCodeResponseException) {
            int httpCode = ((HttpCodeResponseException) th).getHttpCode();
            return httpCode == 404 ? "102010" : httpCode == 503 ? "103010" : "104000";
        }
        if (th instanceof ImageSizeWarningException) {
            int i = ((ImageSizeWarningException) th).exceededTimes;
            if (i >= 1 && i < 2) {
                return "801010";
            }
            if (i >= 2 && i < 4) {
                return "801020";
            }
            if (i >= 4) {
                return "801090";
            }
        }
        NetworkAnalyzer networkAnalyzer = this.e;
        if (networkAnalyzer == null) {
            return null;
        }
        if (networkAnalyzer.isReadTimeoutException(th)) {
            return "101011";
        }
        if (this.e.isCertificateException(th)) {
            return "103011";
        }
        if (this.e.isInvalidHostException(th)) {
            return "201010";
        }
        if (this.e.isConnectTimeoutException(th)) {
            return "201011";
        }
        if (this.e.isInvalidUrlException(th)) {
            return "201012";
        }
        if (this.e.isIndifferentException(th)) {
            return "901000";
        }
        if (th instanceof DecodeException) {
            DecodeException decodeException = (DecodeException) th;
            return decodeException.getDecodedError() + "[Local?" + decodeException.isLocalUri() + ", Disk?" + decodeException.isDataFromDisk() + jn1.ARRAY_END_STR;
        }
        return null;
    }

    private String h(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 256 ? str.substring(0, 256) : str;
    }

    private void i(String str, int i, int i2, String str2) {
        for (int i3 = 0; i3 < i; i3++) {
            if (str2 == null) {
                AppMonitor.Alarm.commitSuccess("ImageLib_Rx", str);
            } else {
                AppMonitor.Alarm.commitSuccess("ImageLib_Rx", str, str2);
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (str2 == null) {
                AppMonitor.Alarm.commitFail("ImageLib_Rx", str, null, null);
            } else {
                AppMonitor.Alarm.commitFail("ImageLib_Rx", str, str2, null, null);
            }
        }
    }

    private boolean j(ImageStatistics imageStatistics, int i, String str) {
        if (!cg2.a || imageStatistics == null || TextUtils.isEmpty(imageStatistics.q)) {
            return false;
        }
        boolean z = imageStatistics.y;
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.ret = i;
        requestInfo.bizId = imageStatistics.r;
        if (str == null) {
            str = "";
        }
        requestInfo.bizErrorCode = str;
        if (imageStatistics.i() != null) {
            String str2 = imageStatistics.i().get("eagleid");
            requestInfo.serverTraceId = str2 != null ? str2 : "";
        }
        if (imageStatistics.k() != ImageStatistics.FromType.FROM_NETWORK) {
            requestInfo.protocolType = "cache";
            if (imageStatistics.k() == ImageStatistics.FromType.FROM_DISK_CACHE || imageStatistics.k() == ImageStatistics.FromType.FROM_LOCAL_FILE) {
                requestInfo.rspDeflateSize = imageStatistics.x;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[traceId:");
            sb.append(imageStatistics.q);
            sb.append(jn1.ARRAY_END_STR);
            sb.append("|end");
            sb.append(",ret=");
            sb.append(i);
            Map<String, Integer> e = imageStatistics.e();
            if (e != null) {
                sb.append(",totalTime=");
                sb.append(o(e, ImageStatistics.KEY_TOTAL_TIME));
                sb.append(",wait2Main=");
                sb.append(o(e, ImageStatistics.KEY_WAIT_FOR_MAIN));
                int o = o(e, ImageStatistics.KEY_SCHEDULE_TIME);
                sb.append(",scheduleTime=");
                sb.append(o);
                sb.append(",decodeTime=");
                sb.append(o(e, ImageStatistics.KEY_BITMAP_DECODE));
                sb.append(",networkConnect=");
                sb.append(o(e, "connect"));
                sb.append(",networkDownload=");
                sb.append(o(e, "download"));
                sb.append(",cacheLookup=");
                sb.append(o(e, ImageStatistics.KEY_READ_DISK_CACHE));
                sb.append(",memoryLookup=");
                sb.append(o(e, ImageStatistics.KEY_READ_MEMORY_CACHE));
                int o2 = o(e, "totalTimeOfContainer");
                if (o2 > 0) {
                    sb.append(",processTimeOfContainer=");
                    sb.append(o(e, "processTimeOfContainer"));
                    sb.append(",totalTimeOfContainer=");
                    sb.append(o2);
                    sb.append(",dxIsReuse=");
                    sb.append(o(e, "isReuseOfContainer"));
                }
                if (o > 5000 && ur1.o().schedulerBuilder().c()) {
                    sb.append("|");
                    sb.append(ur1.o().schedulerBuilder().build().forDecode().getStatus());
                }
            }
            op0.d(imageStatistics, sb.toString());
        }
        Map<String, Integer> e2 = imageStatistics.e();
        if (e2 != null && e2.containsKey(ImageStatistics.KEY_BITMAP_DECODE)) {
            requestInfo.deserializeTime = e2.get(ImageStatistics.KEY_BITMAP_DECODE).intValue();
        }
        requestInfo.url = imageStatistics.p().k();
        requestInfo.bizReqStart = imageStatistics.n();
        requestInfo.bizReqProcessStart = imageStatistics.s;
        requestInfo.bizRspProcessStart = imageStatistics.t;
        requestInfo.bizRspCbDispatch = imageStatistics.u;
        requestInfo.bizRspCbStart = imageStatistics.v;
        requestInfo.bizRspCbEnd = imageStatistics.w;
        requestInfo.pTraceId = s(imageStatistics.i());
        FullTraceAnalysis.getInstance().commitRequest(imageStatistics.q, "picture", requestInfo);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ImageStatistics imageStatistics) {
        if (cg2.a) {
            j(imageStatistics, 2, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ImageStatistics imageStatistics, Throwable th) {
        NetworkAnalyzer networkAnalyzer;
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj2;
        String str7;
        Throwable th2;
        String str8;
        char c;
        char c2;
        String str9;
        String str10;
        String str11;
        DecodeException decodeException;
        NetworkAnalyzer networkAnalyzer2;
        if (j(imageStatistics, 0, p(th))) {
            return;
        }
        if (imageStatistics != null && !imageStatistics.q() && !(th instanceof OnlyCacheFailedException) && ((networkAnalyzer = this.e) == null || !networkAnalyzer.isNoNetworkException(th))) {
            y(imageStatistics);
            String k = imageStatistics.p().k();
            boolean z = th instanceof NetworkResponseException;
            boolean z2 = th instanceof DecodeException;
            String q = q(k);
            String n = n(imageStatistics.i());
            MimeType j = imageStatistics.j();
            String b = j != null ? j.b() : "unknown";
            String t = t(imageStatistics.i());
            if ((th instanceof ImageSizeWarningException) || a(this.j)) {
                obj = "domain";
                str = q;
            } else {
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                create.setValue("domain", q);
                obj = "domain";
                str = q;
                create.setValue("error", "1");
                create.setValue("bizName", n);
                create.setValue("format", b);
                create.setValue("dataFrom", "0");
                create.setValue("pageURL", t);
                create.setValue("hasIcc", imageStatistics.C ? "1" : "0");
                AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlow", create, create2);
                if (cg2.a && SceneIdentifier.getDeviceLevel() == 3) {
                    AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlowForLowDevice", create, create2);
                }
            }
            NavigationInfoObtainer navigationInfoObtainer = this.g;
            if (navigationInfoObtainer != null) {
                str2 = navigationInfoObtainer.getCurrentWindowName();
                str3 = this.g.getCurrentUrl();
            } else {
                str2 = null;
                str3 = null;
            }
            if (z || z2) {
                String g = g(th);
                if (g != null) {
                    v();
                    DimensionValueSet create3 = DimensionValueSet.create();
                    MeasureValueSet create4 = MeasureValueSet.create();
                    str6 = k;
                    create3.setValue("url", str6);
                    create3.setValue("bizName", n);
                    obj2 = "bizName";
                    create3.setValue("analysisErrorCode", g);
                    str5 = g;
                    str4 = n;
                    if (z) {
                        create3.setValue("originErrorCode", String.valueOf(((NetworkResponseException) th).getHttpCode()));
                        create3.setValue(SocialConstants.PARAM_APP_DESC, "analysisReason::" + th.getMessage());
                    } else {
                        create3.setValue("originErrorCode", "200");
                        create3.setValue(SocialConstants.PARAM_APP_DESC, "analysisReason::" + th.toString());
                    }
                    create3.setValue("format", b);
                    create3.setValue("dataFrom", String.valueOf(imageStatistics.k().value));
                    create3.setValue("originUrl", r(imageStatistics.i()));
                    if (str2 != null || str3 != null) {
                        create3.setValue("windowName", str2);
                        create3.setValue("naviUrl", str3);
                    }
                    create3.setValue("pageURL", t);
                    AppMonitor.Stat.commit("ImageLib_Rx", "ImageError", create3, create4);
                } else {
                    str4 = n;
                    str5 = g;
                    str6 = k;
                    obj2 = "bizName";
                }
                str7 = str5;
            } else {
                str4 = n;
                str6 = k;
                str7 = null;
                obj2 = "bizName";
            }
            if (z || a(this.k) || this.h == null) {
                th2 = th;
                str8 = "FlowMonitor";
                c = 0;
                c2 = 1;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("url", str6);
                hashMap.put(obj, str);
                hashMap.put("format", b);
                hashMap.put(obj2, str4);
                hashMap.put("size", Integer.valueOf(imageStatistics.o()));
                hashMap.put("windowName", str2);
                hashMap.put("naviUrl", str3);
                hashMap.put("isRetrying", Boolean.valueOf(imageStatistics.r()));
                hashMap.put("supportAshmem", Boolean.valueOf(Pexode.j()));
                hashMap.put("supportInBitmap", Boolean.valueOf(Pexode.l()));
                hashMap.put("degradationBits", Integer.valueOf(this.i));
                hashMap.put("statusOfTBReal", ur1.o().schedulerBuilder().build().forCpuBound().getStatus());
                hashMap.put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
                Map<String, String> i = imageStatistics.i();
                if (i == null || (networkAnalyzer2 = this.e) == null) {
                    str9 = null;
                    str10 = null;
                    str11 = null;
                } else {
                    str11 = i.get(networkAnalyzer2.keyOfCdnIpPort());
                    str10 = i.get(this.e.keyOfConnectType());
                    str9 = i.get(this.e.keyOfHitCdnCache());
                }
                if (str11 == null) {
                    str11 = "";
                }
                hashMap.put("cdnIpPort", str11);
                if (str10 == null) {
                    str10 = "";
                }
                hashMap.put("connectType", str10);
                if (str9 == null) {
                    str9 = "";
                }
                hashMap.put("hitCdnCache", str9);
                String a = h42.a(th.getClass());
                th2 = th;
                if (th2 instanceof DecodeException) {
                    a = a + ":" + decodeException.getDecodedError() + "[Local?" + decodeException.isLocalUri() + ", Disk?" + decodeException.isDataFromDisk() + jn1.ARRAY_END_STR;
                    Throwable cause = ((DecodeException) th2).getCause();
                    if (cause != null) {
                        str7 = a;
                        th2 = cause;
                        this.h.onNonCriticalErrorHappen(str7, th2, hashMap);
                        c = 0;
                        c2 = 1;
                        str8 = "FlowMonitor";
                        xt2.i(str8, "report non-critical error, details=%s, path=%s", hashMap, str6);
                    }
                }
                str7 = a;
                this.h.onNonCriticalErrorHappen(str7, th2, hashMap);
                c = 0;
                c2 = 1;
                str8 = "FlowMonitor";
                xt2.i(str8, "report non-critical error, details=%s, path=%s", hashMap, str6);
            }
            Object[] objArr = new Object[5];
            objArr[c] = str7;
            objArr[c2] = th2;
            objArr[2] = str2;
            objArr[3] = str3;
            objArr[4] = str6;
            xt2.i(str8, "commit complete onFail, analysisCode=%s, throwable=%s, window=%s, navi=%s, path=%s", objArr);
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = imageStatistics;
        objArr2[1] = imageStatistics != null ? imageStatistics.p().k() : "unknown";
        xt2.a("FlowMonitor", "skipped commit onFail, statistics=%s, path=%s", objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(com.taobao.phenix.request.ImageStatistics r26) {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.phenix.compat.stat.TBImageFlowMonitor.m(com.taobao.phenix.request.ImageStatistics):void");
    }

    private String n(Map<String, String> map) {
        String str;
        return (map == null || (str = map.get("bundle_biz_code")) == null) ? "" : str;
    }

    private int o(Map<String, Integer> map, String str) {
        if (map == null || !map.containsKey(str)) {
            return 0;
        }
        return map.get(str).intValue();
    }

    private static String q(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(WVUtils.URL_SEPARATOR)) {
            i = 2;
        } else {
            int indexOf = str.indexOf(jg1.SCHEME_SLASH);
            i = indexOf < 0 ? 0 : indexOf + 3;
        }
        if (i >= str.length()) {
            return "";
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 < 0) {
            indexOf2 = str.length();
        }
        String substring = str.substring(i, indexOf2);
        return (substring.contains(jn1.BLOCK_START_STR) || substring.contains(",") || !substring.contains(".")) ? "" : substring;
    }

    private String r(Map<String, String> map) {
        String str;
        return (map == null || (str = map.get("origin_url")) == null) ? "" : str;
    }

    private String s(Map<String, String> map) {
        String str;
        return (map == null || (str = map.get("p_trace_id")) == null) ? "" : str;
    }

    private String t(Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("pageURL")) == null || TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(63, 0);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    private synchronized void w() {
        if (this.d) {
            return;
        }
        DimensionSet create = DimensionSet.create();
        create.addDimension("bizName");
        create.addDimension("pageName");
        create.addDimension("pageURL");
        create.addDimension("originalURL");
        create.addDimension("errorCode");
        AppMonitor.register("ImageLib_Rx", "InvalidParam", (MeasureSet) null, create);
        this.d = true;
    }

    private synchronized void x() {
        if (this.c) {
            return;
        }
        xt2.a("FlowMonitor", "TTL exception register start", new Object[0]);
        DimensionSet create = DimensionSet.create();
        create.addDimension("url");
        create.addDimension("eagleId");
        create.addDimension("maxAge");
        AppMonitor.register("ImageLib_Rx", "ImageTTLException", (MeasureSet) null, create);
        this.c = true;
        xt2.a("FlowMonitor", "TTL exception register end", new Object[0]);
    }

    private void y(ImageStatistics imageStatistics) {
        int i;
        if (!this.d) {
            w();
        }
        if (imageStatistics != null) {
            String h = h(r(imageStatistics.i()));
            String h2 = h(imageStatistics.p().k());
            if (TextUtils.isEmpty(h) && TextUtils.isEmpty(h2)) {
                i = 0;
            } else {
                i = (TextUtils.isEmpty(h) || !h.equals(h2)) ? -1 : 1;
            }
            if (i == -1) {
                return;
            }
            DimensionValueSet create = DimensionValueSet.create();
            MeasureValueSet create2 = MeasureValueSet.create();
            create.setValue("bizName", imageStatistics.r);
            NavigationInfoObtainer navigationInfoObtainer = this.g;
            if (navigationInfoObtainer != null) {
                create.setValue("pageName", navigationInfoObtainer.getCurrentWindowName());
                create.setValue("pageURL", this.g.getCurrentUrl());
            }
            create.setValue("originalURL", h);
            create.setValue("errorCode", String.valueOf(i));
            AppMonitor.Stat.commit("ImageLib_Rx", "InvalidParam", create, create2);
        }
    }

    private void z(ImageStatistics imageStatistics) {
        if (imageStatistics.B) {
            if (!this.c) {
                x();
            }
            if (imageStatistics.i() == null || TextUtils.isEmpty(imageStatistics.i().get("max-age"))) {
                return;
            }
            String h = h(imageStatistics.p().k());
            DimensionValueSet create = DimensionValueSet.create();
            MeasureValueSet create2 = MeasureValueSet.create();
            create.setValue("maxAge", imageStatistics.i().get("max-age"));
            create.setValue("eagleId", imageStatistics.i().get("eagleid"));
            create.setValue("url", h);
            AppMonitor.Stat.commit("ImageLib_Rx", "ImageTTLException", create, create2);
        }
    }

    public void A(int i) {
        int unused = ImageSizeWarningException.sImageWarningSize = i;
        xt2.f("FlowMonitor", "set image warning size=%d", Integer.valueOf(i));
    }

    public void B(NavigationInfoObtainer navigationInfoObtainer) {
        this.g = navigationInfoObtainer;
        xt2.f("FlowMonitor", "set navigation info obtainer=%s", navigationInfoObtainer);
    }

    public void C(NonCriticalErrorReporter nonCriticalErrorReporter) {
        this.h = nonCriticalErrorReporter;
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public int getMinimumScheduleTime2StatWaitSize() {
        return 150;
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onCancel(final ImageStatistics imageStatistics) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageFlowMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                TBImageFlowMonitor.this.k(imageStatistics);
            }
        });
    }

    @Override // com.taobao.rxm.schedule.PairingThrottlingScheduler.DegradationListener
    public void onDegrade2Unlimited() {
        this.i = (this.i & (-9)) + 8;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2UnlimitedNetwork", 1.0d);
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onFail(final ImageStatistics imageStatistics, final Throwable th) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageFlowMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                TBImageFlowMonitor.this.l(imageStatistics, th);
            }
        });
    }

    @Override // com.taobao.pexode.Pexode.ForcedDegradationListener
    public void onForcedDegrade2NoAshmem() {
        this.i = (this.i & (-3)) + 2;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2NoAshmem", 1.0d);
    }

    @Override // com.taobao.pexode.Pexode.ForcedDegradationListener
    public void onForcedDegrade2NoInBitmap() {
        this.i = (this.i & (-5)) + 4;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2NoInBitmap", 1.0d);
    }

    @Override // com.taobao.pexode.Pexode.ForcedDegradationListener
    public void onForcedDegrade2System() {
        this.i = (this.i & (-2)) + 1;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2System", 1.0d);
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onProcess(ImageStatistics imageStatistics, String str, String str2) {
        if (cg2.a) {
            try {
                String str3 = imageStatistics.q;
                if (TextUtils.isEmpty(str3)) {
                    str3 = FullTraceAnalysis.getInstance().createRequest("picture");
                    imageStatistics.q = str3;
                }
                FullTraceAnalysis.getInstance().log(str3, "picture", str, str2);
            } catch (Throwable th) {
                xt2.c("analysis.FullTraceAnalysis", "log " + imageStatistics.q + AVFSCacheConstants.COMMA_SEP + "picture" + AVFSCacheConstants.COMMA_SEP + str + AVFSCacheConstants.COMMA_SEP + str2 + AVFSCacheConstants.COMMA_SEP, th);
            }
        }
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onStart(ImageStatistics imageStatistics) {
        if (cg2.a && TextUtils.isEmpty(imageStatistics.q)) {
            imageStatistics.q = FullTraceAnalysis.getInstance().createRequest("picture");
        }
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onSuccess(final ImageStatistics imageStatistics) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageFlowMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                TBImageFlowMonitor.this.m(imageStatistics);
            }
        });
    }

    public String p(Throwable th) {
        return ((th instanceof DecodeException) || (th instanceof NetworkResponseException)) ? g(th) : "";
    }

    protected synchronized void u() {
        if (this.a) {
            return;
        }
        xt2.a("FlowMonitor", "image flow register start", new Object[0]);
        DimensionSet create = DimensionSet.create();
        create.addDimension("domain");
        create.addDimension("error");
        create.addDimension("bizName");
        create.addDimension("format");
        create.addDimension("dataFrom");
        create.addDimension("scheduleFactor");
        create.addDimension("hitCdnCache");
        create.addDimension("connectType");
        create.addDimension("cdnIpPort");
        create.addDimension("windowName");
        create.addDimension("naviUrl");
        create.addDimension("pageURL");
        create.addDimension("launchType");
        create.addDimension("appLaunchExternal");
        create.addDimension("sinceLastLaunchInternal");
        create.addDimension("sinceAppLaunchInterval");
        create.addDimension("deviceLevel");
        create.addDimension("bucketInfo");
        create.addDimension("yixiuBucket");
        create.addDimension("newThreadModel");
        create.addDimension("sdkInitTime");
        create.addDimension("requestStartTime");
        create.addDimension("RequestUrl");
        create.addDimension("originalUrl");
        create.addDimension("ttlExperimentId");
        create.addDimension("ttlGetTime");
        create.addDimension("ttlPutTime");
        create.addDimension("hasIcc");
        MeasureSet create2 = MeasureSet.create();
        b(create2, ImageStatistics.KEY_READ_MEMORY_CACHE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_READ_DISK_CACHE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_READ_LOCAL_FILE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, "connect", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, "download", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_BITMAP_DECODE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_BITMAP_SCALE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_SCHEDULE_TIME, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_WAIT_FOR_MAIN, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, ImageStatistics.KEY_TOTAL_TIME, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(60000.0d));
        b(create2, "size", Double.valueOf(0.0d), null, null);
        b(create2, "speed", Double.valueOf(0.0d), null, null);
        b(create2, ImageStatistics.KEY_MASTER_WAIT_SIZE, Double.valueOf(0.0d), null, null);
        b(create2, ImageStatistics.KEY_NETWORK_WAIT_SIZE, Double.valueOf(0.0d), null, null);
        b(create2, ImageStatistics.KEY_DECODE_WAIT_SIZE, Double.valueOf(0.0d), null, null);
        b(create2, "firstData", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, "sendBefore", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, "responseCode", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, IFullTraceAnalysisV3.Stage.SERVE_RT, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, "processTimeOfContainer", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
        b(create2, "totalTimeOfContainer", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(60000.0d));
        AppMonitor.register("ImageLib_Rx", "ImageFlow", create2, create);
        AppMonitor.register("ImageLib_Rx", "ImageFlowForLowDevice", create2, create);
        this.a = true;
        xt2.a("FlowMonitor", "image flow register end", new Object[0]);
    }

    public synchronized void v() {
        if (this.f) {
            return;
        }
        xt2.a("FlowMonitor", "image error register start", new Object[0]);
        DimensionSet create = DimensionSet.create();
        create.addDimension("url");
        create.addDimension("windowName");
        create.addDimension("naviUrl");
        create.addDimension("bizName");
        create.addDimension("analysisErrorCode");
        create.addDimension("originErrorCode");
        create.addDimension(SocialConstants.PARAM_APP_DESC);
        create.addDimension("format");
        create.addDimension("dataFrom");
        create.addDimension("originUrl");
        create.addDimension("pageURL");
        AppMonitor.register("ImageLib_Rx", "ImageError", (MeasureSet) null, create);
        this.f = true;
        xt2.a("FlowMonitor", "image error register end", new Object[0]);
    }
}
