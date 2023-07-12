package com.ali.user.mobile.rpc.login.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ApplyTokenRequest implements Serializable {
    public String appName;
    public String appVersion;
    public String deviceTokenKey;
    public String deviceTokenSign;
    public String sdkVersion;
    public String sid;
    public int site;
    public long t;
    public boolean useDeviceToken = true;
}
