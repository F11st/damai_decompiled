package com.alibaba.pictures.bricks.channel.component;

import android.app.Activity;
import cn.damai.projectfiltercopy.bean.CategoryRequestNewParams;
import cn.damai.projectfiltercopy.bean.FilterReqParamBean;
import cn.damai.projectfiltercopy.listener.RequestParamProvider;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.loader.v2.GenericComponentLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.page.GenericFragment;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hm1;
import tb.qp1;
import tb.wt2;
import tb.xh;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectListComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private ProjectLoadingListener projectLoadingListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ProjectComponentLoader extends GenericComponentLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectListComponent this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProjectComponentLoader(@NotNull ProjectListComponent projectListComponent, IComponent<ComponentValue> iComponent) {
            super(iComponent);
            b41.i(iComponent, "component");
            this.this$0 = projectListComponent;
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1826259711")) {
                ipChange.ipc$dispatch("1826259711", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            IContext pageContext = this.this$0.getPageContext();
            final ProjectListComponent projectListComponent = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.channel.component.ProjectListComponent$ProjectComponentLoader$handleLoadFailure$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-438022276")) {
                        return (wt2) ipChange2.ipc$dispatch("-438022276", new Object[]{this});
                    }
                    GenericFragment fragment = ProjectListComponent.this.getPageContext().getFragment();
                    BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                    if (baseFragment != null) {
                        baseFragment.hideLoadingDialog(ProjectListComponent.this.getPageContext().getActivity());
                        return wt2.INSTANCE;
                    }
                    return null;
                }
            });
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-279751203")) {
                ipChange.ipc$dispatch("-279751203", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadSuccess(iResponse, i);
            IContext pageContext = this.this$0.getPageContext();
            final ProjectListComponent projectListComponent = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.channel.component.ProjectListComponent$ProjectComponentLoader$handleLoadSuccess$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-396834635")) {
                        return (wt2) ipChange2.ipc$dispatch("-396834635", new Object[]{this});
                    }
                    GenericFragment fragment = ProjectListComponent.this.getPageContext().getFragment();
                    BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                    if (baseFragment != null) {
                        baseFragment.hideLoadingDialog(ProjectListComponent.this.getPageContext().getActivity());
                        return wt2.INSTANCE;
                    }
                    return null;
                }
            });
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull final Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1542343579")) {
                ipChange.ipc$dispatch("1542343579", new Object[]{this, map});
                return;
            }
            b41.i(map, Constants.CONFIG);
            IContext pageContext = this.this$0.getPageContext();
            final ProjectListComponent projectListComponent = this.this$0;
            pageContext.runOnUIThread(new Function0<Activity>() { // from class: com.alibaba.pictures.bricks.channel.component.ProjectListComponent$ProjectComponentLoader$load$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Activity invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1597276409")) {
                        return (Activity) ipChange2.ipc$dispatch("-1597276409", new Object[]{this});
                    }
                    Activity activity = ProjectListComponent.this.getPageContext().getActivity();
                    if (activity != null) {
                        Map<String, Object> map2 = map;
                        ProjectListComponent projectListComponent2 = ProjectListComponent.this;
                        if (b41.d(map2.get("index"), 1)) {
                            GenericFragment fragment = projectListComponent2.getPageContext().getFragment();
                            BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                            if (baseFragment != null) {
                                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(baseFragment, activity, null, false, 6, null);
                                return activity;
                            }
                            return activity;
                        }
                        return activity;
                    }
                    return null;
                }
            });
            super.load(map);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ProjectLoadBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        public ProjectLoadBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            RequestParamProvider requestParamProvider;
            FilterReqParamBean obtainRequestParam;
            CategoryRequestNewParams createReqParams;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1142776973")) {
                return (IRequest) ipChange.ipc$dispatch("1142776973", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            PageArgument b = qp1.INSTANCE.b(ProjectListComponent.this.getContext().getBundle());
            String str = b != null ? b.patternName : null;
            if (str == null) {
                str = "";
            }
            linkedHashMap2.put("patternName", str);
            String str2 = b != null ? b.patternVersion : null;
            linkedHashMap2.put("patternVersion", str2 != null ? str2 : "");
            IComponent projectFilterComponent = ProjectListComponent.this.getProjectFilterComponent();
            ProjectFilterComponent projectFilterComponent2 = projectFilterComponent instanceof ProjectFilterComponent ? (ProjectFilterComponent) projectFilterComponent : null;
            if (projectFilterComponent2 != null && (requestParamProvider = projectFilterComponent2.getRequestParamProvider()) != null && (obtainRequestParam = requestParamProvider.obtainRequestParam()) != null && (createReqParams = obtainRequestParam.createReqParams()) != null) {
                ProjectListComponent projectListComponent = ProjectListComponent.this;
                JSONObject data = projectListComponent.getProperty().getData();
                String string = data != null ? data.getString("nextPageIndex") : null;
                JSONObject data2 = projectListComponent.getProperty().getData();
                String string2 = data2 != null ? data2.getString("nextCityOption") : null;
                if (b41.d(map.get("index"), 1)) {
                    createReqParams.pageIndex = 1;
                    createReqParams.cityOption = 0;
                } else if (b41.d("1", string2)) {
                    createReqParams.pageIndex = hm1.e(string, 1);
                    createReqParams.cityOption = hm1.e(string2, 0);
                } else {
                    Object obj = map.get("index");
                    b41.g(obj, "null cannot be cast to non-null type kotlin.Int");
                    createReqParams.pageIndex = ((Integer) obj).intValue();
                    createReqParams.cityOption = 0;
                }
                Map createRequestArgs = projectListComponent.createRequestArgs(b != null ? b.parseArg2Json() : null, createReqParams);
                createRequestArgs.remove("patternName");
                createRequestArgs.remove("patternVersion");
                linkedHashMap.putAll(createRequestArgs);
            }
            JSONObject data3 = ProjectListComponent.this.getModule().getProperty().getData();
            String str3 = (String) (data3 != null ? data3.get("nodeId") : null);
            JSONObject data4 = ProjectListComponent.this.getProperty().getData();
            return xh.INSTANCE.a(2L, linkedHashMap, linkedHashMap2, str3, (String) (data4 != null ? data4.get("nodeId") : null));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ProjectLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public ProjectLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-440898556")) {
                ipChange.ipc$dispatch("-440898556", new Object[]{this});
                return;
            }
            final PagingLoader componentLoader = ProjectListComponent.this.getComponentLoader();
            if (componentLoader != null) {
                final ProjectListComponent projectListComponent = ProjectListComponent.this;
                projectListComponent.getPageContext().runOnUIThread(new Function0<RefreshLayout>() { // from class: com.alibaba.pictures.bricks.channel.component.ProjectListComponent$ProjectLoadingListener$onAllPageLoaded$1$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final RefreshLayout invoke() {
                        RefreshLayout refreshLayout;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1254702471")) {
                            return (RefreshLayout) ipChange2.ipc$dispatch("1254702471", new Object[]{this});
                        }
                        if (PagingLoader.this.getLoadingPage() >= 2) {
                            BricksToastUtil.INSTANCE.b("都被你看光啦，过会儿再来吧~");
                        }
                        GenericFragment fragment = projectListComponent.getPageContext().getFragment();
                        if (fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null) {
                            return null;
                        }
                        return refreshLayout.setEnableLoadMore(false);
                    }
                });
            }
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextFailure(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1906548466")) {
                ipChange.ipc$dispatch("1906548466", new Object[]{this, str});
            } else {
                ProjectListComponent.this.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.channel.component.ProjectListComponent$ProjectLoadingListener$onLoadNextFailure$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ wt2 invoke() {
                        invoke2();
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1833534573")) {
                            ipChange2.ipc$dispatch("-1833534573", new Object[]{this});
                        } else {
                            BricksToastUtil.INSTANCE.b("小二很忙，系统很累，稍后再试吧");
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectListComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, Constants.CONFIG);
        this.context = iContext;
        setRequestBuilder(new ProjectLoadBuilder());
        setComponentLoader(new ProjectComponentLoader(this, this));
        setRequestBuilder(new ProjectLoadBuilder());
        this.projectLoadingListener = new ProjectLoadingListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> createRequestArgs(JSONObject jSONObject, CategoryRequestNewParams categoryRequestNewParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1269183065")) {
            return (Map) ipChange.ipc$dispatch("-1269183065", new Object[]{this, jSONObject, categoryRequestNewParams});
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONObject != null) {
            Map<String, Object> innerMap = jSONObject.getInnerMap();
            b41.h(innerMap, "innerMap");
            linkedHashMap.putAll(innerMap);
        }
        try {
            JSONObject parseObject = JSON.parseObject(JSON.toJSONString(categoryRequestNewParams));
            b41.h(parseObject, "parseObject(JSON.toJSONS…g(categoryRequestParams))");
            linkedHashMap.putAll(parseObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IComponent<ComponentValue> getProjectFilterComponent() {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100127833")) {
            return (IComponent) ipChange.ipc$dispatch("2100127833", new Object[]{this});
        }
        Iterator<T> it = getModule().getComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IComponent) obj) instanceof ProjectFilterComponent) {
                break;
            }
        }
        return (IComponent) obj;
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1454696244") ? (IContext) ipChange.ipc$dispatch("-1454696244", new Object[]{this}) : this.context;
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onAdd() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143038965")) {
            ipChange.ipc$dispatch("-143038965", new Object[]{this});
            return;
        }
        super.onAdd();
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader == null || (loadingViewManager = componentLoader.getLoadingViewManager()) == null) {
            return;
        }
        loadingViewManager.removeLoadingStateListener(this.projectLoadingListener);
        loadingViewManager.addLoadingStateListener(this.projectLoadingListener);
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onRemove() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916472890")) {
            ipChange.ipc$dispatch("1916472890", new Object[]{this});
            return;
        }
        super.onRemove();
        ProjectLoadingListener projectLoadingListener = this.projectLoadingListener;
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader == null || (loadingViewManager = componentLoader.getLoadingViewManager()) == null) {
            return;
        }
        loadingViewManager.removeLoadingStateListener(projectLoadingListener);
    }

    public final void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824461614")) {
            ipChange.ipc$dispatch("-1824461614", new Object[]{this});
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("index", 1);
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader != null) {
            componentLoader.load(linkedHashMap);
        }
    }
}
