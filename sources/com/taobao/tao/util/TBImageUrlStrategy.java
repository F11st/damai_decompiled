package com.taobao.tao.util;

import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import tb.qb1;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class TBImageUrlStrategy {
    public static final String END_IMAGE_URL = "END_IMAGE_URL";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Area {
        String mArea;
        public static final Area search = new Area("search");
        public static final Area detail = new Area("detail");
        public static final Area shop = new Area(ImageStrategyConfig.SHOP);
        public static final Area weitao = new Area(ImageStrategyConfig.WEITAO);
        public static final Area weapp = new Area(ImageStrategyConfig.WEAPP);
        public static final Area weappsharpen = new Area(ImageStrategyConfig.WEAPPSHARPEN);
        public static final Area bala = new Area(ImageStrategyConfig.BALA);
        public static final Area home = new Area("home");
        public static final Area tbchannel = new Area(ImageStrategyConfig.TBCHANNEL);
        public static final Area non = new Area("default");

        private Area(String str) {
            this.mArea = "";
            this.mArea = str;
        }

        public String getArea() {
            return this.mArea;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum CutType {
        xz("xz"),
        non("");
        
        String mCutType;

        CutType(String str) {
            this.mCutType = "";
            this.mCutType = str;
        }

        public String getCutType() {
            return this.mCutType;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ImageQuality {
        q90("q90"),
        q75("q75"),
        q60("q60"),
        q50("q50"),
        q30("q30"),
        non("");
        
        String mImageQuality;

        ImageQuality(String str) {
            this.mImageQuality = "";
            this.mImageQuality = str;
        }

        public String getImageQuality() {
            return this.mImageQuality;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ImageSharpen {
        s100("s100"),
        s110("s110"),
        s120("s120"),
        s130("s130"),
        s140("s140"),
        s150("s150"),
        non("");
        
        String mImageSharpen;

        ImageSharpen(String str) {
            this.mImageSharpen = "";
            this.mImageSharpen = str;
        }

        public String getImageSharpen() {
            return this.mImageSharpen;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CutType.values().length];
            a = iArr;
            try {
                iArr[CutType.xz.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b {
        public static final TBImageUrlStrategy instance = new TBImageUrlStrategy(null);
    }

    /* synthetic */ TBImageUrlStrategy(a aVar) {
        this();
    }

    public static TBImageUrlStrategy getInstance() {
        return b.instance;
    }

    public String convergenceUrl(String str) {
        return TaobaoImageUrlStrategy.getInstance().convergenceUrl(str);
    }

    @Deprecated
    public String decideLowNetUrl(String str, int i, Area area, CutType cutType) {
        return decideUrl(str, i, area, 0L, -1, -1, cutType, true, true, true);
    }

    public String decideUrl(String str, int i) {
        return decideUrl(str, i, Area.non, 0L, -1, -1, CutType.non);
    }

    public String decideUrl10000Height(String str, int i, Area area, long j) {
        return decideUrl(str, i, area, j, 0, 10000, CutType.non);
    }

    public String decideUrl10000Width(String str, int i, Area area, long j) {
        return decideUrl(str, i, area, j, 10000, 0, CutType.non);
    }

    public void setQuality(int i) {
    }

    private TBImageUrlStrategy() {
    }

    @Deprecated
    public String decideLowNetUrl(String str, int i, Area area, CutType cutType, String str2, String str3) {
        return decideUrl(str, i, area, 0L, -1, -1, cutType, true, true, true);
    }

    public String decideUrl(String str, int i, CutType cutType) {
        return decideUrl(str, i, Area.non, 0L, -1, -1, cutType);
    }

    @Deprecated
    public String decideLowNetUrl(String str, int i, Area area, CutType cutType, long j, int i2, int i3, String str2, String str3, boolean z) {
        return decideUrl(str, i, area, j, i2, i3, cutType, z, true, true);
    }

    public String decideUrl(String str, int i, Area area) {
        return decideUrl(str, i, area, 0L, -1, -1, CutType.non);
    }

    public String decideUrl(String str, int i, Area area, long j) {
        return decideUrl(str, i, area, j, -1, -1, CutType.non);
    }

    public String decideUrl(String str, int i, Area area, long j, int i2, int i3, CutType cutType) {
        return decideUrl(str, i, area, j, i2, i3, cutType, true, true, true);
    }

    public String decideUrl(String str, int i, Area area, long j, boolean z, boolean z2, boolean z3) {
        return decideUrl(str, i, area, j, -1, -1, CutType.non, z, z2, z3);
    }

    private String decideUrl(String str, int i, Area area, long j, int i2, int i3, CutType cutType, boolean z, boolean z2, boolean z3) {
        TaobaoImageUrlStrategy.CutType cutType2;
        if (!TaobaoImageUrlStrategy.getInstance().isCdnImage(str)) {
            qb1.g(qb1.COMMON_TAG, "origin not cdn url:%s", str);
            return str;
        }
        if (a.a[cutType.ordinal()] != 1) {
            cutType2 = TaobaoImageUrlStrategy.CutType.non;
        } else {
            cutType2 = TaobaoImageUrlStrategy.CutType.xz;
        }
        return TaobaoImageUrlStrategy.getInstance().decideUrl(str, i, area.getArea(), cutType2, i2, i3, z, z2, z3) + END_IMAGE_URL;
    }
}
