package com.alibaba.pictures.bricks.artist;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.fastjson.JSONObject;
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
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bi0;
import tb.l8;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FeedComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private FeedLoadingListener projectLoadingListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class FeedComponentLoader extends GenericComponentLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedComponent this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedComponentLoader(@NotNull FeedComponent feedComponent, IComponent<ComponentValue> iComponent) {
            super(iComponent);
            b41.i(iComponent, "component");
            this.this$0 = feedComponent;
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericComponentLoader
        public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1570303768")) {
                ipChange.ipc$dispatch("1570303768", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "itemIterator");
            b41.i(node, "itemNode");
            bi0.INSTANCE.a(node);
            super.handleItemNode(listIterator, node);
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-76123631")) {
                ipChange.ipc$dispatch("-76123631", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            IContext pageContext = this.this$0.getPageContext();
            final FeedComponent feedComponent = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.artist.FeedComponent$FeedComponentLoader$handleLoadFailure$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-987293782")) {
                        return (wt2) ipChange2.ipc$dispatch("-987293782", new Object[]{this});
                    }
                    GenericFragment fragment = FeedComponent.this.getPageContext().getFragment();
                    BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                    if (baseFragment != null) {
                        baseFragment.hideLoadingDialog(FeedComponent.this.getPageContext().getActivity());
                        return wt2.INSTANCE;
                    }
                    return null;
                }
            });
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "875907339")) {
                ipChange.ipc$dispatch("875907339", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadSuccess(iResponse, i);
            IContext pageContext = this.this$0.getPageContext();
            final FeedComponent feedComponent = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.artist.FeedComponent$FeedComponentLoader$handleLoadSuccess$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-946106141")) {
                        return (wt2) ipChange2.ipc$dispatch("-946106141", new Object[]{this});
                    }
                    GenericFragment fragment = FeedComponent.this.getPageContext().getFragment();
                    BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                    if (baseFragment != null) {
                        baseFragment.hideLoadingDialog(FeedComponent.this.getPageContext().getActivity());
                        return wt2.INSTANCE;
                    }
                    return null;
                }
            });
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull final Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1180072403")) {
                ipChange.ipc$dispatch("-1180072403", new Object[]{this, map});
                return;
            }
            b41.i(map, Constants.CONFIG);
            IContext pageContext = this.this$0.getPageContext();
            final FeedComponent feedComponent = this.this$0;
            pageContext.runOnUIThread(new Function0<Activity>() { // from class: com.alibaba.pictures.bricks.artist.FeedComponent$FeedComponentLoader$load$1
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
                    if (AndroidInstantRuntime.support(ipChange2, "1730514485")) {
                        return (Activity) ipChange2.ipc$dispatch("1730514485", new Object[]{this});
                    }
                    Activity activity = FeedComponent.this.getPageContext().getActivity();
                    if (activity != null) {
                        Map<String, Object> map2 = map;
                        FeedComponent feedComponent2 = FeedComponent.this;
                        if (b41.d(map2.get("index"), 1)) {
                            GenericFragment fragment = feedComponent2.getPageContext().getFragment();
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
    public final class FeedLoadBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        public FeedLoadBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-597418309")) {
                return (IRequest) ipChange.ipc$dispatch("-597418309", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Bundle bundle = FeedComponent.this.getPageContext().getBundle();
            if (bundle != null && (obj = bundle.get(l8.KEY_ARTIST_ID)) != null) {
                linkedHashMap.put(l8.KEY_ARTIST_ID, obj);
            }
            Object obj2 = map.get("index");
            if (obj2 != null) {
                linkedHashMap.put("pageNo", (Integer) obj2);
            }
            linkedHashMap2.put("patternName", l8.PATTERN_NAME);
            linkedHashMap2.put("patternVersion", "1.0");
            JSONObject data = FeedComponent.this.getModule().getProperty().getData();
            String str = (String) (data != null ? data.get("nodeId") : null);
            JSONObject data2 = FeedComponent.this.getProperty().getData();
            return l8.INSTANCE.a(2L, linkedHashMap, linkedHashMap2, str, (String) (data2 != null ? data2.get("nodeId") : null));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class FeedLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public FeedLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1421099114")) {
                ipChange.ipc$dispatch("-1421099114", new Object[]{this});
                return;
            }
            final PagingLoader componentLoader = FeedComponent.this.getComponentLoader();
            if (componentLoader != null) {
                final FeedComponent feedComponent = FeedComponent.this;
                feedComponent.getPageContext().runOnUIThread(new Function0<RefreshLayout>() { // from class: com.alibaba.pictures.bricks.artist.FeedComponent$FeedLoadingListener$onAllPageLoaded$1$1
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
                        if (AndroidInstantRuntime.support(ipChange2, "872127001")) {
                            return (RefreshLayout) ipChange2.ipc$dispatch("872127001", new Object[]{this});
                        }
                        if (PagingLoader.this.getLoadingPage() >= 2) {
                            BricksToastUtil.INSTANCE.b("都被你看光啦，过会儿再来吧~");
                        }
                        GenericFragment fragment = feedComponent.getPageContext().getFragment();
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
            if (AndroidInstantRuntime.support(ipChange, "1988851076")) {
                ipChange.ipc$dispatch("1988851076", new Object[]{this, str});
            } else {
                FeedComponent.this.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.artist.FeedComponent$FeedLoadingListener$onLoadNextFailure$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ wt2 invoke() {
                        invoke2();
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1624139583")) {
                            ipChange2.ipc$dispatch("-1624139583", new Object[]{this});
                        } else {
                            BricksToastUtil.INSTANCE.b("小二很忙，系统很累，稍后再试吧");
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, Constants.CONFIG);
        this.context = iContext;
        setComponentLoader(new FeedComponentLoader(this, this));
        setRequestBuilder(new FeedLoadBuilder());
        this.projectLoadingListener = new FeedLoadingListener();
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "512767") ? (IContext) ipChange.ipc$dispatch("512767", new Object[]{this}) : this.context;
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onAdd() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738722296")) {
            ipChange.ipc$dispatch("1738722296", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-741915347")) {
            ipChange.ipc$dispatch("-741915347", new Object[]{this});
            return;
        }
        super.onRemove();
        FeedLoadingListener feedLoadingListener = this.projectLoadingListener;
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader == null || (loadingViewManager = componentLoader.getLoadingViewManager()) == null) {
            return;
        }
        loadingViewManager.removeLoadingStateListener(feedLoadingListener);
    }
}
