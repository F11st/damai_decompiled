package mtopsdk.config.upload;

import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.MtopOrangeAdapter;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploadSwitchListener extends MtopOrangeAdapter.MtopOrangeListener {
    private final String TAG = "mtopsdk.UploadSwitchListener";

    @Override // mtopsdk.config.MtopOrangeAdapter.MtopOrangeListener, com.taobao.orange.OrangeConfigListenerV1
    public void onConfigUpdate(String str, boolean z) {
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[onConfigUpdate] groupName=");
            sb.append(str);
            sb.append(",fromCache=");
            sb.append(z);
            TBSdkLog.i("mtopsdk.UploadSwitchListener", sb.toString());
        }
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.config.upload.UploadSwitchListener.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteConfig.getInstance().updateUploadRemoteConfig();
                UploadSwitchConfigManager uploadSwitchConfigManager = UploadSwitchConfigManager.getInstance();
                uploadSwitchConfigManager.parseRemoteSegmentSizeMapConfig();
                uploadSwitchConfigManager.parseUseHttpsBizCodeSetConfig();
                uploadSwitchConfigManager.parseDegradeBizCodeSetConfig();
            }
        });
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i("mtopsdk.UploadSwitchListener", "[onConfigUpdate]submit UploadSwitchConfigBroadcast task to ThreadPool");
        }
    }
}
