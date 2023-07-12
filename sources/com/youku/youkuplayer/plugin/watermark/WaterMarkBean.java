package com.youku.youkuplayer.plugin.watermark;

import android.content.Context;
import android.util.TypedValue;
import com.youku.android.liveservice.bean.WaterMarkV2;
import com.youku.upsplayer.module.Watermark;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WaterMarkBean {
    public float alpha;
    public int autoScale;
    public List<DisplayDTOS> displayDTOS = new ArrayList();
    public int displayMode;
    public int refCoord;
    public int refWnd;
    public int rsType;
    public String rsUrl;
    public String text;
    public String textColor;
    public int textSize;
    public int type;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class DisplayDTOS {
        public int duration;
        public int height;
        public float posX;
        public float posY;
        public int start;
        public int width;

        public DisplayDTOS() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class DisplayMode {
        public static final int ALL = 0;
        public static final int HORIZONTAL = 1;
        public static final int SMALL = 3;
        public static final int VERTICAL = 2;

        public DisplayMode() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class RefCoord {
        public static final int LEFT_BOTTOM = 3;
        public static final int LEFT_TOP = 0;
        public static final int RIGHT_BOTTOM = 2;
        public static final int RIGHT_TOP = 1;

        public RefCoord() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class ResType {
        public static final int PIC = 2;
        public static final int TEXT = 1;
        public static final int WATERMARK = 0;

        public ResType() {
        }
    }

    public WaterMarkBean(Context context, Watermark watermark) {
        com.youku.upsplayer.module.DisplayDTOS[] displayDTOSArr;
        this.textColor = watermark.textColor;
        this.type = watermark.type;
        this.text = watermark.text;
        this.refWnd = watermark.refWnd;
        this.rsUrl = watermark.rsUrl;
        this.displayMode = watermark.displayMode;
        this.refCoord = watermark.refCoord;
        this.alpha = watermark.alpha;
        this.autoScale = watermark.autoScale;
        this.rsType = watermark.rsType;
        for (com.youku.upsplayer.module.DisplayDTOS displayDTOS : watermark.displayDTOS) {
            DisplayDTOS displayDTOS2 = new DisplayDTOS();
            displayDTOS2.posY = displayDTOS.posY;
            displayDTOS2.posX = displayDTOS.posX;
            displayDTOS2.height = dip2px(context, displayDTOS.height);
            displayDTOS2.width = dip2px(context, displayDTOS.width);
            displayDTOS2.duration = displayDTOS.duration;
            displayDTOS2.start = displayDTOS.start;
            this.displayDTOS.add(displayDTOS2);
        }
    }

    public WaterMarkBean(WaterMarkV2 waterMarkV2) {
        this.textColor = waterMarkV2.getTextColor();
        this.type = (int) waterMarkV2.getType();
        this.text = waterMarkV2.getText();
        this.refWnd = (int) waterMarkV2.getRefWnd();
        this.rsUrl = waterMarkV2.getRsUrl();
        this.displayMode = waterMarkV2.getDisplay_mode();
        this.refCoord = waterMarkV2.getRefCoord();
        this.alpha = waterMarkV2.getAlpha();
        this.autoScale = waterMarkV2.getAutoScale();
        this.rsType = (int) waterMarkV2.getRsType();
        for (WaterMarkV2.displayDTOS displaydtos : waterMarkV2.getDisplayDTOS()) {
            DisplayDTOS displayDTOS = new DisplayDTOS();
            displayDTOS.posY = displaydtos.posY;
            displayDTOS.posX = displaydtos.posX;
            displayDTOS.height = (int) displaydtos.height;
            displayDTOS.width = (int) displaydtos.width;
            displayDTOS.duration = (int) displaydtos.duration;
            displayDTOS.start = (int) displaydtos.start;
            this.displayDTOS.add(displayDTOS);
        }
    }

    private int dip2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public DisplayDTOS getDisplayDTOS(int i) {
        DisplayDTOS displayDTOS = null;
        if (this.displayDTOS != null) {
            for (int i2 = 0; i2 < this.displayDTOS.size(); i2++) {
                DisplayDTOS displayDTOS2 = this.displayDTOS.get(i2);
                int i3 = displayDTOS2.start;
                if (i >= i3 && displayDTOS2.duration == 0) {
                    return displayDTOS2;
                }
                int i4 = displayDTOS2.duration + i3;
                if (i >= i3 && i <= i4) {
                    displayDTOS = displayDTOS2;
                }
            }
        }
        return displayDTOS;
    }
}
