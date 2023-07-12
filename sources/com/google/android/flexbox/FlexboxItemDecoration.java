package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    private static final int[] c = {16843284};
    private Drawable a;
    private int b;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i;
        int i2;
        int i3;
        if (d()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left2 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = recyclerView.getChildAt(i4);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.a.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.a.getIntrinsicHeight();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager.y()) {
                        i2 = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.a.getIntrinsicWidth(), right2);
                        i3 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        this.a.setBounds(i3, intrinsicHeight, i2, top);
                        this.a.draw(canvas);
                    } else {
                        left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.a.getIntrinsicWidth(), left2);
                        right = childAt.getRight();
                        i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i5 = left;
                i2 = right + i;
                i3 = i5;
                this.a.setBounds(i3, intrinsicHeight, i2, top);
                this.a.draw(canvas);
            }
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i;
        int i2;
        if (e()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.y()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.a.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.a.getIntrinsicHeight(), bottom2);
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i2 = min;
                    this.a.setBounds(intrinsicWidth, max, left, i2);
                    this.a.draw(canvas);
                } else {
                    max = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.a.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i2 = bottom + i;
                this.a.setBounds(intrinsicWidth, max, left, i2);
                this.a.draw(canvas);
            }
        }
    }

    private boolean c(int i, List<a> list, FlexboxLayoutManager flexboxLayoutManager) {
        int v = flexboxLayoutManager.v(i);
        if ((v == -1 || v >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(v).o != i) && i != 0) {
            return list.size() != 0 && list.get(list.size() - 1).p == i - 1;
        }
        return true;
    }

    private boolean d() {
        return (this.b & 1) > 0;
    }

    private boolean e() {
        return (this.b & 2) > 0;
    }

    private void f(Rect rect, int i, FlexboxLayoutManager flexboxLayoutManager, List<a> list) {
        if (list.size() == 0 || flexboxLayoutManager.v(i) == 0) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!d()) {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
            rect.top = this.a.getIntrinsicHeight();
            rect.bottom = 0;
        } else if (e()) {
            if (flexboxLayoutManager.y()) {
                rect.right = this.a.getIntrinsicWidth();
                rect.left = 0;
                return;
            }
            rect.left = this.a.getIntrinsicWidth();
            rect.right = 0;
        }
    }

    private void g(Rect rect, int i, FlexboxLayoutManager flexboxLayoutManager, List<a> list, int i2) {
        if (c(i, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!e()) {
                rect.left = 0;
                rect.right = 0;
            } else if (flexboxLayoutManager.y()) {
                rect.right = this.a.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.a.getIntrinsicWidth();
                rect.right = 0;
            }
        } else if (!d()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i2 == 3) {
            rect.bottom = this.a.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.a.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!d() && !e()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List<a> flexLines = flexboxLayoutManager.getFlexLines();
        g(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        f(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    public void setOrientation(int i) {
        this.b = i;
    }
}
