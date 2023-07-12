package com.youku.gaiax.provider.module.js;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.gaiax.impl.GaiaXKey;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.annotation.GaiaXAsyncMethod;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0016\u0010\u000f\u001a\u00020\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXBuildInModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Lcom/alibaba/fastjson/JSONObject;", "data", "params", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", WXBridgeManager.METHOD_CALLBACK, "Ltb/wt2;", "setData", "getData", "", "getComponentIndex", "", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXBuildInModule extends GaiaXBaseModule {
    @GaiaXSyncMethod
    public final int getComponentIndex(@NotNull JSONObject jSONObject) {
        Integer integer;
        b41.i(jSONObject, "params");
        String string = jSONObject.getString("templateId");
        Long l = jSONObject.getLong("instanceId");
        if (string == null || l == null || (integer = JSDelegate.Companion.getInstance().getData(l.longValue(), string).getInteger(GaiaXKey.GAIAX_SCROLL_POSITION)) == null) {
            return -1;
        }
        return integer.intValue();
    }

    @GaiaXSyncMethod
    @NotNull
    public final JSONObject getData(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "params");
        String string = jSONObject.getString("templateId");
        Long l = jSONObject.getLong("instanceId");
        if (string != null && l != null) {
            return JSDelegate.Companion.getInstance().getData(l.longValue(), string);
        }
        return new JSONObject();
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "BuildIn";
    }

    @GaiaXAsyncMethod
    public final void setData(@NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2, @NotNull IGaiaXCallback iGaiaXCallback) {
        b41.i(jSONObject, "data");
        b41.i(jSONObject2, "params");
        b41.i(iGaiaXCallback, WXBridgeManager.METHOD_CALLBACK);
        String string = jSONObject2.getString("templateId");
        Long l = jSONObject2.getLong("instanceId");
        if (string == null || l == null) {
            return;
        }
        JSDelegate.Companion.getInstance().setData(l.longValue(), string, jSONObject, iGaiaXCallback);
    }
}
