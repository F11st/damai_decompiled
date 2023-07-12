package com.taobao.tao.log.task;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.taobao.tao.log.CommandDataCenter;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.MessageReponse;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.task.PullTask;
import com.taobao.tao.log.utils.TLogThreadPool;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PullTask {
    private static String TAG = "TLOG.PullTask";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @TargetApi(14)
    /* loaded from: classes11.dex */
    public class AdapterActivityLifeCycle implements Application.ActivityLifecycleCallbacks {
        private int mActivitiesActive;
        private boolean mIsInForeground;

        private AdapterActivityLifeCycle() {
            this.mActivitiesActive = 0;
            this.mIsInForeground = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.mActivitiesActive++;
            if (!this.mIsInForeground) {
                PullTask.this.pull();
            }
            this.mIsInForeground = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i = this.mActivitiesActive - 1;
            this.mActivitiesActive = i;
            if (i == 0) {
                this.mIsInForeground = false;
                PullTask.this.pull();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CreateInstance {
        private static PullTask instance = new PullTask();

        private CreateInstance() {
        }
    }

    public static PullTask getInstance() {
        return CreateInstance.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$pull$0() {
        try {
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_PULL, TAG, "消息拉取：主动发送消息，拉取任务");
            SendMessage.pull(TLogInitializer.getInstance().getContext());
        } catch (Exception e) {
            Log.e(TAG, "pull task error", e);
        }
    }

    public void handle(MessageReponse messageReponse) {
        CommandDataCenter.getInstance().onData(messageReponse.serviceId, messageReponse.userId, messageReponse.dataId, messageReponse.result.getBytes());
    }

    public void pull() {
        TLogThreadPool.getInstance().execute(new Runnable() { // from class: tb.zx1
            @Override // java.lang.Runnable
            public final void run() {
                PullTask.lambda$pull$0();
            }
        });
    }

    public void start() {
        pull();
        Application application = TLogInitializer.getInstance().getApplication();
        if (application != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 14) {
                application.registerActivityLifecycleCallbacks(new AdapterActivityLifeCycle());
            } else {
                Log.w(TAG, String.format("build version %s not suppert, registerActivityLifecycleCallbacks failed", Integer.valueOf(i)));
            }
        }
    }

    private PullTask() {
    }
}
