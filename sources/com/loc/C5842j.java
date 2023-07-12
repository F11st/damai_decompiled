package com.loc;

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
import tb.a43;
import tb.y33;

/* compiled from: Taobao */
/* renamed from: com.loc.j */
/* loaded from: classes10.dex */
public final class C5842j {
    private static Map<Class<? extends aq>, aq> d = new HashMap();
    private a43 a;
    private SQLiteDatabase b;
    private aq c;

    public C5842j(Context context, aq aqVar) {
        try {
            this.a = new a43(context.getApplicationContext(), aqVar.a(), aqVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = aqVar;
    }

    private static ContentValues a(Object obj, as asVar) {
        Field[] l;
        ContentValues contentValues = new ContentValues();
        for (Field field : l(obj.getClass(), asVar.b())) {
            field.setAccessible(true);
            j(obj, field, contentValues);
        }
        return contentValues;
    }

    private SQLiteDatabase b() {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            y33.e(th, "dbs", "grd");
        }
        return this.b;
    }

    public static synchronized aq c(Class<? extends aq> cls) throws IllegalAccessException, InstantiationException {
        aq aqVar;
        synchronized (C5842j.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            aqVar = d.get(cls);
        }
        return aqVar;
    }

    private static <T> T d(Cursor cursor, Class<T> cls, as asVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object valueOf;
        Field[] l = l(cls, asVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : l) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(at.class);
            if (annotation != null) {
                at atVar = (at) annotation;
                int b = atVar.b();
                int columnIndex = cursor.getColumnIndex(atVar.a());
                switch (b) {
                    case 1:
                        valueOf = Short.valueOf(cursor.getShort(columnIndex));
                        field.set(newInstance, valueOf);
                        break;
                    case 2:
                        valueOf = Integer.valueOf(cursor.getInt(columnIndex));
                        field.set(newInstance, valueOf);
                        break;
                    case 3:
                        valueOf = Float.valueOf(cursor.getFloat(columnIndex));
                        field.set(newInstance, valueOf);
                        break;
                    case 4:
                        valueOf = Double.valueOf(cursor.getDouble(columnIndex));
                        field.set(newInstance, valueOf);
                        break;
                    case 5:
                        valueOf = Long.valueOf(cursor.getLong(columnIndex));
                        field.set(newInstance, valueOf);
                        break;
                    case 6:
                        valueOf = cursor.getString(columnIndex);
                        field.set(newInstance, valueOf);
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> String e(as asVar) {
        if (asVar == null) {
            return null;
        }
        return asVar.a();
    }

    private static <T> void g(SQLiteDatabase sQLiteDatabase, T t) {
        as n = n(t.getClass());
        String e = e(n);
        if (TextUtils.isEmpty(e) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(e, null, a(t, n));
    }

    private <T> void h(T t) {
        p(t);
    }

    private static void j(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(at.class);
        if (annotation == null) {
            return;
        }
        at atVar = (at) annotation;
        try {
            switch (atVar.b()) {
                case 1:
                    contentValues.put(atVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(atVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(atVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(atVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(atVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(atVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    contentValues.put(atVar.a(), (byte[]) field.get(obj));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private <T> void k(String str, Object obj) {
        synchronized (this.c) {
            if (obj == null) {
                return;
            }
            as n = n(obj.getClass());
            String e = e(n);
            if (TextUtils.isEmpty(e)) {
                return;
            }
            ContentValues a = a(obj, n);
            SQLiteDatabase m = m();
            this.b = m;
            if (m == null) {
                return;
            }
            m.update(e, a, str, null);
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private static Field[] l(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase m() {
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
            y33.e(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> as n(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(as.class);
        if (annotation != null) {
            return (as) annotation;
        }
        return null;
    }

    private <T> List<T> o(String str, Class<T> cls) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            as n = n(cls);
            String e = e(n);
            if (this.b == null) {
                this.b = b();
            }
            if (this.b == null || TextUtils.isEmpty(e) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(e, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                y33.e(th, "dbs", "sld");
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
                    str2 = "dbs";
                    str3 = "sld";
                    y33.e(th, str2, str3);
                    return arrayList;
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
                arrayList.add(d(cursor, cls, n));
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
                str2 = "dbs";
                str3 = "sld";
                y33.e(th, str2, str3);
                return arrayList;
            }
            return arrayList;
        }
    }

    private <T> void p(T t) {
        synchronized (this.c) {
            SQLiteDatabase m = m();
            this.b = m;
            if (m == null) {
                return;
            }
            g(m, t);
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private <T> void q(String str, Object obj) {
        k(str, obj);
    }

    public final <T> List<T> f(String str, Class<T> cls) {
        return o(str, cls);
    }

    public final void i(Object obj, String str) {
        synchronized (this.c) {
            List f = f(str, obj.getClass());
            if (f != null && f.size() != 0) {
                q(str, obj);
            }
            h(obj);
        }
    }
}
