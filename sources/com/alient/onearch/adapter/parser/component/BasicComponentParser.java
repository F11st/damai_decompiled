package com.alient.onearch.adapter.parser.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.pom.BasicComponentValue;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/parser/component/BasicComponentParser;", "Lcom/alient/onearch/adapter/parser/component/AbsComponentParser;", "Lcom/alient/onearch/adapter/pom/BasicComponentValue;", "Lcom/youku/arch/v3/core/Node;", "node", StageType.PARSE, "<init>", "()V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class BasicComponentParser extends AbsComponentParser<BasicComponentValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "BasicComponentParser";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/parser/component/BasicComponentParser$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    @Override // com.alient.onearch.adapter.parser.component.AbsComponentParser
    @NotNull
    public BasicComponentValue parse(@NotNull Node node) {
        Object parseObject;
        JSONArray jSONArray;
        b41.i(node, "node");
        int type = node.getType();
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, b41.r("parseElement() - type:", Integer.valueOf(type)));
        }
        JSONObject data = node.getData();
        BasicComponentValue basicComponentValue = null;
        if (data != null) {
            try {
                try {
                    parseObject = data.toJavaObject(BasicComponentValue.class);
                } catch (Exception unused) {
                    parseObject = JSON.parseObject(data.toJSONString(), BasicComponentValue.class);
                }
                basicComponentValue = parseObject;
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
        JSONObject rawJson = node.getRawJson();
        if (rawJson != null && (jSONArray = rawJson.getJSONArray("render")) != null) {
            try {
                BasicComponentValue basicComponentValue2 = basicComponentValue;
                if (basicComponentValue2 != null) {
                    basicComponentValue2.setRenders(JSON.parseArray(jSONArray.toJSONString(), Render.class));
                }
            } catch (Exception e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e2;
                }
            }
        }
        if (basicComponentValue == null) {
            basicComponentValue = new BasicComponentValue(node);
        }
        if (node.getRawJson() != null) {
            basicComponentValue.setRawJson(node.getRawJson());
        }
        return basicComponentValue;
    }
}
