package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UploadFileParams extends AbsUploadFileParams {
    @Override // com.alibaba.security.realidentity.business.upload.AbsUploadFileParams, com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(C3873c c3873c) {
        super.onDelivering(c3873c);
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        if (this.mUploadErrorCode == 0) {
            BucketParams.ErrorCode createAuditPassCode = BucketParams.ErrorCode.createAuditPassCode();
            createAuditPassCode.globalErrorCode = 0;
            createAuditPassCode.errorCode = String.valueOf(0);
            createAuditPassCode.errorMsg = "success";
            return createAuditPassCode;
        }
        BucketParams.ErrorCode createAuditNotCode = BucketParams.ErrorCode.createAuditNotCode();
        createAuditNotCode.globalErrorCode = GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR;
        createAuditNotCode.errorCode = String.valueOf((int) GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR);
        createAuditNotCode.errorMsg = "uploadFile onError";
        return createAuditNotCode;
    }
}
