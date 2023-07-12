package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ControlSkinData extends BaseSkinData {
    private String backgroundColor;

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
    }
}
