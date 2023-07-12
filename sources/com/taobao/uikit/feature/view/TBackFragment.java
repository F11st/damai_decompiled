package com.taobao.uikit.feature.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.uikit.feature.features.ImageSaveFeature;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBackFragment extends Fragment {
    private ImageSaveFeature mImageSaveFeature;

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ImageSaveFeature imageSaveFeature = this.mImageSaveFeature;
        if (imageSaveFeature != null) {
            imageSaveFeature.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void setImageSaveFeature(ImageSaveFeature imageSaveFeature) {
        this.mImageSaveFeature = imageSaveFeature;
    }
}
