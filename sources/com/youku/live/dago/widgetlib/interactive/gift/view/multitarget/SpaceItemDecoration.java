package com.youku.live.dago.widgetlib.interactive.gift.view.multitarget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "SpaceItemDecoration";
    private int space;

    public SpaceItemDecoration(int i) {
        this.space = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199982539")) {
            ipChange.ipc$dispatch("-199982539", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        int i = this.space;
        rect.left = i;
        rect.right = i;
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = 0;
        } else {
            rect.left = this.space;
        }
        if (recyclerView.getChildLayoutPosition(view) == recyclerView.getLayoutManager().getItemCount() - 1) {
            rect.right = 0;
        } else {
            rect.right = this.space;
        }
    }
}
