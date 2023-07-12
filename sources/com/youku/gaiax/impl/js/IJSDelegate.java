package com.youku.gaiax.impl.js;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.impl.GaiaXContext;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/js/IJSDelegate;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lkotlin/Function0;", "Ltb/wt2;", WXBridgeManager.METHOD_CALLBACK, "startEngine", "Lcom/youku/gaiax/impl/GaiaXContext;", "onReadyComponent", "onReuseComponent", "onShowComponent", "onHiddenComponent", "onDestroyComponent", "Lcom/alibaba/fastjson/JSONObject;", "data", "onLoadMoreComponent", "unregisterComponent", "registerComponent", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "dispatcherEvent", "dispatcherNativeMessageEvent", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IJSDelegate {
    void dispatcherEvent(@NotNull EventParams eventParams);

    void dispatcherNativeMessageEvent(@NotNull JSONObject jSONObject);

    void onDestroyComponent(@NotNull GaiaXContext gaiaXContext);

    void onHiddenComponent(@NotNull GaiaXContext gaiaXContext);

    void onLoadMoreComponent(@NotNull GaiaXContext gaiaXContext, @NotNull JSONObject jSONObject);

    void onReadyComponent(@NotNull GaiaXContext gaiaXContext);

    void onReuseComponent(@NotNull GaiaXContext gaiaXContext);

    void onShowComponent(@NotNull GaiaXContext gaiaXContext);

    void registerComponent(@NotNull GaiaXContext gaiaXContext);

    void startEngine(@NotNull Context context, @NotNull Function0<wt2> function0);

    void unregisterComponent(@NotNull GaiaXContext gaiaXContext);
}
