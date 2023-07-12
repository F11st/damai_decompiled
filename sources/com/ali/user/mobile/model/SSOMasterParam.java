package com.ali.user.mobile.model;

import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class SSOMasterParam {
    public static final String TAO_KEY_APPKEY = "masterAppKey";
    public static final String TAO_KEY_SSO_TOKEN = "ssoToken";
    public static final String TAO_KEY_SSO_VERSION = "ssoVersion";
    public static final String TAO_KEY_TIMESTAMP = "t";
    public static final String TAO_KEY_USER_ID = "userId";
    public String appKey;
    public String sign;
    public String ssoToken;
    public String ssoVersion;
    public long t;
    public String userId;
    public String uuidKey;

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("masterAppKey", this.appKey);
        treeMap.put("ssoVersion", this.ssoVersion);
        treeMap.put("t", String.valueOf(this.t));
        treeMap.put("userId", this.userId);
        treeMap.put("ssoToken", this.ssoToken);
        return treeMap;
    }
}
