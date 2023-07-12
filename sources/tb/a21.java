package tb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.format.DateFormat;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class a21 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static int a(BitmapFactory.Options options, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091710167")) {
            return ((Integer) ipChange.ipc$dispatch("2091710167", new Object[]{options, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i || i4 <= i2) {
            return 1;
        }
        return Math.max(Math.round(i3 / i), Math.round(i4 / i2));
    }

    public static Bitmap b(String str, int i, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089190787")) {
            return (Bitmap) ipChange.ipc$dispatch("1089190787", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            i3 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE : 90 : 180;
        } catch (IOException unused) {
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options, i, i2);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (i3 != 0) {
                Bitmap c = c(decodeFile, i3);
                if (c != decodeFile) {
                    decodeFile.recycle();
                }
                return c;
            }
            return decodeFile;
        } catch (OutOfMemoryError unused2) {
            Log.e("eee", "内存泄露！");
            return null;
        }
    }

    public static Bitmap c(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577518730")) {
            return (Bitmap) ipChange.ipc$dispatch("1577518730", new Object[]{bitmap, Integer.valueOf(i)});
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void d(Context context, File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563605451")) {
            ipChange.ipc$dispatch("1563605451", new Object[]{context, file});
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static String e(Bitmap bitmap, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598820794")) {
            return (String) ipChange.ipc$dispatch("-1598820794", new Object[]{bitmap, str});
        }
        StringBuilder sb = new StringBuilder();
        new DateFormat();
        sb.append((Object) DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)));
        sb.append(".png");
        String sb2 = sb.toString();
        FileOutputStream fileOutputStream = null;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + File.separator + sb2;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream2);
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str2;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            return "";
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
        }
    }

    public static Bitmap f(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491042432")) {
            return (Bitmap) ipChange.ipc$dispatch("-491042432", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(i / width, i2 / height);
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
