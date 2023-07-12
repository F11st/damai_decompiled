package cn.damai.uikit.view.state;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.pr1;
import tb.qr1;
import tb.rr1;
import tb.sr1;
import tb.tr1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AnimationStateView extends View implements ValueAnimator.AnimatorUpdateListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isAttachedToWindow;
    private ValueAnimator mAnimator;
    private int mBgColor;
    private final List<PhaseDrawable> mDrawableList;
    private int mLastAnimateValue;
    private float scale;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface PhaseDrawable {
        void draw(Canvas canvas, AnimationStateView animationStateView);

        void setPhase(int i);
    }

    public AnimationStateView(Context context) {
        this(context, null);
    }

    private boolean isAllowAnimation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2100160934") ? ((Boolean) ipChange.ipc$dispatch("2100160934", new Object[]{this})).booleanValue() : this.isAttachedToWindow && getVisibility() == 0;
    }

    public void cancelAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450418297")) {
            ipChange.ipc$dispatch("1450418297", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370455105")) {
            ipChange.ipc$dispatch("-1370455105", new Object[]{this, valueAnimator});
        } else if (!isAllowAnimation()) {
            cancelAnimation();
        } else if (this.mDrawableList.size() > 0 && this.mLastAnimateValue != (intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue())) {
            this.mLastAnimateValue = intValue;
            float f = intValue > 50 ? 1.5f - (((intValue - 50) * 0.5f) / 50.0f) : ((intValue * 0.5f) / 50.0f) + 1.0f;
            float f2 = f >= 1.0f ? f : 1.0f;
            this.scale = f2 <= 1.5f ? f2 : 1.5f;
            for (PhaseDrawable phaseDrawable : this.mDrawableList) {
                phaseDrawable.setPhase(intValue);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589692807")) {
            ipChange.ipc$dispatch("-1589692807", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        if (isAllowAnimation()) {
            playAnimation();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404018012")) {
            ipChange.ipc$dispatch("404018012", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        cancelAnimation();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692370879")) {
            ipChange.ipc$dispatch("-1692370879", new Object[]{this, canvas});
            return;
        }
        canvas.save();
        float f = this.scale;
        canvas.scale(f, f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawColor(-1);
        for (PhaseDrawable phaseDrawable : this.mDrawableList) {
            phaseDrawable.draw(canvas, this);
        }
        canvas.restore();
    }

    public void pauseAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223184729")) {
            ipChange.ipc$dispatch("1223184729", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.mAnimator.pause();
                return;
            }
            return;
        }
        cancelAnimation();
    }

    public void playAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731508659")) {
            ipChange.ipc$dispatch("1731508659", new Object[]{this});
            return;
        }
        cancelAnimation();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        this.mAnimator = ofInt;
        ofInt.setDuration(DanmakuFactory.MIN_DANMAKU_DURATION);
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setRepeatMode(2);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(this);
        this.mAnimator.start();
        this.mAnimator.start();
    }

    public void resumeAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615283628")) {
            ipChange.ipc$dispatch("1615283628", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 19) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator == null || !valueAnimator.isPaused()) {
                return;
            }
            this.mAnimator.resume();
        } else {
            playAnimation();
        }
    }

    public void setAnimation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "337917135")) {
            ipChange.ipc$dispatch("337917135", new Object[]{this, str});
        }
    }

    public void setImageAssetsFolder(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "730709639")) {
            ipChange.ipc$dispatch("730709639", new Object[]{this, str});
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751153684")) {
            ipChange.ipc$dispatch("1751153684", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setVisibility(i);
        if (i == 0) {
            playAnimation();
        } else {
            cancelAnimation();
        }
    }

    public AnimationStateView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationStateView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ArrayList arrayList = new ArrayList();
        this.mDrawableList = arrayList;
        this.scale = 1.0f;
        this.isAttachedToWindow = false;
        this.mBgColor = Color.parseColor("#D4C8FF");
        arrayList.add(new pr1(context));
        arrayList.add(new qr1(context));
        arrayList.add(new rr1(context));
        arrayList.add(new sr1(context));
        arrayList.add(new tr1(context));
        Collections.reverse(arrayList);
    }
}
