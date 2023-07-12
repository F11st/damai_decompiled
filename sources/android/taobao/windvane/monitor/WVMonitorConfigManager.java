package android.taobao.windvane.monitor;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVConfigHandler;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.config.WVConfigUtils;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVMonitorConfigManager {
    private static final String TAG = "WVPackageMonitorImpl";
    private static volatile WVMonitorConfigManager instance;
    public WVMonitorConfig config = new WVMonitorConfig();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class PageFinshWVEventListener implements WVEventListener {
        private PageFinshWVEventListener() {
        }

        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            if (i == 1002) {
                try {
                    double d = WVMonitorConfigManager.getInstance().config.perfCheckSampleRate;
                    String str = WVMonitorConfigManager.getInstance().config.perfCheckURL;
                    if (TextUtils.isEmpty("scriptUrl") || d <= Math.random()) {
                        return null;
                    }
                    wVEventContext.webView.evaluateJavascript(String.format("(function(d){var s = d.createElement('script');s.src='%s';d.head.appendChild(s);})(document)", str));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
    }

    public static WVMonitorConfigManager getInstance() {
        if (instance == null) {
            synchronized (WVMonitorConfigManager.class) {
                if (instance == null) {
                    instance = new WVMonitorConfigManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMonitorConfig(final WVConfigUpdateCallback wVConfigUpdateCallback, final String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus != 2) {
            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UPDATE_DISABLED, 0);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = WVConfigManager.getInstance().getConfigUrl("3", this.config.v, WVConfigUtils.getTargetValue(), str2);
        }
        ConnectManager.getInstance().connectSync(str, new HttpConnectListener<HttpResponse>() { // from class: android.taobao.windvane.monitor.WVMonitorConfigManager.2
            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str3) {
                WVConfigUpdateCallback wVConfigUpdateCallback2 = wVConfigUpdateCallback;
                if (wVConfigUpdateCallback2 != null) {
                    wVConfigUpdateCallback2.updateError(str, str3);
                    wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR, 0);
                }
                TaoLog.d(WVMonitorConfigManager.TAG, "update moniter failed! : " + str3);
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
                        if (WVMonitorConfigManager.this.needSaveConfig(str3)) {
                            ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "monitorwv-data", str3);
                            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.SUCCESS, 1);
                        } else {
                            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NO_VERSION, 0);
                        }
                        return;
                    } catch (UnsupportedEncodingException unused) {
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.ENCODING_ERROR, 0);
                        return;
                    }
                }
                wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NULL_DATA, 0);
            }
        });
    }

    public void init() {
        try {
            String stringVal = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "monitorwv-data", "");
            if (!TextUtils.isEmpty(stringVal)) {
                this.config = parseRule(stringVal);
            }
        } catch (Exception unused) {
        }
        WVConfigManager.getInstance().registerHandler("monitor", new WVConfigHandler() { // from class: android.taobao.windvane.monitor.WVMonitorConfigManager.1
            @Override // android.taobao.windvane.config.WVConfigHandler
            public void update(String str, WVConfigUpdateCallback wVConfigUpdateCallback) {
                WVMonitorConfigManager.this.updateMonitorConfig(wVConfigUpdateCallback, str, getSnapshotN());
            }
        });
        WVEventService.getInstance().addEventListener(new PageFinshWVEventListener());
    }

    protected boolean needSaveConfig(String str) {
        WVMonitorConfig parseRule;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ApiResponse apiResponse = new ApiResponse();
        JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
        if (jSONObject == null || (parseRule = parseRule(jSONObject.toString())) == null) {
            return false;
        }
        this.config = parseRule;
        return true;
    }

    public WVMonitorConfig parseRule(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            WVMonitorConfig wVMonitorConfig = new WVMonitorConfig();
            String optString = jSONObject.optString("v", "");
            wVMonitorConfig.v = optString;
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            wVMonitorConfig.stat.onLoad = jSONObject.optLong("minLoadTime", 0L);
            wVMonitorConfig.stat.onDomLoad = jSONObject.optLong("minDomLoadTime", 0L);
            wVMonitorConfig.stat.resTime = jSONObject.optLong("minResTime", 0L);
            wVMonitorConfig.stat.netstat = jSONObject.optBoolean("reportNetStat", false);
            wVMonitorConfig.stat.resSample = jSONObject.optInt("resSample", 100);
            wVMonitorConfig.isErrorBlacklist = jSONObject.optString("errorType", "b").equals("b");
            JSONArray optJSONArray = jSONObject.optJSONArray("errorRule");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        wVMonitorConfig.errorRule.add(wVMonitorConfig.newErrorRuleInstance(optJSONObject.optString("url", ""), optJSONObject.optString("msg", ""), optJSONObject.optString("code", "")));
                    }
                }
            }
            wVMonitorConfig.perfCheckSampleRate = jSONObject.optDouble("perfCheckSampleRate", 0.0d);
            wVMonitorConfig.perfCheckURL = jSONObject.optString("perfCheckURL", "");
            return wVMonitorConfig;
        } catch (JSONException unused) {
            TaoLog.e(TAG, "parseRule error. content=" + str);
            return null;
        }
    }
}
