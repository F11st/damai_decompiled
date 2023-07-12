package com.taobao.orange.impl;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.taobao.orange.inner.ISign;
import com.taobao.orange.util.OLog;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBGuardSign implements ISign {
    private static final String TAG = "TBGuardSign";
    private static boolean mSecurityGuardValid;

    static {
        try {
            int i = SecurityGuardManager.i;
            mSecurityGuardValid = true;
        } catch (ClassNotFoundException unused) {
            mSecurityGuardValid = false;
        }
    }

    @Override // com.taobao.orange.inner.ISign
    public String sign(Context context, String str, String str2, String str3, String str4) {
        SecurityGuardManager securityGuardManager;
        if (!mSecurityGuardValid) {
            OLog.e(TAG, "no security guard exist", new Object[0]);
            return null;
        }
        try {
            securityGuardManager = SecurityGuardManager.getInstance(context);
        } catch (SecException e) {
            OLog.e(TAG, "sign", e, new Object[0]);
            securityGuardManager = null;
        }
        if (securityGuardManager == null) {
            OLog.e(TAG, "get SecurityGuardManager null", new Object[0]);
            return null;
        }
        ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str3);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        try {
            return secureSignatureComp.signRequest(securityGuardParamContext, str4);
        } catch (SecException e2) {
            OLog.e(TAG, "sign", e2, new Object[0]);
            return null;
        }
    }
}
