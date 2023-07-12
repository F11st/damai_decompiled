package com.alibaba.ability.middleware;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.gn1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H¦\u0002¨\u0006\t"}, d2 = {"Lcom/alibaba/ability/middleware/IMiddlewareHub;", "", "", "abilityName", "namespace", "", "Lcom/alibaba/ability/middleware/IAbilityMiddleware;", "Lcom/alibaba/ability/middleware/MiddlewareList;", gn1.TYPE_OPEN_URL_METHOD_GET, "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IMiddlewareHub {
    @NotNull
    List<IAbilityMiddleware> get(@NotNull String str, @NotNull String str2);
}
