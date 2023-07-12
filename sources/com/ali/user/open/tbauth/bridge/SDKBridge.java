package com.ali.user.open.tbauth.bridge;

import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.webview.BridgeCallbackContext;
import com.ali.user.open.core.webview.BridgeMethod;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SDKBridge {
    @BridgeMethod
    public void getUmid(BridgeCallbackContext bridgeCallbackContext, String str) {
        StorageService storageService = (StorageService) AliMemberSDK.getService(StorageService.class);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("umidToken", storageService.getUmid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        bridgeCallbackContext.success(jSONObject.toString());
    }

    @BridgeMethod
    public void getWua(BridgeCallbackContext bridgeCallbackContext, String str) {
        StorageService storageService = (StorageService) AliMemberSDK.getService(StorageService.class);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wua", JSON.toJSONString(storageService.getWUA()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        bridgeCallbackContext.success(jSONObject.toString());
    }
}
