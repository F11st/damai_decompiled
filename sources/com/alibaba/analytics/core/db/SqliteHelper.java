package com.alibaba.analytics.core.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.utils.Logger;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SqliteHelper extends SQLiteOpenHelper {
    private static boolean e;
    private static DatabaseErrorHandler f = new a();
    private AtomicInteger a;
    private SQLiteDatabase b;
    private DelayCloseDbTask c;
    private Future<?> d;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class DelayCloseDbTask implements Runnable {
        DelayCloseDbTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (SqliteHelper.this) {
                if (SqliteHelper.this.a.get() == 0 && SqliteHelper.this.b != null) {
                    SqliteHelper.this.b.close();
                    SqliteHelper.this.b = null;
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    static class a implements DatabaseErrorHandler {
        a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            Logger.v("SqliteHelper", "DatabaseErrorHandler onCorruption");
            boolean unused = SqliteHelper.e = true;
        }
    }

    public SqliteHelper(Context context, String str) {
        super(context, str, null, 2, f);
        this.a = new AtomicInteger();
        this.c = new DelayCloseDbTask();
    }

    public void e(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void f(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            if (this.a.decrementAndGet() == 0) {
                Future<?> future = this.d;
                if (future != null) {
                    future.cancel(false);
                }
                this.d = hl2.c().d(null, this.c, 30000L);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            if (this.b == null) {
                if (e) {
                    return null;
                }
                this.b = super.getWritableDatabase();
            }
            this.a.incrementAndGet();
            return this.b;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable unused) {
        }
        e(cursor);
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
