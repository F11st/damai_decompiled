package android.taobao.windvane.config;

import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVDomainConfig {
    private static final String TAG = "WVDomainConfig";
    private static volatile WVDomainConfig instance;
    private String forbiddenDomainRedirectURL = "";

    public static WVDomainConfig getInstance() {
        if (instance == null) {
            synchronized (WVDomainConfig.class) {
                if (instance == null) {
                    instance = new WVDomainConfig();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean parseConfig(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("v", "");
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            String optString2 = jSONObject.optString("aliDomain", "");
            String optString3 = jSONObject.optString("thirdPartyDomain", "");
            String optString4 = jSONObject.optString("supportDownloadDomain", "");
            String optString5 = jSONObject.optString("forbiddenDomain", "");
            String optString6 = jSONObject.optString("allowAccessDomain", "");
            this.forbiddenDomainRedirectURL = jSONObject.optString("forbiddenDomainRedirectURL", "");
            if (!TextUtils.isEmpty(optString2)) {
                WVServerConfig.DOMAIN_PATTERN = optString2;
                WVServerConfig.domainPat = null;
            }
            if (!TextUtils.isEmpty(optString3)) {
                WVServerConfig.THIRD_PARTY_DOMAIN_PATTERN = optString3;
                WVServerConfig.thirdPartyDomain = null;
            }
            if (!TextUtils.isEmpty(optString4)) {
                WVServerConfig.SUPPORT_DOWNLOAD_DOMAIN_PATTERN = optString4;
                WVServerConfig.supportDownloadDomain = null;
            }
            if (!TextUtils.isEmpty(optString6)) {
                WVServerConfig.ALLOW_ACCESS_DOMAIN_PATTERN = optString6;
                WVServerConfig.allowAccessDomain = null;
            }
            if (!TextUtils.isEmpty(optString5)) {
                WVServerConfig.FORBIDDEN_DOMAIN_PATTERN = optString5;
                WVServerConfig.forbiddenDomain = null;
                if (!TextUtils.isEmpty(this.forbiddenDomainRedirectURL) && WVServerConfig.isBlackUrl(this.forbiddenDomainRedirectURL)) {
                    this.forbiddenDomainRedirectURL = "";
                }
            }
            WVServerConfig.v = optString;
            return true;
        }
        return false;
    }

    public String getForbiddenDomainRedirectURL() {
        return this.forbiddenDomainRedirectURL;
    }

    public void init() {
        parseConfig(ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "domainwv-data"));
    }

    public void updateDomainRule(final WVConfigUpdateCallback wVConfigUpdateCallback, final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = WVConfigManager.getInstance().getConfigUrl("2", WVServerConfig.v, WVConfigUtils.getTargetValue(), str2);
        }
        ConnectManager.getInstance().connectSync(str, new HttpConnectListener<HttpResponse>() { // from class: android.taobao.windvane.config.WVDomainConfig.1
            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str3) {
                WVConfigUpdateCallback wVConfigUpdateCallback2 = wVConfigUpdateCallback;
                if (wVConfigUpdateCallback2 != null) {
                    wVConfigUpdateCallback2.updateError(str, str3);
                    wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR, 0);
                }
                TaoLog.d(WVDomainConfig.TAG, "update domain failed! : " + str3);
                super.onError(i, str3);
            }

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onFinish(HttpResponse httpResponse, int i) {
                if (wVConfigUpdateCallback == null) {
                    return;
                }
                if (httpResponse != null && httpResponse.getData() != null) {
                    try {
                        String str3 = new String(httpResponse.getData(), "utf-8");
                        if (WVDomainConfig.this.parseConfig(str3)) {
                            ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "domainwv-data", str3);
                            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.SUCCESS, 1);
                        } else {
                            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NO_VERSION, 0);
                        }
                        return;
                    } catch (UnsupportedEncodingException e) {
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.ENCODING_ERROR, 0);
                        TaoLog.e(WVDomainConfig.TAG, "config encoding error. " + e.getMessage());
                        return;
                    }
                }
                wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NULL_DATA, 0);
            }
        });
    }
}
