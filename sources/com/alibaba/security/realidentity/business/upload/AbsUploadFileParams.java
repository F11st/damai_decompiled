package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.realidentity.business.bucket.BucketParams;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AbsUploadFileParams extends BucketParams {
    protected int mUploadErrorCode;
    private List<e> uploadTaskList;

    public List<e> getUploadTaskList() {
        return this.uploadTaskList;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(com.alibaba.security.realidentity.business.c cVar) {
        return true;
    }

    public void setUploadErrorCode(int i) {
        this.mUploadErrorCode = i;
    }

    public void setUploadTaskList(List<e> list) {
        this.uploadTaskList = list;
    }
}
