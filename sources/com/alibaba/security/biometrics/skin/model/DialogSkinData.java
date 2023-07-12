package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DialogSkinData extends BaseSkinData {
    private TextViewSkinData messageText;
    private TextViewSkinData negativeText;
    private TextViewSkinData positiveText;
    private TextViewSkinData titleText;

    public TextViewSkinData getMessageText() {
        return this.messageText;
    }

    public TextViewSkinData getNegativeText() {
        return this.negativeText;
    }

    public TextViewSkinData getPositiveText() {
        return this.positiveText;
    }

    public TextViewSkinData getTitleText() {
        return this.titleText;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
        TextViewSkinData textViewSkinData = this.positiveText;
        if (textViewSkinData != null) {
            textViewSkinData.parse(iSkinParse);
        }
        TextViewSkinData textViewSkinData2 = this.negativeText;
        if (textViewSkinData2 != null) {
            textViewSkinData2.parse(iSkinParse);
        }
        TextViewSkinData textViewSkinData3 = this.titleText;
        if (textViewSkinData3 != null) {
            textViewSkinData3.parse(iSkinParse);
        }
        TextViewSkinData textViewSkinData4 = this.messageText;
        if (textViewSkinData4 != null) {
            textViewSkinData4.parse(iSkinParse);
        }
    }

    public void setMessageText(TextViewSkinData textViewSkinData) {
        this.messageText = textViewSkinData;
    }

    public void setNegativeText(TextViewSkinData textViewSkinData) {
        this.negativeText = textViewSkinData;
    }

    public void setPositiveText(TextViewSkinData textViewSkinData) {
        this.positiveText = textViewSkinData;
    }

    public void setTitleText(TextViewSkinData textViewSkinData) {
        this.titleText = textViewSkinData;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
        TextViewSkinData textViewSkinData = this.positiveText;
        if (textViewSkinData != null) {
            textViewSkinData.webConvert(iSkinParse);
        }
        TextViewSkinData textViewSkinData2 = this.negativeText;
        if (textViewSkinData2 != null) {
            textViewSkinData2.webConvert(iSkinParse);
        }
        TextViewSkinData textViewSkinData3 = this.titleText;
        if (textViewSkinData3 != null) {
            textViewSkinData3.webConvert(iSkinParse);
        }
        TextViewSkinData textViewSkinData4 = this.messageText;
        if (textViewSkinData4 != null) {
            textViewSkinData4.webConvert(iSkinParse);
        }
    }
}
