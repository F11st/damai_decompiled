package tb;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class di2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int NOT_SET = -1;
    final rm a;
    final int b;
    final int c;
    final int d;
    final boolean e;
    final int f;
    final int g;
    final int h;
    final int i;
    final int j;
    final int k;
    final int l;
    final Drawable m;
    final int n;
    final ImageView.ScaleType o;
    final int p;
    final int q;
    final float r;
    final float s;
    final float t;
    final int u;
    final int v;
    final int w;
    final String x;
    final int y;
    public static final int holoRedLight = -48060;
    public static final di2 ALERT = new b().A(holoRedLight).z();
    public static final int holoGreenLight = -6697984;
    public static final di2 CONFIRM = new b().A(holoGreenLight).z();
    public static final int holoBlueLight = -13388315;
    public static final di2 INFO = new b().A(holoBlueLight).z();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int i;
        private int k;
        private int n;
        private int o;
        private float p;
        private float q;
        private float r;
        private int s;
        private int w;
        private rm a = rm.DEFAULT;
        private int v = 10;
        private int c = 17170450;
        private int d = 0;
        private int b = -1;
        private boolean e = false;
        private int f = 17170443;
        private int g = -1;
        private int h = -2;
        private int j = -1;
        private int l = 17;
        private Drawable m = null;
        private int t = 0;
        private ImageView.ScaleType u = ImageView.ScaleType.FIT_XY;
        private String x = null;
        private int y = 0;

        public b A(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1557061445")) {
                return (b) ipChange.ipc$dispatch("1557061445", new Object[]{this, Integer.valueOf(i)});
            }
            this.b = i;
            return this;
        }

        public di2 z() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1179977141") ? (di2) ipChange.ipc$dispatch("-1179977141", new Object[]{this}) : new di2(this);
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1859077880")) {
            return (String) ipChange.ipc$dispatch("1859077880", new Object[]{this});
        }
        return "Style{configuration=" + this.a + ", backgroundColorResourceId=" + this.b + ", backgroundDrawableResourceId=" + this.c + ", backgroundColorValue=" + this.d + ", isTileEnabled=" + this.e + ", textColorResourceId=" + this.f + ", textColorValue=" + this.g + ", heightInPixels=" + this.h + ", heightDimensionResId=" + this.i + ", widthInPixels=" + this.j + ", widthDimensionResId=" + this.k + ", gravity=" + this.l + ", imageDrawable=" + this.m + ", imageResId=" + this.n + ", imageScaleType=" + this.o + ", textSize=" + this.p + ", textShadowColorResId=" + this.q + ", textShadowRadius=" + this.r + ", textShadowDy=" + this.s + ", textShadowDx=" + this.t + ", textAppearanceResId=" + this.u + ", paddingInPixels=" + this.v + ", paddingDimensionResId=" + this.w + ", fontName=" + this.x + ", fontNameResId=" + this.y + '}';
    }

    private di2(b bVar) {
        this.a = bVar.a;
        this.b = bVar.c;
        this.c = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.p = bVar.n;
        this.q = bVar.o;
        this.r = bVar.p;
        this.t = bVar.q;
        this.s = bVar.r;
        this.u = bVar.s;
        this.n = bVar.t;
        this.o = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.d = bVar.b;
        this.x = bVar.x;
        this.y = bVar.y;
    }
}
