package com.taobao.update.apk.processor;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.framework.Processor;
import tb.pu2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class KillAppProcessor implements Processor<ApkUpdateContext> {
    @Override // com.taobao.update.framework.Processor
    public void execute(final ApkUpdateContext apkUpdateContext) {
        if (apkUpdateContext.isForceUpdate()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.taobao.update.apk.processor.KillAppProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    pu2.killChildProcesses(apkUpdateContext.context);
                    int myPid = Process.myPid();
                    Log.d("Updater", "atlas killprocess:" + myPid);
                    Process.killProcess(myPid);
                }
            }, 1000L);
        }
    }
}
