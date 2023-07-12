package com.youku.vpm.track.ad;

import com.youku.vpm.IPlayer;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TrackUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AdPlayTrack {
    public static final String TAG = "AdPlay";
    private Track mTrack;

    public AdPlayTrack(Track track) {
        this.mTrack = track;
    }

    public void commit(int i, int i2) {
        Map<String, String> allDims;
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        IPlayer player = this.mTrack.getPlayer();
        if (player == null) {
            allDims = this.mTrack.mTableBuilder.getTable(TableId.AD_PLAY).getDimensions();
        } else {
            allDims = player.getAllDims(TableId.AD_PLAY);
            if (allDims == null) {
                allDims = new HashMap<>();
            }
        }
        allDims.put("vvId", this.mTrack.getVVId());
        allDims.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        allDims.put(TableField.PS_ID, vpmFullInfo.getString(TableField.PS_ID, null));
        allDims.put(TableField.MEDIA_TYPE, vpmInfo.getString(TableField.MEDIA_TYPE, "0"));
        allDims.put(TableField.PLAY_WAY, vpmFullInfo.getString(TableField.PLAY_WAY, null));
        allDims.put("adType", String.valueOf(i));
        allDims.put("videoVid", vpmFullInfo.getString("vId", null));
        allDims.put("videoShowId", vpmFullInfo.getString("showId", null));
        allDims.put("videoFileformat", this.mTrack.getString(TableField.FILE_FORMAT));
        Map<String, Double> hashMap = new HashMap<>();
        if (player == null) {
            hashMap = this.mTrack.mTableBuilder.getTable(TableId.AD_PLAY).getMeasures();
        } else {
            Map<String, String> allValues = player.getAllValues(TableId.AD_PLAY);
            if (allValues != null && allValues.size() > 0) {
                try {
                    for (Map.Entry<String, String> entry : allValues.entrySet()) {
                        hashMap.put(entry.getKey(), Double.valueOf(Double.parseDouble(entry.getValue())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        allDims.put("adVid", vpmInfo.getString("pre_adid_" + i2, null));
        allDims.put("adFileformat", TrackUtil.getFileFormatByUrl(allDims.get("adUrl")));
        if (this.mTrack.isExternal()) {
            return;
        }
        VpmProxy.commitAdPlayStatistics(allDims, hashMap);
        TrackUtil.printlog(this.mTrack.getContext(), "AdPlay", "AdPlay", allDims, hashMap);
    }
}
