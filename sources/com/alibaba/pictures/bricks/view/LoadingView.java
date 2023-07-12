package com.alibaba.pictures.bricks.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LoadingView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_COLOR_ICON = 0;
    public static final int TYPE_WHITE_ICON = 1;
    private ObjectAnimator animator;
    private ImageView loadingView;

    public LoadingView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255015749")) {
            ipChange.ipc$dispatch("-255015749", new Object[]{this});
            return;
        }
        FrameLayout.inflate(getContext(), R$layout.bricks_uikit_load_view, this);
        ImageView imageView = (ImageView) findViewById(R$id.uikit_loading_icon);
        this.loadingView = imageView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 90.0f);
        this.animator = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.animator.setDuration(666L);
        this.animator.start();
    }

    public void setImageDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910097635")) {
            ipChange.ipc$dispatch("-910097635", new Object[]{this, drawable});
            return;
        }
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511007462")) {
            ipChange.ipc$dispatch("-511007462", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setLoadingIconType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790811520")) {
            ipChange.ipc$dispatch("790811520", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void startLoading() {
        ObjectAnimator objectAnimator;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104845430")) {
            ipChange.ipc$dispatch("1104845430", new Object[]{this});
        } else if (this.loadingView == null || (objectAnimator = this.animator) == null) {
        } else {
            objectAnimator.start();
        }
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045797696")) {
            ipChange.ipc$dispatch("1045797696", new Object[]{this});
            return;
        }
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public LoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
