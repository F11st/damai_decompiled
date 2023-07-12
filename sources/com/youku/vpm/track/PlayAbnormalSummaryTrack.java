package com.youku.vpm.track;

import android.text.TextUtils;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.LogUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayAbnormalSummaryTrack extends BaseTrack {
    public static final String TAG = "PlayAbnormalSummary";

    public PlayAbnormalSummaryTrack(Track track) {
        super(track);
    }

    public void commit(String str) {
        Table tableWithCreate = getTableWithCreate(TableId.PLAY_ABNORMAL_SUMMARY);
        if (!TextUtils.isEmpty(str)) {
            tableWithCreate.putString(str);
        }
        Map<String, String> dimensions = tableWithCreate.getDimensions();
        Map<String, Double> measures = tableWithCreate.getMeasures();
        if ("1".equals(this.mTrack.getDynamicProperties("isExternal"))) {
            return;
        }
        VpmProxy.commitPlayAbnormalSummary(dimensions, measures);
        LogUtil.printLog("PlayAbnormalSummary", dimensions, measures);
    }
}
