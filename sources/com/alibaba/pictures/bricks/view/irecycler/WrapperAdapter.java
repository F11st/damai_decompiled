package com.alibaba.pictures.bricks.view.irecycler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final RecyclerView.Adapter a;
    private final RefreshHeaderLayout b;
    private final FrameLayout c;
    private final LinearLayout d;
    private final LinearLayout e;
    private FullSpanTypeChecker f;
    private RecyclerView.AdapterDataObserver g;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface FullSpanTypeChecker {
        boolean isTypeFullSpan(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.irecycler.WrapperAdapter$a */
    /* loaded from: classes7.dex */
    static class C3592a extends RecyclerView.ViewHolder {
        public C3592a(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.irecycler.WrapperAdapter$b */
    /* loaded from: classes7.dex */
    static class C3593b extends RecyclerView.ViewHolder {
        public C3593b(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.irecycler.WrapperAdapter$c */
    /* loaded from: classes7.dex */
    static class C3594c extends RecyclerView.ViewHolder {
        public C3594c(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.irecycler.WrapperAdapter$d */
    /* loaded from: classes7.dex */
    static class C3595d extends RecyclerView.ViewHolder {
        public C3595d(View view) {
            super(view);
        }
    }

    public WrapperAdapter(RecyclerView.Adapter adapter, RefreshHeaderLayout refreshHeaderLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout) {
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alibaba.pictures.bricks.view.irecycler.WrapperAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1814713854")) {
                    ipChange.ipc$dispatch("-1814713854", new Object[]{this});
                } else {
                    WrapperAdapter.this.notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "663115530")) {
                    ipChange.ipc$dispatch("663115530", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    WrapperAdapter.this.notifyItemRangeChanged(i + 2, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2124086004")) {
                    ipChange.ipc$dispatch("2124086004", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    WrapperAdapter.this.notifyItemRangeInserted(i + 2, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-920268872")) {
                    ipChange.ipc$dispatch("-920268872", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                } else {
                    WrapperAdapter.this.notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-98022178")) {
                    ipChange.ipc$dispatch("-98022178", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    WrapperAdapter.this.notifyItemRangeRemoved(i + 2, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1221961626")) {
                    ipChange.ipc$dispatch("-1221961626", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
                } else {
                    WrapperAdapter.this.notifyItemRangeChanged(i + 2, i2, obj);
                }
            }
        };
        this.g = adapterDataObserver;
        this.a = adapter;
        this.b = refreshHeaderLayout;
        this.d = linearLayout;
        this.e = linearLayout2;
        this.c = frameLayout;
        adapter.registerAdapterDataObserver(adapterDataObserver);
    }

    public RecyclerView.Adapter a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "484707305") ? (RecyclerView.Adapter) ipChange.ipc$dispatch("484707305", new Object[]{this}) : this.a;
    }

    public boolean b(int i) {
        FullSpanTypeChecker fullSpanTypeChecker;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-580275330")) {
            return ((Boolean) ipChange.ipc$dispatch("-580275330", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (i != Integer.MIN_VALUE && i != -2147483647 && i != 2147483646 && i != Integer.MAX_VALUE) {
            z = false;
        }
        return (z || (fullSpanTypeChecker = this.f) == null) ? z : fullSpanTypeChecker.isTypeFullSpan(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "686189779") ? ((Integer) ipChange.ipc$dispatch("686189779", new Object[]{this})).intValue() : this.a.getItemCount() + 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980781289")) {
            return ((Long) ipChange.ipc$dispatch("-1980781289", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        if (i > 1 && i < this.a.getItemCount() + 2) {
            return this.a.getItemId(i - 2);
        }
        return super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054502918")) {
            return ((Integer) ipChange.ipc$dispatch("-2054502918", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        if (i == 1) {
            return StandOutWindow.StandOutLayoutParams.AUTO_POSITION;
        }
        if (1 < i && i < this.a.getItemCount() + 2) {
            return this.a.getItemViewType(i - 2);
        }
        if (i == this.a.getItemCount() + 2) {
            return 2147483646;
        }
        if (i == this.a.getItemCount() + 3) {
            return Integer.MAX_VALUE;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716777421")) {
            ipChange.ipc$dispatch("-1716777421", new Object[]{this, recyclerView});
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.alibaba.pictures.bricks.view.irecycler.WrapperAdapter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1781759361")) {
                        return ((Integer) ipChange2.ipc$dispatch("1781759361", new Object[]{this, Integer.valueOf(i)})).intValue();
                    }
                    if (WrapperAdapter.this.b(((WrapperAdapter) recyclerView.getAdapter()).getItemViewType(i))) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104028230")) {
            ipChange.ipc$dispatch("104028230", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (1 >= i || i >= this.a.getItemCount() + 2) {
        } else {
            this.a.onBindViewHolder(viewHolder, i - 2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "275930736")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("275930736", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == Integer.MIN_VALUE) {
            return new C3595d(this.b);
        }
        if (i == -2147483647) {
            return new C3593b(this.d);
        }
        if (i == 2147483646) {
            return new C3592a(this.e);
        }
        if (i == Integer.MAX_VALUE) {
            return new C3594c(this.c);
        }
        return this.a.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854853737")) {
            ipChange.ipc$dispatch("-854853737", new Object[]{this, viewHolder});
            return;
        }
        super.onViewAttachedToWindow(viewHolder);
        if (b(getItemViewType(viewHolder.getLayoutPosition()))) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }
}
