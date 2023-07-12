package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.C3143b;
import com.alibaba.analytics.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionExtraCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.apache.commons.lang3.time.DateUtils;
import tb.ea2;
import tb.fa2;
import tb.qe;
import tb.qo2;
import tb.tc;
import tb.uo2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.sync.d */
/* loaded from: classes15.dex */
public class C3130d {
    public static final fa2 mMonitor = new fa2();
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static int c = -1;
    private static int d = 0;
    private static SpdySession e = null;
    private static ByteArrayOutputStream f = null;
    private static long g = 0;
    private static long h = 0;
    private static byte[] i = null;
    private static boolean j = true;
    private static boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.sync.d$a */
    /* loaded from: classes5.dex */
    public static class C3131a implements AccsSSLCallback {
        C3131a() {
        }

        @Override // org.android.spdy.AccsSSLCallback
        public byte[] getSSLPublicKey(int i, byte[] bArr) {
            return uo2.c().f(16, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.sync.d$b */
    /* loaded from: classes5.dex */
    public static class C3132b implements SessionCb, SessionExtraCb {
        private byte[] a;
        private String b;

        public C3132b(String str) {
            this.b = "accs_ssl_key2_" + str;
        }

        private int a(byte[] bArr) {
            return (bArr == null || uo2.c().e(this.b, bArr) == 0) ? -1 : 0;
        }

        @Override // org.android.spdy.SessionCb
        public void bioPingRecvCallback(SpdySession spdySession, int i) {
        }

        @Override // org.android.spdy.SessionCb
        public byte[] getSSLMeta(SpdySession spdySession) {
            if (uo2.c().b()) {
                byte[] a = uo2.c().a(this.b);
                return a != null ? a : new byte[0];
            }
            return this.a;
        }

        @Override // org.android.spdy.SessionCb
        public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
            if (uo2.c().b()) {
                return a(bArr);
            }
            this.a = bArr;
            return 0;
        }

        @Override // org.android.spdy.SessionCb
        public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        }

        @Override // org.android.spdy.SessionCb
        public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
            if (spdySession == C3130d.e) {
                if (C3130d.f == null) {
                    ByteArrayOutputStream unused = C3130d.f = new ByteArrayOutputStream(1024);
                    long unused2 = C3130d.h = C3130d.r(bArr);
                }
                if (C3130d.h != -1) {
                    try {
                        C3130d.f.write(bArr);
                    } catch (IOException unused3) {
                    }
                    C3130d.g += bArr.length;
                    if (C3130d.h == C3130d.g - 8) {
                        try {
                            C3130d.f.flush();
                        } catch (IOException unused4) {
                        }
                        byte[] byteArray = C3130d.f.toByteArray();
                        try {
                            C3130d.f.close();
                        } catch (IOException unused5) {
                        }
                        int unused6 = C3130d.c = C3127a.l(byteArray);
                        if (C3130d.c != 0) {
                            C3130d.p();
                        }
                        C3130d.t();
                        return;
                    }
                    return;
                }
                int unused7 = C3130d.c = -1;
                C3130d.p();
                C3130d.t();
                return;
            }
            Logger.v("TnetUtil", "[spdyCustomControlFrameRecvCallback] session != spdySessionUT");
        }

        @Override // org.android.spdy.SessionCb
        public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
            if (spdySession == C3130d.e) {
                int unused = C3130d.c = i;
                synchronized (C3130d.b) {
                    SpdySession unused2 = C3130d.e = null;
                }
            }
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
            if (spdySession == C3130d.e) {
                C3130d.u(spdySession);
            }
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
            if (Variables.n().O()) {
                C3130d.mMonitor.onEvent(ea2.a(ea2.q, null, Double.valueOf(1.0d)));
            }
            if (spdySession == C3130d.e) {
                int unused = C3130d.c = i;
                C3130d.p();
            }
        }

        @Override // org.android.spdy.SessionExtraCb
        public void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
            if (spdySession == C3130d.e) {
                C3130d.u(spdySession);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        Logger.d();
        synchronized (b) {
            SpdySession spdySession = e;
            if (spdySession != null) {
                spdySession.closeSession();
            }
            e = null;
            C3127a.a();
            C3143b.b();
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q() {
        Logger.d();
        synchronized (b) {
            SpdySession spdySession = e;
            if (spdySession != null) {
                spdySession.closeSession();
            }
            j = true;
            e = null;
            C3127a.a();
            C3143b.b();
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long r(byte[] bArr) {
        if (bArr == null || bArr.length < 12) {
            return -1L;
        }
        return qe.b(bArr, 1, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void s() {
        synchronized (b) {
            if (e == null) {
                C3143b.b();
                C3127a.k();
                j = true;
            } else {
                j = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        Object obj = a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(SpdySession spdySession) {
        byte[] bArr;
        synchronized (b) {
            while (true) {
                SpdySession spdySession2 = e;
                if (spdySession == spdySession2 && spdySession2 != null && (bArr = i) != null) {
                    int length = bArr.length;
                    int i2 = d;
                    if (length <= i2) {
                        break;
                    }
                    try {
                        if (bArr.length - i2 > 131072) {
                            spdySession.sendCustomControlFrame(-1, -1, -1, 131072, qe.g(bArr, i2, 131072));
                            d += 131072;
                        } else {
                            int length2 = bArr.length - i2;
                            if (length2 > 0) {
                                spdySession.sendCustomControlFrame(-1, -1, -1, length2, qe.g(bArr, i2, length2));
                                d += length2;
                            }
                        }
                    } catch (SpdyErrorException e2) {
                        Logger.i("TnetUtil", "SpdyErrorException", e2);
                        if (e2.SpdyErrorGetCode() != -3848) {
                            c = e2.SpdyErrorGetCode();
                            p();
                        }
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static tc v(byte[] bArr) {
        long currentTimeMillis;
        Logger.d();
        boolean O = Variables.n().O();
        Double valueOf = Double.valueOf(1.0d);
        if (O) {
            mMonitor.onEvent(ea2.a(ea2.n, null, valueOf));
        }
        tc tcVar = new tc();
        synchronized (b) {
            i = bArr;
            d = 0;
            tcVar.d = bArr.length;
        }
        synchronized (a) {
            ByteArrayOutputStream byteArrayOutputStream = f;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
            f = null;
            g = 0L;
            h = 0L;
            long currentTimeMillis2 = System.currentTimeMillis();
            c = -1;
            try {
                if (w()) {
                    if (Variables.n().O()) {
                        mMonitor.onEvent(ea2.a(ea2.o, null, valueOf));
                    }
                    SpdyAgent spdyAgent = SpdyAgent.getInstance(Variables.n().j(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
                    if (uo2.c().b()) {
                        spdyAgent.setAccsSslCallback(new C3131a());
                    }
                    qo2 f2 = C3129c.b().f();
                    String a2 = f2.a();
                    int b2 = f2.b();
                    Logger.f("TnetUtil", "host", a2, "port", Integer.valueOf(b2));
                    SessionInfo sessionInfo = new SessionInfo(a2, b2, null, null, 0, null, new C3132b(a2), SpdyProtocol.SSSL_0RTT_CUSTOM);
                    if (uo2.c().b()) {
                        sessionInfo.setPubKeySeqNum(8);
                    } else {
                        sessionInfo.setPubKeySeqNum(9);
                    }
                    sessionInfo.setConnectionTimeoutMs(10000);
                    synchronized (b) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        e = spdyAgent.createSession(sessionInfo);
                        tcVar.b = System.currentTimeMillis() - currentTimeMillis3;
                        k = false;
                    }
                    Logger.f("TnetUtil", "createSession");
                    a.wait(DateUtils.MILLIS_PER_MINUTE);
                } else if (e != null && (!j || Variables.n().I())) {
                    u(e);
                    a.wait(DateUtils.MILLIS_PER_MINUTE);
                } else {
                    p();
                }
            } catch (Exception e2) {
                p();
                Logger.i("TnetUtil", "CreateSession Exception", e2);
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
            if (currentTimeMillis >= DateUtils.MILLIS_PER_MINUTE) {
                if (Variables.n().O()) {
                    mMonitor.onEvent(ea2.a(ea2.p, null, valueOf));
                }
                p();
                Logger.v("TnetUtil", "WAIT_TIMEOUT");
            }
        }
        C3127a.m(d);
        synchronized (b) {
            i = null;
            d = 0;
        }
        tcVar.a = c;
        tcVar.c = currentTimeMillis;
        tcVar.e = C3127a.a;
        C3127a.a = null;
        Logger.f("TnetUtil", "PostData isSuccess", Boolean.valueOf(tcVar.a()), "errCode", Integer.valueOf(tcVar.a), "rt", Long.valueOf(tcVar.c));
        return tcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w() {
        if (e == null) {
            return j || Variables.n().I();
        }
        return false;
    }
}
