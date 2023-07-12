package cn.damai.search.component.script;

import android.app.Activity;
import cn.damai.common.AppConfig;
import cn.damai.common.util.toastutil.C0537a;
import cn.damai.live.LiveActivity;
import cn.damai.onearch.errpage.ErrorControlView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.loader.BaseComponentLoader;
import com.alient.onearch.adapter.request.DRParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.IdGenerator;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ir1;
import tb.jn1;
import tb.k50;
import tb.mr1;
import tb.w20;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ScriptComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String API_NAME = "mtop.damai.mec.aristotle.get";
    @NotNull
    public static final C1574a Companion = new C1574a(null);
    private static final boolean NEED_ENCODE = false;
    private static final boolean NEED_SESSION = false;
    private static final int REQUEST_TIME_OUT = 3000;
    @NotNull
    private static final String VERSION = "1.0";
    @NotNull
    private final IContext context;
    @Nullable
    private ScriptLoadingListener scriptLoadingListener;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class ScriptComponentLoader extends BaseComponentLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final LoadingViewManager componentLoadingViewManager;
        private int startPage;
        final /* synthetic */ ScriptComponent this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScriptComponentLoader(@NotNull ScriptComponent scriptComponent, IComponent<ComponentValue> iComponent) {
            super(iComponent);
            b41.i(iComponent, "component");
            this.this$0 = scriptComponent;
            this.componentLoadingViewManager = new LoadingViewManager();
            this.startPage = 2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.AbsLoader
        public int getStartPage() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1904625958") ? ((Integer) ipChange.ipc$dispatch("-1904625958", new Object[]{this})).intValue() : this.startPage;
        }

        @Override // com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2011330167")) {
                ipChange.ipc$dispatch("-2011330167", new Object[]{this, map});
                return;
            }
            b41.i(map, Constants.CONFIG);
            super.load(map);
            setLoadingViewManager(this.componentLoadingViewManager);
            getLoadingViewManager().addLoadingStateListener(this.this$0.scriptLoadingListener);
            if (getLoadingPage() == getStartPage()) {
                GenericFragment fragment = this.this$0.getContext().getFragment();
                ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
                if (errorControlView != null) {
                    errorControlView.showDialogLoading(true);
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.BaseComponentLoader
        public int parseComponentType(@Nullable String str) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1628606523")) {
                return ((Integer) ipChange.ipc$dispatch("1628606523", new Object[]{this, str})).intValue();
            }
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                return -1;
            }
            return ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.AbsLoader
        public void setStartPage(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-745275536")) {
                ipChange.ipc$dispatch("-745275536", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.startPage = i;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class ScriptLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public ScriptLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1893740302")) {
                ipChange.ipc$dispatch("-1893740302", new Object[]{this});
            } else if (ScriptComponent.this.getComponentLoader() != null) {
                final ScriptComponent scriptComponent = ScriptComponent.this;
                HashMap hashMap = new HashMap();
                hashMap.put("componentId", Integer.valueOf(scriptComponent.getType()));
                EventDispatcher eventDispatcher = scriptComponent.getPageContext().getEventDispatcher();
                if (eventDispatcher != null) {
                    eventDispatcher.dispatchEvent("script_all_loaded", hashMap);
                }
                scriptComponent.getPageContext().runOnUIThread(new Function0<RefreshLayout>() { // from class: cn.damai.search.component.script.ScriptComponent$ScriptLoadingListener$onAllPageLoaded$1$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final RefreshLayout invoke() {
                        RefreshLayout refreshLayout;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1404950901")) {
                            return (RefreshLayout) ipChange2.ipc$dispatch("1404950901", new Object[]{this});
                        }
                        GenericFragment fragment = ScriptComponent.this.getContext().getFragment();
                        ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
                        if (errorControlView != null) {
                            errorControlView.showDialogLoading(false);
                        }
                        GenericFragment fragment2 = ScriptComponent.this.getContext().getFragment();
                        if (fragment2 == null || (refreshLayout = fragment2.getRefreshLayout()) == null) {
                            return null;
                        }
                        return refreshLayout.setEnableLoadMore(false);
                    }
                });
            }
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextFailure(@Nullable final String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-677035808")) {
                ipChange.ipc$dispatch("-677035808", new Object[]{this, str});
                return;
            }
            IContext pageContext = ScriptComponent.this.getPageContext();
            final ScriptComponent scriptComponent = ScriptComponent.this;
            pageContext.runOnUIThread(new Function0<Activity>() { // from class: cn.damai.search.component.script.ScriptComponent$ScriptLoadingListener$onLoadNextFailure$1
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
                    RefreshLayout refreshLayout;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1507420701")) {
                        return (Activity) ipChange2.ipc$dispatch("-1507420701", new Object[]{this});
                    }
                    Activity activity = ScriptComponent.this.getContext().getActivity();
                    if (activity != null) {
                        ScriptComponent scriptComponent2 = ScriptComponent.this;
                        String str2 = str;
                        GenericFragment fragment = scriptComponent2.getContext().getFragment();
                        ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
                        if (errorControlView != null) {
                            errorControlView.showDialogLoading(false);
                        }
                        GenericFragment fragment2 = scriptComponent2.getContext().getFragment();
                        if (fragment2 != null && (refreshLayout = fragment2.getRefreshLayout()) != null) {
                            refreshLayout.setEnableLoadMore(false);
                        }
                        C0537a.i(activity, str2);
                        return activity;
                    }
                    return null;
                }
            });
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1167721341")) {
                ipChange.ipc$dispatch("1167721341", new Object[]{this});
                return;
            }
            IContext pageContext = ScriptComponent.this.getPageContext();
            final ScriptComponent scriptComponent = ScriptComponent.this;
            pageContext.runOnUIThread(new Function0<Activity>() { // from class: cn.damai.search.component.script.ScriptComponent$ScriptLoadingListener$onLoadNextSuccess$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Activity invoke() {
                    RefreshLayout refreshLayout;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1090809034")) {
                        return (Activity) ipChange2.ipc$dispatch("1090809034", new Object[]{this});
                    }
                    Activity activity = ScriptComponent.this.getContext().getActivity();
                    if (activity != null) {
                        ScriptComponent scriptComponent2 = ScriptComponent.this;
                        GenericFragment fragment = scriptComponent2.getContext().getFragment();
                        ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
                        if (errorControlView != null) {
                            errorControlView.showDialogLoading(false);
                        }
                        GenericFragment fragment2 = scriptComponent2.getContext().getFragment();
                        if (fragment2 == null || (refreshLayout = fragment2.getRefreshLayout()) == null) {
                            return activity;
                        }
                        refreshLayout.setEnableLoadMore(false);
                        return activity;
                    }
                    return null;
                }
            });
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onNextPageLoading() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1686611059")) {
                ipChange.ipc$dispatch("-1686611059", new Object[]{this});
                return;
            }
            GenericFragment fragment = ScriptComponent.this.getContext().getFragment();
            ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
            if (errorControlView != null) {
                errorControlView.showDialogLoading(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class ScriptRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        public ScriptRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1790578468")) {
                return (IRequest) ipChange.ipc$dispatch("1790578468", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            HashMap hashMap = new HashMap();
            hashMap.put("patternName", "searchScriptKill");
            hashMap.put("patternVersion", "1.0");
            HashMap hashMap2 = new HashMap();
            String c = z20.c();
            b41.h(c, "getCityId()");
            hashMap2.put("comboDamaiCityId", c);
            if (ir1.i(mr1.LOCATION)) {
                hashMap2.put("latitude", Double.valueOf(z20.n()));
                hashMap2.put("longitude", Double.valueOf(z20.o()));
            }
            hashMap2.put(Constants.Name.PAGE_SIZE, 5);
            String p = AppConfig.p();
            b41.h(p, "getTtid()");
            hashMap2.put(LiveActivity.OPTION_TTID, p);
            Object obj2 = map.get("index");
            Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
            if (num != null) {
                hashMap2.put("pageNo", Integer.valueOf(num.intValue()));
            }
            ConcurrentMap<String, Object> concurrentMap = ScriptComponent.this.getPageContext().getConcurrentMap();
            if (concurrentMap != null && (obj = concurrentMap.get("keyword")) != null) {
                hashMap2.put("keyword", obj);
            }
            JSONObject data = ScriptComponent.this.getModule().getProperty().getData();
            String str = (String) (data != null ? data.get("layerId") : null);
            JSONObject data2 = ScriptComponent.this.getProperty().getData();
            DRParam dRParam = new DRParam(str, (String) (data2 != null ? data2.get("sectionId") : null), JSON.toJSONString(hashMap2));
            hashMap.put("dr", jn1.ARRAY_START + JSON.toJSONString(dRParam) + jn1.ARRAY_END);
            String jSONString = JSON.toJSONString(hashMap2);
            b41.h(jSONString, "toJSONString(args)");
            hashMap.put("args", jSONString);
            Map<String, String> c2 = w20.b().c(ScriptComponent.API_NAME, hashMap);
            b41.h(c2, "getInstance().getParams(…AME, params\n            )");
            return new Request.Builder().setApiName(ScriptComponent.API_NAME).setVersion("1.0").setNeedECode(false).setNeedSession(false).setTimeout(3000).setStrategy(2L).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(c2)).build();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.component.script.ScriptComponent$a */
    /* loaded from: classes15.dex */
    public static final class C1574a {
        private C1574a() {
        }

        public /* synthetic */ C1574a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, com.youku.arch.v3.core.Constants.CONFIG);
        this.context = iContext;
        setComponentLoader(new ScriptComponentLoader(this, this));
        setRequestBuilder(new ScriptRequestBuilder());
        this.scriptLoadingListener = new ScriptLoadingListener();
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-782855056") ? (IContext) ipChange.ipc$dispatch("-782855056", new Object[]{this}) : this.context;
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578815838")) {
            return ((Boolean) ipChange.ipc$dispatch("578815838", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (b41.d(str, "script_load_more")) {
            if (map != null && (obj = map.get("componentId")) != null && b41.d(obj, Integer.valueOf(getType()))) {
                loadMore();
            }
            return true;
        }
        return super.onMessage(str, map);
    }
}
