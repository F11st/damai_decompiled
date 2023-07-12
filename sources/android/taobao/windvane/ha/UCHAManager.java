package android.taobao.windvane.ha;

import android.annotation.SuppressLint;
import android.os.Message;
import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.UCHASettings;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public class UCHAManager implements ValueCallback<Pair<Message, Message>> {
    private static UCHAManager INSTANCE = null;
    private static final String TAG = "UCHA";
    public static final int TYPE_BKPG = 0;
    public static final int TYPE_BLACK = 2;
    public static final int TYPE_HARLOG = 1;
    public static final int TYPE_MEM = 3;
    public static final int TYPE_NONE = -1;
    private List<String> mMemoryLogType = Arrays.asList("mapsgrp", "jsobjheap", "jsexalloc", "gltex");

    private String getConfigsFromSomeWhere(UCHASettings.ConfigRate configRate) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cver", 1);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("u4_collect_url_query", configRate.u4CollectUrlQuery);
            jSONObject3.put("u4_collect_url_ref", configRate.u4CollectUrlRef);
            jSONObject3.put("u4_bkpg_sampling_rate", configRate.u4BkpgSamplingRate);
            jSONObject3.put("u4_t1t3detail_sampling_rate", configRate.u4T1t3detailSamplingRate);
            jSONObject3.put("u4_resloadfail_sampling_rate", configRate.u4ResloadfailSamplingRate);
            jSONObject3.put("u4_xhr_sampling_rate", configRate.u4XhrSamplingRate);
            jSONObject3.put("u4_jserr_sampling_rate", configRate.u4JserrSamplingRate);
            jSONObject3.put("u4_har_sampling_rate", configRate.u4HarSamplingRate);
            jSONObject3.put("u4_interaction_js_error_sampling_rate", configRate.u4InteractionJsErrorSamplingRate);
            jSONObject3.put("u4_webgl_error_state_api_sampling_rate", configRate.u4WebglErrorStateApiSamplingRate);
            jSONObject3.put("u4_maps_groups_sampling_rate", configRate.u4MapsGroupsSamplingRate);
            jSONObject3.put("u4_maps_groups_tpupload_define", configRate.u4MapsGroupsTpuploadDefine);
            jSONObject3.put("u4_maps_groups_max_script_memory", configRate.u4MapsGroupsMaxScriptMemory);
            jSONObject3.put("u4_maps_groups_max_gl_memory", configRate.u4MapsGroupsMaxGlMemory);
            jSONObject3.put("u4_uc_large_alloc_size", configRate.u4UcLargeAllocSize);
            jSONObject2.put("common", jSONObject3);
            jSONObject.put(Constants.CONFIG, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static UCHAManager getInstance() {
        if (INSTANCE == null) {
            synchronized (UCHAManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UCHAManager();
                }
            }
        }
        return INSTANCE;
    }

    private void initCallBack() {
        HashMap hashMap = new HashMap();
        hashMap.put("log_upload_callback", this);
        UCCore.notifyCoreEvent(14, hashMap);
    }

    private void setPubOption() {
        HashMap hashMap = new HashMap();
        hashMap.put("bver", GlobalConfig.getInstance().getAppVersion());
        UCCore.notifyCoreEvent(15, hashMap);
        try {
            UCCore.notifyCoreEvent(16, new JSONObject(getConfigsFromSomeWhere(GlobalConfig.getInstance().getConfigRates())));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initApmCallback(String str, String str2) {
        if (WVPerformanceManager.getInstance().getConfig().isOpenHA()) {
            UCHAReporter.getInstance().reset(str, str2);
        }
    }

    public void initHAParam(UCHASettings uCHASettings) {
        if (!WVPerformanceManager.getInstance().getConfig().isOpenHA() || uCHASettings == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WPKFactory.INIT_KEY_CONTEXT, GlobalConfig.context.getApplicationContext());
        hashMap.put("appid", uCHASettings.appid);
        hashMap.put(WPKFactory.INIT_KEY_APP_SECRET, uCHASettings.appSecret);
        hashMap.put(WPKFactory.INIT_KEY_LOG_UPLOAD_MODE, Integer.valueOf(uCHASettings.logUploadMode));
        hashMap.put(WPKFactory.INIT_KEY_CONFIG_UPDATE_MODE, Integer.valueOf(uCHASettings.configUpdateMode));
        hashMap.put("debug", Boolean.valueOf(uCHASettings.debug));
        UCCore.notifyCoreEvent(13, hashMap);
        if (uCHASettings.logUploadMode == 1) {
            initCallBack();
        }
        if (uCHASettings.configUpdateMode == 1) {
            setPubOption();
        }
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Pair<Message, Message> pair) {
        boolean z;
        Map map = (Map) ((Message) pair.first).obj;
        String str = (String) map.get(WPKFactory.INSTANCE_KEY_LOG_TYPE);
        String str2 = (String) map.get("log_data");
        String str3 = (String) map.get("link_key");
        String str4 = (String) map.get("link_id");
        if (TextUtils.isEmpty(str) || TextUtils.equals("pvuv", str)) {
            return;
        }
        int i = -1;
        if (TextUtils.equals("bkpg", str3)) {
            z = true;
            i = 0;
        } else if (TextUtils.equals("harLog", str)) {
            z = true;
            i = 1;
        } else if (TextUtils.equals("jssdkidx", str)) {
            z = true;
            i = 2;
        } else if (this.mMemoryLogType.contains(str)) {
            i = 3;
            z = true;
        } else {
            z = false;
        }
        if (z) {
            TaoLog.e(TAG, "collect log, type:[" + str + "]; linkID:[" + str4 + "]; logData:[" + str2 + jn1.ARRAY_END_STR);
        } else {
            TaoLog.i(TAG, "need not collect log, type:[" + str + "]; linkID:[" + str4 + "];logData:[" + str2 + jn1.ARRAY_END_STR);
        }
        if (WVPerformanceManager.getInstance().getConfig().closeUCHA()) {
            return;
        }
        if (i == 2) {
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            boolean z2 = ((double) wVCommonConfigData.ucParam.webglErrorRate) >= Math.random() * 100.0d;
            TaoLog.i(TAG, "webgl error report with " + wVCommonConfigData.ucParam.webglErrorRate + "% sample rate");
            z = z2;
        }
        if (z) {
            UCHAReporter.getInstance().set(str2, i, str4);
        }
    }
}
