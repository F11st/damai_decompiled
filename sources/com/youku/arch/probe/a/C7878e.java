package com.youku.arch.probe.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.probe.a.e */
/* loaded from: classes2.dex */
public class C7878e extends SQLiteOpenHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416710746")) {
            ipChange.ipc$dispatch("-1416710746", new Object[]{this, sQLiteDatabase});
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS speed_history_table (ID INTEGER PRIMARY KEY,mac TEXT,time INTEGER,start_time INTEGER,ip TEXT,speedArray TEXT,s10 REAL,s50 REAL,s90 REAL,timeArray TEXT,isNTK INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS general_speed_table (mac TEXT PRIMARY KEY,time INTERER,speed TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372887227")) {
            ipChange.ipc$dispatch("-1372887227", new Object[]{this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS speed_history_table");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS general_speed_table");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815778818")) {
            ipChange.ipc$dispatch("-815778818", new Object[]{this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS speed_history_table");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS general_speed_table");
        onCreate(sQLiteDatabase);
    }
}
