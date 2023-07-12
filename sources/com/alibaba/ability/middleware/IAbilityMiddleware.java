package com.alibaba.ability.middleware;

import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.taobao.analysis.v3.FalcoSpanLayer;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.AbstractEditComponent;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jg0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JL\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/alibaba/ability/middleware/IAbilityMiddleware;", "", "", FalcoSpanLayer.ABILITY, "api", "Lcom/alibaba/ability/env/IAbilityContext;", WPKFactory.INIT_KEY_CONTEXT, "", "Lcom/alibaba/ability/AbilityData;", "params", "Lcom/alibaba/ability/callback/IOnCallbackListener;", WXBridgeManager.METHOD_CALLBACK, "Lcom/alibaba/ability/middleware/IAbilityInvoker;", AbstractEditComponent.ReturnTypes.NEXT, "Ltb/jg0;", "invoke", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IAbilityMiddleware {
    @Nullable
    jg0 invoke(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener, @NotNull IAbilityInvoker iAbilityInvoker);
}
