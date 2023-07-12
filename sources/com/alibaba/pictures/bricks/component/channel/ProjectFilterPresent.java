package com.alibaba.pictures.bricks.component.channel;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.projectfiltercopy.FilterViewManager;
import cn.damai.projectfiltercopy.bean.FilterResponse;
import cn.damai.projectfiltercopy.bean.PresetBean;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.listener.FilterBtnAction;
import cn.damai.projectfiltercopy.listener.FilterParamChangeListener;
import com.alibaba.pictures.bricks.channel.bean.StyleFilter;
import com.alibaba.pictures.bricks.channel.component.ProjectFilterComponent;
import com.alibaba.pictures.bricks.channel.component.ProjectListComponent;
import com.alibaba.pictures.bricks.component.channel.ProjectFilterPresent;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.style.Style;
import java.util.List;
import kotlin.collections.C8212k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.bb2;
import tb.kj0;
import tb.mf;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectFilterPresent extends AbsPresenter<GenericItem<ItemValue>, ProjectFilterModel, ProjectFilterView> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private GenericItem<ItemValue> mLastItem;
    @Nullable
    private FilterViewManager mViewManager;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.channel.ProjectFilterPresent$a */
    /* loaded from: classes7.dex */
    public static final class C3454a implements FilterBtnAction {
        private static transient /* synthetic */ IpChange $ipChange;

        C3454a() {
        }

        @Override // cn.damai.projectfiltercopy.listener.FilterBtnAction
        public int computeFloatTopPadding(@Nullable Type type) {
            View renderView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-968574228")) {
                return ((Integer) ipChange.ipc$dispatch("-968574228", new Object[]{this, type})).intValue();
            }
            if (Type.DATE_HOR_CALENDAR == type || (renderView = ((ProjectFilterView) ProjectFilterPresent.this.getView()).getRenderView()) == null) {
                return 0;
            }
            ProjectFilterPresent projectFilterPresent = ProjectFilterPresent.this;
            if (renderView.getParent() != null) {
                FilterViewManager filterViewManager = projectFilterPresent.mViewManager;
                int j = filterViewManager != null ? filterViewManager.j() : 0;
                FilterViewManager filterViewManager2 = projectFilterPresent.mViewManager;
                int h = filterViewManager2 != null ? filterViewManager2.h() : 0;
                int top = renderView.getTop() + j;
                if (top < -5 || top > 5) {
                    return 0;
                }
                return h;
            }
            return 0;
        }

        @Override // cn.damai.projectfiltercopy.listener.FilterBtnAction
        public void doBeforeFilterBtnClick(@Nullable Type type) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2041147948")) {
                ipChange.ipc$dispatch("2041147948", new Object[]{this, type});
            } else {
                ProjectFilterPresent.this.dispatchScroll2TopFilterView();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectFilterPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchScroll2TopFilterView() {
        View renderView;
        GenericFragment fragment;
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948372250")) {
            ipChange.ipc$dispatch("1948372250", new Object[]{this});
            return;
        }
        try {
            FilterViewManager filterViewManager = this.mViewManager;
            if (filterViewManager != null && (renderView = ((ProjectFilterView) getView()).getRenderView()) != null && (fragment = ((GenericItem) getItem()).getPageContext().getFragment()) != null && (recyclerView = fragment.getRecyclerView()) != null) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(renderView);
                int j = filterViewManager.j();
                if (childAdapterPosition >= 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                    if (linearLayoutManager != null) {
                        linearLayoutManager.scrollToPositionWithOffset(childAdapterPosition, -j);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-4$lambda-2  reason: not valid java name */
    public static final void m114init$lambda4$lambda2(GenericItem genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122865661")) {
            ipChange.ipc$dispatch("1122865661", new Object[]{genericItem});
            return;
        }
        b41.i(genericItem, "$item");
        List<IComponent<ComponentValue>> components = genericItem.getComponent().getModule().getComponents();
        if (bb2.d(components)) {
            return;
        }
        Object b0 = C8212k.b0(components);
        ProjectListComponent projectListComponent = b0 instanceof ProjectListComponent ? (ProjectListComponent) b0 : null;
        if (projectListComponent != null) {
            projectListComponent.refresh();
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull final GenericItem<ItemValue> genericItem) {
        Activity activity;
        Style style;
        ComponentValue property;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790930367")) {
            ipChange.ipc$dispatch("790930367", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ProjectFilterPresent) genericItem);
        if ((!b41.d(genericItem, this.mLastItem) || this.mViewManager == null) && (activity = genericItem.getPageContext().getActivity()) != null) {
            this.mLastItem = genericItem;
            GenericFragment fragment = genericItem.getPageContext().getFragment();
            BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
            String spmb = (baseFragment == null || (trackInfo = baseFragment.getTrackInfo()) == null) ? null : trackInfo.getSpmb();
            if (spmb == null) {
                spmb = mf.CALENDAR_PAGE;
            }
            PresetBean presetFromBundle = PresetBean.presetFromBundle(genericItem.getPageContext().getBundle());
            FilterResponse filterResponse = (FilterResponse) ap2.INSTANCE.j(genericItem.getProperty().getData(), FilterResponse.class);
            IComponent<ComponentValue> component = genericItem.getComponent();
            ProjectFilterComponent projectFilterComponent = component instanceof ProjectFilterComponent ? (ProjectFilterComponent) component : null;
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setVisibility(8);
            if (projectFilterComponent != null) {
                projectFilterComponent.addView2RecyclerViewContainer(frameLayout);
            }
            if (projectFilterComponent == null || (property = projectFilterComponent.getProperty()) == null || (style = property.getStyle()) == null) {
                style = genericItem.getProperty().getStyle();
            }
            Object styleValue = style != null ? style.getStyleValue("topRound") : null;
            String str = styleValue instanceof String ? (String) styleValue : null;
            Object styleValue2 = style != null ? style.getStyleValue("calendarStyle") : null;
            StyleFilter styleFilter = new StyleFilter(styleValue2 instanceof String ? (String) styleValue2 : null, null, str);
            FilterViewManager filterViewManager = new FilterViewManager(activity, frameLayout, new kj0(spmb));
            filterViewManager.l(filterResponse, styleFilter, presetFromBundle);
            if (projectFilterComponent != null) {
                projectFilterComponent.setRequestParamProvider(filterViewManager.i());
            }
            filterViewManager.i().setParamChangeListener(new FilterParamChangeListener() { // from class: tb.aw1
                @Override // cn.damai.projectfiltercopy.listener.FilterParamChangeListener
                public final void notifyFilterParamChanged() {
                    ProjectFilterPresent.m114init$lambda4$lambda2(GenericItem.this);
                }
            });
            filterViewManager.m(new C3454a());
            View itemView = ((ProjectFilterView) getView()).getItemView();
            ViewGroup viewGroup = itemView instanceof ViewGroup ? (ViewGroup) itemView : null;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(filterViewManager.k(), -1, -2);
            }
            this.mViewManager = filterViewManager;
            ((ProjectFilterView) getView()).bind(filterResponse);
        }
    }
}
