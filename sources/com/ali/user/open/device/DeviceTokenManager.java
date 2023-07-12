package com.ali.user.open.device;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.service.StorageService;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DeviceTokenManager {
    private static final String DEVICE_TOKEN_ACCOUNT = "device_token";
    private static volatile DeviceTokenManager singleton;

    private DeviceTokenManager() {
    }

    public static DeviceTokenManager getInstance() {
        if (singleton == null) {
            synchronized (DeviceTokenManager.class) {
                if (singleton == null) {
                    singleton = new DeviceTokenManager();
                }
            }
        }
        return singleton;
    }

    private DeviceTokenAccount parseObject(String str) throws JSONException {
        DeviceTokenAccount deviceTokenAccount = new DeviceTokenAccount();
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            deviceTokenAccount.openId = jSONObject.optString("openId");
            deviceTokenAccount.tokenKey = jSONObject.optString("tokenKey");
            deviceTokenAccount.site = jSONObject.optString("site");
            deviceTokenAccount.hid = jSONObject.optString("userId");
            deviceTokenAccount.t = jSONObject.optString("t");
        }
        return deviceTokenAccount;
    }

    private String toJSONString(DeviceTokenAccount deviceTokenAccount) {
        if (deviceTokenAccount != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("openId", deviceTokenAccount.openId);
                jSONObject.put("tokenKey", deviceTokenAccount.tokenKey);
                jSONObject.put("site", deviceTokenAccount.site);
                jSONObject.put("userId", deviceTokenAccount.hid);
                jSONObject.put("t", String.valueOf(System.currentTimeMillis()));
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public void clearDeviceToken() {
        ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue("device_token");
    }

    public DeviceTokenAccount getDeviceToken() {
        try {
            return parseObject(((StorageService) AliMemberSDK.getService(StorageService.class)).getDDpExValue("device_token"));
        } catch (JSONException unused) {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue("device_token");
            return null;
        }
    }

    public void putDeviceToken(DeviceTokenAccount deviceTokenAccount, String str) {
        if (!ConfigManager.getInstance().isSaveHistoryWithSalt() || ((StorageService) AliMemberSDK.getService(StorageService.class)).saveSafeToken(deviceTokenAccount.tokenKey, str)) {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue("device_token", toJSONString(deviceTokenAccount));
        }
    }

    public void removeDeviceToken(DeviceTokenAccount deviceTokenAccount) {
        if (deviceTokenAccount == null) {
            return;
        }
        try {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeSafeToken(deviceTokenAccount.tokenKey);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue("device_token");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
