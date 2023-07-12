package com.alibaba.pictures.bricks.util;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMImageStrategyConfig {
    public boolean a;
    public boolean b;
    public DMImageCropType c;
    public int d;
    public boolean e;
    public int f = -1;
    public int g = -1;
    public DMImageQuality h;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum DMImageCropType {
        cy500,
        cy100
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum DMImageQuality {
        q90,
        q75,
        q60,
        q50,
        q30,
        non
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum DMImageSizeLimitType {
        WIDTH_LIMIT,
        HEIGHT_LIMIT,
        ALL_LIMIT
    }
}
