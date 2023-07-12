package android.taobao.windvane.jspatch;

import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVJsPatch implements WVEventListener {
    private static final String TAG = "WVJsPatch";
    private static WVJsPatch jsPatch;
    private Map<String, WVPatchConfig> configRuleMap = new HashMap();
    private Map<String, WVPatchConfig> ruleMap = new HashMap();

    private WVJsPatch() {
        WVEventService.getInstance().addEventListener(jsPatch);
    }

    public static synchronized WVJsPatch getInstance() {
        WVJsPatch wVJsPatch;
        synchronized (WVJsPatch.class) {
            if (jsPatch == null) {
                jsPatch = new WVJsPatch();
            }
            wVJsPatch = jsPatch;
        }
        return wVJsPatch;
    }

    private boolean tryJsPatch(Map<String, WVPatchConfig> map, IWVWebView iWVWebView, String str) {
        if (map != null && !map.isEmpty() && iWVWebView != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<String, WVPatchConfig> entry : map.entrySet()) {
                String key = entry.getKey();
                WVPatchConfig value = entry.getValue();
                if (value == null) {
                    TaoLog.w(TAG, "config is null");
                } else {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(TAG, "start match rules, rule: " + key);
                    }
                    if (value.pattern == null) {
                        try {
                            value.pattern = Pattern.compile(key);
                        } catch (PatternSyntaxException unused) {
                            TaoLog.e(TAG, "compile rule error, pattern: " + key);
                        }
                    }
                    Pattern pattern = value.pattern;
                    if (pattern != null && pattern.matcher(str).matches()) {
                        if (!value.jsString.startsWith("javascript:")) {
                            value.jsString = "javascript:" + value.jsString;
                        }
                        iWVWebView.evaluateJavascript(value.jsString);
                        if (TaoLog.getLogStatus()) {
                            TaoLog.d(TAG, "url matched, start execute jspatch, jsString: " + value.jsString);
                            return true;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        TaoLog.d(TAG, "no jspatch need execute");
        return false;
    }

    public void addRuleWithPattern(String str, String str2) {
        WVPatchConfig wVPatchConfig = new WVPatchConfig();
        wVPatchConfig.jsString = str2;
        this.ruleMap.put(str, wVPatchConfig);
    }

    public synchronized void config(String str) {
        removeAllConfigRules();
        if (TextUtils.isEmpty(str)) {
            TaoLog.d(TAG, "no jspatch");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String str2 = (String) jSONObject.get(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str2)) {
                    WVPatchConfig wVPatchConfig = new WVPatchConfig();
                    wVPatchConfig.jsString = str2;
                    this.configRuleMap.put(next, wVPatchConfig);
                }
            }
            if (this.ruleMap.isEmpty()) {
                TaoLog.d(TAG, "jspatch config is Empty");
                return;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "config success, config: " + str);
            }
        } catch (JSONException unused) {
            TaoLog.e(TAG, "get config error, config: " + str);
        }
    }

    public synchronized void execute(IWVWebView iWVWebView, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "start execute jspatch, url: " + str);
        }
        tryJsPatch(this.ruleMap, iWVWebView, str);
        tryJsPatch(this.configRuleMap, iWVWebView, str);
    }

    public Map<String, WVPatchConfig> getConfigRuleMap() {
        return this.configRuleMap;
    }

    public Map<String, WVPatchConfig> getRuleMap() {
        return this.ruleMap;
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        if (i == 1002) {
            execute(wVEventContext.webView, wVEventContext.url);
        }
        return new WVEventResult(false);
    }

    public synchronized void putConfig(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WVPatchConfig wVPatchConfig = new WVPatchConfig();
            wVPatchConfig.jsString = str2;
            this.configRuleMap.put(str, wVPatchConfig);
            TaoLog.d(TAG, "putConfig, url: " + str + " js: " + wVPatchConfig.jsString);
        }
    }

    public void removeAllConfigRules() {
        this.configRuleMap.clear();
    }

    public void removeAllRules() {
        this.ruleMap.clear();
    }

    public void removeRuleWithKey(String str) {
        String str2;
        Map<String, WVPatchConfig> map = this.ruleMap;
        if (map != null && !map.isEmpty() && str != null) {
            for (Map.Entry<String, WVPatchConfig> entry : this.ruleMap.entrySet()) {
                WVPatchConfig value = entry.getValue();
                if (value != null && (str2 = value.key) != null && str.equals(str2)) {
                    String key = entry.getKey();
                    this.ruleMap.remove(key);
                    TaoLog.i(TAG, "removeRuleWithKey : " + key);
                }
            }
            return;
        }
        TaoLog.w(TAG, "not need removeRuleWithKey");
    }

    public void addRuleWithPattern(String str, String str2, String str3) {
        WVPatchConfig wVPatchConfig = new WVPatchConfig();
        wVPatchConfig.jsString = str3;
        wVPatchConfig.key = str;
        this.ruleMap.put(str2, wVPatchConfig);
    }
}
