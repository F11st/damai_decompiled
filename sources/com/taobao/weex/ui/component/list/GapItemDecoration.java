package com.taobao.weex.ui.component.list;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GapItemDecoration extends RecyclerView.ItemDecoration {
    private WXListComponent listComponent;

    public GapItemDecoration(WXListComponent wXListComponent) {
        this.listComponent = wXListComponent;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition;
        Float[] spanOffsets = this.listComponent.getSpanOffsets();
        if (spanOffsets != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(view)) >= 0 && (view.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            if (layoutParams.isFullSpan()) {
                return;
            }
            WXComponent child = this.listComponent.getChild(childAdapterPosition);
            if (child instanceof WXCell) {
                WXCell wXCell = (WXCell) child;
                if (wXCell.isFixed() || wXCell.isSticky() || layoutParams.getSpanIndex() >= spanOffsets.length) {
                    return;
                }
                int round = Math.round(WXViewUtils.getRealPxByWidth(this.listComponent.getSpanOffsets()[this.listComponent.isLayoutRTL() ? (spanOffsets.length - layoutParams.getSpanIndex()) - 1 : layoutParams.getSpanIndex()].floatValue(), this.listComponent.getViewPortWidth()));
                if (this.listComponent.isLayoutRTL()) {
                    rect.left = -round;
                    rect.right = round;
                    return;
                }
                rect.left = round;
                rect.right = -round;
            }
        }
    }
}
