package mtopsdk.config;

import android.content.Context;
import java.util.Map;
import mtopsdk.common.config.MtopConfigListener;
import mtopsdk.common.util.SwitchConfigUtil;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.baseswitch.SwitchConfigListener;
import mtopsdk.config.upload.UploadSwitchListener;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopConfigOrangeListenerImpl implements MtopConfigListener {
    private static final String TAG = "mtopsdk.MtopConfigOrangeListenerImpl";

    @Override // mtopsdk.common.config.MtopConfigListener
    public String getConfig(String str, String str2, String str3) {
        try {
            return MtopOrangeAdapter.getConfig(str, str2, str3);
        } catch (Throwable unused) {
            return str3;
        }
    }

    @Override // mtopsdk.common.config.MtopConfigListener
    public Map<String, String> getSwitchConfigByGroupName(String str) {
        try {
            return MtopOrangeAdapter.getConfigs(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // mtopsdk.common.config.MtopConfigListener
    public void initConfig(Context context) {
        try {
            MtopOrangeAdapter.init(context);
            MtopOrangeAdapter.registerListener(new String[]{SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_ANDROID_SWITCH}, new SwitchConfigListener());
            MtopOrangeAdapter.registerListener(new String[]{SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_UPLOAD_SWITCH}, new UploadSwitchListener());
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("groupNames=[");
                sb.append(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_ANDROID_SWITCH);
                sb.append(",");
                sb.append(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_UPLOAD_SWITCH);
                sb.append(jn1.ARRAY_END_STR);
                TBSdkLog.i(TAG, "[initConfig] initConfig  parameter:" + sb.toString());
            }
        } catch (Throwable th) {
            TBSdkLog.w(TAG, "[initConfig] init mtop orange config error", th.toString());
        }
    }
}
