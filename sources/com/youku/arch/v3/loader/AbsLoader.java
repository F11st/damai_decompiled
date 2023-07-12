package com.youku.arch.v3.loader;

import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.DomainObject;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.event.LoaderEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.middlewareservice.provider.analytics.AnalyticsProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.tq2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 <*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002=<B\u000f\u0012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0004\b;\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0004J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\"\u0010\u0018\u001a\u00028\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00048\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010+\u001a\u00020*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00103\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001018\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00128V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/youku/arch/v3/loader/AbsLoader;", "Lcom/youku/arch/v3/DomainObject;", "HOST", "Lcom/youku/arch/v3/loader/PagingLoader;", "", "loadPage", "Ltb/wt2;", "loadNextPage", "", "", "", Constants.CONFIG, "load", "Lcom/youku/arch/v3/io/IResponse;", "response", "index", "handleLoadSuccess", "handleLoadFailure", "", "hasExtraData", "hasNextPage", "canLoadNextPage", "reload", "reset", "host", "Lcom/youku/arch/v3/DomainObject;", "getHost", "()Lcom/youku/arch/v3/DomainObject;", "setHost", "(Lcom/youku/arch/v3/DomainObject;)V", "startPage", "I", "getStartPage", "()I", "setStartPage", "(I)V", "loadingState", "getLoadingState", "setLoadingState", "loadingPage", "getLoadingPage", "setLoadingPage", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "loadingViewManager", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "getLoadingViewManager", "()Lcom/youku/arch/v3/loader/LoadingViewManager;", "setLoadingViewManager", "(Lcom/youku/arch/v3/loader/LoadingViewManager;)V", "Lcom/youku/arch/v3/io/Callback;", "value", WXBridgeManager.METHOD_CALLBACK, "Lcom/youku/arch/v3/io/Callback;", "getCallback", "()Lcom/youku/arch/v3/io/Callback;", "setCallback", "(Lcom/youku/arch/v3/io/Callback;)V", "isLoading", "()Z", "<init>", "Companion", "CallbackInterceptor", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class AbsLoader<HOST extends DomainObject> implements PagingLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START = 1;
    @NotNull
    private static final String TAG = "AbsLoader";
    @Nullable
    private Callback callback;
    @NotNull
    private HOST host;
    private volatile int loadingPage;
    private volatile int loadingState;
    @NotNull
    private LoadingViewManager loadingViewManager;
    private int startPage;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/loader/AbsLoader$CallbackInterceptor;", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/wt2;", "onResponse", WXBridgeManager.METHOD_CALLBACK, "Lcom/youku/arch/v3/io/Callback;", "<init>", "(Lcom/youku/arch/v3/loader/AbsLoader;Lcom/youku/arch/v3/io/Callback;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public final class CallbackInterceptor implements Callback {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private final Callback callback;
        final /* synthetic */ AbsLoader<HOST> this$0;

        public CallbackInterceptor(@Nullable AbsLoader absLoader, Callback callback) {
            b41.i(absLoader, "this$0");
            this.this$0 = absLoader;
            this.callback = callback;
        }

        @Override // com.youku.arch.v3.io.Callback
        public void onResponse(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1428689448")) {
                ipChange.ipc$dispatch("1428689448", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            Event event = new Event(FragmentEvent.ON_RESPONSE_INTERCEPTOR);
            HashMap hashMap = new HashMap(2);
            hashMap.put("response", iResponse);
            event.data = hashMap;
            EventBus eventBus = this.this$0.getHost().getPageContext().getEventBus();
            if (eventBus != null) {
                eventBus.post(event);
            }
            Callback callback = this.callback;
            if (callback == null) {
                return;
            }
            callback.onResponse(iResponse);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/loader/AbsLoader$Companion;", "", "", "DEFAULT_PAGE_START", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public AbsLoader(@NotNull HOST host) {
        b41.i(host, "host");
        this.host = host;
        this.startPage = 1;
        this.loadingPage = getStartPage();
        this.loadingViewManager = new LoadingViewManager();
        this.callback = new CallbackInterceptor(this, null);
    }

    private final void loadNextPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310700032")) {
            ipChange.ipc$dispatch("1310700032", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setLoadingState(1);
        if (i == getStartPage()) {
            if (!hasExtraData() && this.host.getChildCount() == 0) {
                getLoadingViewManager().onLoading();
            }
        } else {
            getLoadingViewManager().onNextPageLoading();
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("cache", Boolean.valueOf(i == getStartPage()));
        hashMap.put("index", Integer.valueOf(i));
        load(hashMap);
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean canLoadNextPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1490821003") ? ((Boolean) ipChange.ipc$dispatch("1490821003", new Object[]{this})).booleanValue() : getLoadingState() == 0 || getLoadingState() == 2;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @Nullable
    public Callback getCallback() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1850385588") ? (Callback) ipChange.ipc$dispatch("1850385588", new Object[]{this}) : this.callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HOST getHost() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-338251532") ? (HOST) ipChange.ipc$dispatch("-338251532", new Object[]{this}) : this.host;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public int getLoadingPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "464898857") ? ((Integer) ipChange.ipc$dispatch("464898857", new Object[]{this})).intValue() : this.loadingPage;
    }

    protected int getLoadingState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1987020423") ? ((Integer) ipChange.ipc$dispatch("1987020423", new Object[]{this})).intValue() : this.loadingState;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @NotNull
    public LoadingViewManager getLoadingViewManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1305239853") ? (LoadingViewManager) ipChange.ipc$dispatch("-1305239853", new Object[]{this}) : this.loadingViewManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getStartPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "333128771") ? ((Integer) ipChange.ipc$dispatch("333128771", new Object[]{this})).intValue() : this.startPage;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337728164")) {
            ipChange.ipc$dispatch("1337728164", new Object[]{this, iResponse});
        } else {
            b41.i(iResponse, "response");
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755640024")) {
            ipChange.ipc$dispatch("1755640024", new Object[]{this, iResponse, Integer.valueOf(i)});
        } else {
            b41.i(iResponse, "response");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean hasExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784348369")) {
            return ((Boolean) ipChange.ipc$dispatch("-784348369", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean hasNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959493703")) {
            return ((Boolean) ipChange.ipc$dispatch("1959493703", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean isLoading() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "788786993") ? ((Boolean) ipChange.ipc$dispatch("788786993", new Object[]{this})).booleanValue() : getLoadingState() == 1;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552410112")) {
            ipChange.ipc$dispatch("-552410112", new Object[]{this, map});
            return;
        }
        b41.i(map, Constants.CONFIG);
        Integer num = (Integer) map.get("index");
        final int startPage = num == null ? getStartPage() : num.intValue();
        IRequest createRequest = this.host.createRequest(map);
        final long currentTimeMillis = System.currentTimeMillis();
        if (createRequest == null) {
            return;
        }
        String pageName = getHost().getPageContext().getPageName();
        if (pageName != null && (archMontior = ArchMontiorManager.Companion.get(pageName)) != null) {
            archMontior.setRequestTime(System.currentTimeMillis());
            archMontior.setApiName(createRequest.getApiName());
        }
        getHost().request(createRequest, new DataLoadCallback(this) { // from class: com.youku.arch.v3.loader.AbsLoader$load$1$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ AbsLoader<HOST> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // com.youku.arch.v3.data.DataLoadCallback
            public void onFilter(@NotNull IResponse iResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "175829590")) {
                    ipChange2.ipc$dispatch("175829590", new Object[]{this, iResponse});
                    return;
                }
                b41.i(iResponse, "response");
                Callback callback = this.this$0.getCallback();
                DataLoadCallback dataLoadCallback = callback instanceof DataLoadCallback ? (DataLoadCallback) callback : null;
                if (dataLoadCallback == null) {
                    return;
                }
                dataLoadCallback.onFilter(iResponse);
            }

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                String jSONString;
                ArchMontior archMontior2;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1642899731")) {
                    ipChange2.ipc$dispatch("-1642899731", new Object[]{this, iResponse});
                    return;
                }
                b41.i(iResponse, "response");
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.d("AbsLoader", b41.r("onResponse ", Boolean.valueOf(iResponse.isSuccess())));
                }
                if (b41.d(iResponse.getSource(), "remote")) {
                    String pageName2 = this.this$0.getHost().getPageContext().getPageName();
                    if (pageName2 != null && (archMontior2 = ArchMontiorManager.Companion.get(pageName2)) != null) {
                        archMontior2.setRequestTime(System.currentTimeMillis() - archMontior2.getRequestTime());
                    }
                    HashMap hashMap = new HashMap();
                    IRequest request = iResponse.getRequest();
                    String apiName = request == null ? null : request.getApiName();
                    Objects.requireNonNull(apiName, "null cannot be cast to non-null type kotlin.String");
                    hashMap.put("apiName", apiName);
                    IRequest request2 = iResponse.getRequest();
                    Map<String, Object> dataParams = request2 != null ? request2.getDataParams() : null;
                    Objects.requireNonNull(dataParams, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                    hashMap.put("apiParams", tq2.c(dataParams));
                    String retCode = iResponse.getRetCode();
                    if (retCode != null) {
                        hashMap.put("retCode", retCode);
                    }
                    String retMessage = iResponse.getRetMessage();
                    if (retMessage != null) {
                        hashMap.put("retMessage", retMessage);
                    }
                    String traceId = iResponse.getTraceId();
                    if (traceId != null) {
                        hashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, traceId);
                    }
                    if (iResponse.isSuccess()) {
                        EventDispatcher eventDispatcher = this.this$0.getHost().getPageContext().getEventDispatcher();
                        if (eventDispatcher != null) {
                            eventDispatcher.dispatchEvent(LoaderEvent.REMOTE_REQUEST_SUCCESS, hashMap);
                        }
                    } else {
                        try {
                            JSONObject jsonObject = iResponse.getJsonObject();
                            if (jsonObject != null && (jSONString = jsonObject.toJSONString()) != null) {
                                hashMap.put("responseData", jSONString);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        EventDispatcher eventDispatcher2 = this.this$0.getHost().getPageContext().getEventDispatcher();
                        if (eventDispatcher2 != null) {
                            eventDispatcher2.dispatchEvent(LoaderEvent.REMOTE_REQUEST_FAILED, hashMap);
                        }
                    }
                }
                if (iResponse.isSuccess()) {
                    this.this$0.handleLoadSuccess(iResponse, startPage);
                } else {
                    this.this$0.handleLoadFailure(iResponse);
                }
                String pageName3 = this.this$0.getHost().getPageContext().getPageName();
                if (pageName3 == null) {
                    return;
                }
                long j = currentTimeMillis;
                String str = (System.currentTimeMillis() - j) + "";
                AnalyticsProviderProxy.utCustomEvent(pageName3, 19999, "abs_load_time", str, startPage + "", null);
            }
        });
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247156782")) {
            ipChange.ipc$dispatch("-1247156782", new Object[]{this});
        } else if (isLoading()) {
        } else {
            setLoadingPage(getStartPage());
            loadNextPage(getLoadingPage());
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234026896")) {
            ipChange.ipc$dispatch("-1234026896", new Object[]{this});
            return;
        }
        setLoadingState(0);
        setLoadingPage(getStartPage());
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setCallback(@Nullable Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260549688")) {
            ipChange.ipc$dispatch("-260549688", new Object[]{this, callback});
        } else {
            this.callback = new CallbackInterceptor(this, callback);
        }
    }

    protected final void setHost(@NotNull HOST host) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554786508")) {
            ipChange.ipc$dispatch("-554786508", new Object[]{this, host});
            return;
        }
        b41.i(host, "<set-?>");
        this.host = host;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setLoadingPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847941119")) {
            ipChange.ipc$dispatch("-1847941119", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.loadingPage = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadingState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75607045")) {
            ipChange.ipc$dispatch("-75607045", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.loadingState = i;
        }
    }

    public void setLoadingViewManager(@NotNull LoadingViewManager loadingViewManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223053909")) {
            ipChange.ipc$dispatch("223053909", new Object[]{this, loadingViewManager});
            return;
        }
        b41.i(loadingViewManager, "<set-?>");
        this.loadingViewManager = loadingViewManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStartPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94355673")) {
            ipChange.ipc$dispatch("-94355673", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.startPage = i;
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void loadNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1481740957")) {
            ipChange.ipc$dispatch("-1481740957", new Object[]{this});
        } else if (isLoading()) {
        } else {
            loadNextPage(getLoadingPage());
        }
    }
}
