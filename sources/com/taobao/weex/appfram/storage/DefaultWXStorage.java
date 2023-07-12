package com.taobao.weex.appfram.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.jn1;
import tb.vg2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultWXStorage implements IWXStorageAdapter {
    private a a;
    private ExecutorService b;

    public DefaultWXStorage(Context context) {
        this.a = new a(context);
    }

    private void g(@Nullable Runnable runnable) {
        if (this.b == null) {
            this.b = Executors.newSingleThreadExecutor();
        }
        if (runnable == null || this.b.isShutdown() || this.b.isTerminated()) {
            return;
        }
        this.b.execute(WXThread.secure(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> h() {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor query = database.query("default_wx_storage", new String[]{"key"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(query.getColumnIndex("key")));
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getAllKeys:" + e.getMessage());
                return arrayList;
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(String str) {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return null;
        }
        Cursor query = database.query("default_wx_storage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
        try {
            if (query.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", a.d.format(new Date()));
                int update = this.a.getDatabase().update("default_wx_storage", contentValues, "key= ?", new String[]{str});
                StringBuilder sb = new StringBuilder();
                sb.append("update timestamp ");
                sb.append(update == 1 ? "success" : "failed");
                sb.append(" for operation [getItem(key = ");
                sb.append(str);
                sb.append(")]");
                WXLogUtils.d("weex_storage", sb.toString());
                return query.getString(query.getColumnIndex("value"));
            }
            return null;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getItem:" + e.getMessage());
            return null;
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long j() {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return 0L;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = database.compileStatement("SELECT count(key) FROM default_wx_storage");
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                return simpleQueryForLong;
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getLength:" + e.getMessage());
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                return 0L;
            }
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(String str) {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return false;
        }
        try {
            return database.delete("default_wx_storage", "key=?", new String[]{str}) == 1;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute removeItem:" + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str, String str2, boolean z, boolean z2) {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return false;
        }
        WXLogUtils.d("weex_storage", "set k-v to storage(key:" + str + ",value:" + str2 + ",isPersistent:" + z + ",allowRetry:" + z2 + jn1.BRACKET_END_STR);
        SQLiteStatement sQLiteStatement = null;
        String format = a.d.format(new Date());
        try {
            try {
                sQLiteStatement = database.compileStatement("INSERT OR REPLACE INTO default_wx_storage VALUES (?,?,?,?);");
                sQLiteStatement.clearBindings();
                sQLiteStatement.bindString(1, str);
                sQLiteStatement.bindString(2, str2);
                sQLiteStatement.bindString(3, format);
                sQLiteStatement.bindLong(4, z ? 1L : 0L);
                sQLiteStatement.execute();
                sQLiteStatement.close();
                return true;
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute setItem :" + e.getMessage());
                if (!(e instanceof SQLiteFullException) || !z2 || !m()) {
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    return false;
                }
                WXLogUtils.d("weex_storage", "retry set k-v to storage(key:" + str + ",value:" + str2 + jn1.BRACKET_END_STR);
                boolean l = l(str, str2, z, false);
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                return l;
            }
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m() {
        /*
            r13 = this;
            java.lang.String r0 = "weex_storage"
            com.taobao.weex.appfram.storage.a r1 = r13.a
            android.database.sqlite.SQLiteDatabase r2 = r1.getDatabase()
            r1 = 0
            if (r2 != 0) goto Lc
            return r1
        Lc:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r11 = "key"
            java.lang.String r12 = "persistent"
            java.lang.String[] r4 = new java.lang.String[]{r11, r12}
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r3 = "default_wx_storage"
            java.lang.String r9 = "timestamp ASC"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)
            r3 = 1
            int r4 = r2.getCount()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            int r4 = r4 / 10
            r5 = 0
        L2d:
            boolean r6 = r2.moveToNext()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L59
            if (r6 == 0) goto L53
            int r6 = r2.getColumnIndex(r11)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L59
            java.lang.String r6 = r2.getString(r6)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L59
            int r7 = r2.getColumnIndex(r12)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L59
            int r7 = r2.getInt(r7)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L59
            if (r7 != r3) goto L47
            r7 = 1
            goto L48
        L47:
            r7 = 0
        L48:
            if (r7 != 0) goto L2d
            if (r6 == 0) goto L2d
            int r5 = r5 + 1
            r10.add(r6)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L59
            if (r5 != r4) goto L2d
        L53:
            r2.close()
            goto L76
        L57:
            r4 = move-exception
            goto L5d
        L59:
            r0 = move-exception
            goto La7
        L5b:
            r4 = move-exception
            r5 = 0
        L5d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r6.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r7 = "DefaultWXStorage occurred an exception when execute trimToSize:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L59
            r6.append(r4)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L59
            com.taobao.weex.utils.WXLogUtils.e(r0, r4)     // Catch: java.lang.Throwable -> L59
            goto L53
        L76:
            if (r5 > 0) goto L79
            return r1
        L79:
            java.util.Iterator r1 = r10.iterator()
        L7d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8d
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r13.k(r2)
            goto L7d
        L8d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "remove "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " items by lru"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.taobao.weex.utils.WXLogUtils.e(r0, r1)
            return r3
        La7:
            r2.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.appfram.storage.DefaultWXStorage.m():boolean");
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void close() {
        final ExecutorService executorService = this.b;
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DefaultWXStorage.this.a.a();
                    ExecutorService executorService2 = executorService;
                    if (executorService2 != null) {
                        executorService2.shutdown();
                    }
                } catch (Exception e) {
                    WXLogUtils.e("weex_storage", e.getMessage());
                }
            }
        });
        this.b = null;
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getAllKeys(final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.5
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> a = vg2.a(DefaultWXStorage.this.h());
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(a);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getItem(final String str, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.2
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> b = vg2.b(DefaultWXStorage.this.i(str));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(b);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void length(final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.4
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> c = vg2.c(DefaultWXStorage.this.j());
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(c);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void removeItem(final String str, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.3
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> g = vg2.g(DefaultWXStorage.this.k(str));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(g);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItem(final String str, final String str2, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.1
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> h = vg2.h(DefaultWXStorage.this.l(str, str2, false, true));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(h);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItemPersistent(final String str, final String str2, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.6
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> h = vg2.h(DefaultWXStorage.this.l(str, str2, true, true));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(h);
            }
        });
    }
}
