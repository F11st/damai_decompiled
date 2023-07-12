package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMark;
import com.youku.live.livesdk.wkit.component.Constants;
import tb.g41;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WaterMarkTextView extends AppCompatTextView implements IWaterMarkView {
    private static transient /* synthetic */ IpChange $ipChange;
    private WaterMark.DisplayDTOS mDisplayDTOS;
    private WaterMark mWaterMark;

    public WaterMarkTextView(Context context, WaterMark waterMark, WaterMark.DisplayDTOS displayDTOS) {
        super(context);
        this.mWaterMark = waterMark;
        this.mDisplayDTOS = displayDTOS;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        WaterMarkUtil.setLayoutParams(getContext(), layoutParams, this.mWaterMark.refCoord, displayDTOS);
        setLayoutParams(layoutParams);
        CharSequence charSequence = waterMark.text;
        float f = (float) (waterMark.textSize / 1.5d);
        String alphaString = getAlphaString(waterMark.alpha);
        String replace = waterMark.textColor.replace(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "");
        String str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + alphaString + replace.replace("0x", "");
        setTextSize(2, f);
        setTextSize(2, f);
        try {
            setTextColor(Color.parseColor(str));
        } catch (Exception unused) {
            setTextColor(-1);
        }
        setText(charSequence);
        setVisibility(0);
    }

    private String getAlphaString(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723597118")) {
            return (String) ipChange.ipc$dispatch("-723597118", new Object[]{this, Float.valueOf(f)});
        }
        String str = f == 0.1f ? "E6" : "FF";
        if (f == 0.2f) {
            str = "CC";
        }
        if (f == 0.3f) {
            str = "B3";
        }
        if (f == 0.4f) {
            str = "99";
        }
        if (f == 0.5f) {
            str = "80";
        }
        if (f == 0.6f) {
            str = g41.ISSUE_PARAM_COMMENT_TYPE_SCRIPT;
        }
        if (f == 0.7f) {
            str = "4D";
        }
        if (f == 0.8f) {
            str = "33";
        }
        if (f == 0.9f) {
            str = "1A";
        }
        return f == 1.0f ? "00" : str;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public WaterMark.DisplayDTOS getDisplayDTOS() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1744069134") ? (WaterMark.DisplayDTOS) ipChange.ipc$dispatch("1744069134", new Object[]{this}) : this.mDisplayDTOS;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public WaterMark getWaterMark() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-256700494") ? (WaterMark) ipChange.ipc$dispatch("-256700494", new Object[]{this}) : this.mWaterMark;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1499429927")) {
            ipChange.ipc$dispatch("-1499429927", new Object[]{this});
        } else if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344758210")) {
            ipChange.ipc$dispatch("-344758210", new Object[]{this});
        } else if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.watermark.IWaterMarkView
    public void updateDisplayDTOS(WaterMark.DisplayDTOS displayDTOS) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "908220929")) {
            ipChange.ipc$dispatch("908220929", new Object[]{this, displayDTOS});
            return;
        }
        this.mDisplayDTOS = displayDTOS;
        WaterMarkUtil.setLayoutParams(getContext(), (FrameLayout.LayoutParams) getLayoutParams(), this.mWaterMark.refCoord, displayDTOS);
    }
}
