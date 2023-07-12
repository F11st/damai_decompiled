package com.ut.mini.behavior.edgecomputing.node;

import android.os.Build;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorEdgeColumn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Edge {
    private static final String TABLE_TYPE = "ut";
    public static final String TAG = "Edge";
    public Map<String, Object> baseSaveMap;
    public long id = -1;
    public long left_node_id = 0;
    public long right_node_id = 0;
    public String left_table = "";
    public String right_table = "";
    public String left_event_id = "";
    public String right_event_id = "";
    public String left_event_name = "";
    public String right_event_name = "";
    public String left_scene = "";
    public String right_scene = "";
    public String create_time = "";
    public String update_time = "";

    public Map<String, Object> getBaseSaveMap() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.baseSaveMap = synchronizedMap;
        synchronizedMap.put(UTDataCollectorEdgeColumn.LEFT_NODE_ID, Long.valueOf(this.left_node_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_NODE_ID, Long.valueOf(this.right_node_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_TABLE, BaseNodeHelper.stringNotNull(this.left_table));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_TABLE, BaseNodeHelper.stringNotNull(this.right_table));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_EVENT_ID, BaseNodeHelper.stringNotNull(this.left_event_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_EVENT_ID, BaseNodeHelper.stringNotNull(this.right_event_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_EVENT_NAME, BaseNodeHelper.stringNotNull(this.left_event_name));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_EVENT_NAME, BaseNodeHelper.stringNotNull(this.right_event_name));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_SCENE, BaseNodeHelper.stringNotNull(this.left_scene));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_SCENE, BaseNodeHelper.stringNotNull(this.right_scene));
        this.baseSaveMap.put("create_time", BaseNodeHelper.stringNotNull(this.create_time));
        return this.baseSaveMap;
    }

    String getType() {
        return "edge";
    }

    public long save() {
        Map<String, Object> baseSaveMap = getBaseSaveMap();
        this.baseSaveMap = baseSaveMap;
        if (baseSaveMap != null && Build.VERSION.SDK_INT >= 21) {
            return UTDataCollector.getInstance().getDataCollectorAdapter().commit(TABLE_TYPE, getType(), this.create_time, this.baseSaveMap);
        }
        return -1L;
    }

    public long update() {
        Logger.f(TAG, "update id", Long.valueOf(this.id));
        if (this.id < 0) {
            return -1L;
        }
        Map<String, Object> baseSaveMap = getBaseSaveMap();
        this.baseSaveMap = baseSaveMap;
        if (baseSaveMap != null && Build.VERSION.SDK_INT >= 21) {
            return UTDataCollector.getInstance().getDataCollectorAdapter().update(TABLE_TYPE, getType(), "" + System.currentTimeMillis(), "id=" + this.id, null, this.baseSaveMap);
        }
        return -1L;
    }
}
