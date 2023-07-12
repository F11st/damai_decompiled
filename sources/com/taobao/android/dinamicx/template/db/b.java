package com.taobao.android.dinamicx.template.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.db.DXFileDataBaseEntry;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import tb.jn1;
import tb.r10;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    private static final String b;
    private static final String c;
    private static final String[] d;
    private a a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public final class a {
        private C0290b a;
        private SQLiteDatabase b;

        a(Context context, String str) {
            this.b = null;
            C0290b c0290b = new C0290b(context, str);
            this.a = c0290b;
            try {
                this.b = c0290b.getWritableDatabase();
            } catch (Throwable th) {
                b.this.i("DinamicX_db", "DB_Open", e.DX_DB_OPEN_ERROR, th);
            }
        }

        void a() {
        }

        SQLiteDatabase b() {
            if (this.b == null) {
                try {
                    this.b = this.a.getReadableDatabase();
                } catch (Throwable th) {
                    b.this.i("DinamicX_db", "DB_Open", e.DX_DB_OPEN_ERROR, th);
                }
            }
            return this.b;
        }

        SQLiteDatabase c() {
            if (this.b == null) {
                try {
                    this.b = this.a.getWritableDatabase();
                } catch (Throwable th) {
                    b.this.i("DinamicX_db", "DB_Open", e.DX_DB_OPEN_ERROR, th);
                }
            }
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.template.db.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public final class C0290b extends SQLiteOpenHelper {
        C0290b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            long nanoTime = System.nanoTime();
            DXFileDataBaseEntry.o.a(sQLiteDatabase);
            b.this.l("DB_Create", System.nanoTime() - nanoTime);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DXFileDataBaseEntry.o.b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    static {
        String c2 = DXFileDataBaseEntry.o.c();
        b = c2;
        c = "insert or replace into " + c2 + jn1.BRACKET_START_STR + "biz_type,name,version," + DXFileDataBaseEntry.Columns.MAIN_PATH + "," + DXFileDataBaseEntry.Columns.STYLE_FILES + ",url) values(?,?,?,?,?,?)";
        d = new String[]{"biz_type", "name", "version", DXFileDataBaseEntry.Columns.MAIN_PATH, DXFileDataBaseEntry.Columns.STYLE_FILES, "url"};
    }

    public b(Context context, String str) {
        this.a = new a(context, str);
    }

    private void c(@NonNull SQLiteStatement sQLiteStatement, int i, String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindString(i, str);
        }
    }

    private String d(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(',');
                sb.append(entry.getValue());
                sb.append(',');
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        }
        return null;
    }

    private boolean f(@NonNull SQLiteStatement sQLiteStatement, @NonNull String str, @NonNull DXTemplateItem dXTemplateItem) {
        c(sQLiteStatement, 1, str);
        c(sQLiteStatement, 2, dXTemplateItem.name);
        sQLiteStatement.bindLong(3, dXTemplateItem.version);
        c(sQLiteStatement, 4, dXTemplateItem.packageInfo.mainFilePath);
        c(sQLiteStatement, 5, d(dXTemplateItem.packageInfo.subFilePathDict));
        c(sQLiteStatement, 6, dXTemplateItem.templateUrl);
        return sQLiteStatement.executeInsert() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, String str2, int i, Throwable th) {
        k(str, str2, null, i, th);
    }

    private void j(String str, String str2, DXTemplateItem dXTemplateItem, int i, String str3) {
        e eVar = new e(str);
        eVar.b = dXTemplateItem;
        e.a aVar = new e.a("DB", str2, i);
        aVar.e = str3;
        ArrayList arrayList = new ArrayList();
        eVar.c = arrayList;
        arrayList.add(aVar);
        DXAppMonitor.n(eVar);
    }

    private void k(String str, String str2, DXTemplateItem dXTemplateItem, int i, Throwable th) {
        j(str, str2, dXTemplateItem, i, ry.a(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, long j) {
        DXAppMonitor.s(2, "DinamicX_db", "DB", str, null, DXAppMonitor.g((float) j), j, true);
    }

    public void e(String str, DXTemplateItem dXTemplateItem) {
        if (TextUtils.isEmpty(str) || !r10.b(dXTemplateItem)) {
            return;
        }
        try {
            String[] strArr = {str, dXTemplateItem.name, String.valueOf(dXTemplateItem.version)};
            SQLiteDatabase c2 = this.a.c();
            if (c2 != null) {
                c2.delete(b, "biz_type=? AND name=? AND version=?", strArr);
                this.a.a();
            }
        } catch (Throwable th) {
            k(str, "DB_Delete", dXTemplateItem, e.DX_DB_DELETE_ERROR, th);
        }
    }

    public LinkedList<DXTemplateItem> g(String str, DXTemplateItem dXTemplateItem) {
        Throwable th;
        SQLiteDatabase b2;
        String[] split;
        int length;
        LinkedList<DXTemplateItem> linkedList = new LinkedList<>();
        String[] strArr = {str, dXTemplateItem.name};
        Cursor cursor = null;
        try {
            b2 = this.a.b();
        } catch (Throwable th2) {
            th = th2;
        }
        if (b2 == null) {
            j(str, "DB_Query", dXTemplateItem, e.DX_DB_QUERY_ERROR, "SQLiteDatabase = null");
            this.a.a();
            return linkedList;
        }
        Cursor query = b2.query(b, d, "biz_type=? AND name=?", strArr, null, null, "version desc");
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    DXTemplateItem dXTemplateItem2 = new DXTemplateItem();
                    dXTemplateItem2.packageInfo = new DXTemplatePackageInfo();
                    dXTemplateItem2.name = dXTemplateItem.name;
                    dXTemplateItem2.version = query.getLong(2);
                    dXTemplateItem2.packageInfo.mainFilePath = query.getString(3);
                    String string = query.getString(4);
                    if (!TextUtils.isEmpty(string) && (length = (split = string.split(",")).length) > 1 && length % 2 == 0) {
                        dXTemplateItem2.packageInfo.subFilePathDict = new HashMap();
                        for (int i = 0; i < length; i += 2) {
                            dXTemplateItem2.packageInfo.subFilePathDict.put(split[i], split[i + 1]);
                        }
                    }
                    dXTemplateItem2.templateUrl = query.getString(5);
                    linkedList.addFirst(dXTemplateItem2);
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    try {
                        k(str, "DB_Query", dXTemplateItem, e.DX_DB_QUERY_ERROR, th);
                        return linkedList;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.a.a();
                    }
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return linkedList;
    }

    public void h(String str, DXTemplateItem dXTemplateItem) {
        DXTemplatePackageInfo dXTemplatePackageInfo;
        if (TextUtils.isEmpty(str) || dXTemplateItem == null || (dXTemplatePackageInfo = dXTemplateItem.packageInfo) == null || TextUtils.isEmpty(dXTemplatePackageInfo.mainFilePath)) {
            return;
        }
        SQLiteDatabase c2 = this.a.c();
        if (c2 != null && c2.isOpen()) {
            try {
                f(c2.compileStatement(c), str, dXTemplateItem);
            } catch (Throwable th) {
                k(str, "DB_Store", dXTemplateItem, e.DX_DB_STORE_ERROR, th);
            }
        } else {
            j(str, "DB_Store", dXTemplateItem, e.DX_DB_STORE_ERROR, "SQLiteDatabase = null");
        }
        this.a.a();
    }
}
