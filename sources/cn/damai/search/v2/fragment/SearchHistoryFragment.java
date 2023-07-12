package cn.damai.search.v2.fragment;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.bean.RankWordBean;
import cn.damai.search.v2.listener.OnHisWordClickListener;
import cn.damai.search.v2.listener.SearchInputObserver;
import cn.damai.search.v2.tool.HistoryWordManager;
import cn.damai.search.v2.tool.RankWordManager;
import cn.damai.uikit.view.ExpandFlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.c82;
import tb.cb2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchHistoryFragment extends DamaiBaseMvpFragment implements SearchInputObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isExpand = false;
    private View mExpandBtnView;
    private TextView mExpandTv;
    private View mHistoryUi;
    private ExpandFlowLayout.AbstractC2583a<String> mHwAdapter;
    private HistoryWordManager mHwManager;
    private OnHisWordClickListener mWordClickListener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1646a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$a$a */
        /* loaded from: classes15.dex */
        public class DialogInterface$OnClickListenerC1647a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC1647a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-193486173")) {
                    ipChange.ipc$dispatch("-193486173", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                SearchHistoryFragment.this.mHwManager.a();
            }
        }

        View$OnClickListenerC1646a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1487992577")) {
                ipChange.ipc$dispatch("-1487992577", new Object[]{this, view});
                return;
            }
            FragmentActivity activity = SearchHistoryFragment.this.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            c82.o();
            DMDialog dMDialog = new DMDialog(activity);
            dMDialog.v("确认清空搜索历史？");
            dMDialog.i("取消", null);
            dMDialog.n("确定", new DialogInterface$OnClickListenerC1647a());
            dMDialog.show();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$b */
    /* loaded from: classes15.dex */
    public class View$OnLayoutChangeListenerC1648b implements View.OnLayoutChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ExpandFlowLayout a;

        View$OnLayoutChangeListenerC1648b(SearchHistoryFragment searchHistoryFragment, ExpandFlowLayout expandFlowLayout) {
            this.a = expandFlowLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int childCount;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-512654820")) {
                ipChange.ipc$dispatch("-512654820", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
            } else if (!(i == i5 && i2 == i6 && i3 == i7 && i4 == i8) && (childCount = this.a.getChildCount()) > 0) {
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt = this.a.getChildAt(i9);
                    if (childAt.getTag() instanceof String) {
                        c82.g(childAt, (String) childAt.getTag(), i9);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$c */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1649c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1649c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1560379135")) {
                ipChange.ipc$dispatch("-1560379135", new Object[]{this, view});
                return;
            }
            SearchHistoryFragment.this.mHwAdapter.e(!SearchHistoryFragment.this.isExpand);
            SearchHistoryFragment searchHistoryFragment = SearchHistoryFragment.this;
            searchHistoryFragment.isExpand = !searchHistoryFragment.isExpand;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$d */
    /* loaded from: classes6.dex */
    public class C1650d implements ExpandFlowLayout.ExpandBtnView {
        private static transient /* synthetic */ IpChange $ipChange;

        C1650d() {
        }

        @Override // cn.damai.uikit.view.ExpandFlowLayout.ExpandBtnView
        public View getExpandBtnView() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1994727746") ? (View) ipChange.ipc$dispatch("1994727746", new Object[]{this}) : SearchHistoryFragment.this.mExpandBtnView;
        }

        @Override // cn.damai.uikit.view.ExpandFlowLayout.ExpandBtnView
        public void setExpand(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1795443401")) {
                ipChange.ipc$dispatch("-1795443401", new Object[]{this, Boolean.valueOf(z)});
            } else {
                SearchHistoryFragment.this.mExpandTv.setText(z ? R$string.iconfont_shangjiantou12 : R$string.iconfont_xiajiantou12);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$e */
    /* loaded from: classes6.dex */
    public class C1651e extends ExpandFlowLayout.AbstractC2583a<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$e$a */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1652a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;
            final /* synthetic */ int b;

            View$OnClickListenerC1652a(String str, int i) {
                this.a = str;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-603858096")) {
                    ipChange.ipc$dispatch("-603858096", new Object[]{this, view});
                    return;
                }
                c82.p(this.a, this.b);
                SearchHistoryFragment.this.mHwManager.dispatchInputWord(new InputInfo(this.a, 22));
                if (SearchHistoryFragment.this.mWordClickListener != null) {
                    SearchHistoryFragment.this.mWordClickListener.onHistoryWordClick(this.a, this.b);
                }
            }
        }

        C1651e() {
        }

        @Override // cn.damai.uikit.view.ExpandFlowLayout.AbstractC2583a
        /* renamed from: h */
        public View c(ViewGroup viewGroup, View view, String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1247033618")) {
                return (View) ipChange.ipc$dispatch("1247033618", new Object[]{this, viewGroup, view, str, Integer.valueOf(i)});
            }
            if (view == null) {
                view = LayoutInflater.from(mu0.a()).inflate(R$layout.item_one_history_word, viewGroup, false);
            }
            ((TextView) view.findViewById(R$id.history_text)).setText(str);
            view.setTag(str);
            view.setOnClickListener(new View$OnClickListenerC1652a(str, i));
            return view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$f */
    /* loaded from: classes6.dex */
    public class C1653f implements HistoryWordManager.OnHisWordDataChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1653f() {
        }

        @Override // cn.damai.search.v2.tool.HistoryWordManager.OnHisWordDataChangeListener
        public void updateList(@Nullable List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1486352797")) {
                ipChange.ipc$dispatch("1486352797", new Object[]{this, list});
            } else if (cb2.d(list)) {
                SearchHistoryFragment.this.mHistoryUi.setVisibility(8);
            } else {
                SearchHistoryFragment.this.mHistoryUi.setVisibility(0);
                SearchHistoryFragment.this.mHwAdapter.g(list);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.fragment.SearchHistoryFragment$g */
    /* loaded from: classes6.dex */
    public class C1654g implements RankWordManager.OnRankWordListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1654g() {
        }

        @Override // cn.damai.search.v2.tool.RankWordManager.OnRankWordListener
        public void onRankWordClick(RankWordBean rankWordBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "462736879")) {
                ipChange.ipc$dispatch("462736879", new Object[]{this, rankWordBean, Integer.valueOf(i)});
                return;
            }
            c82.r(rankWordBean, i);
            FragmentActivity activity = SearchHistoryFragment.this.getActivity();
            if (activity != null) {
                DMNav.from(activity).toUri(rankWordBean.url);
            }
        }

        @Override // cn.damai.search.v2.tool.RankWordManager.OnRankWordListener
        public void onRankWordExpose(View view, RankWordBean rankWordBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-631799973")) {
                ipChange.ipc$dispatch("-631799973", new Object[]{this, view, rankWordBean, Integer.valueOf(i)});
            } else {
                c82.h(view, rankWordBean, i);
            }
        }
    }

    public static SearchHistoryFragment getInstance(OnHisWordClickListener onHisWordClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503738585")) {
            return (SearchHistoryFragment) ipChange.ipc$dispatch("-503738585", new Object[]{onHisWordClickListener});
        }
        SearchHistoryFragment searchHistoryFragment = new SearchHistoryFragment();
        searchHistoryFragment.mWordClickListener = onHisWordClickListener;
        return searchHistoryFragment;
    }

    @Override // cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615619246")) {
            ipChange.ipc$dispatch("-1615619246", new Object[]{this, inputInfo});
            return;
        }
        HistoryWordManager historyWordManager = this.mHwManager;
        if (historyWordManager != null) {
            historyWordManager.dispatchInputWord(inputInfo);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1202154546") ? ((Integer) ipChange.ipc$dispatch("-1202154546", new Object[]{this})).intValue() : R$layout.fragment_search_rank_word;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119318266")) {
            ipChange.ipc$dispatch("1119318266", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709988977")) {
            ipChange.ipc$dispatch("1709988977", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674502772")) {
            ipChange.ipc$dispatch("-674502772", new Object[]{this});
            return;
        }
        View findViewById = this.rootView.findViewById(R$id.search_v2_hot_word_ui);
        this.mHistoryUi = this.rootView.findViewById(R$id.search_v2_history_word_ui);
        ExpandFlowLayout expandFlowLayout = (ExpandFlowLayout) this.rootView.findViewById(R$id.search_v2_history_layout);
        this.rootView.findViewById(R$id.search_v2_history_clear).setOnClickListener(new View$OnClickListenerC1646a());
        expandFlowLayout.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC1648b(this, expandFlowLayout));
        View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.item_history_arrow_view, (ViewGroup) null);
        this.mExpandBtnView = inflate;
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.mExpandTv = (TextView) this.mExpandBtnView.findViewById(R$id.history_text_ift);
        this.mExpandBtnView.setOnClickListener(new View$OnClickListenerC1649c());
        C1650d c1650d = new C1650d();
        c1650d.setExpand(false);
        expandFlowLayout.setExpandBtnView(c1650d);
        C1651e c1651e = new C1651e();
        this.mHwAdapter = c1651e;
        expandFlowLayout.setAdapter(c1651e);
        HistoryWordManager historyWordManager = new HistoryWordManager(new C1653f());
        this.mHwManager = historyWordManager;
        historyWordManager.b();
        new RankWordManager(findViewById, new C1654g()).d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-243743118")) {
            ipChange.ipc$dispatch("-243743118", new Object[]{this, view});
        }
    }
}
