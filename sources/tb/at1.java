package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class at1 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C8926a Companion = new C8926a(null);
    public static final int PAINT_FLAGS = 6;
    private final int a;
    private final int b;
    private PointF c;

    /* compiled from: Taobao */
    /* renamed from: tb.at1$a */
    /* loaded from: classes7.dex */
    public static final class C8926a {
        private C8926a() {
        }

        public /* synthetic */ C8926a(k50 k50Var) {
            this();
        }
    }

    public at1(int i, int i2, @Nullable PointF pointF) {
        this.a = i;
        this.b = i2;
        this.c = pointF;
    }

    private final Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float width;
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846926901")) {
            return (Bitmap) ipChange.ipc$dispatch("1846926901", new Object[]{this, bitmap, bitmap2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == 0 || bitmap2.getHeight() == 0 || (bitmap2.getWidth() == i && bitmap2.getHeight() == i2)) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float f2 = 0.0f;
        if (this.c == null) {
            this.c = new PointF(0.0f, 0.0f);
        }
        PointF pointF = this.c;
        if (pointF != null) {
            float f3 = 0;
            if (pointF.x < f3) {
                pointF.x = 0.0f;
            }
            if (pointF.x > 1.0f) {
                pointF.x = 1.0f;
            }
            if (pointF.y < f3) {
                pointF.y = 0.0f;
            }
            if (pointF.y > 1.0f) {
                pointF.y = 1.0f;
            }
        }
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            width = i2 / bitmap2.getHeight();
            float width2 = i - (bitmap2.getWidth() * width);
            PointF pointF2 = this.c;
            f2 = width2 * (pointF2 != null ? pointF2.x : 0.0f);
            f = 0.0f;
        } else {
            width = i / bitmap2.getWidth();
            float height = i2 - (bitmap2.getHeight() * width);
            PointF pointF3 = this.c;
            f = height * (pointF3 != null ? pointF3.y : 0.0f);
        }
        matrix.setScale(width, width);
        matrix.postTranslate(f2 + 0.5f, f + 0.5f);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, jg1.INSTANCE.e(bitmap2));
        }
        sg1 sg1Var = sg1.INSTANCE;
        b41.h(bitmap, "result");
        sg1Var.j(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-915065160") ? (String) ipChange.ipc$dispatch("-915065160", new Object[]{this}) : "com.alibaba.pictures.phenix.PointFocusCropProcessor";
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485087537")) {
            return (Bitmap) ipChange.ipc$dispatch("-1485087537", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        b41.i(str, "s");
        b41.i(bitmapSupplier, "bitmapSupplier");
        b41.i(bitmap, "toTransform");
        Bitmap bitmap2 = bitmapSupplier.get(this.a, this.b, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        b41.h(bitmap2, "bitmapSupplier.get(outWi… Bitmap.Config.ARGB_8888)");
        Bitmap a = a(bitmap2, bitmap, this.a, this.b);
        b41.f(a);
        if (bitmap2 != null && (!b41.d(bitmap2, a))) {
            bitmap2.recycle();
        }
        return a;
    }
}
