package cn.damai.common.image;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMImageStrategyConfig {
    public boolean a;
    public boolean b;
    public boolean c;
    public DMImageCropType d;
    public int e;
    public boolean f;
    public int g = -1;
    public int h = -1;
    public String i;
    public DMImageQuality j;
    public DMImageSizeLimitType k;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum DMImageCropType {
        cy500,
        cy100
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum DMImageQuality {
        q90,
        q75,
        q60,
        q50,
        q30,
        non
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum DMImageSizeLimitType {
        WIDTH_LIMIT,
        HEIGHT_LIMIT,
        ALL_LIMIT
    }
}
