package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.content.Context;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMark;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WaterMarkImageView extends TUrlImageView implements IWaterMarkView {
    private static transient /* synthetic */ IpChange $ipChange;
    private WaterMark.DisplayDTOS mDisplayDTOS;
    private WaterMark mWaterMark;

    public WaterMarkImageView(Context context, WaterMark waterMark, WaterMark.DisplayDTOS displayDTOS) {
        super(context);
        this.mWaterMark = waterMark;
        this.mDisplayDTOS = displayDTOS;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        WaterMarkUtil.setLayoutParams(getContext(), layoutParams, this.mWaterMark.refCoord, displayDTOS);
        setLayoutParams(layoutParams);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public WaterMark.DisplayDTOS getDisplayDTOS() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "621309692") ? (WaterMark.DisplayDTOS) ipChange.ipc$dispatch("621309692", new Object[]{this}) : this.mDisplayDTOS;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public WaterMark getWaterMark() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "82064672") ? (WaterMark) ipChange.ipc$dispatch("82064672", new Object[]{this}) : this.mWaterMark;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1446621625")) {
            ipChange.ipc$dispatch("-1446621625", new Object[]{this});
        } else if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291949908")) {
            ipChange.ipc$dispatch("-291949908", new Object[]{this});
        } else if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public void updateDisplayDTOS(WaterMark.DisplayDTOS displayDTOS) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9814033")) {
            ipChange.ipc$dispatch("-9814033", new Object[]{this, displayDTOS});
            return;
        }
        this.mDisplayDTOS = displayDTOS;
        WaterMarkUtil.setLayoutParams(getContext(), (FrameLayout.LayoutParams) getLayoutParams(), this.mWaterMark.refCoord, displayDTOS);
    }
}
