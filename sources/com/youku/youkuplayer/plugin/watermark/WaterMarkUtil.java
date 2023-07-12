package com.youku.youkuplayer.plugin.watermark;

import android.content.Context;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.youku.youkuplayer.plugin.watermark.WaterMarkBean;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WaterMarkUtil {
    private static int dip2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void setLayoutParams(Context context, FrameLayout.LayoutParams layoutParams, int i, WaterMarkBean.DisplayDTOS displayDTOS) {
        if (context == null || layoutParams == null || displayDTOS == null) {
            return;
        }
        layoutParams.width = displayDTOS.width;
        layoutParams.height = displayDTOS.height;
        float f = displayDTOS.posX;
        float f2 = displayDTOS.posY;
        if (i != 0) {
            if (i == 1) {
                layoutParams.gravity = 53;
                layoutParams.topMargin = dip2px(context, f2);
            } else if (i == 2) {
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = dip2px(context, f2);
            } else if (i != 3) {
                return;
            } else {
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = dip2px(context, f2);
            }
            layoutParams.rightMargin = dip2px(context, f);
            return;
        }
        layoutParams.gravity = 51;
        layoutParams.topMargin = dip2px(context, f2);
        layoutParams.leftMargin = dip2px(context, f);
    }
}
