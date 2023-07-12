package mtopsdk.config.baseswitch;

import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.MtopOrangeAdapter;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SwitchConfigListener extends MtopOrangeAdapter.MtopOrangeListener {
    private static final String TAG = "mtopsdk.SwitchConfigListener";

    @Override // mtopsdk.config.MtopOrangeAdapter.MtopOrangeListener, com.taobao.orange.OrangeConfigListenerV1
    public void onConfigUpdate(String str, boolean z) {
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[onConfigUpdate] groupName=");
            sb.append(str);
            sb.append(",fromCache=");
            sb.append(z);
            TBSdkLog.i(TAG, sb.toString());
        }
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.config.baseswitch.SwitchConfigListener.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteConfig.getInstance().updateRemoteConfig();
                    SwitchConfigManager switchConfigManager = SwitchConfigManager.getInstance();
                    switchConfigManager.updateIndividualApiLockIntervalMap();
                    switchConfigManager.updateApiCacheConfig();
                    switchConfigManager.updateErrorMappingConfig();
                } catch (Exception e) {
                    TBSdkLog.e(SwitchConfigListener.TAG, "[onConfigUpdate] parse SdkSwitchConfigBroadcast error.", e);
                }
            }
        });
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[onConfigUpdate]submit parseSdkSwitchConfigBroadcast task to ThreadPool");
        }
    }
}
