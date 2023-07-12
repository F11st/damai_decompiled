package com.youku.resource.widget;

import android.animation.Animator;
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
public class YKThumbsupIcon extends FrameLayout {
    private boolean animate;
    private boolean clicked;
    private LottieAnimationView lottieAnimationView;

    public YKThumbsupIcon(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lottieAnimationView = (LottieAnimationView) LayoutInflater.from(context).inflate(R.C8074layout.resource_yk_thumbsup_icon, (ViewGroup) this, true).findViewById(R.id.thumbs_up_icon);
        if (!Utils.isDebug(context) && YoukuDeviceInfoProviderProxy.getDeviceScore() <= 80) {
            this.animate = false;
        } else {
            this.animate = true;
        }
    }

    public void changeState(boolean z) {
        if (this.animate) {
            if (this.clicked) {
                this.lottieAnimationView.setImageResource(R.C8072drawable.yk_icon_thumbs_up);
                this.clicked = false;
                return;
            }
            this.lottieAnimationView.setImageAssetsFolder("images");
            this.lottieAnimationView.setAnimation(!z ? Utils.getThumbsupIconPath() : Utils.getThumbsupFirstIconPath(), LottieAnimationView.CacheStrategy.Strong);
            this.lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.youku.resource.widget.YKThumbsupIcon.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    YKThumbsupIcon.this.lottieAnimationView.setImageResource(R.C8072drawable.yk_icon_thumbs_uped);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.lottieAnimationView.playAnimation();
            this.clicked = true;
        } else if (this.clicked) {
            this.lottieAnimationView.setImageResource(R.C8072drawable.yk_icon_thumbs_up);
            this.clicked = false;
        } else {
            this.lottieAnimationView.setImageResource(R.C8072drawable.yk_icon_thumbs_uped);
            this.clicked = true;
        }
    }

    public void setInitState(boolean z) {
        if (z) {
            this.lottieAnimationView.setImageResource(R.C8072drawable.yk_icon_thumbs_uped);
        } else {
            this.lottieAnimationView.setImageResource(R.C8072drawable.yk_icon_thumbs_up);
        }
        this.clicked = z;
    }

    public YKThumbsupIcon(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
