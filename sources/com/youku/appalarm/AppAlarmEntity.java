package com.youku.appalarm;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppAlarmEntity {
    private String bizData;
    private String bizType;
    private String clickSpm;
    private String errorCode;
    private String errorMsg;
    private String pageName;
    private String pageSpm;
    private String reqData;
    private String respData;
    private String serviceCode;
    private String serviceMsg;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Build {
        private String bizData;
        private String bizType;
        private String clickSpm;
        private String errorCode;
        private String errorMsg;
        private String pageName;
        private String pageSpm;
        private String reqData;
        private String respData;
        private String serviceCode;
        private String serviceMsg;

        public AppAlarmEntity build() {
            AppAlarmEntity appAlarmEntity = new AppAlarmEntity();
            appAlarmEntity.setBizType(this.bizType);
            appAlarmEntity.setErrorCode(this.errorCode);
            appAlarmEntity.setErrorMsg(this.errorMsg);
            appAlarmEntity.setPageName(this.pageName);
            appAlarmEntity.setPageSpm(this.pageSpm);
            appAlarmEntity.setClickSpm(this.clickSpm);
            appAlarmEntity.setReqData(this.reqData);
            appAlarmEntity.setRespData(this.respData);
            appAlarmEntity.setServiceCode(this.serviceCode);
            appAlarmEntity.setServiceMsg(this.serviceMsg);
            appAlarmEntity.setBizData(this.bizData);
            return appAlarmEntity;
        }

        public Build setBizData(String str) {
            this.bizData = str;
            return this;
        }

        public Build setBizType(String str) {
            this.bizType = str;
            return this;
        }

        public Build setClickSpm(String str) {
            this.clickSpm = str;
            return this;
        }

        public Build setErrorCode(String str) {
            this.errorCode = str;
            return this;
        }

        public Build setErrorMsg(String str) {
            this.errorMsg = str;
            return this;
        }

        public Build setPageName(String str) {
            this.pageName = str;
            return this;
        }

        public Build setPageSpm(String str) {
            this.pageSpm = str;
            return this;
        }

        public Build setReqData(String str) {
            this.reqData = str;
            return this;
        }

        public Build setRespData(String str) {
            this.respData = str;
            return this;
        }

        public Build setServiceCode(String str) {
            this.serviceCode = str;
            return this;
        }

        public Build setServiceMsg(String str) {
            this.serviceMsg = str;
            return this;
        }
    }

    public String getBizData() {
        return this.bizData;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getClickSpm() {
        return this.clickSpm;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getPageSpm() {
        return this.pageSpm;
    }

    public String getReqData() {
        return this.reqData;
    }

    public String getRespData() {
        return this.respData;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public String getServiceMsg() {
        return this.serviceMsg;
    }

    public void setBizData(String str) {
        this.bizData = str;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public void setClickSpm(String str) {
        this.clickSpm = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setPageName(String str) {
        this.pageName = str;
    }

    public void setPageSpm(String str) {
        this.pageSpm = str;
    }

    public void setReqData(String str) {
        this.reqData = str;
    }

    public void setRespData(String str) {
        this.respData = str;
    }

    public void setServiceCode(String str) {
        this.serviceCode = str;
    }

    public void setServiceMsg(String str) {
        this.serviceMsg = str;
    }
}
