package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hg {
    private static Map<Class<? extends hf>, hf> d = new HashMap();
    private hj a;
    private SQLiteDatabase b;
    private hf c;

    public hg(Context context, hf hfVar) {
        try {
            this.a = new hj(context.getApplicationContext(), hfVar.b(), null, hfVar.c(), hfVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = hfVar;
    }

    public static synchronized hf a(Class<? extends hf> cls) throws IllegalAccessException, InstantiationException {
        hf hfVar;
        synchronized (hg.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            hfVar = d.get(cls);
        }
        return hfVar;
    }

    private boolean a(Annotation annotation) {
        return annotation != null;
    }

    public <T> List<T> b(String str, Class<T> cls) {
        return a(str, (Class) cls, false);
    }

    private SQLiteDatabase b(boolean z) {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            ha.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (z) {
                sb.append(str);
                sb.append(" = '");
                sb.append(map.get(str));
                sb.append("'");
                z = false;
            } else {
                sb.append(" and ");
                sb.append(str);
                sb.append(" = '");
                sb.append(map.get(str));
                sb.append("'");
            }
        }
        return sb.toString();
    }

    private <T> hh b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hh.class);
        if (a(annotation)) {
            return (hh) annotation;
        }
        return null;
    }

    public <T> void a(String str, Class<T> cls) {
        synchronized (this.c) {
            String a = a(b(cls));
            if (TextUtils.isEmpty(a)) {
                return;
            }
            SQLiteDatabase b = b(false);
            this.b = b;
            if (b == null) {
                return;
            }
            b.delete(a, str, null);
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    public <T> void a(String str, Object obj, boolean z) {
        synchronized (this.c) {
            if (obj == null) {
                return;
            }
            hh b = b(obj.getClass());
            String a = a(b);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            ContentValues a2 = a(obj, b);
            if (a2 == null) {
                return;
            }
            SQLiteDatabase b2 = b(z);
            this.b = b2;
            if (b2 == null) {
                return;
            }
            b2.update(a, a2, str, null);
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    public <T> void a(String str, Object obj) {
        a(str, obj, false);
    }

    public void a(Object obj, String str) {
        synchronized (this.c) {
            List b = b(str, obj.getClass());
            if (b != null && b.size() != 0) {
                a(str, obj);
            }
            a((hg) obj);
        }
    }

    public <T> void a(T t) {
        a((hg) t, false);
    }

    public <T> void a(T t, boolean z) {
        synchronized (this.c) {
            SQLiteDatabase b = b(z);
            this.b = b;
            if (b == null) {
                return;
            }
            a(b, (SQLiteDatabase) t);
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        ContentValues a;
        hh b = b(t.getClass());
        String a2 = a(b);
        if (TextUtils.isEmpty(a2) || sQLiteDatabase == null || (a = a(t, b)) == null) {
            return;
        }
        sQLiteDatabase.insert(a2, null, a);
    }

    public <T> void a(List<T> list) {
        synchronized (this.c) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase b = b(false);
                    this.b = b;
                    if (b == null) {
                        return;
                    }
                    b.beginTransaction();
                    for (T t : list) {
                        a(this.b, (SQLiteDatabase) t);
                    }
                    this.b.setTransactionSuccessful();
                    if (this.b.inTransaction()) {
                        this.b.endTransaction();
                    }
                    try {
                        this.b.close();
                        this.b = null;
                    } catch (Throwable th) {
                        ha.a(th, "dbs", "ild");
                    }
                }
            }
        }
    }

    public <T> List<T> a(String str, Class<T> cls, boolean z) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            hh b = b(cls);
            String a = a(b);
            if (this.b == null) {
                this.b = a(z);
            }
            if (this.b == null || TextUtils.isEmpty(a) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                if (!z) {
                    ha.a(th, "dbs", "sld");
                }
                if (cursor != null) {
                    cursor.close();
                }
                try {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        this.b = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (!z) {
                        str2 = "dbs";
                        str3 = "sld";
                        ha.a(th, str2, str3);
                    }
                }
                return arrayList;
            }
            if (cursor == null) {
                this.b.close();
                this.b = null;
                if (cursor != null) {
                    cursor.close();
                }
                SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                    this.b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(a(cursor, cls, b));
            }
            cursor.close();
            try {
                SQLiteDatabase sQLiteDatabase3 = this.b;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                    this.b = null;
                }
            } catch (Throwable th4) {
                th = th4;
                if (!z) {
                    str2 = "dbs";
                    str3 = "sld";
                    ha.a(th, str2, str3);
                }
            }
            return arrayList;
        }
    }

    private <T> T a(Cursor cursor, Class<T> cls, hh hhVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a = a((Class<?>) cls, hhVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(hi.class);
            if (annotation != null) {
                hi hiVar = (hi) annotation;
                int b = hiVar.b();
                int columnIndex = cursor.getColumnIndex(hiVar.a());
                switch (b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    private void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(hi.class);
        if (annotation == null) {
            return;
        }
        hi hiVar = (hi) annotation;
        try {
            switch (hiVar.b()) {
                case 1:
                    contentValues.put(hiVar.a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(hiVar.a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(hiVar.a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(hiVar.a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(hiVar.a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(hiVar.a(), (String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(hiVar.a(), (byte[]) field.get(obj));
                    break;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private ContentValues a(Object obj, hh hhVar) {
        Field[] a;
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), hhVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                ha.a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    private <T> String a(hh hhVar) {
        if (hhVar == null) {
            return null;
        }
        return hhVar.a();
    }
}
