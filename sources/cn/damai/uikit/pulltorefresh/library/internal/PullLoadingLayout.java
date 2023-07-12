package cn.damai.uikit.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullLoadingLayout extends LoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    AnimationDrawable mHeaderImageAnimationDrawable;
    PullLoadingLayoutInferface pullLoadingLayoutInImp;

    public PullLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray, true);
        this.mHeaderImage.setBackgroundResource(R$drawable.uikit_pull_to_refresh_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mHeaderImage.getBackground();
        this.mHeaderImageAnimationDrawable = animationDrawable;
        animationDrawable.setOneShot(false);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608054769") ? ((Integer) ipChange.ipc$dispatch("-1608054769", new Object[]{this})).intValue() : R$drawable.uikit_pull_to_refresh_logo_0;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void onLoadingDrawableSet(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469446247")) {
            ipChange.ipc$dispatch("-1469446247", new Object[]{this, drawable});
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997673704")) {
            ipChange.ipc$dispatch("1997673704", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Log.e("PullLoadingLayout", "onPullImpl scaleOfLayout = " + f);
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.onPullImpl(f);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void pullToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71238157")) {
            ipChange.ipc$dispatch("-71238157", new Object[]{this});
            return;
        }
        this.mHeaderImageAnimationDrawable.start();
        Log.e("PullLoadingLayout", "pullToRefreshImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.pullToRefreshImpl();
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197388437")) {
            ipChange.ipc$dispatch("1197388437", new Object[]{this});
            return;
        }
        this.mHeaderImage.setVisibility(0);
        this.mHeaderProgress.setVisibility(8);
        Log.e("PullLoadingLayout", "refreshingImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.refreshingImpl();
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void releaseToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958571357")) {
            ipChange.ipc$dispatch("-958571357", new Object[]{this});
            return;
        }
        this.mHeaderImageAnimationDrawable.stop();
        Log.e("PullLoadingLayout", "releaseToRefreshImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.releaseToRefreshImpl();
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-706043329")) {
            ipChange.ipc$dispatch("-706043329", new Object[]{this});
            return;
        }
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
        Log.e("PullLoadingLayout", "resetImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.resetImpl();
        }
    }

    public void setPullLoadingLayoutInImp(PullLoadingLayoutInferface pullLoadingLayoutInferface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683221737")) {
            ipChange.ipc$dispatch("1683221737", new Object[]{this, pullLoadingLayoutInferface});
        } else {
            this.pullLoadingLayoutInImp = pullLoadingLayoutInferface;
        }
    }
}
