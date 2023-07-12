package com.alibaba.security.realidentity.business.biometrics;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.C3839a;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.a.AbstractC3841b;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.model.RiskActionMaterial;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.dynamic.model.ScConfig;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.start.StartHttpResponse;
import com.alibaba.security.realidentity.business.start.model.StartExtraInfo;
import com.alibaba.security.realidentity.business.start.model.StepItem;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BiometricsBucketParams extends AbsBiometricsBucketParams {
    private static final String TAG = BiometricsBucketParams.class.getSimpleName();
    private final ThreadPoolExecutor mExecutorService;
    private Bundle params = new Bundle();
    private StartHttpParams startHttpParams = null;
    private boolean sessionless = false;
    private final HandlerC3868a mUiHandler = new HandlerC3868a(this);

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams$a */
    /* loaded from: classes8.dex */
    static class HandlerC3868a extends Handler {
        private final BiometricsBucketParams a;

        public HandlerC3868a(BiometricsBucketParams biometricsBucketParams) {
            super(Looper.getMainLooper());
            this.a = biometricsBucketParams;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
        }
    }

    public BiometricsBucketParams() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "tbrpsdk-biometrics");
            }
        });
        this.mExecutorService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void assemable(RPBusinessHeadParams rPBusinessHeadParams) {
        if (rPBusinessHeadParams == null) {
            return;
        }
        Bundle bundle = new Bundle();
        this.params = bundle;
        bundle.putString(ALBiometricsKeys.KEY_SEC_TOKEN, this.mVerifyToken);
        this.params.putBoolean(ALBiometricsKeys.KEY_SESSION_LESS, rPBusinessHeadParams.sessionless);
        this.params.putBoolean(ALBiometricsKeys.KEY_NEED_ORIGINAL_IMAGE, rPBusinessHeadParams.needOriginalImage);
        if (!TextUtils.isEmpty(rPBusinessHeadParams.userName)) {
            this.params.putString(ALBiometricsKeys.KEY_USERNAME, rPBusinessHeadParams.userName);
        }
        List<Integer> list = rPBusinessHeadParams.bioStepsEx;
        if (list != null) {
            this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, list.size());
            if (list.size() > 0) {
                int[] iArr = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    iArr[i] = list.get(i).intValue();
                }
                this.params.putIntArray("strategy", iArr);
            }
        }
        String str = C3811h.a(rPBusinessHeadParams.livenessConfig) ? rPBusinessHeadParams.livenessConfig : null;
        if (!TextUtils.isEmpty(str)) {
            this.params.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, str);
        }
        this.params.putString(ALBiometricsKeys.KEY_VERIFY_TOKEN, this.mVerifyToken);
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, rPBusinessHeadParams.showNav);
        this.params.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, rPBusinessHeadParams.needGaze);
        this.params.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
        this.params.putBoolean("needSuccessVideo", rPBusinessHeadParams.needSuccessVideo);
        this.params.putBoolean("needFailVideo", rPBusinessHeadParams.needFailVideo);
        this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA2_OPEN, parseCamera2Config(rPBusinessHeadParams.verifyConf));
        this.params.putString(ALBiometricsKeys.KEY_BIZ_CONF, parseBioConfig(rPBusinessHeadParams.steps));
        this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA_PREVIEW_SWITCH, parseCameraPreviewConfig(rPBusinessHeadParams.verifyConf));
        this.params.putIntegerArrayList(ALBiometricsKeys.KEY_BIO_STEPS, parseBioSteps(rPBusinessHeadParams));
        this.params.putBoolean(ALBiometricsKeys.KEY_BEAUTY_SWITCH, parseBeautySwitch(rPBusinessHeadParams.verifyConf));
        ScConfig scConfig = rPBusinessHeadParams.getScConfig();
        if (scConfig != null) {
            try {
                this.params.putBoolean(ALBiometricsKeys.KEY_DATA_COLLECT_SWITCH, Boolean.parseBoolean(scConfig.getNeedCollect()));
                this.params.putString(ALBiometricsKeys.KEY_DATA_COLLECT_ENABLED_SENSORS, scConfig.getEnableSensors());
                this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_INTERVAL, Integer.parseInt(scConfig.getInterval()));
                this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_CLICK_COUNT, Integer.parseInt(scConfig.getMaxClickCnt()));
                this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_SENSOR_COUNT, Integer.parseInt(scConfig.getClickSensorCnt()));
            } catch (Exception unused) {
                C3800a.b();
            }
        }
        if (rPBusinessHeadParams.onlyGaze) {
            this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, 0);
            this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, true);
        }
    }

    private AbsBiometricsBucketParams.ALBiometricsCallBackBean onLivenessDetectFailed(ALBiometricsResult aLBiometricsResult) {
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
        if (this.isLimited) {
            aLBiometricsCallBackBean.errorCode = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
            aLBiometricsCallBackBean.isSuccessful = true;
            return aLBiometricsCallBackBean;
        }
        if (aLBiometricsResult != null) {
            int r = aLBiometricsResult.getR();
            if (r == -1) {
                aLBiometricsCallBackBean.errorCode = 4;
                return aLBiometricsCallBackBean;
            } else if (r == -10405) {
                aLBiometricsCallBackBean.errorCode = 5;
            } else if (r != -10102 && r != -10103) {
                aLBiometricsCallBackBean.errorCode = 2;
            } else {
                aLBiometricsCallBackBean.errorCode = 6;
            }
        } else {
            aLBiometricsCallBackBean.errorCode = 2;
        }
        aLBiometricsCallBackBean.isSuccessful = false;
        return aLBiometricsCallBackBean;
    }

    private AbsBiometricsBucketParams.ALBiometricsCallBackBean onLivenessDetectSuccess(Context context, ALBiometricsResult aLBiometricsResult) {
        if (aLBiometricsResult != null && aLBiometricsResult.getQi() != null) {
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            aLBiometricsCallBackBean.errorCode = 0;
            aLBiometricsCallBackBean.isSuccessful = true;
            return aLBiometricsCallBackBean;
        }
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean2 = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
        aLBiometricsCallBackBean2.errorCode = 2;
        aLBiometricsCallBackBean2.errorMsg = "验证不通过，请按提示做动作";
        aLBiometricsCallBackBean2.isSuccessful = false;
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", 2);
        hashMap.put("errorMsg", "验证不通过，请按提示做动作");
        AbstractC3841b.a().a(0, AbstractC3840a.F, "livenessFailed", hashMap);
        return aLBiometricsCallBackBean2;
    }

    private void reportEvent(final Context context, final OnRetryListener onRetryListener, final String str, final String str2, final String str3, final String str4) {
        this.mExecutorService.execute(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.2
            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(AbstractC3893a.d, BiometricsBucketParams.this.mVerifyToken);
                hashMap.put("eventCode", str4);
                hashMap.put("name", str);
                RiskActionMaterial riskActionMaterial = new RiskActionMaterial();
                riskActionMaterial.flActionLog = str2;
                riskActionMaterial.sensorActionLog = str3;
                hashMap.put("eventData", C3811h.a(riskActionMaterial));
                BiometricsBucketParams.this.trackRiskStart(str2, str3, str4);
                BiometricsBucketParams biometricsBucketParams = BiometricsBucketParams.this;
                biometricsBucketParams.isLimited = biometricsBucketParams.verifyLimitedEvent(context, hashMap);
                BiometricsBucketParams.this.mUiHandler.post(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        OnRetryListener onRetryListener2 = onRetryListener;
                        if (onRetryListener2 != null) {
                            onRetryListener2.onRetry(!BiometricsBucketParams.this.isLimited ? 1 : 0);
                        }
                    }
                });
            }
        });
    }

    private void trackRiskEnd(int i, boolean z, String str, String str2) {
        TrackLog createRiskEndLog = TrackLog.createRiskEndLog(i, z, str, str2);
        createRiskEndLog.setVerifyToken(this.mVerifyToken);
        createRiskEndLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createRiskEndLog.addTag10("Android");
        C3829a.C3830a.a.a(createRiskEndLog);
        C3829a.C3830a.a.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackRiskStart(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add("flActionLog");
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add("sensorActionLog");
        }
        TrackLog createRiskStartLog = TrackLog.createRiskStartLog(this.sessionless, arrayList, str3);
        createRiskStartLog.setVerifyToken(this.mVerifyToken);
        createRiskStartLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createRiskStartLog.addTag10("Android");
        C3829a.C3830a.a.a(createRiskStartLog);
        C3829a.C3830a.a.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean verifyLimitedEvent(Context context, Map<String, String> map) {
        JSONObject jSONObject;
        String str = this.sessionless ? C3839a.b : C3839a.a;
        if (context == null) {
            return false;
        }
        MtopResponse callMtopSync = RpcInvoker.callMtopSync(context, str, "1.0", true, map);
        if (callMtopSync == null) {
            trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, "-10300", "Null response");
            return false;
        } else if (!callMtopSync.isApiSuccess()) {
            trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
            return false;
        } else {
            JSONObject dataJsonObject = callMtopSync.getDataJsonObject();
            if (dataJsonObject == null) {
                trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
                return false;
            }
            try {
                jSONObject = dataJsonObject.getJSONObject("result");
            } catch (JSONException unused) {
            }
            if (jSONObject == null) {
                trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
                return false;
            }
            trackRiskEnd(0, false, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
            return !jSONObject.optBoolean("verifyLimitedFlag", true);
        }
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean finishTask(Context context, boolean z, BucketParams.InterfaceC3872a interfaceC3872a, Object... objArr) {
        if (z) {
            onLivenessDetectSuccess(context, this.biometricsResult);
            return true;
        }
        onLivenessDetectFailed(this.biometricsResult);
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public Bundle getBundle() {
        return this.params;
    }

    public StartHttpParams getStartHttpParams() {
        return this.startHttpParams;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(C3873c c3873c) {
        StartHttpParams startHttpParams = c3873c.c;
        if (startHttpParams != null) {
            this.startHttpParams = startHttpParams;
            BusinessHeadParams businessHeadParams = c3873c.b;
            assemable(startHttpParams.mStartHttpResponse, businessHeadParams == null ? -2 : businessHeadParams.getCtidCode(), this.startHttpParams.mShowResult, businessHeadParams.getScConfig());
            return true;
        }
        BusinessHeadParams businessHeadParams2 = c3873c.b;
        if (businessHeadParams2 != null) {
            StartHttpParams startHttpParams2 = new StartHttpParams();
            RPBusinessHeadParams rPBusinessHeadParams = (RPBusinessHeadParams) businessHeadParams2;
            this.sessionless = rPBusinessHeadParams.sessionless;
            startHttpParams2.mNeedActionImage = rPBusinessHeadParams.needActionImage;
            startHttpParams2.mNeedGaze = rPBusinessHeadParams.needGaze;
            startHttpParams2.mVerifyDowngradConfig = rPBusinessHeadParams.verifyConf;
            startHttpParams2.mBizConf = rPBusinessHeadParams.bizConf;
            List<Integer> list = rPBusinessHeadParams.bioStepsEx;
            if (list != null) {
                startHttpParams2.mActionCount = list.size();
            }
            startHttpParams2.mLivenessConfig = rPBusinessHeadParams.livenessConfig;
            startHttpParams2.mShowNav = rPBusinessHeadParams.showNav;
            startHttpParams2.mNeedOriginalImage = rPBusinessHeadParams.needOriginalImage;
            new StepItem.JsonAssist().setBioStepsEx(rPBusinessHeadParams.bioStepsEx);
            c3873c.c = startHttpParams2;
            assemable(rPBusinessHeadParams);
        }
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        if (this.isSuccessful) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "bio success", 0);
        }
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = this.biometricsCallBackBean;
        if (aLBiometricsCallBackBean == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10000", "biometrics bean is null", -10000);
        }
        RPResult rPResult = RPResult.AUDIT_NOT;
        String valueOf = String.valueOf(aLBiometricsCallBackBean.errorCode);
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean2 = this.biometricsCallBackBean;
        return new BucketParams.ErrorCode(rPResult, valueOf, aLBiometricsCallBackBean2.errorMsg, aLBiometricsCallBackBean2.errorCode);
    }

    @Override // com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams
    public void riskEvent(Context context, OnRetryListener onRetryListener, String str, String str2, String str3, String str4) {
        super.riskEvent(context, onRetryListener, str, str2, str3, str4);
        reportEvent(context, onRetryListener, str3, str, str2, str4);
    }

    private void assemable(StartHttpResponse startHttpResponse, int i, boolean z, ScConfig scConfig) {
        StartExtraInfo.IdentityInfo identityInfo;
        if (startHttpResponse == null) {
            return;
        }
        StartExtraInfo extraInfoBean = startHttpResponse.getExtraInfoBean();
        StepItem biometricsStepItem = startHttpResponse.getBiometricsStepItem();
        if (biometricsStepItem == null) {
            return;
        }
        this.params = new Bundle();
        if (startHttpResponse.isLimited()) {
            this.params.putBoolean(ALBiometricsKeys.KEY_REACH_BUSINESS_RETRY_LIMITED, true);
        }
        this.params.putString(ALBiometricsKeys.KEY_SEC_TOKEN, this.mVerifyToken);
        if (extraInfoBean != null && (identityInfo = extraInfoBean.identityInfo) != null && !TextUtils.isEmpty(identityInfo.name)) {
            this.params.putString(ALBiometricsKeys.KEY_USERNAME, extraInfoBean.identityInfo.name);
        }
        this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA2_OPEN, parseCamera2Config(startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf()));
        this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA_PREVIEW_SWITCH, parseCameraPreviewConfig(startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf()));
        this.params.putIntegerArrayList(ALBiometricsKeys.KEY_BIO_STEPS, startHttpResponse.obtainBioSteps());
        this.params.putBoolean(ALBiometricsKeys.KEY_BEAUTY_SWITCH, parseBeautySwitch(startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf()));
        this.params.putString(ALBiometricsKeys.KEY_BIZ_CONF, startHttpResponse.obtainDazzleConfig());
        this.params.putString(ALBiometricsKeys.KEY_VERIFY_TOKEN, this.mVerifyToken);
        this.params.putInt(ALBiometricsKeys.KEY_CTID_RESULT_CODE, i);
        if (scConfig != null) {
            try {
                this.params.putBoolean(ALBiometricsKeys.KEY_DATA_COLLECT_SWITCH, Boolean.parseBoolean(scConfig.getNeedCollect()));
                this.params.putString(ALBiometricsKeys.KEY_DATA_COLLECT_ENABLED_SENSORS, scConfig.getEnableSensors());
                this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_INTERVAL, Integer.parseInt(scConfig.getInterval()));
                this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_CLICK_COUNT, Integer.parseInt(scConfig.getMaxClickCnt()));
                this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_SENSOR_COUNT, Integer.parseInt(scConfig.getClickSensorCnt()));
            } catch (Exception unused) {
                C3800a.b();
            }
        }
        StepItem.JsonAssist jsonAssistBean = biometricsStepItem.getJsonAssistBean();
        List<Integer> bioStepsEx = jsonAssistBean.getBioStepsEx();
        if (bioStepsEx != null) {
            this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, bioStepsEx.size());
            if (bioStepsEx.size() > 0) {
                int[] iArr = new int[bioStepsEx.size()];
                for (int i2 = 0; i2 < bioStepsEx.size(); i2++) {
                    iArr[i2] = bioStepsEx.get(i2).intValue();
                }
                this.params.putIntArray("strategy", iArr);
            }
        }
        String livenessConfig = C3811h.a(jsonAssistBean.getLivenessConfig()) ? jsonAssistBean.getLivenessConfig() : null;
        if (!TextUtils.isEmpty(livenessConfig)) {
            this.params.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, livenessConfig);
        }
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, jsonAssistBean.isShowNav());
        this.params.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, jsonAssistBean.isNeedGaze());
        this.params.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
        this.params.putBoolean("needSuccessVideo", jsonAssistBean.isNeedSuccessVideo());
        this.params.putBoolean("needFailVideo", jsonAssistBean.isNeedFailVideo());
        this.params.putBoolean(ALBiometricsKeys.KEY_NEED_ORIGINAL_IMAGE, jsonAssistBean.isNeedOriginalImage());
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_RESULT, z);
        if (jsonAssistBean.isOnlyGaze()) {
            this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, 0);
            this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, true);
        }
    }
}
