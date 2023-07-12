package com.youku.arch.v3.loader;

import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H&R\u001c\u0010\u0018\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/youku/arch/v3/loader/PagingLoader;", "Ljava/io/Serializable;", "", "", "", Constants.CONFIG, "Ltb/wt2;", "load", "reload", "reset", "", "hasNextPage", "canLoadNextPage", "loadNextPage", "Lcom/youku/arch/v3/io/IResponse;", "response", "handleLoadFailure", "", "index", "handleLoadSuccess", "getLoadingPage", "()I", "setLoadingPage", "(I)V", "loadingPage", "isLoading", "()Z", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "getLoadingViewManager", "()Lcom/youku/arch/v3/loader/LoadingViewManager;", "loadingViewManager", "Lcom/youku/arch/v3/io/Callback;", "getCallback", "()Lcom/youku/arch/v3/io/Callback;", "setCallback", "(Lcom/youku/arch/v3/io/Callback;)V", WXBridgeManager.METHOD_CALLBACK, "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface PagingLoader extends Serializable {
    boolean canLoadNextPage();

    @Nullable
    Callback getCallback();

    int getLoadingPage();

    @Nullable
    LoadingViewManager getLoadingViewManager();

    void handleLoadFailure(@NotNull IResponse iResponse);

    void handleLoadSuccess(@NotNull IResponse iResponse, int i);

    boolean hasNextPage();

    boolean isLoading();

    void load(@NotNull Map<String, ? extends Object> map);

    void loadNextPage();

    void reload();

    void reset();

    void setCallback(@Nullable Callback callback);

    void setLoadingPage(int i);
}
