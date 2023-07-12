package com.youku.vpm.track;

import com.youku.playerservice.axp.item.PlayItem;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.LogUtil;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OnePlayExtrasTrack {
    public static final String TAG = "OnePlayExtrasTrack";
    private final Track mTrack;

    public OnePlayExtrasTrack(Track track) {
        this.mTrack = track;
    }

    public void commit() {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        HashMap hashMap = new HashMap();
        hashMap.put("vvId", this.mTrack.getVVId());
        hashMap.put("playType", "end");
        hashMap.put(TableField.MEDIA_TYPE, vpmInfo.getString(TableField.MEDIA_TYPE, "0"));
        hashMap.put("url", this.mTrack.getString("url"));
        hashMap.put("url1", this.mTrack.getString(PlayItem.Result.FIRST_URL));
        hashMap.put("url2", this.mTrack.getString(PlayItem.Result.SECOND_URL));
        hashMap.put("upsUrl", this.mTrack.getString("upsUrl", null));
        HashMap hashMap2 = new HashMap();
        LogUtil.printLog(TAG, hashMap, hashMap2);
        VpmProxy.commitOnePlayExtras(hashMap, hashMap2);
    }
}
