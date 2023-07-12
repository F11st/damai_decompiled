package mtopsdk.security;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.avmp.IAVMPGenericComponent;
import com.alibaba.wireless.security.open.middletier.IMiddleTierGenericComponent;
import com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.security.ISign;
import mtopsdk.security.util.SecurityUtils;
import mtopsdk.security.util.SignConstants;
import mtopsdk.security.util.SignStatistics;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InnerSignImpl extends AbstractSignImpl {
    private static final String TAG = "mtopsdk.InnerSignImpl";
    private volatile IAVMPGenericComponent.IAVMPGenericInstance mAVMPInstance;
    private SecurityGuardManager sgMgr = null;
    private IMiddleTierGenericComponent mMiddleTier = null;
    private IUnifiedSecurityComponent mUnifiedSign = null;

    private synchronized String avmpSign(String str) {
        String str2 = null;
        byte[] bArr = new byte[4];
        int i = 0;
        if (str == null) {
            try {
                str = "";
                TBSdkLog.e(TAG, getInstanceId() + " [avmpSign] input is null");
            } catch (Exception e) {
                try {
                    i = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
                    SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_INVOKE_AVMP, String.valueOf(i), "");
                } catch (Throwable unused) {
                }
                TBSdkLog.e(TAG, getInstanceId() + " [avmpSign] call avmpInstance.invokeAVMP error.errorCode=" + i, e);
            }
        }
        MtopConfig mtopConfig = this.mtopConfig;
        IAVMPGenericComponent.IAVMPGenericInstance aVMPInstance = getAVMPInstance(mtopConfig != null ? mtopConfig.context : MtopUtils.getContext());
        if (aVMPInstance == null) {
            return null;
        }
        byte[] bArr2 = (byte[]) aVMPInstance.invokeAVMP("sign", new byte[0].getClass(), 0, str.getBytes(), Integer.valueOf(str.getBytes().length), "", bArr, Integer.valueOf(getEnv()));
        if (bArr2 != null) {
            str2 = new String(bArr2);
        }
        return str2;
    }

    private String getAppKeyByIndex(int i, String str) {
        String instanceId = getInstanceId();
        String str2 = null;
        try {
            str2 = this.sgMgr.getStaticDataStoreComp().getAppKeyByIndex(i, str);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, instanceId + " [getAppKeyByIndex]getAppKeyByIndex  appKey=" + str2 + ",appKeyIndex=" + i + ",authCode=" + str);
            }
        } catch (SecException e) {
            int errorCode = e.getErrorCode();
            SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_GET_APPKEY, String.valueOf(errorCode), "");
            TBSdkLog.e(TAG, instanceId + " [getAppKeyByIndex]getAppKeyByIndex error.errorCode=" + errorCode + ",appKeyIndex=" + i + ",authCode=" + str, e);
        } catch (Exception e2) {
            TBSdkLog.e(TAG, instanceId + " [getAppKeyByIndex]getAppKeyByIndex error.appKeyIndex=" + i + ",authCode=" + str, e2);
        }
        return str2;
    }

    private int getMiddleTierEnv() {
        if (getEnv() == EnvModeEnum.PREPARE.getEnvMode()) {
            return 1;
        }
        return (getEnv() == EnvModeEnum.TEST.getEnvMode() || getEnv() == EnvModeEnum.TEST_SANDBOX.getEnvMode()) ? 2 : 0;
    }

    private void initMiddleTier(MtopConfig mtopConfig) {
        if (mtopConfig == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("auth_code", getAuthCode());
            if (this.mMiddleTier == null) {
                IMiddleTierGenericComponent iMiddleTierGenericComponent = (IMiddleTierGenericComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IMiddleTierGenericComponent.class);
                this.mMiddleTier = iMiddleTierGenericComponent;
                if (iMiddleTierGenericComponent != null && !iMiddleTierGenericComponent.init(hashMap) && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init middle tier failed");
                }
            }
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put(SignConstants.MIDDLE_PARAM_AUTHCODE, getAuthCode());
            if (this.mUnifiedSign == null) {
                IUnifiedSecurityComponent iUnifiedSecurityComponent = (IUnifiedSecurityComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IUnifiedSecurityComponent.class);
                this.mUnifiedSign = iUnifiedSecurityComponent;
                if (iUnifiedSecurityComponent != null) {
                    iUnifiedSecurityComponent.init(hashMap2);
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
            HashMap hashMap3 = new HashMap();
            hashMap3.put("key_login_module", Boolean.valueOf(RemoteLogin.getLogin(mtopConfig.mtopInstance) != null));
            IFCComponent iFCComponent = (IFCComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IFCComponent.class);
            if (iFCComponent != null) {
                iFCComponent.setUp(mtopConfig.context, hashMap3);
                mtopConfig.mtopGlobalHeaders.put(SignConstants.BX_VERSION, iFCComponent.getFCPluginVersion());
            }
        } catch (SecException e3) {
            TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init ifcComponent failed with errorCode " + e3.getErrorCode() + ",appKeyIndex=" + mtopConfig.appKeyIndex + ",authCode=" + mtopConfig.authCode, e3);
        } catch (Exception e4) {
            TBSdkLog.e(TAG, getInstanceId() + " [initMiddleTier]init ifcComponent failed with unknown exception, appKeyIndex=" + mtopConfig.appKeyIndex + ",authCode=" + mtopConfig.authCode, e4);
        }
        TBSdkLog.e(TAG, "[initMiddleTier] execute initMiddleTier cost time ", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void initUmidToken(String str, String str2) {
        final String instanceId = getInstanceId();
        try {
            IUMIDComponent uMIDComp = this.sgMgr.getUMIDComp();
            if (uMIDComp != null) {
                int env = getEnv();
                if (str2 == null) {
                    str2 = "";
                }
                uMIDComp.initUMID(str, env, str2, new IUMIDInitListenerEx() { // from class: mtopsdk.security.InnerSignImpl.2
                    @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
                    public void onUMIDInitFinishedEx(String str3, int i) {
                        if (i == 200) {
                            XState.setValue(instanceId, XStateConstants.KEY_UMID_TOKEN, str3);
                            TBSdkLog.i(InnerSignImpl.TAG, instanceId + " [initUmidToken]IUMIDComponent initUMID succeed,UMID token=" + str3);
                            return;
                        }
                        TBSdkLog.w(InnerSignImpl.TAG, instanceId + " [initUmidToken]IUMIDComponent initUMID error,resultCode :" + i);
                    }
                });
            }
        } catch (SecException e) {
            int errorCode = e.getErrorCode();
            SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_INIT_UMID, String.valueOf(errorCode), "");
            TBSdkLog.e(TAG, instanceId + "[initUmidToken]IUMIDComponent initUMID error,errorCode=" + errorCode, e);
        } catch (Exception e2) {
            TBSdkLog.e(TAG, instanceId + "[initUmidToken]IUMIDComponent initUMID error.", e2);
        }
    }

    public Map<String, String> convertInnerBaseStrMap(Map<String, String> map, String str, boolean z) {
        if (map == null || map.size() < 1) {
            return null;
        }
        String str2 = map.get("extdata");
        String str3 = map.get("x-features");
        String str4 = map.get(XStateConstants.KEY_ROUTER_ID);
        String str5 = map.get(XStateConstants.KEY_PLACE_ID);
        String str6 = map.get(XStateConstants.KEY_OPEN_BIZ);
        String str7 = map.get(XStateConstants.KEY_MINI_APPKEY);
        String str8 = map.get(XStateConstants.KEY_REQ_APPKEY);
        String str9 = map.get(XStateConstants.KEY_ACCESS_TOKEN);
        String str10 = map.get(XStateConstants.KEY_OPEN_BIZ_DATA);
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
        if (z) {
            sb.append(SecurityUtils.convertNull2Default(str2));
            sb.append("&");
        } else if (StringUtils.isNotBlank(str2)) {
            sb.append(str2);
            sb.append("&");
        }
        sb.append(str3);
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str4));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str5));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str6));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str7));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str8));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str9));
        sb.append("&");
        sb.append(SecurityUtils.convertNull2Default(str10));
        HashMap hashMap = new HashMap(2);
        hashMap.put("INPUT", sb.toString());
        return hashMap;
    }

    IAVMPGenericComponent.IAVMPGenericInstance getAVMPInstance(@NonNull Context context) {
        if (this.mAVMPInstance == null) {
            synchronized (InnerSignImpl.class) {
                if (this.mAVMPInstance == null) {
                    try {
                        this.mAVMPInstance = ((IAVMPGenericComponent) SecurityGuardManager.getInstance(context).getInterface(IAVMPGenericComponent.class)).createAVMPInstance("mwua", "sgcipher");
                        if (this.mAVMPInstance == null) {
                            TBSdkLog.e(TAG, getInstanceId() + " [getAVMPInstance] call createAVMPInstance return null.");
                        }
                    } catch (SecException e) {
                        int errorCode = e.getErrorCode();
                        SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_AVMP_INSTANCE, String.valueOf(errorCode), "");
                        TBSdkLog.e(TAG, getInstanceId() + " [getAVMPInstance] call createAVMPInstance error,errorCode=" + errorCode, e);
                    } catch (Exception e2) {
                        TBSdkLog.e(TAG, getInstanceId() + " [getAVMPInstance] call createAVMPInstance error.", e2);
                    }
                }
            }
        }
        return this.mAVMPInstance;
    }

    @Override // mtopsdk.security.ISign
    public String getAppKey(ISign.SignCtx signCtx) {
        if (signCtx == null) {
            return null;
        }
        return getAppKeyByIndex(signCtx.index, signCtx.authCode);
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public String getAvmpSign(String str, String str2, int i) {
        String avmpSign = avmpSign(str);
        if (StringUtils.isBlank(avmpSign)) {
            TBSdkLog.e(TAG, getInstanceId() + " [getAvmpSign] call avmpSign return null.degrade call getSecBodyDataEx ");
            return getSecBodyDataEx("", "", str2, null, i);
        }
        return avmpSign;
    }

    @Override // mtopsdk.security.ISign
    public String getCommonHmacSha1Sign(String str, String str2) {
        String instanceId = getInstanceId();
        if (str == null || str2 == null) {
            return null;
        }
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
        } catch (SecException e) {
            int errorCode = e.getErrorCode();
            SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_SIGN_HMAC_SHA1, String.valueOf(errorCode), "");
            TBSdkLog.e(TAG, instanceId + " [getCommonHmacSha1Sign] ISecureSignatureComponent signRequest error,errorCode=" + errorCode, e);
            return null;
        } catch (Exception e2) {
            TBSdkLog.e(TAG, instanceId + " [getCommonHmacSha1Sign] ISecureSignatureComponent signRequest error", e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.HashMap<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.HashMap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.alibaba.wireless.security.open.middletier.IMiddleTierGenericComponent] */
    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public String getMiniWua(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        String str = "";
        try {
            if (this.mMiddleTier == null) {
                TBSdkLog.e(TAG, getInstanceId() + " [getMiniWua]middleTier ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
                return "";
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("env", Integer.valueOf(getMiddleTierEnv()));
            HashMap<String, String> hashMap4 = hashMap2;
            if (hashMap2 == null) {
                hashMap4 = new HashMap<>();
            }
            hashMap4.put("api_name", hashMap.get("api"));
            hashMap3.put(SignConstants.MIDDLE_PARAM_EXT, hashMap4);
            HashMap<String, String> miniWua = this.mMiddleTier.getMiniWua(hashMap3);
            if (miniWua != null && !miniWua.isEmpty()) {
                String remove = miniWua.remove(SignConstants.MIDDLE_OUTPUT_X_MINI_WUA);
                try {
                    if (StringUtils.isNotBlank(remove)) {
                        hashMap.putAll(miniWua);
                        return remove;
                    }
                    return remove;
                } catch (SecException e) {
                    e = e;
                    str = remove;
                    TBSdkLog.e(TAG, getInstanceId() + " [getMiniWua]get miniwua failed and SecException errorCode " + e.getErrorCode() + ",appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, e);
                    return str;
                }
            }
            TBSdkLog.e(TAG, getInstanceId() + " [getMiniWua]get miniwua failed with no output ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
            return "";
        } catch (SecException e2) {
            e = e2;
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
        } else if (this.sgMgr == null) {
            hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, "SGManager is null");
            TBSdkLog.e(TAG, instanceId + " [getMtopApiSign]SecurityGuardManager is null,please call ISign init()");
            return null;
        } else {
            try {
                r1 = (SwitchConfig.getInstance().getUseSecurityAdapter() & 1) == 1 ? getSign(hashMap, str) : null;
                if (StringUtils.isBlank(r1)) {
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = str;
                    securityGuardParamContext.requestType = 7;
                    Map<String, String> convertInnerBaseStrMap = convertInnerBaseStrMap(hashMap, str, false);
                    if (convertInnerBaseStrMap != null && 2 == getEnv()) {
                        convertInnerBaseStrMap.put("ATLAS", "daily");
                    }
                    securityGuardParamContext.paramMap = convertInnerBaseStrMap;
                    return this.sgMgr.getSecureSignatureComp().signRequest(securityGuardParamContext, str2);
                }
                return r1;
            } catch (SecException e) {
                int errorCode = e.getErrorCode();
                SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_SIGN_MTOP_REQUEST, String.valueOf(errorCode), "");
                hashMap.put(XStateConstants.KEY_SG_ERROR_CODE, String.valueOf(errorCode));
                TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] ISecureSignatureComponent signRequest error,errorCode=" + errorCode, e);
                return r1;
            } catch (Exception e2) {
                TBSdkLog.e(TAG, instanceId + " [getMtopApiSign] ISecureSignatureComponent signRequest error", e2);
                return r1;
            }
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i) {
        try {
            return ((ISecurityBodyComponent) this.sgMgr.getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(str, str2, str3, hashMap, i, getEnv());
        } catch (SecException e) {
            SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_GET_SECBODY, String.valueOf(e.getErrorCode()), String.valueOf(i));
            TBSdkLog.e(TAG, getInstanceId() + " [getSecBodyDataEx] ISecurityBodyComponent getSecurityBodyDataEx  error.errorCode=" + e.getErrorCode() + ", flag=" + i, e);
            return null;
        } catch (Exception e2) {
            TBSdkLog.e(TAG, getInstanceId() + " [getSecBodyDataEx] ISecurityBodyComponent getSecurityBodyDataEx  error,flag=" + i, e2);
            return null;
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public String getSign(HashMap<String, String> hashMap, String str) {
        String str2 = "";
        String str3 = convertInnerBaseStrMap(hashMap, str, false).get("INPUT");
        try {
            if (this.mMiddleTier != null && !StringUtils.isBlank(str3)) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("data", str3.getBytes("UTF-8"));
                hashMap2.put("env", Integer.valueOf(getMiddleTierEnv()));
                hashMap2.put("appkey", str);
                HashMap<String, String> sign = this.mMiddleTier.getSign(hashMap2);
                if (sign != null && !sign.isEmpty()) {
                    String remove = sign.remove("x-sign");
                    try {
                        if (StringUtils.isNotBlank(remove)) {
                            hashMap.putAll(sign);
                            return remove;
                        }
                        return remove;
                    } catch (SecException e) {
                        e = e;
                        str2 = remove;
                        TBSdkLog.e(TAG, getInstanceId() + " [getSign]get sign failed and SecException errorCode " + e.getErrorCode() + ",appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, e);
                        return str2;
                    } catch (UnsupportedEncodingException e2) {
                        e = e2;
                        str2 = remove;
                        TBSdkLog.e(TAG, getInstanceId() + " [getSign]your input data transfer to byte utf-8 failed ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, e);
                        return str2;
                    }
                }
                TBSdkLog.e(TAG, getInstanceId() + " [getSign]get sign failed with no output ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
                return "";
            }
            TBSdkLog.e(TAG, getInstanceId() + " [getSign]middleTier null or data data ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
            return "";
        } catch (SecException e3) {
            e = e3;
        } catch (UnsupportedEncodingException e4) {
            e = e4;
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
                String str3 = convertInnerBaseStrMap(hashMap, str, true).get("INPUT");
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
    public String getWua(HashMap<String, String> hashMap, String str) {
        String str2 = "";
        String str3 = hashMap.get("sign");
        try {
            if (this.mMiddleTier != null && !StringUtils.isBlank(str3)) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("data", str3.getBytes("UTF-8"));
                hashMap2.put("env", Integer.valueOf(getMiddleTierEnv()));
                HashMap<String, String> wua = this.mMiddleTier.getWua(hashMap2);
                if (wua != null && !wua.isEmpty()) {
                    String remove = wua.remove("wua");
                    try {
                        if (StringUtils.isNotBlank(remove)) {
                            hashMap.putAll(wua);
                            return remove;
                        }
                        return remove;
                    } catch (SecException e) {
                        e = e;
                        str2 = remove;
                        TBSdkLog.e(TAG, getInstanceId() + " [getWua]get wua failed and SecException errorCode " + e.getErrorCode() + ",appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, e);
                        return str2;
                    } catch (UnsupportedEncodingException e2) {
                        e = e2;
                        str2 = remove;
                        TBSdkLog.e(TAG, getInstanceId() + " [getWua]your input data transfer to byte utf-8 failed ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode, e);
                        return str2;
                    }
                }
                TBSdkLog.e(TAG, getInstanceId() + " [getWua]get wua failed with no output ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
                return "";
            }
            TBSdkLog.e(TAG, getInstanceId() + " [getWua]middleTier null or data data ", "appKeyIndex=" + this.mtopConfig.appKeyIndex + ",authCode=" + this.mtopConfig.authCode);
            return "";
        } catch (SecException e3) {
            e = e3;
        } catch (UnsupportedEncodingException e4) {
            e = e4;
        }
    }

    @Override // mtopsdk.security.AbstractSignImpl, mtopsdk.security.ISign
    public void init(@NonNull MtopConfig mtopConfig) {
        super.init(mtopConfig);
        final String instanceId = getInstanceId();
        try {
            SignStatistics.setIUploadStats(mtopConfig.uploadStats);
            long currentTimeMillis = System.currentTimeMillis();
            this.sgMgr = SecurityGuardManager.getInstance(this.mtopConfig.context);
            initUmidToken(StringUtils.isEmpty(mtopConfig.appKey) ? getAppKeyByIndex(mtopConfig.appKeyIndex, getAuthCode()) : mtopConfig.appKey, getAuthCode());
            final Context context = this.mtopConfig.context;
            MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.security.InnerSignImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InnerSignImpl.this.getAVMPInstance(context);
                    } catch (Throwable th) {
                        TBSdkLog.e(InnerSignImpl.TAG, instanceId + " [init]getAVMPInstance error when async init AVMP.", th);
                    }
                }
            });
            initMiddleTier(mtopConfig);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, instanceId + " [init]ISign init SecurityGuard succeed.init time=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (SecException e) {
            int errorCode = e.getErrorCode();
            SignStatistics.commitStats(SignStatistics.SignStatsType.TYPE_SG_MANAGER, String.valueOf(errorCode), "");
            TBSdkLog.e(TAG, instanceId + " [init]ISign init SecurityGuard error.errorCode=" + errorCode, e);
        } catch (Exception e2) {
            TBSdkLog.e(TAG, instanceId + " [init]ISign init SecurityGuard error.", e2);
        }
    }
}
