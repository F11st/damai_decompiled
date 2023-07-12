package com.alibaba.security.realidentity.business.start;

import android.text.TextUtils;
import com.alibaba.security.common.d.h;
import com.alibaba.security.realidentity.business.start.model.StartExtraInfo;
import com.alibaba.security.realidentity.business.start.model.StartStatusResult;
import com.alibaba.security.realidentity.business.start.model.StepItem;
import com.alibaba.security.realidentity.business.start.model.StepType;
import com.alibaba.security.realidentity.http.AbsHttpResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StartHttpResponse extends AbsHttpResponse {
    private ResultBean result;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Property implements Serializable {
        public boolean optional;
        public StepProperty property;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ResultBean implements Serializable {
        private String biz;
        private String bizConf;
        private String extraInfo;
        private String source;
        private List<StepItem> steps;
        private UploadToken uploadToken;
        private Map<String, String> verifyConf;

        public String getBiz() {
            return this.biz;
        }

        public String getBizConf() {
            return this.bizConf;
        }

        public String getExtraInfo() {
            return this.extraInfo;
        }

        public String getSource() {
            return this.source;
        }

        public List<StepItem> getSteps() {
            return this.steps;
        }

        public UploadToken getUploadToken() {
            return this.uploadToken;
        }

        public Map<String, String> getVerifyConf() {
            return this.verifyConf;
        }

        public void setBiz(String str) {
            this.biz = str;
        }

        public void setBizConf(String str) {
            this.bizConf = str;
        }

        public void setExtraInfo(String str) {
            this.extraInfo = str;
        }

        public void setSource(String str) {
            this.source = str;
        }

        public void setSteps(List<StepItem> list) {
            this.steps = list;
        }

        public void setUploadToken(UploadToken uploadToken) {
            this.uploadToken = uploadToken;
        }

        public void setVerifyConf(Map<String, String> map) {
            this.verifyConf = map;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class StepProperty implements Serializable {
        public String code;
        public String name;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class UploadToken implements Serializable {
        private String accessKeyId;
        private String accessKeySecret;
        private String bucketName;
        private String endPoint;
        private String expiration;
        private String path;
        private String token;

        public String getAccessKeyId() {
            return this.accessKeyId;
        }

        public String getAccessKeySecret() {
            return this.accessKeySecret;
        }

        public String getBucketName() {
            return this.bucketName;
        }

        public String getEndPoint() {
            return this.endPoint;
        }

        public String getExpiration() {
            return this.expiration;
        }

        public String getPath() {
            return this.path;
        }

        public String getToken() {
            return this.token;
        }

        public void setAccessKeyId(String str) {
            this.accessKeyId = str;
        }

        public void setAccessKeySecret(String str) {
            this.accessKeySecret = str;
        }

        public void setBucketName(String str) {
            this.bucketName = str;
        }

        public void setEndPoint(String str) {
            this.endPoint = str;
        }

        public void setExpiration(String str) {
            this.expiration = str;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    public StepItem getBiometricsStepItem() {
        ResultBean resultBean = this.result;
        if (resultBean != null && resultBean.steps != null && !this.result.steps.isEmpty()) {
            for (StepItem stepItem : this.result.steps) {
                StepType stepType = stepItem.getStepType();
                if (stepType != null && "BIOMETRIC_CHECK".equals(stepType.name)) {
                    return stepItem;
                }
            }
        }
        return null;
    }

    public StartExtraInfo getExtraInfoBean() {
        ResultBean resultBean = this.result;
        return (StartExtraInfo) h.a(resultBean != null ? resultBean.getExtraInfo() : "", StartExtraInfo.class, false);
    }

    public ResultBean getResult() {
        return this.result;
    }

    public boolean isLimited() {
        return TextUtils.equals(this.retCode, com.alibaba.security.realidentity.a.d);
    }

    public boolean isNeedLogin() {
        return TextUtils.equals(this.retCode, com.alibaba.security.realidentity.a.e);
    }

    public boolean isRepeatedSubmitted() {
        StartExtraInfo extraInfoBean;
        StartStatusResult rpStatusResult;
        StartStatusResult.AuditStatus rpAuditStatus;
        return (this.result == null || (extraInfoBean = getExtraInfoBean()) == null || (rpStatusResult = extraInfoBean.getRpStatusResult()) == null || (rpAuditStatus = rpStatusResult.getRpAuditStatus()) == null || rpAuditStatus.getCode() != 1) ? false : true;
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        ResultBean resultBean;
        return (isRepeatedSubmitted() || (resultBean = this.result) == null || resultBean.steps == null || this.result.steps.isEmpty()) ? false : true;
    }

    public ArrayList<Integer> obtainBioSteps() {
        StepProperty stepProperty;
        StepItem biometricsStepItem = getBiometricsStepItem();
        if (biometricsStepItem == null) {
            return new ArrayList<>();
        }
        if (biometricsStepItem.getProperties() != null && biometricsStepItem.getProperties().size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (Property property : biometricsStepItem.getProperties()) {
                ResultBean resultBean = this.result;
                if (resultBean != null && parseColorfulBioSwitch(resultBean.getVerifyConf()) && (stepProperty = property.property) != null && "BIOMETRIC_COLORFUL".equals(stepProperty.name)) {
                    arrayList.add(2);
                }
                StepProperty stepProperty2 = property.property;
                if (stepProperty2 != null && "Biometric".equals(stepProperty2.name)) {
                    arrayList.add(1);
                }
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public String obtainDazzleConfig() {
        StepItem.JsonAssist jsonAssistBean;
        StepItem biometricsStepItem = getBiometricsStepItem();
        if (biometricsStepItem == null || (jsonAssistBean = biometricsStepItem.getJsonAssistBean()) == null) {
            return null;
        }
        return jsonAssistBean.getBioColorfulConf();
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

    public void setResult(ResultBean resultBean) {
        this.result = resultBean;
    }
}
