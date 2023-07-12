package com.ali.user.mobile.model;

import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DeviceTokenSignParam {
    public static final String KEY_ACTIONTYPE = "actionType";
    public static final String KEY_APPKEY = "appKey";
    public static final String KEY_APPVERSION = "appVersion";
    public static final String KEY_AUTOLOGINTOKEN = "autoLoginToken";
    public static final String KEY_HAVANAID = "havanaId";
    public static final String KEY_SDKVERSION = "sdkVersion";
    public static final String KEY_TIMESTAMP = "timestamp";
    private TreeMap<String, String> map = new TreeMap<>();

    public DeviceTokenSignParam addActionType(String str) {
        this.map.put("actionType", str);
        return this;
    }

    public DeviceTokenSignParam addAppKey(String str) {
        this.map.put("appKey", str);
        return this;
    }

    public DeviceTokenSignParam addAppVersion(String str) {
        this.map.put("appVersion", str);
        return this;
    }

    public DeviceTokenSignParam addAutoLoginToken(String str) {
        this.map.put("autoLoginToken", str);
        return this;
    }

    public DeviceTokenSignParam addHavanaId(String str) {
        this.map.put("havanaId", str);
        return this;
    }

    public DeviceTokenSignParam addSDKVersion(String str) {
        this.map.put("sdkVersion", str);
        return this;
    }

    public DeviceTokenSignParam addTimestamp(String str) {
        this.map.put("timestamp", str);
        return this;
    }

    public TreeMap<String, String> build() {
        return this.map;
    }
}
