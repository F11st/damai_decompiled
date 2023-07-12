package com.youku.gaiax.provider.module.js;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.js.api.annotation.GaiaXPromiseMethod;
import com.youku.gaiax.js.utils.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXNativeEventModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/youku/gaiax/js/api/IGaiaXPromise;", "promise", "Ltb/wt2;", "addEventListener", "removeEventListener", "", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXNativeEventModule extends GaiaXBaseModule {
    @GaiaXPromiseMethod
    public final void addEventListener(@NotNull JSONObject jSONObject, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXPromise, "promise");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("addEventListener() called with: data = ", jSONObject));
        }
        String string = jSONObject.getString("targetId");
        String string2 = jSONObject.getString("templateId");
        Long l = jSONObject.getLong("instanceId");
        String string3 = jSONObject.getString("eventType");
        JSONObject jSONObject2 = jSONObject.getJSONObject("option");
        boolean booleanValue = jSONObject2 == null ? false : jSONObject2.getBooleanValue("cover");
        JSONObject jSONObject3 = jSONObject.getJSONObject("option");
        int intValue = jSONObject3 == null ? 0 : jSONObject3.getIntValue("level");
        if (string != null && string2 != null && l != null && string3 != null) {
            JSDelegate.Companion.getInstance().addEventListener(string, l.longValue(), string3, booleanValue, intValue);
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
            return;
        }
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "NativeEvent";
    }

    @GaiaXPromiseMethod
    public final void removeEventListener(@NotNull JSONObject jSONObject, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXPromise, "promise");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("removeEventListener() called with: data = ", jSONObject));
        }
        String string = jSONObject.getString("targetId");
        String string2 = jSONObject.getString("templateId");
        Long l = jSONObject.getLong("instanceId");
        String string3 = jSONObject.getString("eventType");
        if (string != null && string2 != null && l != null && string3 != null) {
            JSDelegate.Companion.getInstance().removeEventListener(string, l.longValue(), string3);
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
            return;
        }
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
    }
}
