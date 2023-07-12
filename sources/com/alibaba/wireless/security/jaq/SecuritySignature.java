package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SecuritySignature {
    private Context a;

    public SecuritySignature(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    public String atlasSign(String str, String str2) throws JAQException {
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str);
        hashMap.put("ATLAS", "a");
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 5;
        try {
            if (SecurityGuardManager.getInstance(this.a).getAtlasEncryptComp() != null) {
                return SecurityGuardManager.getInstance(this.a).getSecureSignatureComp().signRequest(securityGuardParamContext, "0335");
            }
            throw new SecException(1098);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public String sign(String str, String str2) throws JAQException {
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        try {
            return SecurityGuardManager.getInstance(this.a).getSecureSignatureComp().signRequest(securityGuardParamContext, "0335");
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public String signWithSimulator(String str, String str2) throws JAQException {
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 6;
        try {
            return SecurityGuardManager.getInstance(this.a).getSecureSignatureComp().signRequest(securityGuardParamContext, "0335");
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }
}
