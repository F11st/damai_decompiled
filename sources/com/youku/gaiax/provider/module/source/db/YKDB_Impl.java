package com.youku.gaiax.provider.module.source.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class YKDB_Impl extends YKDB {
    private volatile AssetsTemplateDAO _assetsTemplateDAO;
    private volatile RemoteTemplateDAO _remoteTemplateDAO;

    @Override // com.youku.gaiax.provider.module.source.db.YKDB
    public AssetsTemplateDAO assetsDao() {
        AssetsTemplateDAO assetsTemplateDAO;
        if (this._assetsTemplateDAO != null) {
            return this._assetsTemplateDAO;
        }
        synchronized (this) {
            if (this._assetsTemplateDAO == null) {
                this._assetsTemplateDAO = new AssetsTemplateDAO_Impl(this);
            }
            assetsTemplateDAO = this._assetsTemplateDAO;
        }
        return assetsTemplateDAO;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `yk_template_v2`");
            writableDatabase.execSQL("DELETE FROM `yk_assets_template_v1`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "yk_template_v2", "yk_assets_template_v1");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(6) { // from class: com.youku.gaiax.provider.module.source.db.YKDB_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `yk_template_v2` (`template_id` TEXT NOT NULL, `template_version` INTEGER NOT NULL, `template_biz` TEXT NOT NULL, `template_platform` TEXT NOT NULL, `template_desc` TEXT NOT NULL, `template_resource_url` TEXT NOT NULL, `template_local_url` TEXT NOT NULL, `template_priority` TEXT NOT NULL, `template_support_min_version` INTEGER NOT NULL, `template_support_max_version` INTEGER NOT NULL, `template_createtime` TEXT NOT NULL, `template_modifytime` TEXT NOT NULL, `template_create_empid` TEXT NOT NULL, `template_modify_empid` TEXT NOT NULL, `template_release_status` TEXT NOT NULL, `template_ext_info` TEXT NOT NULL, `template_fileType` TEXT NOT NULL, PRIMARY KEY(`template_id`, `template_version`, `template_biz`, `template_platform`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `yk_assets_template_v1` (`template_id` TEXT NOT NULL, `template_biz` TEXT NOT NULL, `template_local_url` TEXT NOT NULL, `template_app_version` INTEGER NOT NULL, PRIMARY KEY(`template_id`, `template_biz`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '283564bffa5c7922fa1dee7baa4f0ae4')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `yk_template_v2`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `yk_assets_template_v1`");
                if (((RoomDatabase) YKDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) YKDB_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) YKDB_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) YKDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) YKDB_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) YKDB_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) YKDB_Impl.this).mDatabase = supportSQLiteDatabase;
                YKDB_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) YKDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) YKDB_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) YKDB_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(17);
                hashMap.put("template_id", new TableInfo.Column("template_id", "TEXT", true, 1, null, 1));
                hashMap.put("template_version", new TableInfo.Column("template_version", "INTEGER", true, 2, null, 1));
                hashMap.put("template_biz", new TableInfo.Column("template_biz", "TEXT", true, 3, null, 1));
                hashMap.put("template_platform", new TableInfo.Column("template_platform", "TEXT", true, 4, null, 1));
                hashMap.put("template_desc", new TableInfo.Column("template_desc", "TEXT", true, 0, null, 1));
                hashMap.put("template_resource_url", new TableInfo.Column("template_resource_url", "TEXT", true, 0, null, 1));
                hashMap.put("template_local_url", new TableInfo.Column("template_local_url", "TEXT", true, 0, null, 1));
                hashMap.put("template_priority", new TableInfo.Column("template_priority", "TEXT", true, 0, null, 1));
                hashMap.put("template_support_min_version", new TableInfo.Column("template_support_min_version", "INTEGER", true, 0, null, 1));
                hashMap.put("template_support_max_version", new TableInfo.Column("template_support_max_version", "INTEGER", true, 0, null, 1));
                hashMap.put("template_createtime", new TableInfo.Column("template_createtime", "TEXT", true, 0, null, 1));
                hashMap.put("template_modifytime", new TableInfo.Column("template_modifytime", "TEXT", true, 0, null, 1));
                hashMap.put("template_create_empid", new TableInfo.Column("template_create_empid", "TEXT", true, 0, null, 1));
                hashMap.put("template_modify_empid", new TableInfo.Column("template_modify_empid", "TEXT", true, 0, null, 1));
                hashMap.put("template_release_status", new TableInfo.Column("template_release_status", "TEXT", true, 0, null, 1));
                hashMap.put("template_ext_info", new TableInfo.Column("template_ext_info", "TEXT", true, 0, null, 1));
                hashMap.put("template_fileType", new TableInfo.Column("template_fileType", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("yk_template_v2", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "yk_template_v2");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "yk_template_v2(com.youku.gaiax.provider.module.source.db.YKTemplateEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("template_id", new TableInfo.Column("template_id", "TEXT", true, 1, null, 1));
                hashMap2.put("template_biz", new TableInfo.Column("template_biz", "TEXT", true, 2, null, 1));
                hashMap2.put("template_local_url", new TableInfo.Column("template_local_url", "TEXT", true, 0, null, 1));
                hashMap2.put("template_app_version", new TableInfo.Column("template_app_version", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("yk_assets_template_v1", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "yk_assets_template_v1");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "yk_assets_template_v1(com.youku.gaiax.provider.module.source.db.YKAssetsTemplateEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "283564bffa5c7922fa1dee7baa4f0ae4", "d106f35c430d5831be92dc58bbfa6076")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(RemoteTemplateDAO.class, RemoteTemplateDAO_Impl.getRequiredConverters());
        hashMap.put(AssetsTemplateDAO.class, AssetsTemplateDAO_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // com.youku.gaiax.provider.module.source.db.YKDB
    public RemoteTemplateDAO remoteDao() {
        RemoteTemplateDAO remoteTemplateDAO;
        if (this._remoteTemplateDAO != null) {
            return this._remoteTemplateDAO;
        }
        synchronized (this) {
            if (this._remoteTemplateDAO == null) {
                this._remoteTemplateDAO = new RemoteTemplateDAO_Impl(this);
            }
            remoteTemplateDAO = this._remoteTemplateDAO;
        }
        return remoteTemplateDAO;
    }
}
