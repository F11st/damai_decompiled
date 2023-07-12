package com.alibaba.ability;

import com.alibaba.ability.env.IAbilityContext;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9489o0;
import tb.jg0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/alibaba/ability/IAbility;", "", "", "api", "Lcom/alibaba/ability/env/IAbilityContext;", WPKFactory.INIT_KEY_CONTEXT, "", "Lcom/alibaba/ability/AbilityData;", "params", "Ltb/o0;", WXBridgeManager.METHOD_CALLBACK, "Ltb/jg0;", "execute", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IAbility {
    @Nullable
    jg0 execute(@NotNull String str, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull C9489o0 c9489o0);
}
