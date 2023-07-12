package mtopsdk.security;

import androidx.annotation.NonNull;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.huawei.hms.opendevice.c;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.security.ISign;
import mtopsdk.security.util.SecurityUtils;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProductSignImpl extends AbstractSignImpl {
    private static final String TAG = "mtopsdk.ProductSignImpl";
    private SecurityGuardManager sgMgr = null;

    private Map<String, String> convertProductBaseStrMap(Map<String, String> map, String str) {
        if (map == null || map.size() < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(SecurityUtils.getMd5(map.get("data")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_REQBIZ_EXT)));
        sb.append("&");
        sb.append(map.get("x-features"));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("lat")));
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(map.get("api"));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("lng")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("sid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("uid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("ttid")));
        sb.append("&");
        sb.append(map.get("v"));
        sb.append("&");
        sb.append(map.get("t"));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("utdid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_PV)));
        HashMap hashMap = new HashMap(2);
        hashMap.put("INPUT", sb.toString());
        return hashMap;
    }

    private void initUmidToken(String str, String str2) {
        final String instanceId = getInstanceId();
        try {
            IUMIDComponent uMIDComp = this.sgMgr.getUMIDComp();
            if (uMIDComp != null) {
                uMIDComp.initUMID(str, getEnv(), str2, new IUMIDInitListenerEx() { // from class: mtopsdk.security.ProductSignImpl.1
                    @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
                    public void onUMIDInitFinishedEx(String str3, int i) {
                        if (i == 200) {
                            XState.setValue(instanceId, XStateConstants.KEY_UMID_TOKEN, str3);
                            TBSdkLog.i(ProductSignImpl.TAG, instanceId + " [initUmidToken]IUMIDComponent initUMID succeed,UMID token=" + str3);
                            return;
                        }
                        TBSdkLog.w(ProductSignImpl.TAG, instanceId + " [initUmidToken]IUMIDComponent initUMID error,resultCode :" + i);
                    }
                });
            }
        } catch (Exception e) {
            TBSdkLog.w(TAG, instanceId + " [initUmidToken]IUMIDComponent initUMID error", e);
        }
    }

    @Override // mtopsdk.security.ISign
    public String getAppKey(ISign.SignCtx signCtx) {
        if (signCtx == null) {
            return null;
        }
        try {
            return this.sgMgr.getStaticDataStoreComp().getAppKeyByIndex(signCtx.index, signCtx.authCode);
        } catch (SecException e) {
            TBSdkLog.e(TAG, getInstanceId() + " [appKey]getAppKeyByIndex error.errorCode=" + e.getErrorCode() + ",index=" + signCtx.index + ",authCode=" + signCtx.authCode, e);
            return null;
        } catch (Exception e2) {
            TBSdkLog.e(TAG, getInstanceId() + " [appKey]getAppKeyByIndex error.index=" + signCtx.index + ",authCode=" + signCtx.authCode, e2);
            return null;
        }
    }

    @Override // mtopsdk.security.ISign
    public String getCommonHmacSha1Sign(String str, String str2) {
        String instanceId = getInstanceId();
        if (str != null && str2 != null) {
            if (this.sgMgr == null) {
                TBSdkLog.e(TAG, instanceId + " [getCommonHmacSha1Sign]SecurityGuardManager is null,please call ISign init()");
                return null;
            }
            try {
                HashMap hashMap = new HashMap(1);
                hashMap.put("INPUT", str);
                SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                securityGuardParamContext.appKey = str2;
                securityGuardParamContext.requestType = 3;
                securityGuardParamContext.paramMap = hashMap;
                return this.sgMgr.getSecureSignatureComp().signRequest(securityGuardParamContext, getAuthCode());
            } catch (Throwable th) {
                TBSdkLog.e(TAG, instanceId + " [getCommonHmacSha1Sign] ISecureSignatureComponent signRequest error", th);
                return null;
            }
        }
        TBSdkLog.e(TAG, instanceId + " [getCommonHmacSha1Sign] appKey or baseStr is null.appKey=" + str2);
        return null;
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
        } else if (this.sgMgr == null) {
            hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, "SGManager is null");
            TBSdkLog.e(TAG, instanceId + " [getMtopApiSign]SecurityGuardManager is null,please call ISign init()");
            return null;
        } else {
            try {
                SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                securityGuardParamContext.appKey = str;
                securityGuardParamContext.requestType = 7;
                Map<String, String> convertProductBaseStrMap = convertProductBaseStrMap(hashMap, str);
                convertProductBaseStrMap.put("ATLAS", c.a);
                securityGuardParamContext.paramMap = convertProductBaseStrMap;
                return this.sgMgr.getSecureSignatureComp().signRequest(securityGuardParamContext, str2);
            } catch (SecException e) {
                int errorCode = e.getErrorCode();
                hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, String.valueOf(errorCode));
                TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] ISecureSignatureComponent signRequest error,errorCode=" + errorCode, e);
                return null;
            } catch (Throwable th) {
                TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] ISecureSignatureComponent signRequest error", th);
                return null;
            }
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i) {
        if (StringUtils.isBlank(str2) || StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return ((ISecurityBodyComponent) this.sgMgr.getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(str, str2, str3, hashMap, i, getEnv());
        } catch (Throwable th) {
            TBSdkLog.e(TAG, getInstanceId() + " [getSecBodyDataEx] ISecurityBodyComponent getSecurityBodyDataEx  error,flag=" + i, th);
            return null;
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public void init(@NonNull MtopConfig mtopConfig) {
        super.init(mtopConfig);
        String instanceId = getInstanceId();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(this.mtopConfig.context);
            this.sgMgr = securityGuardManager;
            String appKeyByIndex = securityGuardManager.getStaticDataStoreComp().getAppKeyByIndex(mtopConfig.appKeyIndex, getAuthCode());
            TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, instanceId + " [init]ISign get appKey=" + appKeyByIndex + ",authCode=" + getAuthCode());
            }
            initUmidToken(appKeyByIndex, getAuthCode());
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, instanceId + " [init]ISign init SecurityGuard succeed.init time=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (SecException e) {
            TBSdkLog.e(TAG, instanceId + " [init]ISign init SecurityGuard error.errorCode=" + e.getErrorCode(), e);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, instanceId + " [init]ISign init SecurityGuard error.", th);
        }
    }
}
