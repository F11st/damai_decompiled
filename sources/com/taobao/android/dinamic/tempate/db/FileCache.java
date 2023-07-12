package com.taobao.android.dinamic.tempate.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.dinamic.tempate.db.Entry;
import java.io.File;
import tb.kw2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FileCache {
    private static final String h = FileEntry.SCHEMA.e();
    private static final String[] i = {String.format("sum(%s)", "size")};
    private static final String[] j = {"_id", "filename", "tag", "size"};
    private static final String k = String.format("%s ASC", "last_access");
    private final LruCache<String, C6343b> a;
    private File b;
    private boolean c;
    private long d;
    private long e;
    private C6344c f;
    private OnDeleteFileListener g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @Entry.Table("file_cache")
    /* loaded from: classes11.dex */
    public static class FileEntry extends Entry {
        public static final C6345a SCHEMA = new C6345a(FileEntry.class);
        @Entry.Column(indexed = true, value = "hash_code")
        public long b;
        @Entry.Column("tag")
        public String c;
        @Entry.Column("filename")
        public String d;
        @Entry.Column("size")
        public long e;
        @Entry.Column(indexed = true, value = "last_access")
        public long f;

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public interface Columns extends Entry.Columns {
            public static final String FILENAME = "filename";
            public static final String HASH_CODE = "hash_code";
            public static final String LAST_ACCESS = "last_access";
            public static final String SIZE = "size";
            public static final String TAG = "tag";
        }

        private FileEntry() {
        }

        public String toString() {
            return "FileEntry{hashCode=" + this.b + ", tag='" + this.c + "', filename='" + this.d + "', size=" + this.e + ", lastAccess=" + this.f + '}';
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnDeleteFileListener {
        void afterDeleteFile();

        void beforeDeleteFile(File file);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.db.FileCache$b */
    /* loaded from: classes12.dex */
    public static final class C6343b {
        private long a;
        public File b;

        private C6343b(long j, String str, File file) {
            this.a = j;
            this.b = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.db.FileCache$c */
    /* loaded from: classes12.dex */
    public final class C6344c extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;

        public C6344c(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            FileEntry.SCHEMA.a(sQLiteDatabase);
            File[] listFiles = FileCache.this.b.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        Log.w("FileCache", "fail to remove: " + file.getAbsolutePath());
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            FileEntry.SCHEMA.c(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public FileCache(Context context, File file, String str, long j2) {
        this(context, file, str, j2, 4);
    }

    private boolean b(File file) {
        if (file != null) {
            OnDeleteFileListener onDeleteFileListener = this.g;
            if (onDeleteFileListener != null) {
                try {
                    onDeleteFileListener.beforeDeleteFile(file);
                } catch (Throwable th) {
                    Log.e("FileCache", "before delete file action exception", th);
                }
            }
            boolean delete = file.delete();
            OnDeleteFileListener onDeleteFileListener2 = this.g;
            if (onDeleteFileListener2 != null) {
                try {
                    onDeleteFileListener2.afterDeleteFile();
                    return delete;
                } catch (Throwable th2) {
                    Log.e("FileCache", "after delete file action exception", th2);
                    return delete;
                }
            }
            return delete;
        }
        return true;
    }

    private void c(int i2) {
        Cursor query = this.f.getReadableDatabase().query(h, j, null, null, null, null, k);
        while (i2 > 0) {
            try {
                if (this.e <= this.d || !query.moveToNext()) {
                    break;
                }
                long j2 = query.getLong(0);
                String string = query.getString(1);
                String string2 = query.getString(2);
                long j3 = query.getLong(3);
                synchronized (this.a) {
                    if (this.a.get(string2) == null) {
                        i2--;
                        if (b(new File(this.b, string))) {
                            this.e -= j3;
                            this.f.getWritableDatabase().delete(h, "_id=?", new String[]{String.valueOf(j2)});
                        } else {
                            Log.w("FileCache", "unable to delete file: " + string);
                        }
                    }
                }
            } finally {
                query.close();
            }
        }
    }

    private FileEntry f(String str) {
        Cursor cursor;
        C6345a c6345a;
        String[] strArr = {String.valueOf(kw2.b(str)), str};
        try {
            SQLiteDatabase readableDatabase = this.f.getReadableDatabase();
            String str2 = h;
            c6345a = FileEntry.SCHEMA;
            cursor = readableDatabase.query(str2, c6345a.d(), "hash_code=? AND tag=?", strArr, null, null, null);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (!cursor.moveToNext()) {
                cursor.close();
                return null;
            }
            FileEntry fileEntry = new FileEntry();
            c6345a.b(cursor, fileEntry);
            h(fileEntry.a);
            cursor.close();
            return fileEntry;
        } catch (Throwable th2) {
            th = th2;
            try {
                Log.e("FileCache", "query database exception", th);
                return null;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private void h(long j2) {
        if (Build.VERSION.SDK_INT == 29) {
            try {
                i(this.f.getWritableDatabase(), h, "_id=?", String.valueOf(j2));
                return;
            } catch (Throwable th) {
                Log.e("FileCache", "sdk int 29 update db exception", th);
                return;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
        try {
            this.f.getWritableDatabase().update(h, contentValues, "_id=?", new String[]{String.valueOf(j2)});
        } catch (Throwable th2) {
            Log.e("FileCache", "update db exception", th2);
        }
    }

    private int i(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.acquireReference();
        try {
            StringBuilder sb = new StringBuilder(120);
            sb.append("UPDATE ");
            sb.append(str);
            sb.append(" SET ");
            sb.append("last_access=?");
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(sb.toString());
            compileStatement.bindLong(1, System.currentTimeMillis());
            compileStatement.bindString(2, str3);
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            compileStatement.close();
            return executeUpdateDelete;
        } finally {
            sQLiteDatabase.releaseReference();
        }
    }

    public synchronized void d() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (!this.b.isDirectory()) {
            this.b.mkdirs();
            if (!this.b.isDirectory()) {
                throw new RuntimeException("cannot create: " + this.b.getAbsolutePath());
            }
        }
        Cursor query = this.f.getReadableDatabase().query(h, i, null, null, null, null, null);
        if (query.moveToNext()) {
            this.e = query.getLong(0);
        }
        query.close();
        if (this.e > this.d) {
            c(16);
        }
    }

    public C6343b e(String str) {
        if (!this.c) {
            try {
                d();
            } catch (Exception e) {
                Log.e("FileCache", "file cache init exception:", e);
                return null;
            }
        }
        C6343b c6343b = this.a.get(str);
        if (c6343b != null) {
            if (c6343b.b.isFile()) {
                synchronized (this) {
                    h(c6343b.a);
                }
                return c6343b;
            }
            this.a.remove(str);
        }
        synchronized (this) {
            FileEntry f = f(str);
            if (f == null) {
                return null;
            }
            C6343b c6343b2 = new C6343b(f.a, str, new File(this.b, f.d));
            if (!c6343b2.b.isFile()) {
                this.f.getWritableDatabase().delete(h, "_id=?", new String[]{String.valueOf(f.a)});
                this.e -= f.e;
                return null;
            }
            this.a.put(str, c6343b2);
            return c6343b2;
        }
    }

    public void g(String str, File file) {
        if (!this.c) {
            try {
                d();
            } catch (Exception e) {
                Log.e("FileCache", "file cache init exception:", e);
                return;
            }
        }
        kw2.a(file.getParentFile().equals(this.b));
        FileEntry fileEntry = new FileEntry();
        fileEntry.b = kw2.b(str);
        fileEntry.c = str;
        fileEntry.d = file.getName();
        fileEntry.e = file.length();
        fileEntry.f = System.currentTimeMillis();
        if (fileEntry.e < this.d) {
            synchronized (this) {
                FileEntry f = f(str);
                if (f != null) {
                    fileEntry.d = f.d;
                    fileEntry.e = f.e;
                } else {
                    this.e += fileEntry.e;
                }
                FileEntry.SCHEMA.f(this.f.getWritableDatabase(), fileEntry);
                if (this.e > this.d) {
                    c(16);
                }
            }
            return;
        }
        file.delete();
        throw new IllegalArgumentException("file too large: " + fileEntry.e);
    }

    public FileCache(Context context, File file, String str, long j2, int i2) {
        this.c = false;
        this.b = file;
        this.d = j2;
        this.a = new LruCache<>(i2);
        this.f = new C6344c(context, str);
    }
}
