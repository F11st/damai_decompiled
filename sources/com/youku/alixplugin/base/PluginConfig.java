package com.youku.alixplugin.base;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PluginConfig {
    private boolean mEnable;
    private String mLayerId;
    private boolean mLazyLoad;
    private int mMajorLevel;
    private int mMinorLevel;
    private String mName;
    private boolean mOnDemondLoad;
    private int mPlayerIndex;

    public PluginConfig() {
        this.mLazyLoad = false;
        this.mOnDemondLoad = false;
        this.mPlayerIndex = -1;
    }

    public String getLayerId() {
        return this.mLayerId;
    }

    public int getMajorLevel() {
        return this.mMajorLevel;
    }

    public int getMinorLevel() {
        return this.mMinorLevel;
    }

    public String getName() {
        return this.mName;
    }

    public int getPlayerIndex() {
        return this.mPlayerIndex;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isLazyLoad() {
        return this.mLazyLoad;
    }

    public boolean isOnDemondLoad() {
        return this.mOnDemondLoad;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setLayerId(String str) {
        this.mLayerId = str;
    }

    public void setLazyLoad(boolean z) {
        this.mLazyLoad = z;
    }

    public void setMajorLevel(int i) {
        this.mMajorLevel = i;
    }

    public void setMinorLevel(int i) {
        this.mMinorLevel = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOnDemondLoad(boolean z) {
        this.mOnDemondLoad = z;
    }

    public void setPlayerIndex(int i) {
        this.mPlayerIndex = i;
    }

    public PluginConfig(String str, String str2, int i, boolean z) {
        this(str, str2, i, 0, z);
    }

    public PluginConfig(String str, String str2, int i, int i2, boolean z) {
        this.mLazyLoad = false;
        this.mOnDemondLoad = false;
        this.mPlayerIndex = -1;
        setName(str);
        setLayerId(str2);
        setEnable(z);
        setMajorLevel(i);
        setMinorLevel(i2);
    }
}
