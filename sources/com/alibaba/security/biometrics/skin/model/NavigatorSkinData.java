package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class NavigatorSkinData extends BaseSkinData {
    private ImageViewSkinData closeImageView;
    private ImageViewSkinData soundOffImageView;
    private ImageViewSkinData soundOnImageView;

    public ImageViewSkinData getCloseImageView() {
        return this.closeImageView;
    }

    public ImageViewSkinData getSoundOffImageView() {
        return this.soundOffImageView;
    }

    public ImageViewSkinData getSoundOnImageView() {
        return this.soundOnImageView;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
        ImageViewSkinData imageViewSkinData = this.closeImageView;
        if (imageViewSkinData != null) {
            imageViewSkinData.parse(iSkinParse);
        }
        ImageViewSkinData imageViewSkinData2 = this.soundOnImageView;
        if (imageViewSkinData2 != null) {
            imageViewSkinData2.parse(iSkinParse);
        }
        ImageViewSkinData imageViewSkinData3 = this.soundOffImageView;
        if (imageViewSkinData3 != null) {
            imageViewSkinData3.parse(iSkinParse);
        }
    }

    public void setCloseImageView(ImageViewSkinData imageViewSkinData) {
        this.closeImageView = imageViewSkinData;
    }

    public void setSoundOffImageView(ImageViewSkinData imageViewSkinData) {
        this.soundOffImageView = imageViewSkinData;
    }

    public void setSoundOnImageView(ImageViewSkinData imageViewSkinData) {
        this.soundOnImageView = imageViewSkinData;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
        ImageViewSkinData imageViewSkinData = this.closeImageView;
        if (imageViewSkinData != null) {
            imageViewSkinData.webConvert(iSkinParse);
        }
        ImageViewSkinData imageViewSkinData2 = this.soundOnImageView;
        if (imageViewSkinData2 != null) {
            imageViewSkinData2.webConvert(iSkinParse);
        }
        ImageViewSkinData imageViewSkinData3 = this.soundOffImageView;
        if (imageViewSkinData3 != null) {
            imageViewSkinData3.webConvert(iSkinParse);
        }
    }
}
