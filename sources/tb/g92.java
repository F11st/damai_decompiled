package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.C0863b;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPaintData;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import cn.damai.seat.R$raw;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class g92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SEAT_STYLE_CIRCLE = 1;
    public static final int SEAT_STYLE_SOFA = 3;
    public static final byte TYPE_LOCK = 16;
    public static final byte TYPE_PACKAGE = 12;
    public static final byte TYPE_PACKAGE_SELECT = 13;
    public static final byte TYPE_PACKAGE_SOLD = 15;
    public static final byte TYPE_SEAT = 10;
    public static final byte TYPE_SEAT_SELECT = 11;
    public static final byte TYPE_SEAT_SOLD = 14;
    private static SVGPaintData h = c(R$raw.svg_seat_base);
    private static SVGPaintData i = c(R$raw.svg_package_text);
    private static SVGPaintData j = c(R$raw.svg_seat_select_layer);
    private static SVGPaintData k = c(R$raw.svg_seat_select_mark);
    private static SVGPaintData l = c(R$raw.svg_seat_lock_);
    private static SVGPaintData m = c(R$raw.svg_circle_base);
    private static SVGPaintData n = c(R$raw.svg_circle_seat_package_text);
    private static SVGPaintData o = c(R$raw.svg_circle_seat_mark);
    private static SVGPaintData p = c(R$raw.svg_circle_seat_layer);
    private static SVGPaintData q = c(R$raw.svg_circle_seat_lock);
    private final int a;
    private final Rect b = new Rect(0, 0, 128, 128);
    private final LongSparseArray<Bitmap> c = new LongSparseArray<>();
    private final C9167f d = new C9167f();
    private final C9166e e = new C9166e();
    private final C9165d f = new C9165d();
    private final C9163b g = new C9163b();

    /* compiled from: Taobao */
    /* renamed from: tb.g92$b */
    /* loaded from: classes7.dex */
    public static class C9163b extends AbstractC9164c {
        private static transient /* synthetic */ IpChange $ipChange;

        public C9163b() {
            super();
        }

        @Override // tb.g52
        public void d(@NonNull int[] iArr, @NonNull Shape shape) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "818498661")) {
                ipChange.ipc$dispatch("818498661", new Object[]{this, iArr, shape});
                return;
            }
            f(shape);
            e(shape);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.g92$c */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC9164c extends g52 {
        private static transient /* synthetic */ IpChange $ipChange;
        private static final int e = Color.parseColor("#DDE0E5");
        private static final int f = Color.parseColor("#D3D3D3");
        protected int b;
        protected int c;
        private float[] d;

        private AbstractC9164c() {
            this.d = new float[3];
        }

        public void f(Shape shape) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "471945913")) {
                ipChange.ipc$dispatch("471945913", new Object[]{this, shape});
            } else if (shape != null) {
                Paint paint = shape.strokePaint;
                if (paint != null) {
                    paint.setAntiAlias(true);
                }
                Paint paint2 = shape.fillPaint;
                if (paint2 != null) {
                    paint2.setAntiAlias(true);
                }
            }
        }

        public void g(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-799416525")) {
                ipChange.ipc$dispatch("-799416525", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            try {
                Color.colorToHSV(i, this.d);
                float[] fArr = this.d;
                float f2 = fArr[1];
                float f3 = fArr[2];
                fArr[1] = f2 + 0.6f;
                fArr[2] = f3 - 0.25f;
                int HSVToColor = Color.HSVToColor(fArr);
                if (z) {
                    this.b = qk.b(76.5f, i);
                    this.c = qk.b(76.5f, HSVToColor);
                } else {
                    this.b = i;
                    this.c = HSVToColor;
                }
            } catch (Exception unused) {
                this.b = i;
                this.c = i;
            }
        }

        public void h(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1824993137")) {
                ipChange.ipc$dispatch("1824993137", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                g(e, true);
            } else {
                this.b = e;
                this.c = f;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.g92$d */
    /* loaded from: classes7.dex */
    public static final class C9165d extends AbstractC9164c {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9165d() {
            super();
        }

        @Override // tb.g52
        public void d(@NonNull int[] iArr, @NonNull Shape shape) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "604164997")) {
                ipChange.ipc$dispatch("604164997", new Object[]{this, iArr, shape});
                return;
            }
            f(shape);
            iArr[0] = this.b;
            iArr[1] = this.c;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.g92$e */
    /* loaded from: classes7.dex */
    public static final class C9166e extends AbstractC9164c {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9166e() {
            super();
        }

        @Override // tb.g52
        public void d(@NonNull int[] iArr, @NonNull Shape shape) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-662976659")) {
                ipChange.ipc$dispatch("-662976659", new Object[]{this, iArr, shape});
                return;
            }
            f(shape);
            int parseColor = Color.parseColor("#96000000");
            iArr[0] = parseColor;
            iArr[1] = parseColor;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.g92$f */
    /* loaded from: classes7.dex */
    public static final class C9167f extends AbstractC9164c {
        private static transient /* synthetic */ IpChange $ipChange;
        private int g;

        private C9167f() {
            super();
            this.g = 0;
        }

        @Override // tb.g52
        public void d(@NonNull int[] iArr, @NonNull Shape shape) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1964386837")) {
                ipChange.ipc$dispatch("1964386837", new Object[]{this, iArr, shape});
                return;
            }
            f(shape);
            int i = this.g;
            if (i % 2 == 0) {
                int i2 = this.c;
                iArr[0] = i2;
                iArr[1] = i2;
            } else {
                int i3 = this.b;
                iArr[0] = i3;
                iArr[1] = i3;
            }
            this.g = i + 1;
        }

        @Override // tb.g92.AbstractC9164c
        public void g(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1226493567")) {
                ipChange.ipc$dispatch("1226493567", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.g = 0;
            super.g(i, z);
        }

        @Override // tb.g92.AbstractC9164c
        public void h(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1970561627")) {
                ipChange.ipc$dispatch("-1970561627", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.g = 0;
            super.h(z);
        }
    }

    public g92(int i2) {
        if (i2 == 3 && j()) {
            this.a = 3;
        } else if (e()) {
            this.a = 1;
        } else {
            this.a = 888;
        }
    }

    private static SVGPaintData c(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000060054")) {
            return (SVGPaintData) ipChange.ipc$dispatch("-2000060054", new Object[]{Integer.valueOf(i2)});
        }
        try {
            return new C0863b().b(mu0.a().getResources().openRawResource(i2)).a().getSvgPaintData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-17865946") ? ((Boolean) ipChange.ipc$dispatch("-17865946", new Object[]{this})).booleanValue() : (m == null || n == null || o == null || p == null || q == null) ? false : true;
    }

    private boolean f(byte b) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1097977954") ? ((Boolean) ipChange.ipc$dispatch("1097977954", new Object[]{this, Byte.valueOf(b)})).booleanValue() : b == 16;
    }

    private boolean g(byte b) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-589980443") ? ((Boolean) ipChange.ipc$dispatch("-589980443", new Object[]{this, Byte.valueOf(b)})).booleanValue() : b == 12 || b == 15 || b == 13;
    }

    private boolean h(byte b) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619520691") ? ((Boolean) ipChange.ipc$dispatch("1619520691", new Object[]{this, Byte.valueOf(b)})).booleanValue() : b == 11 || b == 13;
    }

    private boolean j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2116607359") ? ((Boolean) ipChange.ipc$dispatch("2116607359", new Object[]{this})).booleanValue() : (j == null || k == null || i == null || h == null || l == null) ? false : true;
    }

    private boolean k(byte b) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "663946123") ? ((Boolean) ipChange.ipc$dispatch("663946123", new Object[]{this, Byte.valueOf(b)})).booleanValue() : b == 14 || b == 15;
    }

    private Bitmap l(int i2, boolean z, boolean z2, boolean z3, C9165d c9165d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641007427")) {
            return (Bitmap) ipChange.ipc$dispatch("-641007427", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), c9165d});
        }
        Bitmap createBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (z3) {
            canvas.drawPicture(q.buildPicture(this.g), this.b);
            return createBitmap;
        }
        canvas.drawPicture(m.buildPicture(c9165d), this.b);
        if (z) {
            canvas.drawPicture(n.buildPicture(this.g), this.b);
        }
        if (z2) {
            Picture buildPicture = p.buildPicture(this.e);
            Picture buildPicture2 = o.buildPicture(this.g);
            canvas.drawPicture(buildPicture, this.b);
            canvas.drawPicture(buildPicture2, this.b);
        }
        return createBitmap;
    }

    private Bitmap m(int i2, byte b, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1040006550")) {
            return (Bitmap) ipChange.ipc$dispatch("-1040006550", new Object[]{this, Integer.valueOf(i2), Byte.valueOf(b), Boolean.valueOf(z)});
        }
        if (z) {
            i2 = qk.b(76.5f, i2);
        }
        h92 e = h92.e();
        if (b == 15) {
            return e.b(Color.parseColor("#e9e9e9"));
        }
        if (b == 14) {
            return e.d(Color.parseColor("#e9e9e9"));
        }
        if (h(b)) {
            return e.c();
        }
        if (g(b)) {
            return e.b(i2);
        }
        return e.d(i2);
    }

    private Bitmap n(float f, boolean z, boolean z2, boolean z3, C9167f c9167f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814254601")) {
            return (Bitmap) ipChange.ipc$dispatch("1814254601", new Object[]{this, Float.valueOf(f), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), c9167f});
        }
        Bitmap createBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (z3) {
            canvas.drawPicture(l.buildPicture(this.g), this.b);
            return createBitmap;
        }
        canvas.drawPicture(h.buildPicture(c9167f), this.b);
        if (z) {
            canvas.drawPicture(i.buildPicture(this.g), this.b);
        }
        if (z2) {
            Picture buildPicture = j.buildPicture(this.e);
            Picture buildPicture2 = k.buildPicture(this.g);
            canvas.drawPicture(buildPicture, this.b);
            if (f != 0.0f) {
                canvas.rotate(-f, 64.0f, 64.0f);
            }
            canvas.drawPicture(buildPicture2, this.b);
        }
        return createBitmap;
    }

    private Bitmap p(Bitmap bitmap, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086644615")) {
            return (Bitmap) ipChange.ipc$dispatch("-2086644615", new Object[]{this, bitmap, Float.valueOf(f)});
        }
        if (f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, 1.0f);
            matrix.postRotate(f, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return bitmap;
    }

    public Bitmap a(int i2, float f, byte b, boolean z) {
        Bitmap m2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "391635636")) {
            return (Bitmap) ipChange.ipc$dispatch("391635636", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f), Byte.valueOf(b), Boolean.valueOf(z)});
        }
        long a = c11.a(i2, (short) f, b, z);
        Bitmap bitmap = this.c.get(a);
        if (bitmap == null) {
            int i3 = this.a;
            if (i3 == 3) {
                if (k(b)) {
                    this.d.h(z);
                    m2 = p(n(f, g(b), false, false, this.d), f);
                } else {
                    this.d.g(i2, z);
                    m2 = p(n(f, g(b), h(b), f(b), this.d), f);
                }
            } else if (i3 == 1) {
                if (k(b)) {
                    this.f.h(z);
                } else {
                    this.f.g(i2, z);
                }
                m2 = l(i2, g(b), h(b), f(b), this.f);
            } else {
                m2 = m(i2, b, z);
            }
            bitmap = m2;
            if (bitmap != null) {
                this.c.put(a, bitmap);
            }
        }
        return bitmap;
    }

    public Bitmap b(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1056527448") ? (Bitmap) ipChange.ipc$dispatch("-1056527448", new Object[]{this, Float.valueOf(f)}) : a(0, f, (byte) 16, false);
    }

    public Bitmap d(float f, byte b, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530139479")) {
            return (Bitmap) ipChange.ipc$dispatch("-1530139479", new Object[]{this, Float.valueOf(f), Byte.valueOf(b), Boolean.valueOf(z)});
        }
        if (b != 15 && b != 14) {
            b = 14;
        }
        return a(0, f, b, z);
    }

    public boolean i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "854871083") ? ((Boolean) ipChange.ipc$dispatch("854871083", new Object[]{this})).booleanValue() : this.a == 3;
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1533909104")) {
            ipChange.ipc$dispatch("-1533909104", new Object[]{this});
            return;
        }
        int size = this.c.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                Bitmap valueAt = this.c.valueAt(i2);
                if (valueAt != null) {
                    valueAt.recycle();
                }
            }
            this.c.clear();
        }
    }
}
