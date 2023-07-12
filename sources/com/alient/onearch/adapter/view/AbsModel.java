package com.alient.onearch.adapter.view;

import android.taobao.windvane.connect.api.ApiResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alient.onearch.adapter.pom.BasicItemValue;
import com.alient.oneservice.nav.Action;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\b\u0001\u0010\u0005*\u00020\u00042\b\u0012\u0004\u0012\u00028\u00000\u0006B\u0007¢\u0006\u0004\b.\u0010/J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\nR$\u0010\u000e\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u00018\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011RF\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRF\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR.\u0010\u001e\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00148\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R.\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\r\u001a\u0004\u0018\u00010$8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010+\u001a\u0004\u0018\u00010$2\b\u0010\r\u001a\u0004\u0018\u00010$8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*¨\u00060"}, d2 = {"Lcom/alient/onearch/adapter/view/AbsModel;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "", ApiResponse.VALUE, "Lcom/youku/arch/v3/view/AbsModel;", "item", "Ltb/wt2;", "parseModel", "(Lcom/youku/arch/v3/IItem;)V", "parseTrackInfo", "parseModelImpl", "<set-?>", "value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "", "", "Lcom/alient/oneservice/nav/Action;", "actions", "Ljava/util/Map;", "getActions", "()Ljava/util/Map;", "setActions", "(Ljava/util/Map;)V", "componentActions", "getComponentActions", "setComponentActions", "itemAction", "Lcom/alient/oneservice/nav/Action;", "getItemAction", "()Lcom/alient/oneservice/nav/Action;", "setItemAction", "(Lcom/alient/oneservice/nav/Action;)V", "Lcom/alibaba/fastjson/JSONObject;", "pabBucket", "Lcom/alibaba/fastjson/JSONObject;", "getPabBucket", "()Lcom/alibaba/fastjson/JSONObject;", "setPabBucket", "(Lcom/alibaba/fastjson/JSONObject;)V", "abBucket", "getAbBucket", "setAbBucket", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class AbsModel<I extends IItem<ItemValue>, VALUE> extends com.youku.arch.v3.view.AbsModel<I> {
    @Nullable
    private JSONObject abBucket;
    @Nullable
    private Map<String, Action> actions = new HashMap();
    @Nullable
    private Map<String, Action> componentActions = new HashMap();
    @Nullable
    private Action itemAction;
    @Nullable
    private JSONObject pabBucket;
    private VALUE value;

    @Nullable
    public final JSONObject getAbBucket() {
        return this.abBucket;
    }

    @Nullable
    public final Map<String, Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Map<String, Action> getComponentActions() {
        return this.componentActions;
    }

    @Nullable
    public final Action getItemAction() {
        return this.itemAction;
    }

    @Nullable
    public final JSONObject getPabBucket() {
        return this.pabBucket;
    }

    @NotNull
    public final VALUE getValue() {
        VALUE value = this.value;
        if (value != null) {
            return value;
        }
        b41.A("value");
        return (VALUE) wt2.INSTANCE;
    }

    @Override // com.youku.arch.v3.view.IContract.Model
    public final void parseModel(@NotNull I i) {
        b41.i(i, "item");
        parseTrackInfo(i);
        parseModelImpl(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseModelImpl(@NotNull I i) {
        b41.i(i, "item");
        if (!(i.getProperty() instanceof BasicItemValue) || ((BasicItemValue) i.getProperty()).getValue() == null) {
            return;
        }
        try {
            VALUE value = (VALUE) ((BasicItemValue) i.getProperty()).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type VALUE of com.alient.onearch.adapter.view.AbsModel");
            }
            this.value = value;
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseTrackInfo(@NotNull I i) {
        b41.i(i, "item");
        JSONObject data = i.getProperty().getData();
        JSONObject jSONObject = data == null ? null : data.getJSONObject("action");
        if (jSONObject != null) {
            try {
                this.actions = (Map) JSON.parseObject(jSONObject.toJSONString(), new TypeReference<HashMap<String, Action>>() { // from class: com.alient.onearch.adapter.view.AbsModel$parseTrackInfo$1
                }, new Feature[0]);
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
            Map<String, Action> map = this.actions;
            this.itemAction = map == null ? null : map.get("item");
        }
        JSONObject data2 = i.getComponent().getProperty().getData();
        JSONObject jSONObject2 = data2 != null ? data2.getJSONObject("action") : null;
        if (jSONObject2 != null) {
            try {
                this.componentActions = (Map) JSON.parseObject(jSONObject2.toJSONString(), new TypeReference<HashMap<String, Action>>() { // from class: com.alient.onearch.adapter.view.AbsModel$parseTrackInfo$2
                }, new Feature[0]);
            } catch (Exception e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    protected final void setAbBucket(@Nullable JSONObject jSONObject) {
        this.abBucket = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setActions(@Nullable Map<String, Action> map) {
        this.actions = map;
    }

    protected final void setComponentActions(@Nullable Map<String, Action> map) {
        this.componentActions = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setItemAction(@Nullable Action action) {
        this.itemAction = action;
    }

    protected final void setPabBucket(@Nullable JSONObject jSONObject) {
        this.pabBucket = jSONObject;
    }
}
