package com.taobao.tao.log.godeye;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.model.GodeyeInfo;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.godeye.core.GodEyeAppListener;
import com.taobao.tao.log.godeye.core.GodEyeReponse;
import com.taobao.tao.log.godeye.core.control.Godeye;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GodeyeInitializer {
    public GodeyeConfig config;
    AtomicBoolean enabling;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CreateInstance {
        private static GodeyeInitializer instance = new GodeyeInitializer();

        private CreateInstance() {
        }
    }

    public static synchronized GodeyeInitializer getInstance() {
        GodeyeInitializer godeyeInitializer;
        synchronized (GodeyeInitializer.class) {
            godeyeInitializer = CreateInstance.instance;
        }
        return godeyeInitializer;
    }

    private String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean handleRemoteCommand(GodeyeInfo godeyeInfo) {
        return Godeye.sharedInstance().handleRemoteCommand(godeyeInfo);
    }

    public void init(Application application, GodeyeConfig godeyeConfig) {
        if (godeyeConfig == null) {
            godeyeConfig = new GodeyeConfig();
        }
        if (TLogInitializer.getInstance().getPackageName().equals(godeyeConfig.processName) && this.enabling.compareAndSet(false, true)) {
            this.config = godeyeConfig;
            String str = godeyeConfig.appVersion;
            String str2 = godeyeConfig.packageTag;
            String str3 = godeyeConfig.appId;
            Godeye.sharedInstance().utdid = this.config.utdid;
            Godeye.sharedInstance().initialize(application, str3, str);
            Godeye.sharedInstance().setBuildId(str2);
        }
    }

    public void onAccurateBootFinished(HashMap<String, String> hashMap) {
        Godeye.sharedInstance().defaultGodeyeJointPointCenter().invokeCustomEventJointPointHandlersIfExist(Constants.AndroidJointPointKey.EVENT_KEY_APP_STARTED);
    }

    public void registGodEyeAppListener(GodEyeAppListener godEyeAppListener) {
        if (godEyeAppListener != null) {
            Godeye.sharedInstance().godEyeAppListener = godEyeAppListener;
        }
    }

    public void registGodEyeReponse(String str, GodEyeReponse godEyeReponse) {
        if (str == null || godEyeReponse == null) {
            return;
        }
        Godeye.sharedInstance().godEyeReponses.put(str, godEyeReponse);
    }

    private GodeyeInitializer() {
        this.enabling = new AtomicBoolean(false);
        this.config = null;
    }
}
