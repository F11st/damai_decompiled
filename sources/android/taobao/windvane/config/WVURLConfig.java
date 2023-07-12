package android.taobao.windvane.config;

import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVURLConfig implements IConfig {
    private static final String TAG = "WVURLConfig";
    private static volatile WVURLConfig instance;
    private String forbiddenDomainRedirectURL = "";
    private AtomicBoolean inited = new AtomicBoolean(false);

    public static WVURLConfig getInstance() {
        if (instance == null) {
            synchronized (WVURLConfig.class) {
                if (instance == null) {
                    instance = new WVURLConfig();
                }
            }
        }
        return instance;
    }

    private boolean parseConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("url_patterns", "");
            String optString2 = jSONObject.optString("url_rules", "");
            String optString3 = jSONObject.optString("api_group", "");
            this.forbiddenDomainRedirectURL = jSONObject.optString("forbiddenDomainRedirectURL", "https://h5.m.taobao.com/forbidden_error.html");
            WVUrlMatchUtils.getInstance().urlMatcherConfig(optString, optString2, optString3, false);
            if (TextUtils.isEmpty(this.forbiddenDomainRedirectURL) || !WVUrlMatchUtils.getInstance().isForbiddenOpen(this.forbiddenDomainRedirectURL)) {
                return true;
            }
            this.forbiddenDomainRedirectURL = "";
            return true;
        }
        return false;
    }

    public String getForbiddenDomainRedirectURL() {
        return this.forbiddenDomainRedirectURL;
    }

    @Override // android.taobao.windvane.config.IConfig
    public boolean hasInited() {
        return this.inited.get();
    }

    public void init() {
        if (this.inited.compareAndSet(false, true)) {
            parseConfig(ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "url_configwv-data"));
        }
    }

    @Override // android.taobao.windvane.config.IConfig
    public void setConfig(String str) {
        parseConfig(str);
        ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "url_configwv-data", str);
    }
}
