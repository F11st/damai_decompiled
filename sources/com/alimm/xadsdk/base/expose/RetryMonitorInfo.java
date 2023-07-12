package com.alimm.xadsdk.base.expose;

import android.database.Cursor;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RetryMonitorInfo {
    private int mAdType;
    private String mCreativeId;
    private String mDate;
    private long mExpireTime;
    private String mGroupId;
    private long mId;
    private String mImpressionId;
    private String mMonitorSdk;
    private String mMonitorType;
    private String mMonitorUrl;
    private int mRetryTimes;

    public RetryMonitorInfo() {
    }

    public RetryMonitorInfo(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, long j) {
        this.mAdType = i;
        this.mImpressionId = str;
        this.mCreativeId = str2;
        this.mGroupId = str3;
        this.mMonitorType = str4;
        this.mMonitorSdk = str5;
        this.mMonitorUrl = str6;
        this.mRetryTimes = i2;
        this.mDate = Utils.formatTimeInMillis(j, RetryMonitorDbHelper.DATE_FORMAT);
        this.mExpireTime = j + 86400000;
    }

    public RetryMonitorInfo(@NonNull Cursor cursor) {
        this.mId = cursor.getLong(cursor.getColumnIndex("id"));
        this.mAdType = cursor.getInt(cursor.getColumnIndex("ad_type"));
        this.mCreativeId = cursor.getString(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_CREATIVE_ID));
        this.mGroupId = cursor.getString(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_GROUP_ID));
        this.mImpressionId = cursor.getString(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_IMPRESSION_ID));
        this.mMonitorType = cursor.getString(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_MONITOR_TYPE));
        this.mMonitorSdk = cursor.getString(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_MONITOR_SDK));
        this.mMonitorUrl = cursor.getString(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_MONITOR_URL));
        this.mRetryTimes = cursor.getInt(cursor.getColumnIndex(RetryMonitorDbHelper.COLUMN_RETRY_TIMES));
        this.mDate = cursor.getString(cursor.getColumnIndex("date"));
        this.mExpireTime = cursor.getLong(cursor.getColumnIndex("expire_time"));
    }

    public int getAdType() {
        return this.mAdType;
    }

    public String getCreativeId() {
        return this.mCreativeId;
    }

    public String getDate() {
        return this.mDate;
    }

    public long getExpireTime() {
        return this.mExpireTime;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public long getId() {
        return this.mId;
    }

    public String getImpressionId() {
        return this.mImpressionId;
    }

    public String getMonitorSdk() {
        return this.mMonitorSdk;
    }

    public String getMonitorType() {
        return this.mMonitorType;
    }

    public String getMonitorUrl() {
        return this.mMonitorUrl;
    }

    public int getRetryTimes() {
        return this.mRetryTimes;
    }

    public RetryMonitorInfo incRetryTimes() {
        this.mRetryTimes++;
        return this;
    }

    public RetryMonitorInfo setAdType(int i) {
        this.mAdType = i;
        return this;
    }

    public RetryMonitorInfo setCreativeId(String str) {
        this.mCreativeId = str;
        return this;
    }

    public RetryMonitorInfo setDate(long j) {
        this.mDate = Utils.formatTimeInMillis(j, RetryMonitorDbHelper.DATE_FORMAT);
        return this;
    }

    public RetryMonitorInfo setExpireTime(long j) {
        this.mExpireTime = j;
        return this;
    }

    public RetryMonitorInfo setGroupId(String str) {
        this.mGroupId = str;
        return this;
    }

    public RetryMonitorInfo setId(long j) {
        this.mId = j;
        return this;
    }

    public RetryMonitorInfo setImpressionId(String str) {
        this.mImpressionId = str;
        return this;
    }

    public RetryMonitorInfo setMonitorSdk(String str) {
        this.mMonitorSdk = str;
        return this;
    }

    public RetryMonitorInfo setMonitorType(String str) {
        this.mMonitorType = str;
        return this;
    }

    public RetryMonitorInfo setMonitorUrl(String str) {
        this.mMonitorUrl = str;
        return this;
    }

    public RetryMonitorInfo setRetryTimes(int i) {
        this.mRetryTimes = i;
        return this;
    }

    public String toString() {
        return "RMI{adType=" + this.mAdType + ",impId=" + this.mImpressionId + ",ie=" + this.mCreativeId + ",ca=" + this.mGroupId + ",type=" + this.mMonitorType + ",sdk=" + this.mMonitorSdk + ",url=" + this.mMonitorUrl + ",retry=" + this.mRetryTimes + ",date=" + this.mDate + ",expire=" + this.mExpireTime + "}";
    }
}
