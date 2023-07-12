package com.youku.arch.v3.io;

import android.os.Bundle;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/youku/arch/v3/io/IRequest;", "Ljava/io/Serializable;", "", "getId", "()J", "id", "", "getApiName", "()Ljava/lang/String;", "apiName", "getVersion", "version", "getCacheTag", "cacheTag", "getCustomDomain", "customDomain", "", "isNeedECode", "()Z", "isNeedSession", "isNeedCache", "isSync", "getStrategy", "strategy", "", "getTimeout", "()I", "timeout", "", "", "getDataParams", "()Ljava/util/Map;", "dataParams", "getHeaders", "headers", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IRequest extends Serializable {
    @Nullable
    String getApiName();

    @Nullable
    Bundle getBundle();

    @Nullable
    String getCacheTag();

    @Nullable
    String getCustomDomain();

    @Nullable
    Map<String, Object> getDataParams();

    @Nullable
    Map<String, String> getHeaders();

    long getId();

    long getStrategy();

    int getTimeout();

    @Nullable
    String getVersion();

    boolean isNeedCache();

    boolean isNeedECode();

    boolean isNeedSession();

    boolean isSync();
}
