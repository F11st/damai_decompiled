package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.utils.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestSecuritySDKRequestAuthentication {
    private String mAppkey;
    private Context mContext;
    private Object s_securityGuardManagerObj = null;
    private Object s_secureSignatureCompObj = null;
    private Class s_securityGuardParamContextClz = null;
    private Field s_securityGuardParamContext_appKey = null;
    private Field s_securityGuardParamContext_paramMap = null;
    private Field s_securityGuardParamContext_requestType = null;
    private Method s_signRequestMethod = null;
    private int s_secureIndex = 1;
    private boolean mBInitSecurityCheck = false;

    public RestSecuritySDKRequestAuthentication(Context context, String str) {
        this.mAppkey = null;
        this.mContext = context;
        this.mAppkey = str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:23:0x0084
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private synchronized void _initSecurityCheck() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.mBInitSecurityCheck     // Catch: java.lang.Throwable -> Lb0
            if (r0 == 0) goto L7
            monitor-exit(r7)
            return
        L7:
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.Class<com.taobao.wireless.security.sdk.SecurityGuardManager> r3 = com.taobao.wireless.security.sdk.SecurityGuardManager.class
            int r4 = com.taobao.wireless.security.sdk.SecurityGuardManager.e     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = "getInstance"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L3a
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r2] = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3a
            android.content.Context r6 = r7.mContext     // Catch: java.lang.Throwable -> L3a
            r5[r2] = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r4 = r4.invoke(r0, r5)     // Catch: java.lang.Throwable -> L3a
            r7.s_securityGuardManagerObj = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "getSecureSignatureComp"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L3a
            java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r5 = r7.s_securityGuardManagerObj     // Catch: java.lang.Throwable -> L3a
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r4 = r4.invoke(r5, r6)     // Catch: java.lang.Throwable -> L3a
            r7.s_secureSignatureCompObj = r4     // Catch: java.lang.Throwable -> L3a
            goto L3f
        L39:
            r3 = r0
        L3a:
            java.lang.String r4 = "initSecurityCheck failure, It's ok "
            com.alibaba.motu.tbrest.utils.LogUtil.i(r4)     // Catch: java.lang.Throwable -> Lb0
        L3f:
            if (r3 == 0) goto Lac
            java.lang.Class<com.taobao.wireless.security.sdk.SecurityGuardParamContext> r4 = com.taobao.wireless.security.sdk.SecurityGuardParamContext.class
            r7.s_securityGuardParamContextClz = r4     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "appKey"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.Throwable -> La7
            r7.s_securityGuardParamContext_appKey = r4     // Catch: java.lang.Throwable -> La7
            java.lang.Class r4 = r7.s_securityGuardParamContextClz     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "paramMap"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.Throwable -> La7
            r7.s_securityGuardParamContext_paramMap = r4     // Catch: java.lang.Throwable -> La7
            java.lang.Class r4 = r7.s_securityGuardParamContextClz     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "requestType"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.Throwable -> La7
            r7.s_securityGuardParamContext_requestType = r4     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "isOpen"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L6a
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L6a
            goto L70
        L6a:
            java.lang.String r3 = "initSecurityCheck failure, It's ok"
            com.alibaba.motu.tbrest.utils.LogUtil.i(r3)     // Catch: java.lang.Throwable -> La7
            r3 = r0
        L70:
            if (r3 == 0) goto L81
            java.lang.Object r0 = r7.s_securityGuardManagerObj     // Catch: java.lang.Throwable -> La7
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La7
            java.lang.Object r0 = r3.invoke(r0, r4)     // Catch: java.lang.Throwable -> La7
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> La7
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> La7
            goto L8e
        L81:
            java.lang.Class<com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent> r0 = com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent.class
            goto L89
        L84:
            java.lang.String r3 = "initSecurityCheck failure, It's ok"
            com.alibaba.motu.tbrest.utils.LogUtil.i(r3)     // Catch: java.lang.Throwable -> La7
        L89:
            if (r0 != 0) goto L8d
            r0 = 1
            goto L8e
        L8d:
            r0 = 0
        L8e:
            if (r0 == 0) goto L92
            r0 = 1
            goto L94
        L92:
            r0 = 12
        L94:
            r7.s_secureIndex = r0     // Catch: java.lang.Throwable -> La7
            java.lang.Class<com.taobao.wireless.security.sdk.securesignature.ISecureSignatureComponent> r0 = com.taobao.wireless.security.sdk.securesignature.ISecureSignatureComponent.class
            java.lang.String r3 = "signRequest"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> La7
            java.lang.Class r5 = r7.s_securityGuardParamContextClz     // Catch: java.lang.Throwable -> La7
            r4[r2] = r5     // Catch: java.lang.Throwable -> La7
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch: java.lang.Throwable -> La7
            r7.s_signRequestMethod = r0     // Catch: java.lang.Throwable -> La7
            goto Lac
        La7:
            java.lang.String r0 = "initSecurityCheck failure, It's ok"
            com.alibaba.motu.tbrest.utils.LogUtil.i(r0)     // Catch: java.lang.Throwable -> Lb0
        Lac:
            r7.mBInitSecurityCheck = r1     // Catch: java.lang.Throwable -> Lb0
            monitor-exit(r7)
            return
        Lb0:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.rest.RestSecuritySDKRequestAuthentication._initSecurityCheck():void");
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public String getSign(String str) {
        Class cls;
        if (!this.mBInitSecurityCheck) {
            _initSecurityCheck();
        }
        if (this.mAppkey == null) {
            LogUtil.e("RestSecuritySDKRequestAuthentication:getSign There is no appkey,please check it!");
            return null;
        } else if (str == null || this.s_securityGuardManagerObj == null || (cls = this.s_securityGuardParamContextClz) == null || this.s_securityGuardParamContext_appKey == null || this.s_securityGuardParamContext_paramMap == null || this.s_securityGuardParamContext_requestType == null || this.s_signRequestMethod == null || this.s_secureSignatureCompObj == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.s_securityGuardParamContext_appKey.set(newInstance, this.mAppkey);
                ((Map) this.s_securityGuardParamContext_paramMap.get(newInstance)).put("INPUT", str);
                this.s_securityGuardParamContext_requestType.set(newInstance, Integer.valueOf(this.s_secureIndex));
                return (String) this.s_signRequestMethod.invoke(this.s_secureSignatureCompObj, newInstance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }
}
