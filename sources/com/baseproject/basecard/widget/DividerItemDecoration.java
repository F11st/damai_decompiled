package com.baseproject.basecard.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private Drawable a;
    private int b;
    private int c;
    private Paint d;

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            int intrinsicHeight = this.a.getIntrinsicHeight() + bottom;
            int i2 = this.c;
            if (i2 > 0) {
                this.a.setBounds(paddingLeft + i2, bottom, width - i2, intrinsicHeight);
            } else {
                this.a.setBounds(paddingLeft, bottom, width, intrinsicHeight);
            }
            this.a.draw(canvas);
            float f = bottom;
            float f2 = intrinsicHeight;
            canvas.drawRect(0.0f, f, this.c, f2, this.d);
            canvas.drawRect(width - this.c, f, width, f2, this.d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        Drawable drawable = this.a;
        if (drawable != null) {
            if (this.b == 1) {
                rect.set(0, 0, 0, drawable.getIntrinsicHeight());
            } else {
                rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.b == 1) {
            drawVertical(canvas, recyclerView);
        }
    }
}
