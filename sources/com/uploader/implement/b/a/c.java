package com.uploader.implement.b.a;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
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

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c implements SessionCb, SessionExtraCb {
    private com.uploader.implement.c a;
    private SpdyAgent b;
    private SpdySession c;
    private final Context d;
    private final f e;
    private volatile a f;
    private volatile String g = "DISCONNECTED";
    private List<C0356c> h = new LinkedList();
    private final int i = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        void a();

        void a(int i);

        void a(int i, int i2);

        void a(byte[] bArr, int i);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements AccsSSLCallback {
        b() {
        }

        @Override // org.android.spdy.AccsSSLCallback
        public byte[] getSSLPublicKey(int i, byte[] bArr) {
            try {
                return c.this.a.b.decrypt(c.this.d, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            } catch (Exception e) {
                if (com.uploader.implement.a.d(16)) {
                    com.uploader.implement.a.b(16, "CustomizedSession", "call config.decrypt error.", e);
                    return null;
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.b.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0356c {
        byte[] a;
        int b;
        int c;

        public C0356c(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(hashCode());
            sb.append(" WaitingData{ length=");
            sb.append(this.b);
            sb.append(", sendSequence=");
            sb.append(this.c);
            sb.append("}");
            return sb.toString();
        }
    }

    public c(com.uploader.implement.c cVar, f fVar) {
        this.a = cVar;
        this.d = cVar.c;
        this.e = fVar;
    }

    private void c(int i) {
        synchronized (this.h) {
            this.h.clear();
        }
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "CustomizedSession", this.i + " CustomizedSession onClose, error:" + i);
        }
        if (this.f != null) {
            this.f.a(i);
        }
    }

    private void f(C0356c c0356c) {
        synchronized (this.h) {
            this.h.add(c0356c);
            if (com.uploader.implement.a.d(8)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(this.i);
                sb.append(" [addWaitingData] ");
                sb.append(c0356c);
                sb.append(", mSession:");
                SpdySession spdySession = this.c;
                sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
                com.uploader.implement.a.a(8, "CustomizedSession", sb.toString());
            }
        }
    }

    private void j() {
        try {
            SpdyAgent.enableDebug = false;
            SpdyAgent spdyAgent = SpdyAgent.getInstance(this.d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            this.b = spdyAgent;
            if (this.e.f) {
                spdyAgent.setAccsSslCallback(new b());
            }
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "CustomizedSession", this.i + " initSpdyAgent");
            }
        } catch (Exception e) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", this.i + " init SpdyAgent failed.", e);
            }
        }
    }

    private void k() {
        synchronized (this.h) {
            if (this.h.isEmpty()) {
                return;
            }
            final C0356c remove = this.h.remove(0);
            if (remove != null) {
                com.uploader.implement.e.b.a(new Runnable() { // from class: com.uploader.implement.b.a.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        C0356c c0356c = remove;
                        cVar.d(c0356c.c, c0356c.a, c0356c.b);
                    }
                });
            }
        }
    }

    public void b() {
        if (!i()) {
            if (com.uploader.implement.a.d(8)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.i);
                sb.append(" CustomizedSession already connected,mSession:");
                SpdySession spdySession = this.c;
                sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
                com.uploader.implement.a.a(8, "CustomizedSession", sb.toString());
                return;
            }
            return;
        }
        try {
            this.g = "CONNECTING";
            int i = this.e.f ? SpdyProtocol.SSSL_0RTT_CUSTOM : 16;
            f fVar = this.e;
            SessionInfo sessionInfo = new SessionInfo(fVar.a, fVar.b, Integer.toString(this.i), null, 0, null, this, i);
            sessionInfo.setConnectionTimeoutMs(10000);
            if (this.e.f) {
                if (2 == this.a.b.getCurrentElement().a) {
                    sessionInfo.setPubKeySeqNum(0);
                } else {
                    sessionInfo.setPubKeySeqNum(6);
                }
            }
            if (this.b == null) {
                j();
            }
            this.c = this.b.createSession(sessionInfo);
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession createSession,mSession:" + this.c.hashCode() + " getRefCount:" + this.c.getRefCount());
            }
        } catch (SpdyErrorException e) {
            this.g = "CONNECTFAILED";
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", this.i + "CustomizedSession connect failed", e);
            }
            c(e.SpdyErrorGetCode());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
    }

    public void d(int i, byte[] bArr, int i2) {
        try {
            if (i()) {
                if (com.uploader.implement.a.d(16)) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append(this.i);
                    sb.append(" send failed, needConnect and return, sequence:");
                    sb.append(i);
                    sb.append(", length=");
                    sb.append(i2);
                    sb.append(", mSession:");
                    SpdySession spdySession = this.c;
                    sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
                    com.uploader.implement.a.a(16, "CustomizedSession", sb.toString());
                    return;
                }
                return;
            }
            this.c.sendCustomControlFrame(i, -1, -1, i2, bArr);
            if (com.uploader.implement.a.d(4)) {
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append(this.i);
                sb2.append(" send sendCustomControlFrame. sequence=");
                sb2.append(i);
                sb2.append(", length=");
                sb2.append(i2);
                sb2.append(", mSession:");
                sb2.append(this.c.hashCode());
                com.uploader.implement.a.a(4, "CustomizedSession", sb2.toString());
            }
            if (this.f != null) {
                this.f.b(i);
            }
        } catch (SpdyErrorException e) {
            int SpdyErrorGetCode = e.SpdyErrorGetCode();
            if (-3848 == SpdyErrorGetCode) {
                f(new C0356c(bArr, i2, i));
                return;
            }
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", this.i + " send sendCustomControlFrame failed", e);
            }
            if (this.f != null) {
                this.f.a(i, SpdyErrorGetCode);
            }
        }
    }

    public void e(a aVar) {
        this.f = aVar;
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        try {
            return this.a.b.getSslTicket(this.d, "ARUP_SSL_TICKET_KEY");
        } catch (Exception e) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", "CustomizedSession call config.getSslTicket error.", e);
                return null;
            }
            return null;
        }
    }

    public void h() {
        SpdySession spdySession = this.c;
        if (spdySession != null) {
            spdySession.closeSession();
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession closeSession,session:" + this.c.hashCode());
            }
        }
        this.g = "DISCONNECTED";
    }

    public boolean i() {
        String str = this.g;
        return ("CONNECTED".equals(str) || "CONNECTING".equals(str)) ? false : true;
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        try {
            return this.a.b.putSslTicket(this.d, "ARUP_SSL_TICKET_KEY", bArr);
        } catch (Exception e) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", "CustomizedSession call config.putSslTicket error.", e);
                return -1;
            }
            return -1;
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession spdyCustomControlFrameFailCallback, session:" + spdySession.hashCode() + ", id:" + i + ", error:" + i2);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        if (this.f != null) {
            this.f.a(bArr, i4);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
                spdySession.clearAllStreamCb();
            } catch (Throwable unused) {
            }
        }
        this.g = "DISCONNECTED";
        if (com.uploader.implement.a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.i);
            sb.append(" CustomizedSession spdySessionCloseCallback,session:");
            sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
            sb.append(", error:");
            sb.append(i);
            com.uploader.implement.a.a(2, "CustomizedSession", sb.toString());
        }
        c(i);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.g = "CONNECTED";
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession spdySessionConnectCB,session:" + spdySession.hashCode());
        }
        if (this.f != null) {
            this.f.a();
        }
        k();
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            spdySession.cleanUp();
        }
        this.g = "CONNECTFAILED";
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession spdySessionFailedError,session:" + spdySession + ", error:" + i);
        }
        c(i);
    }

    @Override // org.android.spdy.SessionExtraCb
    public void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "CustomizedSession", this.i + " CustomizedSession spdySessionOnWritable session:" + spdySession.hashCode() + ",size:" + i);
        }
        k();
    }
}
