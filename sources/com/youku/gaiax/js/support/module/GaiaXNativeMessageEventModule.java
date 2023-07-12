package com.youku.gaiax.js.support.module;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.js.api.annotation.GaiaXPromiseMethod;
import com.youku.gaiax.js.support.GaiaXNativeEventManager;
import com.youku.gaiax.js.utils.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/js/support/module/GaiaXNativeMessageEventModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/youku/gaiax/js/api/IGaiaXPromise;", "promise", "Ltb/wt2;", "addNativeEventListener", "removeNativeEventListener", "", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXNativeMessageEventModule extends GaiaXBaseModule {
    @GaiaXPromiseMethod
    public final void addNativeEventListener(@NotNull JSONObject jSONObject, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXPromise, "promise");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("addNativeEventListener() called with: data = ", jSONObject));
        }
        if (GaiaXNativeEventManager.Companion.getInstance().registerMessage(jSONObject)) {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
        } else {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
        }
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "NativeEvent";
    }

    @GaiaXPromiseMethod
    public final void removeNativeEventListener(@NotNull JSONObject jSONObject, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXPromise, "promise");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("removeNativeEventListener() called with: data = ", jSONObject));
        }
        if (GaiaXNativeEventManager.Companion.getInstance().unRegisterMessage(jSONObject)) {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
        } else {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
        }
    }
}
