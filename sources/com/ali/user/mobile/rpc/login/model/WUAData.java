package com.ali.user.mobile.rpc.login.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class WUAData implements Serializable {
    public String appKey;
    public String t;
    public String wua;

    public WUAData(String str, String str2, String str3) {
        this.appKey = str;
        this.t = str2;
        this.wua = str3;
    }

    public WUAData() {
    }
}
