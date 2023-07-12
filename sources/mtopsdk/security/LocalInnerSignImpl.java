package mtopsdk.security;

import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.security.ISign;
import mtopsdk.security.util.HmacSha1Utils;
import mtopsdk.security.util.SecurityUtils;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LocalInnerSignImpl extends AbstractSignImpl {
    private static final String TAG = "mtopsdk.LocalInnerSignImpl";
    String appKey;
    String appSecret;

    public LocalInnerSignImpl(String str, String str2) {
        this.appKey = str;
        this.appSecret = str2;
    }

    private String convertInnerBaseStrMap(Map<String, String> map, String str) {
        if (map == null || map.size() < 1) {
            return null;
        }
        String str2 = map.get("extdata");
        String str3 = map.get("x-features");
        StringBuilder sb = new StringBuilder(64);
        sb.append(SecurityUtils.convertNull2Default(map.get("utdid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("uid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_REQBIZ_EXT)));
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(SecurityUtils.getMd5(map.get("data")));
        sb.append("&");
        sb.append(map.get("t"));
        sb.append("&");
        sb.append(map.get("api"));
        sb.append("&");
        sb.append(map.get("v"));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("sid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("ttid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("deviceId")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("lat")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("lng")));
        sb.append("&");
        if (StringUtils.isNotBlank(str2)) {
            sb.append(str2);
            sb.append("&");
        }
        sb.append(str3);
        return sb.toString();
    }

    @Override // mtopsdk.security.ISign
    public String getAppKey(ISign.SignCtx signCtx) {
        return this.appKey;
    }

    @Override // mtopsdk.security.ISign
    public String getCommonHmacSha1Sign(String str, String str2) {
        String instanceId = getInstanceId();
        if (StringUtils.isBlank(str)) {
            TBSdkLog.e(TAG, instanceId + " [getCommonHmacSha1Sign] baseStr is null.appKey=" + str2);
            return null;
        } else if (str2 != null && str2.equals(this.appKey)) {
            return HmacSha1Utils.hmacSha1Hex(str, this.appSecret);
        } else {
            StringBuilder sb = new StringBuilder(64);
            sb.append(instanceId);
            sb.append(" [getCommonHmacSha1Sign] request appKey mismatches global appKey.requestAppKey=");
            sb.append(str2);
            sb.append(",globalAppKey=");
            sb.append(this.appKey);
            TBSdkLog.e(TAG, sb.toString());
            return null;
        }
    }

    @Override // mtopsdk.security.ISign
    public String getMtopApiSign(HashMap<String, String> hashMap, String str, String str2) {
        String instanceId = getInstanceId();
        if (hashMap == null) {
            TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] params is null.appKey=" + str);
            return null;
        } else if (str == null) {
            hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, "AppKey is null");
            TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] AppKey is null.");
            return null;
        } else {
            try {
                return getCommonHmacSha1Sign(convertInnerBaseStrMap(hashMap, str), str);
            } catch (Exception e) {
                TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] ISecureSignatureComponent signRequest error", e);
                return null;
            }
        }
    }
}
