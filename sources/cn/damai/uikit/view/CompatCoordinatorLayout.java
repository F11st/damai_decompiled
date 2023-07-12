package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CompatCoordinatorLayout extends CoordinatorLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private AppBarLayout mAppBar;

    public CompatCoordinatorLayout(Context context) {
        super(context);
    }

    private AppBarLayout findAppBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "560582592")) {
            return (AppBarLayout) ipChange.ipc$dispatch("560582592", new Object[]{this});
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof AppBarLayout) {
                return (AppBarLayout) childAt;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271199712")) {
            ipChange.ipc$dispatch("1271199712", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)});
            return;
        }
        if (i3 == 1 && i2 > 0 && (view instanceof RecyclerView)) {
            if (this.mAppBar == null) {
                this.mAppBar = findAppBar();
            }
            AppBarLayout appBarLayout = this.mAppBar;
            if (appBarLayout != null && appBarLayout.getVisibility() != 8) {
                RecyclerView recyclerView = (RecyclerView) view;
                ViewGroup.LayoutParams layoutParams = this.mAppBar.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                    if (behavior instanceof AppBarLayout.Behavior) {
                        if (Math.abs(((AppBarLayout.Behavior) behavior).getTopAndBottomOffset()) >= this.mAppBar.getTotalScrollRange()) {
                            recyclerView.stopNestedScroll(1);
                            return;
                        }
                    }
                }
            }
        }
        super.onNestedPreScroll(view, i, i2, iArr, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849909879")) {
            ipChange.ipc$dispatch("-1849909879", new Object[]{this, view, view2, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onNestedScrollAccepted(view, view2, i, i2);
        }
    }

    public CompatCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompatCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
