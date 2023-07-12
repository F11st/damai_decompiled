package com.youku.arch.v3;

import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import kotlin.Metadata;
import mtopsdk.mtop.intf.Mtop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/ICreator;", Mtop.Id.PRODUCT, "DATA", "", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "create", "(Lcom/youku/arch/v3/core/Config;)Ljava/lang/Object;", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ICreator<PRODUCT, DATA> {
    @Nullable
    PRODUCT create(@NotNull Config<DATA> config);
}
