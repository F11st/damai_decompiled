package com.alient.onearch.adapter.request;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DRParam implements Serializable {
    public String targetArgs;
    public String targetLayerId;
    public String targetSectionId;

    public DRParam() {
    }

    public DRParam(String str, String str2, String str3) {
        this.targetLayerId = str;
        this.targetSectionId = str2;
        this.targetArgs = str3;
    }

    public DRParam(String str, String str2) {
        this(str, str2, null);
    }
}
