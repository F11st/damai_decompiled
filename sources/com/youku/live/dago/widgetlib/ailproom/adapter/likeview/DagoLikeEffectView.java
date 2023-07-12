package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLikeEffectView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoLikeEffectView";
    private ImageView mBgIv;
    private int mBgSize;
    private String mBubbleUrl;
    private Bitmap mCurrentRes;
    private int[] mEndPos;
    private ImageView mHeartIv;
    private ViewGroup mRootView;
    private int mSize;
    private int[] mStartPos;

    public DagoLikeEffectView(ViewGroup viewGroup, DagoLikeEffectParams dagoLikeEffectParams) {
        super(viewGroup.getContext());
        this.mSize = UIUtil.dip2px(50);
        this.mBgSize = UIUtil.dip2px(80);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "DagoLikeEffectView init");
        this.mRootView = viewGroup;
        this.mStartPos = dagoLikeEffectParams.getStartPos();
        this.mEndPos = dagoLikeEffectParams.getEndPos();
        this.mCurrentRes = dagoLikeEffectParams.getResources();
        this.mBubbleUrl = dagoLikeEffectParams.getBubbleUrl();
        initView();
        performHapticFeedback(0, 2);
    }

    private void addHeartInView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804355060")) {
            ipChange.ipc$dispatch("-804355060", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "DagoLikeEffectView addHeartView");
        if (this.mRootView != null) {
            int i = this.mBgSize;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            int[] iArr = this.mStartPos;
            int i2 = iArr[0];
            int i3 = this.mBgSize;
            layoutParams.leftMargin = i2 - (i3 / 2);
            layoutParams.topMargin = iArr[1] - (i3 / 2);
            setLayoutParams(layoutParams);
            this.mRootView.addView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHeartOutView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1050682721")) {
            ipChange.ipc$dispatch("1050682721", new Object[]{this});
            return;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(this.mHeartIv.getDrawable());
        imageView.setRotation(-5.0f);
        int i = this.mSize;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.addView(imageView, layoutParams);
            this.mRootView.removeView(this);
            playOutAnim(imageView);
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572311834")) {
            ipChange.ipc$dispatch("-1572311834", new Object[]{this});
            return;
        }
        setClipChildren(false);
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        this.mHeartIv = new ImageView(getContext());
        this.mBgIv = new ImageView(getContext());
        this.mHeartIv.setImageBitmap(this.mCurrentRes);
        int i = this.mBgSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        addView(this.mBgIv, layoutParams);
        int i2 = this.mSize;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
        layoutParams2.gravity = 17;
        addView(this.mHeartIv, layoutParams2);
        addHeartInView();
    }

    private void playOutAnim(final ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724595326")) {
            ipChange.ipc$dispatch("724595326", new Object[]{this, imageView});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "DagoLikeEffectView playOutAnim");
        int[] iArr = this.mStartPos;
        int i = this.mSize;
        PointF pointF = new PointF(iArr[0] - (i / 2.0f), iArr[1] - (i / 2.0f));
        int[] iArr2 = this.mEndPos;
        PointF pointF2 = new PointF(iArr2[0], iArr2[1]);
        PointF pointF3 = new PointF(pointF2.x, pointF.y);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 0.2f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 0.2f);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(imageView, "mPointF", new PointFTypeEvaluator(pointF3), pointF, pointF2);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1690254817")) {
                    ipChange2.ipc$dispatch("1690254817", new Object[]{this, valueAnimator});
                    return;
                }
                PointF pointF4 = (PointF) valueAnimator.getAnimatedValue();
                imageView.setX(pointF4.x);
                imageView.setY(pointF4.y);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofObject, ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(1500L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1001245935")) {
                    ipChange2.ipc$dispatch("-1001245935", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                if (DagoLikeEffectView.this.mRootView != null) {
                    DagoLikeEffectView.this.mRootView.removeView(imageView);
                }
                DagoLikeEffectView.this.release();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700000744")) {
            ipChange.ipc$dispatch("1700000744", new Object[]{this});
            return;
        }
        ImageView imageView = this.mHeartIv;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.mHeartIv = null;
        }
        ImageView imageView2 = this.mBgIv;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.mBgIv = null;
        }
        this.mStartPos = null;
        this.mEndPos = null;
    }

    public void play() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391880665")) {
            ipChange.ipc$dispatch("-391880665", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "DagoLikeEffectView playInAnim");
        setRotation(-10.0f);
        ur1.o().s(this.mBubbleUrl).y(this.mBgIv);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleX", 0.2f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "scaleY", 0.2f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "rotation", -10.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "rotation", 0.0f, -5.0f);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(100L);
        ofFloat5.setDuration(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.play(ofFloat4).after(ofFloat);
        animatorSet.play(ofFloat5).after(ofFloat4);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-985727217")) {
                    ipChange2.ipc$dispatch("-985727217", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                DagoLikeEffectView.this.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectView.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "450917450")) {
                            ipChange3.ipc$dispatch("450917450", new Object[]{this});
                        } else {
                            DagoLikeEffectView.this.addHeartOutView();
                        }
                    }
                }, 200L);
            }
        });
    }
}
