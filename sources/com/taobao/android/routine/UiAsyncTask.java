package com.taobao.android.routine;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import com.taobao.android.compat.ActivityCompatJellyBean;
import com.taobao.android.lifecycle.PanguActivity;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class UiAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private final WeakReference<Activity> mActivity;
    private UiPostExecutable<Result> mUiPostExecutable;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface UiPostExecutable<Result> {
        void onUiPostExecute(Result result);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.routine.UiAsyncTask$a */
    /* loaded from: classes11.dex */
    class C6585a implements PanguActivity.IndividualActivityLifecycleCallback {
        final /* synthetic */ Activity a;

        C6585a(Activity activity) {
            this.a = activity;
        }

        @Override // com.taobao.android.lifecycle.PanguActivity.IndividualActivityLifecycleCallback
        public void onCreated(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguActivity.IndividualActivityLifecycleCallback
        public void onDestroyed(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguActivity.IndividualActivityLifecycleCallback
        public void onPaused(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguActivity.IndividualActivityLifecycleCallback
        public void onResumed(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguActivity.IndividualActivityLifecycleCallback
        public void onStarted(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguActivity.IndividualActivityLifecycleCallback
        public void onStopped(Activity activity) {
            ((PanguActivity) this.a).unregisterIndividualActivityLifecycleCallback(this);
            UiAsyncTask.this.cancel(false);
        }
    }

    public UiAsyncTask(Activity activity, UiPostExecutable<Result> uiPostExecutable) {
        if (!getClass().isAnonymousClass()) {
            if (activity instanceof PanguActivity) {
                ((PanguActivity) activity).registerIndividualActivityLifecycleCallback(new C6585a(activity));
            }
            this.mActivity = new WeakReference<>(activity);
            this.mUiPostExecutable = uiPostExecutable;
            return;
        }
        throw new IllegalStateException("UiAsyncTask must be explicitly derived to avoid activity leak.");
    }

    @TargetApi(17)
    private static boolean isActivityDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        if (activity instanceof ActivityCompatJellyBean) {
            return ((ActivityCompatJellyBean) activity).isDestroyed();
        }
        return false;
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Result result) {
        Activity activity = this.mActivity.get();
        if (activity == null || activity.isFinishing() || isActivityDestroyed(activity)) {
            return;
        }
        this.mUiPostExecutable.onUiPostExecute(result);
        this.mUiPostExecutable = null;
    }
}
