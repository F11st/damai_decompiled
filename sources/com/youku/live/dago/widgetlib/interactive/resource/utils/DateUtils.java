package com.youku.live.dago.widgetlib.interactive.resource.utils;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DateUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String DATA_STR_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static long stringToLong(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-179932251")) {
            return ((Long) ipChange.ipc$dispatch("-179932251", new Object[]{str})).longValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat(DATA_STR_FORMAT).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }
}
