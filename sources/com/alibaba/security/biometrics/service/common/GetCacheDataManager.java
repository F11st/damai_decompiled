package com.alibaba.security.biometrics.service.common;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GetCacheDataManager {
    private static volatile GetCacheDataManager mInstance;
    private String mUmidToken;
    private boolean mUseHwMagicWindow;
    private boolean mUseLiteVm;
    private boolean mNeedCollectLocalImage = true;
    private long uploadTimeOut = 30;

    private GetCacheDataManager() {
    }

    public static GetCacheDataManager getInstance() {
        if (mInstance == null) {
            synchronized (GetCacheDataManager.class) {
                if (mInstance == null) {
                    mInstance = new GetCacheDataManager();
                }
            }
        }
        return mInstance;
    }

    public String getUmidToken() {
        return this.mUmidToken;
    }

    public long getUploadTimeOut() {
        return this.uploadTimeOut;
    }

    public boolean getUseHwMagicWindow() {
        return this.mUseHwMagicWindow;
    }

    public boolean isNeedCollectLocalImage() {
        return this.mNeedCollectLocalImage;
    }

    public boolean isUseLiteVm() {
        return this.mUseLiteVm;
    }

    public void setNeedCollectLocalImage(boolean z) {
        this.mNeedCollectLocalImage = z;
    }

    public void setUmidToken(String str) {
        this.mUmidToken = str;
    }

    public void setUploadTimeOut(String str) {
        try {
            this.uploadTimeOut = Long.parseLong(str);
        } catch (Throwable unused) {
            this.uploadTimeOut = 30L;
        }
    }

    public void setUseHwMagicWindow(boolean z) {
        this.mUseHwMagicWindow = z;
    }

    public void setUseLiteVm(boolean z) {
        this.mUseLiteVm = z;
    }
}
