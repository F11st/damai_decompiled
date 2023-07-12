package com.alibaba.security.realidentity.business.start.model;

import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.business.start.StartHttpResponse;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StepItem implements Serializable {
    private String jsonAssist;
    private List<StartHttpResponse.Property> properties;
    private StepType stepType;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class JsonAssist implements Serializable {
        private String bioColorfulConf;
        private List<Integer> bioStepsEx;
        private String livenessConfig;
        private boolean needActionImage = true;
        private boolean needFailVideo;
        private boolean needGaze;
        private boolean needOriginalImage;
        private boolean needSuccessVideo;
        private boolean needUserConfirm;
        private boolean onlyGaze;
        private int retryCount;
        private boolean showNav;

        public String getBioColorfulConf() {
            return this.bioColorfulConf;
        }

        public List<Integer> getBioStepsEx() {
            return this.bioStepsEx;
        }

        public String getLivenessConfig() {
            return this.livenessConfig;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public boolean isNeedActionImage() {
            return this.needActionImage;
        }

        public boolean isNeedFailVideo() {
            return this.needFailVideo;
        }

        public boolean isNeedGaze() {
            return this.needGaze;
        }

        public boolean isNeedOriginalImage() {
            return this.needOriginalImage;
        }

        public boolean isNeedSuccessVideo() {
            return this.needSuccessVideo;
        }

        public boolean isNeedUserConfirm() {
            return this.needUserConfirm;
        }

        public boolean isOnlyGaze() {
            return this.onlyGaze;
        }

        public boolean isShowNav() {
            return this.showNav;
        }

        public void setBioColorfulConf(String str) {
            this.bioColorfulConf = str;
        }

        public void setBioStepsEx(List<Integer> list) {
            this.bioStepsEx = list;
        }

        public void setLivenessConfig(String str) {
            this.livenessConfig = str;
        }

        public void setNeedActionImage(boolean z) {
            this.needActionImage = z;
        }

        public void setNeedFailVideo(boolean z) {
            this.needFailVideo = z;
        }

        public void setNeedGaze(boolean z) {
            this.needGaze = z;
        }

        public void setNeedOriginalImage(boolean z) {
            this.needOriginalImage = z;
        }

        public void setNeedSuccessVideo(boolean z) {
            this.needSuccessVideo = z;
        }

        public void setNeedUserConfirm(boolean z) {
            this.needUserConfirm = z;
        }

        public void setOnlyGaze(boolean z) {
            this.onlyGaze = z;
        }

        public void setRetryCount(int i) {
            this.retryCount = i;
        }

        public void setShowNav(boolean z) {
            this.showNav = z;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class StepTypeBean implements Serializable {
        private String code;
        private String desc;
        private String name;

        public String getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public String getJsonAssist() {
        return this.jsonAssist;
    }

    public JsonAssist getJsonAssistBean() {
        return (JsonAssist) C3811h.a(this.jsonAssist, JsonAssist.class, false);
    }

    public List<StartHttpResponse.Property> getProperties() {
        return this.properties;
    }

    public StepType getStepType() {
        return this.stepType;
    }

    public void setJsonAssist(String str) {
        this.jsonAssist = str;
    }

    public void setProperties(List<StartHttpResponse.Property> list) {
        this.properties = list;
    }

    public void setStepType(StepType stepType) {
        this.stepType = stepType;
    }
}
