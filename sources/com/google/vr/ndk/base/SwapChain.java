package com.google.vr.ndk.base;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SwapChain {
    private static final String TAG = "SwapChain";
    private long nativeSwapChain;

    protected void finalize() throws Throwable {
        try {
            if (this.nativeSwapChain != 0) {
                Log.w(TAG, "SwapChain.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    public void shutdown() {
        long j = this.nativeSwapChain;
        if (j != 0) {
            GvrApi.nativeSwapChainDestroy(j);
            this.nativeSwapChain = 0L;
        }
    }
}
