package com.ut.mini.core.sign;

import com.alibaba.analytics.utils.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class SecuritySDK {
    private static final String TAG = "SecuritySDK";
    private String mAppkey;
    private String mAuthcode;
    private Object s_securityGuardManagerObj = null;
    private Object s_secureSignatureCompObj = null;
    private Class s_securityGuardParamContextClz = null;
    private Field s_securityGuardParamContext_appKey = null;
    private Field s_securityGuardParamContext_paramMap = null;
    private Field s_securityGuardParamContext_requestType = null;
    private Method s_signRequestMethod = null;
    private int s_secureIndex = 3;
    private boolean isInitSecurityCheck = false;

    public SecuritySDK(String str, String str2) {
        this.mAppkey = null;
        this.mAuthcode = "";
        this.mAppkey = str;
        this.mAuthcode = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[Catch: all -> 0x008a, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:21:0x0098, B:15:0x0046, B:17:0x0055), top: B:31:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void initSecurityCheck() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.isInitSecurityCheck     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L7
            monitor-exit(r9)
            return
        L7:
            r0 = 0
            r1 = 2
            r2 = 1
            r3 = 0
            java.lang.Class<com.alibaba.wireless.security.open.SecurityGuardManager> r4 = com.alibaba.wireless.security.open.SecurityGuardManager.class
            int r5 = com.alibaba.wireless.security.open.SecurityGuardManager.i     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "getInstance"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L40
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r3] = r7     // Catch: java.lang.Throwable -> L40
            java.lang.reflect.Method r5 = r4.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L40
            com.alibaba.analytics.core.Variables r6 = com.alibaba.analytics.core.Variables.n()     // Catch: java.lang.Throwable -> L40
            android.content.Context r6 = r6.j()     // Catch: java.lang.Throwable -> L40
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L40
            r7[r3] = r6     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = r5.invoke(r0, r7)     // Catch: java.lang.Throwable -> L40
            r9.s_securityGuardManagerObj = r0     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = "getSecureSignatureComp"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L40
            java.lang.reflect.Method r0 = r4.getMethod(r0, r5)     // Catch: java.lang.Throwable -> L40
            java.lang.Object r5 = r9.s_securityGuardManagerObj     // Catch: java.lang.Throwable -> L40
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = r0.invoke(r5, r6)     // Catch: java.lang.Throwable -> L40
            r9.s_secureSignatureCompObj = r0     // Catch: java.lang.Throwable -> L40
            goto L53
        L40:
            r0 = move-exception
            goto L46
        L42:
            r4 = move-exception
            r8 = r4
            r4 = r0
            r0 = r8
        L46:
            java.lang.String r5 = "SecuritySDK"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = "initSecurityCheck"
            r6[r3] = r7     // Catch: java.lang.Throwable -> L9c
            r6[r2] = r0     // Catch: java.lang.Throwable -> L9c
            com.alibaba.analytics.utils.Logger.v(r5, r6)     // Catch: java.lang.Throwable -> L9c
        L53:
            if (r4 == 0) goto L98
            java.lang.Class<com.alibaba.wireless.security.open.SecurityGuardParamContext> r0 = com.alibaba.wireless.security.open.SecurityGuardParamContext.class
            r9.s_securityGuardParamContextClz = r0     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = "appKey"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L8a
            r9.s_securityGuardParamContext_appKey = r0     // Catch: java.lang.Throwable -> L8a
            java.lang.Class r0 = r9.s_securityGuardParamContextClz     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = "paramMap"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L8a
            r9.s_securityGuardParamContext_paramMap = r0     // Catch: java.lang.Throwable -> L8a
            java.lang.Class r0 = r9.s_securityGuardParamContextClz     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = "requestType"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L8a
            r9.s_securityGuardParamContext_requestType = r0     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent> r0 = com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent.class
            java.lang.String r4 = "signRequest"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L8a
            java.lang.Class r6 = r9.s_securityGuardParamContextClz     // Catch: java.lang.Throwable -> L8a
            r5[r3] = r6     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r2] = r6     // Catch: java.lang.Throwable -> L8a
            java.lang.reflect.Method r0 = r0.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L8a
            r9.s_signRequestMethod = r0     // Catch: java.lang.Throwable -> L8a
            goto L98
        L8a:
            r0 = move-exception
            java.lang.String r4 = "SecuritySDK"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = "initSecurityCheck"
            r1[r3] = r5     // Catch: java.lang.Throwable -> L9c
            r1[r2] = r0     // Catch: java.lang.Throwable -> L9c
            com.alibaba.analytics.utils.Logger.v(r4, r1)     // Catch: java.lang.Throwable -> L9c
        L98:
            r9.isInitSecurityCheck = r2     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r9)
            return
        L9c:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.core.sign.SecuritySDK.initSecurityCheck():void");
    }

    public String getSign(String str) {
        Class cls;
        Logger.f(TAG, "toBeSignedStr", str);
        if (!this.isInitSecurityCheck) {
            initSecurityCheck();
        }
        String str2 = null;
        if (this.mAppkey == null) {
            Logger.f(TAG, "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            Object obj = this.s_securityGuardManagerObj;
            if (obj == null || (cls = this.s_securityGuardParamContextClz) == null || this.s_securityGuardParamContext_appKey == null || this.s_securityGuardParamContext_paramMap == null || this.s_securityGuardParamContext_requestType == null || this.s_signRequestMethod == null || this.s_secureSignatureCompObj == null) {
                Logger.v(TAG, "UTSecurityThridRequestAuthentication.getSign s_securityGuardManagerObj", obj, "s_securityGuardParamContextClz", this.s_securityGuardParamContextClz, "s_securityGuardParamContext_appKey", this.s_securityGuardParamContext_appKey, "s_securityGuardParamContext_paramMap", this.s_securityGuardParamContext_paramMap, "s_securityGuardParamContext_requestType", this.s_securityGuardParamContext_requestType, "s_signRequestMethod", this.s_signRequestMethod);
            } else {
                try {
                    Object newInstance = cls.newInstance();
                    this.s_securityGuardParamContext_appKey.set(newInstance, this.mAppkey);
                    ((Map) this.s_securityGuardParamContext_paramMap.get(newInstance)).put("INPUT", str);
                    this.s_securityGuardParamContext_requestType.set(newInstance, Integer.valueOf(this.s_secureIndex));
                    str2 = (String) this.s_signRequestMethod.invoke(this.s_secureSignatureCompObj, newInstance, this.mAuthcode);
                } catch (Exception e) {
                    Logger.h(TAG, e, new Object[0]);
                }
            }
            Logger.f(TAG, "lSignedStr", str2);
            return str2;
        }
    }
}
