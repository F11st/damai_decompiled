package com.youku.playerservice.axp.cache.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity;
import java.util.List;

/* compiled from: Taobao */
@Dao
/* loaded from: classes13.dex */
public interface VideoStoreDao {
    @Query("DELETE FROM ups_info_cache_data WHERE infoID = :infoID")
    void deleteCache(String str);

    @Query("DELETE FROM ups_info_cache_data WHERE expiredTime < :checkTime OR expiredTime is null")
    void deleteExpiredCache(long j);

    @Query("SELECT * FROM ups_info_cache_data WHERE infoID = :infoID AND expiredTime > :checkTime")
    List<VideoUpsInfoEntity> getUpsCacheData(String str, long j);

    @Query("SELECT * FROM ups_info_cache_data WHERE infoID IN (:infoIDs) AND expiredTime > :checkTime")
    List<VideoUpsInfoEntity> getUpsCacheData(List<String> list, long j);

    @Insert(onConflict = 1)
    void insertUpsCacheData(List<VideoUpsInfoEntity> list);
}
