package com.youku.gaiax.provider.module.source.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Database(entities = {YKTemplateEntity.class, YKAssetsTemplateEntity.class}, version = 6)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/YKDB;", "Landroidx/room/RoomDatabase;", "Lcom/youku/gaiax/provider/module/source/db/RemoteTemplateDAO;", "remoteDao", "Lcom/youku/gaiax/provider/module/source/db/AssetsTemplateDAO;", "assetsDao", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class YKDB extends RoomDatabase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String DATABASE_NAME = "yk_gaiax.db";
    @Nullable
    private static volatile YKDB instance;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/YKDB$Companion;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/gaiax/provider/module/source/db/YKDB;", "buildDatabase", "instance", "", "DATABASE_NAME", "Ljava/lang/String;", "Lcom/youku/gaiax/provider/module/source/db/YKDB;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        private final YKDB buildDatabase(Context context) {
            RoomDatabase build = Room.databaseBuilder(context, YKDB.class, YKDB.DATABASE_NAME).fallbackToDestructiveMigration().setJournalMode(RoomDatabase.JournalMode.TRUNCATE).build();
            b41.h(build, "databaseBuilder(context,…\n                .build()");
            return (YKDB) build;
        }

        @NotNull
        public final YKDB instance(@NotNull Context context) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            YKDB ykdb = YKDB.instance;
            if (ykdb == null) {
                synchronized (this) {
                    ykdb = YKDB.instance;
                    if (ykdb == null) {
                        YKDB buildDatabase = YKDB.Companion.buildDatabase(context);
                        YKDB.instance = buildDatabase;
                        ykdb = buildDatabase;
                    }
                }
            }
            return ykdb;
        }
    }

    @NotNull
    public abstract AssetsTemplateDAO assetsDao();

    @NotNull
    public abstract RemoteTemplateDAO remoteDao();
}
