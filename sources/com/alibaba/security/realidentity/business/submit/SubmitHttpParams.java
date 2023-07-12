package com.alibaba.security.realidentity.business.submit;

import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SubmitHttpParams extends AbsSubmitHttpParams {
    private SubmitHttpResponse submitHttpResponse;

    private BusinessRequest assemable() {
        SubmitHttpRequest submitHttpRequest = new SubmitHttpRequest();
        submitHttpRequest.verifyToken = this.mVerifyToken;
        return new BusinessRequest(SubmitHttpRequest.class, submitHttpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        if (httpResponse instanceof SubmitHttpResponse) {
            this.submitHttpResponse = (SubmitHttpResponse) httpResponse;
        }
        return this;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return new BusinessHttpWrapper(SubmitHttpResponse.class, assemable());
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(C3873c c3873c) {
        return false;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        SubmitHttpResponse submitHttpResponse = this.submitHttpResponse;
        if (submitHttpResponse == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "submit fail by response is null", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (submitHttpResponse.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "submit result success", 0);
        }
        int status = this.submitHttpResponse.getStatus();
        if (status == 0) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_IN_AUDIT, String.valueOf(status), C3811h.a(this.submitHttpResponse), GlobalErrorCode.ERROR_VERIFY_BIO_DATA);
        }
        if (status == 2) {
            try {
                return new BucketParams.ErrorCode(RPResult.AUDIT_FAIL, String.valueOf(status), this.submitHttpResponse.getDisplayMsg(), Integer.parseInt(this.submitHttpResponse.result.rpAuditResult.auditStatus.subCode));
            } catch (Exception unused) {
                return new BucketParams.ErrorCode(RPResult.AUDIT_FAIL, String.valueOf(status), this.submitHttpResponse.getDisplayMsg(), status);
            }
        } else if (!TextUtils.isEmpty(this.submitHttpResponse.getRetCode())) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10302", this.submitHttpResponse.getRetMsg(), GlobalErrorCode.ERROR_VERIFY_BIO_DATA);
        } else {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10302", C3811h.a(this.submitHttpResponse), GlobalErrorCode.ERROR_VERIFY_BIO_DATA);
        }
    }
}
