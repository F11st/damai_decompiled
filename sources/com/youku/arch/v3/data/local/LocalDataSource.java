package com.youku.arch.v3.data.local;

import android.app.Application;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.data.IDataSource;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gn1;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086\u0002J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000fJ\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/youku/arch/v3/data/local/LocalDataSource;", "Lcom/youku/arch/v3/data/IDataSource;", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/data/DataLoadCallback;", "callBack", "Ltb/wt2;", gn1.TYPE_OPEN_URL_METHOD_GET, "", "reqId", "Lcom/youku/arch/v3/io/IResponse;", "data", "putDataToMemCache", "id", "getMemCachedData", "", "response", "put", "removeById", "", "type", "removeByType", "Lcom/youku/arch/v3/data/local/DataCache;", "cache", "Lcom/youku/arch/v3/data/local/DataCache;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LocalDataSource implements IDataSource {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.LocalDataSource";
    @NotNull
    private static final Lazy<LocalDataSource> instance$delegate;
    @NotNull
    private final DataCache cache;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/data/local/LocalDataSource$Companion;", "", "Lcom/youku/arch/v3/data/local/LocalDataSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/data/local/LocalDataSource;", "instance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final LocalDataSource getInstance() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1451196963") ? (LocalDataSource) ipChange.ipc$dispatch("1451196963", new Object[]{this}) : (LocalDataSource) LocalDataSource.instance$delegate.getValue();
        }
    }

    static {
        Lazy<LocalDataSource> a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<LocalDataSource>() { // from class: com.youku.arch.v3.data.local.LocalDataSource$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LocalDataSource invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-10383295")) {
                    return (LocalDataSource) ipChange.ipc$dispatch("-10383295", new Object[]{this});
                }
                Application application = AppInfoProviderProxy.getApplication();
                b41.h(application, "getApplication()");
                return new LocalDataSource(application);
            }
        });
        instance$delegate = a;
    }

    public LocalDataSource(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Context applicationContext = context.getApplicationContext();
        b41.h(applicationContext, "context.applicationContext");
        this.cache = new DataCache(applicationContext);
    }

    public static /* synthetic */ void put$default(LocalDataSource localDataSource, IResponse iResponse, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = -1;
        }
        localDataSource.put(iResponse, j);
    }

    @Override // com.youku.arch.v3.data.IDataSource
    public void get(@NotNull IRequest iRequest, @Nullable DataLoadCallback dataLoadCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613069024")) {
            ipChange.ipc$dispatch("-1613069024", new Object[]{this, iRequest, dataLoadCallback});
            return;
        }
        b41.i(iRequest, "request");
        get(iRequest.getId(), dataLoadCallback);
    }

    @Nullable
    public final IResponse getMemCachedData(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-576109231") ? (IResponse) ipChange.ipc$dispatch("-576109231", new Object[]{this, Long.valueOf(j)}) : this.cache.get(j);
    }

    @JvmOverloads
    public final void put(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495082739")) {
            ipChange.ipc$dispatch("1495082739", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        put$default(this, iResponse, 0L, 2, null);
    }

    @JvmOverloads
    public final void put(@NotNull IResponse iResponse, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897044943")) {
            ipChange.ipc$dispatch("-897044943", new Object[]{this, iResponse, Long.valueOf(j)});
            return;
        }
        b41.i(iResponse, "response");
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, b41.r("put data to db ", Long.valueOf(iResponse.getId())));
        }
        if (iResponse.getSource() != "local") {
            Response.Builder builder = new Response.Builder();
            if (j == -1) {
                j = iResponse.getId();
            }
            iResponse = builder.setId(j).setCacheTag(iResponse.getCacheTag()).setRawData(iResponse.getRawData()).setRetCode(iResponse.getRetCode()).setTimestamp(iResponse.getTimestamp()).setSource("local").setJsonObject(iResponse.getJsonObject()).build();
        }
        this.cache.put(iResponse);
    }

    public final void putDataToMemCache(@Nullable IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100506945")) {
            ipChange.ipc$dispatch("2100506945", new Object[]{this, iResponse});
            return;
        }
        DataCache dataCache = this.cache;
        b41.f(iResponse);
        dataCache.put(iResponse);
    }

    public final void removeById(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400793391")) {
            ipChange.ipc$dispatch("-400793391", new Object[]{this, Long.valueOf(j)});
        } else {
            this.cache.removeById(j);
        }
    }

    public final void removeByType(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809854370")) {
            ipChange.ipc$dispatch("-1809854370", new Object[]{this, str});
            return;
        }
        b41.i(str, "type");
        this.cache.removeByType(str);
    }

    public final void get(long j, @Nullable DataLoadCallback dataLoadCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568483013")) {
            ipChange.ipc$dispatch("-1568483013", new Object[]{this, Long.valueOf(j), dataLoadCallback});
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, b41.r("get data from local ", Long.valueOf(j)));
        }
        if (dataLoadCallback != null) {
            IResponse iResponse = this.cache.get(j);
            if ((iResponse == null ? null : iResponse.getRawData()) == null) {
                iResponse = new Response.Builder().setSource("local").setRetCode("local_cache_missing").setRetMessage("local_cache_missing").setId(j).setTimestamp(System.currentTimeMillis()).build();
            }
            dataLoadCallback.onFilter(iResponse);
            dataLoadCallback.onResponse(iResponse);
        }
    }

    @Nullable
    public final IResponse getMemCachedData(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1601601230") ? (IResponse) ipChange.ipc$dispatch("-1601601230", new Object[]{this, Integer.valueOf(i)}) : this.cache.get(i);
    }
}
