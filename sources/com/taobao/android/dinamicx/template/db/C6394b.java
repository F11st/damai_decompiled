package com.taobao.android.dinamicx.template.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.C6368e;
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
/* renamed from: com.taobao.android.dinamicx.template.db.b */
/* loaded from: classes12.dex */
public class C6394b {
    private static final String b;
    private static final String c;
    private static final String[] d;
    private C6395a a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.template.db.b$a */
    /* loaded from: classes12.dex */
    public final class C6395a {
        private C6396b a;
        private SQLiteDatabase b;

        C6395a(Context context, String str) {
            this.b = null;
            C6396b c6396b = new C6396b(context, str);
            this.a = c6396b;
            try {
                this.b = c6396b.getWritableDatabase();
            } catch (Throwable th) {
                C6394b.this.i("DinamicX_db", "DB_Open", C6368e.DX_DB_OPEN_ERROR, th);
            }
        }

        void a() {
        }

        SQLiteDatabase b() {
            if (this.b == null) {
                try {
                    this.b = this.a.getReadableDatabase();
                } catch (Throwable th) {
                    C6394b.this.i("DinamicX_db", "DB_Open", C6368e.DX_DB_OPEN_ERROR, th);
                }
            }
            return this.b;
        }

        SQLiteDatabase c() {
            if (this.b == null) {
                try {
                    this.b = this.a.getWritableDatabase();
                } catch (Throwable th) {
                    C6394b.this.i("DinamicX_db", "DB_Open", C6368e.DX_DB_OPEN_ERROR, th);
                }
            }
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.template.db.b$b */
    /* loaded from: classes12.dex */
    public final class C6396b extends SQLiteOpenHelper {
        C6396b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            long nanoTime = System.nanoTime();
            DXFileDataBaseEntry.o.a(sQLiteDatabase);
            C6394b.this.l("DB_Create", System.nanoTime() - nanoTime);
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

    public C6394b(Context context, String str) {
        this.a = new C6395a(context, str);
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
        C6368e c6368e = new C6368e(str);
        c6368e.b = dXTemplateItem;
        C6368e.C6369a c6369a = new C6368e.C6369a("DB", str2, i);
        c6369a.e = str3;
        ArrayList arrayList = new ArrayList();
        c6368e.c = arrayList;
        arrayList.add(c6369a);
        DXAppMonitor.n(c6368e);
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
            k(str, "DB_Delete", dXTemplateItem, C6368e.DX_DB_DELETE_ERROR, th);
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
            j(str, "DB_Query", dXTemplateItem, C6368e.DX_DB_QUERY_ERROR, "SQLiteDatabase = null");
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
                        k(str, "DB_Query", dXTemplateItem, C6368e.DX_DB_QUERY_ERROR, th);
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
                k(str, "DB_Store", dXTemplateItem, C6368e.DX_DB_STORE_ERROR, th);
            }
        } else {
            j(str, "DB_Store", dXTemplateItem, C6368e.DX_DB_STORE_ERROR, "SQLiteDatabase = null");
        }
        this.a.a();
    }
}
