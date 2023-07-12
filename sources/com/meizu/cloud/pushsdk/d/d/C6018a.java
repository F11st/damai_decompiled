package com.meizu.cloud.pushsdk.d.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.d.a.C6001c;
import com.meizu.cloud.pushsdk.d.a.InterfaceC5999a;
import com.meizu.cloud.pushsdk.d.b.C6007c;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.taobao.weex.annotation.JSMethod;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.d.a */
/* loaded from: classes10.dex */
public class C6018a implements InterfaceC6021d {
    private static final String a = "a";
    private SQLiteDatabase b;
    private final C6019b c;
    private final String[] d = {"id", "eventData", "dateCreated"};
    private long e = -1;
    private final int f;

    public C6018a(Context context, int i) {
        this.c = C6019b.a(context, a(context));
        b();
        this.f = i;
    }

    private String a(Context context) {
        String processName = MzSystemUtils.getProcessName(context);
        if (TextUtils.isEmpty(processName)) {
            return "PushEvents.db";
        }
        return processName + JSMethod.NOT_SET + "PushEvents.db";
    }

    public static Map<String, String> a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Map<String, String> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> a(int i) {
        return a(null, "id ASC LIMIT " + i);
    }

    public List<Map<String, Object>> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (e()) {
            Cursor query = this.b.query("events", this.d, str, null, null, null, str2);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("id", Long.valueOf(query.getLong(0)));
                hashMap.put("eventData", a(query.getBlob(1)));
                hashMap.put("dateCreated", query.getString(2));
                query.moveToNext();
                arrayList.add(hashMap);
            }
            query.close();
        }
        return arrayList;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public void a(InterfaceC5999a interfaceC5999a) {
        b(interfaceC5999a);
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public boolean a() {
        return e();
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public boolean a(long j) {
        int i;
        if (e()) {
            SQLiteDatabase sQLiteDatabase = this.b;
            i = sQLiteDatabase.delete("events", "id=" + j, null);
        } else {
            i = -1;
        }
        String str = a;
        C6030c.b(str, "Removed event from database: " + j, new Object[0]);
        return i == 1;
    }

    public long b(InterfaceC5999a interfaceC5999a) {
        if (e()) {
            byte[] a2 = a(interfaceC5999a.a());
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("eventData", a2);
            this.e = this.b.insert("events", null, contentValues);
        }
        String str = a;
        C6030c.b(str, "Added event to database: " + this.e, new Object[0]);
        return this.e;
    }

    public void b() {
        if (e()) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            this.b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
        } catch (Exception e) {
            String str = a;
            C6030c.a(str, " open database error " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public long c() {
        if (e()) {
            return DatabaseUtils.queryNumEntries(this.b, "events");
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public C6007c d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : a(this.f)) {
            C6001c c6001c = new C6001c();
            c6001c.a((Map) map.get("eventData"));
            linkedList.add((Long) map.get("id"));
            arrayList.add(c6001c);
        }
        return new C6007c(arrayList, linkedList);
    }

    public boolean e() {
        SQLiteDatabase sQLiteDatabase = this.b;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
