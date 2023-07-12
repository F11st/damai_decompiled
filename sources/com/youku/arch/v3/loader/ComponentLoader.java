package com.youku.arch.v3.loader;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001a2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016¨\u0006\u001b"}, d2 = {"Lcom/youku/arch/v3/loader/ComponentLoader;", "Lcom/youku/arch/v3/loader/AbsLoader;", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "", "", "", Constants.CONFIG, "Ltb/wt2;", "load", "Lcom/youku/arch/v3/io/IResponse;", "response", "", "index", "handleLoadSuccess", "handleLoadFailure", "Lcom/youku/arch/v3/core/Node;", "node", "createItems", "Lcom/alibaba/fastjson/JSONObject;", "parseNode", "setLoadingViewState", "reset", "component", "<init>", "(Lcom/youku/arch/v3/IComponent;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ComponentLoader extends AbsLoader<IComponent<ComponentValue>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START = 2;
    public static final int REFRESH_PAGE_INDEX = 1;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/loader/ComponentLoader$Companion;", "", "", "DEFAULT_PAGE_START", "I", "REFRESH_PAGE_INDEX", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentLoader(@NotNull IComponent<ComponentValue> iComponent) {
        super(iComponent);
        RefreshLayout refreshLayout;
        b41.i(iComponent, "component");
        GenericFragment fragment = getHost().getPageContext().getFragment();
        if (fragment != null && (refreshLayout = fragment.getRefreshLayout()) != null) {
            RefreshLayoutManger refreshLayoutManger = new RefreshLayoutManger();
            refreshLayoutManger.setRefreshLayout(refreshLayout);
            getLoadingViewManager().addLoadingStateListener(refreshLayoutManger);
        }
        setStartPage(2);
        setLoadingPage(getStartPage());
    }

    public void createItems(@NotNull Node node, final int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1603987063")) {
            ipChange.ipc$dispatch("1603987063", new Object[]{this, node, Integer.valueOf(i)});
            return;
        }
        b41.i(node, "node");
        final IComponent<ComponentValue> host = getHost();
        if (node.getType() == host.getType()) {
            final int childCount = host.getChildCount();
            host.initProperties(node);
            if (i == 1) {
                ((GenericComponent) getHost()).childItems.clear();
            }
            List<Node> children = node.getChildren();
            if ((children == null || children.isEmpty()) ? true : true) {
                host.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ComponentLoader$createItems$1$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final wt2 invoke() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "2056182391")) {
                            return (wt2) ipChange2.ipc$dispatch("2056182391", new Object[]{this});
                        }
                        if (i == 1) {
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = host.getAdapter();
                            if (adapter == null) {
                                return null;
                            }
                            adapter.notifyItemRangeRemoved(0, childCount);
                            return wt2.INSTANCE;
                        }
                        this.getHost().getProperty().setMore(false);
                        this.getLoadingViewManager().onAllPageLoaded();
                        this.setLoadingState(3);
                        return wt2.INSTANCE;
                    }
                });
                return;
            } else {
                host.getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ComponentLoader$createItems$1$2
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ wt2 invoke() {
                        invoke2();
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RecyclerView recyclerView;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1375278457")) {
                            ipChange2.ipc$dispatch("1375278457", new Object[]{this});
                            return;
                        }
                        try {
                            List<Node> children2 = host.getProperty().getChildren();
                            if (children2 != null) {
                                IComponent<ComponentValue> iComponent = host;
                                ComponentLoader componentLoader = this;
                                int i2 = 0;
                                for (Object obj : children2) {
                                    int i3 = i2 + 1;
                                    if (i2 < 0) {
                                        C8214m.p();
                                    }
                                    Node node2 = (Node) obj;
                                    IItem<ItemValue> createItem = iComponent.createItem(new Config<>(iComponent.getPageContext(), node2.getType(), node2, 0, false, 24, null));
                                    if (createItem != null) {
                                        ((GenericComponent) componentLoader.getHost()).childItems.add(createItem);
                                        createItem.setIndex(i2);
                                        createItem.onAdd();
                                        ((GenericComponent) componentLoader.getHost()).getChildIndexUpdater().onChildAdded(createItem);
                                    }
                                    i2 = i3;
                                }
                            }
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = host.getAdapter();
                            if (adapter != null) {
                                adapter.dataCount = host.getChildCount();
                            }
                            GenericFragment fragment = host.getPageContext().getFragment();
                            if (fragment != null && (recyclerView = fragment.getRecyclerView()) != null) {
                                int i4 = i;
                                IComponent<ComponentValue> iComponent2 = host;
                                int i5 = childCount;
                                if (!recyclerView.isComputingLayout()) {
                                    if (i4 == 1) {
                                        IContainer<ModelValue> pageContainer = iComponent2.getPageContext().getPageContainer();
                                        if (pageContainer != null) {
                                            pageContainer.updateContentAdapter();
                                        }
                                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = iComponent2.getAdapter();
                                        if (adapter2 != null) {
                                            adapter2.notifyItemRangeChanged(0, iComponent2.getChildCount());
                                        }
                                    } else {
                                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter3 = iComponent2.getAdapter();
                                        if (adapter3 != null) {
                                            adapter3.notifyItemRangeInserted(i5, iComponent2.getChildCount() - i5);
                                        }
                                    }
                                }
                            }
                            this.setLoadingPage(i);
                            this.setLoadingViewState();
                        } catch (Exception e) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
                return;
            }
        }
        getHost().getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ComponentLoader$createItems$1$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1081875450")) {
                    ipChange2.ipc$dispatch("1081875450", new Object[]{this});
                    return;
                }
                ComponentLoader.this.getLoadingViewManager().onLoadNextFailure(null);
                ComponentLoader.this.setLoadingState(2);
            }
        });
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821103545")) {
            ipChange.ipc$dispatch("1821103545", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        getHost().getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ComponentLoader$handleLoadFailure$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "640276995")) {
                    ipChange2.ipc$dispatch("640276995", new Object[]{this});
                    return;
                }
                ComponentLoader.this.getLoadingViewManager().onLoadNextFailure(null);
                ComponentLoader.this.setLoadingState(2);
            }
        });
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull final IResponse iResponse, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439592349")) {
            ipChange.ipc$dispatch("-439592349", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        b41.i(iResponse, "response");
        setLoadingPage(i);
        getHost().getPageContext().runOnLoaderThreadLocked(new Function0<Object>() { // from class: com.youku.arch.v3.loader.ComponentLoader$handleLoadSuccess$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:69:0x00d5, code lost:
                if (r7.getLevel() == 2) goto L52;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00a3 A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:23:0x004e, B:34:0x0082, B:49:0x00a3, B:96:0x016e, B:59:0x00b5, B:62:0x00bf, B:71:0x00d9, B:77:0x00ea, B:79:0x00fa, B:86:0x011b, B:89:0x012f, B:92:0x0138, B:82:0x010b, B:85:0x0114, B:93:0x014c, B:74:0x00e0, B:65:0x00c7, B:68:0x00d0, B:44:0x0094, B:47:0x009d, B:32:0x007c, B:26:0x0063, B:29:0x006c), top: B:107:0x004e }] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00b0  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x00b3 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x00b5 A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:23:0x004e, B:34:0x0082, B:49:0x00a3, B:96:0x016e, B:59:0x00b5, B:62:0x00bf, B:71:0x00d9, B:77:0x00ea, B:79:0x00fa, B:86:0x011b, B:89:0x012f, B:92:0x0138, B:82:0x010b, B:85:0x0114, B:93:0x014c, B:74:0x00e0, B:65:0x00c7, B:68:0x00d0, B:44:0x0094, B:47:0x009d, B:32:0x007c, B:26:0x0063, B:29:0x006c), top: B:107:0x004e }] */
            /* JADX WARN: Removed duplicated region for block: B:65:0x00c7 A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:23:0x004e, B:34:0x0082, B:49:0x00a3, B:96:0x016e, B:59:0x00b5, B:62:0x00bf, B:71:0x00d9, B:77:0x00ea, B:79:0x00fa, B:86:0x011b, B:89:0x012f, B:92:0x0138, B:82:0x010b, B:85:0x0114, B:93:0x014c, B:74:0x00e0, B:65:0x00c7, B:68:0x00d0, B:44:0x0094, B:47:0x009d, B:32:0x007c, B:26:0x0063, B:29:0x006c), top: B:107:0x004e }] */
            /* JADX WARN: Removed duplicated region for block: B:71:0x00d9 A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:23:0x004e, B:34:0x0082, B:49:0x00a3, B:96:0x016e, B:59:0x00b5, B:62:0x00bf, B:71:0x00d9, B:77:0x00ea, B:79:0x00fa, B:86:0x011b, B:89:0x012f, B:92:0x0138, B:82:0x010b, B:85:0x0114, B:93:0x014c, B:74:0x00e0, B:65:0x00c7, B:68:0x00d0, B:44:0x0094, B:47:0x009d, B:32:0x007c, B:26:0x0063, B:29:0x006c), top: B:107:0x004e }] */
            /* JADX WARN: Removed duplicated region for block: B:75:0x00e7  */
            /* JADX WARN: Removed duplicated region for block: B:96:0x016e A[Catch: Exception -> 0x018e, TRY_LEAVE, TryCatch #0 {Exception -> 0x018e, blocks: (B:23:0x004e, B:34:0x0082, B:49:0x00a3, B:96:0x016e, B:59:0x00b5, B:62:0x00bf, B:71:0x00d9, B:77:0x00ea, B:79:0x00fa, B:86:0x011b, B:89:0x012f, B:92:0x0138, B:82:0x010b, B:85:0x0114, B:93:0x014c, B:74:0x00e0, B:65:0x00c7, B:68:0x00d0, B:44:0x0094, B:47:0x009d, B:32:0x007c, B:26:0x0063, B:29:0x006c), top: B:107:0x004e }] */
            /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v6 */
            @Override // kotlin.jvm.functions.Function0
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invoke() {
                /*
                    Method dump skipped, instructions count: 455
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.loader.ComponentLoader$handleLoadSuccess$1.invoke():java.lang.Object");
            }
        });
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360366123")) {
            ipChange.ipc$dispatch("-360366123", new Object[]{this, map});
            return;
        }
        b41.i(map, Constants.CONFIG);
        Object obj = map.get("index");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        final int intValue = ((Integer) obj).intValue();
        IComponent<ComponentValue> host = getHost();
        IRequest createRequest = host.createRequest(map);
        if (createRequest == null) {
            return;
        }
        String pageName = getHost().getPageContext().getPageName();
        if (pageName != null && (archMontior = ArchMontiorManager.Companion.get(pageName)) != null) {
            LogUtil.d(ArchMontiorManager.TAG, "ComponentLoader request +++ ");
            archMontior.setRequestTime(System.currentTimeMillis());
            archMontior.setApiName(createRequest.getApiName());
        }
        host.request(createRequest, new Callback() { // from class: com.youku.arch.v3.loader.ComponentLoader$load$1$1$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                ArchMontior archMontior2;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2003772303")) {
                    ipChange2.ipc$dispatch("2003772303", new Object[]{this, iResponse});
                    return;
                }
                b41.i(iResponse, "response");
                String pageName2 = ComponentLoader.this.getHost().getPageContext().getPageName();
                if (pageName2 != null && (archMontior2 = ArchMontiorManager.Companion.get(pageName2)) != null) {
                    archMontior2.setRequestTime(System.currentTimeMillis() - archMontior2.getRequestTime());
                    LogUtil.d(ArchMontiorManager.TAG, b41.r("ComponentLoader request --- ", Long.valueOf(archMontior2.getRequestTime())));
                }
                if (iResponse.isSuccess()) {
                    ComponentLoader.this.handleLoadSuccess(iResponse, intValue);
                } else {
                    ComponentLoader.this.handleLoadFailure(iResponse);
                }
            }
        });
    }

    @Nullable
    public Node parseNode(@NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266575843")) {
            return (Node) ipChange.ipc$dispatch("-1266575843", new Object[]{this, jSONObject});
        }
        b41.i(jSONObject, "response");
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            b41.h(jSONObject, "dataJsonObject.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922645243")) {
            ipChange.ipc$dispatch("-1922645243", new Object[]{this});
            return;
        }
        setLoadingState(0);
        setLoadingPage(getStartPage());
    }

    public void setLoadingViewState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1882629026")) {
            ipChange.ipc$dispatch("1882629026", new Object[]{this});
        } else if (getHost().hasNext()) {
            getLoadingViewManager().onLoadNextSuccess();
            setLoadingPage(getLoadingPage() + 1);
            getLoadingPage();
            setLoadingState(0);
        } else {
            setLoadingState(3);
            getLoadingViewManager().onAllPageLoaded();
        }
    }
}
