package com.youku.usercenter.passport.task;

import android.content.Context;
import android.text.TextUtils;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.PassportPreference;
import com.youku.usercenter.passport.callback.ICallback;
import com.youku.usercenter.passport.result.ConfigResult;
import com.youku.usercenter.passport.util.EncryptUtil;
import com.youku.usercenter.passport.util.Logger;
import com.youku.usercenter.passport.util.MiscUtil;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ConfigTask implements Runnable {
    private Context mContext;

    public ConfigTask(Context context) {
        this.mContext = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        PassportManager.getInstance().getService().getGlobalConfig(new ICallback<ConfigResult>() { // from class: com.youku.usercenter.passport.task.ConfigTask.1
            @Override // com.youku.usercenter.passport.callback.ICallback
            public void onFailure(ConfigResult configResult) {
            }

            @Override // com.youku.usercenter.passport.callback.ICallback
            public void onSuccess(ConfigResult configResult) {
                try {
                    PassportPreference passportPreference = PassportPreference.getInstance(ConfigTask.this.mContext);
                    String configDataMd5 = passportPreference.getConfigDataMd5();
                    JSONObject jSONObject = new JSONObject(configResult.mConfigData);
                    boolean optBoolean = jSONObject.optBoolean("mtopSwitch", true);
                    PassportConfig config = PassportManager.getInstance().getConfig();
                    if (config.getMtopServer() != optBoolean) {
                        config.setUseMtopServer(optBoolean);
                        passportPreference.setMtopSwitchServer(optBoolean);
                    }
                    String encryptMD5 = EncryptUtil.encryptMD5(configResult.mConfigData, true);
                    if (TextUtils.equals(configDataMd5, encryptMD5)) {
                        return;
                    }
                    MiscUtil.handleConfig(jSONObject);
                    passportPreference.setConfigDataMd5(encryptMD5);
                } catch (Exception e) {
                    Logger.printStackTrace(e);
                }
            }
        });
    }
}
