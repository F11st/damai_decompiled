package tb;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class s73 implements com.loc.aq {
    @Override // com.loc.aq
    public final String a() {
        return "alsn20170807.db";
    }

    @Override // com.loc.aq
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            com.loc.j1.h(th, "SdCardDbCreator", "onCreate");
        }
    }
}
