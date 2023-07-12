package com.taobao.android.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.taobao.android.compat.ApplicationCompat;
import com.taobao.android.task.SafeAsyncTask;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import tb.s40;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PanguApplication extends ApplicationCompat {
    protected static final Handler mAppHandler = new Handler(Looper.getMainLooper());
    protected WeakReference<Activity> mWeakActivity;
    protected final List<CrossActivityLifecycleCallback> mCrossActivityLifecycleCallbacks = new CopyOnWriteArrayList();
    protected final AtomicInteger mCreationCount = new AtomicInteger();
    protected final AtomicInteger mStartCount = new AtomicInteger();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface CrossActivityLifecycleCallback {
        void onCreated(Activity activity);

        void onDestroyed(Activity activity);

        void onStarted(Activity activity);

        void onStopped(Activity activity);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class StickCrossRunnable implements Runnable {
        private CrossActivityLifecycleCallback callback;
        private String method;

        public StickCrossRunnable(CrossActivityLifecycleCallback crossActivityLifecycleCallback, String str) {
            this.callback = crossActivityLifecycleCallback;
            this.method = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            WeakReference<Activity> weakReference = PanguApplication.this.mWeakActivity;
            if (weakReference != null && (activity = weakReference.get()) != null && this.callback != null) {
                if (s40.b()) {
                    PanguApplication.timeingCallbackMethod(this.callback, activity, this.method);
                } else if ("onCreated".equals(this.method)) {
                    this.callback.onCreated(activity);
                } else if ("onStarted".equals(this.method)) {
                    this.callback.onStarted(activity);
                }
            }
            this.callback = null;
            this.method = null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements ApplicationCompat.ActivityLifecycleCallbacksCompat {
        a() {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
            Log.d("TaobaoInitializer", "CrossActivityLifecycleCallbacks internal:" + PanguApplication.this.mCrossActivityLifecycleCallbacks.size() + " " + PanguApplication.this.mCrossActivityLifecycleCallbacks.toString());
            PanguApplication.this.mWeakActivity = new WeakReference<>(activity);
            if (PanguApplication.this.mCreationCount.getAndIncrement() != 0 || PanguApplication.this.mCrossActivityLifecycleCallbacks.isEmpty()) {
                return;
            }
            for (CrossActivityLifecycleCallback crossActivityLifecycleCallback : PanguApplication.this.mCrossActivityLifecycleCallbacks) {
                if (s40.b()) {
                    try {
                        PanguApplication.timeingCallbackMethod(crossActivityLifecycleCallback, activity, "onCreated");
                    } catch (Exception e) {
                        Log.e("TaobaoInitializer", crossActivityLifecycleCallback + "onCreated exception", e);
                    }
                } else {
                    crossActivityLifecycleCallback.onCreated(activity);
                }
            }
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityDestroyed(Activity activity) {
            if (PanguApplication.this.mCreationCount.decrementAndGet() != 0 || PanguApplication.this.mCrossActivityLifecycleCallbacks.isEmpty()) {
                return;
            }
            for (CrossActivityLifecycleCallback crossActivityLifecycleCallback : PanguApplication.this.mCrossActivityLifecycleCallbacks) {
                if (s40.b()) {
                    PanguApplication.timeingCallbackMethod(crossActivityLifecycleCallback, activity, "onDestroyed");
                } else {
                    crossActivityLifecycleCallback.onDestroyed(activity);
                }
            }
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityPaused(Activity activity) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityResumed(Activity activity) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityStarted(Activity activity) {
            if (PanguApplication.this.mStartCount.getAndIncrement() != 0 || PanguApplication.this.mCrossActivityLifecycleCallbacks.isEmpty()) {
                return;
            }
            for (CrossActivityLifecycleCallback crossActivityLifecycleCallback : PanguApplication.this.mCrossActivityLifecycleCallbacks) {
                if (s40.b()) {
                    PanguApplication.timeingCallbackMethod(crossActivityLifecycleCallback, activity, "onStarted");
                } else {
                    crossActivityLifecycleCallback.onStarted(activity);
                }
            }
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityStopped(Activity activity) {
            if (PanguApplication.this.mStartCount.decrementAndGet() != 0 || PanguApplication.this.mCrossActivityLifecycleCallbacks.isEmpty()) {
                return;
            }
            for (CrossActivityLifecycleCallback crossActivityLifecycleCallback : PanguApplication.this.mCrossActivityLifecycleCallbacks) {
                if (s40.b()) {
                    PanguApplication.timeingCallbackMethod(crossActivityLifecycleCallback, activity, "onStopped");
                } else {
                    crossActivityLifecycleCallback.onStopped(activity);
                }
            }
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        mAppHandler.post(runnable);
    }

    protected static void timeingCallbackMethod(CrossActivityLifecycleCallback crossActivityLifecycleCallback, Activity activity, String str) {
        long nanoTime = System.nanoTime();
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        if ("onCreated".equals(str)) {
            crossActivityLifecycleCallback.onCreated(activity);
        } else if ("onStarted".equals(str)) {
            crossActivityLifecycleCallback.onStarted(activity);
        } else if ("onStopped".equals(str)) {
            crossActivityLifecycleCallback.onStopped(activity);
        } else if ("onDestroyed".equals(str)) {
            crossActivityLifecycleCallback.onDestroyed(activity);
        }
        Log.i("Coord", "CrossLifeTiming - " + crossActivityLifecycleCallback.getClass().getName() + " " + str + " " + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000) + "ms (cpu) / " + ((System.nanoTime() - nanoTime) / 1000000) + "ms (real)");
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        s40.a(this);
        registerActivityLifecycleCallbacks(new a());
        SafeAsyncTask.init();
    }

    public void registerCrossActivityLifecycleCallback(CrossActivityLifecycleCallback crossActivityLifecycleCallback) {
        if (crossActivityLifecycleCallback == null) {
            RuntimeException runtimeException = new RuntimeException("registerCrossActivityLifecycleCallback must not be null");
            runtimeException.fillInStackTrace();
            Log.w("Pangu", "Called: " + this, runtimeException);
            return;
        }
        this.mCrossActivityLifecycleCallbacks.add(crossActivityLifecycleCallback);
        if (this.mCreationCount.get() > 0) {
            mAppHandler.post(new StickCrossRunnable(crossActivityLifecycleCallback, "onCreated"));
        }
        if (this.mStartCount.get() > 0) {
            mAppHandler.post(new StickCrossRunnable(crossActivityLifecycleCallback, "onStarted"));
        }
    }

    public void unregisterCrossActivityLifecycleCallback(CrossActivityLifecycleCallback crossActivityLifecycleCallback) {
        this.mCrossActivityLifecycleCallbacks.remove(crossActivityLifecycleCallback);
    }
}
