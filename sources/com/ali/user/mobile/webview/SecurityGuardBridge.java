package com.ali.user.mobile.webview;

import android.content.ContextWrapper;
import android.os.Build;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.WindVaneInterface;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.utils.NetworkUtil;
import com.alibaba.fastjson.JSON;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SecurityGuardBridge extends WVApiPlugin {
    private void getEncryptedDevAndEnvInfo(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            str2 = new JSONObject(str).optString("key");
        } catch (JSONException unused) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            wVCallBackContext.error(WVResult.RET_PARAM_ERR);
            return;
        }
        try {
            String encryptedDevAndEnvInfo = SecurityGuardManager.getInstance(new ContextWrapper(this.mContext)).getDataCollectionComp().getEncryptedDevAndEnvInfo(16, str2);
            WVResult wVResult = new WVResult();
            wVResult.addData("encryptedInfo", encryptedDevAndEnvInfo);
            wVCallBackContext.success(wVResult);
        } catch (Exception unused2) {
            wVCallBackContext.error();
        }
    }

    @WindVaneInterface
    private void getInfo(WVCallBackContext wVCallBackContext, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceID", DataProviderFactory.getDataProvider().getDeviceId());
        hashMap.put("ttid", DataProviderFactory.getDataProvider().getTTID());
        hashMap.put("network", NetworkUtil.getNetworkType(this.mContext));
        hashMap.put("sdkversion", "" + Build.VERSION.SDK_INT);
        wVCallBackContext.success(JSON.toJSONString(hashMap));
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getSecurityGuardEncryptedDevAndEnvInfo".equals(str)) {
            getEncryptedDevAndEnvInfo(wVCallBackContext, str2);
            return true;
        } else if ("getDeviceInfo".equals(str)) {
            getInfo(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }
}
