package com.taobao.android.sns4android;

import com.ali.user.open.core.Site;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum SNSPlatform {
    PLATFORM_GOOGLE("google", "", false),
    PLATFORM_FACEBOOK("facebook", "com.facebook.katana", true),
    PLATFORM_TWITTER("twitter", "com.twitter.android", true),
    PLATFORM_LINKEDIN("linkedin", "com.linkedin.android", true),
    PLATFORM_QQ(Site.QQ, "com.tencent.mobileqq", false),
    PLATFORM_WEIXIN("weixin", "com.tencent.mm", false),
    PLATFORM_WEIBO(Site.WEIBO, "com.sina.weibo", true),
    PLATFORM_ALIPAY("alipay", "com.eg.android.AlipayGphone", true),
    PLATFORM_ALIPAYINSIDE("alipay", "com.eg.android.AlipayGphone", true),
    PLATFORM_LINE("line", "jp.naver.line.android", true),
    PLATFORM_TAOBAO("taobao", "com.taobao.taobao", true),
    PLATFORM_OTHERS("other", "", false),
    PLATFORM_HUAWEI("Huawei", "", false),
    PLATFORM_UC("UC", "", true),
    PLATFORM_NETEASE("Netease", "", true),
    PLATFORM_WC("WC", "cn.cyberIdentity.certification", false);
    
    private boolean canAuthByH5;
    private String packageName;
    private String platform;

    SNSPlatform(String str, String str2, boolean z) {
        this.platform = str;
        this.packageName = str2;
        this.canAuthByH5 = z;
    }

    public boolean canAuthByH5() {
        return this.canAuthByH5;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPlatform() {
        return this.platform;
    }
}
