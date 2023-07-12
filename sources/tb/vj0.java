package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class vj0 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C9821a Companion = new C9821a(null);
    public static final int PAINT_FLAGS = 6;
    private final int a;
    private final int b;

    /* compiled from: Taobao */
    /* renamed from: tb.vj0$a */
    /* loaded from: classes7.dex */
    public static final class C9821a {
        private C9821a() {
        }

        public /* synthetic */ C9821a(k50 k50Var) {
            this();
        }
    }

    public vj0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Nullable
    public final Bitmap a(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289858811")) {
            return (Bitmap) ipChange.ipc$dispatch("289858811", new Object[]{this, bitmap, bitmap2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == 0 || bitmap2.getHeight() == 0 || (bitmap2.getWidth() == i && bitmap2.getHeight() == i2)) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(i / bitmap2.getWidth(), i2 / bitmap2.getHeight());
        matrix.postTranslate(0.5f, 0.5f);
        if (bitmap != null) {
            lg1 lg1Var = lg1.INSTANCE;
            lg1Var.a("fitXyCrop: recycler Bitmap + w=" + i + ",h=" + i2 + "this=" + toString());
        } else {
            Bitmap.Config e = jg1.INSTANCE.e(bitmap2);
            b41.f(e);
            bitmap = Bitmap.createBitmap(i, i2, e);
            b41.h(bitmap, "Bitmap.createBitmap(widt… getSafeConfig(toCrop)!!)");
            lg1 lg1Var2 = lg1.INSTANCE;
            lg1Var2.a("fitXyCrop: creat new Bitmap + w=" + i + ",h=" + i2 + "this=" + toString());
        }
        sg1.INSTANCE.j(bitmap2, bitmap);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap2, matrix, new Paint(6));
        canvas.setBitmap(null);
        return bitmap;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "351393970") ? (String) ipChange.ipc$dispatch("351393970", new Object[]{this}) : "com.alibaba.pictures.phenix.FitXYCropProcessor";
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374044949")) {
            return (Bitmap) ipChange.ipc$dispatch("374044949", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        b41.i(str, "s");
        b41.i(bitmapSupplier, "bitmapSupplier");
        b41.i(bitmap, "toTransform");
        int i2 = this.b;
        if (i2 <= 0 || (i = this.a) <= 0) {
            return bitmap;
        }
        Bitmap bitmap2 = bitmapSupplier.get(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        b41.h(bitmap2, "bitmapSupplier[outWidth,… Bitmap.Config.ARGB_8888]");
        Bitmap a = a(bitmap2, bitmap, this.a, this.b);
        b41.f(a);
        if (bitmap2 != null && (!b41.d(bitmap2, a))) {
            bitmap2.recycle();
        }
        return a;
    }
}
