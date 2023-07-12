package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayControlButton extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isAnimCycle;
    private Runnable mClearAnimation;
    private int mCurResourceId;
    private AnimationDrawable mPlayControlAnim;

    public PlayControlButton(Context context) {
        super(context);
        this.mClearAnimation = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.view.PlayControlButton.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1478563826")) {
                    ipChange.ipc$dispatch("-1478563826", new Object[]{this});
                } else {
                    PlayControlButton.this.clear();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1202296825")) {
            ipChange.ipc$dispatch("1202296825", new Object[]{this});
            return;
        }
        AnimationDrawable animationDrawable = this.mPlayControlAnim;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.mPlayControlAnim = null;
            clearAnimation();
        }
        removeCallbacks(this.mClearAnimation);
    }

    private boolean isAnimDrawableAnimEnd(AnimationDrawable animationDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931041755")) {
            return ((Boolean) ipChange.ipc$dispatch("931041755", new Object[]{this, animationDrawable})).booleanValue();
        }
        if (animationDrawable == null || animationDrawable.getNumberOfFrames() <= 0) {
            return true;
        }
        try {
            return animationDrawable.getCurrent() == animationDrawable.getFrame(animationDrawable.getNumberOfFrames() - 1);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setAnimResource(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846281957")) {
            ipChange.ipc$dispatch("846281957", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i == this.mCurResourceId && this.isAnimCycle) {
            setLastFrame(i2);
        } else {
            this.isAnimCycle = false;
            setImageResource(i);
            this.mCurResourceId = i;
            startAnimation();
            this.isAnimCycle = true;
        }
    }

    public void setLastFrame(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391734572")) {
            ipChange.ipc$dispatch("-391734572", new Object[]{this, Integer.valueOf(i)});
        } else if (isAnimDrawableAnimEnd(this.mPlayControlAnim)) {
            clear();
            setImageResource(i);
        }
    }

    public void setResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466397267")) {
            ipChange.ipc$dispatch("-1466397267", new Object[]{this, Integer.valueOf(i)});
        } else {
            setImageResource(i);
        }
    }

    public void startAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221027294")) {
            ipChange.ipc$dispatch("-221027294", new Object[]{this});
            return;
        }
        clear();
        try {
            this.mPlayControlAnim = (AnimationDrawable) getDrawable();
        } catch (Exception unused) {
            this.mPlayControlAnim = null;
        }
        AnimationDrawable animationDrawable = this.mPlayControlAnim;
        if (animationDrawable == null || animationDrawable.isRunning()) {
            return;
        }
        this.mPlayControlAnim.start();
    }

    public void stopAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025124729")) {
            ipChange.ipc$dispatch("-1025124729", new Object[]{this});
            return;
        }
        clear();
        this.mCurResourceId = -1;
    }

    public PlayControlButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClearAnimation = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.view.PlayControlButton.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1478563826")) {
                    ipChange.ipc$dispatch("-1478563826", new Object[]{this});
                } else {
                    PlayControlButton.this.clear();
                }
            }
        };
    }

    public PlayControlButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClearAnimation = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.view.PlayControlButton.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1478563826")) {
                    ipChange.ipc$dispatch("-1478563826", new Object[]{this});
                } else {
                    PlayControlButton.this.clear();
                }
            }
        };
    }
}
