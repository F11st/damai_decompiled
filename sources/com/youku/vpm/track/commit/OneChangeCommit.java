package com.youku.vpm.track.commit;

import com.taobao.weex.common.Constants;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.LogUtil;
import com.youku.vpm.utils.SystemUtil;
import com.youku.vpm.utils.TLogUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OneChangeCommit extends BaseTrack implements BaseTrack.OnExtrasBuildCallback {
    public static final String TAG = "OneChange";
    public long changeStartTime;
    public String changeStateAfter;
    public String changeStateBefore;
    public double changeTotalTimeFromPlayer;
    public double currentPosition;
    public String isAuto;
    public String isSuccess;
    private int mQualityMode;
    public double timeConsume;

    public OneChangeCommit(Track track) {
        super(track);
    }

    @Override // com.youku.vpm.BaseTrack.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void commit(TableId tableId, String str) {
        String str2 = "2".equals(str) ? "seek" : Constants.Name.QUALITY;
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        if (vpmFullInfo != null) {
            commitOneChangeStatistics(tableId, str, str2, this.mTrack, vpmFullInfo);
        }
    }

    public void commitOneChangeStatistics(TableId tableId, String str, String str2, Track track, IVpmFullInfo iVpmFullInfo) {
        if (iVpmFullInfo == null) {
            TLogUtil.loge("", "video is null on onechange");
            return;
        }
        Table tableWithCreate = getTableWithCreate(tableId);
        Map<String, String> dimensions = tableWithCreate.getDimensions();
        dimensions.put("VPMIndex", String.valueOf(track.getVPMIndex()));
        dimensions.put("changeStateBefore", this.changeStateBefore);
        dimensions.put("changeStateAfter", this.changeStateAfter);
        dimensions.put("changeType", str);
        dimensions.put("isSuccess", this.isSuccess);
        dimensions.put("isAuto", this.isAuto);
        dimensions.put("qualityMode", this.mQualityMode + "");
        track.buildExtras(dimensions, this);
        Map<String, Double> measures = tableWithCreate.getMeasures();
        measures.put("timeConsume", Double.valueOf(this.timeConsume));
        measures.put("changeTotalTimeFromPlayer", Double.valueOf(this.changeTotalTimeFromPlayer));
        measures.put("videoPlayDuration", Double.valueOf(iVpmFullInfo.getDouble("duration", -1.0d)));
        measures.put("PlayTime", Double.valueOf(this.mTrack.getPlayTime()));
        measures.put("currentPosition", Double.valueOf(this.currentPosition));
        if (this.mTrack.isExternal()) {
            return;
        }
        VpmProxy.commitOneChangeStatistics(dimensions, measures);
        TLogUtil.vpmLog("OneChange:baseInfo:" + dimensions.toString());
        TLogUtil.vpmLog("OneChange:statisticsInfo:" + measures.toString());
        if (SystemUtil.isDebug(this.mTrack.getContext())) {
            LogUtil.printLog("OneChange-" + str2, dimensions, measures);
        }
    }
}
