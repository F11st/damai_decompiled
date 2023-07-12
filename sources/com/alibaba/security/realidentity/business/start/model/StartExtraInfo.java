package com.alibaba.security.realidentity.business.start.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StartExtraInfo implements Serializable {
    public IdentityInfo identityInfo;
    public String livenessConfig;
    public boolean localAccelerateOpen;
    private boolean needGuidePage;
    private boolean needLogin;
    private boolean needPrivacyPage;
    private boolean needQueryPage;
    private boolean needStatusPage;
    private boolean needUserInfo;
    private StartStatusResult rpStatusResult;
    public String skinColor;
    private boolean useNewProcess;
    private boolean useOCR;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class IdentityInfo implements Serializable {
        public String name;
    }

    public IdentityInfo getIdentityInfo() {
        return this.identityInfo;
    }

    public String getLivenessConfig() {
        return this.livenessConfig;
    }

    public StartStatusResult getRpStatusResult() {
        return this.rpStatusResult;
    }

    public String getSkinColor() {
        return this.skinColor;
    }

    public boolean isLocalAccelerateOpen() {
        return this.localAccelerateOpen;
    }

    public boolean isNeedGuidePage() {
        return this.needGuidePage;
    }

    public boolean isNeedLogin() {
        return this.needLogin;
    }

    public boolean isNeedPrivacyPage() {
        return this.needPrivacyPage;
    }

    public boolean isNeedQueryPage() {
        return this.needQueryPage;
    }

    public boolean isNeedStatusPage() {
        return this.needStatusPage;
    }

    public boolean isNeedUserInfo() {
        return this.needUserInfo;
    }

    public boolean isUseNewProcess() {
        return this.useNewProcess;
    }

    public boolean isUseOCR() {
        return this.useOCR;
    }

    public void setIdentityInfo(IdentityInfo identityInfo) {
        this.identityInfo = identityInfo;
    }

    public void setLivenessConfig(String str) {
        this.livenessConfig = str;
    }

    public void setLocalAccelerateOpen(boolean z) {
        this.localAccelerateOpen = z;
    }

    public void setNeedGuidePage(boolean z) {
        this.needGuidePage = z;
    }

    public void setNeedLogin(boolean z) {
        this.needLogin = z;
    }

    public void setNeedPrivacyPage(boolean z) {
        this.needPrivacyPage = z;
    }

    public void setNeedQueryPage(boolean z) {
        this.needQueryPage = z;
    }

    public void setNeedStatusPage(boolean z) {
        this.needStatusPage = z;
    }

    public void setNeedUserInfo(boolean z) {
        this.needUserInfo = z;
    }

    public void setRpStatusResult(StartStatusResult startStatusResult) {
        this.rpStatusResult = startStatusResult;
    }

    public void setSkinColor(String str) {
        this.skinColor = str;
    }

    public void setUseNewProcess(boolean z) {
        this.useNewProcess = z;
    }

    public void setUseOCR(boolean z) {
        this.useOCR = z;
    }
}
