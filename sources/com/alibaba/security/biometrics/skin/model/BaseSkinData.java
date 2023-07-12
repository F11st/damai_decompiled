package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseSkinData {
    private String key;

    public String getKey() {
        return this.key;
    }

    public abstract void parse(ISkinParse iSkinParse);

    public void setKey(String str) {
        this.key = str;
    }

    public abstract void webConvert(ISkinParse iSkinParse);
}
