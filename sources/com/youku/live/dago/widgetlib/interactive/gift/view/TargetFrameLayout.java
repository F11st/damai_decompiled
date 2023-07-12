package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TargetFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View mTargetView;
    private int mTargetViewId;

    public TargetFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "612304724")) {
            ipChange.ipc$dispatch("612304724", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        setSelected(isSelected());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972397990")) {
            ipChange.ipc$dispatch("1972397990", new Object[]{this, view});
            return;
        }
        super.onViewAdded(view);
        if (this.mTargetViewId == -1 || view.getId() != this.mTargetViewId) {
            return;
        }
        this.mTargetView = view;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38497015")) {
            ipChange.ipc$dispatch("-38497015", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setSelected(z);
        View view = this.mTargetView;
        if (view != null) {
            if (z) {
                this.mTargetView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_gift_item_selected_anim));
            } else {
                view.clearAnimation();
            }
        }
    }

    public TargetFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TargetFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTargetViewId = -1;
        this.mTargetView = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TargetFrameLayout);
        this.mTargetViewId = obtainStyledAttributes.getResourceId(R.styleable.TargetFrameLayout_target_view, -1);
        obtainStyledAttributes.recycle();
    }
}
