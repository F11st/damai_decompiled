package com.alient.onearch.adapter.parser.module;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.pom.BasicModuleValue;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Node;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/parser/module/BasicModuleParser;", "Lcom/alient/onearch/adapter/parser/module/AbsModuleParser;", "Lcom/alient/onearch/adapter/pom/BasicModuleValue;", "Lcom/youku/arch/v3/core/Node;", "node", StageType.PARSE, "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class BasicModuleParser extends AbsModuleParser<BasicModuleValue> {
    @Override // com.alient.onearch.adapter.parser.module.AbsModuleParser
    @NotNull
    public BasicModuleValue parse(@NotNull Node node) {
        Object parseObject;
        b41.i(node, "node");
        JSONObject data = node.getData();
        BasicModuleValue basicModuleValue = null;
        if (data != null) {
            try {
                try {
                    parseObject = data.toJavaObject(BasicModuleValue.class);
                } catch (Exception unused) {
                    parseObject = JSON.parseObject(data.toJSONString(), BasicModuleValue.class);
                }
                basicModuleValue = parseObject;
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
        if (basicModuleValue == null) {
            basicModuleValue = new BasicModuleValue(node);
        }
        if (node.getRawJson() != null) {
            basicModuleValue.setRawJson(node.getRawJson());
        }
        return basicModuleValue;
    }
}
