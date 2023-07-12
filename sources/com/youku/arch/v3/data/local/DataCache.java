package com.youku.arch.v3.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.collection.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.io.IResponse;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gn1;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/youku/arch/v3/data/local/DataCache;", "", "", "deadline", "Ltb/wt2;", "removeCacheByTimeIfNeed", "id", "Lcom/youku/arch/v3/io/IResponse;", gn1.TYPE_OPEN_URL_METHOD_GET, "response", "put", "removeById", "", "type", "removeByType", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "Landroidx/collection/LruCache;", "memCache", "Landroidx/collection/LruCache;", "<init>", "(Landroid/content/Context;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DataCache {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long WEEK_MILLIS = 604800000;
    @NotNull
    private final Context context;
    @NotNull
    private final LruCache<Long, IResponse> memCache;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/data/local/DataCache$Companion;", "", "", "WEEK_MILLIS", "J", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public DataCache(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context;
        this.memCache = new LruCache<>(20);
    }

    private final void removeCacheByTimeIfNeed(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047073280")) {
            ipChange.ipc$dispatch("1047073280", new Object[]{this, Long.valueOf(j)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("onearch", 0);
        long j2 = sharedPreferences.getLong("last_clear_cache_timestamp", currentTimeMillis);
        if (currentTimeMillis - j2 > 604800000) {
            if (DataCacheUtils.INSTANCE.removeCacheByTime(this.context, j) > 0) {
                sharedPreferences.edit().putLong("last_clear_cache_timestamp", currentTimeMillis).apply();
            }
        } else if (currentTimeMillis <= j2) {
            sharedPreferences.edit().putLong("last_clear_cache_timestamp", currentTimeMillis).apply();
        }
    }

    @Nullable
    public final IResponse get(long j) {
        Item cacheById;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2012306070")) {
            return (IResponse) ipChange.ipc$dispatch("2012306070", new Object[]{this, Long.valueOf(j)});
        }
        IResponse iResponse = this.memCache.get(Long.valueOf(j));
        if (iResponse != null || (cacheById = DataCacheUtils.INSTANCE.getCacheById(this.context, j)) == null) {
            return iResponse;
        }
        Response.Builder builder = new Response.Builder();
        Long l = cacheById.id;
        b41.h(l, "item.id");
        Response.Builder source = builder.setId(l.longValue()).setCacheTag(cacheById.type).setSource("local");
        Long l2 = cacheById.time;
        b41.h(l2, "item.time");
        Response build = source.setTimestamp(l2.longValue()).setRetCode(cacheById.retCode).setRawData(cacheById.content).setRetMessage(cacheById.retMsg).build();
        this.memCache.put(Long.valueOf(j), build);
        return build;
    }

    public final void put(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221599189")) {
            ipChange.ipc$dispatch("-1221599189", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        this.memCache.put(Long.valueOf(iResponse.getId()), iResponse);
        Item item = new Item();
        item.type = iResponse.getCacheTag();
        item.id = Long.valueOf(iResponse.getId());
        item.content = iResponse.getRawData();
        item.time = Long.valueOf(iResponse.getTimestamp());
        item.expire = Long.valueOf(iResponse.getTimestamp() + 86400000);
        item.retCode = iResponse.getRetCode();
        item.retMsg = iResponse.getRetMessage();
        if (DataCacheUtils.INSTANCE.updateCache(this.context, item, 0)) {
            removeCacheByTimeIfNeed(System.currentTimeMillis() - 604800000);
        }
    }

    public final void removeById(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603013641")) {
            ipChange.ipc$dispatch("603013641", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.memCache.remove(Long.valueOf(j));
        DataCacheUtils.INSTANCE.removeCacheById(this.context, j);
    }

    public final void removeByType(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392416218")) {
            ipChange.ipc$dispatch("-392416218", new Object[]{this, str});
            return;
        }
        b41.i(str, "type");
        List<Long> removeCacheByType = DataCacheUtils.INSTANCE.removeCacheByType(this.context, str);
        if (removeCacheByType == null || !(!removeCacheByType.isEmpty())) {
            return;
        }
        for (Long l : removeCacheByType) {
            this.memCache.remove(Long.valueOf(l.longValue()));
        }
    }
}
