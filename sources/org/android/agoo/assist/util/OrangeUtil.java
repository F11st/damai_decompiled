package org.android.agoo.assist.util;

import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import org.android.agoo.assist.AssistManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class OrangeUtil {
    public static final String KEY_ASSIST = "assist_enable";
    public static final String NAMESPACE = "damai_accs_assist";
    private static final String TAG = "OrangeUtil";
    public static boolean mOrangeValid = true;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class OrangeListener implements OrangeConfigListenerV1 {
        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            if (GlobalClientInfo.getContext() == null) {
                ALog.e(OrangeUtil.TAG, "onConfigUpdate context null", new Object[0]);
                return;
            }
            try {
                ALog.i(OrangeUtil.TAG, "onConfigUpdate", "namespace", str);
                if (OrangeUtil.NAMESPACE.equals(str)) {
                    OrangeUtil.saveConfig2SP();
                }
            } catch (Throwable th) {
                ALog.e(OrangeUtil.TAG, "onConfigUpdate", th, new Object[0]);
            }
        }
    }

    private static String getConfig(String str, String str2) {
        return mOrangeValid ? OrangeConfig.getInstance().getConfig(NAMESPACE, str, str2) : str2;
    }

    public static String getConfigFromSp(String str, String str2) {
        return SharedPreferencesUtil.getStringVal(AssistManager.appContext, str, str2);
    }

    public static boolean isAssistEnabled() {
        return Boolean.parseBoolean(getConfigFromSp(KEY_ASSIST, "true"));
    }

    public static void registerListener() {
        if (mOrangeValid) {
            OrangeConfig.getInstance().registerListener(new String[]{NAMESPACE}, new OrangeListener());
        } else {
            ALog.w(TAG, "no orange sdk", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveConfig2SP() {
        String config = getConfig(KEY_ASSIST, "true");
        SharedPreferencesUtil.editor(AssistManager.appContext).putString(KEY_ASSIST, config).apply();
        ALog.i(TAG, "onConfigUpdate", "saveConfig2SP-agas", config);
    }
}
