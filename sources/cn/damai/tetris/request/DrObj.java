package cn.damai.tetris.request;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class DrObj implements Serializable {
    public String targetArgs;
    public String targetLayerId;
    public String targetSectionId;

    public DrObj() {
    }

    public DrObj(String str, String str2, String str3) {
        this.targetLayerId = str;
        this.targetSectionId = str2;
        this.targetArgs = str3;
    }
}
