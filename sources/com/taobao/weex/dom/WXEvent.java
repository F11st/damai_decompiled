package com.taobao.weex.dom;

import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.dom.binding.ELUtils;
import com.taobao.weex.dom.binding.JSONUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXEvent extends ArrayList<String> {
    public static final String EVENT_KEY_ARGS = "params";
    public static final String EVENT_KEY_TYPE = "type";
    private static final long serialVersionUID = -8186587029452440107L;
    private ArrayMap mEventBindingArgs;
    private ArrayMap<String, List<Object>> mEventBindingArgsValues;

    private void addBindingArgsEvent(String str, Object obj) {
        if (!contains(str)) {
            add(str);
        }
        if (obj != null) {
            if (this.mEventBindingArgs == null) {
                this.mEventBindingArgs = new ArrayMap();
            }
            this.mEventBindingArgs.put(str, ELUtils.bindingBlock(obj));
        }
    }

    private String addBindingEvent(JSONObject jSONObject) {
        String string = jSONObject.getString("type");
        Object obj = jSONObject.get("params");
        if (string != null) {
            addBindingArgsEvent(string, obj);
        }
        return string;
    }

    public static String getEventName(Object obj) {
        if (obj instanceof CharSequence) {
            return obj.toString();
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).getString("type");
        }
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public void addEvent(Object obj) {
        if (obj instanceof CharSequence) {
            if (JSONUtils.isJSON(obj.toString())) {
                addEvent(JSONUtils.toJSON(obj.toString()));
                return;
            }
            String obj2 = obj.toString();
            if (contains(obj2)) {
                return;
            }
            add(obj2);
        } else if (obj instanceof JSONObject) {
            addBindingEvent((JSONObject) obj);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ArrayMap arrayMap = this.mEventBindingArgs;
        if (arrayMap != null) {
            arrayMap.clear();
        }
        ArrayMap<String, List<Object>> arrayMap2 = this.mEventBindingArgsValues;
        if (arrayMap2 != null) {
            arrayMap2.clear();
        }
        super.clear();
    }

    public ArrayMap getEventBindingArgs() {
        return this.mEventBindingArgs;
    }

    public ArrayMap<String, List<Object>> getEventBindingArgsValues() {
        return this.mEventBindingArgsValues;
    }

    public void parseStatements() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size(); i++) {
            String str = get(i);
            if (JSONUtils.isJSON(str)) {
                set(i, addBindingEvent(JSONUtils.toJSON(str)));
            }
        }
    }

    public void putEventBindingArgsValue(String str, List<Object> list) {
        if (this.mEventBindingArgsValues == null) {
            this.mEventBindingArgsValues = new ArrayMap<>();
        }
        if (list == null) {
            this.mEventBindingArgsValues.remove(str);
        } else {
            this.mEventBindingArgsValues.put(str, list);
        }
    }

    public boolean remove(String str) {
        ArrayMap arrayMap = this.mEventBindingArgs;
        if (arrayMap != null) {
            arrayMap.remove(str);
        }
        ArrayMap<String, List<Object>> arrayMap2 = this.mEventBindingArgsValues;
        if (arrayMap2 != null) {
            arrayMap2.remove(str);
        }
        return super.remove((Object) str);
    }

    @Override // java.util.ArrayList
    public WXEvent clone() {
        WXEvent wXEvent = new WXEvent();
        wXEvent.addAll(this);
        ArrayMap arrayMap = this.mEventBindingArgs;
        if (arrayMap != null) {
            wXEvent.mEventBindingArgs = new ArrayMap(arrayMap);
        }
        wXEvent.mEventBindingArgsValues = null;
        return wXEvent;
    }
}
