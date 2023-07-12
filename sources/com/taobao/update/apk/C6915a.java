package com.taobao.update.apk;

import android.content.Intent;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.processor.KillAppProcessor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.utils.Constants;
import tb.el2;
import tb.k6;
import tb.ok1;
import tb.wb;
import tb.ye0;
import tb.yl1;

/* compiled from: Taobao */
/* renamed from: com.taobao.update.apk.a */
/* loaded from: classes11.dex */
public class C6915a {
    private UpdateMonitor a;

    public C6915a() {
        this.a = null;
        try {
            this.a = (UpdateMonitor) wb.getInstance(UpdateMonitor.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ApkUpdateContext a(boolean z, MainUpdateData mainUpdateData) {
        ApkUpdateContext apkUpdateContext = new ApkUpdateContext();
        apkUpdateContext.context = UpdateRuntime.getContext();
        apkUpdateContext.background = z;
        apkUpdateContext.mainUpdate = mainUpdateData;
        String str = mainUpdateData.version;
        String downloadUrl = mainUpdateData.getDownloadUrl();
        UpdateMonitor updateMonitor = this.a;
        if (updateMonitor != null) {
            updateMonitor.add("apefficiency", true, "revupdate", "", "", str, downloadUrl, 0L, 0L);
        }
        UpdateRuntime.log("UpdateFlowController start to execute in background " + z);
        k6.getProcessor(ye0.class).execute(apkUpdateContext);
        UpdateMonitor updateMonitor2 = this.a;
        if (updateMonitor2 != null) {
            updateMonitor2.add("apefficiency", apkUpdateContext.success, "disk", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, downloadUrl, 0L, 0L);
        }
        if (!apkUpdateContext.success) {
            UpdateRuntime.log("UpdateFlowController failed to pass EnvCheckProcessor " + apkUpdateContext);
            return apkUpdateContext;
        }
        UpdateRuntime.log("UpdateFlowController start to do apk update ");
        k6.getProcessor(yl1.class).execute(apkUpdateContext);
        UpdateMonitor updateMonitor3 = this.a;
        if (updateMonitor3 != null) {
            updateMonitor3.add("apefficiency", apkUpdateContext.success, "notifytimes", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, downloadUrl, 0L, 0L);
        }
        if (apkUpdateContext.success) {
            return (apkUpdateContext.isForceUpdate() || apkUpdateContext.notifyPolicy == ApkUpdateContext.NotifyPolicy.DEFAULT) ? ok1.getInstance().doUpdate(apkUpdateContext, str, downloadUrl) : apkUpdateContext;
        }
        if (apkUpdateContext.exceedUpdateTimes.booleanValue()) {
            UpdateRuntime.log("update check not pass, exceedUpdateTimes=true");
        } else {
            UpdateRuntime.log("update check not pass, exceedUpdateTimes=false");
        }
        UpdateRuntime.log("UpdateFlowController failed to pass NotifyTimesCheckProcessor " + apkUpdateContext);
        return apkUpdateContext;
    }

    public el2 execute(boolean z, MainUpdateData mainUpdateData) {
        ApkUpdateContext apkUpdateContext = null;
        try {
            Intent intent = new Intent(Constants.UPDATE_MESSAGE_NAME);
            intent.putExtra(Constants.HAS_APk_UPDATE, true);
            UpdateRuntime.getContext().sendBroadcast(intent);
            apkUpdateContext = a(z, mainUpdateData);
            UpdateMonitor updateMonitor = this.a;
            if (updateMonitor != null) {
                updateMonitor.commit("apefficiency");
            }
            if (apkUpdateContext.isForceUpdate() && !apkUpdateContext.isDownloadError) {
                UpdateRuntime.log("UpdateFlowController start to do KillAppProcessor ");
                new KillAppProcessor().execute(apkUpdateContext);
            }
        } catch (Throwable th) {
            UpdateRuntime.log("do apk update error", th);
        }
        return apkUpdateContext;
    }
}
