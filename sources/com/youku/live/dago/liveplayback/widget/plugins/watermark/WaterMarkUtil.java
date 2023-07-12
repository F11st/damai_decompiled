package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.content.Context;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMark;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WaterMarkUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    private static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1133156441") ? ((Integer) ipChange.ipc$dispatch("-1133156441", new Object[]{context, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void setLayoutParams(Context context, FrameLayout.LayoutParams layoutParams, int i, WaterMark.DisplayDTOS displayDTOS) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946402530")) {
            ipChange.ipc$dispatch("-946402530", new Object[]{context, layoutParams, Integer.valueOf(i), displayDTOS});
        } else if (context == null || layoutParams == null || displayDTOS == null) {
        } else {
            layoutParams.width = displayDTOS.width;
            layoutParams.height = displayDTOS.height;
            float f = displayDTOS.posX;
            float f2 = displayDTOS.posY;
            if (i == 0) {
                layoutParams.gravity = 51;
                layoutParams.topMargin = dip2px(context, f2);
                layoutParams.leftMargin = dip2px(context, f);
            } else if (i == 1) {
                layoutParams.gravity = 53;
                layoutParams.topMargin = dip2px(context, f2);
                layoutParams.rightMargin = dip2px(context, f);
            } else if (i == 2) {
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = dip2px(context, f2);
                layoutParams.rightMargin = dip2px(context, f);
            } else if (i != 3) {
            } else {
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = dip2px(context, f2);
                layoutParams.leftMargin = dip2px(context, f);
            }
        }
    }
}
