package cn.damai.uikit.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMBreatheView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int BREATH_INTERVAL_TIME;
    private ObjectAnimator animInAlpha;
    private ObjectAnimator animInScaleX;
    private ObjectAnimator animInScaleY;
    private ObjectAnimator animOutAlpha;
    private ObjectAnimator animOutScaleX;
    private ObjectAnimator animOutScaleY;
    private AnimatorSet animSet;
    boolean isStopAnimation;
    private boolean isUp;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMBreatheView$a */
    /* loaded from: classes8.dex */
    public class C2571a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2571a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1245856511")) {
                ipChange.ipc$dispatch("1245856511", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1586163856")) {
                ipChange.ipc$dispatch("1586163856", new Object[]{this, animator});
            } else {
                DMBreatheView.this.startPlay();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-735535170")) {
                ipChange.ipc$dispatch("-735535170", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1854326295")) {
                ipChange.ipc$dispatch("-1854326295", new Object[]{this, animator});
            }
        }
    }

    public DMBreatheView(Context context) {
        this(context, null);
    }

    private void setAnimIn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419003862")) {
            ipChange.ipc$dispatch("1419003862", new Object[]{this});
            return;
        }
        this.animInScaleX = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 1.0f);
        this.animInScaleY = ObjectAnimator.ofFloat(this, "scaleY", 1.5f, 1.0f);
        this.animInAlpha = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
    }

    private void setAnimOut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219948161")) {
            ipChange.ipc$dispatch("1219948161", new Object[]{this});
            return;
        }
        this.animOutScaleX = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 1.0f);
        this.animOutScaleY = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 1.5f);
        this.animOutAlpha = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844561288")) {
            ipChange.ipc$dispatch("-1844561288", new Object[]{this});
        } else if (this.isStopAnimation) {
        } else {
            this.animSet = new AnimatorSet();
            setAnimOut();
            setAnimIn();
            this.animSet.setDuration(3500L);
            this.animSet.setInterpolator(new LinearInterpolator());
            if (this.isUp) {
                this.animSet.playTogether(this.animOutScaleX, this.animOutScaleY, this.animOutAlpha);
                this.isUp = false;
            } else {
                this.animSet.playTogether(this.animInScaleX, this.animInScaleY, this.animInAlpha);
                this.isUp = true;
            }
            this.animSet.start();
            this.animSet.addListener(new C2571a());
        }
    }

    public void setDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199388396")) {
            ipChange.ipc$dispatch("1199388396", new Object[]{this, Long.valueOf(j)});
        } else {
            this.animSet.setDuration(j);
        }
    }

    public void startAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035537178")) {
            ipChange.ipc$dispatch("2035537178", new Object[]{this});
        } else if (this.animSet == null) {
            this.isStopAnimation = false;
            startPlay();
        }
    }

    public void stopAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153121908")) {
            ipChange.ipc$dispatch("-153121908", new Object[]{this});
            return;
        }
        this.isStopAnimation = true;
        AnimatorSet animatorSet = this.animSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animSet = null;
        }
    }

    public DMBreatheView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMBreatheView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BREATH_INTERVAL_TIME = 3500;
        this.isStopAnimation = false;
        this.isUp = true;
        startAnimation();
    }
}
