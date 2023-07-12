package com.alibaba.security.realidentity.business.upload;

import android.text.TextUtils;
import com.alibaba.security.realidentity.http.AbsHttpResponse;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UploadResultResponse extends AbsHttpResponse {
    public Result result;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Result implements Serializable {
        public String uploadId;
        public UploadStatus uploadStatus;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class UploadStatus implements Serializable {
        public String code;
        public String name;

        public boolean isSuccess() {
            return TextUtils.equals("UPLOAD_STATUS_SUCCESS", this.name);
        }
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        UploadStatus uploadStatus;
        Result result = this.result;
        return (result == null || (uploadStatus = result.uploadStatus) == null || !uploadStatus.isSuccess()) ? false : true;
    }
}
