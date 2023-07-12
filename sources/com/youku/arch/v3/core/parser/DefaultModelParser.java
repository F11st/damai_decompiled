package com.youku.arch.v3.core.parser;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/core/parser/DefaultModelParser;", "Lcom/youku/arch/v3/core/parser/IParser;", "Lcom/youku/arch/v3/core/Node;", "Lcom/youku/arch/v3/core/ModelValue;", "node", "parseElement", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class DefaultModelParser implements IParser<Node, ModelValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.core.parser.IParser
    @NotNull
    public ModelValue parseElement(@NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "567698178")) {
            return (ModelValue) ipChange.ipc$dispatch("567698178", new Object[]{this, node});
        }
        b41.i(node, "node");
        return new ModelValue(node);
    }
}
