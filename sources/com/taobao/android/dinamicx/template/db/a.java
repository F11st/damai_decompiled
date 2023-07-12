package com.taobao.android.dinamicx.template.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.taobao.android.dinamicx.template.db.DXDataBaseEntry;
import java.lang.reflect.Field;
import java.util.ArrayList;
import tb.b90;
import tb.jn1;
import tb.nz;
import tb.s00;

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
    private static final String[] c = {"TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "REAL", "REAL", "NONE"};
    private final String a;
    private final C0289a[] b;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.template.db.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C0289a {
        public final String a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final String e;
        public final boolean f;

        public C0289a(String str, int i, boolean z, boolean z2, String str2, boolean z3, Field field, int i2) {
            this.a = str.toLowerCase();
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = str2;
            this.f = z3;
            field.setAccessible(true);
        }

        public boolean a() {
            return "_id".equals(this.a);
        }
    }

    public a(Class<? extends DXDataBaseEntry> cls) {
        C0289a[] f = f(cls);
        this.a = g(cls);
        this.b = f;
        if (f != null) {
            String[] strArr = new String[f.length];
            for (int i = 0; i != f.length; i++) {
                strArr[i] = f[i].a;
            }
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(str);
    }

    private void e(Class<?> cls, ArrayList<C0289a> arrayList) {
        int i;
        Field[] declaredFields = cls.getDeclaredFields();
        for (int i2 = 0; i2 != declaredFields.length; i2++) {
            Field field = declaredFields[i2];
            DXDataBaseEntry.Column column = (DXDataBaseEntry.Column) field.getAnnotation(DXDataBaseEntry.Column.class);
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
                arrayList.add(new C0289a(column.value(), i, column.indexed(), column.primaryKey(), column.defaultValue(), column.notNull(), field, arrayList.size()));
            }
        }
    }

    private C0289a[] f(Class<?> cls) {
        ArrayList<C0289a> arrayList = new ArrayList<>();
        while (cls != null) {
            e(cls, arrayList);
            cls = cls.getSuperclass();
        }
        C0289a[] c0289aArr = new C0289a[arrayList.size()];
        arrayList.toArray(c0289aArr);
        return c0289aArr;
    }

    private String g(Class<?> cls) {
        DXDataBaseEntry.Table table = (DXDataBaseEntry.Table) cls.getAnnotation(DXDataBaseEntry.Table.class);
        if (table == null) {
            return null;
        }
        return table.value();
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        C0289a[] c0289aArr;
        C0289a[] c0289aArr2;
        String str = this.a;
        if (TextUtils.isEmpty(str)) {
            s00.d(nz.TAG, "DataBase", "没有用注解定义表名");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append(str);
        sb2.append(" (_id INTEGER");
        for (C0289a c0289a : this.b) {
            if (!c0289a.a()) {
                sb2.append(',');
                sb2.append(c0289a.a);
                sb2.append(' ');
                sb2.append(c[c0289a.b]);
                if (!TextUtils.isEmpty(c0289a.e)) {
                    sb2.append(" DEFAULT ");
                    sb2.append(c0289a.e);
                } else if (c0289a.f) {
                    sb2.append(" NOT NULL");
                }
                if (c0289a.d) {
                    sb.append(c0289a.a);
                    sb.append(",");
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb2.append(", PRIMARY KEY(");
            sb2.append(sb.toString());
            sb2.append(jn1.BRACKET_END_STR);
        }
        sb2.append(");");
        d(sQLiteDatabase, sb2.toString());
        sb2.setLength(0);
        sb2.append("CREATE INDEX index_template ON ");
        sb2.append(str);
        sb2.append(jn1.BRACKET_START_STR);
        for (C0289a c0289a2 : this.b) {
            if (c0289a2.c) {
                sb2.append(c0289a2.a);
                sb2.append(",");
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append(");");
        d(sQLiteDatabase, sb2.toString());
        sb2.setLength(0);
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ");
        sb.append(this.a);
        sb.append(b90.TokenSEM);
        d(sQLiteDatabase, sb.toString());
        sb.setLength(0);
    }

    public String c() {
        return this.a;
    }
}
