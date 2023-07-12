package com.youku.playerservice.axp.cache.local.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.youku.playerservice.axp.cache.local.db.VideoStoreDataBaseWrapper;
import com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao;
import com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao_Impl;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.lang3.StringUtils;
import tb.h23;
import tb.op2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl extends VideoStoreDataBaseWrapper.AbstractStorageVideoStoreDataBase {
    private volatile VideoStoreDao _videoStoreDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ups_info_cache_data`");
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
        return new InvalidationTracker(this, "ups_info_cache_data");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.youku.playerservice.axp.cache.local.db.VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ups_info_cache_data` (`infoID` TEXT NOT NULL, `playType` TEXT NOT NULL, `requestMode` TEXT NOT NULL, `extraParams` TEXT, `rawData` TEXT, `extraData` TEXT, `playContentData` TEXT, `expiredTime` INTEGER, PRIMARY KEY(`infoID`, `playType`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"9925bf21ab58174c8e5835fd7e9a0a3c\")");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ups_info_cache_data`");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mDatabase = supportSQLiteDatabase;
                VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) VideoStoreDataBaseWrapper_AbstractStorageVideoStoreDataBase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(8);
                hashMap.put("infoID", new TableInfo.Column("infoID", "TEXT", true, 1));
                hashMap.put("playType", new TableInfo.Column("playType", "TEXT", true, 2));
                hashMap.put("requestMode", new TableInfo.Column("requestMode", "TEXT", true, 0));
                hashMap.put(op2.KEY_EXTRA_PARAMS, new TableInfo.Column(op2.KEY_EXTRA_PARAMS, "TEXT", false, 0));
                hashMap.put("rawData", new TableInfo.Column("rawData", "TEXT", false, 0));
                hashMap.put(h23.EXTRA_DATA_DIMEN, new TableInfo.Column(h23.EXTRA_DATA_DIMEN, "TEXT", false, 0));
                hashMap.put("playContentData", new TableInfo.Column("playContentData", "TEXT", false, 0));
                hashMap.put("expiredTime", new TableInfo.Column("expiredTime", "INTEGER", false, 0));
                TableInfo tableInfo = new TableInfo("ups_info_cache_data", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "ups_info_cache_data");
                if (tableInfo.equals(read)) {
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle ups_info_cache_data(com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity).\n Expected:\n" + tableInfo + StringUtils.LF + " Found:\n" + read);
            }
        }, "9925bf21ab58174c8e5835fd7e9a0a3c", "4581650e25a566c2d95c13a66c7637ec")).build());
    }

    @Override // com.youku.playerservice.axp.cache.local.db.VideoStoreDataBaseWrapper.AbstractStorageVideoStoreDataBase
    public VideoStoreDao videoUpsInfoDao() {
        VideoStoreDao videoStoreDao;
        if (this._videoStoreDao != null) {
            return this._videoStoreDao;
        }
        synchronized (this) {
            if (this._videoStoreDao == null) {
                this._videoStoreDao = new VideoStoreDao_Impl(this);
            }
            videoStoreDao = this._videoStoreDao;
        }
        return videoStoreDao;
    }
}
