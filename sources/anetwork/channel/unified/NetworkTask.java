package anetwork.channel.unified;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import anet.channel.C0159a;
import anet.channel.C0162c;
import anet.channel.NoAvailStrategyException;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.SessionGetCallback;
import anet.channel.entity.ENV;
import anet.channel.fulltrace.C0179a;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.request.C0193a;
import anet.channel.request.Cancelable;
import anet.channel.session.HttpSession;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.C0242a;
import anetwork.channel.cache.Cache;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.http.NetworkSdkSetting;
import anetwork.channel.interceptor.Callback;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.ab2;
import tb.cf0;
import tb.h01;
import tb.he;
import tb.hu0;
import tb.jg1;
import tb.ln0;
import tb.o01;
import tb.qj1;
import tb.rj1;
import tb.x6;
import tb.z12;
import tb.zh2;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class NetworkTask implements IUnifiedTask {
    public static final int MAX_RSP_BUFFER_LENGTH = 131072;
    public static final String TAG = "anet.NetworkTask";
    String bizReqId;
    Cache cache;
    Cache.Entry entry;
    String f_refer;
    volatile AtomicBoolean isDone;
    C0254b rc;
    ByteArrayOutputStream cacheBuffer = null;
    volatile Cancelable cancelable = null;
    volatile boolean isCanceled = false;
    int contentLength = 0;
    int dataChunkIndex = 0;
    boolean isHeaderCallback = false;
    boolean isDataChuckCallback = false;
    C0251c responseBuffer = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.unified.NetworkTask$a */
    /* loaded from: classes.dex */
    public class C0249a implements SessionGetCallback {
        final /* synthetic */ RequestStatistic a;
        final /* synthetic */ long b;
        final /* synthetic */ C0193a c;
        final /* synthetic */ C0162c d;
        final /* synthetic */ o01 e;
        final /* synthetic */ boolean f;

        C0249a(RequestStatistic requestStatistic, long j, C0193a c0193a, C0162c c0162c, o01 o01Var, boolean z) {
            this.a = requestStatistic;
            this.b = j;
            this.c = c0193a;
            this.d = c0162c;
            this.e = o01Var;
            this.f = z;
        }

        @Override // anet.channel.SessionGetCallback
        public void onSessionGetFail() {
            ALog.e(NetworkTask.TAG, "onSessionGetFail", NetworkTask.this.rc.c, "url", this.a.url);
            this.a.connWaitTime = System.currentTimeMillis() - this.b;
            NetworkTask networkTask = NetworkTask.this;
            networkTask.sendRequest(networkTask.tryGetHttpSession(null, this.d, this.e, this.f), this.c);
        }

        @Override // anet.channel.SessionGetCallback
        public void onSessionGetSuccess(Session session) {
            ALog.f(NetworkTask.TAG, "onSessionGetSuccess", NetworkTask.this.rc.c, "Session", session);
            this.a.connWaitTime = System.currentTimeMillis() - this.b;
            this.a.spdyRequestSend = true;
            NetworkTask.this.sendRequest(session, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.unified.NetworkTask$b */
    /* loaded from: classes.dex */
    public class C0250b implements RequestCb {
        final /* synthetic */ C0193a a;
        final /* synthetic */ RequestStatistic b;

        C0250b(C0193a c0193a, RequestStatistic requestStatistic) {
            this.a = c0193a;
            this.b = requestStatistic;
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(he heVar, boolean z) {
            if (NetworkTask.this.isDone.get()) {
                return;
            }
            if (NetworkTask.this.rc.f == null || !NetworkTask.this.rc.f.isResponseReturn()) {
                NetworkTask networkTask = NetworkTask.this;
                if (networkTask.dataChunkIndex == 0) {
                    ALog.f(NetworkTask.TAG, "[onDataReceive] receive first data chunk!", networkTask.rc.c, new Object[0]);
                }
                if (z) {
                    ALog.f(NetworkTask.TAG, "[onDataReceive] receive last data chunk!", NetworkTask.this.rc.c, new Object[0]);
                }
                NetworkTask networkTask2 = NetworkTask.this;
                int i = networkTask2.dataChunkIndex + 1;
                networkTask2.dataChunkIndex = i;
                try {
                    C0251c c0251c = networkTask2.responseBuffer;
                    if (c0251c != null) {
                        c0251c.c.add(heVar);
                        if (this.b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z) {
                            NetworkTask networkTask3 = NetworkTask.this;
                            networkTask3.dataChunkIndex = networkTask3.responseBuffer.a(networkTask3.rc.b, networkTask3.contentLength);
                            NetworkTask networkTask4 = NetworkTask.this;
                            networkTask4.isHeaderCallback = true;
                            networkTask4.isDataChuckCallback = networkTask4.dataChunkIndex > 1;
                            networkTask4.responseBuffer = null;
                        }
                    } else {
                        networkTask2.rc.b.onDataReceiveSize(i, networkTask2.contentLength, heVar);
                        NetworkTask.this.isDataChuckCallback = true;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = NetworkTask.this.cacheBuffer;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.write(heVar.c(), 0, heVar.d());
                        if (z) {
                            String h = NetworkTask.this.rc.a.h();
                            NetworkTask networkTask5 = NetworkTask.this;
                            networkTask5.entry.data = networkTask5.cacheBuffer.toByteArray();
                            long currentTimeMillis = System.currentTimeMillis();
                            NetworkTask networkTask6 = NetworkTask.this;
                            networkTask6.cache.put(h, networkTask6.entry);
                            ALog.f(NetworkTask.TAG, "write cache", NetworkTask.this.rc.c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "size", Integer.valueOf(NetworkTask.this.entry.data.length), "key", h);
                        }
                    }
                } catch (Exception e) {
                    ALog.j(NetworkTask.TAG, "[onDataReceive] error.", NetworkTask.this.rc.c, e, new Object[0]);
                }
            }
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            String valueOf;
            DefaultFinishEvent defaultFinishEvent;
            if (NetworkTask.this.isDone.getAndSet(true)) {
                return;
            }
            if (NetworkTask.this.rc.f == null || !NetworkTask.this.rc.f.isResponseReturn()) {
                int i2 = 3;
                if (ALog.g(2)) {
                    ALog.f(NetworkTask.TAG, "[onFinish]", NetworkTask.this.rc.c, "code", Integer.valueOf(i), "msg", str);
                }
                if (i < 0) {
                    try {
                        if (NetworkTask.this.rc.a.l()) {
                            NetworkTask networkTask = NetworkTask.this;
                            if (!networkTask.isHeaderCallback && !networkTask.isDataChuckCallback) {
                                ALog.e(NetworkTask.TAG, "clear response buffer and retry", networkTask.rc.c, new Object[0]);
                                C0251c c0251c = NetworkTask.this.responseBuffer;
                                if (c0251c != null) {
                                    if (!c0251c.c.isEmpty()) {
                                        i2 = 4;
                                    }
                                    requestStatistic.roaming = i2;
                                    NetworkTask.this.responseBuffer.b();
                                    NetworkTask.this.responseBuffer = null;
                                }
                                if (NetworkTask.this.rc.a.e == 0) {
                                    requestStatistic.firstProtocol = requestStatistic.protocolType;
                                    requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i;
                                }
                                NetworkTask.this.rc.a.q();
                                NetworkTask.this.rc.d = new AtomicBoolean();
                                NetworkTask networkTask2 = NetworkTask.this;
                                C0254b c0254b = networkTask2.rc;
                                c0254b.e = new NetworkTask(c0254b, networkTask2.cache, networkTask2.entry);
                                if (requestStatistic.tnetErrorCode != 0) {
                                    valueOf = i + "|" + requestStatistic.protocolType + "|" + requestStatistic.tnetErrorCode;
                                    requestStatistic.tnetErrorCode = 0;
                                } else {
                                    valueOf = String.valueOf(i);
                                }
                                requestStatistic.appendErrorTrace(valueOf);
                                long currentTimeMillis = System.currentTimeMillis();
                                requestStatistic.retryCostTime += currentTimeMillis - requestStatistic.start;
                                requestStatistic.start = currentTimeMillis;
                                ThreadPoolExecutorFactory.g(NetworkTask.this.rc.e, ThreadPoolExecutorFactory.C0235b.a);
                                return;
                            }
                            requestStatistic.msg += ":回调后触发重试";
                            NetworkTask networkTask3 = NetworkTask.this;
                            if (networkTask3.isDataChuckCallback) {
                                requestStatistic.roaming = 2;
                            } else if (networkTask3.isHeaderCallback) {
                                requestStatistic.roaming = 1;
                            }
                            ALog.e(NetworkTask.TAG, "Cannot retry request after onHeader/onDataReceived callback!", networkTask3.rc.c, new Object[0]);
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
                NetworkTask networkTask4 = NetworkTask.this;
                C0251c c0251c2 = networkTask4.responseBuffer;
                if (c0251c2 != null) {
                    c0251c2.a(networkTask4.rc.b, networkTask4.contentLength);
                }
                NetworkTask.this.rc.c();
                requestStatistic.isDone.set(true);
                if (NetworkTask.this.rc.a.s() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
                    requestStatistic.ret = 0;
                    requestStatistic.statusCode = cf0.ERROR_DATA_LENGTH_NOT_MATCH;
                    str = cf0.b(cf0.ERROR_DATA_LENGTH_NOT_MATCH);
                    requestStatistic.msg = str;
                    NetworkTask networkTask5 = NetworkTask.this;
                    ALog.e(NetworkTask.TAG, "received data length not match with content-length", networkTask5.rc.c, "content-length", Integer.valueOf(networkTask5.contentLength), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
                    ExceptionStatistic exceptionStatistic = new ExceptionStatistic(cf0.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
                    exceptionStatistic.url = NetworkTask.this.rc.a.h();
                    x6.b().commitStat(exceptionStatistic);
                    i = cf0.ERROR_DATA_LENGTH_NOT_MATCH;
                }
                if (i == 304 && NetworkTask.this.entry != null) {
                    requestStatistic.protocolType = "cache";
                    defaultFinishEvent = new DefaultFinishEvent(200, str, this.a);
                } else {
                    defaultFinishEvent = new DefaultFinishEvent(i, str, this.a);
                }
                NetworkTask.this.rc.b.onFinish(defaultFinishEvent);
                if (i >= 0) {
                    BandWidthSampler.f().i(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
                } else {
                    requestStatistic.netType = NetworkStatusHelper.e();
                }
                qj1.a().commitFlow(new ln0(NetworkTask.this.f_refer, requestStatistic));
            }
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
            String d;
            if (NetworkTask.this.isDone.get()) {
                return;
            }
            if (NetworkTask.this.rc.f == null || !NetworkTask.this.rc.f.isResponseReturn()) {
                NetworkTask.this.rc.a();
                if (ALog.g(2)) {
                    ALog.f(NetworkTask.TAG, "onResponseCode", this.a.n(), "code", Integer.valueOf(i));
                    ALog.f(NetworkTask.TAG, "onResponseCode", this.a.n(), "headers", map);
                }
                if (h01.a(this.a, i) && (d = h01.d(map, "Location")) != null) {
                    o01 g = o01.g(d);
                    if (g != null) {
                        if (NetworkTask.this.isDone.compareAndSet(false, true)) {
                            g.f();
                            NetworkTask.this.rc.a.p(g);
                            NetworkTask.this.rc.d = new AtomicBoolean();
                            C0254b c0254b = NetworkTask.this.rc;
                            c0254b.e = new NetworkTask(c0254b, null, null);
                            this.b.recordRedirect(i, g.l());
                            this.b.locationUrl = d;
                            ThreadPoolExecutorFactory.g(NetworkTask.this.rc.e, ThreadPoolExecutorFactory.C0235b.a);
                            return;
                        }
                        return;
                    }
                    ALog.e(NetworkTask.TAG, "redirect url is invalid!", this.a.n(), "redirect url", d);
                }
                try {
                    NetworkTask.this.rc.c();
                    CookieManager.l(NetworkTask.this.rc.a.h(), map);
                    NetworkTask.this.contentLength = h01.f(map);
                    String h = NetworkTask.this.rc.a.h();
                    NetworkTask networkTask = NetworkTask.this;
                    Cache.Entry entry = networkTask.entry;
                    if (entry != null && i == 304) {
                        entry.responseHeaders.putAll(map);
                        Cache.Entry b = C0242a.b(map);
                        if (b != null) {
                            long j = b.ttl;
                            Cache.Entry entry2 = NetworkTask.this.entry;
                            if (j > entry2.ttl) {
                                entry2.ttl = j;
                            }
                        }
                        NetworkTask networkTask2 = NetworkTask.this;
                        networkTask2.rc.b.onResponseCode(200, networkTask2.entry.responseHeaders);
                        NetworkTask networkTask3 = NetworkTask.this;
                        Callback callback = networkTask3.rc.b;
                        byte[] bArr = networkTask3.entry.data;
                        callback.onDataReceiveSize(1, bArr.length, he.g(bArr));
                        long currentTimeMillis = System.currentTimeMillis();
                        NetworkTask networkTask4 = NetworkTask.this;
                        networkTask4.cache.put(h, networkTask4.entry);
                        ALog.f(NetworkTask.TAG, "update cache", NetworkTask.this.rc.c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "key", h);
                        return;
                    }
                    if (networkTask.cache != null) {
                        if ("no-store".equals(h01.d(map, "Cache-Control"))) {
                            NetworkTask.this.cache.remove(h);
                        } else {
                            NetworkTask networkTask5 = NetworkTask.this;
                            Cache.Entry b2 = C0242a.b(map);
                            networkTask5.entry = b2;
                            if (b2 != null) {
                                h01.j(map, "Cache-Control");
                                map.put("Cache-Control", Arrays.asList("no-store"));
                                NetworkTask networkTask6 = NetworkTask.this;
                                int i2 = NetworkTask.this.contentLength;
                                if (i2 == 0) {
                                    i2 = 5120;
                                }
                                networkTask6.cacheBuffer = new ByteArrayOutputStream(i2);
                            }
                        }
                    }
                    map.put("x-protocol", Arrays.asList(this.b.protocolType));
                    if (!"open".equalsIgnoreCase(h01.d(map, "streaming-parser")) && rj1.D()) {
                        NetworkTask networkTask7 = NetworkTask.this;
                        if (networkTask7.contentLength <= 131072) {
                            networkTask7.responseBuffer = new C0251c(i, map);
                            return;
                        }
                    }
                    NetworkTask.this.rc.b.onResponseCode(i, map);
                    NetworkTask.this.isHeaderCallback = true;
                } catch (Exception e) {
                    ALog.j(NetworkTask.TAG, "[onResponseCode] error.", NetworkTask.this.rc.c, e, new Object[0]);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.unified.NetworkTask$c */
    /* loaded from: classes.dex */
    private static class C0251c {
        int a;
        Map<String, List<String>> b;
        List<he> c = new ArrayList();

        C0251c(int i, Map<String, List<String>> map) {
            this.a = i;
            this.b = map;
        }

        int a(Callback callback, int i) {
            callback.onResponseCode(this.a, this.b);
            int i2 = 1;
            for (he heVar : this.c) {
                callback.onDataReceiveSize(i2, i, heVar);
                i2++;
            }
            return i2;
        }

        void b() {
            for (he heVar : this.c) {
                heVar.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetworkTask(C0254b c0254b, Cache cache, Cache.Entry entry) {
        this.cache = null;
        this.entry = null;
        this.f_refer = "other";
        this.isDone = null;
        this.rc = c0254b;
        this.isDone = c0254b.d;
        this.cache = cache;
        this.entry = entry;
        Map<String, String> d = c0254b.a.d();
        this.f_refer = d.get(HttpHeaderConstant.F_REFER);
        this.bizReqId = d.get("f-biz-req-id");
    }

    private o01 checkCName(o01 o01Var) {
        o01 g;
        String str = this.rc.a.d().get("x-host-cname");
        return (TextUtils.isEmpty(str) || (g = o01.g(o01Var.n().replaceFirst(o01Var.d(), str))) == null) ? o01Var : g;
    }

    private void executeRequest() {
        C0162c sessionCenter = getSessionCenter();
        o01 e = this.rc.a.e();
        boolean a = e.a();
        z12 z12Var = this.rc.a;
        RequestStatistic requestStatistic = z12Var.f;
        C0193a b = z12Var.b();
        if (this.rc.a.j == 1 && rj1.F() && this.rc.a.e == 0 && !a) {
            sessionCenter.d(checkCName(e), ab2.a, 3000L, new C0249a(requestStatistic, System.currentTimeMillis(), b, sessionCenter, e, a));
            return;
        }
        sendRequest(tryGetHttpSession(null, sessionCenter, e, a), b);
    }

    private C0162c getSessionCenter() {
        String g = this.rc.a.g("APPKEY");
        if (TextUtils.isEmpty(g)) {
            return C0162c.k();
        }
        ENV env = ENV.ONLINE;
        String g2 = this.rc.a.g("ENVIRONMENT");
        if ("pre".equalsIgnoreCase(g2)) {
            env = ENV.PREPARE;
        } else if ("test".equalsIgnoreCase(g2)) {
            env = ENV.TEST;
        }
        if (env != NetworkSdkSetting.CURRENT_ENV) {
            NetworkSdkSetting.CURRENT_ENV = env;
            C0162c.D(env);
        }
        C0159a j = C0159a.j(g, env);
        if (j == null) {
            j = new C0159a.C0160a().c(g).e(env).d(this.rc.a.g("AuthCode")).a();
        }
        return C0162c.l(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private anet.channel.request.C0193a preProcessRequest(anet.channel.request.C0193a r7) {
        /*
            r6 = this;
            anetwork.channel.unified.b r0 = r6.rc
            tb.z12 r0 = r0.a
            boolean r0 = r0.n()
            if (r0 == 0) goto L3c
            anetwork.channel.unified.b r0 = r6.rc
            tb.z12 r0 = r0.a
            java.lang.String r0 = r0.h()
            java.lang.String r0 = anetwork.channel.cookie.CookieManager.i(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3c
            anet.channel.request.a$b r1 = r7.u()
            java.util.Map r2 = r7.g()
            java.lang.String r3 = "Cookie"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L38
            java.lang.String r4 = "; "
            java.lang.String r0 = tb.zh2.e(r2, r4, r0)
        L38:
            r1.I(r3, r0)
            goto L3d
        L3c:
            r1 = 0
        L3d:
            anetwork.channel.cache.Cache$Entry r0 = r6.entry
            if (r0 == 0) goto L66
            if (r1 != 0) goto L48
            anet.channel.request.a$b r0 = r7.u()
            r1 = r0
        L48:
            anetwork.channel.cache.Cache$Entry r0 = r6.entry
            java.lang.String r0 = r0.etag
            if (r0 == 0) goto L53
            java.lang.String r2 = "If-None-Match"
            r1.I(r2, r0)
        L53:
            anetwork.channel.cache.Cache$Entry r0 = r6.entry
            long r2 = r0.lastModified
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L66
            java.lang.String r0 = anetwork.channel.cache.C0242a.d(r2)
            java.lang.String r2 = "If-Modified-Since"
            r1.I(r2, r0)
        L66:
            anetwork.channel.unified.b r0 = r6.rc
            tb.z12 r0 = r0.a
            int r0 = r0.e
            if (r0 != 0) goto La9
            java.lang.String r0 = r6.f_refer
            java.lang.String r2 = "weex"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 != 0) goto L87
            anetwork.channel.unified.b r0 = r6.rc
            tb.z12 r0 = r0.a
            tb.o01 r0 = r0.e()
            boolean r0 = tb.rj1.f(r0)
            if (r0 == 0) goto La9
        L87:
            if (r1 != 0) goto L8e
            anet.channel.request.a$b r0 = r7.u()
            r1 = r0
        L8e:
            r0 = 3000(0xbb8, float:4.204E-42)
            r1.T(r0)
            anetwork.channel.unified.b r0 = r6.rc
            tb.z12 r2 = r0.a
            anet.channel.statist.RequestStatistic r2 = r2.f
            r3 = 1
            r2.isFastDegrade = r3
            java.lang.String r0 = r0.c
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "anet.NetworkTask"
            java.lang.String r4 = "set read time out 3s."
            anet.channel.util.ALog.e(r3, r4, r0, r2)
        La9:
            if (r1 != 0) goto Lac
            goto Lb0
        Lac:
            anet.channel.request.a r7 = r1.J()
        Lb0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.unified.NetworkTask.preProcessRequest(anet.channel.request.a):anet.channel.request.a");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequest(Session session, C0193a c0193a) {
        if (session == null || this.isCanceled) {
            return;
        }
        C0193a preProcessRequest = preProcessRequest(c0193a);
        RequestStatistic requestStatistic = this.rc.a.f;
        requestStatistic.reqStart = System.currentTimeMillis();
        C0179a.f().log(requestStatistic.span, "netReqProcessStart", null);
        this.cancelable = session.w(preProcessRequest, new C0250b(preProcessRequest, requestStatistic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Session tryGetHttpSession(Session session, C0162c c0162c, o01 o01Var, boolean z) {
        z12 z12Var = this.rc.a;
        RequestStatistic requestStatistic = z12Var.f;
        if (session == null && z12Var.m() && !z && !NetworkStatusHelper.o()) {
            session = c0162c.j(o01Var, ab2.b, 0L);
        }
        if (session == null) {
            ALog.f(TAG, "create HttpSession with local DNS", this.rc.c, new Object[0]);
            session = new HttpSession(hu0.c(), new zm(zh2.e(o01Var.j(), jg1.SCHEME_SLASH, o01Var.d()), this.rc.c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.f(TAG, "tryGetHttpSession", this.rc.c, "Session", session);
        return session;
    }

    private Session tryGetSession() {
        Session session;
        final C0162c sessionCenter = getSessionCenter();
        final o01 e = this.rc.a.e();
        final boolean a = e.a();
        z12 z12Var = this.rc.a;
        final RequestStatistic requestStatistic = z12Var.f;
        if (z12Var.j == 1 && rj1.F() && this.rc.a.e == 0 && !a) {
            final o01 checkCName = checkCName(e);
            try {
                session = sessionCenter.t(checkCName, ab2.a, 0L);
            } catch (NoAvailStrategyException unused) {
                return tryGetHttpSession(null, sessionCenter, e, a);
            } catch (Exception unused2) {
                session = null;
            }
            if (session == null) {
                ThreadPoolExecutorFactory.g(new Runnable() { // from class: anetwork.channel.unified.NetworkTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        Session j = sessionCenter.j(checkCName, ab2.a, 3000L);
                        requestStatistic.connWaitTime = System.currentTimeMillis() - currentTimeMillis;
                        requestStatistic.spdyRequestSend = j != null;
                        Session tryGetHttpSession = NetworkTask.this.tryGetHttpSession(j, sessionCenter, e, a);
                        NetworkTask networkTask = NetworkTask.this;
                        networkTask.sendRequest(tryGetHttpSession, networkTask.rc.a.b());
                    }
                }, ThreadPoolExecutorFactory.C0235b.b);
                return null;
            }
            ALog.f(TAG, "tryGetSession", this.rc.c, "Session", session);
            requestStatistic.spdyRequestSend = true;
            return session;
        }
        return tryGetHttpSession(null, sessionCenter, e, a);
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        if (this.cancelable != null) {
            this.cancelable.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isCanceled) {
            return;
        }
        RequestStatistic requestStatistic = this.rc.a.f;
        requestStatistic.f_refer = this.f_refer;
        requestStatistic.bizReqId = this.bizReqId;
        if (!NetworkStatusHelper.n()) {
            if (rj1.B() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = -200;
                ThreadPoolExecutorFactory.j(new Runnable() { // from class: anetwork.channel.unified.NetworkTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ThreadPoolExecutorFactory.g(NetworkTask.this, ThreadPoolExecutorFactory.C0235b.a);
                    }
                }, 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.g(2)) {
                ALog.f(TAG, HttpUtils.NetworkUnavailableException.ERROR_INFO, this.rc.c, "NetworkStatus", NetworkStatusHelper.i());
            }
            this.isDone.set(true);
            this.rc.c();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = -200;
            requestStatistic.msg = cf0.b(-200);
            requestStatistic.rspEnd = System.currentTimeMillis();
            C0179a.f().log(requestStatistic.span, "netRspRecvEnd", null);
            this.rc.b.onFinish(new DefaultFinishEvent(-200, (String) null, this.rc.a.b()));
        } else if (rj1.i() && hu0.i() && AppLifecycle.b > 0 && !AppLifecycle.c && System.currentTimeMillis() - AppLifecycle.b > rj1.a() && !rj1.H(this.rc.a.e()) && !rj1.l(this.rc.a.b().c()) && !this.rc.a.b().r()) {
            this.isDone.set(true);
            this.rc.c();
            if (ALog.g(2)) {
                C0254b c0254b = this.rc;
                ALog.f(TAG, "request forbidden in background", c0254b.c, "url", c0254b.a.e());
            }
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = cf0.ERROR_REQUEST_FORBIDDEN_IN_BG;
            requestStatistic.msg = cf0.b(cf0.ERROR_REQUEST_FORBIDDEN_IN_BG);
            requestStatistic.rspEnd = System.currentTimeMillis();
            C0179a.f().log(requestStatistic.span, "netRspRecvEnd", null);
            this.rc.b.onFinish(new DefaultFinishEvent((int) cf0.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, this.rc.a.b()));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(cf0.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
            exceptionStatistic.host = this.rc.a.e().d();
            exceptionStatistic.url = this.rc.a.h();
            x6.b().commitStat(exceptionStatistic);
        } else {
            if (ALog.g(2)) {
                C0254b c0254b2 = this.rc;
                ALog.f(TAG, "exec request", c0254b2.c, "retryTimes", Integer.valueOf(c0254b2.a.e));
            }
            if (rj1.o()) {
                executeRequest();
                return;
            }
            try {
                Session tryGetSession = tryGetSession();
                if (tryGetSession == null) {
                    return;
                }
                sendRequest(tryGetSession, this.rc.a.b());
            } catch (Exception e) {
                ALog.d(TAG, "send request failed.", this.rc.c, e, new Object[0]);
            }
        }
    }
}
