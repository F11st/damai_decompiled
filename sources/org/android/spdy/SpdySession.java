package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.ProtectedPointer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SpdySession {
    private static volatile int count;
    private SpdyAgent agent;
    private String authority;
    private String domain;
    private Handler handler;
    Intenalcb intenalcb;
    private int mode;
    private ProtectedPointer pptr4sessionNativePtr;
    private int pubkey_seqnum;
    SessionCb sessionCallBack;
    private volatile long sessionNativePtr;
    private NetSparseArray<SpdyStreamContext> spdyStream;
    private HandlerThread thread;
    private Object userData;
    private AtomicBoolean closed = new AtomicBoolean();
    private boolean sessionClearedFromSessionMgr = false;
    private Object lock = new Object();
    private int streamcount = 1;
    volatile int refcount = 1;
    private SuperviseConnectInfo mSuperviseConnectInfo = new SuperviseConnectInfo();

    /* compiled from: Taobao */
    /* renamed from: org.android.spdy.SpdySession$a */
    /* loaded from: classes2.dex */
    class C8876a implements ProtectedPointer.ProtectedPointerOnClose {
        C8876a(SpdySession spdySession) {
        }

        @Override // org.android.spdy.ProtectedPointer.ProtectedPointerOnClose
        public void close(Object obj) {
            SpdySession spdySession = (SpdySession) obj;
            spdySession.NotifyNotInvokeAnyMoreN(spdySession.sessionNativePtr);
            spdySession.setSessionNativePtr(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdySession(long j, SpdyAgent spdyAgent, String str, String str2, SessionCb sessionCb, int i, int i2, Object obj) {
        this.spdyStream = null;
        this.sessionCallBack = null;
        this.pubkey_seqnum = 0;
        this.userData = null;
        this.mode = 0;
        this.sessionNativePtr = j;
        ProtectedPointer protectedPointer = new ProtectedPointer(this);
        this.pptr4sessionNativePtr = protectedPointer;
        protectedPointer.d(new C8876a(this));
        this.agent = spdyAgent;
        this.authority = str;
        this.intenalcb = new C8880d();
        this.domain = str2;
        this.spdyStream = new NetSparseArray<>(5);
        this.sessionCallBack = sessionCb;
        this.pubkey_seqnum = i2;
        this.mode = i;
        this.userData = obj;
        this.closed.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int NotifyNotInvokeAnyMoreN(long j);

    private int closeprivate() {
        synchronized (this.lock) {
            if (!this.sessionClearedFromSessionMgr) {
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
            }
        }
        synchronized (this.lock) {
            SpdyStreamContext[] allStreamCb = getAllStreamCb();
            if (allStreamCb != null) {
                for (SpdyStreamContext spdyStreamContext : allStreamCb) {
                    spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] unfinished stm=", spdyStreamContext.streamId);
                    spdyStreamContext.callBack.spdyStreamCloseCallback(this, spdyStreamContext.streamId, -2001, spdyStreamContext.streamContext, null);
                }
            }
            this.spdyStream.clear();
        }
        return 0;
    }

    private String getAuthority() {
        return this.authority;
    }

    private native int sendCustomControlFrameN(long j, int i, int i2, int i3, int i4, byte[] bArr);

    private native int sendHeadersN(long j, int i, String[] strArr, boolean z);

    private native int setOptionN(long j, int i, int i2);

    private native int streamCloseN(long j, int i, int i2);

    private native int streamSendDataN(long j, int i, byte[] bArr, int i2, int i3, boolean z);

    private native int submitBioPingN(long j);

    private native int submitPingN(long j);

    private native int submitRequestN(long j, String str, byte b, String[] strArr, byte[] bArr, boolean z, int i, int i2, int i3);

    public int cleanUp() {
        spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        this.agent.removeSession(this);
        return closeprivate();
    }

    public void clearAllStreamCb() {
        spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
    }

    int closeInternal() {
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        return closeprivate();
    }

    public int closeSession() {
        int i;
        spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
        synchronized (this.lock) {
            i = 0;
            if (!this.sessionClearedFromSessionMgr) {
                spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ", this.authority);
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
                if (this.pptr4sessionNativePtr.a()) {
                    try {
                        int closeSession = this.agent.closeSession(this.sessionNativePtr);
                        this.pptr4sessionNativePtr.b();
                        i = closeSession;
                    } catch (UnsatisfiedLinkError e) {
                        e.printStackTrace();
                        this.pptr4sessionNativePtr.b();
                    }
                } else {
                    i = -2001;
                }
            }
        }
        return i;
    }

    public SpdyStreamContext[] getAllStreamCb() {
        SpdyStreamContext[] spdyStreamContextArr;
        synchronized (this.lock) {
            int size = this.spdyStream.size();
            if (size > 0) {
                spdyStreamContextArr = new SpdyStreamContext[size];
                this.spdyStream.toArray(spdyStreamContextArr);
            } else {
                spdyStreamContextArr = null;
            }
        }
        return spdyStreamContextArr;
    }

    public String getConnectInfoOnConnected() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("mode=");
        sb.append(this.mode);
        sb.append(",connectTime=");
        sb.append(this.mSuperviseConnectInfo.connectTime);
        sb.append(",retryTimes=");
        sb.append(this.mSuperviseConnectInfo.retryTimes);
        sb.append(",handshakeTime=");
        sb.append(this.mSuperviseConnectInfo.handshakeTime);
        sb.append(",doHandshakeTime=");
        sb.append(this.mSuperviseConnectInfo.doHandshakeTime);
        sb.append(",sessionTicketReused=");
        sb.append(this.mSuperviseConnectInfo.sessionTicketReused);
        if (isQUIC()) {
            sb.append(",scid=");
            sb.append(this.mSuperviseConnectInfo.scid);
            sb.append(",dcid=");
            sb.append(this.mSuperviseConnectInfo.dcid);
            sb.append(",congControlKind=");
            sb.append(this.mSuperviseConnectInfo.congControlKind);
        }
        return sb.toString();
    }

    public String getConnectInfoOnDisConnected() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(getConnectInfoOnConnected());
        sb.append(",reused_counter=");
        sb.append(this.mSuperviseConnectInfo.reused_counter);
        sb.append(",keepalive_period_second=");
        sb.append(this.mSuperviseConnectInfo.keepalive_period_second);
        sb.append(",srtt=");
        sb.append(this.mSuperviseConnectInfo.srtt);
        sb.append(",connSendSize=");
        sb.append(this.mSuperviseConnectInfo.connSendSize);
        sb.append(",connRecvSize=");
        sb.append(this.mSuperviseConnectInfo.connRecvSize);
        sb.append(",sendPacketCount=");
        sb.append(this.mSuperviseConnectInfo.sendPacketCount);
        sb.append(",recvPacketCount=");
        sb.append(this.mSuperviseConnectInfo.recvPacketCount);
        sb.append(",connLastRdEventIdleTime=");
        sb.append(this.mSuperviseConnectInfo.connLastRdEventIdleTime);
        if (isQUIC()) {
            sb.append(",retransmissionRate=");
            sb.append(this.mSuperviseConnectInfo.retransmissionRate);
            sb.append(",tlpCount=");
            sb.append(this.mSuperviseConnectInfo.tlpCount);
            sb.append(",rtoCount=");
            sb.append(this.mSuperviseConnectInfo.rtoCount);
            sb.append(",xqcSendCount=");
            sb.append(this.mSuperviseConnectInfo.sendCount);
            sb.append(",xqcRecvCount=");
            sb.append(this.mSuperviseConnectInfo.recvCount);
            sb.append(",lossRate=");
            sb.append(this.mSuperviseConnectInfo.lossRate);
            sb.append(",xqc0RttStatus=");
            sb.append(this.mSuperviseConnectInfo.xqc0RttStatus);
        }
        return sb.toString();
    }

    public String getDomain() {
        return this.domain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    Handler getMsgHandler() {
        return this.handler;
    }

    @Deprecated
    public String getQuicConnectionID() {
        return "";
    }

    public int getRefCount() {
        return this.refcount;
    }

    long getSessionNativePtr() {
        return this.sessionNativePtr;
    }

    SpdyAgent getSpdyAgent() {
        return this.agent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdyStreamContext getSpdyStream(int i) {
        SpdyStreamContext spdyStreamContext;
        if (i > 0) {
            synchronized (this.lock) {
                spdyStreamContext = this.spdyStream.get(i);
            }
            return spdyStreamContext;
        }
        return null;
    }

    public Object getUserData() {
        return this.userData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increRefCount() {
        this.refcount++;
    }

    boolean isHTTP3() {
        return (this.mode & 256) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMultiPathMode() {
        return (this.mode & 2048) != 0;
    }

    boolean isQUIC() {
        return isHTTP3() || (this.mode & 4) != 0;
    }

    int putSpdyStreamCtx(SpdyStreamContext spdyStreamContext) {
        int i;
        synchronized (this.lock) {
            i = this.streamcount;
            this.streamcount = i + 1;
            this.spdyStream.put(i, spdyStreamContext);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releasePptr() {
        this.pptr4sessionNativePtr.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSpdyStream(int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.spdyStream.remove(i);
            }
        }
    }

    public int sendCustomControlFrame(int i, int i2, int i3, int i4, byte[] bArr) throws SpdyErrorException {
        int i5;
        sessionIsOpen();
        if (bArr != null && bArr.length <= 0) {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        spduLog.Logi("tnet-jni", "[sendCustomControlFrame] - type: ", i2);
        if (this.pptr4sessionNativePtr.a()) {
            i5 = sendCustomControlFrameN(this.sessionNativePtr, i, i2, i3, i4, bArr2);
            this.pptr4sessionNativePtr.b();
        } else {
            i5 = -2001;
        }
        if (i5 == 0) {
            return i5;
        }
        throw new SpdyErrorException("sendCustomControlFrame error: " + i5, i5);
    }

    void sessionIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("session is already closed: -1104", (int) TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(int i) {
        this.mode = i;
    }

    public int setOption(int i, int i2) throws SpdyErrorException {
        int i3;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.a()) {
            i3 = setOptionN(this.sessionNativePtr, i, i2);
            this.pptr4sessionNativePtr.b();
        } else {
            i3 = -2001;
        }
        if (i3 == 0) {
            return i3;
        }
        throw new SpdyErrorException("setOption error: " + i3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSessionNativePtr(long j) {
        this.sessionNativePtr = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSuperviseConnectInfoOnConnectedCB(SuperviseConnectInfo superviseConnectInfo) {
        if (superviseConnectInfo == null) {
            return;
        }
        SuperviseConnectInfo superviseConnectInfo2 = this.mSuperviseConnectInfo;
        superviseConnectInfo2.connectTime = superviseConnectInfo.connectTime;
        superviseConnectInfo2.retryTimes = superviseConnectInfo.retryTimes;
        superviseConnectInfo2.timeout = superviseConnectInfo.timeout;
        superviseConnectInfo2.handshakeTime = superviseConnectInfo.handshakeTime;
        superviseConnectInfo2.doHandshakeTime = superviseConnectInfo.doHandshakeTime;
        superviseConnectInfo2.sessionTicketReused = superviseConnectInfo.sessionTicketReused;
        if (isQUIC()) {
            SuperviseConnectInfo superviseConnectInfo3 = this.mSuperviseConnectInfo;
            superviseConnectInfo3.scid = superviseConnectInfo.scid;
            superviseConnectInfo3.dcid = superviseConnectInfo.dcid;
            superviseConnectInfo3.congControlKind = superviseConnectInfo.congControlKind;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSuperviseConnectInfoOnDisconnectedCB(SuperviseConnectInfo superviseConnectInfo) {
        if (superviseConnectInfo == null) {
            return;
        }
        SuperviseConnectInfo superviseConnectInfo2 = this.mSuperviseConnectInfo;
        superviseConnectInfo2.reused_counter = superviseConnectInfo.reused_counter;
        superviseConnectInfo2.keepalive_period_second = superviseConnectInfo.keepalive_period_second;
        superviseConnectInfo2.timeout = superviseConnectInfo.timeout;
        superviseConnectInfo2.handshakeTime = superviseConnectInfo.handshakeTime;
        superviseConnectInfo2.doHandshakeTime = superviseConnectInfo.doHandshakeTime;
        superviseConnectInfo2.sessionTicketReused = superviseConnectInfo.sessionTicketReused;
        superviseConnectInfo2.srtt = superviseConnectInfo.srtt;
        superviseConnectInfo2.connRecvSize = superviseConnectInfo.connRecvSize;
        superviseConnectInfo2.connSendSize = superviseConnectInfo.connSendSize;
        superviseConnectInfo2.recvPacketCount = superviseConnectInfo.recvPacketCount;
        superviseConnectInfo2.sendPacketCount = superviseConnectInfo.sendPacketCount;
        superviseConnectInfo2.connLastRdEventIdleTime = superviseConnectInfo.connLastRdEventIdleTime;
        if (isQUIC()) {
            SuperviseConnectInfo superviseConnectInfo3 = this.mSuperviseConnectInfo;
            superviseConnectInfo3.retransmissionRate = superviseConnectInfo.retransmissionRate;
            superviseConnectInfo3.lossRate = superviseConnectInfo.lossRate;
            superviseConnectInfo3.tlpCount = superviseConnectInfo.tlpCount;
            superviseConnectInfo3.rtoCount = superviseConnectInfo.rtoCount;
            superviseConnectInfo3.sendCount = superviseConnectInfo.sendCount;
            superviseConnectInfo3.recvCount = superviseConnectInfo.recvCount;
            superviseConnectInfo3.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
        }
    }

    public int streamReset(long j, int i) throws SpdyErrorException {
        int i2;
        sessionIsOpen();
        spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
        if (this.pptr4sessionNativePtr.a()) {
            i2 = streamCloseN(this.sessionNativePtr, (int) j, i);
            this.pptr4sessionNativePtr.b();
        } else {
            i2 = -2001;
        }
        if (i2 == 0) {
            return i2;
        }
        throw new SpdyErrorException("streamReset error: " + i2, i2);
    }

    @Deprecated
    public int submitBioPing() throws SpdyErrorException {
        int i;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.a()) {
            i = submitBioPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.b();
        } else {
            i = -2001;
        }
        if (i == 0) {
            return i;
        }
        throw new SpdyErrorException("submitBioPing error: " + i, i);
    }

    public int submitPing() throws SpdyErrorException {
        int i;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.a()) {
            i = submitPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.b();
        } else {
            i = -2001;
        }
        if (i == 0) {
            return i;
        }
        throw new SpdyErrorException("submitPing error: " + i, i);
    }

    public int submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Spdycb spdycb) throws SpdyErrorException {
        int i;
        if (spdyRequest != null && obj != null && spdyRequest.getAuthority() != null) {
            sessionIsOpen();
            byte[] dataproviderToByteArray = SpdyAgent.dataproviderToByteArray(spdyRequest, spdyDataProvider);
            if (dataproviderToByteArray != null && dataproviderToByteArray.length <= 0) {
                dataproviderToByteArray = null;
            }
            byte[] bArr = dataproviderToByteArray;
            boolean z = spdyDataProvider != null ? spdyDataProvider.finished : true;
            SpdyStreamContext spdyStreamContext = new SpdyStreamContext(obj, spdycb);
            int putSpdyStreamCtx = putSpdyStreamCtx(spdyStreamContext);
            String[] mapToByteArray = SpdyAgent.mapToByteArray(spdyRequest.getHeaders());
            if (this.pptr4sessionNativePtr.a()) {
                i = submitRequestN(this.sessionNativePtr, spdyRequest.getUrlPath(), (byte) spdyRequest.getPriority(), mapToByteArray, bArr, z, putSpdyStreamCtx, spdyRequest.getRequestTimeoutMs(), spdyRequest.getRequestRdTimeoutMs());
                this.pptr4sessionNativePtr.b();
            } else {
                i = -2001;
            }
            if (i >= 0) {
                spdyStreamContext.streamId = i;
                return i;
            }
            removeSpdyStream(putSpdyStreamCtx);
            throw new SpdyErrorException("submitRequest error: " + i, i);
        }
        throw new SpdyErrorException("submitRequest error: -1102", (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }
}
