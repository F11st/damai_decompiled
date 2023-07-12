package tv.cjump.jni;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NativeBitmapFactory {
    private static final String a = "NativeBitmapFactory";
    static Field b;
    static boolean c;
    static boolean d;

    public static Bitmap a(int i, int i2, Bitmap.Config config) {
        return b(i, i2, config, config.equals(Bitmap.Config.ARGB_8888));
    }

    public static Bitmap b(int i, int i2, Bitmap.Config config, boolean z) {
        if (c && b != null) {
            return c(i, i2, config, z);
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private static Bitmap c(int i, int i2, Bitmap.Config config, boolean z) {
        int d2 = d(config);
        return Build.VERSION.SDK_INT == 19 ? createBitmap19(i, i2, d2, z) : createBitmap(i, i2, d2, z);
    }

    private static native Bitmap createBitmap(int i, int i2, int i3, boolean z);

    private static native Bitmap createBitmap19(int i, int i2, int i3, boolean z);

    public static int d(Bitmap.Config config) {
        try {
            Field field = b;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    static void e() {
        try {
            Field declaredField = Bitmap.Config.class.getDeclaredField("nativeInt");
            b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            b = null;
            e.printStackTrace();
        }
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT < 11 || (c && b != null);
    }

    public static void g() {
        if (d) {
            return;
        }
        if (!DeviceUtils.g() && !DeviceUtils.h()) {
            d = true;
            c = false;
        } else if (c) {
        } else {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 11 && i < 23) {
                    System.loadLibrary("ndkbitmap");
                    c = true;
                    Log.d(a, "loadLibrary ndkbitmap");
                } else {
                    d = true;
                    c = false;
                    Log.d(a, "os version not loadLibrary ndkbitmap");
                }
            } catch (Error e) {
                e.printStackTrace();
                d = true;
                c = false;
                Log.d(a, "loadLibrary Error");
            } catch (Exception e2) {
                e2.printStackTrace();
                d = true;
                c = false;
                Log.d(a, "loadLibrary Exception");
            }
            if (c) {
                try {
                    boolean init = init();
                    String str = a;
                    Log.d(str, "libInit init");
                    if (!init) {
                        release();
                        d = true;
                        c = false;
                        Log.d(str, "init error");
                    } else {
                        e();
                        if (!i()) {
                            release();
                            d = true;
                            c = false;
                            Log.d(str, "testLib Error");
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    d = true;
                    c = false;
                    Log.d(a, "init Exception");
                }
            }
            String str2 = a;
            Log.e(str2, "loadLibs " + c);
        }
    }

    public static void h() {
        if (c) {
            release();
        }
        b = null;
        c = false;
    }

    @SuppressLint({"NewApi"})
    private static boolean i() {
        if (b == null) {
            return false;
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = c(2, 2, Bitmap.Config.ARGB_8888, true);
                boolean z = bitmap != null && bitmap.getWidth() == 2 && bitmap.getHeight() == 2;
                if (z) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 17 && !bitmap.isPremultiplied()) {
                        bitmap.setPremultiplied(true);
                    }
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint();
                    paint.setColor(SupportMenu.CATEGORY_MASK);
                    paint.setTextSize(20.0f);
                    canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), paint);
                    canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                    if (i >= 17) {
                        z = bitmap.isPremultiplied();
                    }
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return z;
            } catch (Error unused) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            } catch (Exception e) {
                Log.e(a, "exception:" + e.toString());
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            }
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    private static native boolean init();

    private static native boolean release();
}
