package com.taobao.android.dinamicx.widget.recycler;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamic.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StickyItemDecoration extends RecyclerView.ItemDecoration {
    private StickyLayout a;
    private IStickyAdapter b;
    private SparseArray<List<RecyclerView.ViewHolder>> c = new SparseArray<>();
    private SparseArray<RecyclerView.ViewHolder> d = new SparseArray<>();
    private Set<Integer> e = new HashSet();
    private List<String> f = new ArrayList();

    private void b(Canvas canvas, RecyclerView recyclerView, View view, RecyclerView.Adapter adapter, int i, int i2) {
        View view2 = d(recyclerView, i, true).itemView;
        canvas.save();
        Rect rect = new Rect();
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().calculateItemDecorationsForChild(view, rect);
        }
        int paddingLeft = recyclerView.getPaddingLeft() + rect.left;
        int e = e(recyclerView, adapter.getItemCount(), view, view2, i, i2);
        int measuredHeight = view2.getMeasuredHeight() + e;
        if (measuredHeight <= 0 || e >= recyclerView.getMeasuredHeight()) {
            return;
        }
        if (g(i)) {
            String valueOf = String.valueOf(i);
            if (e == 0) {
                if (!this.f.contains(valueOf)) {
                    this.f.add(valueOf);
                    this.b.onStickyChange(i, true);
                }
            } else if (e > wt.Y() && this.f.contains(valueOf)) {
                this.f.remove(valueOf);
                this.b.onStickyChange(i, false);
            }
        }
        canvas.translate(paddingLeft, e);
        view2.draw(canvas);
        canvas.restore();
        view2.layout(paddingLeft, e, view2.getMeasuredWidth() + paddingLeft, measuredHeight);
    }

    private RecyclerView.ViewHolder c(int i) {
        return this.d.get(i);
    }

    private int e(RecyclerView recyclerView, int i, View view, View view2, int i2, int i3) {
        int height = view2.getHeight();
        int y = ((int) view.getY()) - height;
        int f = f(i2);
        if (i3 == 0) {
            int childCount = recyclerView.getChildCount();
            int stickyPosition = this.b.getStickyPosition(i2);
            int i4 = 1;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i4));
                if (childAdapterPosition == -1 || !this.b.hasPreSticky(childAdapterPosition) || stickyPosition == this.b.getStickyPosition(childAdapterPosition)) {
                    i4++;
                } else {
                    int y2 = ((int) recyclerView.getChildAt(i4).getY()) - (height + d(recyclerView, childAdapterPosition, false).itemView.getHeight());
                    if (y2 < 0) {
                        return y2;
                    }
                }
            }
            y = Math.max(f, y);
        }
        return Math.max(f, y);
    }

    private int f(int i) {
        IStickyAdapter iStickyAdapter = this.b;
        if (iStickyAdapter == null) {
            return 0;
        }
        return iStickyAdapter.getStickyOffset(i);
    }

    private boolean g(int i) {
        IStickyAdapter iStickyAdapter = this.b;
        return iStickyAdapter != null && iStickyAdapter.isSticky(i);
    }

    private void h(int i, RecyclerView.ViewHolder viewHolder) {
        this.d.put(i, viewHolder);
    }

    private void i(int i, RecyclerView.ViewHolder viewHolder) {
        this.d.remove(i);
        if (viewHolder == null) {
            return;
        }
        int itemViewType = this.b.getItemViewType(i);
        List<RecyclerView.ViewHolder> list = this.c.get(itemViewType);
        if (list == null) {
            list = new LinkedList<>();
            this.c.put(itemViewType, list);
        }
        list.add(viewHolder);
    }

    private void j() {
        ArrayList<View> arrayList = new ArrayList(0);
        for (int i = 0; i < this.a.getChildCount(); i++) {
            View childAt = this.a.getChildAt(i);
            int stickyPosition = this.b.getStickyPosition(((Integer) childAt.getTag(R$id.dx_recycler_sticky_key)).intValue());
            if (!this.e.contains(Integer.valueOf(stickyPosition))) {
                i(stickyPosition, (RecyclerView.ViewHolder) childAt.getTag(R$id.dx_recycler_sticky_holder));
                arrayList.add(childAt);
            }
        }
        for (View view : arrayList) {
            this.a.removeView(view);
        }
    }

    private void m(RecyclerView recyclerView) {
        this.e.clear();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i));
            if (g(childAdapterPosition) || (i == 0 && this.b.hasPreSticky(childAdapterPosition))) {
                this.e.add(Integer.valueOf(this.b.getStickyPosition(childAdapterPosition)));
            }
        }
        j();
    }

    public void a() {
        this.f.clear();
    }

    public RecyclerView.ViewHolder d(RecyclerView recyclerView, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int stickyPosition = this.b.getStickyPosition(i);
        RecyclerView.ViewHolder c = c(stickyPosition);
        List<Integer> stickChangedList = this.b.getStickChangedList();
        int indexOf = stickChangedList != null ? stickChangedList.indexOf(Integer.valueOf(stickyPosition)) : -1;
        RecyclerView.ViewHolder viewHolder = null;
        if (c != null && indexOf >= 0) {
            i(stickyPosition, c);
            c = null;
        }
        if (c == null) {
            List<RecyclerView.ViewHolder> list = this.c.get(this.b.getItemViewType(stickyPosition));
            if (list != null && list.size() > 0) {
                viewHolder = list.remove(0);
            }
            if (viewHolder == null) {
                IStickyAdapter iStickyAdapter = this.b;
                c = iStickyAdapter.onCreateViewHolder(recyclerView, iStickyAdapter.getItemViewType(stickyPosition));
            } else {
                c = viewHolder;
            }
            View view = c.itemView;
            view.setTag(R$id.dx_recycler_sticky_holder, c);
            view.setTag(R$id.dx_recycler_sticky_key, Integer.valueOf(stickyPosition));
            this.b.onBindStickyHolder(c, stickyPosition);
            if (indexOf >= 0) {
                stickChangedList.remove(indexOf);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                i3 = marginLayoutParams.leftMargin;
                i4 = marginLayoutParams.topMargin;
                i5 = marginLayoutParams.rightMargin;
                i2 = marginLayoutParams.bottomMargin;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((((recyclerView.getMeasuredWidth() - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()) - i3) - i5, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(i3, i4, view.getMeasuredWidth() + i5, view.getMeasuredHeight() + i2);
            h(stickyPosition, c);
        }
        if (z && c.itemView.getParent() == null && this.a != null) {
            this.a.addView(c.itemView, c.itemView.getLayoutParams());
        }
        return c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        rect.set(0, 0, 0, 0);
        if (recyclerView.getAdapter() == null || this.b == null) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        m(recyclerView);
        if (g(childAdapterPosition)) {
            RecyclerView.ViewHolder d = d(recyclerView, childAdapterPosition, true);
            ViewGroup.LayoutParams layoutParams = d.itemView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                i4 = marginLayoutParams.leftMargin;
                i2 = marginLayoutParams.topMargin;
                i3 = marginLayoutParams.rightMargin;
                i = marginLayoutParams.bottomMargin;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            rect.set(i4, d.itemView.getMeasuredHeight() - i2, i3, i);
        }
    }

    public void k(RecyclerView.Adapter adapter) {
        if (adapter instanceof IStickyAdapter) {
            this.b = (IStickyAdapter) adapter;
        }
    }

    public void l(StickyLayout stickyLayout) {
        this.a = stickyLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        if (this.b == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseStickyAdapter) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (g(childAdapterPosition) || (i == 0 && this.b.hasPreSticky(childAdapterPosition))) {
                    b(canvas, recyclerView, childAt, adapter, childAdapterPosition, i);
                }
            }
        }
    }
}
