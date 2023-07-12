package cn.damai.uikit.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$raw;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PraiseAnimateView extends LottieAnimationView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = PraiseAnimateView.class.getSimpleName();
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mCancellistener;
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mClicklistener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.PraiseAnimateView$a */
    /* loaded from: classes8.dex */
    public class C2599a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2599a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "306185654")) {
                ipChange.ipc$dispatch("306185654", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1845494073")) {
                ipChange.ipc$dispatch("1845494073", new Object[]{this, animator});
                return;
            }
            PraiseAnimateView praiseAnimateView = PraiseAnimateView.this;
            praiseAnimateView.removeAnimatorListener(praiseAnimateView.mClicklistener);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1675206027")) {
                ipChange.ipc$dispatch("-1675206027", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1746090926")) {
                ipChange.ipc$dispatch("-1746090926", new Object[]{this, animator});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.PraiseAnimateView$b */
    /* loaded from: classes8.dex */
    public class C2600b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2600b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1075355669")) {
                ipChange.ipc$dispatch("1075355669", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1837734714")) {
                ipChange.ipc$dispatch("1837734714", new Object[]{this, animator});
                return;
            }
            PraiseAnimateView praiseAnimateView = PraiseAnimateView.this;
            praiseAnimateView.removeAnimatorListener(praiseAnimateView.mCancellistener);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-906036012")) {
                ipChange.ipc$dispatch("-906036012", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-612900333")) {
                ipChange.ipc$dispatch("-612900333", new Object[]{this, animator});
            }
        }
    }

    public PraiseAnimateView(Context context) {
        super(context);
        this.mClicklistener = new C2599a();
        this.mCancellistener = new C2600b();
    }

    public void playCancelAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865862702")) {
            ipChange.ipc$dispatch("-865862702", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_dian_zan_dismiss);
        addAnimatorListener(this.mCancellistener);
        playAnimation();
    }

    public void playClickAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284255912")) {
            ipChange.ipc$dispatch("-1284255912", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_dian_zan);
        addAnimatorListener(this.mClicklistener);
        playAnimation();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859251761")) {
            ipChange.ipc$dispatch("-859251761", new Object[]{this, onClickListener});
        } else {
            super.setOnClickListener(onClickListener);
        }
    }

    public PraiseAnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClicklistener = new C2599a();
        this.mCancellistener = new C2600b();
    }

    public PraiseAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClicklistener = new C2599a();
        this.mCancellistener = new C2600b();
    }
}
