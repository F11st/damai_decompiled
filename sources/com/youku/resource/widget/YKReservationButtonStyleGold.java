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
public class YKReservationButtonStyleGold extends FrameLayout {
    private boolean animate;
    private boolean clicked;
    private LottieAnimationView lottieAnimationView;

    public YKReservationButtonStyleGold(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lottieAnimationView = (LottieAnimationView) LayoutInflater.from(context).inflate(R.layout.resource_yk_reservation_button, (ViewGroup) this, true).findViewById(R.id.reservation_button);
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
                this.lottieAnimationView.setAnimation(Utils.getCancelReservationGoldPath(), LottieAnimationView.CacheStrategy.Strong);
                this.lottieAnimationView.playAnimation();
                this.clicked = false;
                return;
            }
            this.lottieAnimationView.setImageAssetsFolder("images");
            this.lottieAnimationView.setAnimation(Utils.getAddReservationGoldPath(), LottieAnimationView.CacheStrategy.Strong);
            this.lottieAnimationView.playAnimation();
            this.clicked = true;
        } else if (this.clicked) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_reservation_gold);
            this.clicked = false;
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_reservationed);
            this.clicked = true;
        }
    }

    public void setInitState(boolean z) {
        if (z) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_reservationed);
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_button_reservation_gold);
        }
        this.clicked = z;
    }

    public YKReservationButtonStyleGold(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
