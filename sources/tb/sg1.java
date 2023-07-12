package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.weex.common.Constants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.og1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class sg1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PAINT_FLAGS = 6;
    private static Paint b;
    private static final Set<String> c;
    @NotNull
    private static final Lock d;
    @NotNull
    public static final sg1 INSTANCE = new sg1();
    private static final Paint a = new Paint(6);

    /* compiled from: Taobao */
    /* renamed from: tb.sg1$a  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class locksLockC9693a implements Lock {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-492727302")) {
                ipChange.ipc$dispatch("-492727302", new Object[]{this});
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1504954041")) {
                ipChange.ipc$dispatch("-1504954041", new Object[]{this});
            }
        }

        @Override // java.util.concurrent.locks.Lock
        @NotNull
        public Condition newCondition() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-904488513")) {
                return (Condition) ipChange.ipc$dispatch("-904488513", new Object[]{this});
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1309129565")) {
                return ((Boolean) ipChange.ipc$dispatch("-1309129565", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NotNull TimeUnit timeUnit) throws InterruptedException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "687150487")) {
                return ((Boolean) ipChange.ipc$dispatch("687150487", new Object[]{this, Long.valueOf(j), timeUnit})).booleanValue();
            }
            b41.i(timeUnit, "unit");
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1968927553")) {
                ipChange.ipc$dispatch("1968927553", new Object[]{this});
            }
        }
    }

    static {
        List j;
        new Paint(7);
        j = C8214m.j("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079");
        HashSet hashSet = new HashSet(j);
        c = hashSet;
        d = hashSet.contains(Build.getMODEL()) ? new ReentrantLock() : new locksLockC9693a();
        Paint paint = new Paint(7);
        b = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private sg1() {
    }

    private final void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719260930")) {
            ipChange.ipc$dispatch("-719260930", new Object[]{this, bitmap, bitmap2, matrix});
            return;
        }
        Lock lock = d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            d.unlock();
            throw th;
        }
    }

    private final void e(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918063419")) {
            ipChange.ipc$dispatch("-1918063419", new Object[]{this, canvas});
        } else {
            canvas.setBitmap(null);
        }
    }

    private final Bitmap.Config i(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119658303")) {
            return (Bitmap.Config) ipChange.ipc$dispatch("-119658303", new Object[]{this, bitmap});
        }
        if (bitmap.getConfig() != null) {
            Bitmap.Config config = bitmap.getConfig();
            b41.h(config, "bitmap.config");
            return config;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @Nullable
    public final Bitmap b(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @Nullable Bitmap bitmap, @Nullable og1.C9521a c9521a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898148273")) {
            return (Bitmap) ipChange.ipc$dispatch("-1898148273", new Object[]{this, bitmapSupplier, bitmap, c9521a});
        }
        b41.i(bitmapSupplier, "bitmapSupplier");
        if (bitmap == null || c9521a == null) {
            return null;
        }
        float[] d2 = c9521a.d();
        float c2 = c9521a.c();
        int a2 = c9521a.a();
        int b2 = c9521a.b();
        Bitmap bitmap2 = bitmapSupplier.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            lg1 lg1Var = lg1.INSTANCE;
            lg1Var.a("borderCrop: creat new Bitmap + w=" + bitmap.getWidth() + ",h=" + bitmap.getHeight() + "this=" + toString());
        } else {
            lg1 lg1Var2 = lg1.INSTANCE;
            lg1Var2.a("borderCrop: use recycle Bitmap + w=" + bitmap.getWidth() + ",h=" + bitmap.getHeight() + "this=" + toString());
        }
        b41.f(bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        if (c2 > 0) {
            Paint paint = new Paint();
            if (b2 == 0) {
                b2 = -12303292;
            }
            paint.setColor(b2);
            paint.setStrokeWidth(c2);
            paint.setStyle(Paint.Style.STROKE);
            if (a2 == 1) {
                paint.setPathEffect(new DashPathEffect(new float[]{8.0f, 5.0f}, 0.0f));
            }
            paint.setAntiAlias(true);
            Path path = new Path();
            if (c9521a.f()) {
                path.addCircle(bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f, (Math.min(bitmap.getWidth(), bitmap.getHeight()) - c2) / 2, Path.Direction.CCW);
            } else {
                float f = c2 / 2;
                path.addRoundRect(new RectF(f, f, bitmap.getWidth() - f, bitmap.getHeight() - f), d2, Path.Direction.CCW);
            }
            canvas.drawPath(path, paint);
        }
        Paint paint2 = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint2.setAntiAlias(true);
        Path path2 = new Path();
        if (c9521a.f()) {
            path2.addCircle(bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f, (Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2) - c2, Path.Direction.CCW);
        } else {
            path2.addRoundRect(new RectF(c2, c2, bitmap.getWidth() - c2, bitmap.getHeight() - c2), d2, Path.Direction.CCW);
        }
        canvas.drawPath(path2, paint2);
        canvas.setBitmap(null);
        return bitmap2;
    }

    @NotNull
    public final Bitmap c(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044375789")) {
            return (Bitmap) ipChange.ipc$dispatch("-1044375789", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(bitmapSupplier, "pool");
        b41.i(bitmap, "inBitmap");
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || (bitmap.getWidth() == i && bitmap.getHeight() == i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        Bitmap bitmap2 = bitmapSupplier.get(i, i2, i(bitmap));
        b41.h(bitmap2, "pool.get(width, height, …tNonNullConfig(inBitmap))");
        j(bitmap, bitmap2);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    @NotNull
    public final Bitmap d(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624616295")) {
            return (Bitmap) ipChange.ipc$dispatch("624616295", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(bitmapSupplier, "pool");
        b41.i(bitmap, "inBitmap");
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            lg1.INSTANCE.b("TransformationUtils", "requested target size larger or equal to input, returning input");
            return bitmap;
        }
        lg1.INSTANCE.b("TransformationUtils", "requested target size too big for input, fit centering instead");
        return f(bitmapSupplier, bitmap, i, i2);
    }

    @NotNull
    public final Bitmap f(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769151006")) {
            return (Bitmap) ipChange.ipc$dispatch("-769151006", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(bitmapSupplier, "pool");
        b41.i(bitmap, "inBitmap");
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0 && (bitmap.getWidth() != i || bitmap.getHeight() != i2)) {
            float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
            int round = Math.round(bitmap.getWidth() * min);
            int round2 = Math.round(bitmap.getHeight() * min);
            if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                }
                return bitmap;
            }
            Bitmap bitmap2 = bitmapSupplier.get((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), i(bitmap));
            b41.h(bitmap2, "pool.get(targetWidth, targetHeight, config)");
            j(bitmap, bitmap2);
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "request: " + i + Constants.Name.X + i2);
                Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + Constants.Name.X + bitmap.getHeight());
                Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + Constants.Name.X + bitmap2.getHeight());
                StringBuilder sb = new StringBuilder();
                sb.append("minPct:   ");
                sb.append(min);
                Log.v("TransformationUtils", sb.toString());
            }
            Matrix matrix = new Matrix();
            matrix.setScale(min, min);
            a(bitmap, bitmap2, matrix);
            return bitmap2;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
        }
        return bitmap;
    }

    @Nullable
    public final Bitmap g(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @Nullable Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878990880")) {
            return (Bitmap) ipChange.ipc$dispatch("1878990880", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(bitmapSupplier, "pool");
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float height = i2 / bitmap.getHeight();
        Bitmap bitmap2 = bitmapSupplier.get((int) (bitmap.getWidth() * height), i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        b41.h(bitmap2, "pool.get((toCrop.width*s… Bitmap.Config.ARGB_8888)");
        matrix.setScale(height, height);
        float f = (int) 0.5f;
        matrix.postTranslate(f, f);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), (int) (bitmap.getHeight() * height), jg1.INSTANCE.e(bitmap));
        }
        b41.h(bitmap2, "result");
        j(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        e(canvas);
        return bitmap2;
    }

    @Nullable
    public final Bitmap h(@NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @Nullable Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402631885")) {
            return (Bitmap) ipChange.ipc$dispatch("-1402631885", new Object[]{this, bitmapSupplier, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(bitmapSupplier, "pool");
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width = i / bitmap.getWidth();
        Bitmap bitmap2 = bitmapSupplier.get(i, (int) (bitmap.getHeight() * width), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        b41.h(bitmap2, "pool.get(width, (toCrop.… Bitmap.Config.ARGB_8888)");
        matrix.setScale(width, width);
        float f = (int) 0.5f;
        matrix.postTranslate(f, f);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i, (int) (bitmap.getHeight() * width), jg1.INSTANCE.e(bitmap));
        }
        b41.h(bitmap2, "result");
        j(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        e(canvas);
        return bitmap2;
    }

    public final void j(@NotNull Bitmap bitmap, @NotNull Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423695809")) {
            ipChange.ipc$dispatch("1423695809", new Object[]{this, bitmap, bitmap2});
            return;
        }
        b41.i(bitmap, "inBitmap");
        b41.i(bitmap2, "outBitmap");
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
