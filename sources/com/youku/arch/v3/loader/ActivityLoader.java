package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.core.ActivityContext;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.GenericActivity;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 8*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00018B\u000f\u0012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b7\u0010\u001bJ\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\"\u0010\u0016\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\"\u0010,\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001e\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u0010$\u001a\u0004\b5\u0010&\"\u0004\b6\u0010(¨\u00069"}, d2 = {"Lcom/youku/arch/v3/loader/ActivityLoader;", "Lcom/youku/arch/v3/page/GenericActivity;", "HOST", "Lcom/youku/arch/v3/loader/PagingLoader;", "", "", "", Constants.CONFIG, "Ltb/wt2;", "load", "reload", "reset", "Lcom/youku/arch/v3/io/IResponse;", "response", "handleLoadFailure", "", "index", "handleLoadSuccess", "loadNextPage", "", "hasNextPage", "canLoadNextPage", "host", "Lcom/youku/arch/v3/page/GenericActivity;", "getHost", "()Lcom/youku/arch/v3/page/GenericActivity;", "setHost", "(Lcom/youku/arch/v3/page/GenericActivity;)V", "loadingState", "I", "getLoadingState", "()I", "setLoadingState", "(I)V", "Lcom/youku/arch/v3/io/Callback;", "callBack", "Lcom/youku/arch/v3/io/Callback;", "getCallBack", "()Lcom/youku/arch/v3/io/Callback;", "setCallBack", "(Lcom/youku/arch/v3/io/Callback;)V", "isLoading", "Z", "()Z", "loadingPage", "getLoadingPage", "setLoadingPage", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "loadingViewManager", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "getLoadingViewManager", "()Lcom/youku/arch/v3/loader/LoadingViewManager;", WXBridgeManager.METHOD_CALLBACK, "getCallback", "setCallback", "<init>", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ActivityLoader<HOST extends GenericActivity> implements PagingLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.ActivityLoader";
    @Nullable
    private Callback callBack;
    @Nullable
    private Callback callback;
    @NotNull
    private HOST host;
    private final boolean isLoading;
    private int loadingPage;
    private int loadingState;
    @Nullable
    private final LoadingViewManager loadingViewManager;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/loader/ActivityLoader$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public ActivityLoader(@NotNull HOST host) {
        b41.i(host, "host");
        this.host = host;
        this.isLoading = getLoadingState() == 1;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean canLoadNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078459048")) {
            return ((Boolean) ipChange.ipc$dispatch("2078459048", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Nullable
    public final Callback getCallBack() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2127658865") ? (Callback) ipChange.ipc$dispatch("2127658865", new Object[]{this}) : this.callBack;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @Nullable
    public Callback getCallback() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-204738671") ? (Callback) ipChange.ipc$dispatch("-204738671", new Object[]{this}) : this.callback;
    }

    @NotNull
    public final HOST getHost() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1498583924") ? (HOST) ipChange.ipc$dispatch("1498583924", new Object[]{this}) : this.host;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public int getLoadingPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1592233580") ? ((Integer) ipChange.ipc$dispatch("1592233580", new Object[]{this})).intValue() : this.loadingPage;
    }

    public int getLoadingState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1720308828") ? ((Integer) ipChange.ipc$dispatch("-1720308828", new Object[]{this})).intValue() : this.loadingState;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @Nullable
    public LoadingViewManager getLoadingViewManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "413754032") ? (LoadingViewManager) ipChange.ipc$dispatch("413754032", new Object[]{this}) : this.loadingViewManager;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956169087")) {
            ipChange.ipc$dispatch("-1956169087", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        setLoadingState(0);
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull final IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570926949")) {
            ipChange.ipc$dispatch("-1570926949", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        b41.i(iResponse, "response");
        ActivityContext activityContext = this.host.getActivityContext();
        if (activityContext == null) {
            return;
        }
        activityContext.runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.loader.ActivityLoader$handleLoadSuccess$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ActivityLoader<HOST> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "448527604")) {
                    ipChange2.ipc$dispatch("448527604", new Object[]{this});
                    return;
                }
                Callback callBack = this.this$0.getCallBack();
                if (callBack != null) {
                    callBack.onResponse(iResponse);
                }
                this.this$0.getHost().onTabDataLoaded(iResponse.getJsonObject());
                this.this$0.setLoadingState(0);
            }
        });
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean hasNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005089252")) {
            return ((Boolean) ipChange.ipc$dispatch("2005089252", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean isLoading() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1329598962") ? ((Boolean) ipChange.ipc$dispatch("-1329598962", new Object[]{this})).booleanValue() : this.isLoading;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        ActivityContext activityContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634892957")) {
            ipChange.ipc$dispatch("634892957", new Object[]{this, map});
            return;
        }
        b41.i(map, Constants.CONFIG);
        setLoadingState(1);
        final IRequest build = this.host.getRequestBuilder().build(map);
        if (build == null || (activityContext = getHost().getActivityContext()) == null) {
            return;
        }
        activityContext.runOnLoaderThread(new Function0<wt2>() { // from class: com.youku.arch.v3.loader.ActivityLoader$load$1$1
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
                if (AndroidInstantRuntime.support(ipChange2, "-1116335280")) {
                    ipChange2.ipc$dispatch("-1116335280", new Object[]{this});
                    return;
                }
                Repository companion = Repository.Companion.getInstance();
                IRequest iRequest = IRequest.this;
                final ActivityLoader<HOST> activityLoader = this;
                companion.request(iRequest, new Callback() { // from class: com.youku.arch.v3.loader.ActivityLoader$load$1$1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.arch.v3.io.Callback
                    public void onResponse(@NotNull IResponse iResponse) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "1030834774")) {
                            ipChange3.ipc$dispatch("1030834774", new Object[]{this, iResponse});
                            return;
                        }
                        b41.i(iResponse, "response");
                        if (AppInfoProviderProxy.isDebuggable()) {
                            LogUtil.d("OneArch.ActivityLoader", b41.r("onResponse ", Boolean.valueOf(iResponse.isSuccess())));
                        }
                        if (iResponse.isSuccess()) {
                            activityLoader.handleLoadSuccess(iResponse, 0);
                        } else {
                            activityLoader.handleLoadFailure(iResponse);
                        }
                    }
                });
            }
        });
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void loadNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68278938")) {
            ipChange.ipc$dispatch("-68278938", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039623147")) {
            ipChange.ipc$dispatch("-1039623147", new Object[]{this});
        } else {
            load(new LinkedHashMap());
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642974259")) {
            ipChange.ipc$dispatch("-1642974259", new Object[]{this});
        } else {
            setLoadingState(0);
        }
    }

    public final void setCallBack(@Nullable Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255012693")) {
            ipChange.ipc$dispatch("-255012693", new Object[]{this, callback});
        } else {
            this.callBack = callback;
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setCallback(@Nullable Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455107723")) {
            ipChange.ipc$dispatch("455107723", new Object[]{this, callback});
        } else {
            this.callback = callback;
        }
    }

    public final void setHost(@NotNull HOST host) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022833998")) {
            ipChange.ipc$dispatch("2022833998", new Object[]{this, host});
            return;
        }
        b41.i(host, "<set-?>");
        this.host = host;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setLoadingPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260303074")) {
            ipChange.ipc$dispatch("-1260303074", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.loadingPage = i;
        }
    }

    public void setLoadingState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961303166")) {
            ipChange.ipc$dispatch("961303166", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.loadingState = i;
        }
    }
}
