package com.taobao.android.ultron.datamodel.imp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMEvent implements IDMEvent, Serializable, Cloneable {
    private List<IDMComponent> mComponents;
    private JSONObject mFields;
    private JSONObject mStashFields;
    private String mType;

    public DMEvent(String str, JSONObject jSONObject, List<IDMComponent> list) {
        this.mType = str;
        this.mFields = jSONObject;
        this.mComponents = list;
    }

    @Override // com.taobao.android.ultron.common.model.IDMEvent
    public List<IDMComponent> getComponents() {
        return this.mComponents;
    }

    @Override // com.taobao.android.ultron.common.model.IDMEvent
    public JSONObject getFields() {
        return this.mFields;
    }

    @Override // com.taobao.android.ultron.common.model.IDMEvent
    public String getType() {
        return this.mType;
    }

    @Override // com.taobao.android.ultron.common.model.IDMEvent
    public void record() {
        JSONObject jSONObject = this.mFields;
        if (jSONObject != null) {
            this.mStashFields = JSON.parseObject(jSONObject.toJSONString());
        }
    }

    @Override // com.taobao.android.ultron.common.model.IDMEvent
    public void rollBack() {
        JSONObject jSONObject = this.mStashFields;
        if (jSONObject != null) {
            this.mFields = jSONObject;
            this.mStashFields = null;
        }
    }

    @Override // com.taobao.android.ultron.common.model.IDMEvent
    public void writeFields(String str, Object obj) {
        if (this.mFields == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.mFields.put(str, obj);
    }
}
