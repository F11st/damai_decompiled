package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.youku.middlewareservice.provider.youku.YoukuDeviceInfoProviderProxy;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;
import com.youku.uplayer.AliMediaPlayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKPageErrorView extends YKErrorView {
    private ImageView error_refresh;
    private OnRefreshClickListener mOnRefreshClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnRefreshClickListener {
        void clickRefresh(int i);
    }

    public YKPageErrorView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.C8074layout.resource_ykpage_errorview, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.error_image);
        this.error_image = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int width = Utils.getWidth(getContext()) - (getResources().getDimensionPixelOffset(R.dimen.resource_size_42) * 2);
        int i = (width * AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_LOADING_FACTOR_STEP) / 291;
        layoutParams.width = width;
        layoutParams.height = i;
        this.error_image.setLayoutParams(layoutParams);
        this.error_text = (TextView) inflate.findViewById(R.id.error_text);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.error_lottie);
        this.error_lottie = lottieAnimationView;
        lottieAnimationView.getLayoutParams().width = width;
        this.error_lottie.getLayoutParams().height = i;
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) inflate.findViewById(R.id.error_bird);
        this.error_bird = lottieAnimationView2;
        lottieAnimationView2.getLayoutParams().width = width;
        this.error_bird.getLayoutParams().height = i;
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.error_refresh);
        this.error_refresh = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.youku.resource.widget.YKPageErrorView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YKPageErrorView.this.mOnRefreshClickListener != null) {
                    YKPageErrorView.this.mOnRefreshClickListener.clickRefresh(YKPageErrorView.this.errorType);
                }
            }
        });
        if (YoukuDeviceInfoProviderProxy.getDeviceScore() > 80) {
            this.animate = true;
        } else {
            this.animate = false;
        }
    }

    public void setErrorText(String str, int i, boolean z) {
        this.animate = z;
        super.setErrorText(str, i);
    }

    public void setOnRefreshClickListener(OnRefreshClickListener onRefreshClickListener) {
        this.mOnRefreshClickListener = onRefreshClickListener;
        if (onRefreshClickListener != null) {
            this.error_refresh.setVisibility(0);
        } else {
            this.error_refresh.setVisibility(8);
        }
    }

    public YKPageErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
