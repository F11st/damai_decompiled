package com.taobao.android.launcher.idle;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import com.taobao.android.launcher.Constants;
import com.taobao.android.launcher.common.LauncherRuntime;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class IdleChecker {
    private static final AtomicBoolean sSetup = new AtomicBoolean(false);

    public static void setup(@NonNull final Runnable runnable) {
        if (sSetup.compareAndSet(false, true)) {
            LauncherRuntime.postUITask(new Runnable() { // from class: com.taobao.android.launcher.idle.IdleChecker.1
                @Override // java.lang.Runnable
                @SuppressLint({"ObsoleteSdkInt"})
                public void run() {
                    IdleFrameCallback idleFrameCallback = new IdleFrameCallback(System.nanoTime(), runnable);
                    if (Build.VERSION.SDK_INT >= 16) {
                        boolean isSwitchOpen = IdleSwitch.isSwitchOpen();
                        Log.e(Constants.TAG_LIFE_CYCLE, "idle check switch is " + isSwitchOpen);
                        if (isSwitchOpen) {
                            Choreographer.getInstance().postFrameCallback(idleFrameCallback);
                        }
                    }
                }
            });
        }
    }
}
