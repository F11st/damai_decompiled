package com.youku.usercenter.passport.result;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MemberRequestBase implements Serializable {
    public String appName;
    public String appVersion = "android_1.2.3";
    public String deviceId;
    public Map<String, Object> ext;
    public String locale;
    public String sdkVersion;
    public int site;
    public Map<String, String> sysExt;
    public String ttid;
    public String utdid;
}
