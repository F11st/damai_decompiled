package com.youku.playerservice.axp.cache.local;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.youku.playerservice.axp.cache.local.db.VideoStoreDataBaseWrapper;
import com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao;
import com.youku.playerservice.axp.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class SimpleLocalDataStorage {
    public static final String TAG = "AXP_LOCAL";
    private static SimpleLocalDataStorage sInstance;
    private final VideoStoreDataBaseWrapper.AbstractStorageVideoStoreDataBase mVideoStore;
    private VideoStoreDao mVideoUpsStoreDao;

    private SimpleLocalDataStorage(Application application) {
        this.mVideoStore = VideoStoreDataBaseWrapper.getDatabase(application);
        initDatabase();
    }

    @Nullable
    public static SimpleLocalDataStorage getInstance() {
        SimpleLocalDataStorage simpleLocalDataStorage = sInstance;
        if (simpleLocalDataStorage != null) {
            return simpleLocalDataStorage;
        }
        throw new Exception("LocalDataRepository hasn't Init!");
    }

    public static SimpleLocalDataStorage initInstance(Context context) {
        if (context instanceof Application) {
            if (sInstance == null) {
                synchronized (SimpleLocalDataStorage.class) {
                    if (sInstance == null) {
                        sInstance = new SimpleLocalDataStorage((Application) context);
                    }
                }
            } else if (Logger.DEBUG) {
                Logger.d(TAG, "LocalDataRepository has init!");
            }
            return sInstance;
        }
        throw new Exception("LocalDataRepository only accept Application to init");
    }

    public VideoStoreDao getVideoUpsInfoDao() {
        return this.mVideoUpsStoreDao;
    }

    protected void initDatabase() {
        this.mVideoUpsStoreDao = this.mVideoStore.videoUpsInfoDao();
    }
}
