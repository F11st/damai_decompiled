package com.youku.arch.v3.loader;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.Util;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.wt2;
import tb.xl2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001cB\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u001c\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\t\u0010\u0018\u001a\u00020\u0017H\u0094\u0002¨\u0006\u001d"}, d2 = {"Lcom/youku/arch/v3/loader/ModuleLoader;", "Lcom/youku/arch/v3/loader/AbsLoader;", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "Lcom/alibaba/fastjson/JSONObject;", "response", "Lcom/youku/arch/v3/core/Node;", "parseNode", "node", "", "index", "Ltb/wt2;", "createComponents", "setLoadingViewState", "", "", "", Constants.CONFIG, "load", "Lcom/youku/arch/v3/io/IResponse;", "handleLoadSuccess", "handleLoadFailure", "reset", "", xl2.HAS_NEXT, "module", "<init>", "(Lcom/youku/arch/v3/IModule;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ModuleLoader extends AbsLoader<IModule<ModuleValue>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START = 2;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/loader/ModuleLoader$Companion;", "", "", "DEFAULT_PAGE_START", "I", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleLoader(@NotNull IModule<ModuleValue> iModule) {
        super(iModule);
        b41.i(iModule, "module");
        setLoadingViewManager(getHost().getContainer().getPageLoader().getLoadingViewManager());
        setStartPage(2);
        setLoadingPage(getStartPage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createComponents(Node node, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361465568")) {
            ipChange.ipc$dispatch("-361465568", new Object[]{this, node, Integer.valueOf(i)});
            return;
        }
        Util.throwIf(node == null);
        b41.f(node);
        getHost().initProperties(node);
        final int childCount = getHost().getChildCount();
        List<Node> children = getHost().getProperty().getChildren();
        b41.f(children);
        getHost().createComponents(children);
        getHost().getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ModuleLoader$createComponents$1
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
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1503386002")) {
                    ipChange2.ipc$dispatch("1503386002", new Object[]{this});
                    return;
                }
                ModuleLoader.this.setLoadingPage(i);
                for (DelegateAdapter.Adapter<?> adapter : PageUtil.INSTANCE.getSubAdapters(ModuleLoader.this.getHost(), childCount, ModuleLoader.this.getHost().getChildCount())) {
                    adapter.notifyItemRangeInserted(0, adapter.getItemCount());
                }
                ModuleLoader.this.setLoadingViewState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Node parseNode(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713289422")) {
            return (Node) ipChange.ipc$dispatch("-713289422", new Object[]{this, jSONObject});
        }
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            b41.h(jSONObject, "dataResponse.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLoadingViewState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089770835")) {
            ipChange.ipc$dispatch("-1089770835", new Object[]{this});
        } else if (hasNext()) {
            getLoadingViewManager().onLoadNextSuccess();
            setLoadingPage(getLoadingPage() + 1);
            getLoadingPage();
            setLoadingState(0);
        } else {
            setLoadingState(3);
            getLoadingViewManager().onAllPageLoaded();
        }
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368380028")) {
            ipChange.ipc$dispatch("-368380028", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        getHost().getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ModuleLoader$handleLoadFailure$1
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
                if (AndroidInstantRuntime.support(ipChange2, "-1050402664")) {
                    ipChange2.ipc$dispatch("-1050402664", new Object[]{this});
                    return;
                }
                ModuleLoader.this.getLoadingViewManager().onLoadNextFailure(null);
                ModuleLoader.this.setLoadingState(2);
            }
        });
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull final IResponse iResponse, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405893624")) {
            ipChange.ipc$dispatch("405893624", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        b41.i(iResponse, "response");
        setLoadingPage(i);
        getHost().getPageContext().runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ModuleLoader$handleLoadSuccess$1
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
                Node parseNode;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2086541487")) {
                    ipChange2.ipc$dispatch("-2086541487", new Object[]{this});
                    return;
                }
                Callback callback = ModuleLoader.this.getCallback();
                if (callback != null) {
                    callback.onResponse(iResponse);
                }
                JSONObject jsonObject = iResponse.getJsonObject();
                if (jsonObject != null) {
                    ModuleLoader moduleLoader = ModuleLoader.this;
                    int i2 = i;
                    parseNode = moduleLoader.parseNode(jsonObject);
                    moduleLoader.createComponents(parseNode, i2);
                }
                ModuleLoader.this.setLoadingState(0);
            }
        });
    }

    protected boolean hasNext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175883082")) {
            return ((Boolean) ipChange.ipc$dispatch("-1175883082", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962201312")) {
            ipChange.ipc$dispatch("962201312", new Object[]{this, map});
            return;
        }
        b41.i(map, Constants.CONFIG);
        Object obj = map.get("index");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        final int intValue = ((Integer) obj).intValue();
        IRequest createRequest = getHost().createRequest(map);
        if (createRequest == null) {
            return;
        }
        getHost().request(createRequest, new Callback() { // from class: com.youku.arch.v3.loader.ModuleLoader$load$1$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-527605812")) {
                    ipChange2.ipc$dispatch("-527605812", new Object[]{this, iResponse});
                    return;
                }
                b41.i(iResponse, "response");
                if (iResponse.isSuccess()) {
                    ModuleLoader.this.handleLoadSuccess(iResponse, intValue);
                } else {
                    ModuleLoader.this.handleLoadFailure(iResponse);
                }
            }
        });
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888622256")) {
            ipChange.ipc$dispatch("-1888622256", new Object[]{this});
            return;
        }
        setLoadingState(0);
        setLoadingPage(getStartPage());
    }
}
