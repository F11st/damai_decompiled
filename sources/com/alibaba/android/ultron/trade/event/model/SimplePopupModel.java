package com.alibaba.android.ultron.trade.event.model;

import com.alibaba.fastjson.JSONArray;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SimplePopupModel implements Serializable {
    AsSelect asSelect;
    JSONArray components;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static final class AsSelect implements Serializable {
        String max;
        String optional;
        List<String> selectedIds;

        public String getMax() {
            return this.max;
        }

        public String getOptional() {
            return this.optional;
        }

        public List<String> getSelectedIds() {
            return this.selectedIds;
        }

        public void setMax(String str) {
            this.max = str;
        }

        public void setOptional(String str) {
            this.optional = str;
        }

        public void setSelectedIds(List<String> list) {
            this.selectedIds = list;
        }
    }

    public AsSelect getAsSelect() {
        return this.asSelect;
    }

    public JSONArray getComponents() {
        return this.components;
    }

    public void setAsSelect(AsSelect asSelect) {
        this.asSelect = asSelect;
    }

    public void setComponents(JSONArray jSONArray) {
        this.components = jSONArray;
    }
}
