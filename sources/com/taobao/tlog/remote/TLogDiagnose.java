package com.taobao.tlog.remote;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.upload.LogFileUploadManager;
import com.taobao.tao.log.upload.TLogUploadDiagnoseListener;
import com.taobao.tlog.remote.TLogDiagnose;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class TLogDiagnose extends WVApiPlugin {
    private static final String ACTION_GET_TLOG_LIST = "getTLogList";
    private static final String ACTION_IS_ENABLE = "isUploadEnable";
    private static final String ACTION_UPLOAD_TLOG = "uploadTLog";
    private static final String BRIDGE = "TLogDiagnoseBridge";
    private static final String ERROR_EXEC = "100";
    private static final String ERROR_IS_DISABLE = "101";
    private static final String ERROR_NEED_BIZ_INFO = "202";
    private static final String ERROR_NEED_SESSION_ID = "203";
    private static final String ERROR_NO_TLOG_FILE = "201";
    private static final String EVENT_UPLOAD_PROCESS = "uploadProcess";
    private static final String TAG = "TLogDiagnose";
    private String sessionID;

    private void error(WVCallBackContext wVCallBackContext, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", str);
            wVCallBackContext.error(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            wVCallBackContext.error();
        }
    }

    private void getTLogFileList(WVCallBackContext wVCallBackContext) {
        if (!TLogInitializer.getInstance().isScanUploadEnable()) {
            Log.e(TAG, "Scan Upload is disable");
            error(wVCallBackContext, "101");
            return;
        }
        Log.d(TAG, "getTLogFileList");
        try {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            for (String str : TLogUtils.getFilePathAll(".tlog", 0)) {
                File file = new File(str);
                if (file.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fileName", file.getName());
                    jSONObject.put(TLogEventConst.PARAM_FILE_SIZE, file.length());
                    jSONObject.put("filePath", str);
                    jSONArray.put(i, jSONObject);
                    i++;
                }
            }
            if (jSONArray.length() == 0) {
                Log.e(TAG, "TLog file is empty!");
                error(wVCallBackContext, ERROR_NO_TLOG_FILE);
                return;
            }
            Log.d(TAG, "TLog file:" + jSONArray.toString());
            wVCallBackContext.success(jSONArray.toString());
        } catch (Exception e) {
            Log.e(TAG, "Get TLog file exception!");
            e.printStackTrace();
            error(wVCallBackContext, "100");
        }
    }

    public static void init() {
        try {
            Log.d(TAG, "init TLogDiagnoseBridge");
            WVPluginManager.registerPlugin(BRIDGE, (Class<? extends WVApiPlugin>) TLogDiagnose.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void isEnable(WVCallBackContext wVCallBackContext) {
        if (TLogInitializer.getInstance().isScanUploadEnable()) {
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadLogFile$0(WVCallBackContext wVCallBackContext, String str, String str2, String str3, Map map) {
        if (TextUtils.isEmpty(str) || !str.equals(this.sessionID)) {
            return;
        }
        Log.d(TAG, String.format("UploadDiagnose: sessionID=%s, stage=%s, event=%s, data=%s", str, str2, str3, map));
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put(TLogEventConst.PARAM_SESSION_ID, str);
            jSONObject.put(TLogEventConst.PARAM_UPLOAD_STAGE, str2);
            jSONObject.put("event", str3);
            wVCallBackContext.fireEvent(EVENT_UPLOAD_PROCESS, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "fireEvent exception!!");
        }
    }

    private void uploadLogFile(String str, final WVCallBackContext wVCallBackContext) {
        Log.d(TAG, "uploadLogFile");
        if (!TLogInitializer.getInstance().isScanUploadEnable()) {
            Log.e(TAG, "Scan Upload is disable");
            error(wVCallBackContext, "101");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("bizType", "");
            String optString2 = jSONObject.optString("bizCode", "");
            String optString3 = jSONObject.optString("days", "");
            String optString4 = jSONObject.optString(TLogEventConst.PARAM_SESSION_ID, "");
            this.sessionID = optString4;
            Log.d(TAG, String.format("sessionID=%s, bizType=%s, bizCode=%s, uploadDays=%s", optString4, optString, optString2, optString3));
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                if (TextUtils.isEmpty(this.sessionID)) {
                    error(wVCallBackContext, ERROR_NEED_SESSION_ID);
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("extraInfos");
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.getString(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TLogEventHelper.setUploadDiagnoseListener(this.sessionID, new TLogUploadDiagnoseListener() { // from class: tb.jk2
                    @Override // com.taobao.tao.log.upload.TLogUploadDiagnoseListener
                    public final void onEvent(String str2, String str3, String str4, Map map) {
                        TLogDiagnose.this.lambda$uploadLogFile$0(wVCallBackContext, str2, str3, str4, map);
                    }
                });
                new LogFileUploadManager(this.mContext).uploadTLogFile(this.sessionID, new String[]{optString3}, optString, optString2, hashMap, null);
                wVCallBackContext.success();
                return;
            }
            error(wVCallBackContext, ERROR_NEED_BIZ_INFO);
        } catch (Exception e2) {
            Log.d(TAG, "uploadLogFile exception");
            e2.printStackTrace();
            error(wVCallBackContext, "100");
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -243105839:
                if (str.equals(ACTION_UPLOAD_TLOG)) {
                    c = 0;
                    break;
                }
                break;
            case 91598948:
                if (str.equals(ACTION_GET_TLOG_LIST)) {
                    c = 1;
                    break;
                }
                break;
            case 1438698798:
                if (str.equals(ACTION_IS_ENABLE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uploadLogFile(str2, wVCallBackContext);
                break;
            case 1:
                getTLogFileList(wVCallBackContext);
                break;
            case 2:
                isEnable(wVCallBackContext);
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        if (TextUtils.isEmpty(this.sessionID)) {
            return;
        }
        TLogEventHelper.clearUploadDiagnoseListener(this.sessionID);
    }
}
