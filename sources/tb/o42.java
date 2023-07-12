package tb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.utils.Logger;
import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class o42 extends SQLiteOpenHelper {
    private SQLiteDatabase a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.o42$a */
    /* loaded from: classes5.dex */
    public static class C9505a implements FileFilter {
        final /* synthetic */ String a;

        C9505a(String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().startsWith(this.a);
        }
    }

    public o42(Context context, String str) {
        super(context, str, null, 2, null);
    }

    private void b(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized void c() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    private static boolean d(File file) {
        if (file == null) {
            return false;
        }
        boolean delete = file.delete() | false | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            File[] listFiles = parentFile.listFiles(new C9505a(file.getName() + "-mj"));
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    delete |= file2.delete();
                }
            }
        }
        return delete;
    }

    public void a() {
        getWritableDatabase();
        c();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            if (this.a == null) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.a = writableDatabase;
                boolean isDatabaseIntegrityOk = writableDatabase.isDatabaseIntegrityOk();
                Logger.f("SQLiteCheckHelper", "isDatabaseIntegrityOk", Boolean.valueOf(isDatabaseIntegrityOk));
                if (!isDatabaseIntegrityOk) {
                    Logger.i("SQLiteCheckHelper", "delete Database", Boolean.valueOf(d(new File(this.a.getPath()))));
                }
                Logger.f("SQLiteCheckHelper", "WritableDatabase", this.a);
            }
        }
        return this.a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable unused) {
        }
        b(cursor);
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
