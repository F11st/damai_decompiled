package com.youku.playerservice.axp.cache.local.db.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;

/* compiled from: Taobao */
@Entity(primaryKeys = {"infoID", "playType"}, tableName = "ups_info_cache_data")
/* loaded from: classes13.dex */
public class VideoUpsInfoEntity {
    private Long expiredTime;
    private String extraData;
    private String extraParams;
    @NonNull
    private String infoID;
    private String playContentData;
    @NonNull
    private String playType;
    private String rawData;
    @NonNull
    private String requestMode;

    public VideoUpsInfoEntity(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.infoID = str;
        this.playType = str2;
        this.requestMode = str3;
    }

    public Long getExpiredTime() {
        return this.expiredTime;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public String getExtraParams() {
        return this.extraParams;
    }

    @NonNull
    public String getInfoID() {
        return this.infoID;
    }

    public String getPlayContentData() {
        return this.playContentData;
    }

    @NonNull
    public String getPlayType() {
        return this.playType;
    }

    public String getRawData() {
        return this.rawData;
    }

    @NonNull
    public String getRequestMode() {
        return this.requestMode;
    }

    public void setExpiredTime(Long l) {
        this.expiredTime = l;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public void setExtraParams(String str) {
        this.extraParams = str;
    }

    public void setInfoID(@NonNull String str) {
        this.infoID = str;
    }

    public void setPlayContentData(String str) {
        this.playContentData = str;
    }

    public void setPlayType(@NonNull String str) {
        this.playType = str;
    }

    public void setRawData(String str) {
        this.rawData = str;
    }

    public void setRequestMode(@NonNull String str) {
        this.requestMode = str;
    }

    public String toString() {
        return "VideoUpsInfoEntity{infoID='" + this.infoID + "', playType='" + this.playType + "', requestMode='" + this.requestMode + "', extraParams='" + this.extraParams + "', extraData='" + this.extraData + "', expiredTime=" + this.expiredTime + '}';
    }
}
