package com.youku.youkuplayer.plugin.watermark;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.widget.AppCompatTextView;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.youkuplayer.plugin.watermark.WaterMarkBean;
import tb.g41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WaterMarkTextView extends AppCompatTextView {
    public WaterMarkTextView(Context context, WaterMarkBean waterMarkBean, WaterMarkBean.DisplayDTOS displayDTOS) {
        super(context);
        String str = waterMarkBean.text;
        float f = (float) (waterMarkBean.textSize / 1.5d);
        String alphaString = getAlphaString(waterMarkBean.alpha);
        String replace = waterMarkBean.textColor.replace(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "");
        String str2 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + alphaString + replace.replace("0x", "");
        setTextSize(2, f);
        setTextSize(2, f);
        try {
            setTextColor(Color.parseColor(str2));
        } catch (Exception unused) {
            setTextColor(-1);
        }
        setText(str);
        setVisibility(0);
    }

    private String getAlphaString(float f) {
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
}
