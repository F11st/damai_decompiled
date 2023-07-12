package com.alibaba.security.realidentity.business.start.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StartStatusResult implements Serializable {
    private String biz;
    private boolean gradeCertified;
    private boolean reviewStatus;
    private AuditStatus rpAuditStatus;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AuditStatus implements Serializable {
        private int code;
        private String desc;
        private String name;

        public int getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public String getBiz() {
        return this.biz;
    }

    public AuditStatus getRpAuditStatus() {
        return this.rpAuditStatus;
    }

    public boolean isGradeCertified() {
        return this.gradeCertified;
    }

    public boolean isReviewStatus() {
        return this.reviewStatus;
    }

    public void setBiz(String str) {
        this.biz = str;
    }

    public void setGradeCertified(boolean z) {
        this.gradeCertified = z;
    }

    public void setReviewStatus(boolean z) {
        this.reviewStatus = z;
    }

    public void setRpAuditStatus(AuditStatus auditStatus) {
        this.rpAuditStatus = auditStatus;
    }
}
