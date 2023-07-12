package com.alient.onearch.adapter.loader;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.loader.ComponentLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.xl2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¨\u0006#"}, d2 = {"Lcom/alient/onearch/adapter/loader/BaseComponentLoader;", "Lcom/youku/arch/v3/loader/ComponentLoader;", "Lcom/youku/arch/v3/core/Node;", "node", "Ltb/wt2;", "handleNode", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "findRootDataNode", "response", "parseNode", "pageNode", "Lcom/alibaba/fastjson/JSONArray;", "layers", "parseLayers", "layerNode", "sections", "parseSections", "section", "parseSection", "sectionNode", "items", "", "limit", "parseItems", "item", "parseItem", "", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "parseComponentType", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "component", "<init>", "(Lcom/youku/arch/v3/IComponent;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BaseComponentLoader extends ComponentLoader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseComponentLoader(@NotNull IComponent<ComponentValue> iComponent) {
        super(iComponent);
        b41.i(iComponent, "component");
    }

    private final JSONObject findRootDataNode(JSONObject jSONObject) {
        if (jSONObject.containsKey("data")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            b41.h(jSONObject2, "jsonObject.getJSONObject(\"data\")");
            return jSONObject2;
        }
        return jSONObject;
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

    public abstract int parseComponentType(@Nullable String str);

    public void parseItem(@NotNull Node node, @NotNull JSONObject jSONObject) {
        ViewTypeConfig viewTypeConfig;
        HashMap<String, Object> params;
        Object obj;
        b41.i(node, "sectionNode");
        b41.i(jSONObject, "item");
        Node node2 = new Node();
        node2.setLevel(3);
        node2.setData(new JSONObject());
        node2.setChildren(new ArrayList());
        node2.setType(node.getType());
        node2.setId(node.getId());
        if (node2.getConfig() == null) {
            node2.setConfig(new JSONObject());
        }
        ViewTypeSupport viewTypeSupport = getHost().getPageContext().getViewTypeSupport();
        if (viewTypeSupport != null && (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node2.getType())) != null && (params = viewTypeConfig.getParams()) != null && (obj = params.get("bean")) != null) {
            JSONObject config = node2.getConfig();
            b41.f(config);
            config.put((JSONObject) "bean", (String) obj);
        }
        for (String str : jSONObject.keySet()) {
            JSONObject data = node2.getData();
            b41.f(data);
            data.put((JSONObject) str, (String) jSONObject.get(str));
        }
        node2.setParent(node);
        List<Node> children = node.getChildren();
        if (children == null) {
            return;
        }
        children.add(node2);
    }

    public void parseItems(@NotNull Node node, @Nullable JSONArray jSONArray, int i) {
        b41.i(node, "sectionNode");
        if (jSONArray == null) {
            return;
        }
        int i2 = 0;
        if (i <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            b41.h(jSONObject, "getJSONObject(index)");
            parseItem(node, jSONObject);
            if (i3 >= i) {
                return;
            }
            i2 = i3;
        }
    }

    public void parseLayers(@NotNull Node node, @NotNull JSONArray jSONArray) {
        boolean q;
        b41.i(node, "pageNode");
        b41.i(jSONArray, "layers");
        int size = jSONArray.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getJSONArray("sections") != null) {
                Node node2 = new Node();
                boolean z = true;
                node2.setLevel(1);
                node2.setData(new JSONObject());
                node2.setId(jSONObject.getString("layerId").hashCode());
                node2.setChildren(new ArrayList());
                for (String str : jSONObject.keySet()) {
                    q = o.q(str, "sections", true);
                    if (q) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("sections");
                        b41.h(jSONArray2, "getJSONArray(\"sections\")");
                        parseSections(node2, jSONArray2);
                    } else {
                        JSONObject data = node2.getData();
                        b41.f(data);
                        data.put((JSONObject) str, (String) jSONObject.get(str));
                    }
                }
                List<Node> children = node2.getChildren();
                if (children != null && !children.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    node2.setParent(node);
                    List<Node> children2 = node.getChildren();
                    if (children2 != null) {
                        children2.add(node2);
                    }
                }
            }
            if (i2 > size) {
                return;
            }
            i = i2;
        }
    }

    @Override // com.youku.arch.v3.loader.ComponentLoader
    @NotNull
    public Node parseNode(@NotNull JSONObject jSONObject) {
        boolean q;
        b41.i(jSONObject, "response");
        Node node = new Node();
        node.setLevel(0);
        node.setData(new JSONObject());
        node.setChildren(new ArrayList());
        JSONObject findRootDataNode = findRootDataNode(jSONObject);
        for (String str : findRootDataNode.keySet()) {
            q = o.q(str, "layers", true);
            if (q) {
                JSONArray jSONArray = findRootDataNode.getJSONArray("layers");
                b41.h(jSONArray, "rootDataJSONObject.getJSONArray(\"layers\")");
                parseLayers(node, jSONArray);
            } else {
                JSONObject data = node.getData();
                b41.f(data);
                data.put((JSONObject) str, (String) findRootDataNode.get(str));
            }
        }
        handleNode(node);
        return node;
    }

    public void parseSection(@NotNull Node node, @NotNull JSONObject jSONObject) {
        boolean q;
        boolean q2;
        boolean q3;
        b41.i(node, "layerNode");
        b41.i(jSONObject, "section");
        String string = jSONObject.getString("componentId");
        boolean z = false;
        if (string == null || string.length() == 0) {
            return;
        }
        String string2 = jSONObject.getString("sectionId");
        if ((string2 == null || string2.length() == 0) ? true : true) {
            return;
        }
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setData(new JSONObject());
        node2.setType(parseComponentType(jSONObject.getString("componentId")));
        node2.setId(jSONObject.getString("sectionId").hashCode());
        node2.setChildren(new ArrayList());
        if (!jSONObject.containsKey("item") || jSONObject.getJSONObject("item") == null) {
            return;
        }
        for (String str : jSONObject.keySet()) {
            q = o.q(str, "item", true);
            if (q) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("item");
                for (String str2 : jSONObject2.keySet()) {
                    if (!jSONObject2.containsKey("list") && !jSONObject2.containsKey("result")) {
                        return;
                    }
                    q2 = o.q(str2, "list", true);
                    if (!q2) {
                        q3 = o.q(str2, "result", true);
                        if (!q3) {
                            JSONObject data = node2.getData();
                            if (data != null) {
                                data.put((JSONObject) str2, (String) jSONObject2.get(str2));
                            }
                        }
                    }
                    JSONArray jSONArray = jSONObject2.getJSONArray("list") == null ? jSONObject2.getJSONArray("result") : jSONObject2.getJSONArray("list");
                    if (jSONArray == null || jSONArray.isEmpty()) {
                        return;
                    }
                    parseItems(node2, jSONArray, jSONArray.size());
                    if (jSONObject2.containsKey(xl2.HAS_NEXT)) {
                        Boolean bool = jSONObject2.getBoolean(xl2.HAS_NEXT);
                        b41.h(bool, "sectionItemsData.getBoolean(\"hasNext\")");
                        if (bool.booleanValue()) {
                            node2.setMore(true);
                        }
                    }
                }
                continue;
            } else {
                JSONObject data2 = node2.getData();
                if (data2 != null) {
                    data2.put((JSONObject) str, (String) jSONObject.get(str));
                }
            }
        }
        node2.setParent(node);
        List<Node> children = node.getChildren();
        if (children == null) {
            return;
        }
        children.add(node2);
    }

    public void parseSections(@NotNull Node node, @NotNull JSONArray jSONArray) {
        b41.i(node, "layerNode");
        b41.i(jSONArray, "sections");
        int size = jSONArray.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            b41.h(jSONObject, "sections.getJSONObject(index)");
            parseSection(node, jSONObject);
            if (i2 > size) {
                return;
            }
            i = i2;
        }
    }
}
