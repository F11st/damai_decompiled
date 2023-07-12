package com.youku.asyncview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.youku.asyncview.AsyncPlusLayoutInflater;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class AbstractLayoutPreLoader {
    private static final String TAG = "LayoutPreLoader";
    private PreInflateFinishedListener mCurPreInflateFinishedListener;
    private boolean mDebug = false;
    private ArrayList<View> mViewPool;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class PreInflateFinishedListener implements AsyncPlusLayoutInflater.OnFastFinishedListener, AsyncPlusLayoutInflater.OnInflateFinishedListener {
        private boolean mDebug;
        private ArrayList<View> mViewPool;

        private PreInflateFinishedListener() {
        }

        @Override // com.youku.asyncview.AsyncPlusLayoutInflater.OnFastFinishedListener
        public void onInflateFastFinished(View view, int i, ViewGroup viewGroup) {
            if (this.mDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInflateFastFinished: mViewPool = ");
                sb.append(this.mViewPool != null);
                sb.append(",view = ");
                sb.append(view);
                Log.e(AbstractLayoutPreLoader.TAG, sb.toString());
            }
            ArrayList<View> arrayList = this.mViewPool;
            if (arrayList == null || view == null) {
                return;
            }
            synchronized (arrayList) {
                if (!arrayList.contains(view)) {
                    if (this.mDebug) {
                        Log.e(AbstractLayoutPreLoader.TAG, "onInflateFastFinished: add");
                    }
                    arrayList.add(view);
                }
            }
        }

        @Override // com.youku.asyncview.AsyncPlusLayoutInflater.OnInflateFinishedListener
        public void onInflateFinished(View view, int i, ViewGroup viewGroup) {
        }

        public void setDebug(boolean z) {
            this.mDebug = z;
        }

        public void setViewPool(ArrayList<View> arrayList) {
            this.mViewPool = arrayList;
        }
    }

    public AbstractLayoutPreLoader(int i) {
        this.mViewPool = new ArrayList<>(i);
    }

    public void clean() {
        synchronized (this.mViewPool) {
            if (this.mDebug) {
                Log.e(TAG, "clean: size = " + this.mViewPool.size() + ",this = " + this);
            }
            this.mViewPool.clear();
        }
        PreInflateFinishedListener preInflateFinishedListener = this.mCurPreInflateFinishedListener;
        if (preInflateFinishedListener != null) {
            preInflateFinishedListener.setViewPool(null);
        }
        this.mCurPreInflateFinishedListener = null;
    }

    public abstract int getPreLoadLayoutId();

    public View popView(int i) {
        View remove;
        if (i != getPreLoadLayoutId()) {
            return null;
        }
        synchronized (this.mViewPool) {
            if (this.mDebug) {
                Log.e(TAG, "popView: size = " + this.mViewPool.size());
            }
            remove = this.mViewPool.size() > 0 ? this.mViewPool.remove(0) : null;
            if (this.mDebug) {
                Log.e(TAG, "popView: view = " + remove + ",size = " + this.mViewPool.size());
            }
        }
        return remove;
    }

    public void preLoad(Context context, ViewGroup viewGroup, int i) {
        synchronized (this.mViewPool) {
            this.mViewPool.clear();
        }
        PreInflateFinishedListener preInflateFinishedListener = this.mCurPreInflateFinishedListener;
        if (preInflateFinishedListener != null) {
            preInflateFinishedListener.setViewPool(null);
        }
        this.mCurPreInflateFinishedListener = null;
        PreInflateFinishedListener preInflateFinishedListener2 = new PreInflateFinishedListener();
        preInflateFinishedListener2.setViewPool(this.mViewPool);
        preInflateFinishedListener2.setDebug(this.mDebug);
        this.mCurPreInflateFinishedListener = preInflateFinishedListener2;
        AsyncPlusLayoutInflater asyncPlusLayoutInflater = new AsyncPlusLayoutInflater(context);
        asyncPlusLayoutInflater.setErrorAndMainCreate(false);
        asyncPlusLayoutInflater.setEnableMainHandlerCallback(false);
        asyncPlusLayoutInflater.setOnFastFinishedListener(preInflateFinishedListener2);
        for (int i2 = 0; i2 < i; i2++) {
            asyncPlusLayoutInflater.inflate(getPreLoadLayoutId(), viewGroup, preInflateFinishedListener2);
        }
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public void preLoad(Context context, int i) {
        preLoad(context, null, i);
    }
}
