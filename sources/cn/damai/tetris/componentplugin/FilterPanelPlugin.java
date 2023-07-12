package cn.damai.tetris.componentplugin;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.CategoryQuery;
import cn.damai.tetris.component.drama.bean.FilterBean;
import cn.damai.tetris.component.drama.bean.FilterDateBean;
import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.tetris.component.drama.viewholder.FilterViewHolder;
import cn.damai.tetris.componentplugin.FilterCalendarPanel;
import cn.damai.tetris.componentplugin.a;
import cn.damai.tetris.componentplugin.bean.LoadData;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.StyleInfo;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.section.ISection;
import cn.damai.uikit.view.XHorizontalScrollView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb1;
import tb.cb2;
import tb.jj0;
import tb.m62;
import tb.mu0;
import tb.om;
import tb.xl2;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class FilterPanelPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "FilterPanelPlugin";
    private boolean isMaskPanelShowing;
    @Nullable
    private FilterCalendarPanel mCalendarPanel;
    @Nullable
    private IContainer mContainer;
    private int mFilterViewType;
    private int mMainFilterHeight;
    @Nullable
    private View mMaskView;
    @Nullable
    private FilterViewHolder mMaskViewHolder;
    private FilterPanelModel mPanelModel;
    private int mPanelOffsetAboveFilter;
    private jj0 mPanelUt;
    @Nullable
    private FilterViewHolder mRealViewHolder;
    @Nullable
    private ViewGroup mRecyclerContainer;
    @Nullable
    private RecyclerView mRecyclerView;
    @Nullable
    private FilterBean mRefFilterBean;
    private XHorizontalScrollView.OnScrollListener mSubTagScrollListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements XHorizontalScrollView.OnScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.XHorizontalScrollView.OnScrollListener
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-389556045")) {
                ipChange.ipc$dispatch("-389556045", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } else if (FilterPanelPlugin.this.mRefFilterBean != null) {
                FilterPanelPlugin.this.mRefFilterBean.mTagPanelScrollX = i;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements FilterCalendarPanel.OnCalendarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.tetris.componentplugin.FilterCalendarPanel.OnCalendarListener
        public void onCalendarChanged(FilterDateBean filterDateBean) {
            String calendarText;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2134423489")) {
                ipChange.ipc$dispatch("-2134423489", new Object[]{this, filterDateBean});
            } else if (FilterPanelPlugin.this.mRefFilterBean != null && FilterPanelPlugin.this.mRefFilterBean.changedFilterDate(filterDateBean)) {
                CategoryQuery query = FilterPanelPlugin.this.mRefFilterBean.getQuery();
                if (query.index != 4) {
                    calendarText = FilterPanelPlugin.this.mRefFilterBean.getCalendarText();
                } else {
                    calendarText = query.startDate;
                }
                FilterPanelPlugin.this.mPanelUt.f(query.index, calendarText);
                FilterPanelPlugin.this.mPanelModel.m(query);
                FilterPanelPlugin.this.updatePanelDateText();
                FilterPanelPlugin.this.load(true, true);
            }
        }

        @Override // cn.damai.tetris.componentplugin.FilterCalendarPanel.OnCalendarListener
        public void onVisibilityChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-413633954")) {
                ipChange.ipc$dispatch("-413633954", new Object[]{this, Boolean.valueOf(z)});
            } else {
                FilterPanelPlugin.this.updatePanelArrow(z);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements OnBizListener<LoadData> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        c(boolean z, boolean z2, boolean z3) {
            this.a = z;
            this.b = z2;
            this.c = z3;
        }

        @Override // cn.damai.tetris.componentplugin.OnBizListener
        /* renamed from: a */
        public void onSuccess(LoadData loadData) {
            int filterPanelItemPosInRecycler;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1128806759")) {
                ipChange.ipc$dispatch("-1128806759", new Object[]{this, loadData});
                return;
            }
            if (this.a) {
                ((ComponentPlugin) FilterPanelPlugin.this).mComponentUi.stopProgressDialog();
            }
            if (loadData.hasNextPage) {
                ((ComponentPlugin) FilterPanelPlugin.this).mComponentUi.loadMoreResetV2(true);
            } else if (!this.b || loadData.hasListSize()) {
                ((ComponentPlugin) FilterPanelPlugin.this).mComponentUi.showNoMoreV2();
            } else {
                ((ComponentPlugin) FilterPanelPlugin.this).mComponentUi.showNoMoreV2("没有找到相关演出，换个筛选条件试试吧");
            }
            List<ILayer> layerList = FilterPanelPlugin.this.mContainer.getLayerList();
            ILayer iLayer = cb2.d(layerList) ? null : layerList.get(layerList.size() - 1);
            if (iLayer == null) {
                return;
            }
            if (this.b) {
                iLayer.clearSectionList();
                iLayer.createSectionList(loadData.sectionList, true);
            } else {
                iLayer.createSectionList(loadData.sectionList, true);
            }
            if (!this.c || FilterPanelPlugin.this.mRecyclerView == null || (filterPanelItemPosInRecycler = FilterPanelPlugin.this.getFilterPanelItemPosInRecycler()) < 0) {
                return;
            }
            FilterPanelPlugin.this.setMaskVisibility(8);
            FilterPanelPlugin.this.mRecyclerView.scrollToPosition(filterPanelItemPosInRecycler);
        }

        @Override // cn.damai.tetris.componentplugin.OnBizListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1424979062")) {
                ipChange.ipc$dispatch("-1424979062", new Object[]{this, str, str2});
                return;
            }
            if (!this.b) {
                ((ComponentPlugin) FilterPanelPlugin.this).mComponentUi.loadMoreResetV2(true);
            }
            if (this.a) {
                ((ComponentPlugin) FilterPanelPlugin.this).mComponentUi.stopProgressDialog();
            }
            ToastUtil.i(str2);
        }
    }

    public FilterPanelPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
        this.isMaskPanelShowing = false;
        this.mPanelUt = jj0.a();
        this.mPanelOffsetAboveFilter = m62.a(mu0.a(), 46.0f);
        this.mMainFilterHeight = m62.a(mu0.a(), 38.0f);
        View rootView = componentPageUi.getRootView();
        this.mRecyclerView = componentPageUi.getRecycler();
        this.mContainer = componentPageUi.getPageContainer();
        this.mRecyclerContainer = (ViewGroup) rootView.findViewById(R$id.tetris_recycler_container);
        IContainer iContainer = this.mContainer;
        this.mPanelModel = new FilterPanelModel(iContainer == null ? null : iContainer.getContainerArg());
        if (this.mRecyclerContainer != null) {
            View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.item_tetris_project_filter_ui_mask, this.mRecyclerContainer, false);
            this.mMaskView = inflate;
            inflate.setVisibility(8);
            this.mMaskView.scrollTo(0, this.mPanelOffsetAboveFilter);
            this.mRecyclerContainer.addView(this.mMaskView);
            FilterViewHolder filterViewHolder = new FilterViewHolder(this.mMaskView, new a.C0080a(componentPageUi.getBaseContext()));
            this.mMaskViewHolder = filterViewHolder;
            XHorizontalScrollView h = filterViewHolder.h();
            a aVar = new a();
            this.mSubTagScrollListener = aVar;
            h.setListener(aVar);
        }
        this.mFilterViewType = om.c(mu0.a()).d(xl2.DM_PROJECT_FILTER_PANEL_CID);
        addScrollListener();
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1762152314")) {
            ipChange.ipc$dispatch("-1762152314", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.componentplugin.FilterPanelPlugin.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-855588466")) {
                    ipChange2.ipc$dispatch("-855588466", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    FilterPanelPlugin.this.dispatchScrollY(recyclerView2, i2);
                }
            }
        });
    }

    private void autoScrollFilterPanel2Top() {
        int filterPanelItemPosInRecycler;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766314667")) {
            ipChange.ipc$dispatch("-766314667", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.stopScroll();
        View view = this.mMaskView;
        if ((view == null || view.getVisibility() != 0) && (filterPanelItemPosInRecycler = getFilterPanelItemPosInRecycler()) >= 0) {
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(filterPanelItemPosInRecycler, -this.mPanelOffsetAboveFilter);
            } else {
                this.mRecyclerView.smoothScrollToPosition(filterPanelItemPosInRecycler);
            }
        }
    }

    private void checkPanelUiShowCalendarUiIfCan() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478581748")) {
            ipChange.ipc$dispatch("1478581748", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = this.mRecyclerContainer;
        if (viewGroup == null) {
            return;
        }
        if (this.mCalendarPanel == null) {
            this.mCalendarPanel = new FilterCalendarPanel(viewGroup, new b());
        }
        this.mRecyclerContainer.post(new Runnable() { // from class: cn.damai.tetris.componentplugin.FilterPanelPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1424820243")) {
                    ipChange2.ipc$dispatch("-1424820243", new Object[]{this});
                } else if (FilterPanelPlugin.this.mCalendarPanel == null) {
                } else {
                    FilterPanelPlugin.this.mCalendarPanel.d(FilterPanelPlugin.this.isFilterUiFloatingTop() ? FilterPanelPlugin.this.mMainFilterHeight : 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchScrollY(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-851261438")) {
            ipChange.ipc$dispatch("-851261438", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else if (recyclerView != null && i != 0 && !isMaskUnAttached()) {
            View childAt = recyclerView.getChildAt(0);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (childAt == null || adapter == null) {
                return;
            }
            boolean z = i < 0;
            int itemCount = adapter.getItemCount();
            int i2 = -1;
            for (int i3 = 0; i3 < itemCount; i3++) {
                if (this.mFilterViewType == adapter.getItemViewType(i3)) {
                    i2 = i3;
                }
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (i2 == -1) {
                setMaskVisibility(8);
            } else if (childAdapterPosition > i2) {
                showMaskPanel(z, !(((this.mMaskView.getVisibility() == 0) || z) ? false : true));
                this.mMaskView.setVisibility(0);
            } else if (i2 == childAdapterPosition) {
                int top = childAt.getTop();
                int i4 = this.mMaskViewHolder.i();
                int j = this.mMaskViewHolder.j();
                if (top < 0) {
                    int abs = Math.abs(top);
                    if (abs >= i4) {
                        if (z) {
                            setMaskVisibility(0);
                            showMaskPanel(true, true);
                            return;
                        }
                        setMaskVisibility(0);
                        showMaskPanel(false, false);
                        return;
                    } else if (abs < j) {
                        setMaskVisibility(8);
                        return;
                    } else if (z) {
                        if (this.mMaskView.getVisibility() != 0 || this.isMaskPanelShowing) {
                            return;
                        }
                        setMaskVisibility(8);
                        return;
                    } else {
                        setMaskVisibility(8);
                        return;
                    }
                }
                setMaskVisibility(8);
            } else {
                setMaskVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFilterPanelItemPosInRecycler() {
        RecyclerView.Adapter adapter;
        int itemCount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086788012")) {
            return ((Integer) ipChange.ipc$dispatch("1086788012", new Object[]{this})).intValue();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.getAdapter() == null || (itemCount = (adapter = this.mRecyclerView.getAdapter()).getItemCount()) <= 0) {
            return -1;
        }
        for (int i = 0; i < itemCount; i++) {
            if (adapter.getItemViewType(i) == this.mFilterViewType) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFilterUiFloatingTop() {
        int filterPanelItemPosInRecycler;
        View childAt;
        int childAdapterPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063985971")) {
            return ((Boolean) ipChange.ipc$dispatch("1063985971", new Object[]{this})).booleanValue();
        }
        if (this.mRecyclerView == null || isMaskUnAttached() || (filterPanelItemPosInRecycler = getFilterPanelItemPosInRecycler()) < 0 || (childAt = this.mRecyclerView.getChildAt(0)) == null || (childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(childAt)) < 0) {
            return false;
        }
        if (childAdapterPosition > filterPanelItemPosInRecycler) {
            return true;
        }
        if (childAdapterPosition == filterPanelItemPosInRecycler) {
            int top = childAt.getTop();
            cb1.c("FilterPlugin", "child top " + top + "" + this.mPanelOffsetAboveFilter);
            return true;
        }
        return false;
    }

    private boolean isMaskUnAttached() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2064272147") ? ((Boolean) ipChange.ipc$dispatch("2064272147", new Object[]{this})).booleanValue() : this.mMaskView == null || this.mMaskViewHolder == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(boolean z, boolean z2) {
        View view;
        IpChange ipChange = $ipChange;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "-306256004")) {
            ipChange.ipc$dispatch("-306256004", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (this.mContainer == null || this.mRefFilterBean == null) {
        } else {
            if (z2) {
                this.mComponentUi.startProgressDialog();
            }
            if (z && (view = this.mMaskView) != null) {
                z3 = view.getVisibility() == 0;
            }
            this.mPanelModel.j(z, new c(z2, z, z3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskVisibility(int i) {
        FilterViewHolder filterViewHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924669115")) {
            ipChange.ipc$dispatch("1924669115", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.mMaskView;
        if (view != null) {
            view.setVisibility(i);
            if (i != 0 || this.mRefFilterBean == null || (filterViewHolder = this.mMaskViewHolder) == null) {
                return;
            }
            filterViewHolder.h().scrollTo(this.mRefFilterBean.mTagPanelScrollX, 0);
        }
    }

    @SuppressLint({"NewApi"})
    private void showMaskPanel(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806357581")) {
            ipChange.ipc$dispatch("1806357581", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (isMaskUnAttached()) {
        } else {
            this.isMaskPanelShowing = z;
            Object tag = this.mMaskView.getTag();
            if (tag instanceof ScrollAnimator) {
                ScrollAnimator scrollAnimator = (ScrollAnimator) tag;
                if (z == scrollAnimator.show) {
                    return;
                }
                scrollAnimator.cancel();
            }
            int j = this.mMaskViewHolder.j();
            int i = this.mMaskViewHolder.i();
            if (!z) {
                j = i;
            }
            if (z2) {
                ScrollAnimator scrollAnimator2 = new ScrollAnimator(this.mMaskView, z, this.mMaskView.getScrollY(), j);
                scrollAnimator2.setDuration(300L);
                this.mMaskView.setTag(scrollAnimator2);
                scrollAnimator2.start();
                return;
            }
            this.mMaskView.scrollTo(0, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePanelArrow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-240553216")) {
            ipChange.ipc$dispatch("-240553216", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        FilterViewHolder filterViewHolder = this.mMaskViewHolder;
        if (filterViewHolder != null) {
            filterViewHolder.n(z);
        }
        FilterViewHolder filterViewHolder2 = this.mRealViewHolder;
        if (filterViewHolder2 != null) {
            filterViewHolder2.n(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePanelDateText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83289326")) {
            ipChange.ipc$dispatch("-83289326", new Object[]{this});
            return;
        }
        FilterBean filterBean = this.mRefFilterBean;
        if (filterBean == null) {
            return;
        }
        FilterViewHolder filterViewHolder = this.mMaskViewHolder;
        if (filterViewHolder != null) {
            filterViewHolder.o(filterBean.getCalendarText());
        }
        FilterViewHolder filterViewHolder2 = this.mRealViewHolder;
        if (filterViewHolder2 != null) {
            filterViewHolder2.o(this.mRefFilterBean.getCalendarText());
        }
    }

    private void updatePanelUi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1323513305")) {
            ipChange.ipc$dispatch("1323513305", new Object[]{this});
            return;
        }
        FilterBean filterBean = this.mRefFilterBean;
        if (filterBean == null) {
            return;
        }
        FilterViewHolder filterViewHolder = this.mMaskViewHolder;
        if (filterViewHolder != null) {
            filterViewHolder.a(filterBean, 0);
        }
        FilterViewHolder filterViewHolder2 = this.mRealViewHolder;
        if (filterViewHolder2 != null) {
            filterViewHolder2.a(this.mRefFilterBean, 0);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071514548")) {
            return ((Boolean) ipChange.ipc$dispatch("-2071514548", new Object[]{this})).booleanValue();
        }
        if (this.mContainer == null || this.mRefFilterBean == null) {
            return false;
        }
        this.mComponentUi.showLoadMoreV2();
        load(false, false);
        cb1.c(TAG, "FilterPanelPlugin onLoadMore");
        return true;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1968064029")) {
            return ((Boolean) ipChange.ipc$dispatch("-1968064029", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        if (this.mRefFilterBean == null) {
            return false;
        }
        if (i == 7001) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: cn.damai.tetris.componentplugin.FilterPanelPlugin.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1031793233")) {
                            ipChange2.ipc$dispatch("-1031793233", new Object[]{this});
                            return;
                        }
                        FilterPanelPlugin filterPanelPlugin = FilterPanelPlugin.this;
                        filterPanelPlugin.dispatchScrollY(filterPanelPlugin.mRecyclerView, 1);
                    }
                });
            }
            return true;
        } else if (obj instanceof cn.damai.tetris.componentplugin.a) {
            cb1.c(TAG, "FilterPanelPlugin onMessage");
            cn.damai.tetris.componentplugin.a aVar = (cn.damai.tetris.componentplugin.a) obj;
            switch (i) {
                case 2048:
                    FilterMainBean filterMainBean = aVar.a;
                    this.mPanelUt.e(filterMainBean, aVar.d);
                    this.mRefFilterBean.setSelectTab(filterMainBean);
                    this.mPanelModel.m(this.mRefFilterBean.getQuery());
                    updatePanelUi();
                    load(true, true);
                    break;
                case cn.damai.tetris.componentplugin.a.TYPE_TAG_CLICK /* 2049 */:
                    FilterTagBean filterTagBean = aVar.b;
                    this.mPanelUt.g(filterTagBean, aVar.d);
                    this.mRefFilterBean.setSelectTag(filterTagBean);
                    this.mPanelModel.m(this.mRefFilterBean.getQuery());
                    updatePanelUi();
                    load(true, true);
                    break;
                case 2050:
                    FilterViewHolder filterViewHolder = aVar.c;
                    this.mRealViewHolder = filterViewHolder;
                    if (filterViewHolder != null) {
                        filterViewHolder.h().setListener(this.mSubTagScrollListener);
                        break;
                    }
                    break;
                case 2051:
                    FilterBean filterBean = this.mRefFilterBean;
                    if (filterBean != null) {
                        this.mPanelUt.d(filterBean.getCalendarText());
                    }
                    autoScrollFilterPanel2Top();
                    checkPanelUiShowCalendarUiIfCan();
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243450640")) {
            return ((Boolean) ipChange.ipc$dispatch("-1243450640", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844354818")) {
            ipChange.ipc$dispatch("1844354818", new Object[]{this, iSection});
            return;
        }
        if (AppConfig.v()) {
            String sectionId = iSection == null ? "" : iSection.getSectionId();
            cb1.c("ComponentPlugin", "onSectionBind " + sectionId);
        }
        if (iSection != null) {
            JSONObject item = iSection.getItem();
            StyleInfo styleInfo = iSection.getStyleInfo();
            String str = styleInfo != null ? CardTitleBean.fromTetrisStyle(styleInfo).title : null;
            this.mPanelUt.c(iSection);
            if (item != null) {
                FilterBean parseBeanWithDefaultSelect = FilterBean.parseBeanWithDefaultSelect(new NodeData(item));
                this.mRefFilterBean = parseBeanWithDefaultSelect;
                iSection.setExtra(parseBeanWithDefaultSelect);
                FilterBean filterBean = this.mRefFilterBean;
                if (filterBean != null) {
                    filterBean.title = str;
                    this.mPanelModel.l(filterBean.itemInfo);
                    this.mPanelModel.m(this.mRefFilterBean.getQuery());
                }
            }
        }
        updatePanelUi();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179303969")) {
            ipChange.ipc$dispatch("-1179303969", new Object[]{this, iSection});
            return;
        }
        if (AppConfig.v()) {
            String sectionId = iSection == null ? "" : iSection.getSectionId();
            cb1.c("ComponentPlugin", "onSectionRemoved " + sectionId);
        }
        this.mRefFilterBean = null;
        this.mRealViewHolder = null;
        FilterCalendarPanel filterCalendarPanel = this.mCalendarPanel;
        if (filterCalendarPanel != null) {
            filterCalendarPanel.c();
            this.mCalendarPanel = null;
        }
        setMaskVisibility(8);
        this.mPanelModel.i();
    }
}
