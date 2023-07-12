package com.taobao.tao.log.godeye.core.control;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.model.joint.point.EventJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.LifecycleJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.NotificationJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.TimerJointPoint;
import com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter;
import com.taobao.tao.log.godeye.protocol.model.ClientEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GodeyeJointPointCenter implements IGodeyeJointPointCenter {
    private String lastVisitedPage;
    private final Application mApplication;
    private ConcurrentHashMap<String, List<IGodeyeJointPointCenter.GodeyeJointPointCallback>> mActivityLifecycleJointPointHandlers = new ConcurrentHashMap<>();
    private Vector<IGodeyeJointPointCenter.GodeyeJointPointCallback> mEnterBackgroundJointPointHandlers = new Vector<>();
    private Vector<IGodeyeJointPointCenter.GodeyeJointPointCallback> mEnterForegroundJointPointHandlers = new Vector<>();
    private ConcurrentHashMap<String, List<IGodeyeJointPointCenter.GodeyeJointPointCallback>> mCustomEventJointPointHandlers = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class DelayStopHandler extends Handler {
        private final IGodeyeJointPointCenter.GodeyeJointPointCallback mGodeyeJointPointCallback;

        DelayStopHandler(IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
            this.mGodeyeJointPointCallback = godeyeJointPointCallback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.mGodeyeJointPointCallback.doCallback();
        }
    }

    /* compiled from: Taobao */
    @TargetApi(14)
    /* loaded from: classes11.dex */
    class GodeyeAppLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        private int mActivityCounter = 0;

        GodeyeAppLifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Godeye.sharedInstance().isDebugMode()) {
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(activity.getClass().getName(), Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (Godeye.sharedInstance().isDebugMode()) {
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(activity.getClass().getName(), Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
                Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), buildLifecycleKey, null));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (Godeye.sharedInstance().isDebugMode()) {
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(activity.getClass().getName(), Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
                Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), buildLifecycleKey, null));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (Godeye.sharedInstance().isDebugMode()) {
                String name = activity.getClass().getName();
                GodeyeJointPointCenter.this.lastVisitedPage = name;
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(name, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
                Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), buildLifecycleKey, null));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            if (Godeye.sharedInstance().isDebugMode()) {
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(activity.getClass().getName(), Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_SAVEINSTANCESTATE);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.mActivityCounter++;
            if (Godeye.sharedInstance().isDebugMode()) {
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(activity.getClass().getName(), Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
                Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), buildLifecycleKey, null));
                if (this.mActivityCounter == 1) {
                    GodeyeJointPointCenter godeyeJointPointCenter2 = GodeyeJointPointCenter.this;
                    godeyeJointPointCenter2.executeAndClearCallbacks(godeyeJointPointCenter2.mEnterForegroundJointPointHandlers);
                    Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), "enter_foreground", null));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            this.mActivityCounter--;
            if (Godeye.sharedInstance().isDebugMode()) {
                String buildLifecycleKey = GodeyeJointPointCenter.buildLifecycleKey(activity.getClass().getName(), Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED);
                GodeyeJointPointCenter godeyeJointPointCenter = GodeyeJointPointCenter.this;
                godeyeJointPointCenter.executeAndClearCallbacks((List) godeyeJointPointCenter.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey));
                Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), buildLifecycleKey, null));
                if (this.mActivityCounter == 0) {
                    GodeyeJointPointCenter godeyeJointPointCenter2 = GodeyeJointPointCenter.this;
                    godeyeJointPointCenter2.executeAndClearCallbacks(godeyeJointPointCenter2.mEnterBackgroundJointPointHandlers);
                    Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), "enter_background", null));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class GodeyeBroadcastReceiver extends BroadcastReceiver {
        private final Context mContext;
        private final IGodeyeJointPointCenter.GodeyeJointPointCallback mGodeyeJointPointCallback;

        GodeyeBroadcastReceiver(Context context, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
            this.mContext = context;
            this.mGodeyeJointPointCallback = godeyeJointPointCallback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.mGodeyeJointPointCallback.doCallback();
            if (this.mGodeyeJointPointCallback.isDisposable()) {
                this.mContext.unregisterReceiver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class GodeyeJointPointCallbackWithStartHook extends IGodeyeJointPointCenter.GodeyeJointPointCallback {
        private final IGodeyeJointPointCenter.GodeyeJointPointCallback mGodeyeJointPointCallback;

        public GodeyeJointPointCallbackWithStartHook(IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
            this.mGodeyeJointPointCallback = godeyeJointPointCallback;
        }

        @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
        public void doCallback() {
            this.mGodeyeJointPointCallback.doCallback();
            Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), "global_start", null));
        }

        @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
        public boolean isDisposable() {
            return this.mGodeyeJointPointCallback.isDisposable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class GodeyeJointPointCallbackWithStopHook extends IGodeyeJointPointCenter.GodeyeJointPointCallback {
        private final IGodeyeJointPointCenter.GodeyeJointPointCallback mGodeyeJointPointCallback;

        public GodeyeJointPointCallbackWithStopHook(IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
            this.mGodeyeJointPointCallback = godeyeJointPointCallback;
        }

        @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
        public void doCallback() {
            Godeye.sharedInstance().addClientEvent(new ClientEvent(Long.valueOf(System.currentTimeMillis()), "global_end", null));
            this.mGodeyeJointPointCallback.doCallback();
        }

        @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
        public boolean isDisposable() {
            return this.mGodeyeJointPointCallback.isDisposable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class GodeyeStartJointPointCallbackWithDelayStop extends IGodeyeJointPointCenter.GodeyeJointPointCallback {
        private final long mDelayStopMilliSeconds;
        private final IGodeyeJointPointCenter.GodeyeJointPointCallback mGodeyeJointPointCallbackStart;
        private final IGodeyeJointPointCenter.GodeyeJointPointCallback mGodeyeJointPointCallbackStop;

        GodeyeStartJointPointCallbackWithDelayStop(long j, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback2) {
            this.mDelayStopMilliSeconds = j;
            this.mGodeyeJointPointCallbackStart = godeyeJointPointCallback;
            this.mGodeyeJointPointCallbackStop = godeyeJointPointCallback2;
        }

        @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
        public void doCallback() {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.tao.log.godeye.core.control.GodeyeJointPointCenter.GodeyeStartJointPointCallbackWithDelayStop.1
                @Override // java.lang.Runnable
                public void run() {
                    GodeyeStartJointPointCallbackWithDelayStop.this.mGodeyeJointPointCallbackStart.doCallback();
                }
            });
            if (this.mDelayStopMilliSeconds > 0) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.taobao.tao.log.godeye.core.control.GodeyeJointPointCenter.GodeyeStartJointPointCallbackWithDelayStop.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GodeyeStartJointPointCallbackWithDelayStop.this.mGodeyeJointPointCallbackStop.doCallback();
                    }
                }, this.mDelayStopMilliSeconds);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GodeyeJointPointCenter(Application application) {
        this.mApplication = application;
        application.registerActivityLifecycleCallbacks(new GodeyeAppLifecycleCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String buildLifecycleKey(String str, String str2) {
        return str + "." + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAndClearCallbacks(List<IGodeyeJointPointCenter.GodeyeJointPointCallback> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback = list.get(size);
                godeyeJointPointCallback.doCallback();
                if (godeyeJointPointCallback.isDisposable()) {
                    list.remove(size);
                }
            }
        }
    }

    private void installStartJointPoint(JointPoint jointPoint, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback, boolean z) {
        if (z && jointPoint.type.equals(StartupJointPoint.TYPE)) {
            godeyeJointPointCallback.doCallback();
        } else if (jointPoint.type.equals("lifecycle")) {
            LifecycleJointPoint lifecycleJointPoint = (LifecycleJointPoint) jointPoint;
            registerActivityLifecycleCallbackHandler(lifecycleJointPoint.page, lifecycleJointPoint.lifecycleMethod, godeyeJointPointCallback);
        } else if (jointPoint.type.equals("notification")) {
            registerBroadcastHandler(((NotificationJointPoint) jointPoint).action, godeyeJointPointCallback);
        } else if (jointPoint.type.equals("background")) {
            registerEnterBackgroundCallbackHandler(godeyeJointPointCallback);
        } else if (jointPoint.type.equals(ForegroundJointPoint.TYPE)) {
            registerEnterForegroundCallbackHandler(godeyeJointPointCallback);
        } else if (jointPoint.type.equals("event")) {
            registerCustomEventHandler(((EventJointPoint) jointPoint).eventName, godeyeJointPointCallback);
        }
    }

    private void installStopJointPoint(JointPoint jointPoint, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
        if (jointPoint.type.equals("lifecycle")) {
            LifecycleJointPoint lifecycleJointPoint = (LifecycleJointPoint) jointPoint;
            registerActivityLifecycleCallbackHandler(lifecycleJointPoint.page, lifecycleJointPoint.lifecycleMethod, godeyeJointPointCallback);
        } else if (jointPoint.type.equals("notification")) {
            registerBroadcastHandler(((NotificationJointPoint) jointPoint).action, godeyeJointPointCallback);
        } else if (jointPoint.type.equals("background")) {
            registerEnterBackgroundCallbackHandler(godeyeJointPointCallback);
        } else if (jointPoint.type.equals(ForegroundJointPoint.TYPE)) {
            registerEnterForegroundCallbackHandler(godeyeJointPointCallback);
        } else if (jointPoint.type.equals("event")) {
            registerCustomEventHandler(((EventJointPoint) jointPoint).eventName, godeyeJointPointCallback);
        }
    }

    private void registerActivityLifecycleCallbackHandler(String str, String str2, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
        String buildLifecycleKey = buildLifecycleKey(str, str2);
        List<IGodeyeJointPointCenter.GodeyeJointPointCallback> list = this.mActivityLifecycleJointPointHandlers.get(buildLifecycleKey);
        if (list != null) {
            list.add(godeyeJointPointCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(godeyeJointPointCallback);
        this.mActivityLifecycleJointPointHandlers.put(buildLifecycleKey, arrayList);
    }

    private void registerBroadcastHandler(String str, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        this.mApplication.registerReceiver(new GodeyeBroadcastReceiver(this.mApplication, godeyeJointPointCallback), intentFilter);
    }

    private void registerCustomEventHandler(String str, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
        List<IGodeyeJointPointCenter.GodeyeJointPointCallback> list = this.mCustomEventJointPointHandlers.get(str);
        if (list != null) {
            list.add(godeyeJointPointCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(godeyeJointPointCallback);
        this.mCustomEventJointPointHandlers.put(str, arrayList);
    }

    private void registerEnterBackgroundCallbackHandler(IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
        this.mEnterBackgroundJointPointHandlers.add(godeyeJointPointCallback);
    }

    private void registerEnterForegroundCallbackHandler(IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback) {
        this.mEnterForegroundJointPointHandlers.add(godeyeJointPointCallback);
    }

    @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter
    public String getLastVisitedPage() {
        return this.lastVisitedPage;
    }

    @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter
    public void installJointPoints(JointPoint jointPoint, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback, JointPoint jointPoint2, IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback2, boolean z) {
        boolean z2;
        long j;
        if (jointPoint2.type.equals("timer")) {
            z2 = true;
            j = ((TimerJointPoint) jointPoint2).waitMilliseconds;
        } else {
            z2 = false;
            j = -1;
        }
        GodeyeJointPointCallbackWithStartHook godeyeJointPointCallbackWithStartHook = new GodeyeJointPointCallbackWithStartHook(godeyeJointPointCallback);
        GodeyeJointPointCallbackWithStopHook godeyeJointPointCallbackWithStopHook = new GodeyeJointPointCallbackWithStopHook(godeyeJointPointCallback2);
        if (z2 && j > 0) {
            installStartJointPoint(jointPoint, new GodeyeStartJointPointCallbackWithDelayStop(j, godeyeJointPointCallbackWithStartHook, godeyeJointPointCallbackWithStopHook), z);
        }
        if (z2) {
            return;
        }
        installStartJointPoint(jointPoint, godeyeJointPointCallbackWithStartHook, z);
        installStopJointPoint(jointPoint2, godeyeJointPointCallbackWithStopHook);
    }

    public void invokeCustomEventJointPointHandlersIfExist(String str) {
        if (Godeye.sharedInstance().isDebugMode()) {
            List<IGodeyeJointPointCenter.GodeyeJointPointCallback> list = this.mCustomEventJointPointHandlers.get(str);
            if (list != null) {
                for (IGodeyeJointPointCenter.GodeyeJointPointCallback godeyeJointPointCallback : list) {
                    godeyeJointPointCallback.doCallback();
                }
            }
            this.mCustomEventJointPointHandlers.remove(str);
        }
    }
}
