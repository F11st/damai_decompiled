package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.youku.middlewareservice.provider.youku.YoukuDeviceInfoProviderProxy;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKFollowButtonStyle4 extends FrameLayout {
    private boolean animate;
    private boolean clicked;
    private LottieAnimationView lottieAnimationView;

    public YKFollowButtonStyle4(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lottieAnimationView = (LottieAnimationView) LayoutInflater.from(context).inflate(R.layout.resource_yk_follow_button, (ViewGroup) this, true).findViewById(R.id.follow_button);
        if (!Utils.isDebug(context) && YoukuDeviceInfoProviderProxy.getDeviceScore() <= 80) {
            this.animate = false;
        } else {
            this.animate = true;
        }
    }

    public void changeState() {
        if (this.animate) {
            if (this.clicked) {
                this.lottieAnimationView.setImageAssetsFolder("images");
                this.lottieAnimationView.setAnimation(Utils.getCancelFollow4Path(), LottieAnimationView.CacheStrategy.Strong);
                this.lottieAnimationView.playAnimation();
                this.clicked = false;
                return;
            }
            this.lottieAnimationView.setImageAssetsFolder("images");
            this.lottieAnimationView.setAnimation(Utils.getAddFollow4Path(), LottieAnimationView.CacheStrategy.Strong);
            this.lottieAnimationView.playAnimation();
            this.clicked = true;
        } else if (this.clicked) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_addfollow4);
            this.clicked = false;
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_followed3);
            this.clicked = true;
        }
    }

    public void setInitState(boolean z) {
        if (z) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_followed3);
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_addfollow4);
        }
        this.clicked = z;
    }

    public YKFollowButtonStyle4(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
