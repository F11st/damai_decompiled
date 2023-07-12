package tb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.db.SqliteHelper;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class pq {
    private SqliteHelper b;
    private String c;
    private HashMap<String, Boolean> a = new HashMap<>();
    private HashMap<Class<?>, List<Field>> d = new HashMap<>();
    private HashMap<Field, String> e = new HashMap<>();
    private HashMap<Class<?>, String> f = new HashMap<>();

    public pq(Context context, String str) {
        this.b = new SqliteHelper(context, str);
        this.c = str;
    }

    private SQLiteDatabase a(Class<? extends ve0> cls, String str) {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        Boolean bool = Boolean.TRUE;
        if (this.a.get(str) == null || !this.a.get(str).booleanValue()) {
            bool = Boolean.FALSE;
        }
        if (cls != null && !bool.booleanValue() && writableDatabase != null) {
            List<Field> j = j(cls);
            ArrayList<Field> arrayList = new ArrayList<>();
            String str2 = " SELECT * FROM " + str + " LIMIT 0";
            int i = 0;
            if (j != null) {
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery(str2, null);
                } catch (Exception unused) {
                    Logger.f("DBMgr", "has not create table", str);
                }
                int i2 = cursor != null ? 0 : 1;
                while (i < j.size()) {
                    Field field = j.get(i);
                    if (!"_id".equalsIgnoreCase(k(field)) && (i2 != 0 || (cursor != null && cursor.getColumnIndex(k(field)) == -1))) {
                        arrayList.add(field);
                    }
                    i++;
                }
                this.b.e(cursor);
                i = i2;
            }
            if (i != 0) {
                e(writableDatabase, str, arrayList);
            } else if (arrayList.size() > 0) {
                u(writableDatabase, str, arrayList);
            }
            this.a.put(str, Boolean.TRUE);
        }
        return writableDatabase;
    }

    private void e(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                Class<?> type = arrayList.get(i).getType();
                sb.append(" ");
                sb.append(k(arrayList.get(i)));
                sb.append(" ");
                sb.append(o(type));
                sb.append(" ");
                sb.append(n(type));
            }
        }
        sb.append(" );");
        String sb2 = sb.toString();
        Logger.f("DBMgr", "excute sql:", sb2);
        try {
            sQLiteDatabase.execSQL(sb2);
        } catch (Exception e) {
            Logger.v("DBMgr", "create db error", e);
        }
    }

    private List<Field> j(Class cls) {
        Field[] declaredFields;
        if (this.d.containsKey(cls)) {
            return this.d.get(cls);
        }
        List<Field> emptyList = Collections.emptyList();
        if (cls != null) {
            emptyList = new ArrayList<>();
            for (Field field : cls.getDeclaredFields()) {
                if (field.getAnnotation(Ingore.class) == null && !field.isSynthetic()) {
                    field.setAccessible(true);
                    emptyList.add(field);
                }
            }
            if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
                emptyList.addAll(j(cls.getSuperclass()));
            }
            this.d.put(cls, emptyList);
        }
        return emptyList;
    }

    private String k(Field field) {
        String name;
        if (this.e.containsKey(field)) {
            return this.e.get(field);
        }
        Column column = (Column) field.getAnnotation(Column.class);
        if (column != null && !TextUtils.isEmpty(column.value())) {
            name = column.value();
        } else {
            name = field.getName();
        }
        this.e.put(field, name);
        return name;
    }

    private String n(Class cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "default 0" : "default \"\"";
    }

    private String o(Class<?> cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "INTEGER" : "TEXT";
    }

    private void u(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        String str2 = "ALTER TABLE " + str + " ADD COLUMN ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(str2);
            sb.append(k(arrayList.get(i)));
            sb.append(" ");
            sb.append(o(arrayList.get(i).getType()));
            String sb2 = sb.toString();
            try {
                sQLiteDatabase.execSQL(sb2);
            } catch (Exception e) {
                Logger.v("DBMgr", "update db error...", e);
            }
            sb.delete(0, sb2.length());
            Logger.f("DBMgr", null, "excute sql:", sb2);
        }
    }

    public synchronized void b(Class<? extends ve0> cls) {
        if (cls == null) {
            return;
        }
        c(p(cls));
    }

    public synchronized void c(String str) {
        if (str == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete(str, null, null);
                this.b.f(writableDatabase);
            }
        } catch (Exception e) {
            Logger.h("delete db data", e, new Object[0]);
        }
    }

    public synchronized int d(Class<? extends ve0> cls) {
        int i = 0;
        if (cls == null) {
            return 0;
        }
        String p = p(cls);
        SQLiteDatabase a = a(cls, p);
        if (a != null) {
            Cursor rawQuery = a.rawQuery("SELECT count(*) FROM " + p, null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            this.b.e(rawQuery);
            this.b.f(a);
        } else {
            Logger.f("DBMgr", "[count] db is null. tableName", p);
        }
        return i;
    }

    public synchronized int f(Class<? extends ve0> cls, String str, String[] strArr) {
        int i = 0;
        if (cls != null) {
            SQLiteDatabase a = a(cls, p(cls));
            if (a == null) {
                return 0;
            }
            i = a.delete(p(cls), str, strArr);
            this.b.f(a);
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized int g(List<? extends ve0> list) {
        if (list != null) {
            if (list.size() != 0) {
                String p = p(list.get(0).getClass());
                SQLiteDatabase a = a(list.get(0).getClass(), p);
                if (a == null) {
                    Logger.f("DBMgr", "[delete] db is null. tableName", p);
                    return 0;
                }
                a.beginTransaction();
                StringBuffer stringBuffer = new StringBuffer();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    if (arrayList.size() > 0) {
                        stringBuffer.append(" OR ");
                    }
                    stringBuffer.append("_id=?");
                    arrayList.add(String.valueOf(list.get(i)._id));
                    if (arrayList.size() == 20) {
                        String[] strArr = new String[arrayList.size()];
                        arrayList.toArray(strArr);
                        long delete = a.delete(p, stringBuffer.toString(), strArr);
                        if (delete == arrayList.size()) {
                            Logger.f("DBMgr", "delete success. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete));
                        } else {
                            Logger.f("DBMgr", "delete fail. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete));
                        }
                        stringBuffer.delete(0, stringBuffer.length());
                        arrayList.clear();
                    }
                }
                if (arrayList.size() > 0) {
                    String[] strArr2 = new String[arrayList.size()];
                    arrayList.toArray(strArr2);
                    long delete2 = a.delete(p, stringBuffer.toString(), strArr2);
                    if (delete2 == arrayList.size()) {
                        Logger.f("DBMgr", "delete success. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete2));
                    } else {
                        Logger.f("DBMgr", "delete fail. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete2));
                    }
                }
                try {
                    a.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                try {
                    a.endTransaction();
                } catch (Throwable unused2) {
                }
                this.b.f(a);
                return list.size();
            }
        }
        return 0;
    }

    public int h(ve0 ve0Var) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(ve0Var);
        return g(arrayList);
    }

    public synchronized List<? extends ve0> i(Class<? extends ve0> cls, String str, String str2, int i) {
        List<? extends ve0> list;
        Object valueOf;
        List<? extends ve0> list2 = Collections.EMPTY_LIST;
        if (cls == null) {
            return list2;
        }
        String p = p(cls);
        SQLiteDatabase a = a(cls, p);
        if (a == null) {
            Logger.f("DBMgr", "[find] db is null. tableName", p);
            return list2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(p);
        sb.append(TextUtils.isEmpty(str) ? "" : " WHERE " + str);
        sb.append(TextUtils.isEmpty(str2) ? "" : " ORDER BY " + str2);
        sb.append(i <= 0 ? "" : " LIMIT " + i);
        String sb2 = sb.toString();
        Logger.r("DBMgr", kh1.CACHE_SQL, sb2);
        Cursor cursor = null;
        try {
            cursor = a.rawQuery(sb2, null);
            list = new ArrayList<>();
        } catch (Throwable th) {
            th = th;
        }
        try {
            List<Field> j = j(cls);
            while (cursor != null) {
                if (!cursor.moveToNext()) {
                    break;
                }
                ve0 newInstance = cls.newInstance();
                for (int i2 = 0; i2 < j.size(); i2++) {
                    Field field = j.get(i2);
                    Class<?> type = field.getType();
                    String k = k(field);
                    int columnIndex = cursor.getColumnIndex(k);
                    if (columnIndex != -1) {
                        try {
                            if (type != Long.class && type != Long.TYPE) {
                                if (type != Integer.class && type != Integer.TYPE) {
                                    if (type != Double.TYPE && type != Double.class) {
                                        valueOf = cursor.getString(columnIndex);
                                        field.set(newInstance, valueOf);
                                    }
                                    valueOf = Double.valueOf(cursor.getDouble(columnIndex));
                                    field.set(newInstance, valueOf);
                                }
                                valueOf = Integer.valueOf(cursor.getInt(columnIndex));
                                field.set(newInstance, valueOf);
                            }
                            field.set(newInstance, valueOf);
                        } catch (Exception e) {
                            try {
                                if ((e instanceof IllegalArgumentException) && (valueOf instanceof String)) {
                                    field.set(newInstance, Boolean.valueOf((String) valueOf));
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        valueOf = Long.valueOf(cursor.getLong(columnIndex));
                    } else {
                        Logger.v("DBMgr", "can not get field", k);
                    }
                }
                list.add(newInstance);
            }
            this.b.e(cursor);
            this.b.f(a);
        } catch (Throwable th2) {
            th = th2;
            list2 = list;
            Logger.v("DBMgr", "[get]", th);
            this.b.e(cursor);
            this.b.f(a);
            list = list2;
            return list;
        }
        return list;
    }

    public SQLiteDatabase l() {
        return this.b.getWritableDatabase();
    }

    public double m() {
        File databasePath;
        Context j = Variables.n().j();
        if (j == null || (databasePath = j.getDatabasePath("ut.db")) == null) {
            return 0.0d;
        }
        return (databasePath.length() / 1024.0d) / 1024.0d;
    }

    public String p(Class<?> cls) {
        String replace;
        if (cls == null) {
            Logger.i("DBMgr", "cls is null");
            return null;
        } else if (this.f.containsKey(cls)) {
            return this.f.get(cls);
        } else {
            TableName tableName = (TableName) cls.getAnnotation(TableName.class);
            if (tableName != null && !TextUtils.isEmpty(tableName.value())) {
                replace = tableName.value();
            } else {
                replace = cls.getName().replace(".", JSMethod.NOT_SET);
            }
            this.f.put(cls, replace);
            return replace;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void q(List<? extends ve0> list) {
        SqliteHelper sqliteHelper;
        if (list != null) {
            if (list.size() != 0) {
                String p = p(list.get(0).getClass());
                SQLiteDatabase a = a(list.get(0).getClass(), p);
                if (a == null) {
                    Logger.v("DBMgr", "[insert]can not get available db. tableName", p);
                    return;
                }
                Logger.f("DBMgr", "entities.size", Integer.valueOf(list.size()));
                try {
                    List<Field> j = j(list.get(0).getClass());
                    ContentValues contentValues = new ContentValues();
                    a.beginTransaction();
                    for (int i = 0; i < list.size(); i++) {
                        ve0 ve0Var = list.get(i);
                        for (int i2 = 0; i2 < j.size(); i2++) {
                            Field field = j.get(i2);
                            String k = k(field);
                            try {
                                try {
                                    Object obj = field.get(ve0Var);
                                    if (obj != null) {
                                        contentValues.put(k, obj + "");
                                    } else {
                                        contentValues.put(k, "");
                                    }
                                } catch (Exception unused) {
                                    try {
                                        a.endTransaction();
                                    } catch (Exception unused2) {
                                    }
                                    sqliteHelper = this.b;
                                    sqliteHelper.f(a);
                                }
                            } catch (Exception e) {
                                Logger.v("DBMgr", "get field failed", e);
                            }
                        }
                        long j2 = ve0Var._id;
                        if (j2 == -1) {
                            contentValues.remove("_id");
                            long insert = a.insert(p, null, contentValues);
                            if (insert != -1) {
                                ve0Var._id = insert;
                            }
                        } else {
                            a.update(p, contentValues, "_id=?", new String[]{String.valueOf(j2)});
                        }
                        contentValues.clear();
                    }
                    try {
                        a.setTransactionSuccessful();
                    } catch (Exception unused3) {
                    }
                    try {
                        a.endTransaction();
                    } catch (Exception unused4) {
                    }
                    sqliteHelper = this.b;
                } catch (Throwable unused5) {
                    a.setTransactionSuccessful();
                    a.endTransaction();
                    sqliteHelper = this.b;
                    sqliteHelper.f(a);
                }
                sqliteHelper.f(a);
            }
        }
    }

    public void r(ve0 ve0Var) {
        if (ve0Var != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(ve0Var);
            q(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void s(List<? extends ve0> list) {
        SqliteHelper sqliteHelper;
        if (list != null) {
            if (list.size() != 0) {
                String p = p(list.get(0).getClass());
                SQLiteDatabase a = a(list.get(0).getClass(), p);
                if (a == null) {
                    Logger.f("DBMgr", "[update] db is null. tableName", p);
                    return;
                }
                try {
                    try {
                        a.beginTransaction();
                        List<Field> j = j(list.get(0).getClass());
                        for (int i = 0; i < list.size(); i++) {
                            ContentValues contentValues = new ContentValues();
                            for (int i2 = 0; i2 < j.size(); i2++) {
                                Field field = j.get(i2);
                                try {
                                    field.setAccessible(true);
                                    String k = k(field);
                                    contentValues.put(k, field.get(list.get(i)) + "");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            a.update(p, contentValues, "_id=?", new String[]{list.get(i)._id + ""});
                        }
                        try {
                            a.setTransactionSuccessful();
                        } catch (Exception unused) {
                        }
                        try {
                            a.endTransaction();
                        } catch (Exception unused2) {
                        }
                        sqliteHelper = this.b;
                    } catch (Exception unused3) {
                        try {
                            a.endTransaction();
                        } catch (Exception unused4) {
                        }
                        sqliteHelper = this.b;
                        sqliteHelper.f(a);
                    }
                } catch (Exception unused5) {
                    a.setTransactionSuccessful();
                    a.endTransaction();
                    sqliteHelper = this.b;
                    sqliteHelper.f(a);
                }
                sqliteHelper.f(a);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void t(List<? extends ve0> list) {
        SqliteHelper sqliteHelper;
        if (list != null) {
            if (list.size() != 0) {
                String p = p(list.get(0).getClass());
                SQLiteDatabase a = a(list.get(0).getClass(), p);
                if (a == null) {
                    Logger.f("DBMgr", "[updateLogPriority] db is null. tableName", p);
                    return;
                }
                try {
                    try {
                        a.beginTransaction();
                        List<Field> j = j(list.get(0).getClass());
                        for (int i = 0; i < list.size(); i++) {
                            ContentValues contentValues = new ContentValues();
                            for (int i2 = 0; i2 < j.size(); i2++) {
                                Field field = j.get(i2);
                                String k = k(field);
                                if (k != null && k.equalsIgnoreCase("priority")) {
                                    try {
                                        field.setAccessible(true);
                                        contentValues.put(k, field.get(list.get(i)) + "");
                                        a.update(p, contentValues, "_id=?", new String[]{list.get(i)._id + ""});
                                        break;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        try {
                            a.setTransactionSuccessful();
                        } catch (Exception unused) {
                        }
                        try {
                            a.endTransaction();
                        } catch (Exception unused2) {
                        }
                        sqliteHelper = this.b;
                    } catch (Exception unused3) {
                        a.setTransactionSuccessful();
                        try {
                            a.endTransaction();
                        } catch (Exception unused4) {
                        }
                        sqliteHelper = this.b;
                        sqliteHelper.f(a);
                    }
                } catch (Exception unused5) {
                    a.endTransaction();
                    sqliteHelper = this.b;
                    sqliteHelper.f(a);
                }
                sqliteHelper.f(a);
            }
        }
    }
}
