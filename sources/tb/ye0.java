package tb;

import android.text.TextUtils;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.framework.Processor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ye0 implements Processor<ApkUpdateContext> {
    public static int UpdateDataDiskFreeSize = 100;

    @Override // com.taobao.update.framework.Processor
    public void execute(ApkUpdateContext apkUpdateContext) {
        if (TextUtils.isEmpty(apkUpdateContext.apkPath)) {
            if (pu2.getNetworkType() == 0) {
                apkUpdateContext.success = false;
                apkUpdateContext.errorCode = -22;
                apkUpdateContext.errorMsg = pu2.getAppNameString(R$string.notice_update_err_nonetwork, UpdateRuntime.sAppName);
            } else if (apkUpdateContext.skipUpdate()) {
                apkUpdateContext.success = false;
                apkUpdateContext.errorCode = -23;
                apkUpdateContext.errorMsg = "不满足网络条件";
            } else {
                String storePath = pu2.getStorePath(apkUpdateContext.context);
                long j = apkUpdateContext.mainUpdate.size;
                if (j == 0) {
                    j = UpdateDataDiskFreeSize * 1024 * 1024;
                }
                if (pu2.hasEnoughSpace(storePath, j)) {
                    return;
                }
                apkUpdateContext.success = false;
                apkUpdateContext.errorCode = -21;
                apkUpdateContext.errorMsg = pu2.getAppNameString(R$string.update_no_sdcard_space, UpdateRuntime.sAppName);
            }
        }
    }
}
