package com.youku.arch.v3.core.parser;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/core/parser/DefaultItemParser;", "Lcom/youku/arch/v3/core/parser/IParser;", "Lcom/youku/arch/v3/core/Node;", "Lcom/youku/arch/v3/core/ItemValue;", "node", "parseElement", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class DefaultItemParser implements IParser<Node, ItemValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.core.parser.IParser
    @NotNull
    public ItemValue parseElement(@NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636435544")) {
            return (ItemValue) ipChange.ipc$dispatch("-636435544", new Object[]{this, node});
        }
        b41.i(node, "node");
        return new ItemValue(node);
    }
}
