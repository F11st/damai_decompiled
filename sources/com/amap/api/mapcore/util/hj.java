package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hj extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c;
    private hf a;

    public hj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, hf hfVar) {
        super(context, str, cursorFactory, i);
        this.a = hfVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i, i2);
    }
}
