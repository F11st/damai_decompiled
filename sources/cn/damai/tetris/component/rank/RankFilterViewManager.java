package cn.damai.tetris.component.rank;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.rank.RankFilterViewManager;
import cn.damai.tetris.component.rank.adapter.RankTypeAdapter;
import cn.damai.tetris.component.rank.bean.CategoryTabBean;
import cn.damai.tetris.component.rank.bean.PresetBean;
import cn.damai.tetris.component.rank.bean.RankFilterBean;
import cn.damai.tetris.component.rank.bean.TypeTabBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb2;
import tb.m62;
import tb.mu0;
import tb.rk2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankFilterViewManager implements TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private final View b;
    @NotNull
    private final OnRankActionListener c;
    @NotNull
    private final TabLayout d;
    @NotNull
    private final RecyclerView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final TextView g;
    @NotNull
    private final View h;
    @NotNull
    private final View i;
    @Nullable
    private RankTypeAdapter j;
    @Nullable
    private List<? extends CategoryTabBean> k;
    @Nullable
    private CategoryTabBean l;
    @Nullable
    private TypeTabBean m;
    private final int n;
    private final int o;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnRankActionListener {
        void onChangeCityClick();

        void onFilterChanged(@NotNull CategoryTabBean categoryTabBean, @NotNull TypeTabBean typeTabBean);

        void onMainBtnClick(@NotNull CategoryTabBean categoryTabBean, int i);

        void onMainBtnExpose(@Nullable View view, @NotNull CategoryTabBean categoryTabBean, int i);

        void onSubBtnClick(@NotNull CategoryTabBean categoryTabBean, @NotNull TypeTabBean typeTabBean, int i);

        void onSubBtnExpose(@Nullable View view, @Nullable CategoryTabBean categoryTabBean, @Nullable TypeTabBean typeTabBean, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.rank.RankFilterViewManager$a */
    /* loaded from: classes7.dex */
    public static final class C1946a implements OnItemBindListener<TypeTabBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1946a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(@Nullable View view, @Nullable TypeTabBean typeTabBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-550949573")) {
                ipChange.ipc$dispatch("-550949573", new Object[]{this, view, typeTabBean, Integer.valueOf(i)});
            } else {
                RankFilterViewManager.this.c.onSubBtnExpose(view, RankFilterViewManager.this.l, typeTabBean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(@Nullable TypeTabBean typeTabBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1304773350")) {
                ipChange.ipc$dispatch("1304773350", new Object[]{this, typeTabBean, Integer.valueOf(i)});
                return;
            }
            RankFilterViewManager.this.m = typeTabBean;
            RankTypeAdapter rankTypeAdapter = RankFilterViewManager.this.j;
            if (rankTypeAdapter != null) {
                rankTypeAdapter.g(typeTabBean);
            }
            if (RankFilterViewManager.this.m != null && RankFilterViewManager.this.l != null) {
                OnRankActionListener onRankActionListener = RankFilterViewManager.this.c;
                CategoryTabBean categoryTabBean = RankFilterViewManager.this.l;
                b41.f(categoryTabBean);
                TypeTabBean typeTabBean2 = RankFilterViewManager.this.m;
                b41.f(typeTabBean2);
                onRankActionListener.onSubBtnClick(categoryTabBean, typeTabBean2, i);
            }
            RankFilterViewManager.this.t();
            RankFilterViewManager.this.o();
        }
    }

    public RankFilterViewManager(@NotNull Context context, @NotNull View view, @NotNull OnRankActionListener onRankActionListener) {
        b41.i(context, "mContext");
        b41.i(view, "mView");
        b41.i(onRankActionListener, "mListener");
        this.a = context;
        this.b = view;
        this.c = onRankActionListener;
        View findViewById = view.findViewById(R$id.id_rank_f_main_btn_tab);
        b41.h(findViewById, "mView.findViewById(R.id.id_rank_f_main_btn_tab)");
        TabLayout tabLayout = (TabLayout) findViewById;
        this.d = tabLayout;
        View findViewById2 = view.findViewById(R$id.id_rank_f_sub_btn_lv);
        b41.h(findViewById2, "mView.findViewById(R.id.id_rank_f_sub_btn_lv)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.e = recyclerView;
        View findViewById3 = view.findViewById(R$id.id_rank_f_tip);
        b41.h(findViewById3, "mView.findViewById(R.id.id_rank_f_tip)");
        this.f = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.id_rank_city_tip);
        b41.h(findViewById4, "mView.findViewById(R.id.id_rank_city_tip)");
        this.g = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.id_tetris_rank_empty_layout);
        b41.h(findViewById5, "mView.findViewById(R.id.…tetris_rank_empty_layout)");
        this.h = findViewById5;
        View findViewById6 = view.findViewById(R$id.id_tetris_rank_top_round_bg);
        b41.h(findViewById6, "mView.findViewById(R.id.…tetris_rank_top_round_bg)");
        this.i = findViewById6;
        findViewById5.findViewById(R$id.id_tetris_rank_change_city).setOnClickListener(new View.OnClickListener() { // from class: tb.wy1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RankFilterViewManager.c(RankFilterViewManager.this, view2);
            }
        });
        findViewById5.setVisibility(8);
        this.n = m62.a(context, 12.0f);
        this.o = m62.a(context, 12.0f);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.rank.RankFilterViewManager.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-310703418")) {
                    ipChange.ipc$dispatch("-310703418", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                b41.i(rect, "outRect");
                b41.i(view2, "view");
                b41.i(recyclerView2, "parent");
                b41.i(state, "state");
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                boolean z = childAdapterPosition == 0;
                RankTypeAdapter rankTypeAdapter = RankFilterViewManager.this.j;
                b41.f(rankTypeAdapter);
                boolean z2 = childAdapterPosition == rankTypeAdapter.getItemCount() - 1;
                rect.left = z ? RankFilterViewManager.this.n : 0;
                RankFilterViewManager rankFilterViewManager = RankFilterViewManager.this;
                rect.right = z2 ? rankFilterViewManager.n : rankFilterViewManager.o;
            }
        });
        RankTypeAdapter rankTypeAdapter = new RankTypeAdapter(context, new C1946a());
        this.j = rankTypeAdapter;
        recyclerView.setAdapter(rankTypeAdapter);
        tabLayout.setSelectedTabIndicator(new rk2(22));
        tabLayout.addOnTabSelectedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RankFilterViewManager rankFilterViewManager, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "282888616")) {
            ipChange.ipc$dispatch("282888616", new Object[]{rankFilterViewManager, view});
            return;
        }
        b41.i(rankFilterViewManager, "this$0");
        rankFilterViewManager.c.onChangeCityClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(RankFilterViewManager rankFilterViewManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954643546")) {
            ipChange.ipc$dispatch("954643546", new Object[]{rankFilterViewManager});
            return;
        }
        b41.i(rankFilterViewManager, "this$0");
        TabLayout tabLayout = rankFilterViewManager.d;
        tabLayout.setScrollPosition(tabLayout.getSelectedTabPosition(), 0.0f, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759262057")) {
            ipChange.ipc$dispatch("759262057", new Object[]{this});
            return;
        }
        CategoryTabBean categoryTabBean = this.l;
        if (categoryTabBean == null || this.m == null) {
            return;
        }
        OnRankActionListener onRankActionListener = this.c;
        b41.f(categoryTabBean);
        TypeTabBean typeTabBean = this.m;
        b41.f(typeTabBean);
        onRankActionListener.onFilterChanged(categoryTabBean, typeTabBean);
    }

    private final void p() {
        TypeTabBean typeTabBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892987811")) {
            ipChange.ipc$dispatch("-1892987811", new Object[]{this});
            return;
        }
        CategoryTabBean categoryTabBean = this.l;
        if (categoryTabBean != null) {
            int indexOf = categoryTabBean.subTypeList.indexOf(this.m);
            if (indexOf >= 0) {
                typeTabBean = categoryTabBean.subTypeList.get(indexOf);
            } else {
                typeTabBean = categoryTabBean.subTypeList.isEmpty() ? null : categoryTabBean.subTypeList.get(0);
            }
            this.m = typeTabBean;
            RankTypeAdapter rankTypeAdapter = this.j;
            if (rankTypeAdapter != null) {
                rankTypeAdapter.f(categoryTabBean.subTypeList, typeTabBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403641165")) {
            ipChange.ipc$dispatch("-403641165", new Object[]{this});
            return;
        }
        TypeTabBean typeTabBean = this.m;
        if (typeTabBean != null) {
            this.f.setText(typeTabBean.desc);
        }
    }

    public final void m(@Nullable RankFilterBean rankFilterBean, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5607747")) {
            ipChange.ipc$dispatch("-5607747", new Object[]{this, rankFilterBean, str});
        } else if (rankFilterBean != null) {
            this.d.removeOnTabSelectedListener(this);
            this.d.removeAllTabs();
            rankFilterBean.ensureFormatBeanOneTime();
            List<CategoryTabBean> list = rankFilterBean.categoryTabs;
            this.k = list;
            if (!cb2.d(list)) {
                this.l = PresetBean.obtainSelected(this.k, str);
                List<? extends CategoryTabBean> list2 = this.k;
                if (list2 != null) {
                    for (CategoryTabBean categoryTabBean : list2) {
                        TabLayout.Tab newTab = this.d.newTab();
                        b41.h(newTab, "mCategoryTabsLayout.newTab()");
                        newTab.setText(categoryTabBean.name);
                        this.d.addTab(newTab, categoryTabBean == this.l);
                    }
                }
                if (this.d.getSelectedTabPosition() > 0) {
                    this.d.post(new Runnable() { // from class: tb.xy1
                        @Override // java.lang.Runnable
                        public final void run() {
                            RankFilterViewManager.n(RankFilterViewManager.this);
                        }
                    });
                }
                View childAt = this.d.getChildAt(0);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (viewGroup.getChildCount() > 0) {
                        int childCount = viewGroup.getChildCount();
                        int i = 0;
                        while (i < childCount) {
                            View childAt2 = viewGroup.getChildAt(i);
                            boolean z = i == 0;
                            boolean z2 = i == childCount + (-1);
                            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                if (z) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = m62.a(mu0.a(), 3.0f);
                                }
                                if (z2) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = m62.a(mu0.a(), 8.0f);
                                }
                            }
                            CategoryTabBean categoryTabBean2 = (CategoryTabBean) cb2.b(this.k, i);
                            if (categoryTabBean2 != null) {
                                this.c.onMainBtnExpose(childAt2, categoryTabBean2, i);
                            }
                            i++;
                        }
                    }
                }
            }
            p();
            t();
            this.d.addOnTabSelectedListener(this);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@Nullable TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980465837")) {
            ipChange.ipc$dispatch("-980465837", new Object[]{this, tab});
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652674970")) {
            ipChange.ipc$dispatch("-652674970", new Object[]{this, tab});
            return;
        }
        b41.i(tab, "tab");
        int position = tab.getPosition();
        CategoryTabBean categoryTabBean = (CategoryTabBean) cb2.b(this.k, position);
        CategoryTabBean categoryTabBean2 = this.l;
        if (categoryTabBean2 == null || !b41.d(categoryTabBean2, categoryTabBean)) {
            this.l = categoryTabBean;
            if (categoryTabBean != null) {
                OnRankActionListener onRankActionListener = this.c;
                b41.f(categoryTabBean);
                onRankActionListener.onMainBtnClick(categoryTabBean, position);
            }
            p();
            o();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722620205")) {
            ipChange.ipc$dispatch("722620205", new Object[]{this, tab});
        }
    }

    public final void q(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1476544653")) {
            ipChange.ipc$dispatch("-1476544653", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    public final void r(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483848354")) {
            ipChange.ipc$dispatch("-1483848354", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.i.setBackgroundColor(i);
        }
    }

    public final void s(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267185801")) {
            ipChange.ipc$dispatch("267185801", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.g.setVisibility(z ? 0 : 8);
        }
    }
}
