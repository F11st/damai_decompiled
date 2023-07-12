package com.alimm.xadsdk.base.expose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RetryMonitorDbHelper extends SQLiteOpenHelper {
    public static final String COLUMN_AD_TYPE = "ad_type";
    public static final String COLUMN_CREATIVE_ID = "creative_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_EXPIRE_TIME = "expire_time";
    public static final String COLUMN_GROUP_ID = "group_id";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMPRESSION_ID = "impression_id";
    public static final String COLUMN_MONITOR_SDK = "monitor_sdk";
    public static final String COLUMN_MONITOR_TYPE = "monitor_type";
    public static final String COLUMN_MONITOR_URL = "monitor_url";
    public static final String COLUMN_RETRY_TIMES = "retry_times";
    private static final String DATABASE_NAME = "mm_ad_sdk.db";
    private static final int DATABASE_VERSION = 1;
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TABLE_RETRY_MONITOR_INFO = "retry_monitor_info";
    private static final String TAG = "RetryMonitorDbHelper";

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryMonitorDbHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public synchronized void delete(long j) {
        try {
            long delete = getWritableDatabase().delete(TABLE_RETRY_MONITOR_INFO, "id = ?", new String[]{String.valueOf(j)});
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "delete: id = " + j + ", deleteRows = " + delete);
            }
        } finally {
        }
    }

    public synchronized void delete(long j, int i) {
        long delete = getWritableDatabase().delete(TABLE_RETRY_MONITOR_INFO, "expire_time > ? or retry_times >= ?", new String[]{String.valueOf(j), String.valueOf(i)});
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "delete: deletedRows = " + delete + ", expireTime = " + j + ", maxRetryTimes = " + i);
        }
    }

    public synchronized void delete(String str, int i) {
        long delete = getWritableDatabase().delete(TABLE_RETRY_MONITOR_INFO, "date != ? or retry_times >= ?", new String[]{str, String.valueOf(i)});
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "delete: deletedRows = " + delete + ", date = " + str + ", maxRetryTimes = " + i);
        }
    }

    public synchronized void insert(BidInfo bidInfo, String str, String str2, String str3, int i, long j, long j2) {
        if (bidInfo == null) {
            LogUtils.d(TAG, "insert failed with a null bidInfo.");
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_type", Integer.valueOf(bidInfo.getType()));
        contentValues.put(COLUMN_CREATIVE_ID, bidInfo.getCreativeId());
        contentValues.put(COLUMN_GROUP_ID, bidInfo.getGroupId());
        contentValues.put(COLUMN_IMPRESSION_ID, bidInfo.getImpressionId());
        contentValues.put(COLUMN_MONITOR_TYPE, str);
        contentValues.put(COLUMN_MONITOR_SDK, str2);
        contentValues.put(COLUMN_MONITOR_URL, str3);
        contentValues.put(COLUMN_RETRY_TIMES, Integer.valueOf(i));
        String formatTimeInMillis = Utils.formatTimeInMillis(j, DATE_FORMAT);
        contentValues.put("date", formatTimeInMillis);
        contentValues.put("expire_time", Long.valueOf(j2));
        long insert = writableDatabase.insert(TABLE_RETRY_MONITOR_INFO, null, contentValues);
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "insert: index = " + insert + ", exposeDate = " + formatTimeInMillis);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onCreate: createRetryTableSql = CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, ad_type VARCHAR(10), creative_id VTEXT, group_id TEXT,impression_id TEXT, monitor_type VARCHAR(10), monitor_sdk VARCHAR(5), monitor_url TEXT, retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, ad_type VARCHAR(10), creative_id VTEXT, group_id TEXT,impression_id TEXT, monitor_type VARCHAR(10), monitor_sdk VARCHAR(5), monitor_url TEXT, retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onUpgrade: oldVer = " + i + ", newVer = " + i2);
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_monitor_info");
        onCreate(sQLiteDatabase);
    }

    @NonNull
    public synchronized List<RetryMonitorInfo> query(long j) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor query = getReadableDatabase().query(TABLE_RETRY_MONITOR_INFO, null, "expire_time <= ?", new String[]{String.valueOf(j)}, null, null, null, null);
        while (query != null) {
            try {
                if (!query.moveToNext()) {
                    break;
                }
                RetryMonitorInfo retryMonitorInfo = new RetryMonitorInfo(query);
                arrayList.add(retryMonitorInfo);
                if (LogUtils.DEBUG) {
                    LogUtils.d(TAG, "query: add retryMonitorInfo = " + retryMonitorInfo);
                }
            } catch (Exception e) {
                LogUtils.d(TAG, "query exception, expireTime = " + j, e);
            }
        }
        if (query != null) {
            query.close();
        }
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "query: expireTime = " + j + ", retryMonitorInfoList = " + arrayList);
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<RetryMonitorInfo> query(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor query = getReadableDatabase().query(TABLE_RETRY_MONITOR_INFO, null, "date = ?", new String[]{str}, null, null, null, null);
        while (query != null) {
            try {
                if (!query.moveToNext()) {
                    break;
                }
                RetryMonitorInfo retryMonitorInfo = new RetryMonitorInfo(query);
                arrayList.add(retryMonitorInfo);
                if (LogUtils.DEBUG) {
                    LogUtils.d(TAG, "query: add retryMonitorInfo = " + retryMonitorInfo);
                }
            } catch (Exception e) {
                LogUtils.d(TAG, "query exception, date = " + str, e);
            }
        }
        if (query != null) {
            query.close();
        }
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "query: exposeDate = " + str + ", retryMonitorInfoList = " + arrayList);
        }
        return arrayList;
    }

    public synchronized void update(long j, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_RETRY_TIMES, Integer.valueOf(i));
        writableDatabase.update(TABLE_RETRY_MONITOR_INFO, contentValues, "id = ?", new String[]{String.valueOf(j)});
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "update: id = " + j + ", retryTimes = " + i);
        }
    }
}
