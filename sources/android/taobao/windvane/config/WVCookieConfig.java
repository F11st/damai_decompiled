package android.taobao.windvane.config;

import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVCookieConfig implements IConfig {
    private static final String TAG = "WVCookieConfig";
    private static volatile WVCookieConfig instance;
    private AtomicBoolean inited = new AtomicBoolean(false);
    public String cookieBlackList = "";

    public static WVCookieConfig getInstance() {
        if (instance == null) {
            synchronized (WVCookieConfig.class) {
                if (instance == null) {
                    instance = new WVCookieConfig();
                }
            }
        }
        return instance;
    }

    private void parseConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
        }
        if (jSONObject != null) {
            this.cookieBlackList = jSONObject.optString("cookieBlackList", this.cookieBlackList);
        }
    }

    @Override // android.taobao.windvane.config.IConfig
    public boolean hasInited() {
        return this.inited.get();
    }

    public void init() {
        if (this.inited.compareAndSet(false, true)) {
            String stringVal = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, WVConfigManager.CONFIGNAME_COOKIE);
            TaoLog.i(TAG, "get cookie config local = [" + stringVal + jn1.ARRAY_END_STR);
            parseConfig(stringVal);
            try {
                OrangeConfig.getInstance().registerListener(new String[]{WVConfigManager.CONFIGNAME_COOKIE}, new OrangeConfigListenerV1() { // from class: android.taobao.windvane.config.WVCookieConfig.1
                    @Override // com.taobao.orange.OrangeConfigListenerV1
                    public void onConfigUpdate(String str, boolean z) {
                        Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
                        if (configs != null && configs.size() != 0) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                for (Map.Entry<String, String> entry : configs.entrySet()) {
                                    jSONObject.put(entry.getKey(), entry.getValue());
                                }
                                jSONObject.put("appVersion", GlobalConfig.getInstance().getAppVersion());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            WVConfigManager.getInstance().updateConfigByKey(str, jSONObject.toString());
                            TaoLog.i("WVConfig", "receive name=[" + str + "]; config=[" + jSONObject.toString() + jn1.ARRAY_END_STR);
                            return;
                        }
                        WVConfigManager.getInstance().updateConfigByKey(str, "");
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.taobao.windvane.config.IConfig
    public void setConfig(String str) {
        TaoLog.i(TAG, "receive cookie config = [" + str + jn1.ARRAY_END_STR);
        parseConfig(str);
        ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, WVConfigManager.CONFIGNAME_COOKIE, str);
    }
}
