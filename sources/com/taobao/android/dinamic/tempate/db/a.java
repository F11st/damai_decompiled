package com.taobao.android.dinamic.tempate.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.android.dinamic.tempate.db.Entry;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import tb.b90;
import tb.kw2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class a {
    public static final int TYPE_BLOB = 7;
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_STRING = 0;
    private static final String[] e = {"TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "REAL", "REAL", "NONE"};
    private final String a;
    private final C0285a[] b;
    private final String[] c;
    private final boolean d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.db.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C0285a {
        public final String a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final String e;
        public final Field f;
        public final int g;

        public C0285a(String str, int i, boolean z, boolean z2, String str2, Field field, int i2) {
            this.a = str.toLowerCase();
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = str2;
            this.f = field;
            this.g = i2;
            field.setAccessible(true);
        }

        public boolean a() {
            return "_id".equals(this.a);
        }
    }

    public a(Class<? extends Entry> cls) {
        C0285a[] k = k(cls);
        this.a = l(cls);
        this.b = k;
        boolean z = false;
        String[] strArr = new String[0];
        if (k != null) {
            strArr = new String[k.length];
            boolean z2 = false;
            for (int i = 0; i != k.length; i++) {
                C0285a c0285a = k[i];
                strArr[i] = c0285a.a;
                if (c0285a.d) {
                    z2 = true;
                }
            }
            z = z2;
        }
        this.c = strArr;
        this.d = z;
    }

    private long g(SQLiteDatabase sQLiteDatabase, String str, String str2, HashMap<String, Object> hashMap) {
        sQLiteDatabase.acquireReference();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT");
            sb.append(" OR REPLACE ");
            sb.append(" INTO ");
            sb.append(str);
            sb.append('(');
            Object[] objArr = null;
            int size = (hashMap == null || hashMap.isEmpty()) ? 0 : hashMap.size();
            if (size > 0) {
                objArr = new Object[size];
                int i = 0;
                for (String str3 : hashMap.keySet()) {
                    sb.append(i > 0 ? "," : "");
                    sb.append(str3);
                    objArr[i] = hashMap.get(str3);
                    i++;
                }
                sb.append(')');
                sb.append(" VALUES (");
                int i2 = 0;
                while (i2 < size) {
                    sb.append(i2 > 0 ? ",?" : "?");
                    i2++;
                }
            } else {
                sb.append(str2 + ") VALUES (NULL");
            }
            sb.append(')');
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(sb.toString());
            if (size > 0) {
                int length = objArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (objArr[i3] instanceof Long) {
                        compileStatement.bindLong(i3 + 1, ((Long) objArr[i3]).longValue());
                    } else if (objArr[i3] instanceof String) {
                        compileStatement.bindString(i3 + 1, (String) objArr[i3]);
                    }
                }
            }
            long executeInsert = compileStatement.executeInsert();
            compileStatement.close();
            return executeInsert;
        } finally {
            sQLiteDatabase.releaseReference();
        }
    }

    private void h(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(str);
    }

    private void j(Class<?> cls, ArrayList<C0285a> arrayList) {
        int i;
        Field[] declaredFields = cls.getDeclaredFields();
        for (int i2 = 0; i2 != declaredFields.length; i2++) {
            Field field = declaredFields[i2];
            Entry.Column column = (Entry.Column) field.getAnnotation(Entry.Column.class);
            if (column != null) {
                Class<?> type = field.getType();
                if (type == String.class) {
                    i = 0;
                } else if (type == Boolean.TYPE) {
                    i = 1;
                } else if (type == Short.TYPE) {
                    i = 2;
                } else if (type == Integer.TYPE) {
                    i = 3;
                } else if (type == Long.TYPE) {
                    i = 4;
                } else if (type == Float.TYPE) {
                    i = 5;
                } else if (type == Double.TYPE) {
                    i = 6;
                } else if (type != byte[].class) {
                    throw new IllegalArgumentException("Unsupported field type for column: " + type.getName());
                } else {
                    i = 7;
                }
                arrayList.add(new C0285a(column.value(), i, column.indexed(), column.fullText(), column.defaultValue(), field, arrayList.size()));
            }
        }
    }

    private C0285a[] k(Class<?> cls) {
        ArrayList<C0285a> arrayList = new ArrayList<>();
        while (cls != null) {
            j(cls, arrayList);
            cls = cls.getSuperclass();
        }
        C0285a[] c0285aArr = new C0285a[arrayList.size()];
        arrayList.toArray(c0285aArr);
        return c0285aArr;
    }

    private String l(Class<?> cls) {
        Entry.Table table = (Entry.Table) cls.getAnnotation(Entry.Table.class);
        if (table == null) {
            return null;
        }
        return table.value();
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        C0285a[] c0285aArr;
        C0285a[] c0285aArr2;
        C0285a[] c0285aArr3;
        C0285a[] c0285aArr4;
        C0285a[] c0285aArr5;
        String str = this.a;
        kw2.a(str != null);
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(str);
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
        for (C0285a c0285a : this.b) {
            if (!c0285a.a()) {
                sb.append(',');
                sb.append(c0285a.a);
                sb.append(' ');
                sb.append(e[c0285a.b]);
                if (!TextUtils.isEmpty(c0285a.e)) {
                    sb.append(" DEFAULT ");
                    sb.append(c0285a.e);
                }
            }
        }
        sb.append(");");
        h(sQLiteDatabase, sb.toString());
        sb.setLength(0);
        for (C0285a c0285a2 : this.b) {
            if (c0285a2.c) {
                sb.append("CREATE INDEX ");
                sb.append(str);
                sb.append("_index_");
                sb.append(c0285a2.a);
                sb.append(" ON ");
                sb.append(str);
                sb.append(" (");
                sb.append(c0285a2.a);
                sb.append(");");
                h(sQLiteDatabase, sb.toString());
                sb.setLength(0);
            }
        }
        if (this.d) {
            String str2 = str + "_fulltext";
            sb.append("CREATE VIRTUAL TABLE ");
            sb.append(str2);
            sb.append(" USING FTS3 (_id INTEGER PRIMARY KEY");
            for (C0285a c0285a3 : this.b) {
                if (c0285a3.d) {
                    String str3 = c0285a3.a;
                    sb.append(',');
                    sb.append(str3);
                    sb.append(AVFSCacheConstants.TEXT_TYPE);
                }
            }
            sb.append(");");
            h(sQLiteDatabase, sb.toString());
            sb.setLength(0);
            StringBuilder sb2 = new StringBuilder("INSERT OR REPLACE INTO ");
            sb2.append(str2);
            sb2.append(" (_id");
            for (C0285a c0285a4 : this.b) {
                if (c0285a4.d) {
                    sb2.append(',');
                    sb2.append(c0285a4.a);
                }
            }
            sb2.append(") VALUES (new._id");
            for (C0285a c0285a5 : this.b) {
                if (c0285a5.d) {
                    sb2.append(",new.");
                    sb2.append(c0285a5.a);
                }
            }
            sb2.append(");");
            String sb3 = sb2.toString();
            sb.append("CREATE TRIGGER ");
            sb.append(str);
            sb.append("_insert_trigger AFTER INSERT ON ");
            sb.append(str);
            sb.append(" FOR EACH ROW BEGIN ");
            sb.append(sb3);
            sb.append("END;");
            h(sQLiteDatabase, sb.toString());
            sb.setLength(0);
            sb.append("CREATE TRIGGER ");
            sb.append(str);
            sb.append("_update_trigger AFTER UPDATE ON ");
            sb.append(str);
            sb.append(" FOR EACH ROW BEGIN ");
            sb.append(sb3);
            sb.append("END;");
            h(sQLiteDatabase, sb.toString());
            sb.setLength(0);
            sb.append("CREATE TRIGGER ");
            sb.append(str);
            sb.append("_delete_trigger AFTER DELETE ON ");
            sb.append(str);
            sb.append(" FOR EACH ROW BEGIN DELETE FROM ");
            sb.append(str2);
            sb.append(" WHERE _id = old._id; END;");
            h(sQLiteDatabase, sb.toString());
            sb.setLength(0);
        }
    }

    public <T extends Entry> T b(Cursor cursor, T t) {
        C0285a[] c0285aArr;
        try {
            for (C0285a c0285a : this.b) {
                int i = c0285a.g;
                Field field = c0285a.f;
                Object obj = null;
                switch (c0285a.b) {
                    case 0:
                        if (!cursor.isNull(i)) {
                            obj = cursor.getString(i);
                        }
                        field.set(t, obj);
                        break;
                    case 1:
                        short s = cursor.getShort(i);
                        boolean z = true;
                        if (s != 1) {
                            z = false;
                        }
                        field.setBoolean(t, z);
                        break;
                    case 2:
                        field.setShort(t, cursor.getShort(i));
                        break;
                    case 3:
                        field.setInt(t, cursor.getInt(i));
                        break;
                    case 4:
                        field.setLong(t, cursor.getLong(i));
                        break;
                    case 5:
                        field.setFloat(t, cursor.getFloat(i));
                        break;
                    case 6:
                        field.setDouble(t, cursor.getDouble(i));
                        break;
                    case 7:
                        if (!cursor.isNull(i)) {
                            obj = cursor.getBlob(i);
                        }
                        field.set(t, obj);
                        break;
                }
            }
            return t;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        String str = this.a;
        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ");
        sb.append(str);
        sb.append(b90.TokenSEM);
        h(sQLiteDatabase, sb.toString());
        sb.setLength(0);
        if (this.d) {
            sb.append("DROP TABLE IF EXISTS ");
            sb.append(str);
            sb.append("_fulltext");
            sb.append(b90.TokenSEM);
            h(sQLiteDatabase, sb.toString());
        }
    }

    public String[] d() {
        return this.c;
    }

    public String e() {
        return this.a;
    }

    public long f(SQLiteDatabase sQLiteDatabase, Entry entry) {
        C0285a[] c0285aArr;
        if (Build.VERSION.SDK_INT == 29) {
            try {
                HashMap<String, Object> hashMap = new HashMap<>();
                for (C0285a c0285a : this.b) {
                    hashMap.put(c0285a.a, c0285a.f.get(entry));
                }
                if (entry.a == 0) {
                    hashMap.remove("_id");
                }
                long g = g(sQLiteDatabase, this.a, "_id", hashMap);
                entry.a = g;
                return g;
            } catch (Throwable th) {
                Log.e("EntrySchema", "sdk int 29 insertOrReplace db exception", th);
                return -1L;
            }
        }
        ContentValues contentValues = new ContentValues();
        i(entry, contentValues);
        if (entry.a == 0) {
            contentValues.remove("_id");
        }
        long replace = sQLiteDatabase.replace(this.a, "_id", contentValues);
        entry.a = replace;
        return replace;
    }

    public void i(Entry entry, ContentValues contentValues) {
        C0285a[] c0285aArr;
        try {
            for (C0285a c0285a : this.b) {
                String str = c0285a.a;
                Field field = c0285a.f;
                switch (c0285a.b) {
                    case 0:
                        contentValues.put(str, (String) field.get(entry));
                        break;
                    case 1:
                        contentValues.put(str, Boolean.valueOf(field.getBoolean(entry)));
                        break;
                    case 2:
                        contentValues.put(str, Short.valueOf(field.getShort(entry)));
                        break;
                    case 3:
                        contentValues.put(str, Integer.valueOf(field.getInt(entry)));
                        break;
                    case 4:
                        contentValues.put(str, Long.valueOf(field.getLong(entry)));
                        break;
                    case 5:
                        contentValues.put(str, Float.valueOf(field.getFloat(entry)));
                        break;
                    case 6:
                        contentValues.put(str, Double.valueOf(field.getDouble(entry)));
                        break;
                    case 7:
                        contentValues.put(str, (byte[]) field.get(entry));
                        break;
                }
            }
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }
}
