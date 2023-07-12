package com.youku.arch.v3.loader;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.style.StyleFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/youku/arch/v3/loader/NodeParser;", "", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "Lcom/youku/arch/v3/core/Node;", StageType.PARSE, "", "data", "parseNode", "parent", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class NodeParser {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final NodeParser INSTANCE = new NodeParser();
    @NotNull
    private static final String TAG = "OneArch.NodeJsonParser";

    private NodeParser() {
    }

    private final Node parse(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1642190478") ? (Node) ipChange.ipc$dispatch("-1642190478", new Object[]{this, jSONObject}) : parse(null, jSONObject);
    }

    private final Node parseNode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183866302")) {
            return (Node) ipChange.ipc$dispatch("183866302", new Object[]{this, str});
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                Node node = (Node) JSON.parseObject(str, Node.class);
                Log.v(TAG, b41.r("FastJsonParser cost time AA ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                b41.h(node, "{\n            val node =…           node\n        }");
                return node;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } finally {
            Log.v(TAG, b41.r("FastJsonParser cost time BB ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    @Nullable
    public final Node parse(@Nullable Node node, @Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "480987626")) {
            return (Node) ipChange.ipc$dispatch("480987626", new Object[]{this, node, jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        Node node2 = new Node();
        node2.setParent(node);
        node2.setId(jSONObject.getIntValue("id"));
        node2.setLevel(jSONObject.getIntValue("level"));
        node2.setType(jSONObject.getIntValue("type"));
        node2.setMore(jSONObject.getBooleanValue("more"));
        node2.setData(jSONObject.getJSONObject("data"));
        node2.setConfig(jSONObject.getJSONObject(Constants.CONFIG));
        node2.setLayout(jSONObject.getJSONObject("layout"));
        node2.setRawJson(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("render");
        if (jSONArray != null) {
            node2.setRenders(JSON.parseArray(jSONArray.toJSONString(), Render.class));
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("style");
        if (jSONObject2 != null) {
            node2.setStyle(StyleFactory.INSTANCE.create(jSONObject2, node != null ? node.getStyle() : null));
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("nodes");
        if (jSONArray2 != null && !jSONArray2.isEmpty()) {
            z = false;
        }
        if (!z) {
            ArrayList arrayList = new ArrayList(jSONArray2.size());
            node2.setChildren(arrayList);
            int size = jSONArray2.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    Node parse = parse(node2, jSONArray2.getJSONObject(i));
                    if (parse != null) {
                        arrayList.add(parse);
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        return node2;
    }

    private final Node parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195659744")) {
            return (Node) ipChange.ipc$dispatch("-195659744", new Object[]{this, str});
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                JSONObject parseObject = JSON.parseObject(str);
                Log.v(TAG, b41.r("FastJsonParser cost time A ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                return parse(parseObject.getJSONObject("data"));
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } finally {
            Log.v(TAG, b41.r("FastJsonParser cost time B ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }
}
