package com.alibaba.pictures.bricks.view.irecycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$anim;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$string;
import com.alibaba.pictures.bricks.view.RefreshTrigger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PullToRefreshArrowLoadingView extends FrameLayout implements RefreshTrigger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_HEADER_VIEW_HEIGHT = 70;
    private ImageView mArrow;
    private int mHeight;
    private ProgressBar mProgressBar;
    private TextView mRefreshText;
    private Animation mRotateDown;
    private Animation mRotateUp;
    private boolean mRotated;

    public PullToRefreshArrowLoadingView(Context context) {
        this(context, null);
    }

    public static PullToRefreshArrowLoadingView getInstance(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36283557")) {
            return (PullToRefreshArrowLoadingView) ipChange.ipc$dispatch("-36283557", new Object[]{context});
        }
        PullToRefreshArrowLoadingView pullToRefreshArrowLoadingView = new PullToRefreshArrowLoadingView(context);
        pullToRefreshArrowLoadingView.setLayoutParams(new LinearLayout.LayoutParams(-1, s60.INSTANCE.b(context, 70)));
        return pullToRefreshArrowLoadingView;
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992364803")) {
            ipChange.ipc$dispatch("992364803", new Object[]{this});
            return;
        }
        this.mRotated = false;
        this.mArrow.clearAnimation();
        this.mArrow.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mRefreshText.setText(getResources().getString(R$string.bricks_pull_to_refresh_text));
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onMove(boolean z, boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184870472")) {
            ipChange.ipc$dispatch("-184870472", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
        } else if (z) {
        } else {
            this.mArrow.setVisibility(0);
            this.mProgressBar.setVisibility(8);
            if (i <= this.mHeight) {
                if (this.mRotated) {
                    this.mArrow.clearAnimation();
                    this.mArrow.startAnimation(this.mRotateDown);
                    this.mRotated = false;
                }
                this.mRefreshText.setText(getResources().getString(R$string.bricks_pull_to_refresh_text));
                return;
            }
            this.mRefreshText.setText(getResources().getString(R$string.bricks_release_to_refresh_text));
            if (this.mRotated) {
                return;
            }
            this.mArrow.clearAnimation();
            this.mArrow.startAnimation(this.mRotateUp);
            this.mRotated = true;
        }
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1965426573")) {
            ipChange.ipc$dispatch("-1965426573", new Object[]{this});
            return;
        }
        this.mArrow.clearAnimation();
        this.mArrow.setVisibility(8);
        this.mProgressBar.setVisibility(0);
        this.mRefreshText.setText(getResources().getString(R$string.bricks_loading_text));
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134248903")) {
            ipChange.ipc$dispatch("1134248903", new Object[]{this});
        }
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1201273921")) {
            ipChange.ipc$dispatch("-1201273921", new Object[]{this});
            return;
        }
        this.mRotated = false;
        this.mArrow.clearAnimation();
        this.mArrow.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
    public void onStart(boolean z, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762487016")) {
            ipChange.ipc$dispatch("1762487016", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mHeight = i;
        this.mProgressBar.setIndeterminate(false);
    }

    public PullToRefreshArrowLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToRefreshArrowLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotated = false;
        FrameLayout.inflate(context, R$layout.bricks_pull_to_refresh_arrow_loading_layout, this);
        this.mArrow = (ImageView) findViewById(R$id.pull_to_refresh_arrow_icon);
        this.mProgressBar = (ProgressBar) findViewById(R$id.pull_to_refresh_arrow_loading_progress);
        this.mRefreshText = (TextView) findViewById(R$id.pull_to_refresh_status_text);
        this.mRotateUp = AnimationUtils.loadAnimation(context, R$anim.bricks_rotate_up);
        this.mRotateDown = AnimationUtils.loadAnimation(context, R$anim.bricks_rotate_down);
    }
}
