package com.youku.alixplayer.opensdk.statistics.track.impairment;

import android.os.Handler;
import com.ali.user.open.ucc.data.ApiConstants;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.vpm.constants.TableField;
import java.util.Map;
import tb.in2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StartLoadingCommit {
    public static final String TAG = "StartLoading";
    private boolean isCancel;
    private Handler mHandler = new Handler();
    private Track mTrack;

    public StartLoadingCommit(Track track) {
        this.mTrack = track;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commit(YoukuVideoInfo youkuVideoInfo, String str, int i, int i2, Object obj) {
        if (this.isCancel) {
            return;
        }
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        Table table = this.mTrack.mVPM.getTable(MSGTABLEID.START_LOADING);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put(TableField.MEDIA_TYPE, playVideoInfo.getPlayType().getValue() + "");
        dimensions.put("vvId", this.mTrack.getVVId());
        dimensions.put(ApiConstants.ApiField.USER_ACTION, str);
        dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
        dimensions.put(TableField.VIDEO_TYPE, youkuVideoInfo != null ? youkuVideoInfo.getVideoType() : null);
        dimensions.put("userId", this.mTrack.getUserId());
        dimensions.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        dimensions.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
        VpmProxy.commitStartLoadingStatistics(dimensions, table.getMeasures());
    }

    public void cancel() {
        this.isCancel = true;
    }

    public void commitDelayed(final YoukuVideoInfo youkuVideoInfo, final String str, final int i, final int i2, final Object obj) {
        this.mHandler.postDelayed(new Runnable() { // from class: com.youku.alixplayer.opensdk.statistics.track.impairment.StartLoadingCommit.1
            @Override // java.lang.Runnable
            public void run() {
                StartLoadingCommit.this.commit(youkuVideoInfo, str, i, i2, obj);
            }
        }, Integer.parseInt(ConfigFetcher.getInstance().getConfig("autoQualitySwitch", "impairmentTimeLimit", in2.PERFORM_CANCEL)));
    }
}
