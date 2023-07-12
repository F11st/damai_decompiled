package com.youku.arch.beast.apas.remote;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.util.Logger;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ApasServiceManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ApasServiceManager";
    private static ApasServiceManager mInstance = new ApasServiceManager();
    private IApasConn mApasConn;

    private ApasServiceManager() {
    }

    public static ApasServiceManager getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-240069535") ? (ApasServiceManager) ipChange.ipc$dispatch("-240069535", new Object[0]) : mInstance;
    }

    private boolean isMainProcess(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1282841140")) {
            return ((Boolean) ipChange.ipc$dispatch("1282841140", new Object[]{this, context})).booleanValue();
        }
        int myPid = Process.myPid();
        String str = "";
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
        }
        return context.getApplicationContext().getPackageName().equals(str);
    }

    public boolean containsNamespace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872311254")) {
            return ((Boolean) ipChange.ipc$dispatch("1872311254", new Object[]{this, str})).booleanValue();
        }
        IApasConn iApasConn = this.mApasConn;
        if (iApasConn == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return false;
        }
        return iApasConn.containsNamespace(str);
    }

    public String getConfig(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336826442")) {
            return (String) ipChange.ipc$dispatch("-336826442", new Object[]{this, str, str2, str3});
        }
        IApasConn iApasConn = this.mApasConn;
        if (iApasConn == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return str3;
        }
        return iApasConn.getConfig(str, str2, str3);
    }

    public Map getConfigs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814008234")) {
            return (Map) ipChange.ipc$dispatch("1814008234", new Object[]{this, str});
        }
        IApasConn iApasConn = this.mApasConn;
        if (iApasConn == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return null;
        }
        return iApasConn.getConfigs(str);
    }

    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494223214")) {
            ipChange.ipc$dispatch("-494223214", new Object[]{this, context});
            return;
        }
        if (isMainProcess(context)) {
            this.mApasConn = new LocalApasConn();
        } else {
            this.mApasConn = new RemoteApasConn();
        }
        this.mApasConn.init(context);
    }

    public boolean registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77582646")) {
            return ((Boolean) ipChange.ipc$dispatch("-77582646", new Object[]{this, str, iApasUpdateListenerInterface})).booleanValue();
        }
        IApasConn iApasConn = this.mApasConn;
        if (iApasConn == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return false;
        }
        return iApasConn.registerListener(str, iApasUpdateListenerInterface);
    }

    public void setRequestExtraInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653249497")) {
            ipChange.ipc$dispatch("-1653249497", new Object[]{this, str, str2});
            return;
        }
        IApasConn iApasConn = this.mApasConn;
        if (iApasConn == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
        } else {
            iApasConn.setRequestExtraInfo(str, str2);
        }
    }

    public boolean unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "972952867")) {
            return ((Boolean) ipChange.ipc$dispatch("972952867", new Object[]{this, str, iApasUpdateListenerInterface})).booleanValue();
        }
        IApasConn iApasConn = this.mApasConn;
        if (iApasConn == null) {
            Logger.e(TAG, "context is null! did you forget to call init??");
            return false;
        }
        return iApasConn.unregisterListener(str, iApasUpdateListenerInterface);
    }
}
