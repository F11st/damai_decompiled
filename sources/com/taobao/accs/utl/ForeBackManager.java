package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.asp.AThreadPool;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.init.Launcher_InitAccs;
import com.taobao.agoo.TaobaoRegister;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ForeBackManager implements Application.ActivityLifecycleCallbacks {
    static String ACTION_BACK = null;
    static String ACTION_FORE = null;
    public static final String ACTION_STATE_BACK = "ACTION_STATE_BACK";
    public static final String ACTION_STATE_FORE = "ACTION_STATE_FORE";
    private static final int FIRST = 1;
    private static final int LAUNCH = 2;
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;
    private static ArrayList<ClickMessageRunnable> clickMessageRunnableArrayList;
    private static Application context;
    private static volatile ForeBackManager foreBackManager;
    private static ArrayList<ForeBackStateListener> foreBackStateListenerArrayList;
    private boolean isComeFromBg;
    private static final String TAG = ForeBackManager.class.getSimpleName();
    private static boolean setFlag = false;
    private int flag = 0;
    private int count = 0;
    private int state = 1;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ClickMessageRunnable implements Runnable {
        private long lastActiveTime = OrangeAdapter.getLastActiveTime(ForeBackManager.context);
        private String msgId;
        private int startFlag;

        public ClickMessageRunnable(String str, int i) {
            this.msgId = str;
            this.startFlag = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ALog.e(ForeBackManager.TAG, "click report", "lastActiveTime", Long.valueOf(this.lastActiveTime), "currentActiveTime", Long.valueOf(currentTimeMillis));
            long j = this.lastActiveTime;
            if (j == 0 || UtilityImpl.isSameDay(j, currentTimeMillis)) {
                this.startFlag |= 8;
            }
            TaobaoRegister.clickMessage(ForeBackManager.context, this.msgId, null, this.startFlag, this.lastActiveTime);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ForeBackStateListener {
        void onBackState(Context context);

        void onForeState(Context context);
    }

    private ForeBackManager() {
        clickMessageRunnableArrayList = new ArrayList<>();
        foreBackStateListenerArrayList = new ArrayList<>();
    }

    public static ForeBackManager getManager() {
        if (foreBackManager == null) {
            synchronized (ForeBackManager.class) {
                if (foreBackManager == null) {
                    foreBackManager = new ForeBackManager();
                }
            }
        }
        return foreBackManager;
    }

    public int getState() {
        return this.state;
    }

    public void initialize(Application application) {
        if (context == null) {
            GlobalClientInfo.mContext = application;
            context = application;
            ACTION_FORE = context.getPackageName() + JSMethod.NOT_SET + ACTION_STATE_FORE;
            ACTION_BACK = context.getPackageName() + JSMethod.NOT_SET + ACTION_STATE_BACK;
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i = this.flag;
        if ((i & 1) != 1) {
            int i2 = i | 1;
            this.flag = i2;
            this.flag = i2 | 2;
        } else if ((i & 2) == 2) {
            this.flag = i & (-3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.isComeFromBg) {
            AThreadPool.submitSingleTask(new Runnable() { // from class: com.taobao.accs.utl.ForeBackManager.3
                @Override // java.lang.Runnable
                public void run() {
                    OrangeAdapter.saveLastActiveTime(ForeBackManager.context, System.currentTimeMillis());
                    if (ForeBackManager.setFlag) {
                        return;
                    }
                    OrangeAdapter.setADaemonTriggerType(ForeBackManager.context);
                    OrangeAdapter.setDefaultVersion(ForeBackManager.context);
                    boolean unused = ForeBackManager.setFlag = true;
                }
            });
        }
        this.isComeFromBg = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i = this.count;
        this.count = i + 1;
        if (i == 0) {
            ALog.i(TAG, "onActivityStarted back to force", new Object[0]);
            this.isComeFromBg = true;
            this.state = 1;
            ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.utl.ForeBackManager.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = ForeBackManager.foreBackStateListenerArrayList.iterator();
                    while (it.hasNext()) {
                        ForeBackStateListener foreBackStateListener = (ForeBackStateListener) it.next();
                        if (foreBackStateListener != null) {
                            foreBackStateListener.onForeState(ForeBackManager.context);
                        }
                    }
                }
            });
        }
        int i2 = (this.isComeFromBg ? 4 : 0) | ((this.flag & 2) == 2 ? 2 : 1);
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        try {
            Intent intent = activity.getIntent();
            String stringExtra = intent.getStringExtra("AliAgooMsgID");
            if (!TextUtils.isEmpty(stringExtra)) {
                ALog.i(TAG, "onActivityStarted isFromAgoo", new Object[0]);
                intent.removeExtra("AliAgooMsgID");
                final ClickMessageRunnable clickMessageRunnable = new ClickMessageRunnable(stringExtra, i2);
                if (Launcher_InitAccs.mIsInited) {
                    ThreadPoolExecutorFactory.execute(clickMessageRunnable);
                } else {
                    ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.utl.ForeBackManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ForeBackManager.clickMessageRunnableArrayList.add(clickMessageRunnable);
                        }
                    });
                }
            }
        } catch (Exception e) {
            ALog.e(TAG, "onActivityStarted Error:", e, new Object[0]);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int max = Math.max(0, this.count - 1);
        this.count = max;
        if (max == 0) {
            this.state = 0;
            ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.utl.ForeBackManager.4
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = ForeBackManager.foreBackStateListenerArrayList.iterator();
                    while (it.hasNext()) {
                        ForeBackStateListener foreBackStateListener = (ForeBackStateListener) it.next();
                        if (foreBackStateListener != null) {
                            foreBackStateListener.onBackState(ForeBackManager.context);
                        }
                    }
                }
            });
        }
    }

    public void registerForeBackStateListener(ForeBackStateListener foreBackStateListener) {
        if (foreBackStateListener != null) {
            foreBackStateListenerArrayList.add(foreBackStateListener);
        }
    }

    public void reportSaveClickMessage() {
        ArrayList<ClickMessageRunnable> arrayList = clickMessageRunnableArrayList;
        if (arrayList != null) {
            Iterator<ClickMessageRunnable> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            clickMessageRunnableArrayList.clear();
        }
    }

    public void uninitialize(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void unregisterForeBackStateListener(ForeBackStateListener foreBackStateListener) {
        if (foreBackStateListener != null) {
            foreBackStateListenerArrayList.remove(foreBackStateListener);
        }
    }
}
