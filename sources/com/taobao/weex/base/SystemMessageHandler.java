package com.taobao.weex.base;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.Serializable;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SystemMessageHandler extends Handler implements Serializable {
    private static final int SCHEDULED_WORK = 1;
    private static final String TAG = "SystemMessageHandler";
    private Method mMessageMethodSetAsynchronous;
    private long mMessagePumpDelegateNative;

    private SystemMessageHandler(long j) {
        this.mMessagePumpDelegateNative = 0L;
        this.mMessagePumpDelegateNative = j;
        try {
            this.mMessageMethodSetAsynchronous = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Failed to find android.os.Message class:" + e);
        } catch (NoSuchMethodException e2) {
            Log.e(TAG, "Failed to load Message.setAsynchronous method:" + e2);
        } catch (RuntimeException e3) {
            Log.e(TAG, "Exception while loading Message.setAsynchronous method: " + e3);
        }
    }

    @CalledByNative
    public static SystemMessageHandler create(long j) {
        return new SystemMessageHandler(j);
    }

    private native void nativeRunWork(long j);

    private Message obtainAsyncMessage(int i) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return obtain;
    }

    @CalledByNative
    private void scheduleDelayedWork(long j) {
        sendMessageDelayed(obtainAsyncMessage(1), j);
    }

    @CalledByNative
    private void scheduleWork() {
        sendMessage(obtainAsyncMessage(1));
    }

    @CalledByNative
    private void stop() {
        removeMessages(1);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        nativeRunWork(this.mMessagePumpDelegateNative);
    }
}
