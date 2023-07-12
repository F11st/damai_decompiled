package com.taobao.accs.asp;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.login4android.session.SessionManager;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Utils {
    private static final String TAG = "Utils";
    private static volatile String sCoreProviderProcess;
    private static volatile String sCurrentProcess;

    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCoreProviderProcess() {
        if (sCoreProviderProcess != null) {
            return sCoreProviderProcess;
        }
        try {
            ComponentName componentName = new ComponentName(ARanger.getContext(), PrefsIPCChannel.CORE_CONTENT_PROVIDER);
            PackageManager packageManager = ARanger.getContext().getPackageManager();
            if (packageManager != null) {
                sCoreProviderProcess = packageManager.getProviderInfo(componentName, 0).processName;
            }
        } catch (Exception e) {
            ALog.e("Utils", "getCoreProviderProcess", e, new Object[0]);
        }
        return sCoreProviderProcess;
    }

    static String getCurrentProcess() {
        if (sCurrentProcess != null) {
            return sCurrentProcess;
        }
        sCurrentProcess = IPCUtils.getCurrentProcessName();
        return sCurrentProcess;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCoreProcess() {
        return getCurrentProcess().endsWith(SessionManager.CHANNEL_PROCESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isCoreProcessLive() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String coreProviderProcess = getCoreProviderProcess();
        if (TextUtils.isEmpty(coreProviderProcess) || (runningAppProcesses = GlobalClientInfo.getInstance(ARanger.getContext()).getActivityManager().getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(coreProviderProcess)) {
                return true;
            }
        }
        return false;
    }
}
