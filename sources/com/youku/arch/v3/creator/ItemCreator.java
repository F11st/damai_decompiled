package com.youku.arch.v3.creator;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/creator/ItemCreator;", "Lcom/youku/arch/v3/ICreator;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/core/Node;", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "create", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ItemCreator implements ICreator<IItem<ItemValue>, Node> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.arch.v3.ICreator
    @NotNull
    public IItem<ItemValue> create(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137026124")) {
            return (IItem) ipChange.ipc$dispatch("-137026124", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        return new GenericItem(config.getContext(), config.getData());
    }
}
