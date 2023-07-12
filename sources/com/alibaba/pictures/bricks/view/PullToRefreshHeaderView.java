package com.alibaba.pictures.bricks.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jg2;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PullToRefreshHeaderView extends FrameLayout implements RefreshTrigger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_HEADER_VIEW_HEIGHT = 70;
    private static boolean mIsImmersion;
    private static int mRefreshViweHeightUnitDp;
    private ImageView mAnimView;
    private AnimationDrawable mAnimationDrawable;
    private AnimationDrawable mAnimationStartDrawable;
    private boolean mCanAnimate;
    private ImageView mDefaultView;
    private int mHeight;
    private PullToRefreshListener mListener;
    private int statusHeight;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface PullToRefreshListener {
        void onComplete();

        void onMove(boolean z, boolean z2, int i, boolean z3);
    }

    public PullToRefreshHeaderView(Context context) {
        this(context, null);
    }

    public static PullToRefreshHeaderView getInstance(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1967642073") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("1967642073", new Object[]{context}) : getInstance(context, false);
    }

    private void initStatuBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882345172")) {
            ipChange.ipc$dispatch("-1882345172", new Object[]{this, activity});
        } else if (mIsImmersion) {
            View findViewById = findViewById(R$id.status_bar_space);
            if (Build.VERSION.SDK_INT < 23) {
                this.statusHeight = 0;
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            } else if (findViewById != null) {
                this.statusHeight = jg2.a(activity);
                findViewById.getLayoutParams().height = this.statusHeight;
                findViewById.setVisibility(0);
            }
        }
    }

    public void clearLoadingDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584159889")) {
            ipChange.ipc$dispatch("-1584159889", new Object[]{this});
            return;
        }
        this.mAnimationDrawable = null;
        ImageView imageView = this.mAnimView;
        int i = R$drawable.bricks_transparent_bg;
        imageView.setBackgroundResource(i);
        this.mDefaultView.setImageResource(i);
        setBackgroundResource(i);
        this.mCanAnimate = false;
    }

    public int getRefreshLayoutHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1600008377") ? ((Integer) ipChange.ipc$dispatch("1600008377", new Object[]{this})).intValue() : getMeasuredHeight();
    }

    public int getStatusHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1619223694") ? ((Integer) ipChange.ipc$dispatch("-1619223694", new Object[]{this})).intValue() : this.statusHeight;
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396459012")) {
            ipChange.ipc$dispatch("396459012", new Object[]{this});
            return;
        }
        this.mDefaultView.setVisibility(0);
        this.mAnimView.setVisibility(4);
        PullToRefreshListener pullToRefreshListener = this.mListener;
        if (pullToRefreshListener != null) {
            pullToRefreshListener.onComplete();
        }
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onMove(boolean z, boolean z2, int i) {
        PullToRefreshListener pullToRefreshListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866661225")) {
            ipChange.ipc$dispatch("-1866661225", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
            return;
        }
        int i2 = this.mHeight;
        float f = (i / i2) * 25.0f;
        if (i >= i2) {
            this.mDefaultView.setVisibility(4);
            this.mAnimView.setVisibility(0);
            if (this.mCanAnimate && !this.mAnimationDrawable.isRunning()) {
                this.mAnimationDrawable.start();
            }
        } else {
            this.mDefaultView.setVisibility(0);
            this.mDefaultView.setImageDrawable(this.mAnimationStartDrawable.getFrame(Math.min(Math.round(f), 25)));
            this.mAnimView.setVisibility(4);
            if (this.mCanAnimate && this.mAnimationDrawable.isRunning()) {
                this.mAnimationDrawable.stop();
            }
        }
        if (z) {
            return;
        }
        if (i >= this.mHeight && (pullToRefreshListener = this.mListener) != null) {
            pullToRefreshListener.onMove(z, z2, i, true);
            return;
        }
        PullToRefreshListener pullToRefreshListener2 = this.mListener;
        if (pullToRefreshListener2 != null) {
            pullToRefreshListener2.onMove(z, z2, i, false);
        }
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647749970")) {
            ipChange.ipc$dispatch("647749970", new Object[]{this});
            return;
        }
        this.mDefaultView.setVisibility(4);
        this.mAnimView.setVisibility(0);
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547541850")) {
            ipChange.ipc$dispatch("-547541850", new Object[]{this});
        }
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493526434")) {
            ipChange.ipc$dispatch("-1493526434", new Object[]{this});
            return;
        }
        this.mDefaultView.setVisibility(0);
        this.mAnimView.setVisibility(4);
        if (this.mCanAnimate && this.mAnimationDrawable.isRunning()) {
            this.mAnimationDrawable.stop();
        }
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onStart(boolean z, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166581225")) {
            ipChange.ipc$dispatch("1166581225", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.mHeight = i;
        }
    }

    public void setBackgroundColorBg(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90622399")) {
            ipChange.ipc$dispatch("90622399", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mAnimView.setBackgroundColor(i);
        this.mAnimView.setImageDrawable(null);
        this.mDefaultView.setBackgroundColor(i);
        this.mDefaultView.setImageDrawable(null);
        setBackgroundColor(i);
    }

    public void setImmersion(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638729217")) {
            ipChange.ipc$dispatch("638729217", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        mIsImmersion = z;
        initStatuBar((Activity) getContext());
    }

    public void setPullToRefreshListener(PullToRefreshListener pullToRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680589172")) {
            ipChange.ipc$dispatch("-1680589172", new Object[]{this, pullToRefreshListener});
        } else {
            this.mListener = pullToRefreshListener;
        }
    }

    public PullToRefreshHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static PullToRefreshHeaderView getInstance(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "938578607") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("938578607", new Object[]{context, Boolean.valueOf(z)}) : getInstance(context, z, 17170445);
    }

    public PullToRefreshHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.statusHeight = 0;
        FrameLayout.inflate(context, R$layout.bricks_pull_to_refresh_layout, this);
        this.mDefaultView = (ImageView) findViewById(R$id.pull_to_refresh_default_view);
        ImageView imageView = (ImageView) findViewById(R$id.pull_to_refresh_anim_view);
        this.mAnimView = imageView;
        imageView.setBackgroundResource(R$drawable.bricks_uikit_pull_to_refresh_loading);
        this.mDefaultView.setBackgroundResource(R$drawable.bricks_uikit_pull_to_refresh_starting);
        this.mAnimationStartDrawable = (AnimationDrawable) this.mDefaultView.getBackground();
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mAnimView.getBackground();
        this.mAnimationDrawable = animationDrawable;
        animationDrawable.setOneShot(false);
        this.mCanAnimate = true;
        initStatuBar((Activity) context);
        ((FrameLayout) findViewById(R$id.pull_to_refresh_view_layout)).setLayoutParams(new LinearLayout.LayoutParams(-1, s60.INSTANCE.b(context, mRefreshViweHeightUnitDp)));
    }

    public static PullToRefreshHeaderView getInstance(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-776924832") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("-776924832", new Object[]{context, Integer.valueOf(i)}) : getInstance(context, false, i);
    }

    public static PullToRefreshHeaderView getInstance(Context context, boolean z, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1681846090") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("1681846090", new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) : getInstance(context, 70, z, i);
    }

    public static PullToRefreshHeaderView getInstance(Context context, int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262970129")) {
            return (PullToRefreshHeaderView) ipChange.ipc$dispatch("1262970129", new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        mIsImmersion = z;
        mRefreshViweHeightUnitDp = i;
        PullToRefreshHeaderView pullToRefreshHeaderView = new PullToRefreshHeaderView(context);
        pullToRefreshHeaderView.setBackgroundResource(i2);
        return pullToRefreshHeaderView;
    }
}
