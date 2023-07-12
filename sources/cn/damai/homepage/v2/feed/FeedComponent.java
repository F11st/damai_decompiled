package cn.damai.homepage.v2.feed;

import android.text.TextUtils;
import cn.damai.common.util.ToastUtil;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.loader.v2.GenericComponentLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.page.GenericFragment;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ci0;
import tb.wt2;
import tb.wy0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class FeedComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private FeedLoadingListener feedLoadingListener;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
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
            if (AndroidInstantRuntime.support(ipChange, "-1736069360")) {
                ipChange.ipc$dispatch("-1736069360", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "itemIterator");
            b41.i(node, "itemNode");
            ci0.INSTANCE.a(node);
            super.handleItemNode(listIterator, node);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public final class FeedLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public FeedLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-883160178")) {
                ipChange.ipc$dispatch("-883160178", new Object[]{this});
                return;
            }
            final PagingLoader componentLoader = FeedComponent.this.getComponentLoader();
            if (componentLoader != null) {
                final FeedComponent feedComponent = FeedComponent.this;
                feedComponent.getPageContext().runOnUIThread(new Function0<RefreshLayout>() { // from class: cn.damai.homepage.v2.feed.FeedComponent$FeedLoadingListener$onAllPageLoaded$1$1
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
                        if (AndroidInstantRuntime.support(ipChange2, "1946477073")) {
                            return (RefreshLayout) ipChange2.ipc$dispatch("1946477073", new Object[]{this});
                        }
                        if (PagingLoader.this.getLoadingPage() >= 2) {
                            ToastUtil.b("都被你看光啦，过会儿再来吧~", 0);
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
            if (AndroidInstantRuntime.support(ipChange, "-222947972")) {
                ipChange.ipc$dispatch("-222947972", new Object[]{this, str});
            } else {
                FeedComponent.this.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: cn.damai.homepage.v2.feed.FeedComponent$FeedLoadingListener$onLoadNextFailure$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ wt2 invoke() {
                        invoke2();
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1420599753")) {
                            ipChange2.ipc$dispatch("1420599753", new Object[]{this});
                        } else {
                            ToastUtil.b("小二很忙，系统很累，稍后再试吧", 0);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public final class FeedRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        public FeedRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1602003648")) {
                return (IRequest) ipChange.ipc$dispatch("1602003648", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Object obj2 = map.get("index");
            if (obj2 != null) {
                hashMap2.put("pageNo", (Integer) obj2);
            }
            JSONObject data = FeedComponent.this.getProperty().getData();
            if (data != null && (obj = data.get("offSet")) != null) {
                hashMap2.put("offSet", obj);
            }
            JSONObject data2 = FeedComponent.this.getModule().getProperty().getData();
            String str = (String) (data2 != null ? data2.get("nodeId") : null);
            JSONObject data3 = FeedComponent.this.getProperty().getData();
            return wy0.INSTANCE.a(2L, hashMap2, hashMap, str, (String) (data3 != null ? data3.get("nodeId") : null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, Constants.CONFIG);
        this.context = iContext;
        setComponentLoader(new FeedComponentLoader(this, this));
        setRequestBuilder(new FeedRequestBuilder());
        this.feedLoadingListener = new FeedLoadingListener();
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.IItemManager
    @Nullable
    public IItem<ItemValue> createItem(@NotNull Config<Node> config) {
        Node node;
        JSONObject data;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882832341")) {
            return (IItem) ipChange.ipc$dispatch("882832341", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        GenericFactory<IItem<ItemValue>, Node> itemFactory = getItemFactory();
        String str = null;
        IItem<ItemValue> create = itemFactory != null ? itemFactory.create(config) : null;
        if (create != null) {
            b41.g(this, "null cannot be cast to non-null type com.youku.arch.v3.IComponent<com.youku.arch.v3.core.ComponentValue>");
            create.setComponent(this);
            create.initProperties(config.getData());
            JSONObject data2 = create.getComponent().getProperty().getData();
            if (data2 != null && (jSONObject5 = data2.getJSONObject("action")) != null && (jSONObject6 = jSONObject5.getJSONObject("tab")) != null && (jSONObject7 = jSONObject6.getJSONObject("trackInfo")) != null && (jSONObject8 = jSONObject7.getJSONObject("args")) != null) {
                str = jSONObject8.getString("titlelabel");
            }
            if (!TextUtils.isEmpty(str) && (node = ((GenericItem) create).getNode()) != null && (data = node.getData()) != null && (jSONObject = data.getJSONObject("action")) != null && (jSONObject2 = jSONObject.getJSONObject("item")) != null && (jSONObject3 = jSONObject2.getJSONObject("trackInfo")) != null && (jSONObject4 = jSONObject3.getJSONObject("args")) != null) {
                b41.h(jSONObject4, "getJSONObject(\"args\")");
                jSONObject4.put((JSONObject) "titlelabel", str);
            }
        }
        return create;
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1212194823") ? (IContext) ipChange.ipc$dispatch("1212194823", new Object[]{this}) : this.context;
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onAdd() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860215792")) {
            ipChange.ipc$dispatch("860215792", new Object[]{this});
            return;
        }
        super.onAdd();
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader == null || (loadingViewManager = componentLoader.getLoadingViewManager()) == null) {
            return;
        }
        loadingViewManager.removeLoadingStateListener(this.feedLoadingListener);
        loadingViewManager.addLoadingStateListener(this.feedLoadingListener);
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onRemove() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201525813")) {
            ipChange.ipc$dispatch("1201525813", new Object[]{this});
            return;
        }
        super.onRemove();
        FeedLoadingListener feedLoadingListener = this.feedLoadingListener;
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader == null || (loadingViewManager = componentLoader.getLoadingViewManager()) == null) {
            return;
        }
        loadingViewManager.removeLoadingStateListener(feedLoadingListener);
    }
}
