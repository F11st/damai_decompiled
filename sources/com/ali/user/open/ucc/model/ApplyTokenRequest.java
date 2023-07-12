package com.ali.user.open.ucc.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
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
