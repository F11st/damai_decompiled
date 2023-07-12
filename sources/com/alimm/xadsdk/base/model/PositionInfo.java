package com.alimm.xadsdk.base.model;

import android.text.TextUtils;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PositionInfo {
    private static final int POSITION_NUM = 6;
    private static final String TAG = "PositionInfo";
    private int mHeight;
    private int mInitHeight;
    private int mInitWidth;
    private int mWidth;
    private int mXCoord;
    private int mYCoord;

    public PositionInfo(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mInitWidth = i;
        this.mInitHeight = i2;
        this.mXCoord = i3;
        this.mYCoord = i4;
        this.mWidth = i5;
        this.mHeight = i6;
    }

    public PositionInfo(String str) {
        String[] split;
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "PositionInfo: strPosition = " + str);
        }
        if (TextUtils.isEmpty(str) || (split = str.split(",")) == null || split.length != 6) {
            return;
        }
        this.mInitWidth = Utils.toInt(split[0], 0);
        this.mInitHeight = Utils.toInt(split[1], 0);
        this.mXCoord = Utils.toInt(split[2], 0);
        this.mYCoord = Utils.toInt(split[3], 0);
        this.mWidth = Utils.toInt(split[4], 0);
        this.mHeight = Utils.toInt(split[5], 0);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getInitHeight() {
        return this.mInitHeight;
    }

    public int getInitWidth() {
        return this.mInitWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getXCoord() {
        return this.mXCoord;
    }

    public int getYCoord() {
        return this.mYCoord;
    }
}
