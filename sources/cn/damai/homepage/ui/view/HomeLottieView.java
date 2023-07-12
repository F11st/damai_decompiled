package cn.damai.homepage.ui.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ls;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomeLottieView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView bgImageView;
    private LottieAnimationView lottieView;

    public HomeLottieView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551210384")) {
            ipChange.ipc$dispatch("-1551210384", new Object[]{this, context});
            return;
        }
        ImageView imageView = new ImageView(context);
        this.bgImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.bgImageView, new FrameLayout.LayoutParams(-1, -1));
        this.lottieView = new LottieAnimationView(context);
        addView(this.lottieView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281905075")) {
            ipChange.ipc$dispatch("1281905075", new Object[]{this, animatorListener});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.addAnimatorListener(animatorListener);
    }

    public void cancelAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840899891")) {
            ipChange.ipc$dispatch("1840899891", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.lottieView.clearAnimation();
            this.lottieView.removeAllLottieOnCompositionLoadedListener();
            this.lottieView.removeAllAnimatorListeners();
        }
    }

    public LottieAnimationView getLottieView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1643456165") ? (LottieAnimationView) ipChange.ipc$dispatch("1643456165", new Object[]{this}) : this.lottieView;
    }

    public boolean isAnimating() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "560024525")) {
            return ((Boolean) ipChange.ipc$dispatch("560024525", new Object[]{this})).booleanValue();
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return false;
        }
        return lottieAnimationView.isAnimating();
    }

    public void pauseAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396618401")) {
            ipChange.ipc$dispatch("-1396618401", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.pauseAnimation();
    }

    public void playAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062640877")) {
            ipChange.ipc$dispatch("2062640877", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.playAnimation();
    }

    public void setBgImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203604483")) {
            ipChange.ipc$dispatch("1203604483", new Object[]{this, str});
        } else if (this.bgImageView == null || TextUtils.isEmpty(str)) {
        } else {
            C0504a.b().c(ls.a(str)).g(this.bgImageView);
        }
    }

    public void setComposition(C2821a c2821a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431969556")) {
            ipChange.ipc$dispatch("-431969556", new Object[]{this, c2821a});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setComposition(c2821a);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910496155")) {
            ipChange.ipc$dispatch("910496155", new Object[]{this, imageAssetDelegate});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728728011")) {
            ipChange.ipc$dispatch("-728728011", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setProgress(i);
    }

    public void setRepeatCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567187512")) {
            ipChange.ipc$dispatch("-1567187512", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setRepeatCount(i);
    }

    public HomeLottieView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeLottieView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
