package com.ali.user.open.core.util;

import android.content.Context;
import android.util.DisplayMetrics;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RichWUA;
import com.ali.user.open.core.model.WUAData;
import com.ali.user.open.core.service.StorageService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.youku.usercenter.passport.PassportConfig;
import tb.y90;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RiskControlInfoContext {
    public static String buildRiskControlInfo() {
        JSONObject jSONObject = new JSONObject();
        StorageService storageService = (StorageService) AliMemberSDK.getService(StorageService.class);
        WUAData wua = storageService.getWUA();
        if (wua != null) {
            jSONObject.put("wua", (Object) wua.wua);
            jSONObject.put("t", (Object) wua.t);
        }
        jSONObject.put("umidToken", (Object) storageService.getUmid());
        Context applicationContext = KernelContext.getApplicationContext();
        jSONObject.put(WXConfig.osName, (Object) "android");
        jSONObject.put("osVersion", (Object) Build.VERSION.getRELEASE());
        String model = Build.getMODEL();
        jSONObject.put(WXDebugConstants.ENV_DEVICE_MODEL, (Object) model);
        jSONObject.put("deviceName", (Object) model);
        jSONObject.put("deviceBrand", (Object) Build.getMANUFACTURER());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        applicationContext.getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        jSONObject.put("screenSize", (Object) (i + Constants.Name.X + i2));
        jSONObject.put(PassportConfig.STATISTIC_APPSTORE, (Object) AliMemberSDK.ttid);
        jSONObject.put("ssid", (Object) SystemUtils.getSSID(applicationContext));
        jSONObject.put(y90.BSSID, (Object) SystemUtils.getBSSID(applicationContext));
        return jSONObject.toJSONString();
    }

    public static JSONObject getCommon() {
        JSONObject jSONObject = new JSONObject();
        StorageService storageService = (StorageService) AliMemberSDK.getService(StorageService.class);
        if (storageService != null) {
            jSONObject.put("umidToken", (Object) storageService.getUmid());
        }
        Context applicationContext = KernelContext.getApplicationContext();
        jSONObject.put(WXConfig.osName, (Object) "android");
        jSONObject.put("osVersion", (Object) Build.VERSION.getRELEASE());
        String model = Build.getMODEL();
        jSONObject.put(WXDebugConstants.ENV_DEVICE_MODEL, (Object) model);
        jSONObject.put("deviceName", (Object) model);
        jSONObject.put("deviceBrand", (Object) Build.getMANUFACTURER());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        applicationContext.getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        jSONObject.put("screenSize", (Object) (i + Constants.Name.X + i2));
        jSONObject.put(PassportConfig.STATISTIC_APPSTORE, (Object) AliMemberSDK.ttid);
        jSONObject.put("ssid", (Object) SystemUtils.getSSID(applicationContext));
        jSONObject.put(y90.BSSID, (Object) SystemUtils.getBSSID(applicationContext));
        return jSONObject;
    }

    public static void getRiskControlInfo(final MemberCallback<String> memberCallback) {
        StorageService storageService;
        if (memberCallback == null || (storageService = (StorageService) AliMemberSDK.getService(StorageService.class)) == null) {
            return;
        }
        storageService.getWUAData(new MemberCallback<RichWUA>() { // from class: com.ali.user.open.core.util.RiskControlInfoContext.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                MemberCallback.this.onSuccess(RiskControlInfoContext.getCommon().toJSONString());
            }

            @Override // com.ali.user.open.core.callback.MemberCallback
            public void onSuccess(RichWUA richWUA) {
                JSONObject common = RiskControlInfoContext.getCommon();
                if (richWUA != null) {
                    common.put("wua", (Object) richWUA.wua);
                    common.put("t", (Object) richWUA.t);
                }
                MemberCallback.this.onSuccess(common.toJSONString());
            }
        });
    }
}
