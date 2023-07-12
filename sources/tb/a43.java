package tb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a43 extends SQLiteOpenHelper {
    private com.loc.aq a;

    public a43(Context context, String str, com.loc.aq aqVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = aqVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
