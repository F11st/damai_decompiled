package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AbsUploadFileParams extends BucketParams {
    protected int mUploadErrorCode;
    private List<AsyncTaskC3885e> uploadTaskList;

    public List<AsyncTaskC3885e> getUploadTaskList() {
        return this.uploadTaskList;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(C3873c c3873c) {
        return true;
    }

    public void setUploadErrorCode(int i) {
        this.mUploadErrorCode = i;
    }

    public void setUploadTaskList(List<AsyncTaskC3885e> list) {
        this.uploadTaskList = list;
    }
}
