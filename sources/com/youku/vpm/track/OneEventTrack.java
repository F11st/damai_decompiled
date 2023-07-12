package com.youku.vpm.track;

import com.youku.vpm.BaseTrack;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OneEventTrack extends BaseTrack {
    private static final String TAG = "OneEvent";
    private double mIpChangeSuccCnt;
    private double mIpChangeTotalCnt;

    public OneEventTrack(Track track) {
        super(track);
    }

    public void commitOneEventStatistics(String str) {
        Table tableWithCreate = getTableWithCreate(TableId.ONEEVENT);
        Map<String, String> dimensions = tableWithCreate.getDimensions();
        dimensions.put("eventType", str);
        Map<String, Double> measures = tableWithCreate.getMeasures();
        if (!this.mTrack.isExternal()) {
            VpmProxy.commitOneEventStatistics(dimensions, measures);
            TrackUtil.printlog(this.mTrack.getContext(), TAG, str, dimensions, measures);
        }
        if ("1".equals(str)) {
            this.mIpChangeTotalCnt += 1.0d;
            if (measures.get("isSuccess").doubleValue() == 1.0d) {
                this.mIpChangeSuccCnt += 1.0d;
            }
        }
    }

    public double getIpChangeSuccCnt() {
        return this.mIpChangeSuccCnt;
    }

    public double getIpChangeTotalCnt() {
        return this.mIpChangeTotalCnt;
    }
}
