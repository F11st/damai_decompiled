package cn.damai.uikit.irecycler;

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
/* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public interface FullSpanTypeChecker {
        boolean isTypeFullSpan(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.irecycler.WrapperAdapter$a */
    /* loaded from: classes8.dex */
    static class C2510a extends RecyclerView.ViewHolder {
        public C2510a(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.irecycler.WrapperAdapter$b */
    /* loaded from: classes8.dex */
    static class C2511b extends RecyclerView.ViewHolder {
        public C2511b(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.irecycler.WrapperAdapter$c */
    /* loaded from: classes8.dex */
    static class C2512c extends RecyclerView.ViewHolder {
        public C2512c(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.irecycler.WrapperAdapter$d */
    /* loaded from: classes8.dex */
    static class C2513d extends RecyclerView.ViewHolder {
        public C2513d(View view) {
            super(view);
        }
    }

    public WrapperAdapter(RecyclerView.Adapter adapter, RefreshHeaderLayout refreshHeaderLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout) {
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: cn.damai.uikit.irecycler.WrapperAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1697066368")) {
                    ipChange.ipc$dispatch("1697066368", new Object[]{this});
                } else {
                    WrapperAdapter.this.notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1163634484")) {
                    ipChange.ipc$dispatch("-1163634484", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    WrapperAdapter.this.notifyItemRangeChanged(i + 2, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1329410418")) {
                    ipChange.ipc$dispatch("1329410418", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    WrapperAdapter.this.notifyItemRangeInserted(i + 2, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "960466358")) {
                    ipChange.ipc$dispatch("960466358", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                } else {
                    WrapperAdapter.this.notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1924772192")) {
                    ipChange.ipc$dispatch("-1924772192", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    WrapperAdapter.this.notifyItemRangeRemoved(i + 2, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2075644504")) {
                    ipChange.ipc$dispatch("-2075644504", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
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
        return AndroidInstantRuntime.support(ipChange, "-1120621525") ? (RecyclerView.Adapter) ipChange.ipc$dispatch("-1120621525", new Object[]{this}) : this.a;
    }

    public boolean b(int i) {
        FullSpanTypeChecker fullSpanTypeChecker;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-617527300")) {
            return ((Boolean) ipChange.ipc$dispatch("-617527300", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (i != Integer.MIN_VALUE && i != -2147483647 && i != 2147483646 && i != Integer.MAX_VALUE) {
            z = false;
        }
        return (z || (fullSpanTypeChecker = this.f) == null) ? z : fullSpanTypeChecker.isTypeFullSpan(i);
    }

    public void c(FullSpanTypeChecker fullSpanTypeChecker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157406303")) {
            ipChange.ipc$dispatch("1157406303", new Object[]{this, fullSpanTypeChecker});
        } else {
            this.f = fullSpanTypeChecker;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2117773035") ? ((Integer) ipChange.ipc$dispatch("-2117773035", new Object[]{this})).intValue() : this.a.getItemCount() + 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-759119399")) {
            return ((Long) ipChange.ipc$dispatch("-759119399", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        if (i > 1 && i < this.a.getItemCount() + 2) {
            return this.a.getItemId(i - 2);
        }
        return super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1085653308")) {
            return ((Integer) ipChange.ipc$dispatch("1085653308", new Object[]{this, Integer.valueOf(i)})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-2089484367")) {
            ipChange.ipc$dispatch("-2089484367", new Object[]{this, recyclerView});
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: cn.damai.uikit.irecycler.WrapperAdapter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "117989699")) {
                        return ((Integer) ipChange2.ipc$dispatch("117989699", new Object[]{this, Integer.valueOf(i)})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "386620100")) {
            ipChange.ipc$dispatch("386620100", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (1 >= i || i >= this.a.getItemCount() + 2) {
        } else {
            this.a.onBindViewHolder(viewHolder, i - 2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103657550")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1103657550", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == Integer.MIN_VALUE) {
            return new C2513d(this.b);
        }
        if (i == -2147483647) {
            return new C2511b(this.d);
        }
        if (i == 2147483646) {
            return new C2510a(this.e);
        }
        if (i == Integer.MAX_VALUE) {
            return new C2512c(this.c);
        }
        return this.a.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1008217127")) {
            ipChange.ipc$dispatch("-1008217127", new Object[]{this, viewHolder});
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
