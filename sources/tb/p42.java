package tb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class p42 extends SQLiteOpenHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C9544a Companion = new C9544a(null);
    @NotNull
    public static final String Lock = "dblock";
    private final String a;

    /* compiled from: Taobao */
    /* renamed from: tb.p42$a */
    /* loaded from: classes7.dex */
    public static final class C9544a {
        private C9544a() {
        }

        public /* synthetic */ C9544a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p42(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i, @NotNull String str2) {
        super(context, str, cursorFactory, i);
        b41.i(str2, "mTableName");
        this.a = str2;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            b41.h(writableDatabase, "sqLiteDatabase");
            onCreate(writableDatabase);
            writableDatabase.close();
        } catch (Exception e) {
            rq.b("SQLiteHelper", e);
        }
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791828227")) {
            ipChange.ipc$dispatch("1791828227", new Object[]{this});
            return;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.a);
        } catch (Exception e) {
            rq.b("SQLiteHelper", e);
        }
    }

    public final void c(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495839849")) {
            ipChange.ipc$dispatch("1495839849", new Object[]{this, str});
            return;
        }
        b41.i(str, "key");
        synchronized (Lock) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.delete(this.a, "key=?", new String[]{str});
                writableDatabase.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final af d(@NotNull String str) {
        Cursor query;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1924096009")) {
            return (af) ipChange.ipc$dispatch("1924096009", new Object[]{this, str});
        }
        b41.i(str, "key");
        synchronized (Lock) {
            Cursor cursor = null;
            try {
                try {
                    query = getReadableDatabase().query(this.a, new String[]{"value", "cacheTime"}, "key=?", new String[]{str}, null, null, null);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        if ((string == null || string.length() == 0) ? true : true) {
                            query.close();
                            return null;
                        }
                        af afVar = new af(str, string);
                        afVar.f(query.getLong(1));
                        query.close();
                        return afVar;
                    }
                    query.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void e(@Nullable String str, @Nullable String str2) {
        SQLiteDatabase writableDatabase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491110529")) {
            ipChange.ipc$dispatch("1491110529", new Object[]{this, str, str2});
            return;
        }
        synchronized (Lock) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("key", str);
                    contentValues.put("value", str2);
                    contentValues.put("cacheTime", Long.valueOf(System.currentTimeMillis()));
                    writableDatabase.insert(this.a, null, contentValues);
                    writableDatabase.close();
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void f(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886643345")) {
            ipChange.ipc$dispatch("1886643345", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "key");
        synchronized (Lock) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", str2);
                contentValues.put("cacheTime", Long.valueOf(System.currentTimeMillis()));
                writableDatabase.update(this.a, contentValues, "key=?", new String[]{str});
                writableDatabase.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(@Nullable String str, @Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906062475")) {
            ipChange.ipc$dispatch("-906062475", new Object[]{this, str, l});
        } else if (str == null || l == null) {
        } else {
            synchronized (Lock) {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("cacheTime", l);
                    writableDatabase.update(this.a, contentValues, "key=?", new String[]{str});
                    writableDatabase.close();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891950152")) {
            ipChange.ipc$dispatch("-1891950152", new Object[]{this, sQLiteDatabase});
            return;
        }
        b41.i(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL("create table if not exists " + this.a + jn1.BRACKET_START_STR + "key varchar(128) primary key,value varchar(4096),cacheTime long)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834251948")) {
            ipChange.ipc$dispatch("1834251948", new Object[]{this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(sQLiteDatabase, "db");
        a();
        onCreate(sQLiteDatabase);
    }
}
