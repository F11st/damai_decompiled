package com.alient.onearch.adapter.component.footer;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alient.onearch.adapter.component.footer.GenericFooterContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.uc.webview.export.cyclone.StatAction;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.HashMap;
import java.util.Map;
import tb.yh0;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GenericFooterModel extends AbsModel<GenericItem<ItemValue>, Object> implements GenericFooterContract.Model {
    private String componentId;
    private JSONArray result;
    private int total;

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.Model
    public String getComponentId() {
        return this.componentId;
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.Model
    public JSONArray getResult() {
        JSONArray jSONArray = this.result;
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.Model
    public int getTotal() {
        return this.total;
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.Model
    public TrackInfo getTrackInfo() {
        if (getItemAction() != null) {
            return getItemAction().getTrackInfo();
        }
        return new TrackInfo();
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(GenericItem<ItemValue> genericItem) {
        JSONObject data = genericItem.getProperty().getData();
        if (data != null) {
            this.componentId = data.getString("componentId");
            JSONObject jSONObject = data.getJSONObject("item");
            if (jSONObject != null) {
                this.total = jSONObject.getIntValue(StatAction.KEY_TOTAL);
                this.result = jSONObject.getJSONArray(jSONObject.getJSONArray("list") == null ? "result" : "list");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseTrackInfo(GenericItem<ItemValue> genericItem) {
        JSONObject jSONObject;
        setActions(new HashMap());
        JSONObject data = genericItem.getProperty().getData();
        if (data != null) {
            JSONObject jSONObject2 = data.getJSONObject("action");
            if (jSONObject2 != null) {
                try {
                    setActions((Map) yh0.INSTANCE.b(jSONObject2.toJSONString(), new TypeReference<HashMap<String, Action>>() { // from class: com.alient.onearch.adapter.component.footer.GenericFooterModel.1
                    }));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ModelValue property = genericItem.component.getModule().getContainer().getProperty();
            ComponentValue property2 = genericItem.component.getProperty();
            JSONObject jSONObject3 = null;
            JSONObject a = (property.getData() == null || (jSONObject = property.getData().getJSONObject("globalConfig")) == null || TextUtils.isEmpty(jSONObject.getString("pabBucket"))) ? null : yh0.INSTANCE.a(jSONObject.getString("pabBucket"));
            if (property2.getData() != null && !TextUtils.isEmpty(property2.getData().getString("abBucket"))) {
                jSONObject3 = yh0.INSTANCE.a(property2.getData().getString("abBucket"));
            }
            if (getActions() != null) {
                for (Action action : getActions().values()) {
                    if (action.getTrackInfo() != null) {
                        action.getTrackInfo().setPabBucket(a);
                        action.getTrackInfo().setAbBucket(jSONObject3);
                        if (jSONObject3 != null) {
                            if (action.getTrackInfo().getArgs() == null) {
                                action.getTrackInfo().setArgs(new HashMap<>());
                            }
                            action.getTrackInfo().getArgs().put("ABTrackInfo", jSONObject3.toJSONString());
                        }
                    }
                }
                setItemAction(getActions().get("more"));
            }
        }
    }
}
