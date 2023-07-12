package com.youku.live.livesdk.widgets.container.pagable;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RestrictedPagerSnapHelper extends PagerSnapHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView mRecyclerView;

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450317955")) {
            ipChange.ipc$dispatch("450317955", new Object[]{this, recyclerView});
            return;
        }
        super.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        View findSnapView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535552656")) {
            return ((Integer) ipChange.ipc$dispatch("-1535552656", new Object[]{this, layoutManager, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, i, i2);
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (findSnapView = findSnapView(layoutManager)) != null) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(findSnapView);
            int i3 = childAdapterPosition + 1;
            if (findTargetSnapPosition > i3) {
                return i3;
            }
            int i4 = childAdapterPosition - 1;
            return findTargetSnapPosition < i4 ? i4 : findTargetSnapPosition;
        }
        return findTargetSnapPosition;
    }
}
