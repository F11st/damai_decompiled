package com.alibaba.security.biometrics.camera;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PreviewSize implements Serializable {
    @JSONField(name = "height")
    private int height;
    @JSONField(name = "width")
    private int width;

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
