package com.alibaba.pictures.share.common.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.alibaba.pictures.share.R$color;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.sb2;
import tb.z11;

/* compiled from: Taobao */
@JvmName(name = "ShareUtil")
/* loaded from: classes8.dex */
public final class ShareUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int a = 300;

    @Nullable
    public static final Bitmap a(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381839528")) {
            return (Bitmap) ipChange.ipc$dispatch("381839528", new Object[]{bitmap, Integer.valueOf(i)});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 80;
        do {
            byteArrayOutputStream.reset();
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            }
            i2 -= 10;
        } while (byteArrayOutputStream.toByteArray().length > i * 1024);
        Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
        if ((!b41.d(bitmap, decodeStream)) && bitmap != null && !bitmap.isRecycled()) {
            m(bitmap);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodeStream;
    }

    @Nullable
    public static final Bitmap b(@NotNull Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973731848")) {
            return (Bitmap) ipChange.ipc$dispatch("973731848", new Object[]{bitmap, Integer.valueOf(i)});
        }
        b41.i(bitmap, "image");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i2 = i * 1024;
        if (byteArrayOutputStream.toByteArray().length < i2) {
            return bitmap;
        }
        while (byteArrayOutputStream.toByteArray().length > i2) {
            float length = i2 / byteArrayOutputStream.toByteArray().length;
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * length), (int) (bitmap.getHeight() * length), false);
            b41.h(bitmap, "Bitmap.createScaledBitma…          false\n        )");
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Nullable
    public static final Bitmap c(@Nullable Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064750093")) {
            return (Bitmap) ipChange.ipc$dispatch("-1064750093", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Application a2 = ShareManager.INSTANCE.a();
        if (a2 != null) {
            paint.setColor(ContextCompat.getColor(a2, R$color.white));
        }
        float f = i;
        canvas.drawRect(0.0f, 0.0f, f, f, paint);
        canvas.drawBitmap(bitmap, (i - bitmap.getWidth()) / 2, (i2 - bitmap.getHeight()) / 2, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    @Nullable
    public static final Bitmap d(@Nullable Bitmap bitmap, int i, int i2) {
        int i3;
        Bitmap createScaledBitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368204657")) {
            return (Bitmap) ipChange.ipc$dispatch("-1368204657", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || i <= 0 || i2 <= 0) {
            return null;
        }
        double d = i;
        double width = bitmap.getWidth();
        double d2 = (d * 1.0d) / width;
        double d3 = i2;
        double height = bitmap.getHeight();
        double max = Math.max(d2, (1.0d * d3) / height);
        if (max == d2) {
            i3 = 0;
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, (int) (height * max), false);
        } else {
            i3 = 0;
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width * max), i2, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i3, i3, i, i2);
        byte[] a2 = z11.a(createBitmap, true);
        if ((a2 != null ? a2.length : 0) > 130000) {
            d(createBitmap, (int) (d * 0.9d), (int) (d3 * 0.9d));
        }
        return createBitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        r2 = r2.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        r3 = kotlin.text.o.F(r2, "http", false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        if (r3 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
        r1 = tb.yd1.a(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
        r1 = android.graphics.BitmapFactory.decodeStream(new java.net.URL(r2).openStream());
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:14:0x0029, B:35:0x0072, B:37:0x0078, B:39:0x0084, B:43:0x008b, B:45:0x008f, B:46:0x0095, B:48:0x009f, B:50:0x00a5, B:52:0x00ab, B:20:0x0038, B:23:0x0040, B:28:0x004a, B:30:0x0056, B:32:0x005e, B:33:0x0063), top: B:81:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:14:0x0029, B:35:0x0072, B:37:0x0078, B:39:0x0084, B:43:0x008b, B:45:0x008f, B:46:0x0095, B:48:0x009f, B:50:0x00a5, B:52:0x00ab, B:20:0x0038, B:23:0x0040, B:28:0x004a, B:30:0x0056, B:32:0x005e, B:33:0x0063), top: B:81:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap e(@org.jetbrains.annotations.Nullable android.content.Context r8, @org.jetbrains.annotations.Nullable com.alibaba.pictures.share.common.share.ShareContent r9) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.common.util.ShareUtil.e(android.content.Context, com.alibaba.pictures.share.common.share.ShareContent):android.graphics.Bitmap");
    }

    @Nullable
    public static final String f(@NotNull Context context, @Nullable Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336072456")) {
            return (String) ipChange.ipc$dispatch("-1336072456", new Object[]{context, bitmap, Boolean.valueOf(z)});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (!b41.d("mounted", Environment.getExternalStorageState())) {
            ShareManager shareManager = ShareManager.INSTANCE;
            if (shareManager.a() != null) {
                Toast.makeText(shareManager.a(), "分享失败，请插入SD卡", 0).show();
            } else {
                sb2.f();
            }
            return null;
        } else if (bitmap == null || bitmap.isRecycled()) {
            return null;
        } else {
            File externalCacheDir = context.getExternalCacheDir();
            File file = new File(String.valueOf(externalCacheDir) + "/share");
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append("/share");
            sb.append(z ? Long.valueOf(System.currentTimeMillis()) : "");
            sb.append(".jpeg");
            File file2 = new File(sb.toString());
            return z11.b(file2, bitmap) != null ? file2.getAbsolutePath() : "";
        }
    }

    public static /* synthetic */ String g(Context context, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return f(context, bitmap, z);
    }

    @Nullable
    public static final Bitmap h(@Nullable Context context, @Nullable ShareContent shareContent, int i) {
        Bitmap createBitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976060604")) {
            return (Bitmap) ipChange.ipc$dispatch("-976060604", new Object[]{context, shareContent, Integer.valueOf(i)});
        }
        Bitmap e = e(context, shareContent);
        if (e != null) {
            int height = e.getHeight();
            int width = e.getWidth();
            if (height >= width) {
                createBitmap = Bitmap.createBitmap(e, 0, (height - width) / 2, width, width, (Matrix) null, false);
                b41.h(createBitmap, "Bitmap.createBitmap(bmp,…idth, width, null, false)");
            } else {
                createBitmap = Bitmap.createBitmap(e, (width - height) / 2, 0, height, height, (Matrix) null, false);
                b41.h(createBitmap, "Bitmap.createBitmap(bmp,…ght, height, null, false)");
            }
            int height2 = createBitmap.getHeight();
            int i2 = a;
            if (height2 > i2) {
                height2 = i2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, height2, height2, true);
            if (!b41.d(createBitmap, createScaledBitmap)) {
                m(createBitmap);
            }
            if (!b41.d(e, createScaledBitmap)) {
                m(e);
            }
            if (shareContent != null) {
                Integer valueOf = Integer.valueOf(shareContent.getTypeIconId());
                if (!(valueOf.intValue() > 0)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(context != null ? context.getResources() : null, valueOf.intValue());
                    b41.h(createScaledBitmap, "thumbBmp");
                    b41.h(decodeResource, RemoteMessageConst.Notification.ICON);
                    Bitmap l = l(createScaledBitmap, decodeResource);
                    m(createScaledBitmap);
                    createScaledBitmap = l;
                }
            }
            b41.h(createScaledBitmap, "thumbBmp");
            return a(b(createScaledBitmap, i), i);
        }
        return null;
    }

    @Nullable
    public static final Bitmap i(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "58299336") ? (Bitmap) ipChange.ipc$dispatch("58299336", new Object[]{bitmap, Integer.valueOf(i)}) : j(bitmap, a, i);
    }

    @Nullable
    public static final Bitmap j(@Nullable Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456130871")) {
            return (Bitmap) ipChange.ipc$dispatch("456130871", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (height >= width) {
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width, (Matrix) null, false);
            b41.h(createBitmap, "Bitmap.createBitmap(bmp,…idth, width, null, false)");
        } else {
            createBitmap = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height, (Matrix) null, false);
            b41.h(createBitmap, "Bitmap.createBitmap(bmp,…ght, height, null, false)");
        }
        int height2 = createBitmap.getHeight();
        if (height2 > i) {
            height2 = i;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, height2, height2, true);
        b41.h(createScaledBitmap, "thumbBmp");
        return a(b(createScaledBitmap, i2), i2);
    }

    @Nullable
    public static final Bitmap k(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128909387")) {
            return (Bitmap) ipChange.ipc$dispatch("-1128909387", new Object[]{bitmap, Integer.valueOf(i)});
        }
        if (bitmap == null) {
            return null;
        }
        Bitmap c = c(bitmap, (bitmap.getHeight() * 5) / 4, bitmap.getHeight());
        return a(c != null ? b(c, i) : null, i);
    }

    private static final Bitmap l(Bitmap bitmap, Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566510557")) {
            return (Bitmap) ipChange.ipc$dispatch("566510557", new Object[]{bitmap, bitmap2});
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Rect rect = new Rect();
        rect.top = (bitmap.getHeight() - min) / 2;
        int width = (bitmap.getWidth() - min) / 2;
        rect.left = width;
        rect.right = width + min;
        rect.bottom = rect.top + min;
        canvas.drawBitmap(bitmap2, (Rect) null, rect, (Paint) null);
        m(bitmap);
        m(bitmap2);
        b41.h(createBitmap, "bitmap");
        return createBitmap;
    }

    public static final void m(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567700888")) {
            ipChange.ipc$dispatch("1567700888", new Object[]{bitmap});
        }
    }

    public static final void n(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009867642")) {
            ipChange.ipc$dispatch("-2009867642", new Object[]{str});
            return;
        }
        b41.i(str, "msg");
        o(str, false);
    }

    public static final void o(@NotNull String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118658318")) {
            ipChange.ipc$dispatch("2118658318", new Object[]{str, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "msg");
        ShareManager.IToast n = ShareManager.INSTANCE.b().n();
        if (n != null) {
            n.showToast(str, z);
        }
    }
}
