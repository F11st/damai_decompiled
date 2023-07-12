package com.alibaba.pictures.bricks.component.project.tour;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class GridItemBlankDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private Drawable a;
    private int b;
    private int c;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.project.tour.GridItemBlankDecoration$b */
    /* loaded from: classes7.dex */
    public static class C3492b {
        private static transient /* synthetic */ IpChange $ipChange;
        private Resources a;
        private int b = 0;
        private int c = 0;
        private int d = -1;

        public C3492b(Context context) {
            this.a = context.getResources();
        }

        public GridItemBlankDecoration a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1185105685") ? (GridItemBlankDecoration) ipChange.ipc$dispatch("1185105685", new Object[]{this}) : new GridItemBlankDecoration(this.b, this.c, this.d);
        }

        public C3492b b(@ColorInt int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-574588650")) {
                return (C3492b) ipChange.ipc$dispatch("-574588650", new Object[]{this, Integer.valueOf(i)});
            }
            this.d = i;
            return this;
        }

        public C3492b c(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1152087460")) {
                return (C3492b) ipChange.ipc$dispatch("-1152087460", new Object[]{this, Float.valueOf(f)});
            }
            this.b = (int) TypedValue.applyDimension(0, f, this.a.getDisplayMetrics());
            return this;
        }

        public C3492b d(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-921925238")) {
                return (C3492b) ipChange.ipc$dispatch("-921925238", new Object[]{this, Float.valueOf(f)});
            }
            this.c = (int) TypedValue.applyDimension(0, f, this.a.getDisplayMetrics());
            return this;
        }
    }

    private boolean a(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580087685")) {
            return ((Boolean) ipChange.ipc$dispatch("1580087685", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        }
        int i4 = i3 % i2;
        if (i4 == 0) {
            if (i >= i3 - i2) {
                return true;
            }
        } else if (i >= i3 - i4) {
            return true;
        }
        return false;
    }

    private int b(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1478428892")) {
            return ((Integer) ipChange.ipc$dispatch("-1478428892", new Object[]{this, recyclerView})).intValue();
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private boolean c(RecyclerView recyclerView, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900390845")) {
            return ((Boolean) ipChange.ipc$dispatch("900390845", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return a(i, i2, i3);
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                return a(i, i2, i3);
            }
            if ((i + 1) % i2 == 0) {
                return true;
            }
        }
        return false;
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255749377")) {
            ipChange.ipc$dispatch("-255749377", new Object[]{this, canvas, recyclerView});
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!c(recyclerView, i, b(recyclerView), childCount)) {
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                this.a.setBounds(childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, bottom, childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, this.b + bottom);
                this.a.draw(canvas);
            }
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804960659")) {
            ipChange.ipc$dispatch("-804960659", new Object[]{this, canvas, recyclerView});
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if ((recyclerView.getChildViewHolder(childAt).getAdapterPosition() + 1) % b(recyclerView) != 0) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.b;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                this.a.setBounds(right, top, this.c + right, bottom);
                this.a.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591225482")) {
            ipChange.ipc$dispatch("591225482", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        int b = b(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (viewLayoutPosition < 0) {
            return;
        }
        int i = viewLayoutPosition % b;
        int i2 = this.c;
        rect.set((i * i2) / b, 0, i2 - (((i + 1) * i2) / b), !c(recyclerView, viewLayoutPosition, b, itemCount) ? this.b : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751673306")) {
            ipChange.ipc$dispatch("751673306", new Object[]{this, canvas, recyclerView, state});
            return;
        }
        drawHorizontal(canvas, recyclerView);
        drawVertical(canvas, recyclerView);
    }

    private GridItemBlankDecoration(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.a = new ColorDrawable(i3);
    }
}
