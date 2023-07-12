package com.taobao.android.ultron.datamodel.imp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ExtendBlock implements Serializable, Cloneable {
    Map<String, List<IDMComponent>> blockComponents = new LinkedHashMap();
    Map<String, JSONObject> blockHierarchy = new HashMap();
    private IDMComponent mExtendBlock;

    public ExtendBlock(IDMComponent iDMComponent) {
        this.mExtendBlock = iDMComponent;
    }

    private void handleSubKeyArray(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (str == null || !jSONObject.containsKey(str)) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        jSONObject2.put(str, (Object) jSONArray);
        for (int i = 0; i < jSONArray.size(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof String) {
                handleSubKeyArray((String) obj, jSONObject, jSONObject2);
            }
        }
    }

    public void addBlock(String str, List<IDMComponent> list) {
        this.blockComponents.put(str, list);
    }

    public void addHierarchy(String str, a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = this.blockHierarchy.get(str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject n = aVar.n();
        if (n.containsKey(str)) {
            JSONArray jSONArray = n.getJSONArray(str);
            jSONObject.put(str, (Object) jSONArray);
            for (int i = 0; i < jSONArray.size(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    handleSubKeyArray((String) obj, n, jSONObject);
                }
            }
            this.blockHierarchy.put(str, jSONObject);
            return;
        }
        this.blockHierarchy.remove(str);
    }

    public JSONObject getBlockHierarchy(String str) {
        if (this.blockHierarchy.containsKey(str)) {
            return this.blockHierarchy.get(str);
        }
        return null;
    }

    public IDMComponent getExtendBlock() {
        return this.mExtendBlock;
    }

    public List<IDMComponent> getblockComponentList() {
        List<IDMComponent> value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<IDMComponent>> entry : this.blockComponents.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                arrayList.addAll(value);
            }
        }
        return arrayList;
    }

    public void updateExtendBlock(IDMComponent iDMComponent) {
        this.mExtendBlock = iDMComponent;
    }
}
