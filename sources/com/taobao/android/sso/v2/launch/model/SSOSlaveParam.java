package com.taobao.android.sso.v2.launch.model;

import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SSOSlaveParam {
    public static final String KEY_APPKEY = "slaveAppKey";
    public static final String KEY_SSO_VERSION = "ssoVersion";
    public static final String KEY_TARGET_URL = "targetUrl";
    public static final String KEY_TIMESTAMP = "t";
    public static final String KEY_UUIDKEY = "euuid";
    public String appKey;
    public String sign;
    public String ssoVersion;
    public long t;
    public String targetUrl;
    public String uuidKey;

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("slaveAppKey", this.appKey);
        treeMap.put("ssoVersion", this.ssoVersion);
        treeMap.put("t", String.valueOf(this.t));
        treeMap.put(KEY_UUIDKEY, this.uuidKey);
        treeMap.put("targetUrl", this.targetUrl);
        return treeMap;
    }
}
