package com.alibaba.security.realidentity.business.submit;

import com.alibaba.security.realidentity.http.AbsHttpResponse;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SubmitHttpResponse extends AbsHttpResponse {
    public Result result;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AuditStatus implements Serializable {
        public int code;
        public String desc;
        public String name;
        public String subCode;

        public boolean isSuccess() {
            return this.code == 1;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class MaterialDetail implements Serializable {
        public String code;
        public String display;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class RPAuditDetail implements Serializable {
        public List<MaterialDetail> materialDetail;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class RPAuditResult implements Serializable {
        public AuditStatus auditStatus;
        public RPAuditDetail rpAuditDetails;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Result implements Serializable {
        public RPAuditResult rpAuditResult;
    }

    public String getDisplayMsg() {
        RPAuditResult rPAuditResult;
        RPAuditDetail rPAuditDetail;
        List<MaterialDetail> list;
        Result result = this.result;
        if (result == null || (rPAuditResult = result.rpAuditResult) == null || (rPAuditDetail = rPAuditResult.rpAuditDetails) == null || (list = rPAuditDetail.materialDetail) == null || list.size() <= 0) {
            return null;
        }
        return this.result.rpAuditResult.rpAuditDetails.materialDetail.get(0).display;
    }

    public int getStatus() {
        RPAuditResult rPAuditResult;
        AuditStatus auditStatus;
        Result result = this.result;
        if (result == null || (rPAuditResult = result.rpAuditResult) == null || (auditStatus = rPAuditResult.auditStatus) == null) {
            return -10000;
        }
        return auditStatus.code;
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        RPAuditResult rPAuditResult;
        AuditStatus auditStatus;
        Result result = this.result;
        return (result == null || (rPAuditResult = result.rpAuditResult) == null || (auditStatus = rPAuditResult.auditStatus) == null || !auditStatus.isSuccess()) ? false : true;
    }
}
