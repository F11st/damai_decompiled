package com.youku.vpm.data;

import com.youku.vpm.IVpmInfo;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.track.Track;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExtrasNetm3sInfo extends ExtraMap {
    public static final String EXTRAS_NETM3S_INFO = "extras_netm3s_info";

    public ExtrasNetm3sInfo(Track track, String str) {
        super(str);
        Table table;
        Map<String, String> dimensions;
        Map<String, String> dimensions2;
        IVpmInfo vpmInfo = track.getVpmInfo();
        put("wifiInfo", vpmInfo.getString("wifiInfo", null));
        if (contains("impairment")) {
            put("startLoadingWifiInfo", vpmInfo.getString("startLoadingWifiInfo", null));
            Table table2 = track.getTable(TableId.IMPAIRMENT);
            if (table2 != null && (dimensions2 = table2.getDimensions()) != null) {
                put("dlreportbufferlow", dimensions2.get("dlreportbufferlow"));
                put("dlreportbufferdone", dimensions2.get("dlreportbufferdone"));
            }
        }
        if (!contains("onePlay") || (table = track.getTable(TableId.ONEPLAY)) == null || (dimensions = table.getDimensions()) == null) {
            return;
        }
        put("dlreportfirstts", dimensions.get("dlreportfirstts"));
    }
}
