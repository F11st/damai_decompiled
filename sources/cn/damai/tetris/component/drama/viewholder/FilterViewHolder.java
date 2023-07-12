package cn.damai.tetris.component.drama.viewholder;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.tetris.component.drama.bean.FilterBean;
import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.XHorizontalScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.m62;
import tb.mu0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FilterViewHolder extends BaseViewHolder<FilterBean> implements cn.damai.tetris.component.drama.viewholder.OnItemClickListener<FilterTagBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private View b;
    private RecyclerView c;
    private View d;
    private TextView e;
    private DMIconFontTextView f;
    private FilterMainAdapter g;
    private XHorizontalScrollView h;
    private ViewGroup i;
    private OnItemClickListener j;
    private OnItemExposeListener k;
    private int l;
    private int m;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnItemClickListener {
        void onCalendarClick();

        void onMainTabClick(FilterMainBean filterMainBean, int i);

        void onTagClick(FilterTagBean filterTagBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnItemExposeListener {
        void onSortTypeExpose(View view, List<FilterMainBean> list, int i);

        void onTagTypeExpose(View view, List<FilterTagBean> list, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477250355")) {
                ipChange.ipc$dispatch("-1477250355", new Object[]{this, view});
            } else if (FilterViewHolder.this.j != null) {
                FilterViewHolder.this.j.onCalendarClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements OnItemBindListener<FilterMainBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, FilterMainBean filterMainBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-447831368")) {
                ipChange.ipc$dispatch("-447831368", new Object[]{this, view, filterMainBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(FilterMainBean filterMainBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1400700957")) {
                ipChange.ipc$dispatch("-1400700957", new Object[]{this, filterMainBean, Integer.valueOf(i)});
            } else if (FilterViewHolder.this.j != null) {
                FilterViewHolder.this.j.onMainTabClick(filterMainBean, i);
            }
        }
    }

    public FilterViewHolder(View view, OnItemClickListener onItemClickListener) {
        super(view);
        this.j = onItemClickListener;
        this.l = m62.a(mu0.a(), 9.0f);
        this.m = m62.a(mu0.a(), 21.0f);
        this.a = (TextView) view.findViewById(R$id.filter_title);
        this.b = view.findViewById(R$id.filter_main_tab_layout);
        this.c = (RecyclerView) view.findViewById(R$id.main_tab_recycler);
        this.d = view.findViewById(R$id.filter_time_ui);
        this.e = (TextView) view.findViewById(R$id.filter_timer);
        this.f = (DMIconFontTextView) view.findViewById(R$id.filter_timer_arrow);
        this.h = (XHorizontalScrollView) view.findViewById(R$id.filter_sub_horizontal_scroll_view);
        this.i = (ViewGroup) view.findViewById(R$id.filter_sub_container);
        this.d.setOnClickListener(new a());
        this.c.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        this.c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.drama.viewholder.FilterViewHolder.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-921027502")) {
                    ipChange.ipc$dispatch("-921027502", new Object[]{this, rect, view2, recyclerView, state});
                } else if (recyclerView.getChildAdapterPosition(view2) > 0) {
                    rect.left = FilterViewHolder.this.l;
                }
            }
        });
        FilterMainAdapter filterMainAdapter = new FilterMainAdapter(new b());
        this.g = filterMainAdapter;
        this.c.setAdapter(filterMainAdapter);
    }

    @SuppressLint({"NewApi", "ViewTag"})
    private void f(List<FilterTagBean> list) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625928187")) {
            ipChange.ipc$dispatch("-625928187", new Object[]{this, list});
            return;
        }
        int e = wh2.e(list);
        if (e == 0) {
            this.i.removeAllViews();
            return;
        }
        if (this.i.getChildCount() != e) {
            this.i.removeAllViews();
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i = 0;
            while (i < e) {
                boolean z2 = i == 0;
                boolean z3 = i == e + (-1);
                FilterTagViewHolder filterTagViewHolder = new FilterTagViewHolder(this.i, this);
                View view = filterTagViewHolder.itemView;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (z2) {
                        marginLayoutParams.leftMargin = this.m;
                    }
                    if (z3) {
                        marginLayoutParams.rightMargin = this.m;
                    }
                }
                view.setTag(R$id.holder_id, filterTagViewHolder);
                this.i.addView(view);
                i++;
            }
        }
        for (int i2 = 0; i2 < e; i2++) {
            FilterTagBean filterTagBean = list.get(i2);
            View childAt = this.i.getChildAt(i2);
            if (childAt != null) {
                Object tag = childAt.getTag(R$id.holder_id);
                if (tag instanceof FilterTagViewHolder) {
                    ((FilterTagViewHolder) tag).a(filterTagBean, i2);
                }
            }
        }
        OnItemExposeListener onItemExposeListener = this.k;
        if (onItemExposeListener != null) {
            onItemExposeListener.onTagTypeExpose(this.i, list, 0);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: g */
    public void a(final FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1813325057")) {
            ipChange.ipc$dispatch("1813325057", new Object[]{this, filterBean, Integer.valueOf(i)});
            return;
        }
        List<FilterMainBean> list = filterBean.tabs;
        this.g.f(list);
        OnItemExposeListener onItemExposeListener = this.k;
        if (onItemExposeListener != null) {
            onItemExposeListener.onSortTypeExpose(this.c, list, 0);
        }
        FilterMainBean filterMainBean = null;
        if (!cb2.d(list)) {
            for (FilterMainBean filterMainBean2 : list) {
                if (filterMainBean2.isSelected) {
                    filterMainBean = filterMainBean2;
                }
            }
        }
        if ((filterMainBean == null || cb2.d(filterMainBean.labels)) ? false : false) {
            this.h.setVisibility(0);
            f(filterMainBean.labels);
            this.h.post(new Runnable() { // from class: cn.damai.tetris.component.drama.viewholder.FilterViewHolder.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-735230240")) {
                        ipChange2.ipc$dispatch("-735230240", new Object[]{this});
                    } else {
                        FilterViewHolder.this.h.scrollTo(filterBean.mTagPanelScrollX, 0);
                    }
                }
            });
        } else {
            this.h.setVisibility(8);
        }
        o(filterBean.getCalendarText());
        this.a.setText(filterBean.title);
    }

    public XHorizontalScrollView h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1549184979") ? (XHorizontalScrollView) ipChange.ipc$dispatch("-1549184979", new Object[]{this}) : this.h;
    }

    public int i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1761382494") ? ((Integer) ipChange.ipc$dispatch("-1761382494", new Object[]{this})).intValue() : this.a.getHeight() + this.b.getHeight();
    }

    public int j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "620459470") ? ((Integer) ipChange.ipc$dispatch("620459470", new Object[]{this})).intValue() : this.a.getHeight();
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: k */
    public void onItemClick(FilterTagBean filterTagBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178603817")) {
            ipChange.ipc$dispatch("-178603817", new Object[]{this, filterTagBean, Integer.valueOf(i)});
            return;
        }
        OnItemClickListener onItemClickListener = this.j;
        if (onItemClickListener != null) {
            onItemClickListener.onTagClick(filterTagBean, i);
        }
    }

    public void l(OnItemExposeListener onItemExposeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944406860")) {
            ipChange.ipc$dispatch("-1944406860", new Object[]{this, onItemExposeListener});
        } else {
            this.k = onItemExposeListener;
        }
    }

    public void m(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110614532")) {
            ipChange.ipc$dispatch("110614532", new Object[]{this, onItemClickListener});
        } else {
            this.j = onItemClickListener;
        }
    }

    public void n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264176928")) {
            ipChange.ipc$dispatch("264176928", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.f.setText(z ? R$string.iconfont_shaixuanshang12 : R$string.iconfont_shaixuanxia12);
        }
    }

    public void o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546788014")) {
            ipChange.ipc$dispatch("1546788014", new Object[]{this, str});
        } else {
            this.e.setText(str);
        }
    }
}
