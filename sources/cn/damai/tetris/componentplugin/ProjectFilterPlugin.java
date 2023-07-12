package cn.damai.tetris.componentplugin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.projectfilter.FilterViewManager;
import cn.damai.projectfilter.bean.FilterResponse;
import cn.damai.projectfilter.bean.PresetBean;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.listener.FilterBtnAction;
import cn.damai.projectfilter.listener.FilterParamChangeListener;
import cn.damai.projectfilter.listener.RequestParamProvider;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.componentplugin.ProjectFilterModel;
import cn.damai.tetris.componentplugin.bean.LoadData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb1;
import tb.cb2;
import tb.ja;
import tb.kh0;
import tb.lj0;
import tb.m61;
import tb.m62;
import tb.mu0;
import tb.om;
import tb.xl2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectFilterPlugin extends ComponentPlugin implements FilterBtnAction, FilterParamChangeListener, ProjectFilterModel.OnModelBizListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ProjectFilter";
    private ViewGroup mCmsContainer;
    private FilterViewManager mFilterVManager;
    private FrameLayout mFloatLayout;
    private VBaseViewHolder mHolder;
    private ProjectFilterModel mModel;
    private RequestParamProvider mParamProvider;
    private final int mViewType4Filter;

    public ProjectFilterPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
        this.mViewType4Filter = om.c(mu0.a()).d(xl2.PROJECT_FILTER_OPTION_C_ID);
    }

    @Override // cn.damai.projectfilter.listener.FilterBtnAction
    public int computeFloatTopPadding() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-114835143")) {
            return ((Integer) ipChange.ipc$dispatch("-114835143", new Object[]{this})).intValue();
        }
        FilterViewManager filterViewManager = this.mFilterVManager;
        if (kh0.f(this.mViewType4Filter, this.mComponentUi.getRecycler(), filterViewManager != null ? filterViewManager.f() : 0)) {
            return m62.a(mu0.a(), 44.0f);
        }
        return 0;
    }

    @Override // cn.damai.projectfilter.listener.FilterBtnAction
    public void doBeforeFilterBtnClick(Type type) {
        int e;
        RecyclerView.LayoutManager layoutManager;
        FilterViewManager filterViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "329195464")) {
            ipChange.ipc$dispatch("329195464", new Object[]{this, type});
            return;
        }
        RecyclerView recycler = this.mComponentUi.getRecycler();
        if (recycler == null || (e = kh0.e(this.mViewType4Filter, recycler)) < 0 || (layoutManager = recycler.getLayoutManager()) == null || (filterViewManager = this.mFilterVManager) == null) {
            return;
        }
        int f = filterViewManager.f();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(e, -f);
        } else {
            recycler.smoothScrollToPosition(e);
        }
    }

    public int getSectionHash(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380456528")) {
            return ((Integer) ipChange.ipc$dispatch("380456528", new Object[]{this, iSection})).intValue();
        }
        if (iSection == null) {
            return -1;
        }
        return iSection.hashCode();
    }

    @Override // cn.damai.projectfilter.listener.FilterParamChangeListener
    public void notifyFilterParamChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907234431")) {
            ipChange.ipc$dispatch("1907234431", new Object[]{this});
        } else if (this.mParamProvider == null || this.mModel == null) {
        } else {
            this.mComponentUi.startProgressDialog();
            this.mModel.j(true, this);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922355070")) {
            ipChange.ipc$dispatch("922355070", new Object[]{this, iSection, vBaseViewHolder});
            return;
        }
        if (AppConfig.v()) {
            cb1.c(TAG, "call onBindViewHolder sectionHash:" + getSectionHash(iSection));
        }
        if (this.mHolder != null) {
            return;
        }
        FilterResponse filterResponse = (FilterResponse) m61.d(iSection.getItem(), FilterResponse.class);
        CardTitleBean fromTetrisStyle = CardTitleBean.fromTetrisStyle(iSection.getStyleInfo());
        ViewGroup viewGroup = (ViewGroup) vBaseViewHolder.itemView.findViewById(R$id.id_tetris_project_filter_container);
        ja baseContext = this.mComponentUi.getBaseContext();
        View rootView = this.mComponentUi.getRootView();
        IContainer pageContainer = this.mComponentUi.getPageContainer();
        if (viewGroup == null || rootView == null || baseContext == null || baseContext.getActivity() == null || pageContainer == null || filterResponse == null || !filterResponse.isValid()) {
            return;
        }
        this.mHolder = vBaseViewHolder;
        this.mFloatLayout = new FrameLayout(baseContext.getActivity());
        ViewGroup viewGroup2 = (ViewGroup) rootView.findViewById(R$id.tetris_recycler_container);
        this.mCmsContainer = viewGroup2;
        if (viewGroup2 != null) {
            this.mFloatLayout.setVisibility(8);
            this.mCmsContainer.addView(this.mFloatLayout, -1, -1);
        }
        TrackInfo trackInfo = iSection.getTrackInfo();
        FilterViewManager filterViewManager = new FilterViewManager(baseContext.getActivity(), this.mFloatLayout, new lj0(trackInfo == null ? "" : trackInfo.trackB));
        this.mFilterVManager = filterViewManager;
        View g = filterViewManager.g();
        this.mFilterVManager.i(this);
        viewGroup.addView(g, -1, -2);
        ContainerArg containerArg = pageContainer.getContainerArg();
        this.mFilterVManager.h(filterResponse, fromTetrisStyle.title, PresetBean.filterPresetFromArg(containerArg));
        RequestParamProvider e = this.mFilterVManager.e();
        this.mParamProvider = e;
        e.setParamChangeListener(this);
        this.mModel = new ProjectFilterModel(this.mParamProvider, containerArg, CategoryItemListInfo.obtainFromSection(iSection, CategoryItemListInfo.defaultItem()));
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1018514287")) {
            return ((Boolean) ipChange.ipc$dispatch("-1018514287", new Object[]{this})).booleanValue();
        }
        if (this.mModel == null) {
            return false;
        }
        if (AppConfig.v()) {
            cb1.c(TAG, "call onLoadMore sectionHash:" + getSectionHash(this.mSection));
        }
        this.mComponentUi.showLoadMoreV2();
        this.mModel.j(false, this);
        return true;
    }

    @Override // cn.damai.tetris.componentplugin.ProjectFilterModel.OnModelBizListener
    public void onLoadProjectFail(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501278857")) {
            ipChange.ipc$dispatch("-501278857", new Object[]{this, Boolean.valueOf(z), str, str2});
            return;
        }
        if (!z) {
            this.mComponentUi.loadMoreResetV2(true);
        }
        if (z) {
            this.mComponentUi.stopProgressDialog();
        }
        ToastUtil.i(str2);
    }

    @Override // cn.damai.tetris.componentplugin.ProjectFilterModel.OnModelBizListener
    public void onLoadProjectSuccess(LoadData loadData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491021172")) {
            ipChange.ipc$dispatch("1491021172", new Object[]{this, loadData});
            return;
        }
        IContainer pageContainer = this.mComponentUi.getPageContainer();
        this.mComponentUi.stopProgressDialog();
        boolean z = loadData.firstPage;
        if (loadData.hasNextPage) {
            this.mComponentUi.loadMoreResetV2(true);
        } else if (z && !loadData.hasListSize()) {
            this.mComponentUi.showNoMoreV2("没有找到相关演出，换个筛选条件试试吧");
        } else {
            this.mComponentUi.showNoMoreV2();
        }
        List<ILayer> layerList = pageContainer.getLayerList();
        ILayer iLayer = cb2.d(layerList) ? null : layerList.get(layerList.size() - 1);
        if (iLayer == null) {
            return;
        }
        if (z) {
            iLayer.clearSectionList();
        }
        iLayer.createSectionList(loadData.sectionList, true);
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1287318296")) {
            return ((Boolean) ipChange.ipc$dispatch("-1287318296", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516746229")) {
            return ((Boolean) ipChange.ipc$dispatch("-516746229", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349736953")) {
            ipChange.ipc$dispatch("-1349736953", new Object[]{this, iSection});
            return;
        }
        CategoryItemListInfo obtainFromSection = CategoryItemListInfo.obtainFromSection(iSection, CategoryItemListInfo.defaultItem());
        if (obtainFromSection.isCanRequestNextPage(true, 1)) {
            this.mComponentUi.loadMoreResetV2(true);
        } else if (obtainFromSection.hasListSize()) {
            this.mComponentUi.showNoMoreV2();
        } else {
            this.mComponentUi.showNoMoreV2("没有找到相关演出，换个筛选条件试试吧");
        }
        if (AppConfig.v()) {
            cb1.c(TAG, "onSectionBind sectionHash:" + getSectionHash(this.mSection) + " ");
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        FrameLayout frameLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366810950")) {
            ipChange.ipc$dispatch("-1366810950", new Object[]{this, iSection});
            return;
        }
        if (AppConfig.v()) {
            cb1.c(TAG, "call onSectionRemoved sectionHash:" + getSectionHash(iSection));
        }
        ViewGroup viewGroup = this.mCmsContainer;
        if (viewGroup != null && (frameLayout = this.mFloatLayout) != null) {
            viewGroup.removeView(frameLayout);
        }
        ProjectFilterModel projectFilterModel = this.mModel;
        if (projectFilterModel != null) {
            projectFilterModel.i();
        }
        this.mHolder = null;
    }
}
