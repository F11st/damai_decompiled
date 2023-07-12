package com.youku.vpm.track;

import android.content.Context;
import android.text.TextUtils;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.PlayerErrorMsg;
import com.youku.vpm.utils.TLogUtil;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ErrorTrack extends BaseTrack implements BaseTrack.OnExtrasBuildCallback {
    private static final String TAG = "ErrorTrack";
    private static int[] UPS_ERROR = {25001, 26001, 26003, 26004, 26006, 26007, 26008};
    private Context mContext;
    private boolean mIsSend;
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

    public static void flowLog(String str, String str2) {
        TLogUtil.loge("[KeyFlow][MiddleLayer][axp][" + str + jn1.ARRAY_END_STR, str2);
    }

    private double getDoubleValueForPlayErrInfo(String str) {
        return TrackUtil.getDoubleValue(str);
    }

    private String getNotEmptyString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    private String intToIP(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    @Override // com.youku.vpm.BaseTrack.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    public double getLoadingTotalTime() {
        if (this.playingLoadingStartTime > 0) {
            double currentTimeMillis = System.currentTimeMillis() - this.playingLoadingStartTime;
            this.playingLoadingStartTime = 0L;
            return currentTimeMillis;
        }
        return -1.0d;
    }

    public String getLoadingType() {
        return this.mLoadingType;
    }

    public String getQuitType() {
        return this.mQuitType;
    }

    public void onDataFail(int i) {
        if (!contains(i)) {
            i = 0;
        }
        onError(i);
    }

    public void onEndLoading() {
        this.mLoadingType = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onError(int r13) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.vpm.track.ErrorTrack.onError(int):void");
    }

    public void onRealVideoStart() {
        this.mLoadingType = null;
    }

    public void onStartLoading(String str) {
        this.mLoadingType = str;
        this.playingLoadingStartTime = System.currentTimeMillis();
    }

    public void setPlayerErrorMsg(Object obj) {
        this.playerErrorMsg = PlayerErrorMsg.creat(String.valueOf(obj));
    }

    public void setQuitType(String str) {
        this.mQuitType = str;
    }
}
