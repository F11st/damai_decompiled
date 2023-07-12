package com.taobao.accs.statistics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DBHelper extends SQLiteOpenHelper {
    private static final int MAX_DB_COUNT = 4000;
    private static final int MAX_SQL_NUM = 5;
    private static final String TAG = "DBHelper";
    private static final Lock lock = new ReentrantLock();
    private static volatile DBHelper sInstance;
    LinkedList<SQLObject> cachedSql;
    public int curLogsCount;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class SQLObject {
        Object[] args;
        String sql;

        private SQLObject(String str, Object[] objArr) {
            this.sql = str;
            this.args = objArr;
        }
    }

    private DBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.curLogsCount = 0;
        this.cachedSql = new LinkedList<>();
        this.mContext = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r2 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean checkTrafficsExist(java.lang.String r13, java.lang.String r14, java.lang.String r15, boolean r16, long r17, java.lang.String r19) {
        /*
            r12 = this;
            monitor-enter(r12)
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.getWritableDatabase()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r3 != 0) goto Lb
            monitor-exit(r12)
            return r1
        Lb:
            java.lang.String r4 = "traffic"
            java.lang.String r5 = "_id"
            java.lang.String r6 = "date"
            java.lang.String r7 = "host"
            java.lang.String r8 = "serviceid"
            java.lang.String r9 = "bid"
            java.lang.String r10 = "isbackground"
            java.lang.String r11 = "size"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11}     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r6 = "date=? AND host=? AND bid=? AND isbackground=?"
            r0 = 4
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r7[r1] = r19     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r0 = 1
            r7[r0] = r13     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r8 = 2
            r7[r8] = r15     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r8 = 3
            java.lang.String r9 = java.lang.String.valueOf(r16)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r7[r8] = r9     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 100
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r2 == 0) goto L4d
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r3 <= 0) goto L4d
            r2.close()     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r12)
            return r0
        L4d:
            if (r2 == 0) goto L64
        L4f:
            r2.close()     // Catch: java.lang.Throwable -> L6c
            goto L64
        L53:
            r0 = move-exception
            goto L66
        L55:
            r0 = move-exception
            java.lang.String r3 = "DBHelper"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L53
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L53
            com.taobao.accs.utl.ALog.w(r3, r0, r4)     // Catch: java.lang.Throwable -> L53
            if (r2 == 0) goto L64
            goto L4f
        L64:
            monitor-exit(r12)
            return r1
        L66:
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.lang.Throwable -> L6c
        L6b:
            throw r0     // Catch: java.lang.Throwable -> L6c
        L6c:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.statistics.DBHelper.checkTrafficsExist(java.lang.String, java.lang.String, java.lang.String, boolean, long, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        com.taobao.accs.utl.ALog.d(com.taobao.accs.statistics.DBHelper.TAG, "db is full!", new java.lang.Object[0]);
        onUpgrade(r5, 0, 1);
        r4.curLogsCount = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void execSQL(java.lang.String r5, java.lang.Object[] r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.util.LinkedList<com.taobao.accs.statistics.DBHelper$SQLObject> r1 = r4.cachedSql     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            com.taobao.accs.statistics.DBHelper$SQLObject r2 = new com.taobao.accs.statistics.DBHelper$SQLObject     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r3 = 0
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r1.add(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.util.LinkedList<com.taobao.accs.statistics.DBHelper$SQLObject> r5 = r4.cachedSql     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r6 = 5
            if (r5 > r6) goto L18
            if (r7 == 0) goto L78
        L18:
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            if (r5 != 0) goto L20
            monitor-exit(r4)
            return
        L20:
            java.util.LinkedList<com.taobao.accs.statistics.DBHelper$SQLObject> r6 = r4.cachedSql     // Catch: java.lang.Throwable -> L65
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L65
            if (r6 <= 0) goto L61
            java.util.LinkedList<com.taobao.accs.statistics.DBHelper$SQLObject> r6 = r4.cachedSql     // Catch: java.lang.Throwable -> L65
            java.lang.Object r6 = r6.removeFirst()     // Catch: java.lang.Throwable -> L65
            com.taobao.accs.statistics.DBHelper$SQLObject r6 = (com.taobao.accs.statistics.DBHelper.SQLObject) r6     // Catch: java.lang.Throwable -> L65
            java.lang.Object[] r7 = r6.args     // Catch: java.lang.Throwable -> L65
            if (r7 == 0) goto L3a
            java.lang.String r1 = r6.sql     // Catch: java.lang.Throwable -> L65
            r5.execSQL(r1, r7)     // Catch: java.lang.Throwable -> L65
            goto L3f
        L3a:
            java.lang.String r7 = r6.sql     // Catch: java.lang.Throwable -> L65
            r5.execSQL(r7)     // Catch: java.lang.Throwable -> L65
        L3f:
            java.lang.String r6 = r6.sql     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = "INSERT"
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L65
            if (r6 == 0) goto L20
            int r6 = r4.curLogsCount     // Catch: java.lang.Throwable -> L65
            r7 = 1
            int r6 = r6 + r7
            r4.curLogsCount = r6     // Catch: java.lang.Throwable -> L65
            r1 = 4000(0xfa0, float:5.605E-42)
            if (r6 <= r1) goto L20
            java.lang.String r6 = "DBHelper"
            java.lang.String r1 = "db is full!"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L65
            com.taobao.accs.utl.ALog.d(r6, r1, r2)     // Catch: java.lang.Throwable -> L65
            r4.onUpgrade(r5, r0, r7)     // Catch: java.lang.Throwable -> L65
            r4.curLogsCount = r0     // Catch: java.lang.Throwable -> L65
        L61:
            r5.close()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            goto L78
        L65:
            r6 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            throw r6     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
        L6a:
            r5 = move-exception
            goto L7a
        L6c:
            r5 = move-exception
            java.lang.String r6 = "DBHelper"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6a
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6a
            com.taobao.accs.utl.ALog.d(r6, r5, r7)     // Catch: java.lang.Throwable -> L6a
        L78:
            monitor-exit(r4)
            return
        L7a:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.statistics.DBHelper.execSQL(java.lang.String, java.lang.Object[], boolean):void");
    }

    public static DBHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DBHelper.class) {
                if (sInstance == null) {
                    sInstance = new DBHelper(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return sInstance;
    }

    public void clearTraffics() {
        execSQL("DELETE FROM traffic", null, true);
    }

    public List<TrafficsMonitor.TrafficInfo> getTraffics(boolean z) {
        SQLiteDatabase writableDatabase;
        Cursor query;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (Exception e) {
                    e = e;
                }
                if (writableDatabase == null) {
                    return null;
                }
                if (z) {
                    query = writableDatabase.query("traffic", new String[]{"_id", "date", "host", "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.formatDay(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    query = writableDatabase.query("traffic", new String[]{"_id", "date", "host", "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                }
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                try {
                } catch (Exception e2) {
                    cursor = query;
                    e = e2;
                    ALog.w(TAG, e.toString(), new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(1);
                        String string2 = query.getString(2);
                        String string3 = query.getString(3);
                        String string4 = query.getString(4);
                        boolean booleanValue = Boolean.valueOf(query.getString(5)).booleanValue();
                        long j = query.getLong(6);
                        if (string4 != null && j > 0) {
                            arrayList.add(new TrafficsMonitor.TrafficInfo(string, string4, string3, booleanValue, string2, j));
                        }
                    } while (query.moveToNext());
                    query.close();
                    return arrayList;
                }
                query.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            Lock lock2 = lock;
            if (lock2.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            lock2.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public void onTraffics(String str, String str2, String str3, boolean z, long j, String str4) {
        if (checkTrafficsExist(str, str2, str3, z, j, str4)) {
            execSQL("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j), str4, str, str3, String.valueOf(z)}, true);
        } else {
            execSQL("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j)}, true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }
}
