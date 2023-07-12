package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CombFloatingView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DISMISS_FLOATING = 17;
    private static final int GENERAL_RICH_NUM = 10;
    private static final int MAX_LENGTH = 4;
    private static final int MEDIUM_RICH_NUM = 30;
    private static final int MIN_LENGTH = 1;
    private static final int MIN_RICH_NUM = 1;
    private static final int SUPER_RICH_NUM = 60;
    private static final String TAG = "CombFloatingView";
    private boolean isChangeState;
    private boolean isChangeStateEnd;
    private boolean isMaxSendNum;
    private AnimatorSet mAnimatorSet;
    private ImageView mCombEffectView;
    private LinearLayout mCombNumView;
    private TUrlImageView mCombShineView;
    private ValueAnimator mDismissScaleAnimator;
    private ImageView mFirstNumView;
    private ImageView mFourNumView;
    private ValueAnimator mNumScaleAnimator;
    private ImageView mSecondNumView;
    private ValueAnimator mTextScaleAnimator;
    private ImageView mThirdNumView;
    @SuppressLint({"HandlerLeak"})
    public Handler weakHandler;

    public CombFloatingView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1721709819")) {
            ipChange.ipc$dispatch("1721709819", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_comb_floating, (ViewGroup) this, true);
        this.mCombNumView = (LinearLayout) findViewById(R.id.comb_num_view);
        this.mFirstNumView = (ImageView) findViewById(R.id.comb_num_1);
        this.mSecondNumView = (ImageView) findViewById(R.id.comb_num_2);
        this.mThirdNumView = (ImageView) findViewById(R.id.comb_num_3);
        this.mFourNumView = (ImageView) findViewById(R.id.comb_num_4);
        this.mCombEffectView = (ImageView) findViewById(R.id.comb_effct_view);
        this.mCombShineView = (TUrlImageView) findViewById(R.id.comb_effct_shine);
        this.mAnimatorSet = new AnimatorSet();
        setNumScaleType();
        setTextScaleType();
        setDismissStyleType();
    }

    private void setDismissStyleType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1563873051")) {
            ipChange.ipc$dispatch("-1563873051", new Object[]{this});
            return;
        }
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.0f);
        this.mDismissScaleAnimator = ofFloat;
        ofFloat.setDuration(100L);
        this.mDismissScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1034988269")) {
                    ipChange2.ipc$dispatch("1034988269", new Object[]{this, valueAnimator});
                    return;
                }
                CombFloatingView.this.mCombEffectView.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CombFloatingView.this.mCombEffectView.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CombFloatingView.this.mCombNumView.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CombFloatingView.this.mCombNumView.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mDismissScaleAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1113025565")) {
                    ipChange2.ipc$dispatch("1113025565", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                CombFloatingView.this.setVisibility(8);
            }
        });
    }

    private void setFloatingParams(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103813879")) {
            ipChange.ipc$dispatch("-2103813879", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 11 && i != 31 && i != 61) {
            this.isChangeStateEnd = false;
            this.isChangeState = false;
            this.mTextScaleAnimator.setFloatValues(1.0f, 1.4f, 1.0f);
            this.mTextScaleAnimator.setDuration(150L);
            this.mTextScaleAnimator.setInterpolator(new LinearInterpolator());
        } else {
            this.isChangeStateEnd = false;
            this.isChangeState = true;
            this.mTextScaleAnimator.setFloatValues(0.0f, 2.0f);
            this.mTextScaleAnimator.setDuration(300L);
            this.mTextScaleAnimator.setInterpolator(new DecelerateInterpolator(1.0f));
        }
    }

    private void setMaxNumParams(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740478186")) {
            ipChange.ipc$dispatch("-1740478186", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCombNumView.getLayoutParams();
        layoutParams.rightMargin = UIUtil.dip2px(z ? 65 : 80);
        this.mCombNumView.setLayoutParams(layoutParams);
    }

    private void setNum(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334305378")) {
            ipChange.ipc$dispatch("334305378", new Object[]{this, str, imageView});
        } else if ("1".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_1);
        } else if ("2".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_2);
        } else if ("3".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_3);
        } else if ("4".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_4);
        } else if ("5".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_5);
        } else if ("6".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_6);
        } else if ("7".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_7);
        } else if ("8".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_8);
        } else if ("9".equals(str)) {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_9);
        } else {
            imageView.setImageResource(R.C7941drawable.dago_pgc_combsend_0);
        }
    }

    private void setNumScaleType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586426712")) {
            ipChange.ipc$dispatch("-586426712", new Object[]{this});
            return;
        }
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.2f, 0.9f);
        this.mNumScaleAnimator = ofFloat;
        ofFloat.setDuration(150L);
        this.mNumScaleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mNumScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-856387606")) {
                    ipChange2.ipc$dispatch("-856387606", new Object[]{this, valueAnimator});
                    return;
                }
                CombFloatingView.this.mCombNumView.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CombFloatingView.this.mCombNumView.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateChangeType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110007497")) {
            ipChange.ipc$dispatch("1110007497", new Object[]{this});
            return;
        }
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(2.0f, 0.8f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-225928981")) {
                    ipChange2.ipc$dispatch("-225928981", new Object[]{this, valueAnimator});
                    return;
                }
                CombFloatingView.this.mCombEffectView.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CombFloatingView.this.mCombEffectView.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1128544283")) {
                    ipChange2.ipc$dispatch("1128544283", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                CombFloatingView.this.isChangeStateEnd = true;
            }
        });
        ofFloat.start();
    }

    private void setTextScaleType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907689101")) {
            ipChange.ipc$dispatch("1907689101", new Object[]{this});
            return;
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        this.mTextScaleAnimator = objectAnimator;
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2117304856")) {
                    ipChange2.ipc$dispatch("-2117304856", new Object[]{this, valueAnimator});
                    return;
                }
                CombFloatingView.this.mCombEffectView.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CombFloatingView.this.mCombEffectView.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mTextScaleAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1151822360")) {
                    ipChange2.ipc$dispatch("1151822360", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                if (CombFloatingView.this.isChangeState) {
                    CombFloatingView.this.setStateChangeType();
                }
                CombFloatingView.this.weakHandler.sendEmptyMessageDelayed(17, 4500L);
            }
        });
    }

    public void cancelAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705070441")) {
            ipChange.ipc$dispatch("-1705070441", new Object[]{this});
            return;
        }
        this.isMaxSendNum = false;
        ValueAnimator valueAnimator = this.mNumScaleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mTextScaleAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        TUrlImageView tUrlImageView = this.mCombShineView;
        if (tUrlImageView != null) {
            tUrlImageView.setVisibility(8);
            this.mCombShineView.setImageDrawable(null);
            ur1.o().e();
        }
    }

    public void removeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002310706")) {
            ipChange.ipc$dispatch("1002310706", new Object[]{this});
            return;
        }
        Handler handler = this.weakHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (getVisibility() == 0) {
            setVisibility(8);
        }
        cancelAnim();
    }

    public void setDataForNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416787492")) {
            ipChange.ipc$dispatch("416787492", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        String valueOf = String.valueOf(i);
        if (valueOf.length() >= 1 && valueOf.length() < 4) {
            this.mFirstNumView.setVisibility(0);
            this.mThirdNumView.setVisibility(8);
            setNum(String.valueOf(valueOf.charAt(0)), this.mFirstNumView);
            if (valueOf.length() == 1) {
                this.mSecondNumView.setVisibility(8);
                this.mFourNumView.setVisibility(8);
                return;
            } else if (valueOf.length() == 2) {
                this.mSecondNumView.setVisibility(0);
                this.mFourNumView.setVisibility(8);
                setNum(String.valueOf(valueOf.charAt(1)), this.mSecondNumView);
                return;
            } else {
                this.mSecondNumView.setVisibility(0);
                this.mFourNumView.setVisibility(0);
                String valueOf2 = String.valueOf(valueOf.charAt(1));
                String valueOf3 = String.valueOf(valueOf.charAt(2));
                setNum(valueOf2, this.mSecondNumView);
                setNum(valueOf3, this.mFourNumView);
                return;
            }
        }
        this.isMaxSendNum = true;
        this.mFirstNumView.setVisibility(0);
        this.mSecondNumView.setVisibility(0);
        this.mFourNumView.setVisibility(0);
        this.mThirdNumView.setVisibility(0);
        ImageView imageView = this.mFirstNumView;
        int i2 = R.C7941drawable.dago_pgc_combsend_9;
        imageView.setImageResource(i2);
        this.mSecondNumView.setImageResource(i2);
        this.mFourNumView.setImageResource(i2);
        this.mThirdNumView.setImageResource(R.C7941drawable.dago_pgc_combsend_add);
    }

    public void setDataForText(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971435371")) {
            ipChange.ipc$dispatch("971435371", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= 1 && i <= 10) {
            this.mCombEffectView.setImageResource(R.C7941drawable.dago_pgc_combsend_rich0);
        } else if (i > 10 && i <= 30) {
            this.mCombEffectView.setImageResource(R.C7941drawable.dago_pgc_combsend_rich1);
        } else if (i > 30 && i <= 60) {
            this.mCombEffectView.setImageResource(R.C7941drawable.dago_pgc_combsend_rich2);
        } else {
            this.mCombEffectView.setImageResource(R.C7941drawable.dago_pgc_combsend_rich3);
        }
        if (this.isMaxSendNum) {
            ur1.o().s("https://img.alicdn.com/tfs/TB1xxa6JbH1gK0jSZFwXXc7aXXa-344-168.png").y(this.mCombShineView);
            this.mCombShineView.setVisibility(0);
        }
    }

    public void startFloatingAnim(int i) {
        Handler handler;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923727380")) {
            ipChange.ipc$dispatch("923727380", new Object[]{this, Integer.valueOf(i)});
        } else if ((this.isChangeState && !this.isChangeStateEnd) || (handler = this.weakHandler) == null || this.mCombNumView == null || this.mCombEffectView == null || this.mNumScaleAnimator == null || this.mTextScaleAnimator == null) {
        } else {
            handler.removeMessages(17);
            setVisibility(0);
            setDataForNum(i);
            setDataForText(i);
            setFloatingParams(i);
            setMaxNumParams(this.isMaxSendNum);
            this.mNumScaleAnimator.start();
            this.mTextScaleAnimator.start();
        }
    }

    public CombFloatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CombFloatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isChangeStateEnd = true;
        this.weakHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.CombFloatingView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "624577135")) {
                    ipChange.ipc$dispatch("624577135", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                if (message.what != 17) {
                    return;
                }
                CombFloatingView.this.mDismissScaleAnimator.start();
            }
        };
        initView(context);
    }
}
