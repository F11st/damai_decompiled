package me.ele.altriax.launcher.biz.impl.biz;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import com.taobao.android.job.core.base.Log;
import java.io.File;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public final class LauncherTrace implements Application.ActivityLifecycleCallbacks {
    private static final int DEFAULT_SAMPLING_INTERVAL = 10000;
    private static final String INTERVAL_FILE_NAME_PREFIX = ".eleme_trace_interval_";
    private static final int SAMPLING_INTERVAL_10 = 10000;
    private static final int SAMPLING_INTERVAL_100 = 100000;
    private static final int SAMPLING_INTERVAL_5 = 5000;
    private static final int SAMPLING_INTERVAL_50 = 50000;
    private static final int STAGE_LAUNCHER = 0;
    private static final int STAGE_MAINPAGE = 2;
    private static final int STAGE_WELCOME = 1;
    private static final String SWITCH_FILE_NAME = ".eleme_trace_switcher";
    private static final String TRACE_NAME_LAUNCHER = "launcher";
    private static final String TRACE_NAME_MAINPAGE = "mainpage";
    private static final String TRACE_NAME_WELCOME = "welcome";
    private final int sampleInterval;
    private int traceStage = 0;
    private boolean traceable;

    public LauncherTrace(Application application) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23 && application.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        this.traceable = new File("/data/local/tmp/", SWITCH_FILE_NAME).exists();
        boolean isLoggable = Log.isLoggable("LauncherTrace", 2);
        if (!z) {
            this.traceable = false;
        }
        Log.e("LauncherTrace", "traceable " + this.traceable + " hasPermission" + z + " logable " + isLoggable, new Object[0]);
        if (this.traceable) {
            int determineSamplingInternal = determineSamplingInternal();
            this.sampleInterval = determineSamplingInternal;
            Log.e("LauncherTrace", "sampleInterval " + determineSamplingInternal, new Object[0]);
            application.registerActivityLifecycleCallbacks(this);
            return;
        }
        this.sampleInterval = 10000;
    }

    private int determineSamplingInternal() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (new File(externalStorageDirectory, ".eleme_trace_interval_50").exists()) {
            return 50000;
        }
        if (new File(externalStorageDirectory, ".eleme_trace_interval_100").exists()) {
            return SAMPLING_INTERVAL_100;
        }
        if (new File(externalStorageDirectory, ".eleme_trace_interval_5").exists()) {
            return 5000;
        }
        new File(externalStorageDirectory, ".eleme_trace_interval_10").exists();
        return 10000;
    }

    private static void startTracing(boolean z, String str, int i) {
        if (z) {
            Debug.stopMethodTracing();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Debug.startMethodTracingSampling(str, 0, i);
        } else {
            Debug.startMethodTracing(str);
        }
    }

    public boolean isSwitchOn() {
        return this.traceable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i = this.traceStage;
        if (i == 0) {
            Log.e("LauncherTrace", "startTracing  welcome ", new Object[0]);
            startTracing(true, "welcome", this.sampleInterval);
            this.traceStage = 1;
        } else if (i == 1) {
            Log.e("LauncherTrace", "startTracing  mainpage ", new Object[0]);
            startTracing(true, TRACE_NAME_MAINPAGE, this.sampleInterval);
            this.traceStage = 2;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.traceStage == 2) {
            Log.e("LauncherTrace", "stopMethodTracing", new Object[0]);
            Debug.stopMethodTracing();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public void start() {
        if (this.traceable) {
            Log.e("LauncherTrace", "startTracing launcher sampleInterval " + this.sampleInterval, new Object[0]);
            startTracing(false, TRACE_NAME_LAUNCHER, this.sampleInterval);
        }
    }
}
