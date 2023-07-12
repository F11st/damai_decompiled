package com.ali.user.mobile.security;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.log.TLogAdapter;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class SSOSecurityService {
    public static final String TAG = "Login.SSOSecurityService";
    private static ISecureSignatureComponent signComponent;
    private static SSOSecurityService ssoSecurityService;

    private SSOSecurityService() {
    }

    public static SSOSecurityService getInstace(Context context) throws SecException {
        if (ssoSecurityService == null) {
            ssoSecurityService = new SSOSecurityService();
            if (SecurityGuardManagerWraper.getSecurityGuardManager() != null) {
                signComponent = SecurityGuardManagerWraper.getSecurityGuardManager().getSecureSignatureComp();
            }
        }
        return ssoSecurityService;
    }

    private static ISecureSignatureComponent getSignComponent() {
        if (signComponent == null && SecurityGuardManagerWraper.getSecurityGuardManager() != null) {
            signComponent = SecurityGuardManagerWraper.getSecurityGuardManager().getSecureSignatureComp();
        }
        return signComponent;
    }

    public String sign(String str, TreeMap<String, String> treeMap, String str2) throws SecException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        return sign(str, sb.substring(0, sb.length() - 1), str2);
    }

    public String sign(String str, TreeMap<String, String> treeMap) throws SecException {
        return sign(str, treeMap, "");
    }

    public static String sign(String str, String str2, String str3) throws SecException {
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ATLAS", str3);
        }
        if (DataProviderFactory.getDataProvider().getEnvType() == 1) {
            hashMap.put("ATLAS", "daily");
        }
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 5;
        String signRequest = getSignComponent() != null ? getSignComponent().signRequest(securityGuardParamContext, "") : "";
        if (Debuggable.isDebug()) {
            TLogAdapter.e(TAG, "sign = " + signRequest + " ,appKey = " + str + ", beSigned = " + str2);
        }
        return signRequest;
    }

    public static String sign(String str, String str2) throws SecException {
        return sign(str, str2, "");
    }
}
