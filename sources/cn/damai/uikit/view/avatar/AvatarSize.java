package cn.damai.uikit.view.avatar;

import android.content.Context;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum AvatarSize {
    SIZE_30x30(30, 12, 2),
    SIZE_40x40(40, 12, 2),
    SIZE_50x50(50, 18, 3),
    SIZE_60x60(60, 24, 3),
    SIZE_80x80(80, 24, 4),
    SIZE_100x100(100, 24, 4);
    
    public final int borderWidthDp;
    public final int rbTagSizeDp;
    public final int viewSizeDp;

    AvatarSize(int i, int i2, int i3) {
        this.viewSizeDp = i;
        this.rbTagSizeDp = i2;
        this.borderWidthDp = i3;
    }

    public static AvatarSize get(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 5) {
                            return SIZE_60x60;
                        }
                        return SIZE_100x100;
                    }
                    return SIZE_80x80;
                }
                return SIZE_50x50;
            }
            return SIZE_40x40;
        }
        return SIZE_30x30;
    }

    public int getOutBorderSizePx(Context context) {
        return l62.a(context, this.borderWidthDp);
    }

    public int getRbTagSizePx(Context context) {
        return l62.a(context, this.rbTagSizeDp);
    }

    public int getViewSizePx(Context context) {
        return l62.a(context, this.viewSizeDp);
    }
}
