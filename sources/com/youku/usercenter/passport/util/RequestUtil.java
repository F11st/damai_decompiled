package com.youku.usercenter.passport.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.youku.usercenter.passport.BuildConfig;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.util.ReflectUtil;
import org.json.JSONObject;
import tb.y90;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class RequestUtil {
    public static final String CHARSET_NAME = "UTF-8";
    public static final int DEVICE_TYPE = 2;
    private static String sDeviceMac;
    private static String sSalt;
    private static String sScreenSize;
    private static String sSessionId;

    public static JSONObject addBasicInfo(JSONObject jSONObject, Context context, String str, String str2) {
        try {
            jSONObject.put(ALBiometricsKeys.KEY_APP_ID, str);
            jSONObject.put("appIdentifier", context.getPackageName());
            jSONObject.put("appSign", SysUtil.getApkPublicKeyDigest(context));
            jSONObject.put("nonceStr", str2);
            jSONObject.put("timestamp", PassportManager.getInstance().getTimestamp());
            jSONObject.put("version", "1.0.0");
            jSONObject.putOpt("sessionId", sSessionId);
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
        return jSONObject;
    }

    public static JSONObject addDeviceInfo(JSONObject jSONObject, Context context) {
        try {
            jSONObject.put("sdkVersion", BuildConfig.VERSION_NAME);
            jSONObject.put(WXConfig.osName, "Android");
            jSONObject.put("osVersion", SysUtil.getOSVersion());
            jSONObject.put("deviceBrand", SysUtil.getDeviceBrand());
            jSONObject.put(WXDebugConstants.ENV_DEVICE_MODEL, SysUtil.getDeviceModel());
            jSONObject.put("deviceName", SysUtil.getDeviceModel());
            if (TextUtils.isEmpty(sScreenSize)) {
                sScreenSize = SysUtil.getScreenSize(context);
            }
            jSONObject.put("screenSize", sScreenSize);
            jSONObject.put("deviceUid", SysUtil.getDeviceId(context));
            if (TextUtils.isEmpty(sDeviceMac)) {
                sDeviceMac = SysUtil.getDeviceMac();
            }
            jSONObject.put("network", SysUtil.getNetworkType(context));
            jSONObject.put("mac", sDeviceMac);
            StorageService storageService = (StorageService) AliMemberSDK.getService(StorageService.class);
            if (storageService != null) {
                jSONObject.put("umidToken", storageService.getUmid());
            }
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
        return jSONObject;
    }

    public static JSONObject addExtraInfo(JSONObject jSONObject, Context context) {
        String str = "";
        try {
            jSONObject.put(TbAuthConstants.CLIENT_IP, SysUtil.getDeviceIp());
            jSONObject.put("deviceType", 2);
            jSONObject.put("appFrom", "");
            jSONObject.put("userPort", "");
            String appVersionName = SysUtil.getAppVersionName(context);
            if (appVersionName != null) {
                str = appVersionName;
            }
            jSONObject.put("appVersion", str);
            jSONObject.put("ssid", SysUtil.getSSID(context));
            jSONObject.put(y90.BSSID, SysUtil.getBSSID(context));
            Map<String, String> map = PassportManager.getInstance().getConfig().mStatistics;
            if (map != null) {
                jSONObject.put("guId", map.get("guid"));
                jSONObject.put(PassportConfig.STATISTIC_OUID, map.get(PassportConfig.STATISTIC_OUID));
                jSONObject.put(PassportConfig.STATISTIC_APPSTORE, map.get(PassportConfig.STATISTIC_APPSTORE));
                jSONObject.put(PassportConfig.STATISTIC_RGUID, map.get(PassportConfig.STATISTIC_RGUID));
                jSONObject.put(PassportConfig.STATISTIC_UTDID, map.get(PassportConfig.STATISTIC_UTDID));
            }
            jSONObject.put("imei", SysUtil.getImei(context));
            double[] location = SysUtil.getLocation(context);
            if (location != null) {
                jSONObject.put("latitude", location[0]);
                jSONObject.put("longitude", location[1]);
            }
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
        return jSONObject;
    }

    public static String formatPost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String encode = URLEncoder.encode(Base64.encodeToString(str.getBytes(), 0), "UTF-8");
            StringBuilder sb = new StringBuilder();
            HashMap hashMap = new HashMap();
            hashMap.put("msg", encode);
            hashMap.put("sign", getSign(encode));
            sb.append(ReflectUtil.convertMapToDataStr(hashMap));
            return sb.toString();
        } catch (Exception e) {
            Logger.w("post data format Exception", e);
            return "";
        }
    }

    public static String getSign(String str) {
        if (sSalt == null) {
            sSalt = PassportManager.getInstance().getConfig().mAppSecret;
        }
        return EncryptUtil.encryptMD5(str + sSalt, true);
    }

    public static void updateSessionId(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(sSessionId) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("sdkResponseContext")) == null) {
            return;
        }
        sSessionId = optJSONObject.optString("sessionId");
    }
}
