package com.alibaba.motu.crashreporter2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AnrOrangeLauncher {
    private static final String ORANGE_NAMESPACE = "CrashReportSwitcher";

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class OrangeListener implements OConfigListener {
        private final Context mContext;

        public OrangeListener(Context context) {
            this.mContext = context;
        }

        private void onUpdate(Map<String, String> map) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext).edit();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            Map<String, String> configs = OrangeConfig.getInstance().getConfigs(AnrOrangeLauncher.ORANGE_NAMESPACE);
            if (configs == null || configs.size() <= 0) {
                return;
            }
            onUpdate(configs);
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        OrangeConfig.getInstance().registerListener(new String[]{ORANGE_NAMESPACE}, new OrangeListener(application), true);
    }
}
