package com.taobao.tao.image;

import com.taobao.tao.util.TaobaoImageUrlStrategy;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageStrategyConfig {
    public static final String BALA = "bala";
    public static final String DEFAULT = "default";
    public static final String DETAIL = "detail";
    public static final String HOME = "home";
    public static final String SEARCH = "search";
    public static final String SHOP = "shop";
    public static final String TBCHANNEL = "tbchannel";
    public static final String WEAPP = "weapp";
    public static final String WEAPPSHARPEN = "weappsharpen";
    public static final String WEITAO = "weitao";
    boolean a;
    String b;
    int c;
    int d;
    int e;
    boolean f;
    TaobaoImageUrlStrategy.CutType g;
    Boolean h;
    Boolean i;
    Boolean j;
    Boolean k;
    Boolean l;
    TaobaoImageUrlStrategy.ImageQuality m;
    SizeLimitType n;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum SizeLimitType {
        WIDTH_LIMIT,
        HEIGHT_LIMIT,
        ALL_LIMIT
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.tao.image.ImageStrategyConfig$b */
    /* loaded from: classes11.dex */
    public static class C6898b {
        boolean a;
        String b;
        int c;
        int d = -1;
        int e = -1;
        TaobaoImageUrlStrategy.CutType f;
        Boolean g;
        Boolean h;
        Boolean i;
        Boolean j;
        Boolean k;
        Boolean l;
        TaobaoImageUrlStrategy.ImageQuality m;
        SizeLimitType n;

        public C6898b(String str, int i) {
            this.b = str;
            this.c = i;
        }

        public ImageStrategyConfig a() {
            return new ImageStrategyConfig(this);
        }

        public C6898b b(boolean z) {
            this.g = Boolean.valueOf(z);
            return this;
        }

        public C6898b c(TaobaoImageUrlStrategy.ImageQuality imageQuality) {
            this.m = imageQuality;
            return this;
        }

        public C6898b d(SizeLimitType sizeLimitType) {
            this.n = sizeLimitType;
            return this;
        }
    }

    public static C6898b o(String str) {
        return new C6898b(str, 0);
    }

    public static C6898b p(String str, int i) {
        return new C6898b(str, i);
    }

    public int a() {
        return this.c;
    }

    public TaobaoImageUrlStrategy.CutType b() {
        return this.g;
    }

    public int c() {
        return this.e;
    }

    public TaobaoImageUrlStrategy.ImageQuality d() {
        return this.m;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.b;
    }

    public SizeLimitType g() {
        return this.n;
    }

    public Boolean h() {
        return this.l;
    }

    public Boolean i() {
        return this.k;
    }

    public Boolean j() {
        return this.i;
    }

    public Boolean k() {
        return this.j;
    }

    public Boolean l() {
        return this.h;
    }

    public boolean m() {
        return this.f;
    }

    public boolean n() {
        return this.a;
    }

    public String q() {
        StringBuilder sb = new StringBuilder(300);
        sb.append("ImageStrategyConfig@");
        sb.append(hashCode());
        sb.append(StringUtils.LF);
        sb.append("bizName:");
        sb.append(this.b);
        sb.append(StringUtils.LF);
        sb.append("bizId:");
        sb.append(this.c);
        sb.append(StringUtils.LF);
        sb.append("skipped:");
        sb.append(this.a);
        sb.append(StringUtils.LF);
        sb.append("finalWidth:");
        sb.append(this.d);
        sb.append(StringUtils.LF);
        sb.append("finalHeight:");
        sb.append(this.e);
        sb.append(StringUtils.LF);
        sb.append("cutType:");
        sb.append(this.g);
        sb.append(StringUtils.LF);
        sb.append("enabledWebP:");
        sb.append(this.h);
        sb.append(StringUtils.LF);
        sb.append("enabledQuality:");
        sb.append(this.i);
        sb.append(StringUtils.LF);
        sb.append("enabledSharpen:");
        sb.append(this.j);
        sb.append(StringUtils.LF);
        sb.append("enabledMergeDomain:");
        sb.append(this.k);
        sb.append(StringUtils.LF);
        sb.append("enabledLevelModel:");
        sb.append(this.l);
        sb.append(StringUtils.LF);
        sb.append("finalImageQuality:");
        sb.append(this.m);
        sb.append(StringUtils.LF);
        sb.append("forcedWebPOn:");
        sb.append(this.f);
        sb.append(StringUtils.LF);
        sb.append("sizeLimitType:");
        sb.append(this.n);
        return sb.toString();
    }

    public final String toString() {
        return String.valueOf(this.c);
    }

    private ImageStrategyConfig(C6898b c6898b) {
        this.b = c6898b.b;
        this.c = c6898b.c;
        this.a = c6898b.a;
        this.d = c6898b.d;
        this.e = c6898b.e;
        this.g = c6898b.f;
        this.h = c6898b.g;
        this.i = c6898b.h;
        this.j = c6898b.i;
        this.k = c6898b.j;
        this.l = c6898b.k;
        this.m = c6898b.m;
        Boolean bool = c6898b.l;
        if (bool != null) {
            this.f = bool.booleanValue();
        }
        SizeLimitType sizeLimitType = c6898b.n;
        this.n = sizeLimitType;
        if (sizeLimitType == null) {
            this.n = SizeLimitType.ALL_LIMIT;
        } else if (sizeLimitType == SizeLimitType.WIDTH_LIMIT) {
            this.e = 10000;
            this.d = 0;
        } else if (sizeLimitType == SizeLimitType.HEIGHT_LIMIT) {
            this.e = 0;
            this.d = 10000;
        }
    }
}
