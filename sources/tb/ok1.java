package tb;

import android.text.TextUtils;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.processor.ApkDownloadProcessor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ok1 {
    private UpdateMonitor a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b {
        private static final ok1 a = new ok1();
    }

    public static ok1 getInstance() {
        return b.a;
    }

    public ApkUpdateContext doUpdate(ApkUpdateContext apkUpdateContext, String str, String str2) {
        new zl1().execute(apkUpdateContext);
        UpdateMonitor updateMonitor = this.a;
        if (updateMonitor != null) {
            updateMonitor.add("apefficiency", apkUpdateContext.success, "notifydownload", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, str2, 0L, 0L);
        }
        if (!apkUpdateContext.success) {
            UpdateRuntime.log("UpdateFlowController failed to pass NotifyNewApkUpdateProcessor " + apkUpdateContext);
            return apkUpdateContext;
        }
        System.currentTimeMillis();
        new ApkDownloadProcessor().execute(apkUpdateContext);
        this.a.add("apefficiency", apkUpdateContext.success, "download", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, str2, 0L, System.currentTimeMillis());
        if (!apkUpdateContext.success) {
            UpdateRuntime.log("UpdateFlowController failed to pass ApkDownloadProcessor " + apkUpdateContext);
            apkUpdateContext.isDownloadError = true;
            return apkUpdateContext;
        }
        if (!apkUpdateContext.isDefaultUpdate() || UpdateRuntime.popDialogBeforeInstall || !pu2.isNotificationPermissioned()) {
            UpdateRuntime.log("UpdateFlowController start to do ApkInstallProcessor ");
            new j6().execute(apkUpdateContext);
            this.a.add("apefficiency", apkUpdateContext.success, "notifyinstall", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, str2, 0L, 0L);
        }
        UpdateRuntime.log("UpdateFlowController apk upgrade execute result is " + apkUpdateContext);
        if (!apkUpdateContext.success && TextUtils.isEmpty(apkUpdateContext.errorMsg)) {
            apkUpdateContext.errorMsg = pu2.getAppNameString(R$string.notice_errorupdate, UpdateRuntime.sAppName);
        }
        UpdateRuntime.log("UpdateFlowController update finished with result " + apkUpdateContext);
        return apkUpdateContext;
    }

    private ok1() {
        try {
            this.a = (UpdateMonitor) wb.getInstance(UpdateMonitor.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
