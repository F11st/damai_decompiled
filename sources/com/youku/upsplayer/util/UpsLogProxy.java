package com.youku.upsplayer.util;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UpsLogProxy {
    private LogProxyWorker mProxy = new LogProxyWorker() { // from class: com.youku.upsplayer.util.UpsLogProxy.1
        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int d(String str, String str2) {
            return Log.d(str, str2);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int d(String str, String str2, Throwable th) {
            return Log.d(str, str2, th);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int e(String str, String str2) {
            return Log.e(str, str2);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int e(String str, String str2, Throwable th) {
            return Log.e(str, str2, th);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int i(String str, String str2) {
            return Log.i(str, str2);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int i(String str, String str2, Throwable th) {
            return Log.i(str, str2, th);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int v(String str, String str2) {
            return Log.v(str, str2);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int v(String str, String str2, Throwable th) {
            return Log.v(str, str2, th);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int w(String str, String str2) {
            return Log.w(str, str2);
        }

        @Override // com.youku.upsplayer.util.UpsLogProxy.LogProxyWorker
        public int w(String str, String str2, Throwable th) {
            return Log.w(str, str2, th);
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class Holder {
        private static final UpsLogProxy instance = new UpsLogProxy();

        private Holder() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface LogProxyWorker {
        int d(String str, String str2);

        int d(String str, String str2, Throwable th);

        int e(String str, String str2);

        int e(String str, String str2, Throwable th);

        int i(String str, String str2);

        int i(String str, String str2, Throwable th);

        int v(String str, String str2);

        int v(String str, String str2, Throwable th);

        int w(String str, String str2);

        int w(String str, String str2, Throwable th);
    }

    UpsLogProxy() {
    }

    public static UpsLogProxy getInstance() {
        return Holder.instance;
    }

    public LogProxyWorker getProxy() {
        return this.mProxy;
    }

    public void setProxy(LogProxyWorker logProxyWorker) {
        this.mProxy = logProxyWorker;
    }
}
