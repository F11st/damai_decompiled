package com.alipay.camera2;

import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraFocusStateDescription {
    public int mActiveScanFrameCount;
    public int mFocusFailedFrameCount;
    public int mFocusNotStartedFrameCount;
    public String mFocusStateHistory;
    public long mFrameCount;
    public float mHyperFocusDistance;
    public boolean mInitFocusDistanceMatched;
    public float mLastFocusDistance;
    public int mPassiveScanFrameCount;
    public String mPhoneMovementState;
    public int mSameFocusDistanceFrameCount;
    public boolean mSupportControlFocusDistance;
    public float mMaxProportion = -1.0f;
    public float mMaxProportionFocusDistance = -1.0f;
    public float mMaxProportionFocusDistanceForFirstSecond = -1.0f;
    public float mMaxProportionForFirstSecond = -1.0f;
    public float mHistoryAvgSuccessfulFocusDistance = -1.0f;
    public long mHistorySuccessfulFocusDistanceCount = -1;
    public float mMaxFocusDistance = -1.0f;

    public CameraFocusStateDescription(long j, boolean z, float f, float f2, int i, int i2, String str, int i3, int i4, int i5, boolean z2, String str2) {
        this.mFrameCount = j;
        this.mSupportControlFocusDistance = z;
        this.mHyperFocusDistance = f;
        this.mLastFocusDistance = f2;
        this.mFocusNotStartedFrameCount = i;
        this.mFocusFailedFrameCount = i2;
        this.mFocusStateHistory = str;
        this.mActiveScanFrameCount = i3;
        this.mPassiveScanFrameCount = i4;
        this.mSameFocusDistanceFrameCount = i5;
        this.mInitFocusDistanceMatched = z2;
        this.mPhoneMovementState = str2;
    }

    public void setHistoryAvgSuccessfulFocusDistance(float f) {
        this.mHistoryAvgSuccessfulFocusDistance = f;
    }

    public void setHistorySuccessfulFocusDistanceCount(long j) {
        this.mHistorySuccessfulFocusDistanceCount = j;
    }

    public void setMaxFocusDistance(float f) {
        this.mMaxFocusDistance = f;
    }

    public void setMaxProportion(float f) {
        this.mMaxProportion = f;
    }

    public void setMaxProportionFocusDistance(float f) {
        this.mMaxProportionFocusDistance = f;
    }

    public void setMaxProportionFocusDistanceForFirstSecond(float f) {
        this.mMaxProportionFocusDistanceForFirstSecond = f;
    }

    public void setMaxProportionForFirstSecond(float f) {
        this.mMaxProportionForFirstSecond = f;
    }

    public String toString() {
        try {
            return "###mSupportControlFocusDistance=" + String.valueOf(this.mSupportControlFocusDistance) + "###mFocusNotStartedFrameCount=" + String.valueOf(this.mFocusNotStartedFrameCount) + "###mFocusFailedFrameCount=" + String.valueOf(this.mFocusFailedFrameCount) + "###mHyperFocusDistance=" + String.valueOf(this.mHyperFocusDistance) + "###mMaxFocusDistance=" + String.valueOf(this.mMaxFocusDistance) + "###mLastFocusDistance=" + String.valueOf(this.mLastFocusDistance) + "###mActiveScanFrameCount=" + String.valueOf(this.mActiveScanFrameCount) + "###mPassiveScanFrameCount=" + String.valueOf(this.mPassiveScanFrameCount) + "###mFocusStateHistory=" + String.valueOf(this.mFocusStateHistory) + "###mInitFocusDistanceMatched=" + String.valueOf(this.mInitFocusDistanceMatched) + "###mPhoneMovementState=" + String.valueOf(this.mPhoneMovementState) + "###mSameFocusDistanceFrameCount=" + String.valueOf(this.mSameFocusDistanceFrameCount) + "###mMaxProportionForFirstSecond=" + String.valueOf(this.mMaxProportionForFirstSecond) + "###mMaxProportion=" + String.valueOf(this.mMaxProportion) + "###mMaxProportionFocusDistanceForFirstSecond=" + String.valueOf(this.mMaxProportionFocusDistanceForFirstSecond) + "###mMaxProportionFocusDistance=" + String.valueOf(this.mMaxProportionFocusDistance) + "###mHistoryAvgSuccessfulFocusDistance=" + String.valueOf(this.mHistoryAvgSuccessfulFocusDistance) + "###mFrameCount=" + String.valueOf(this.mFrameCount) + "###mHistorySuccessfulFocusDistanceCount=" + String.valueOf(this.mHistorySuccessfulFocusDistanceCount);
        } catch (Exception e) {
            MPaasLogger.e("CameraFocusStateDescription", new Object[]{"toString with error:"}, e);
            return "null";
        }
    }
}
