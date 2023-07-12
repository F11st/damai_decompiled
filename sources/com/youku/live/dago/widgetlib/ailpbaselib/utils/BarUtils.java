package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.content.res.Resources;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class BarUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_ALPHA = 112;
    private static final String TAG_ALPHA = "TAG_ALPHA";
    private static final String TAG_COLOR = "TAG_COLOR";
    private static final int TAG_OFFSET = -123;

    private BarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getNavBarHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793238831")) {
            return ((Integer) ipChange.ipc$dispatch("793238831", new Object[0])).intValue();
        }
        Resources resources = AppContextUtils.getApp().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
