package com.alibaba.motu.crashreporter;

import com.alibaba.motu.tbrest.rest.RestConstants;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ReporterConfigure {
    public boolean enableUncaughtExceptionIgnore = true;
    public boolean enableExternalLinster = true;
    public boolean enableFinalizeFake = true;
    public boolean enableCatchUncaughtException = true;
    public boolean enableCatchNativeException = true;
    public boolean enableCatchANRException = true;
    public long enabeMainLooperTimeoutInterval = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
    public boolean isCloseMainLooperSampling = false;
    public boolean enableANRMainThreadOnly = false;
    public boolean closeMainLooperMonitor = false;
    public boolean enableStartCount = true;
    public int sendOnLaunchDelay = 0;
    public boolean enableActivityMonitor = true;
    public boolean enableDumpSysLog = false;
    public boolean enableDumpEventsLog = false;
    public boolean enableDumpRadioLog = false;
    public boolean enableDumpAppLog = false;
    public boolean enableDumpAllThread = false;
    public boolean enableDebug = false;
    public int enabeANRTimeoutInterval = 5000;
    public boolean enableDeduplication = false;
    public boolean enableAbortCount = false;
    public boolean enableUIProcessSafeGuard = false;
    public String adashxServerHost = RestConstants.G_DEFAULT_ADASHX_HOST;
    public boolean enableSecuritySDK = true;
    public int enableMaxThreadNumber = 200;
    public int enableMaxThreadStackTraceNumber = 64;
    public int enableSysLogcatMaxCount = 100;
    public int enableSysLogcatLinkMaxCount = 100;
    public boolean enableBreakPadDump = false;

    public void setEnableANRMainThreadOnly(boolean z) {
        this.enableANRMainThreadOnly = z;
    }

    public void setEnableCatchANRException(boolean z) {
        this.enableCatchANRException = z;
    }

    public void setEnableDebug(boolean z) {
        this.enableDebug = z;
    }

    public void setEnableDumpAllThread(boolean z) {
        this.enableDumpAllThread = z;
    }

    public void setEnableDumpAppLog(boolean z) {
        this.enableDumpAppLog = z;
    }

    public void setEnableDumpEventsLog(boolean z) {
        this.enableDumpEventsLog = z;
    }

    public void setEnableDumpRadioLog(boolean z) {
        this.enableDumpRadioLog = z;
    }

    public void setEnableDumpSysLog(boolean z) {
        this.enableDumpSysLog = z;
    }
}
