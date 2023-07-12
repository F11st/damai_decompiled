package com.youku.vpm.track.ad;

import android.text.TextUtils;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.param.CustomParams;
import com.youku.vpm.track.Track;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AdTrack {
    private AdErrorTrack mAdErrorTrack;
    private AdImpairmentTrack mAdImpairmentTrack;
    private AdPlayTrack mAdPlayTrack;
    private long mEndPreAdTime;
    private boolean mIsMidAdShowing;
    private boolean mIsPostAdShowing;
    private boolean mIsPreAdShowing;
    private long mStartPreAdTime;
    private Track mTrack;
    private int mAdType = 1;
    private String beforeDurationAdtype = "无广告";

    public AdTrack(Track track) {
        this.mTrack = track;
        this.mAdPlayTrack = new AdPlayTrack(track);
        this.mAdErrorTrack = new AdErrorTrack(track);
    }

    private int getAdTypeByArg(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return i == 3 ? 3 : 4;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    private boolean isAdPlayError(int i) {
        return i == 0 || i == 0 || i == 0 || i == 0 || (i == 0 && isAdShowing()) || ((i == 0 && isMidAdShowing()) || ((i == 0 && (isAdShowing() || isMidAdShowing())) || ((i == 0 && (isAdShowing() || isMidAdShowing())) || (i == 0 && (isAdShowing() || isMidAdShowing())))));
    }

    public int getAdType() {
        return this.mAdType;
    }

    public int getAdTypeForVpm() {
        if (isPreAdShowing()) {
            return 1;
        }
        if (isPostAdShowing()) {
            return 3;
        }
        isMidAdShowing();
        return 2;
    }

    public String getBeforeDurationAdtype() {
        return this.beforeDurationAdtype;
    }

    public long getEndPreAdTime() {
        return this.mEndPreAdTime;
    }

    public boolean isAdShowing() {
        return this.mIsMidAdShowing || this.mIsPreAdShowing || this.mIsPostAdShowing;
    }

    public boolean isMidAdShowing() {
        return this.mIsMidAdShowing;
    }

    public boolean isPostAdShowing() {
        return this.mIsPostAdShowing;
    }

    public boolean isPreAdShowing() {
        return this.mIsPreAdShowing;
    }

    public void onEndLoading() {
        AdImpairmentTrack adImpairmentTrack = this.mAdImpairmentTrack;
        if (adImpairmentTrack != null) {
            adImpairmentTrack.commit();
        }
    }

    public boolean onError(int i, int i2, Object obj) {
        if (isAdPlayError(i)) {
            this.mAdErrorTrack.commit(getAdTypeForVpm(), i2);
            return true;
        }
        return false;
    }

    public void onMidAdStart(int i, IVpmFullInfo iVpmFullInfo) {
        this.mAdPlayTrack.commit(2, i);
    }

    public void onPreAdEnd(int i) {
        this.mEndPreAdTime = getCurrentTime();
    }

    public void onPreAdStart(int i) {
        this.beforeDurationAdtype = "视频";
        if (this.mStartPreAdTime == 0) {
            this.mStartPreAdTime = getCurrentTime();
        }
        this.mAdPlayTrack.commit(1, i);
    }

    public void onRealVideoStart() {
        this.mAdType = 0;
    }

    public void onStartLoading(int i) {
        this.mAdImpairmentTrack = new AdImpairmentTrack(this.mTrack, getAdTypeByArg(i));
    }

    public void onStartPlayPostAD(int i) {
        this.mAdPlayTrack.commit(3, i);
    }

    public void onVideoSliceStart(int i, int i2, Object obj) {
        if (this.mAdPlayTrack == null) {
            return;
        }
        String value = new CustomParams(String.valueOf(obj)).getValue("url");
        if (TextUtils.isEmpty(value)) {
            return;
        }
        if (value.contains("/ad/") || value.contains("ccode=0902")) {
            this.mAdPlayTrack.commit(4, i);
        }
    }
}
