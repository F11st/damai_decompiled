package com.youku.vpm;

import android.text.TextUtils;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.StaticsUtil;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseTrack {
    protected final Track mTrack;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnExtrasBuildCallback {
        void buildExtras(String str, Map<String, String> map);
    }

    public BaseTrack(Track track) {
        this.mTrack = track;
    }

    private void addBaseDimensions(Map<String, String> map) {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        map.put("vvId", this.mTrack.getVVId());
        map.put(TableField.MEDIA_TYPE, vpmInfo.getString(TableField.MEDIA_TYPE, "0"));
        map.put(TableField.PLAY_WAY, this.mTrack.getPlayWay());
        map.put("vid", getValueFromInfo(vpmInfo, vpmFullInfo, "vid"));
        map.put("showId", getValueFromInfo(vpmFullInfo, "showId"));
        map.put(TableField.VIDEO_FORMAT, getValueFromInfo(vpmInfo, vpmFullInfo, TableField.VIDEO_FORMAT));
        map.put(TableField.STREAM_TYPE, getValueFromInfo(vpmFullInfo, TableField.STREAM_TYPE));
        map.put(TableField.DRM_TYPE, vpmFullInfo != null ? vpmFullInfo.getString(TableField.DRM_TYPE, null) : null);
        map.put("isRtmpe", vpmFullInfo != null ? vpmFullInfo.getString(TableField.DRM_TYPE, null) : null);
        map.put(TableField.DOLBY_TYPE, vpmFullInfo != null ? vpmFullInfo.getString(TableField.DOLBY_TYPE, null) : null);
        map.put(TableField.VIDEO_TYPE, getValueFromInfo(vpmFullInfo, TableField.VIDEO_TYPE));
        map.put(TableField.FILE_FORMAT, getValueFromInfo(vpmInfo, vpmFullInfo, TableField.FILE_FORMAT));
        map.put("playerCore", "axp");
        map.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        map.put(TableField.VV_SOURCE, getValueFromInfo(vpmInfo, vpmFullInfo, TableField.VV_SOURCE));
        map.put(TableField.PS_ID, getValueFromInfo(vpmFullInfo, TableField.PS_ID));
        map.put("userId", this.mTrack.getUserId());
        map.put("preloadinfo", vpmInfo.getString(TableField.PRELOAD_INFO, null));
        map.put(TableField.USE_MIN_SET, vpmInfo.getString(TableField.USE_MIN_SET, null));
        map.put(TableField.USE_FIRST_SLICE, vpmInfo.getString(TableField.USE_FIRST_SLICE, null));
        map.put("isAuto", vpmInfo.getString("isAuto", "0"));
        map.put(TableField.IS_VIP, getTrack().isVip() ? "1" : "0");
        map.put("deviceChip", TrackUtil.getCpuName(getTrack().getContext()));
        map.put("netStatus", StaticsUtil.getNetStatus());
    }

    private void addBaseMeasures(Map<String, Double> map) {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        map.put("videoPlayDuration", Double.valueOf(vpmFullInfo != null ? vpmFullInfo.getDouble("videoPlayDuration", 0.0d) : 0.0d));
        map.put("feedType", Double.valueOf(vpmInfo.getDouble("feedMode", 0.0d)));
    }

    public Table getTable(TableId tableId) {
        return this.mTrack.getTable(tableId);
    }

    public Table getTableWithCreate(TableId tableId) {
        Map<String, String> allValues;
        Map<String, String> allDims;
        Table table = this.mTrack.getTable(tableId);
        IPlayer player = this.mTrack.getPlayer();
        Map<String, String> dimensions = table.getDimensions();
        addBaseDimensions(dimensions);
        if (player != null && (allDims = player.getAllDims(tableId)) != null) {
            for (Map.Entry<String, String> entry : allDims.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!isEmpty(key) && !isEmpty(value)) {
                    dimensions.put(key, value);
                }
            }
        }
        Map<String, Double> measures = table.getMeasures();
        addBaseMeasures(measures);
        if (player != null && (allValues = player.getAllValues(tableId)) != null) {
            for (Map.Entry<String, String> entry2 : allValues.entrySet()) {
                String key2 = entry2.getKey();
                String value2 = entry2.getValue();
                if (!isEmpty(key2) && !isEmpty(value2)) {
                    try {
                        measures.put(key2, Double.valueOf(value2));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return table;
    }

    public Track getTrack() {
        return this.mTrack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getValueFromInfo(IVpmFullInfo iVpmFullInfo, String str) {
        if (iVpmFullInfo != null) {
            return iVpmFullInfo.getString(str, null);
        }
        return null;
    }

    protected String getValueFromInfo(IVpmInfo iVpmInfo, IVpmFullInfo iVpmFullInfo, String str) {
        return iVpmFullInfo != null ? iVpmFullInfo.getString(str, null) : iVpmInfo.getString(str, null);
    }

    protected boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || "-1".equals(str);
    }
}
