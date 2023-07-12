package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.view.ViewGroup;
import com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMark;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IWaterMarkView {
    WaterMark.DisplayDTOS getDisplayDTOS();

    ViewGroup.LayoutParams getLayoutParams();

    WaterMark getWaterMark();

    void hide();

    void requestLayout();

    void show();

    void updateDisplayDTOS(WaterMark.DisplayDTOS displayDTOS);
}
