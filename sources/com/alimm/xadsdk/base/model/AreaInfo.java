package com.alimm.xadsdk.base.model;

import android.text.TextUtils;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AreaInfo {
    private static final int AREA_NUM = 4;
    private static final String TAG = "AreaInfo";
    private int mHeight;
    private int mWidth;
    private int mXCoord;
    private int mYCoord;

    public AreaInfo(String str) {
        String[] split;
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "AreaInfo: strArea = " + str);
        }
        if (TextUtils.isEmpty(str) || (split = str.split(",")) == null || split.length != 4) {
            return;
        }
        this.mXCoord = Utils.toInt(split[0], 0);
        this.mYCoord = Utils.toInt(split[1], 0);
        this.mWidth = Utils.toInt(split[2], 0);
        this.mHeight = Utils.toInt(split[3], 0);
    }

    public int getHeight() {
        return this.mHeight;
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
