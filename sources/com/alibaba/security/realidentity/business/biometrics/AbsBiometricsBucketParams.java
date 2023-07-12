package com.alibaba.security.realidentity.business.biometrics;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.ALBiometricsNavigator;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.d.h;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpResponse;
import com.alibaba.security.realidentity.business.start.model.StepItem;
import com.alibaba.security.realidentity.business.start.model.StepType;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AbsBiometricsBucketParams extends BucketParams {
    public ALBiometricsCallBackBean biometricsCallBackBean;
    public ALBiometricsNavigator biometricsNavigator;
    public ALBiometricsResult biometricsResult;
    protected boolean isLimited;
    public boolean isNeedBioResultPage = false;
    protected boolean bCalledFinishSuccessfully = false;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ALBiometricsCallBackBean implements Serializable {
        public int errorCode;
        public String errorMsg;
        public byte[] faceImage;
        public int faceImageHeight;
        public int faceImageWidth;
        public boolean isSuccessful = false;
    }

    public ALBiometricsResult getBiometricsResult() {
        return this.biometricsResult;
    }

    public StepItem getBiometricsStepItem(List<StepItem> list) {
        if (list != null && !list.isEmpty()) {
            for (StepItem stepItem : list) {
                StepType stepType = stepItem.getStepType();
                if (stepType != null && "BIOMETRIC_CHECK".equals(stepType.name)) {
                    return stepItem;
                }
            }
        }
        return null;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return null;
    }

    public boolean isCalledFinishSuccessfully() {
        return this.bCalledFinishSuccessfully;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseBeautySwitch(Map<String, String> map) {
        Map map2;
        if (map == null || map.isEmpty()) {
            return true;
        }
        String str = map.get("rpsdkBiometricsBeautyEffect");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            map2 = (Map) h.a(str, Map.class, false);
        } catch (Exception unused) {
        }
        if (map2 == null || map2.isEmpty() || !map2.containsKey("closeBeautyEffect")) {
            return false;
        }
        return Integer.parseInt(map2.get("closeBeautyEffect").toString()) != 1;
    }

    public String parseBioConfig(List<StepItem> list) {
        StepItem.JsonAssist jsonAssistBean;
        StepItem biometricsStepItem = getBiometricsStepItem(list);
        if (biometricsStepItem == null || (jsonAssistBean = biometricsStepItem.getJsonAssistBean()) == null) {
            return null;
        }
        return jsonAssistBean.getBioColorfulConf();
    }

    public ArrayList<Integer> parseBioSteps(RPBusinessHeadParams rPBusinessHeadParams) {
        StartHttpResponse.StepProperty stepProperty;
        StepItem biometricsStepItem = getBiometricsStepItem(rPBusinessHeadParams.steps);
        if (biometricsStepItem == null) {
            return new ArrayList<>();
        }
        if (biometricsStepItem.getProperties() != null && biometricsStepItem.getProperties().size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (StartHttpResponse.Property property : biometricsStepItem.getProperties()) {
                if (parseColorfulBioSwitch(rPBusinessHeadParams.verifyConf) && (stepProperty = property.property) != null && "BIOMETRIC_COLORFUL".equals(stepProperty.name)) {
                    arrayList.add(2);
                }
                StartHttpResponse.StepProperty stepProperty2 = property.property;
                if (stepProperty2 != null && "Biometric".equals(stepProperty2.name)) {
                    arrayList.add(1);
                }
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseCamera2Config(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("rpCamera2Close");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (Integer.valueOf(str).intValue() != 0) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseCameraPreviewConfig(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("rpCameraPreview");
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                return Integer.valueOf(str).intValue() != 0;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    protected boolean parseColorfulBioSwitch(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        String str = map.get("rpsdkColorfulBioSwitch");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            Map map2 = (Map) h.a(str, Map.class, false);
            if (map2 == null || map2.isEmpty() || !map2.containsKey("isOpen")) {
                return true;
            }
            return Integer.parseInt(map2.get("isOpen").toString()) == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public void riskEvent(Context context, OnRetryListener onRetryListener, String str, String str2, String str3, String str4) {
    }

    public void setAlBiometricsResult(ALBiometricsResult aLBiometricsResult) {
        this.biometricsResult = aLBiometricsResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBiometricsCallBackBean(ALBiometricsCallBackBean aLBiometricsCallBackBean) {
        this.biometricsCallBackBean = aLBiometricsCallBackBean;
    }

    public void setCalledFinishSuccessfully(boolean z) {
        this.bCalledFinishSuccessfully = z;
    }
}
