package com.taobao.weex.appfram.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.utils.WXLogUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends SQLiteOpenHelper {
    static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private long a;
    private Context b;
    private SQLiteDatabase c;

    public a(Context context) {
        super(context, "WXStorage", (SQLiteDatabase.CursorFactory) null, 2);
        this.a = 52428800L;
        this.b = context;
    }

    private void b(@NonNull SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'default_wx_storage'", null);
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor == null) {
                    return;
                }
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.close();
                return;
            }
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS default_wx_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL,persistent INTEGER DEFAULT 0)");
            if (cursor == null) {
                return;
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private boolean c() {
        a();
        return this.b.deleteDatabase("WXStorage");
    }

    public synchronized void a() {
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.c.close();
            this.c = null;
        }
    }

    synchronized void e() {
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            for (int i = 0; i < 2; i++) {
                if (i > 0) {
                    try {
                        c();
                    } catch (SQLiteException e) {
                        e.printStackTrace();
                        try {
                            Thread.sleep(30L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                this.c = getWritableDatabase();
            }
            SQLiteDatabase sQLiteDatabase2 = this.c;
            if (sQLiteDatabase2 == null) {
                return;
            }
            b(sQLiteDatabase2);
            this.c.setMaximumSize(this.a);
        }
    }

    @Nullable
    public SQLiteDatabase getDatabase() {
        e();
        return this.c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS default_wx_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL,persistent INTEGER DEFAULT 0)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            if (i2 == 2) {
                boolean z = true;
                if (i == 1) {
                    WXLogUtils.d("weex_storage", "storage is updating from version " + i + " to version " + i2);
                    try {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            sQLiteDatabase.beginTransaction();
                            WXLogUtils.d("weex_storage", "exec sql : ALTER TABLE default_wx_storage ADD COLUMN timestamp TEXT;");
                            sQLiteDatabase.execSQL("ALTER TABLE default_wx_storage ADD COLUMN timestamp TEXT;");
                            WXLogUtils.d("weex_storage", "exec sql : ALTER TABLE default_wx_storage ADD COLUMN persistent INTEGER;");
                            sQLiteDatabase.execSQL("ALTER TABLE default_wx_storage ADD COLUMN persistent INTEGER;");
                            String str = "UPDATE default_wx_storage SET timestamp = '" + d.format(new Date()) + "' , persistent = 0";
                            WXLogUtils.d("weex_storage", "exec sql : " + str);
                            sQLiteDatabase.execSQL(str);
                            sQLiteDatabase.setTransactionSuccessful();
                            WXLogUtils.d("weex_storage", "storage updated success (" + (System.currentTimeMillis() - currentTimeMillis) + "ms)");
                        } catch (Exception e) {
                            WXLogUtils.d("weex_storage", "storage updated failed from version " + i + " to version " + i2 + "," + e.getMessage());
                            z = false;
                        }
                        if (z) {
                            return;
                        }
                        WXLogUtils.d("weex_storage", "storage is rollback,all data will be removed");
                        c();
                        onCreate(sQLiteDatabase);
                        return;
                    } finally {
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
            c();
            onCreate(sQLiteDatabase);
        }
    }
}
