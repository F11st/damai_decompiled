package android.taobao.windvane.extra.ha;

import android.annotation.SuppressLint;
import android.os.Message;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.UCHASettings;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public class UCHAManager implements ValueCallback<Pair<Message, Message>> {
    private static UCHAManager INSTANCE = null;
    private static final String TAG = "UCHA";
    private static boolean closeUCHA = false;
    private static long commonID = 0;
    private static String currentUrl = "";
    private static String lastID = "";
    private static boolean onlyBkpg = true;
    private StringBuilder sb = new StringBuilder();

    private String getConfigsFromSomeWhere(UCHASettings.ConfigRate configRate) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cver", 1);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("u4_collect_url_query", configRate.u4CollectUrlQuery);
            jSONObject3.put("u4_collect_url_query", configRate.u4CollectUrlRef);
            jSONObject3.put("u4_bkpg_sampling_rate", configRate.u4BkpgSamplingRate);
            jSONObject3.put("u4_t1t3detail_sampling_rate", configRate.u4T1t3detailSamplingRate);
            jSONObject3.put("u4_resloadfail_sampling_rate", configRate.u4ResloadfailSamplingRate);
            jSONObject3.put("u4_xhr_sampling_rate", configRate.u4XhrSamplingRate);
            jSONObject3.put("u4_jserr_sampling_rate", configRate.u4JserrSamplingRate);
            jSONObject3.put("u4_har_sampling_rate", configRate.u4HarSamplingRate);
            jSONObject2.put("common", jSONObject3);
            jSONObject.put(Constants.CONFIG, jSONObject2);
        } catch (Exception e) {
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

    public void commitUCHA() {
    }

    public void initHAParam(UCHASettings uCHASettings) {
        try {
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Pair<Message, Message> pair) {
        Map map = (Map) ((Message) pair.first).obj;
        String str = (String) map.get("log_data");
        String str2 = (String) map.get("link_key");
        String str3 = (String) map.get("link_id");
        if (TextUtils.equals("pvuv", (String) map.get(WPKFactory.INSTANCE_KEY_LOG_TYPE))) {
            return;
        }
        if (TextUtils.isEmpty(lastID)) {
            lastID = str3;
        }
        boolean z = true;
        if (onlyBkpg && !TextUtils.equals(str2, "bkpg")) {
            z = false;
        }
        if (!TextUtils.equals(str3, lastID)) {
            commitUCHA();
            StringBuilder sb = this.sb;
            sb.delete(0, sb.length());
            if (z) {
                lastID = str3;
                this.sb.append(str);
            }
        } else if (z) {
            StringBuilder sb2 = this.sb;
            sb2.append(str);
            sb2.append(StringUtils.LF);
        }
        if (!TextUtils.equals("bkpg", str2)) {
            TaoLog.i(TAG, "linkID:[" + str3 + "];logData:[" + str + jn1.ARRAY_END_STR);
            return;
        }
        TaoLog.e(TAG, "linkID:[" + str3 + "];logData:[" + str + jn1.ARRAY_END_STR);
    }
}
