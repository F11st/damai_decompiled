package com.taobao.android.dinamicx.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int a;
    private int b;
    private int c;
    private int d;
    private boolean e;

    public SpaceItemDecoration(int i, int i2, int i3, int i4, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            if (layoutParams2.isFullSpan()) {
                if (this.e) {
                    rect.left = this.b;
                    rect.right = this.c;
                }
            } else if (this.d <= 0) {
            } else {
                int width = recyclerView.getWidth();
                int i = this.d;
                int i2 = width / i;
                int i3 = (((width - ((i - 1) * this.a)) - this.b) - this.c) / i;
                int spanIndex = layoutParams2.getSpanIndex();
                if (spanIndex == 0) {
                    rect.left = this.b;
                } else if (spanIndex == this.d - 1) {
                    rect.left = (i2 - this.c) - i3;
                } else {
                    int i4 = this.a;
                    rect.left = i4 - ((((i2 - i3) * spanIndex) - ((spanIndex - 1) * i4)) - this.b);
                }
            }
        }
    }
}
