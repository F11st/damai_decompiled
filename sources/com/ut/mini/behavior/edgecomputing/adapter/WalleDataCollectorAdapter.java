package com.ut.mini.behavior.edgecomputing.adapter;

import android.content.ContentValues;
import com.alibaba.analytics.utils.Logger;
import com.taobao.walle.datacollector.WADataCollector;
import com.taobao.weex.annotation.JSMethod;
import com.tmall.android.dai.internal.database.SQLiteDatabase;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WalleDataCollectorAdapter extends AbstractDataCollectorAdapter {
    private static final String TAG = "WalleDataCollectorAdapter";
    private static WalleDataCollectorAdapter _instance;
    private static SQLiteDatabase mSQLiteDatabase;

    private WalleDataCollectorAdapter() {
        mSQLiteDatabase = WADataCollector.getInstance().getDB();
    }

    private void clearLegacyData(String str) {
        try {
            Logger.f(TAG, "clearLegacyData table", str);
            SQLiteDatabase db = getDB();
            db.execSQL("DELETE FROM " + str + " WHERE id < (SELECT MAX(id) FROM " + str + ") - 5000;");
        } catch (Exception e) {
            Logger.v(TAG, "clearLegacyData db error", e);
        }
    }

    private void createEdgeTable(String str) {
        try {
            Logger.f(TAG, "create edge table", str);
            SQLiteDatabase db = getDB();
            db.execSQL("CREATE TABLE IF NOT EXISTS " + str + "(id INTEGER PRIMARY KEY AUTOINCREMENT, left_node_id INTEGER, right_node_id INTEGER, left_table  VARCHAR,right_table VARCHAR,left_event_id VARCHAR,right_event_id VARCHAR,left_event_name VARCHAR,right_event_name VARCHAR,left_scene VARCHAR,right_scene VARCHAR,create_time VARCHAR)");
        } catch (Exception e) {
            Logger.v(TAG, "create db error", e);
        }
    }

    private void createNodeTable(String str) {
        try {
            Logger.f(TAG, "create node table", str);
            SQLiteDatabase db = getDB();
            db.execSQL("CREATE TABLE IF NOT EXISTS " + str + "(id INTEGER PRIMARY KEY AUTOINCREMENT, cold_start_id  VARCHAR, session_id  VARCHAR, pv_key  VARCHAR, pv_id VARCHAR, scene  VARCHAR, from_scene  VARCHAR, event_id VARCHAR, create_time  VARCHAR, user_id  VARCHAR, update_time  VARCHAR, page VARCHAR, arg1 VARCHAR,arg2 VARCHAR,arg3 VARCHAR,args VARCHAR,spm_cnt VARCHAR,spm_url VARCHAR,spm_pre VARCHAR,scm VARCHAR,scm_pre VARCHAR,utparam_cnt VARCHAR,utparam_url VARCHAR,utparam_pre VARCHAR,utlogmap VARCHAR,utlogmapedge VARCHAR,object_id  VARCHAR,object_type  VARCHAR,biz_arg1  VARCHAR, biz_arg2  VARCHAR, biz_arg3  VARCHAR, biz_arg4  VARCHAR, biz_arg5  VARCHAR, biz_arg6  VARCHAR, biz_arg7  VARCHAR, biz_arg8  VARCHAR, biz_arg9  VARCHAR, biz_arg10  VARCHAR, biz_args  VARCHAR, sys_arg1  VARCHAR, sys_arg2  VARCHAR, sys_arg3  VARCHAR, sys_arg4  VARCHAR, sys_arg5  VARCHAR,sys_args  VARCHAR )");
        } catch (Exception e) {
            Logger.v(TAG, "create db error", e);
        }
    }

    private SQLiteDatabase getDB() {
        return mSQLiteDatabase;
    }

    public static synchronized WalleDataCollectorAdapter getInstance() {
        WalleDataCollectorAdapter walleDataCollectorAdapter;
        synchronized (WalleDataCollectorAdapter.class) {
            if (_instance == null) {
                _instance = new WalleDataCollectorAdapter();
            }
            walleDataCollectorAdapter = _instance;
        }
        return walleDataCollectorAdapter;
    }

    private String getTableName(String str, String str2) {
        return "dc_" + str + JSMethod.NOT_SET + str2;
    }

    private long save(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            return -2L;
        }
        if (getDB() == null) {
            return -3L;
        }
        ContentValues contentValues = new ContentValues();
        for (String str3 : map.keySet()) {
            contentValues.put(str3, stringValue(map.get(str3)));
        }
        String tableName = getTableName(str, str2);
        Logger.f(TAG, "save table", tableName);
        return getDB().insertWithOnConflict(tableName, "", contentValues, 0);
    }

    private String stringValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    @Override // com.ut.mini.behavior.edgecomputing.adapter.AbstractDataCollectorAdapter
    public long commit(String str, String str2, String str3, Map<String, Object> map) {
        return save(str, str2, map);
    }

    @Override // com.ut.mini.behavior.edgecomputing.adapter.AbstractDataCollectorAdapter
    public void createTable(String str) {
        if (str.endsWith("node")) {
            createNodeTable(str);
        } else if (str.endsWith("edge")) {
            createEdgeTable(str);
        }
        clearLegacyData(str);
    }

    @Override // com.ut.mini.behavior.edgecomputing.adapter.AbstractDataCollectorAdapter
    public long update(String str, String str2, String str3, String str4, String[] strArr, Map<String, Object> map) {
        return update(str, str2, str4, strArr, map);
    }

    private int update(String str, String str2, String str3, String[] strArr, Map<String, Object> map) {
        if (map == null || getDB() == null || str3 == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        for (String str4 : map.keySet()) {
            contentValues.put(str4, stringValue(map.get(str4)));
        }
        String tableName = getTableName(str, str2);
        Logger.f(TAG, "update table", tableName);
        return getDB().updateWithOnConflict(tableName, contentValues, str3, strArr, 0);
    }
}
