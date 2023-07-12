package com.youku.vpm.track.ad;

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
public class AdImpairmentTrack {
    public static final String TAG = "AdImpairment";
    private int mAdType;
    private Track mTrack;

    public AdImpairmentTrack(Track track, int i) {
        this.mTrack = track;
        this.mAdType = i;
    }

    public void commit() {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        Table table = this.mTrack.mTableBuilder.getTable(TableId.AD_IMPAIRMENT);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put("vvId", this.mTrack.getVVId());
        dimensions.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        dimensions.put(TableField.MEDIA_TYPE, vpmInfo.getString(TableField.MEDIA_TYPE, "0"));
        dimensions.put("adType", String.valueOf(this.mAdType));
        Map<String, Double> measures = table.getMeasures();
        String str = dimensions.get("adUrl");
        dimensions.put("adVid", TrackUtil.getValueByKeyFromUrl(str, "adVid"));
        dimensions.put("adFileformat", TrackUtil.getFileFormatByUrl(str));
        if (this.mAdType == 4) {
            Table table2 = this.mTrack.getTable(TableId.IMPAIRMENT);
            dimensions.put("adFileformat", TrackUtil.getFileFormatByUrl(table2.getDimensions().get("URL")));
            dimensions.put("adVideoCode", table2.getDimensions().get("videoCode"));
        }
        if (this.mTrack.isExternal()) {
            return;
        }
        VpmProxy.commitAdImpairmentStatistics(dimensions, measures);
    }
}
