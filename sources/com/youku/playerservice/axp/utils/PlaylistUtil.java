package com.youku.playerservice.axp.utils;

import android.text.TextUtils;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.playerservice.axp.item.SliceItem;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlaylistUtil {
    public static String constructTsParams(long j, long j2, long j3, long j4, long j5, String str, long j6, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"mStartMSDirectly=");
        stringBuffer.append(j);
        stringBuffer.append(";");
        stringBuffer.append("mSeqNumberUpdatedDirectly=");
        stringBuffer.append(j2);
        stringBuffer.append(";");
        stringBuffer.append("mSeqSizeDirectly=");
        stringBuffer.append(j3);
        stringBuffer.append(";");
        stringBuffer.append("mSeqDurationDirectly=");
        stringBuffer.append(j4);
        stringBuffer.append(";");
        stringBuffer.append("mSeqPeriodIndexDirectly=");
        stringBuffer.append(j5);
        stringBuffer.append(";");
        stringBuffer.append("mStartTSStreamType=");
        stringBuffer.append(str);
        stringBuffer.append(";");
        stringBuffer.append("mDurationUs=");
        stringBuffer.append(j6);
        stringBuffer.append(";");
        stringBuffer.append("mSliceDrmKey=");
        stringBuffer.append(str2);
        stringBuffer.append(";");
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String constructTsParams(long j, long j2, String str, long j3, String str2) {
        return constructTsParams(j, 0L, 0L, j2, 0L, str, j3 * 1000, str2);
    }

    public static Period getPeriod(SliceItem sliceItem) {
        Period period = new Period();
        period.setType(0);
        period.setMediaType(0);
        period.setStartTime(sliceItem.getStartPos());
        period.addSource(new Source(sliceItem.getTsUrl(), sliceItem.getTsDurSeconds()));
        return period;
    }
}
