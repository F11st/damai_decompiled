package com.ali.user.mobile.security;

import android.text.TextUtils;
import com.ali.user.mobile.log.TLogAdapter;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AlibabaSecurityTokenService {
    private static final String TAG = "login.AlibabaSecurityTokenService";

    public static void removeSafeToken(String str) {
        try {
            SecurityGuardManagerWraper.getSecurityGuardManager().getSafeTokenComp().removeToken(str);
        } catch (SecException e) {
            TLogAdapter.e(TAG, "removeSafeToken SecException", e);
            SecurityUTHitUtils.utHit("60002", "removeToken " + e + ",errorCode=" + e.getErrorCode(), "Event_removeTokenFail");
        } catch (Throwable th) {
            SecurityUTHitUtils.utHit("60002", "removeToke " + th, "Event_removeTokenFail");
            TLogAdapter.e(TAG, "removeSafeToken SecException", th);
        }
    }

    public static synchronized boolean saveToken(String str, String str2) {
        synchronized (AlibabaSecurityTokenService.class) {
            if (TextUtils.isEmpty(str)) {
                SecurityUTHitUtils.utHit("60001", "key = null", "Event_saveTokenFail");
                return true;
            }
            try {
                ISafeTokenComponent safeTokenComp = SecurityGuardManagerWraper.getSecurityGuardManager().getSafeTokenComp();
                if (safeTokenComp != null) {
                    return safeTokenComp.saveToken(str, str2, null, 0);
                }
                SecurityUTHitUtils.utHit("60001", "ISafeTokenComponent = null", "Event_saveTokenFail");
                return false;
            } catch (SecException e) {
                TLogAdapter.e(TAG, "saveToken SecException", e);
                SecurityUTHitUtils.utHit("60001", "ISafeTokenComponent " + e + ",errorCode=" + e.getErrorCode(), "Event_saveTokenFail");
                return false;
            }
        }
    }

    public static String sign(String str, TreeMap<String, String> treeMap) {
        if (TextUtils.isEmpty(str)) {
            SecurityUTHitUtils.utHit("60003", "signError key is null", "Event_signFail");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        return sign(str, sb.substring(0, sb.length() - 1));
    }

    public static String sign(String str, String str2) {
        try {
            String signWithToken = SecurityGuardManagerWraper.getSecurityGuardManager().getSafeTokenComp().signWithToken(str, str2.getBytes("UTF-8"), 0);
            if (signWithToken == null) {
                SecurityUTHitUtils.utHit("60009", "signResultNull", "Event_signFail");
            }
            return signWithToken;
        } catch (SecException e) {
            TLogAdapter.e(TAG, "sign", e);
            SecurityUTHitUtils.utHit("60005", "signExceptionError " + e + ",errorCode=" + e.getErrorCode(), "Event_signFail");
            return null;
        } catch (Throwable th) {
            TLogAdapter.e(TAG, "sign", th);
            SecurityUTHitUtils.utHit("60005", "signThrowableError " + th, "Event_signFail");
            return null;
        }
    }
}
