package com.alipay.auth.mobile.common;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alipay.auth.mobile.api.IAlipayAuthMonitor;
import com.taobao.wireless.security.sdk.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AlipayAuthUtils {
    public static String atlasSignData(Context context, String str, String str2, IAlipayAuthMonitor iAlipayAuthMonitor) {
        String str3 = "";
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            LoggerUtils.d("AlipayAuthUtils", "获取sgMgr对象");
            if (securityGuardManager != null) {
                LoggerUtils.d("AlipayAuthUtils", "sgMgr not null");
                ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
                HashMap hashMap = new HashMap();
                hashMap.put("INPUT", str2);
                hashMap.put("ATLAS", "a");
                SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                securityGuardParamContext.appKey = str;
                securityGuardParamContext.paramMap = hashMap;
                securityGuardParamContext.requestType = 5;
                str3 = secureSignatureComp.signRequest(securityGuardParamContext, "");
                LoggerUtils.d("AlipayAuthUtils", "sign = " + str3);
            }
        } catch (SecException e) {
            LoggerUtils.e("AlipayAuthUtils", "atlasSignData SecException error", e);
            MonitorAlipayAuth.getInstance().monitorAlipayAuth(iAlipayAuthMonitor, "AliPayAuth_SignError");
        } catch (Throwable th) {
            LoggerUtils.e("AlipayAuthUtils", "atlasSignData error", th);
            MonitorAlipayAuth.getInstance().monitorAlipayAuth(iAlipayAuthMonitor, "AliPayAuth_SignError");
        }
        LoggerUtils.d("AlipayAuthUtils", "end sign = " + str3);
        return str3;
    }

    public static String encrypt(Context context, String str, String str2, IAlipayAuthMonitor iAlipayAuthMonitor) {
        String str3 = "";
        try {
            LoggerUtils.d("AlipayAuthUtils", "encrypt param appkey=" + str + " data=" + str2);
            com.taobao.wireless.security.sdk.SecurityGuardManager securityGuardManager = com.taobao.wireless.security.sdk.SecurityGuardManager.getInstance(context);
            if (securityGuardManager != null) {
                LoggerUtils.d("AlipayAuthUtils", "sgMgr != null");
                IStaticDataEncryptComponent staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp();
                if (staticDataEncryptComp != null) {
                    LoggerUtils.d("AlipayAuthUtils", "comp != null");
                    str3 = staticDataEncryptComp.staticSafeEncrypt(16, str, str2);
                    LoggerUtils.d("AlipayAuthUtils", "encryptData=" + str3);
                    return str3;
                }
                return "";
            }
            return "";
        } catch (Throwable th) {
            LoggerUtils.e("AlipayAuthUtils", "encrypt error", th);
            MonitorAlipayAuth.getInstance().monitorAlipayAuth(iAlipayAuthMonitor, "AliPayAuth_EncError");
            return str3;
        }
    }

    public static String strJoint(Map<String, String> map) {
        return strJoint(null, map);
    }

    public static String strJoint(String str, Map<String, String> map) {
        String str2;
        if (map == null || map.size() <= 0) {
            str2 = null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
            str2 = sb.substring(0, sb.lastIndexOf("&"));
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "&" + str2;
        }
        LoggerUtils.d("AlipayAuthUtils", str2);
        return str2;
    }
}
