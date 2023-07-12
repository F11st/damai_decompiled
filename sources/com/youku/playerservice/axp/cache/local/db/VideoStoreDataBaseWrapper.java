package com.youku.playerservice.axp.cache.local.db;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.youku.playerservice.axp.cache.local.db.converter.DateConverter;
import com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao;
import com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity;
import com.youku.util.Logger;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class VideoStoreDataBaseWrapper {
    public static final String DATABASE_NAME = "playLocalDB";
    private static AbstractStorageVideoStoreDataBase INSTANCE;

    /* compiled from: Taobao */
    @TypeConverters({DateConverter.class})
    @Database(entities = {VideoUpsInfoEntity.class}, version = 1)
    /* loaded from: classes3.dex */
    public static abstract class AbstractStorageVideoStoreDataBase extends RoomDatabase {
        public abstract VideoStoreDao videoUpsInfoDao();
    }

    public static AbstractStorageVideoStoreDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AbstractStorageVideoStoreDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = (AbstractStorageVideoStoreDataBase) Room.databaseBuilder(context.getApplicationContext(), AbstractStorageVideoStoreDataBase.class, DATABASE_NAME).allowMainThreadQueries().addCallback(new RoomDatabase.Callback() { // from class: com.youku.playerservice.axp.cache.local.db.VideoStoreDataBaseWrapper.1
                        @Override // androidx.room.RoomDatabase.Callback
                        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                            if (Logger.DEBUG) {
                                Logger.e(VideoStoreDataBaseWrapper.DATABASE_NAME, "AbstractStorageVideoStoreDataBase Has Create");
                            }
                            super.onCreate(supportSQLiteDatabase);
                        }

                        @Override // androidx.room.RoomDatabase.Callback
                        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                            if (Logger.DEBUG) {
                                Logger.e(VideoStoreDataBaseWrapper.DATABASE_NAME, "AbstractStorageVideoStoreDataBase Has Opened");
                            }
                            super.onOpen(supportSQLiteDatabase);
                        }
                    }).build();
                }
            }
        }
        return INSTANCE;
    }
}
