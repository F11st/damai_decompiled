package com.heytap.msp.push.statis;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.dg2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class StatisticUtils {
    public static boolean statisticEvent(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessageStat(context.getPackageName(), str));
        return dg2.c(context, arrayList);
    }

    public static boolean statisticEvent(Context context, String str, DataMessage dataMessage) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        arrayList.add(dataMessage == null ? new MessageStat(packageName, str) : new MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
        return dg2.c(context, arrayList);
    }

    public static boolean statisticEvent(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (list != null && list.size() != 0) {
            for (String str : list) {
                arrayList.add(new MessageStat(packageName, str));
            }
        }
        return dg2.c(context, arrayList);
    }

    public static boolean statisticEvent(Context context, Map<String, List<DataMessage>> map) {
        if (map == null) {
            return false;
        }
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            List<DataMessage> list = map.get(str);
            if (list != null) {
                for (DataMessage dataMessage : list) {
                    arrayList.add(new MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
                }
            } else {
                arrayList.add(new MessageStat(packageName, str));
            }
        }
        return dg2.c(context, arrayList);
    }
}
