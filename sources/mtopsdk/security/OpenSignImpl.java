package mtopsdk.security;

import androidx.annotation.NonNull;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.security.ISign;
import mtopsdk.security.util.SecurityUtils;
import mtopsdk.security.util.SignConstants;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OpenSignImpl extends AbstractSignImpl {
    private static final String TAG = "mtopsdk.OpenSignImpl";
    private IUnifiedSecurityComponent mUnifiedSign;
    private SecurityGuardManager sgMgr = null;

    private Map<String, String> convertOpenBaseStrMap(Map<String, String> map, String str) {
        if (map == null || map.size() < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(map.get("api"));
        sb.append("&");
        sb.append(map.get("v"));
        sb.append("&");
        sb.append(SecurityUtils.getMd5(map.get("data")));
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_ACCESS_TOKEN)));
        sb.append("&");
        sb.append(map.get("t"));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("utdid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_PV)));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("x-features")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("ttid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("sid")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get("wua")));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_OPEN_BIZ)));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_MINI_APPKEY)));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_REQ_APPKEY)));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(map.get(XStateConstants.KEY_OPEN_BIZ_DATA)));
        HashMap hashMap = new HashMap(2);
        hashMap.put("INPUT", sb.toString());
        return hashMap;
    }

    private int getMiddleTierEnv() {
        if (getEnv() == EnvModeEnum.PREPARE.getEnvMode()) {
            return 1;
        }
        return (getEnv() == EnvModeEnum.TEST.getEnvMode() || getEnv() == EnvModeEnum.TEST_SANDBOX.getEnvMode()) ? 2 : 0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0057 -> B:39:0x00ad). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007e -> B:39:0x00ad). Please submit an issue!!! */
    private void initMiddleTier(MtopConfig mtopConfig) {
        if (mtopConfig == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, getAuthCode());
            if (this.mUnifiedSign == null) {
                IUnifiedSecurityComponent iUnifiedSecurityComponent = (IUnifiedSecurityComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IUnifiedSecurityComponent.class);
                this.mUnifiedSign = iUnifiedSecurityComponent;
                if (iUnifiedSecurityComponent != null) {
                    iUnifiedSecurityComponent.init(hashMap);
                } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init sign failed");
                }
            }
        } catch (SecException e) {
            TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init middleTier failed with errorCode " + e.getErrorCode() + ",appKeyIndex=" + mtopConfig.appKeyIndex + ",authCode=" + mtopConfig.authCode, e);
        } catch (Exception e2) {
            TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init middleTier failed with unknown exception, appKeyIndex=" + mtopConfig.appKeyIndex + ",authCode=" + mtopConfig.authCode, e2);
        }
        try {
            HashMap hashMap2 = new HashMap();
            boolean z = false;
            try {
                Class.forName("com.ali.auth.third.core.MemberSDK");
                z = true;
            } catch (Throwable unused) {
            }
            hashMap2.put("key_login_module", Boolean.valueOf(z ? z : true));
            IFCComponent iFCComponent = (IFCComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IFCComponent.class);
            if (iFCComponent != null) {
                iFCComponent.setUp(mtopConfig.context, hashMap2);
                mtopConfig.mtopGlobalHeaders.put(SignConstants.BX_VERSION, iFCComponent.getFCPluginVersion());
            }
        } catch (SecException e3) {
            TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init ifcComponent failed with errorCode " + e3.getErrorCode() + ",appKeyIndex=" + mtopConfig.appKeyIndex + ",authCode=" + mtopConfig.authCode, e3);
        } catch (Exception e4) {
            TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init ifcComponent failed with unknown exception, appKeyIndex=" + mtopConfig.appKeyIndex + ",authCode=" + mtopConfig.authCode, e4);
        }
        TBSdkLog.e(TAG, "[initMiddleTier] execute initMiddleTier cost time ", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // mtopsdk.security.ISign
    public String getAppKey(ISign.SignCtx signCtx) {
        String str = null;
        if (signCtx == null) {
            return null;
        }
        String instanceId = getInstanceId();
        try {
            str = this.sgMgr.getStaticDataStoreComp().getAppKeyByIndex(signCtx.index, signCtx.authCode);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, instanceId + " [getAppKey]ISign getAppKey.index=" + signCtx.index + ",authCode=" + signCtx.authCode + ",appKey=" + str);
            }
        } catch (SecException e) {
            TBSdkLog.e(TAG, instanceId + " [getAppKey]ISign getAppKey error.errorCode=" + e.getErrorCode() + ",index=" + signCtx.index + ",authCode=" + signCtx.authCode, e);
        } catch (Exception e2) {
            TBSdkLog.e(TAG, instanceId + " [getAppKey]ISign getAppKey error.index=" + signCtx.index + ",authCode=" + signCtx.authCode, e2);
        }
        return str;
    }

    @Override // mtopsdk.security.ISign
    public String getCommonHmacSha1Sign(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String instanceId = getInstanceId();
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

    @Override // mtopsdk.security.ISign
    public String getMtopApiSign(HashMap<String, String> hashMap, String str, String str2) {
        String instanceId = getInstanceId();
        if (hashMap == null) {
            TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] params is null.appkey=" + str);
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
                Map<String, String> convertOpenBaseStrMap = convertOpenBaseStrMap(hashMap, str);
                convertOpenBaseStrMap.put("ATLAS", "a");
                securityGuardParamContext.paramMap = convertOpenBaseStrMap;
                return this.sgMgr.getSecureSignatureComp().signRequest(securityGuardParamContext, getAuthCode());
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
            return ((ISecurityBodyComponent) this.sgMgr.getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(str, str2, str3, null, i, getEnv());
        } catch (Throwable th) {
            TBSdkLog.e(TAG, getInstanceId() + "[getSecBodyDataEx] ISecurityBodyComponent getSecurityBodyDataEx  error,flag=" + i, th);
            return null;
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z) {
        String instanceId = getInstanceId();
        if (str == null) {
            hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, "AppKey is null");
            TBSdkLog.e(TAG, instanceId + " [getUnifiedSign] AppKey is null.");
            return null;
        } else if (hashMap == null) {
            TBSdkLog.e(TAG, instanceId + " [getUnifiedSign] params is null.appKey=" + str);
            return null;
        } else if (this.mUnifiedSign == null) {
            hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, "unified is null");
            TBSdkLog.e(TAG, instanceId + " [getUnifiedSign]sg unified sign is null, please call ISign init()");
            return null;
        } else {
            try {
                HashMap<String, Object> hashMap3 = new HashMap<>();
                String str3 = convertOpenBaseStrMap(hashMap, str).get("INPUT");
                if (StringUtils.isBlank(str3)) {
                    TBSdkLog.e(TAG, getInstanceId() + " [getUnifiedSign]get sign failed with sign data empty ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
                    return null;
                }
                hashMap3.put("appkey", str);
                hashMap3.put("data", str3);
                hashMap3.put(SignConstants.MIDDLE_PARAM_USE_WUA, Boolean.valueOf(z));
                hashMap3.put("env", Integer.valueOf(getMiddleTierEnv()));
                hashMap3.put(SignConstants.MIDDLE_PARAM_AUTHCODE, str2);
                hashMap3.put(SignConstants.MIDDLE_PARAM_EXT_PARAM, hashMap2);
                hashMap3.put("api", hashMap.get("api"));
                HashMap<String, String> securityFactors = this.mUnifiedSign.getSecurityFactors(hashMap3);
                if (securityFactors != null && !securityFactors.isEmpty()) {
                    return securityFactors;
                }
                TBSdkLog.e(TAG, getInstanceId() + " [getUnifiedSign]get sign failed with no output ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
                return null;
            } catch (SecException e) {
                TBSdkLog.e(TAG, getInstanceId() + " [getUnifiedSign]get sign failed and SecException errorCode " + e.getErrorCode() + ",appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, e);
                return null;
            } catch (Throwable th) {
                TBSdkLog.e(TAG, getInstanceId() + " [getUnifiedSign]get sign failed exception ,appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, th);
                return null;
            }
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public void init(@NonNull MtopConfig mtopConfig) {
        super.init(mtopConfig);
        String instanceId = getInstanceId();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.sgMgr = SecurityGuardManager.getInstance(this.mtopConfig.context);
            initMiddleTier(mtopConfig);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, instanceId + " [init]ISign init succeed.init time=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (SecException e) {
            TBSdkLog.e(TAG, instanceId + " [init]init securityguard error.errorCode=" + e.getErrorCode(), e);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, instanceId + " [init]init securityguard error.", th);
        }
    }
}
