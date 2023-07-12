package com.taobao.android.ultron.datamodel.cache.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.ultron.datamodel.cache.db.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tb.bw2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FileCache {
    private static final String f = FileEntry.SCHEMA.e();
    private final LruCache<String, C6655b> a;
    private File b;
    private boolean c;
    private long d;
    private C6656c e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @Entry.Table("file_cache")
    /* loaded from: classes11.dex */
    public static class FileEntry extends Entry {
        public static final C6657a SCHEMA = new C6657a(FileEntry.class);
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
    /* renamed from: com.taobao.android.ultron.datamodel.cache.db.FileCache$b */
    /* loaded from: classes12.dex */
    public static final class C6655b {
        private long a;
        public String b;
        public File c;

        private C6655b(long j, String str, File file) {
            this.a = j;
            this.b = str;
            this.c = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.ultron.datamodel.cache.db.FileCache$c */
    /* loaded from: classes12.dex */
    public final class C6656c extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;

        public C6656c(Context context, String str) {
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

    static {
        String.format("sum(%s)", "size");
    }

    public FileCache(Context context, File file, String str, long j) {
        this(context, file, str, j, 4);
    }

    private List<FileEntry> d() {
        Cursor cursor;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.e.getReadableDatabase().query(f, FileEntry.SCHEMA.d(), null, null, null, null, null);
            while (cursor.moveToNext()) {
                try {
                    FileEntry fileEntry = new FileEntry();
                    FileEntry.SCHEMA.b(cursor, fileEntry);
                    i(fileEntry.a);
                    arrayList.add(fileEntry);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.e("FileCache", "query database exception", th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
        return arrayList;
    }

    private FileEntry g(String str) {
        Cursor cursor;
        C6657a c6657a;
        String[] strArr = {String.valueOf(bw2.b(str)), str};
        try {
            SQLiteDatabase readableDatabase = this.e.getReadableDatabase();
            String str2 = f;
            c6657a = FileEntry.SCHEMA;
            cursor = readableDatabase.query(str2, c6657a.d(), "hash_code=? AND tag=?", strArr, null, null, null);
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
            c6657a.b(cursor, fileEntry);
            i(fileEntry.a);
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

    private void i(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
        try {
            this.e.getWritableDatabase().update(f, contentValues, "_id=?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            Log.e("FileCache", "update db exception", e);
        }
    }

    public void b(String str) {
        synchronized (this) {
            FileEntry g = g(str);
            if (g != null) {
                C6655b c6655b = new C6655b(g.a, str, new File(this.b, g.d));
                this.e.getWritableDatabase().delete(f, "_id=?", new String[]{String.valueOf(g.a)});
                c6655b.c.delete();
            }
        }
    }

    public List<C6655b> c() {
        if (!this.c) {
            try {
                e();
            } catch (Exception e) {
                Log.e("FileCache", "file cache init exception:", e);
                return null;
            }
        }
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            List<FileEntry> d = d();
            if (d == null) {
                return null;
            }
            for (FileEntry fileEntry : d) {
                C6655b c6655b = new C6655b(fileEntry.a, fileEntry.c, new File(this.b, fileEntry.d));
                if (!c6655b.c.isFile()) {
                    this.e.getWritableDatabase().delete(f, "_id=?", new String[]{String.valueOf(fileEntry.a)});
                } else {
                    arrayList.add(c6655b);
                }
            }
            return arrayList;
        }
    }

    public synchronized void e() {
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
    }

    public C6655b f(String str) {
        if (!this.c) {
            try {
                e();
            } catch (Exception e) {
                Log.e("FileCache", "file cache init exception:", e);
                return null;
            }
        }
        C6655b c6655b = this.a.get(str);
        if (c6655b != null) {
            if (c6655b.c.isFile()) {
                synchronized (this) {
                    i(c6655b.a);
                }
                return c6655b;
            }
            this.a.remove(str);
        }
        synchronized (this) {
            FileEntry g = g(str);
            if (g == null) {
                return null;
            }
            C6655b c6655b2 = new C6655b(g.a, str, new File(this.b, g.d));
            if (!c6655b2.c.isFile()) {
                this.e.getWritableDatabase().delete(f, "_id=?", new String[]{String.valueOf(g.a)});
                return null;
            }
            this.a.put(str, c6655b2);
            return c6655b2;
        }
    }

    public void h(String str, File file) {
        if (!this.c) {
            try {
                e();
            } catch (Exception e) {
                Log.e("FileCache", "file cache init exception:", e);
                return;
            }
        }
        bw2.a(file.getParentFile().equals(this.b));
        FileEntry fileEntry = new FileEntry();
        fileEntry.b = bw2.b(str);
        fileEntry.c = str;
        fileEntry.d = file.getName();
        fileEntry.e = file.length();
        fileEntry.f = System.currentTimeMillis();
        if (fileEntry.e < this.d) {
            synchronized (this) {
                FileEntry g = g(str);
                if (g != null) {
                    fileEntry.d = g.d;
                    fileEntry.e = g.e;
                }
                FileEntry.SCHEMA.f(this.e.getWritableDatabase(), fileEntry);
                Log.e("detail_FileCache", "insertOrReplace entry:" + fileEntry);
            }
            return;
        }
        file.delete();
        throw new IllegalArgumentException("file too large: " + fileEntry.e);
    }

    public FileCache(Context context, File file, String str, long j, int i) {
        this.c = false;
        this.b = file;
        this.d = j;
        this.a = new LruCache<>(i);
        C6656c c6656c = new C6656c(context, str);
        this.e = c6656c;
        if (Build.VERSION.SDK_INT >= 16) {
            c6656c.setWriteAheadLoggingEnabled(false);
        }
    }
}
