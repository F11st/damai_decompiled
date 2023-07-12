package com.alibaba.security.biometrics.skin.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;
import com.alibaba.security.common.b.a.a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ButtonSkinData extends TextViewSkinData {
    private String backgroundColor;
    private String backgroundImage;
    @a(d = false)
    private Bitmap backgroundImageBitmap;

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public Bitmap getBackgroundImageBitmap() {
        return this.backgroundImageBitmap;
    }

    @Override // com.alibaba.security.biometrics.skin.model.TextViewSkinData, com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
        this.backgroundImageBitmap = iSkinParse.parseBitmap(this.backgroundImage);
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public void setBackgroundImage(String str) {
        this.backgroundImage = str;
    }

    public void setBackgroundImageBitmap(Bitmap bitmap) {
        this.backgroundImageBitmap = bitmap;
    }

    @Override // com.alibaba.security.biometrics.skin.model.TextViewSkinData, com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
        if (TextUtils.isEmpty(this.backgroundImage)) {
            return;
        }
        this.backgroundImage = iSkinParse.convertWebPath(this.backgroundImage);
    }
}
