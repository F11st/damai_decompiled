package com.youku.arch.v3.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/youku/arch/v3/data/local/CacheDBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", "db", "Ltb/wt2;", "createDataCacheTable", "upgradeDatabaseToVersion2", "dropTable", "onCreate", "onConfigure", "", "oldVersion", "newVersion", "onUpgrade", "onDowngrade", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CacheDBHelper extends SQLiteOpenHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COLUMN_CHANNEL = 7;
    public static final int COLUMN_CONTENT = 2;
    public static final int COLUMN_EXPIRE = 4;
    public static final int COLUMN_ID = 0;
    public static final int COLUMN_RET_CODE = 5;
    public static final int COLUMN_RET_MSG = 6;
    public static final int COLUMN_TIME = 3;
    public static final int COLUMN_TYPE = 1;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.CacheDBHelper";
    private static final int VERSION = 2;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/data/local/CacheDBHelper$Companion;", "", "", "COLUMN_CHANNEL", "I", "COLUMN_CONTENT", "COLUMN_EXPIRE", "COLUMN_ID", "COLUMN_RET_CODE", "COLUMN_RET_MSG", "COLUMN_TIME", "COLUMN_TYPE", "", "TAG", "Ljava/lang/String;", "VERSION", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public CacheDBHelper(@Nullable Context context) {
        super(context, "data_cache.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    private final void createDataCacheTable(SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082456626")) {
            ipChange.ipc$dispatch("-1082456626", new Object[]{this, sQLiteDatabase});
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE if not exists data_cache(_id integer primary key,type varchar,content varchar,timestamp integer,expire integer,ret_code varchar,ret_msg varchar,channel integer)");
        }
    }

    private final void dropTable(SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726300733")) {
            ipChange.ipc$dispatch("1726300733", new Object[]{this, sQLiteDatabase});
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS data_cache");
        }
    }

    private final void upgradeDatabaseToVersion2(SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738182352")) {
            ipChange.ipc$dispatch("-1738182352", new Object[]{this, sQLiteDatabase});
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE data_cache RENAME TO tmp_data_cache");
        createDataCacheTable(sQLiteDatabase);
        sQLiteDatabase.execSQL("INSERT INTO data_cache(_id, type, content, timestamp, expire, retcode, ret_msg, channel) SELECT _id, type, content, timestamp, expire, ret_code, ret_msg, channel from tmp_data_cache");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tmp_data_cache");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(@NotNull SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1424680939")) {
            ipChange.ipc$dispatch("-1424680939", new Object[]{this, sQLiteDatabase});
            return;
        }
        b41.i(sQLiteDatabase, "db");
        sQLiteDatabase.enableWriteAheadLogging();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089881019")) {
            ipChange.ipc$dispatch("-2089881019", new Object[]{this, sQLiteDatabase});
            return;
        }
        b41.i(sQLiteDatabase, "db");
        createDataCacheTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878917126")) {
            ipChange.ipc$dispatch("878917126", new Object[]{this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(sQLiteDatabase, "db");
        sQLiteDatabase.beginTransaction();
        try {
            dropTable(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029076737")) {
            ipChange.ipc$dispatch("-2029076737", new Object[]{this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(sQLiteDatabase, "db");
        if (i != 1 || i2 <= 1) {
            return;
        }
        sQLiteDatabase.beginTransaction();
        try {
            upgradeDatabaseToVersion2(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }
}
