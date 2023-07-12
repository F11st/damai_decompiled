package com.youku.youkuplayer.plugin.watermark;

import android.view.View;
import android.widget.FrameLayout;
import com.youku.youkuplayer.plugin.watermark.WaterMarkBean;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WaterMarkWrap {
    private WaterMarkBean.DisplayDTOS mDisplayDTOS;
    private View mView;
    private WaterMarkBean mWaterMarkBean;

    public WaterMarkWrap(View view, WaterMarkBean waterMarkBean, WaterMarkBean.DisplayDTOS displayDTOS) {
        this.mView = view;
        this.mWaterMarkBean = waterMarkBean;
        this.mDisplayDTOS = displayDTOS;
        view.setContentDescription("displayMode=" + waterMarkBean.displayMode);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        WaterMarkUtil.setLayoutParams(this.mView.getContext(), layoutParams, waterMarkBean.refCoord, displayDTOS);
        this.mView.setLayoutParams(layoutParams);
    }

    public WaterMarkBean getWaterMarkBean() {
        return this.mWaterMarkBean;
    }

    public void hide() {
        if (this.mView.getVisibility() != 8) {
            this.mView.setVisibility(8);
        }
    }

    public boolean isRefresh(WaterMarkBean.DisplayDTOS displayDTOS) {
        return isSameDisplayDTOS(displayDTOS) || this.mView.getVisibility() == 8;
    }

    public boolean isSameDisplayDTOS(WaterMarkBean.DisplayDTOS displayDTOS) {
        WaterMarkBean.DisplayDTOS displayDTOS2 = this.mDisplayDTOS;
        if (displayDTOS2 == null || displayDTOS == null) {
            return false;
        }
        return (displayDTOS2.width == displayDTOS.width && displayDTOS2.height == displayDTOS.height && displayDTOS2.posX == displayDTOS.posX && displayDTOS2.posY == displayDTOS.posY) ? false : true;
    }

    public void show() {
        if (this.mView.getVisibility() != 0) {
            this.mView.setVisibility(0);
        }
        this.mView.requestLayout();
    }

    public void updateDisplayDTOS(WaterMarkBean.DisplayDTOS displayDTOS) {
        this.mDisplayDTOS = displayDTOS;
        WaterMarkUtil.setLayoutParams(this.mView.getContext(), (FrameLayout.LayoutParams) this.mView.getLayoutParams(), this.mWaterMarkBean.refCoord, displayDTOS);
    }
}
