package org.android.spdy;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: org.android.spdy.d */
/* loaded from: classes2.dex */
public final class C8880d implements Intenalcb {
    @Override // org.android.spdy.Intenalcb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.bioPingRecvCallback] - ", spdySession);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null) {
            sessionCb.bioPingRecvCallback(spdySession, i);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.bioPingRecvCallback] - no sessionCallBack.");
        }
    }

    @Override // org.android.spdy.Intenalcb
    public byte[] getSSLMeta(SpdySession spdySession) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.getSSLMeta] - ", spdySession);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null) {
            return sessionCb.getSSLMeta(spdySession);
        }
        spduLog.Loge("tnet-jni", "[SpdySessionCallBack.getSSLMeta] - no sessionCallBack.");
        return null;
    }

    @Override // org.android.spdy.Intenalcb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.putSSLMeta] - ", spdySession);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null) {
            return sessionCb.putSSLMeta(spdySession, bArr);
        }
        spduLog.Loge("tnet-jni", "[SpdySessionCallBack.putSSLMeta] - no sessionCallBack.");
        return -1;
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyCustomControlFrameFailCallback] - ", spdySession);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null) {
            sessionCb.spdyCustomControlFrameFailCallback(spdySession, obj, i, i2);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyCustomControlFrameFailCallback] - no sessionCallBack.");
        }
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyCustomControlFrameRecvCallback] - ", spdySession);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null) {
            sessionCb.spdyCustomControlFrameRecvCallback(spdySession, obj, i, i2, i3, i4, bArr);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyCustomControlFrameRecvCallback] - no sessionCallBack.");
        }
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, int i) {
        Spdycb spdycb;
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataChunkRecvCB] - ", spdySession);
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i);
        if (spdyStream != null && (spdycb = spdyStream.callBack) != null) {
            spdycb.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataChunkRecvCB] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyDataChunkRecvCB", 3, begin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, int i2) {
        Spdycb spdycb;
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataRecvCallback] - ", spdySession);
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && (spdycb = spdyStream.callBack) != null) {
            spdycb.spdyDataRecvCallback(spdySession, z, j, i, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyDataRecvCallback", 3, begin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, int i2) {
        Spdycb spdycb;
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataSendCallback] - ");
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && (spdycb = spdyStream.callBack) != null) {
            spdycb.spdyDataSendCallback(spdySession, z, j, i, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataSendCallback] - no sessionCallBack.");
        }
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, int i) {
        Spdycb spdycb;
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - ", spdySession);
        NetTimeGaurd.start(3);
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i);
        if (spdyStream != null && (spdycb = spdyStream.callBack) != null) {
            spdycb.spdyOnStreamResponse(spdySession, j, map, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyOnStreamResponse", 3, begin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyPingRecvCallback] - ", spdySession);
        NetTimeGaurd.start(1);
        if (spdySession.sessionCallBack != null) {
            long begin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdyPingRecvCallback(spdySession, j, obj);
            NetTimeGaurd.end("spdyPingRecvCallback", 1, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyPingRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(1);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j, int i) {
        Spdycb spdycb;
        spduLog.Logd("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - ", spdySession.toString());
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i);
        if (spdyStream != null && (spdycb = spdyStream.callBack) != null) {
            spdycb.spdyRequestRecvCallback(spdySession, j, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyRequestRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyPingRecvCallback", 3, begin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionCloseCallback] - ", spdySession);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null) {
            sessionCb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionCloseCallback] - no sessionCallBack.");
        }
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionConnectCB] - ", spdySession);
        NetTimeGaurd.start(0);
        if (spdySession.sessionCallBack != null) {
            long begin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdySessionConnectCB(spdySession, superviseConnectInfo);
            NetTimeGaurd.end("spdySessionConnectCB", 0, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionConnectCB] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(0);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionFailedError] - ", spdySession);
        NetTimeGaurd.start(2);
        if (spdySession.sessionCallBack != null) {
            long begin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdySessionFailedError(spdySession, i, obj);
            spdySession.clearAllStreamCb();
            NetTimeGaurd.end("spdySessionFailedError", 2, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionFailedError] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(2);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionOnWritable] - ", spdySession);
        NetTimeGaurd.start(2);
        SessionCb sessionCb = spdySession.sessionCallBack;
        if (sessionCb != null && (sessionCb instanceof SessionExtraCb)) {
            long begin = NetTimeGaurd.begin();
            ((SessionExtraCb) spdySession.sessionCallBack).spdySessionOnWritable(spdySession, obj, i);
            NetTimeGaurd.end("spdySessionOnWritable", 2, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionOnWritable] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(2);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, int i2, SuperviseData superviseData) {
        Spdycb spdycb;
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] - ", spdySession);
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && (spdycb = spdyStream.callBack) != null) {
            spdycb.spdyStreamCloseCallback(spdySession, j, i, spdyStream.streamContext, superviseData);
            spdySession.removeSpdyStream(i2);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyStreamCloseCallback", 3, begin);
        NetTimeGaurd.finish(3);
    }
}
