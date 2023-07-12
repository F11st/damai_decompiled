package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baseproject.basecard.widget.WithCornerMaskImageView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuImageView extends WithCornerMaskImageView {
    public YoukuImageView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baseproject.basecard.widget.WithCornerMaskImageView, com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, (size * 9) / 16);
    }

    public YoukuImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
