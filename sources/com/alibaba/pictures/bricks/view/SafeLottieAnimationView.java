package com.alibaba.pictures.bricks.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.Animation;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.alibaba.pictures.bricks.view.SafeLottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import tb.eh0;
import tb.nd;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SafeLottieAnimationView extends LottieAnimationView implements Animator.AnimatorListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "SafeLottieAnimationView";
    private int failCount;
    private boolean isHacked;
    private String lottieStatisticScene;
    private OnLottieDrawFailListener mListener;
    private String mLottieNetWorkUrl;
    private LottieListener<Throwable> onLottieFailListener;
    private LottieListener<com.airbnb.lottie.a> onLottieSuccessListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnLottieDrawFailListener {
        void onDrawLottieFail(Throwable th, int i);
    }

    public SafeLottieAnimationView(Context context) {
        super(context);
        this.failCount = 0;
    }

    private void hackDefaultListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946812790")) {
            ipChange.ipc$dispatch("-1946812790", new Object[]{this});
        } else if (this.isHacked) {
        } else {
            replaceFailureListener(this, new LottieListener() { // from class: tb.q52
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    SafeLottieAnimationView.this.lambda$hackDefaultListener$0((Throwable) obj);
                }
            });
            replaceSuccessListener(this, new LottieListener() { // from class: tb.p52
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    SafeLottieAnimationView.this.lambda$hackDefaultListener$1((com.airbnb.lottie.a) obj);
                }
            });
            addAnimatorListener(this);
            this.isHacked = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hackDefaultListener$0(Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1782280116")) {
            ipChange.ipc$dispatch("-1782280116", new Object[]{this, th});
            return;
        }
        nd.a("fail-play " + th.getMessage(), TAG);
        LottieListener<Throwable> lottieListener = this.onLottieFailListener;
        if (lottieListener != null) {
            lottieListener.onResult(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hackDefaultListener$1(com.airbnb.lottie.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636131465")) {
            ipChange.ipc$dispatch("636131465", new Object[]{this, aVar});
            return;
        }
        nd.a("downLoad-success ", TAG);
        setComposition(aVar);
        LottieListener<com.airbnb.lottie.a> lottieListener = this.onLottieSuccessListener;
        if (lottieListener != null) {
            lottieListener.onResult(aVar);
        }
    }

    private static void replaceFailureListener(LottieAnimationView lottieAnimationView, LottieListener<Throwable> lottieListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443800081")) {
            ipChange.ipc$dispatch("443800081", new Object[]{lottieAnimationView, lottieListener});
        } else if (lottieAnimationView == null || lottieListener == null) {
        } else {
            try {
                Field a = com.alibaba.pictures.bricks.view.safelottiemonitor.a.b(LottieAnimationView.class, "failureListener").b(LottieListener.class).a();
                a.setAccessible(true);
                a.set(lottieAnimationView, lottieListener);
            } catch (Throwable th) {
                eh0.c(th);
            }
        }
    }

    private static void replaceSuccessListener(LottieAnimationView lottieAnimationView, LottieListener<com.airbnb.lottie.a> lottieListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170502666")) {
            ipChange.ipc$dispatch("170502666", new Object[]{lottieAnimationView, lottieListener});
        } else if (lottieAnimationView == null || lottieListener == null) {
        } else {
            try {
                Field a = com.alibaba.pictures.bricks.view.safelottiemonitor.a.b(LottieAnimationView.class, "loadedListener").b(LottieListener.class).a();
                a.setAccessible(true);
                a.set(lottieAnimationView, lottieListener);
            } catch (Throwable th) {
                eh0.c(th);
            }
        }
    }

    public String getLottieNetWorkUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "492597848") ? (String) ipChange.ipc$dispatch("492597848", new Object[]{this}) : this.mLottieNetWorkUrl;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606938628")) {
            ipChange.ipc$dispatch("-606938628", new Object[]{this, animator});
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502018893")) {
            ipChange.ipc$dispatch("-1502018893", new Object[]{this, animator});
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706636987")) {
            ipChange.ipc$dispatch("1706636987", new Object[]{this, animator});
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775546548")) {
            ipChange.ipc$dispatch("-1775546548", new Object[]{this, animator});
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685980260")) {
            ipChange.ipc$dispatch("-1685980260", new Object[]{this, canvas});
            return;
        }
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            this.failCount++;
            eh0.c(e);
            if (this.mListener != null) {
                this.mListener.onDrawLottieFail(e, this.failCount);
            }
            if (getDrawable() instanceof LottieDrawable) {
                ((LottieDrawable) getDrawable()).clearComposition();
                nd.a("onDraw:-error ", TAG);
            }
        }
    }

    @Override // android.view.View
    public void setAnimation(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099629302")) {
            ipChange.ipc$dispatch("-2099629302", new Object[]{this, animation});
            return;
        }
        super.setAnimation(animation);
        hackDefaultListener();
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimationFromUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-450990043")) {
            ipChange.ipc$dispatch("-450990043", new Object[]{this, str});
            return;
        }
        nd.a("setAnimationFromUrl: " + str + ";;env=" + this.lottieStatisticScene, TAG);
        hackDefaultListener();
        this.mLottieNetWorkUrl = str;
        super.setAnimationFromUrl(str);
    }

    public void setDrawFailListener(OnLottieDrawFailListener onLottieDrawFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521254342")) {
            ipChange.ipc$dispatch("-521254342", new Object[]{this, onLottieDrawFailListener});
        } else {
            this.mListener = onLottieDrawFailListener;
        }
    }

    public void setLottieStatisticScene(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084175243")) {
            ipChange.ipc$dispatch("1084175243", new Object[]{this, str});
            return;
        }
        this.lottieStatisticScene = str;
        setImageAssetsFolder(str);
    }

    public void setOnLottieSuccessListener(LottieListener<com.airbnb.lottie.a> lottieListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-706863690")) {
            ipChange.ipc$dispatch("-706863690", new Object[]{this, lottieListener});
        } else {
            this.onLottieSuccessListener = lottieListener;
        }
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.failCount = 0;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338123284")) {
            ipChange.ipc$dispatch("338123284", new Object[]{this, str});
            return;
        }
        hackDefaultListener();
        super.setAnimation(str);
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.failCount = 0;
    }
}
