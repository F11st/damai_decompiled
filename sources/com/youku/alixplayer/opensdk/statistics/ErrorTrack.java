package com.youku.alixplayer.opensdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.utils.PlayCode;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ErrorTrack extends BaseTrack implements Track.OnExtrasBuildCallback {
    private static final String TAG = "ErrorTrack";
    private static int[] UPS_ERROR = {25001, 26001, 26003, 26004, 26006, 26007, 26008};
    private Context mContext;
    private String mLoadingType;
    private String mQuitType;
    public PlayerErrorMsg playerErrorMsg;
    private long playingLoadingStartTime;

    public ErrorTrack(Track track) {
        super(track);
        this.playingLoadingStartTime = 0L;
        this.mContext = track.getContext();
    }

    private boolean contains(int i) {
        for (int i2 : UPS_ERROR) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private double getDoubleValueForPlayErrInfo(String str) {
        return TrackUtil.getDoubleValueForPlayErrInfo(str);
    }

    private String getNotEmptyString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.Track.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    public double getLoadingTotalTime() {
        if (this.playingLoadingStartTime > 0) {
            double nanoTime = (System.nanoTime() / 1000000) - this.playingLoadingStartTime;
            this.playingLoadingStartTime = 0L;
            return nanoTime;
        }
        return -1.0d;
    }

    public String getLoadingType() {
        return this.mLoadingType;
    }

    public String getQuitType() {
        return this.mQuitType;
    }

    public void onEndLoading() {
        this.mLoadingType = null;
    }

    public void onError(String str) {
        String string = this.mTrack.getString("retryCount");
        String string2 = this.mTrack.getString("retryCode");
        if ((PlayCode.USER_LOADING_RETURN.equals(str) || PlayCode.RETURN_WHEN_BUFFERING.equals(str)) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            int intValue = Integer.valueOf(string2).intValue();
            onError(intValue, ErrorCodeUtil.getErrorMsg(intValue));
            return;
        }
        int intValue2 = Integer.valueOf(str).intValue();
        onError(intValue2, ErrorCodeUtil.getErrorMsg(intValue2));
    }

    public void onRealVideoStart() {
        this.mLoadingType = null;
    }

    public void onStartLoading(String str) {
        this.mLoadingType = str;
        this.playingLoadingStartTime = System.nanoTime() / 1000000;
    }

    public void setPlayerErrorMsg(Object obj) {
        this.playerErrorMsg = PlayerErrorMsg.creat(String.valueOf(obj));
    }

    public void setQuitType(String str) {
        this.mQuitType = str;
    }

    public void onError(int i) {
        onError(i, ErrorCodeUtil.getErrorMsg(i));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:1|(1:3)(1:64)|4|(1:6)(1:63)|7|8|9|(23:11|12|(1:14)(1:58)|15|(1:17)(1:57)|18|19|20|(1:28)|30|(1:32)(1:54)|33|(1:35)|36|(1:38)(1:53)|39|(1:41)(1:52)|42|(1:44)(1:51)|45|(1:47)|48|49)|60|12|(0)(0)|15|(0)(0)|18|19|20|(4:22|24|26|28)|30|(0)(0)|33|(0)|36|(0)(0)|39|(0)(0)|42|(0)(0)|45|(0)|48|49) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0110, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0111, code lost:
        r14.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onError(int r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.opensdk.statistics.ErrorTrack.onError(int, java.lang.String):void");
    }

    public void onError(VideoRequestError videoRequestError) {
        int httpStatus = videoRequestError.getHttpStatus();
        int errorCode = videoRequestError.getErrorCode();
        String errorMsg = videoRequestError.getErrorMsg();
        if (httpStatus == 200 && !contains(errorCode)) {
            errorCode = 0;
        }
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = ErrorCodeUtil.getErrorMsg(errorCode);
        }
        onError(errorCode, errorMsg);
    }
}
