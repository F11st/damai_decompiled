package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKCardErrorView extends YKErrorView implements YKCustomizedView {
    public YKCardErrorView(Context context) {
        super(context);
        init(context, null);
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.resource_ykcard_errorview, (ViewGroup) this, true);
        this.error_image = (ImageView) inflate.findViewById(R.id.error_image);
        this.error_text = (TextView) inflate.findViewById(R.id.error_text);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.error_image.getLayoutParams();
        int width = Utils.getWidth(getContext());
        Resources resources = getResources();
        int i = R.dimen.resource_size_48;
        int dimensionPixelOffset = ((width - (resources.getDimensionPixelOffset(i) * 2)) - (getResources().getDimensionPixelOffset(R.dimen.resource_size_74) * 2)) - getResources().getDimensionPixelOffset(R.dimen.resource_size_9);
        int i2 = (dimensionPixelOffset * 74) / 123;
        layoutParams.width = dimensionPixelOffset;
        layoutParams.height = i2;
        this.error_image.setLayoutParams(layoutParams);
        int i3 = (dimensionPixelOffset * 66) / 582;
        Resources resources2 = getResources();
        int i4 = R.dimen.resource_size_30;
        setPadding(getResources().getDimensionPixelOffset(i) - i3, resources2.getDimensionPixelOffset(i4), getResources().getDimensionPixelOffset(i) + i3, getResources().getDimensionPixelOffset(i4));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.error_lottie);
        this.error_lottie = lottieAnimationView;
        lottieAnimationView.getLayoutParams().width = dimensionPixelOffset;
        this.error_lottie.getLayoutParams().height = i2;
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) inflate.findViewById(R.id.error_bird);
        this.error_bird = lottieAnimationView2;
        lottieAnimationView2.getLayoutParams().width = dimensionPixelOffset;
        this.error_bird.getLayoutParams().height = i2;
        this.animate = false;
    }

    public YKCardErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
