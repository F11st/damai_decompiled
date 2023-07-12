package com.alibaba.security.realidentity.business.start;

import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.model.StartExtraInfo;
import com.alibaba.security.realidentity.business.start.model.StepItem;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StartHttpParams extends AbsStartHttpParams {
    public StartHttpResponse mStartHttpResponse;
    private SensorInfo sensorInfo;

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        StartHttpRequest startHttpRequest = new StartHttpRequest(this.mVerifyToken);
        if (this.sensorInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(AbstractC3893a.ae, this.sensorInfo);
            startHttpRequest.setExtendMap(C3811h.a((Object) hashMap));
        }
        return new BusinessHttpWrapper(StartHttpResponse.class, new BusinessRequest(StartHttpRequest.class, startHttpRequest));
    }

    public SensorInfo getSensorInfo() {
        return this.sensorInfo;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(C3873c c3873c) {
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        StartHttpResponse startHttpResponse = this.mStartHttpResponse;
        if (startHttpResponse == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "start api fail", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (startHttpResponse.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "success", 0);
        }
        if (this.mStartHttpResponse.isRepeatedSubmitted()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "the verification has passed", 0);
        }
        if (!TextUtils.isEmpty(this.mStartHttpResponse.getRetCode())) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", this.mStartHttpResponse.getRetMsg(), GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        String str = this.mStartHttpResponse.Code;
        if (!TextUtils.isEmpty(str) && str.equals("InvalidTimeStamp.Expired")) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10413", "invalid_timestamp_expired", GlobalErrorCode.ERROR_INVALID_TIMESTAMP_EXPIRED);
        }
        return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", C3811h.a(this.mStartHttpResponse), GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
    }

    public void setSensorInfo(SensorInfo sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    @Override // com.alibaba.security.realidentity.business.start.AbsStartHttpParams, com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public StartHttpParams doTransform(HttpResponse httpResponse) {
        StepItem.JsonAssist jsonAssistBean;
        if (httpResponse instanceof StartHttpResponse) {
            StartHttpResponse startHttpResponse = (StartHttpResponse) httpResponse;
            this.mStartHttpResponse = startHttpResponse;
            StepItem biometricsStepItem = startHttpResponse.getBiometricsStepItem();
            if (biometricsStepItem != null && (jsonAssistBean = biometricsStepItem.getJsonAssistBean()) != null) {
                this.mNeedActionImage = jsonAssistBean.isNeedActionImage();
                this.mOnlyGaze = jsonAssistBean.isOnlyGaze();
                this.mShowNav = jsonAssistBean.isShowNav();
                this.mNeedGaze = jsonAssistBean.isNeedGaze();
                this.mNeedOriginalImage = jsonAssistBean.isNeedOriginalImage();
            }
            this.mVerifyDowngradConfig = startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf();
            this.mBizConf = startHttpResponse.getResult() != null ? startHttpResponse.getResult().getBizConf() : null;
            StartExtraInfo extraInfoBean = startHttpResponse.getExtraInfoBean();
            if (extraInfoBean != null) {
                this.mLivenessConfig = extraInfoBean.livenessConfig;
            }
            RPConfig b = C3847g.C3848a.a.b();
            if (b != null && b.getBiometricsConfig() != null) {
                this.mShowResult = b.getBiometricsConfig().isNeedFailResultPage();
            }
        }
        return this;
    }
}
