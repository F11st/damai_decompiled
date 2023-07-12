package com.ut.mini.behavior.edgecomputing.node;

import android.os.Build;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseNode {
    private static final String TABLE_TYPE = "ut";
    public static final String TAG = "BaseNode";
    public Map<String, Object> baseSaveMap;
    public long id = -1;
    public String cold_start_id = "";
    public String session_id = "";
    public String pv_key = "";
    public String pv_id = "";
    public String scene = "";
    public String from_scene = "";
    public String event_id = "";
    public String createTime = "";
    public String updateTime = "";
    public String user_id = "";
    public String page = "";
    public Map<String, String> bizMap = null;

    public Map<String, Object> getBaseSaveMap() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.baseSaveMap = synchronizedMap;
        synchronizedMap.put(UTDataCollectorNodeColumn.COLD_START_ID, BaseNodeHelper.stringNotNull(this.cold_start_id));
        this.baseSaveMap.put("session_id", BaseNodeHelper.stringNotNull(this.session_id));
        this.baseSaveMap.put(UTDataCollectorNodeColumn.PV_KEY, BaseNodeHelper.stringNotNull(this.pv_key));
        this.baseSaveMap.put("scene", BaseNodeHelper.stringNotNull(this.scene));
        this.baseSaveMap.put(UTDataCollectorNodeColumn.FROM_SCENE, BaseNodeHelper.stringNotNull(this.from_scene));
        this.baseSaveMap.put(UTDataCollectorNodeColumn.EVENT_ID, BaseNodeHelper.stringNotNull(this.event_id));
        this.baseSaveMap.put("create_time", BaseNodeHelper.stringNotNull(this.createTime));
        this.baseSaveMap.put(UTDataCollectorNodeColumn.UPDATE_TIME, BaseNodeHelper.stringNotNull(this.updateTime));
        this.baseSaveMap.put(UTDataCollectorNodeColumn.USER_ID, BaseNodeHelper.stringNotNull(this.user_id));
        this.baseSaveMap.put("page", BaseNodeHelper.stringNotNull(this.page));
        Map<String, String> map = this.bizMap;
        if (map != null) {
            this.baseSaveMap.put(UTDataCollectorNodeColumn.PV_ID, BaseNodeHelper.stringNotNull(map.get("utpvid")));
            this.baseSaveMap.put("arg1", BaseNodeHelper.stringNotNull(this.bizMap.get(LogField.ARG1.toString())));
            this.baseSaveMap.put("arg2", BaseNodeHelper.stringNotNull(this.bizMap.get(LogField.ARG2.toString())));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.ARG3, BaseNodeHelper.stringNotNull(this.bizMap.get(LogField.ARG3.toString())));
            try {
                this.baseSaveMap.put("args", BaseNodeHelper.stringNotNull(JSON.toJSONString(this.bizMap)));
            } catch (Exception unused) {
            }
            this.baseSaveMap.put(UTDataCollectorNodeColumn.SPM_CNT, BaseNodeHelper.stringNotNull(this.bizMap.get("spm-cnt")));
            this.baseSaveMap.put("spm_url", BaseNodeHelper.stringNotNull(this.bizMap.get("spm-url")));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.SPM_PRE, BaseNodeHelper.stringNotNull(this.bizMap.get("spm-pre")));
            this.baseSaveMap.put("scm", BaseNodeHelper.stringNotNull(this.bizMap.get("scm")));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.SCM_PRE, BaseNodeHelper.stringNotNull(this.bizMap.get("scm-pre")));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.UTPARM_CNT, BaseNodeHelper.stringNotNull(this.bizMap.get("utparam-cnt")));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.UTPARAM_URL, BaseNodeHelper.stringNotNull(this.bizMap.get("utparam-url")));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.UTPARAM_PRE, BaseNodeHelper.stringNotNull(this.bizMap.get("utparam-pre")));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.UTLOGMAP, BaseNodeHelper.stringNotNull(this.bizMap.get(UTDataCollectorNodeColumn.UTLOGMAP)));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.UTLOGMAPEDGE, BaseNodeHelper.stringNotNull(this.bizMap.get(UTDataCollectorNodeColumn.UTLOGMAPEDGE)));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.OBJECT_ID, BaseNodeHelper.stringNotNull(this.bizMap.get(UTDataCollectorNodeColumn.OBJECT_ID)));
            this.baseSaveMap.put(UTDataCollectorNodeColumn.OBJECT_TYPE, BaseNodeHelper.stringNotNull(this.bizMap.get(UTDataCollectorNodeColumn.OBJECT_TYPE)));
            BaseNodeHelper.getInstance().putArgFields(this.baseSaveMap, this.bizMap);
        }
        return this.baseSaveMap;
    }

    public abstract String getNodeType();

    public String getTableName() {
        return "dc_ut_" + getNodeType();
    }

    public long save() {
        Map<String, Object> baseSaveMap = getBaseSaveMap();
        this.baseSaveMap = baseSaveMap;
        if (baseSaveMap != null && Build.VERSION.SDK_INT >= 21) {
            return UTDataCollector.getInstance().getDataCollectorAdapter().commit(TABLE_TYPE, getNodeType(), this.createTime, this.baseSaveMap);
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
            return UTDataCollector.getInstance().getDataCollectorAdapter().update(TABLE_TYPE, getNodeType(), this.updateTime, "id=" + this.id, null, this.baseSaveMap);
        }
        return -1L;
    }

    public void updateBizMap(Map<String, String> map) {
        try {
            this.bizMap = Collections.synchronizedMap(new HashMap(map));
        } catch (Exception unused) {
        }
    }

    public long updatePageName() {
        Logger.f(TAG, "update id", Long.valueOf(this.id), "pageName", this.page, UTDataCollectorNodeColumn.PV_KEY, this.pv_key);
        if (this.id >= 0 && Build.VERSION.SDK_INT >= 21) {
            Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap());
            synchronizedMap.put(UTDataCollectorNodeColumn.PV_KEY, BaseNodeHelper.stringNotNull(this.pv_key));
            synchronizedMap.put("page", BaseNodeHelper.stringNotNull(this.page));
            return UTDataCollector.getInstance().getDataCollectorAdapter().update(TABLE_TYPE, getNodeType(), this.updateTime, "id=" + this.id, null, synchronizedMap);
        }
        return -1L;
    }
}
