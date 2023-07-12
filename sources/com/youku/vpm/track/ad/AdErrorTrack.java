package com.youku.vpm.track.ad;

import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AdErrorTrack {
    public static final String TAG = "AdError";
    private final Track mTrack;

    public AdErrorTrack(Track track) {
        this.mTrack = track;
    }

    private String getFullInfoValue(IVpmFullInfo iVpmFullInfo, String str) {
        if (iVpmFullInfo != null) {
            return iVpmFullInfo.getString(str, null);
        }
        return null;
    }

    public void commit(int i, int i2) {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        Table table = this.mTrack.getTable(TableId.AD_ERROR);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put("vvId", this.mTrack.getVVId());
        dimensions.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        dimensions.put(TableField.PS_ID, getFullInfoValue(vpmFullInfo, TableField.PS_ID));
        dimensions.put(TableField.MEDIA_TYPE, vpmInfo.getString(TableField.MEDIA_TYPE, "0"));
        dimensions.put(TableField.PLAY_WAY, this.mTrack.getPlayWay());
        dimensions.put("adType", String.valueOf(i));
        dimensions.put("errorCode", String.valueOf(i2));
        dimensions.put("videoVid", getFullInfoValue(vpmFullInfo, "vId"));
        dimensions.put("videoShowId", getFullInfoValue(vpmFullInfo, "showId"));
        dimensions.put("videoFileformat", this.mTrack.getFileFormat());
        Map<String, Double> measures = table.getMeasures();
        String str = dimensions.get("adUrl");
        dimensions.put("adVid", TrackUtil.getValueByKeyFromUrl(str, "adVid"));
        dimensions.put("adFileformat", TrackUtil.getFileFormatByUrl(str));
        VpmProxy.commitAdErrorStatistics(dimensions, measures);
    }
}
