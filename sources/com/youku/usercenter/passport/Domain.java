package com.youku.usercenter.passport;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum Domain {
    DOMAIN_ONLINE("https://account.youku.com", "acs.youku.com"),
    DOMAIN_PRE("http://pre-sdkservice-userservice.passport.youku.com", "pre-acs.youku.com"),
    DOMAIN_TRUNK("http://accountsdktrunk.youku.com", "daily-acs.youku.com"),
    DOMAIN_TEST("http://accountsdktest.heyi.test", "daily-acs.youku.com");
    
    private String mHostUrl;
    private String mMtopHost;

    Domain(String str, String str2) {
        this.mHostUrl = str;
        this.mMtopHost = str2;
    }

    public String getMtopHost() {
        return this.mMtopHost;
    }

    public String getUrl() {
        return this.mHostUrl;
    }
}
