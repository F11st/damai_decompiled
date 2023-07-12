package com.alimm.xadsdk.base.model;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CreativeItem implements BaseInfo {
    private static final String TAG = "CreativeItem";
    @JSONField(name = "cache_key")
    private String mCacheKey;
    @JSONField(name = "md5")
    private String mContentMd5;
    @JSONField(name = "duration")
    private int mDuration;
    @JSONField(name = "height")
    private int mHeight;
    @JSONField(serialize = false)
    private String mName;
    @JSONField(name = "type")
    private String mType;
    @JSONField(name = "value")
    private String mUrl;
    @JSONField(name = "vid")
    private String mVideoId;
    @JSONField(name = "width")
    private int mWidth;

    private void ensureNameNotNull() {
        if (this.mName == null) {
            this.mName = !TextUtils.isEmpty(this.mUrl) ? Utils.md5(this.mUrl) : "";
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "ensureNameNotNull: mName = " + this.mName + ", mUrl = " + this.mUrl);
            }
        }
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public String getContentMd5() {
        return this.mContentMd5;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getName() {
        if (TextUtils.isEmpty(this.mCacheKey)) {
            if (TextUtils.isEmpty(this.mVideoId)) {
                ensureNameNotNull();
                return this.mName;
            }
            return this.mVideoId;
        }
        return this.mCacheKey;
    }

    public String getType() {
        return this.mType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public CreativeItem setCacheKey(String str) {
        this.mCacheKey = str;
        return this;
    }

    public CreativeItem setContentMd5(String str) {
        this.mContentMd5 = str;
        return this;
    }

    public CreativeItem setDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public CreativeItem setHeight(int i) {
        this.mHeight = i;
        return this;
    }

    public CreativeItem setType(String str) {
        this.mType = str;
        return this;
    }

    public CreativeItem setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public CreativeItem setVideoId(String str) {
        this.mVideoId = str;
        return this;
    }

    public CreativeItem setWidth(int i) {
        this.mWidth = i;
        return this;
    }
}
