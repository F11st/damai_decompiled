package com.alient.onearch.adapter.loader.v2;

import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.loader.ComponentLoader;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\u0012"}, d2 = {"Lcom/alient/onearch/adapter/loader/v2/GenericComponentLoader;", "Lcom/youku/arch/v3/loader/ComponentLoader;", "Lcom/youku/arch/v3/core/Node;", "node", "Ltb/wt2;", "handleNode", "Lcom/alibaba/fastjson/JSONObject;", "response", "parseNode", "", "itemIterator", "itemNode", "handleItemNode", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "component", "<init>", "(Lcom/youku/arch/v3/IComponent;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericComponentLoader extends ComponentLoader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericComponentLoader(@NotNull IComponent<ComponentValue> iComponent) {
        super(iComponent);
        b41.i(iComponent, "component");
    }

    private final void handleNode(Node node) {
        ViewTypeSupport viewTypeSupport;
        ViewTypeConfig viewTypeConfig;
        HashMap<String, Object> params;
        Object obj;
        List<Node> children = node.getChildren();
        if (children == null || children.isEmpty()) {
            return;
        }
        List<Node> children2 = node.getChildren();
        b41.f(children2);
        ListIterator<Node> listIterator = children2.listIterator();
        while (listIterator.hasNext()) {
            Node next = listIterator.next();
            if (next.getLevel() == 3) {
                handleItemNode(listIterator, next);
                if (next.getConfig() == null) {
                    next.setConfig(new JSONObject());
                }
                JSONObject config = next.getConfig();
                if (config != null && (viewTypeSupport = getHost().getPageContext().getViewTypeSupport()) != null && (viewTypeConfig = viewTypeSupport.getViewTypeConfig(next.getType())) != null && (params = viewTypeConfig.getParams()) != null && (obj = params.get("bean")) != null) {
                    config.put((JSONObject) "bean", (String) obj);
                }
            }
            handleNode(next);
        }
    }

    public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        b41.i(listIterator, "itemIterator");
        b41.i(node, "itemNode");
    }

    @Override // com.youku.arch.v3.loader.ComponentLoader
    @Nullable
    public Node parseNode(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "response");
        Node parseNode = super.parseNode(jSONObject);
        if (parseNode != null) {
            handleNode(parseNode);
        }
        return parseNode;
    }
}
