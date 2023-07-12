package com.taobao.weex.bridge;

import android.util.SparseArray;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ResultCallbackManager {
    private static SparseArray<ResultCallback> mResultCallbacks = new SparseArray<>();
    private static long sCallbackId;

    ResultCallbackManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long generateCallbackId(ResultCallback resultCallback) {
        if (sCallbackId >= 2147483647L) {
            sCallbackId = 0L;
        }
        long j = sCallbackId;
        sCallbackId = 1 + j;
        int i = (int) j;
        mResultCallbacks.put(i, resultCallback);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResultCallback removeCallbackById(long j) {
        int i = (int) j;
        ResultCallback resultCallback = mResultCallbacks.get(i);
        mResultCallbacks.remove(i);
        return resultCallback;
    }
}
