package com.youku.playerservice.axp.cache.local.db.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity;
import java.util.ArrayList;
import java.util.List;
import tb.h23;
import tb.op2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VideoStoreDao_Impl implements VideoStoreDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfVideoUpsInfoEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCache;
    private final SharedSQLiteStatement __preparedStmtOfDeleteExpiredCache;

    public VideoStoreDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfVideoUpsInfoEntity = new EntityInsertionAdapter<VideoUpsInfoEntity>(roomDatabase) { // from class: com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao_Impl.1
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoUpsInfoEntity videoUpsInfoEntity) {
                if (videoUpsInfoEntity.getInfoID() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, videoUpsInfoEntity.getInfoID());
                }
                if (videoUpsInfoEntity.getPlayType() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, videoUpsInfoEntity.getPlayType());
                }
                if (videoUpsInfoEntity.getRequestMode() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, videoUpsInfoEntity.getRequestMode());
                }
                if (videoUpsInfoEntity.getExtraParams() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, videoUpsInfoEntity.getExtraParams());
                }
                if (videoUpsInfoEntity.getRawData() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, videoUpsInfoEntity.getRawData());
                }
                if (videoUpsInfoEntity.getExtraData() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, videoUpsInfoEntity.getExtraData());
                }
                if (videoUpsInfoEntity.getPlayContentData() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, videoUpsInfoEntity.getPlayContentData());
                }
                if (videoUpsInfoEntity.getExpiredTime() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, videoUpsInfoEntity.getExpiredTime().longValue());
                }
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ups_info_cache_data`(`infoID`,`playType`,`requestMode`,`extraParams`,`rawData`,`extraData`,`playContentData`,`expiredTime`) VALUES (?,?,?,?,?,?,?,?)";
            }
        };
        this.__preparedStmtOfDeleteExpiredCache = new SharedSQLiteStatement(roomDatabase) { // from class: com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ups_info_cache_data WHERE expiredTime < ? OR expiredTime is null";
            }
        };
        this.__preparedStmtOfDeleteCache = new SharedSQLiteStatement(roomDatabase) { // from class: com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ups_info_cache_data WHERE infoID = ?";
            }
        };
    }

    @Override // com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao
    public void deleteCache(String str) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteCache.acquire();
        this.__db.beginTransaction();
        try {
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteCache.release(acquire);
        }
    }

    @Override // com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao
    public void deleteExpiredCache(long j) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteExpiredCache.acquire();
        this.__db.beginTransaction();
        try {
            acquire.bindLong(1, j);
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteExpiredCache.release(acquire);
        }
    }

    @Override // com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao
    public List<VideoUpsInfoEntity> getUpsCacheData(String str, long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ups_info_cache_data WHERE infoID = ? AND expiredTime > ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("infoID");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("playType");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("requestMode");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow(op2.KEY_EXTRA_PARAMS);
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("rawData");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow(h23.EXTRA_DATA_DIMEN);
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("playContentData");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("expiredTime");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                VideoUpsInfoEntity videoUpsInfoEntity = new VideoUpsInfoEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3));
                videoUpsInfoEntity.setExtraParams(query.getString(columnIndexOrThrow4));
                videoUpsInfoEntity.setRawData(query.getString(columnIndexOrThrow5));
                videoUpsInfoEntity.setExtraData(query.getString(columnIndexOrThrow6));
                videoUpsInfoEntity.setPlayContentData(query.getString(columnIndexOrThrow7));
                videoUpsInfoEntity.setExpiredTime(query.isNull(columnIndexOrThrow8) ? null : Long.valueOf(query.getLong(columnIndexOrThrow8)));
                arrayList.add(videoUpsInfoEntity);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao
    public List<VideoUpsInfoEntity> getUpsCacheData(List<String> list, long j) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM ups_info_cache_data WHERE infoID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND expiredTime > ");
        newStringBuilder.append("?");
        int i = 1;
        int i2 = size + 1;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), i2);
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        acquire.bindLong(i2, j);
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("infoID");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("playType");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("requestMode");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow(op2.KEY_EXTRA_PARAMS);
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("rawData");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow(h23.EXTRA_DATA_DIMEN);
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("playContentData");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("expiredTime");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                VideoUpsInfoEntity videoUpsInfoEntity = new VideoUpsInfoEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3));
                videoUpsInfoEntity.setExtraParams(query.getString(columnIndexOrThrow4));
                videoUpsInfoEntity.setRawData(query.getString(columnIndexOrThrow5));
                videoUpsInfoEntity.setExtraData(query.getString(columnIndexOrThrow6));
                videoUpsInfoEntity.setPlayContentData(query.getString(columnIndexOrThrow7));
                videoUpsInfoEntity.setExpiredTime(query.isNull(columnIndexOrThrow8) ? null : Long.valueOf(query.getLong(columnIndexOrThrow8)));
                arrayList.add(videoUpsInfoEntity);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao
    public void insertUpsCacheData(List<VideoUpsInfoEntity> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfVideoUpsInfoEntity.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
