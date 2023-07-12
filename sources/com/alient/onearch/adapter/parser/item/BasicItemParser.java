package com.alient.onearch.adapter.parser.item;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.pom.BasicItemValue;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.util.ReflectionUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/alient/onearch/adapter/parser/item/BasicItemParser;", "Lcom/alient/onearch/adapter/parser/item/AbsItemParser;", "Lcom/alient/onearch/adapter/pom/BasicItemValue;", "basicItemValue", "Lcom/youku/arch/v3/core/Node;", "node", "Ltb/wt2;", "setRawJson", StageType.PARSE, "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class BasicItemParser extends AbsItemParser<BasicItemValue> {
    private final void setRawJson(BasicItemValue basicItemValue, Node node) {
        if (basicItemValue == null || node.getRawJson() == null) {
            return;
        }
        basicItemValue.setRawJson(node.getRawJson());
    }

    @Override // com.alient.onearch.adapter.parser.item.AbsItemParser
    @NotNull
    public BasicItemValue parse(@NotNull Node node) {
        JSONArray jSONArray;
        String string;
        b41.i(node, "node");
        BasicItemValue basicItemValue = new BasicItemValue();
        JSONObject config = node.getConfig();
        if (config != null && (string = config.getString("bean")) != null) {
            try {
                Class<?> tryGetClassForName = ReflectionUtil.INSTANCE.tryGetClassForName(string);
                JSONObject data = node.getData();
                basicItemValue.setValue(data == null ? null : data.toJavaObject(tryGetClassForName));
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject rawJson = node.getRawJson();
        if (rawJson != null && (jSONArray = rawJson.getJSONArray("render")) != null) {
            try {
                basicItemValue.setRenders(JSON.parseArray(jSONArray.toJSONString(), Render.class));
            } catch (Exception e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    e2.printStackTrace();
                }
            }
        }
        setRawJson(basicItemValue, node);
        return basicItemValue;
    }
}
