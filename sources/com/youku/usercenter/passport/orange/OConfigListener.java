package com.youku.usercenter.passport.orange;

import android.util.Log;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.PassportPreference;
import com.youku.usercenter.passport.util.Logger;
import com.youku.usercenter.passport.util.MiscUtil;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OConfigListener implements OrangeConfigListenerV1 {
    private static final String TAG = "OConfigUpdate";

    @Override // com.taobao.orange.OrangeConfigListenerV1
    public void onConfigUpdate(String str, boolean z) {
        if (Logger.isDebug()) {
            Log.d(TAG, String.format("Update namespace:%s from cache ? %b", str, Boolean.valueOf(z)));
        }
        if ("passport_config".equals(str)) {
            String bool = Boolean.TRUE.toString();
            boolean equals = OrangeConfig.getInstance().getConfig(str, "mtopSwitch", bool).equals(bool);
            PassportConfig config = PassportManager.getInstance().getConfig();
            PassportPreference passportPreference = PassportPreference.getInstance(config.mContext);
            if (config.getMtopServer() != equals) {
                config.setUseMtopServer(equals);
                passportPreference.setMtopSwitchServer(equals);
            }
            if (z) {
                return;
            }
            try {
                MiscUtil.handleConfig(new JSONObject(OrangeConfig.getInstance().getConfigs(str)));
            } catch (Throwable th) {
                Logger.printStackTrace(th);
            }
        }
    }
}
