package com.youku.asyncview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.youku.asyncview.utils.ThreadUtil;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AsyncPlusLayoutInflater {
    private static final String TAG = "AsyncPlusLayoutInflater";
    LayoutInflater mInflater;
    private OnFastFinishedListener mOnFastFinishedListener;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.youku.asyncview.AsyncPlusLayoutInflater.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.view == null && inflateRequest.errorAndMainCreate) {
                inflateRequest.view = AsyncPlusLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            OnInflateFinishedListener onInflateFinishedListener = inflateRequest.callback;
            if (onInflateFinishedListener != null) {
                onInflateFinishedListener.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            }
            AsyncPlusLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    };
    Handler mHandler = new Handler(Looper.getMainLooper(), this.mHandlerCallback);
    InflateThread mInflateThread = InflateThread.getInstance();
    private boolean mErrorAndMainCreate = true;
    private boolean mEnableMainHandlerCallback = true;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : sClassPrefixList) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class InflateRequest {
        OnInflateFinishedListener callback;
        boolean enableMainHandlerCallback;
        boolean errorAndMainCreate;
        AsyncPlusLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        InflateRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<InflateRequest> mQueue = new ArrayBlockingQueue<>(64);
        private Pools.SynchronizedPool<InflateRequest> mRequestPool = new Pools.SynchronizedPool<>(64);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.mRequestPool.acquire();
            return acquire == null ? new InflateRequest() : acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.view = null;
            inflateRequest.errorAndMainCreate = false;
            inflateRequest.enableMainHandlerCallback = false;
            this.mRequestPool.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncPlusLayoutInflater.forceSetMainLoop();
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.mQueue.take();
                try {
                    take.view = take.inflater.mInflater.inflate(take.resid, take.parent, false);
                } catch (RuntimeException e) {
                    Log.w(AsyncPlusLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                OnFastFinishedListener onFastFinishedListener = take.inflater.mOnFastFinishedListener;
                if (onFastFinishedListener != null) {
                    onFastFinishedListener.onInflateFastFinished(take.view, take.resid, take.parent);
                }
                if (take.enableMainHandlerCallback) {
                    Message.obtain(take.inflater.mHandler, 0, take).sendToTarget();
                } else {
                    releaseRequest(take);
                }
            } catch (InterruptedException e2) {
                Log.w(AsyncPlusLayoutInflater.TAG, e2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnFastFinishedListener {
        void onInflateFastFinished(View view, int i, ViewGroup viewGroup);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnInflateFinishedListener {
        void onInflateFinished(View view, int i, ViewGroup viewGroup);
    }

    public AsyncPlusLayoutInflater(Context context) {
        this.mInflater = new BasicInflater(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void forceSetMainLoop() {
        ThreadUtil.forceSetMainLoop();
    }

    public void inflate(int i, ViewGroup viewGroup, OnInflateFinishedListener onInflateFinishedListener) {
        InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
        obtainRequest.inflater = this;
        obtainRequest.resid = i;
        obtainRequest.parent = viewGroup;
        obtainRequest.callback = onInflateFinishedListener;
        obtainRequest.enableMainHandlerCallback = this.mEnableMainHandlerCallback;
        obtainRequest.errorAndMainCreate = this.mErrorAndMainCreate;
        this.mInflateThread.enqueue(obtainRequest);
    }

    public void setEnableMainHandlerCallback(boolean z) {
        this.mEnableMainHandlerCallback = z;
    }

    public void setErrorAndMainCreate(boolean z) {
        this.mErrorAndMainCreate = z;
    }

    public void setOnFastFinishedListener(OnFastFinishedListener onFastFinishedListener) {
        this.mOnFastFinishedListener = onFastFinishedListener;
    }
}
