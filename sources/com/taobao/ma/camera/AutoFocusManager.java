package com.taobao.ma.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class AutoFocusManager implements Camera.AutoFocusCallback {
    private static final long AUTO_FOCUS_INTERVAL_MS = 2000;
    private static final Collection<String> FOCUS_MODES_CALLING_AF;
    private static final String TAG = AutoFocusManager.class.getSimpleName();
    private final Camera camera;
    private Handler firstFocusHandler;
    private boolean focusing;
    private AsyncTask<?, ?, ?> outstandingTask;
    private boolean stopped;
    private final boolean useAutoFocus;
    private long autoFocusInterval = 2000;
    private OnAutoFocusListener focusListener = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public final class AutoFocusTask extends AsyncTask<Object, Object, Object> {
        private AutoFocusTask() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(AutoFocusManager.this.autoFocusInterval);
            } catch (InterruptedException unused) {
            }
            AutoFocusManager.this.start();
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnAutoFocusListener {
        void onFocus(boolean z);
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        FOCUS_MODES_CALLING_AF = arrayList;
        arrayList.add("auto");
        arrayList.add(BQCCameraParam.FOCUS_TYPE_MACRO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoFocusManager(Context context, Camera camera) {
        this.camera = camera;
        this.firstFocusHandler = new Handler(context.getMainLooper()) { // from class: com.taobao.ma.camera.AutoFocusManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AutoFocusManager.this.start();
            }
        };
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = true;
        z = (defaultSharedPreferences.getBoolean("preferences_auto_focus", true) && FOCUS_MODES_CALLING_AF.contains(focusMode)) ? false : false;
        this.useAutoFocus = z;
        String str = TAG;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
    }

    private synchronized void autoFocusAgainLater() {
        if (!this.stopped && this.outstandingTask == null) {
            AutoFocusTask autoFocusTask = new AutoFocusTask();
            try {
                autoFocusTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.outstandingTask = autoFocusTask;
            } catch (RejectedExecutionException e) {
                Log.w(TAG, "Could not request auto focus", e);
            }
        }
    }

    private synchronized void cancelOutstandingTask() {
        AsyncTask<?, ?, ?> asyncTask = this.outstandingTask;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.outstandingTask.cancel(true);
            }
            this.outstandingTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void start() {
        if (this.useAutoFocus) {
            this.outstandingTask = null;
            if (!this.stopped && !this.focusing) {
                try {
                    this.camera.autoFocus(this);
                    this.focusing = true;
                } catch (RuntimeException e) {
                    Log.w(TAG, "Unexpected exception while focusing", e);
                    autoFocusAgainLater();
                }
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.focusing = false;
        OnAutoFocusListener onAutoFocusListener = this.focusListener;
        if (onAutoFocusListener != null) {
            onAutoFocusListener.onFocus(z);
        }
        autoFocusAgainLater();
    }

    public synchronized void restart() {
        this.stopped = false;
        start();
    }

    public void setAutoFocusInterval(long j) {
        if (j >= 0) {
            this.autoFocusInterval = j;
        }
    }

    public void setFocusListener(OnAutoFocusListener onAutoFocusListener) {
        this.focusListener = onAutoFocusListener;
    }

    public void startAutoFocus(long j) {
        Handler handler;
        if (j < 0 || (handler = this.firstFocusHandler) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(0, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        this.stopped = true;
        if (this.useAutoFocus) {
            cancelOutstandingTask();
            try {
                this.camera.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(TAG, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
