package com.taobao.weex.ui.component.list.template;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONArray;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CellDataManager {
    public static final String SUB_COMPONENT_TEMPLATE_ID = "@templateId";
    public static final String VIRTUAL_COMPONENT_ID = "@virtualComponentId";
    private static final String VIRTUAL_COMPONENT_SEPRATOR = "@";
    JSONArray listData;
    private Map<Integer, CellRenderState> renderStates = new ArrayMap();
    public final WXRecyclerTemplateList templateList;
    private Map<String, CellRenderState> virtualComponentRenderStates;

    public CellDataManager(WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.templateList = wXRecyclerTemplateList;
    }

    private void cleanRenderState(CellRenderState cellRenderState) {
        if (cellRenderState != null && cellRenderState.hasVirtualComponents()) {
            for (String str : cellRenderState.getVirtualComponentIds().values()) {
                Map<String, CellRenderState> map = this.virtualComponentRenderStates;
                if (map != null) {
                    map.remove(str);
                }
                WXBridgeManager.getInstance().asyncCallJSEventVoidResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, this.templateList.getInstanceId(), null, str, "lifecycle", "detach", null);
            }
        }
    }

    public static String createVirtualComponentId(String str, String str2, long j) {
        return str + "@" + str2 + "@" + j;
    }

    public static String getListRef(String str) {
        if (str == null) {
            return null;
        }
        return str.split("@")[0];
    }

    public void createVirtualComponentData(int i, String str, Object obj) {
        if (this.virtualComponentRenderStates == null) {
            this.virtualComponentRenderStates = new HashMap(8);
        }
        CellRenderState cellRenderState = this.renderStates.get(Integer.valueOf(i));
        cellRenderState.getVirtualComponentDatas().put(str, obj);
        this.virtualComponentRenderStates.put(str, cellRenderState);
    }

    public CellRenderState getRenderState(int i) {
        CellRenderState cellRenderState = this.renderStates.get(Integer.valueOf(i));
        if (cellRenderState == null) {
            cellRenderState = new CellRenderState();
            cellRenderState.position = i;
            this.renderStates.put(Integer.valueOf(i), cellRenderState);
        }
        if (i != cellRenderState.position) {
            cellRenderState.position = i;
            cellRenderState.hasPositionChange = true;
        }
        return cellRenderState;
    }

    public boolean insertData(int i, Object obj) {
        this.listData.add(i, obj);
        boolean z = false;
        for (int size = this.listData.size(); size >= i; size--) {
            CellRenderState remove = this.renderStates.remove(Integer.valueOf(size));
            if (remove != null) {
                this.renderStates.put(Integer.valueOf(size + 1), remove);
                z = true;
            }
        }
        return z;
    }

    public boolean insertRange(int i, JSONArray jSONArray) {
        this.listData.addAll(i, jSONArray);
        boolean z = false;
        for (int size = this.listData.size() - 1; size >= i; size--) {
            CellRenderState remove = this.renderStates.remove(Integer.valueOf(size));
            if (remove != null) {
                this.renderStates.put(Integer.valueOf(size + 1), remove);
                z = true;
            }
        }
        return z;
    }

    public void removeData(Integer num) {
        this.listData.remove(num.intValue());
        cleanRenderState(this.renderStates.remove(num));
        int size = this.listData.size() + 1;
        int intValue = num.intValue();
        while (true) {
            intValue++;
            if (intValue >= size) {
                return;
            }
            CellRenderState remove = this.renderStates.remove(Integer.valueOf(intValue));
            if (remove != null) {
                this.renderStates.put(Integer.valueOf(intValue - 1), remove);
            }
        }
    }

    public void setListData(JSONArray jSONArray) {
        JSONArray jSONArray2 = this.listData;
        if (jSONArray2 != jSONArray) {
            if (jSONArray2 != null && WXUtils.getBoolean(this.templateList.getAttrs().get("exitDetach"), Boolean.TRUE).booleanValue()) {
                for (int i = 0; i < this.listData.size(); i++) {
                    cleanRenderState(this.renderStates.remove(Integer.valueOf(i)));
                }
            }
            this.listData = jSONArray;
            this.renderStates.clear();
            Map<String, CellRenderState> map = this.virtualComponentRenderStates;
            if (map != null) {
                map.clear();
            }
        }
    }

    public boolean updateData(Object obj, int i) {
        boolean equals = TextUtils.equals(this.templateList.getTemplateKey(i), this.templateList.getTemplateKey(obj));
        this.listData.set(i, obj);
        if (!equals) {
            cleanRenderState(this.renderStates.remove(Integer.valueOf(i)));
        } else {
            CellRenderState cellRenderState = this.renderStates.get(Integer.valueOf(i));
            if (cellRenderState != null) {
                cellRenderState.hasDataUpdate = true;
            }
        }
        return equals;
    }

    public void updateVirtualComponentData(String str, Object obj) {
        Map<String, CellRenderState> map = this.virtualComponentRenderStates;
        if (map != null) {
            CellRenderState cellRenderState = map.get(str);
            if (cellRenderState != null) {
                cellRenderState.getVirtualComponentDatas().put(str, obj);
                cellRenderState.hasVirtualCompoentUpdate = true;
            } else if (WXEnvironment.isApkDebugable()) {
                throw new IllegalArgumentException("virtualComponentDatas illegal state empty render state" + str);
            }
        } else if (WXEnvironment.isApkDebugable()) {
            throw new IllegalArgumentException("virtualComponentDatas illegal state " + str);
        }
    }
}
