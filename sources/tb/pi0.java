package tb;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class pi0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final pi0 INSTANCE = new pi0();

    private pi0() {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.io.File b(android.content.Context r11, android.net.Uri r12, java.lang.String r13) {
        /*
            r10 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.pi0.$ipChange
            java.lang.String r1 = "1026629341"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L20
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r10
            r3 = 1
            r2[r3] = r11
            r11 = 2
            r2[r11] = r12
            r11 = 3
            r2[r11] = r13
            java.lang.Object r11 = r0.ipc$dispatch(r1, r2)
            java.io.File r11 = (java.io.File) r11
            return r11
        L20:
            r0 = 0
            if (r13 == 0) goto L45
            java.lang.String r5 = "."
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r13
            int r1 = kotlin.text.C8596g.f0(r4, r5, r6, r7, r8, r9)     // Catch: java.io.IOException -> L89
            if (r1 < 0) goto L45
            java.lang.String r5 = "."
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r13
            int r1 = kotlin.text.C8596g.f0(r4, r5, r6, r7, r8, r9)     // Catch: java.io.IOException -> L89
            java.lang.String r13 = r13.substring(r1)     // Catch: java.io.IOException -> L89
            java.lang.String r1 = "(this as java.lang.String).substring(startIndex)"
            tb.b41.h(r13, r1)     // Catch: java.io.IOException -> L89
            goto L46
        L45:
            r13 = r0
        L46:
            android.content.ContentResolver r1 = r11.getContentResolver()     // Catch: java.io.IOException -> L89
            java.io.InputStream r12 = r1.openInputStream(r12)     // Catch: java.io.IOException -> L89
            java.lang.String r1 = "upload_compress"
            java.io.File r11 = r11.getCacheDir()     // Catch: java.io.IOException -> L89
            java.io.File r11 = java.io.File.createTempFile(r1, r13, r11)     // Catch: java.io.IOException -> L89
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L89
            r13.<init>(r11)     // Catch: java.io.IOException -> L89
            if (r12 == 0) goto L88
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L7a
        L63:
            int r2 = r12.read(r1)     // Catch: java.lang.Throwable -> L7a
            r4 = -1
            if (r2 == r4) goto L6e
            r13.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L7a
            goto L63
        L6e:
            r13.flush()     // Catch: java.lang.Throwable -> L7a
            tb.wt2 r1 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> L7a
            tb.xj.a(r13, r0)     // Catch: java.lang.Throwable -> L81
            tb.xj.a(r12, r0)     // Catch: java.io.IOException -> L89
            goto L88
        L7a:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L7c
        L7c:
            r1 = move-exception
            tb.xj.a(r13, r11)     // Catch: java.lang.Throwable -> L81
            throw r1     // Catch: java.lang.Throwable -> L81
        L81:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L83
        L83:
            r13 = move-exception
            tb.xj.a(r12, r11)     // Catch: java.io.IOException -> L89
            throw r13     // Catch: java.io.IOException -> L89
        L88:
            return r11
        L89:
            r11 = move-exception
            com.alibaba.pictures.uploader.FileUploader$a r12 = com.alibaba.pictures.uploader.FileUploader.Companion
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "copyAndSaveFile:"
            r13.append(r1)
            r13.append(r11)
            java.lang.String r13 = r13.toString()
            r12.h(r13)
            r11.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pi0.b(android.content.Context, android.net.Uri, java.lang.String):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: Exception -> 0x00ee, TryCatch #2 {Exception -> 0x00ee, blocks: (B:10:0x0028, B:12:0x0037, B:19:0x0044, B:21:0x0050, B:28:0x007d, B:37:0x008c, B:41:0x0095, B:43:0x009b, B:44:0x00a1, B:46:0x00ad, B:48:0x00b3, B:53:0x00bd, B:55:0x00c3, B:57:0x00cb, B:62:0x00dd, B:64:0x00e7, B:60:0x00d7, B:23:0x0062, B:25:0x0068, B:27:0x007b), top: B:71:0x0028 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(@org.jetbrains.annotations.Nullable android.content.Context r14, @org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pi0.a(android.content.Context, java.lang.String):java.lang.String");
    }

    @JvmOverloads
    @Nullable
    public final Bitmap c(@NotNull Context context, @Nullable String str, @Nullable BitmapFactory.Options options) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346443029")) {
            return (Bitmap) ipChange.ipc$dispatch("346443029", new Object[]{this, context, str, options});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ParcelFileDescriptor e = e(context, str);
            if (e != null) {
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(e.getFileDescriptor(), null, options);
                xj.a(e, null);
                return decodeFileDescriptor;
            }
        } catch (Exception e2) {
            FileUploader.C3645a c3645a = FileUploader.Companion;
            c3645a.h("MoImageDecodeHelper.decodeImageFile:" + e2);
        }
        return null;
    }

    @Nullable
    public final Uri d(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173529916")) {
            return (Uri) ipChange.ipc$dispatch("173529916", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, AbstractC3893a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        query.close();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        return Uri.withAppendedPath(uri, "" + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[Catch: Exception -> 0x00e7, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e7, blocks: (B:10:0x0024, B:12:0x0033, B:19:0x0040, B:22:0x004e, B:23:0x0058, B:25:0x0064, B:27:0x006a, B:33:0x0075, B:34:0x007e, B:44:0x00c6, B:45:0x00dd, B:39:0x009a, B:36:0x0090, B:41:0x00b2), top: B:52:0x0024, inners: #0, #2 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.ParcelFileDescriptor e(@org.jetbrains.annotations.Nullable android.content.Context r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pi0.e(android.content.Context, java.lang.String):android.os.ParcelFileDescriptor");
    }

    @Nullable
    public final Uri f(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624635812")) {
            return (Uri) ipChange.ipc$dispatch("-1624635812", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, AbstractC3893a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        query.close();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        return Uri.withAppendedPath(uri, "" + i);
    }

    public final boolean g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690128929")) {
            return ((Boolean) ipChange.ipc$dispatch("-690128929", new Object[]{this, str})).booleanValue();
        }
        if (str == null) {
            return false;
        }
        try {
            File file = new File(str);
            if (Build.VERSION.SDK_INT == 29) {
                if (!file.canRead()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            FileUploader.C3645a c3645a = FileUploader.Companion;
            c3645a.h("MoImageDecodeHelper:isFileNotAccess:" + e);
            return false;
        }
    }

    public final int h(@NotNull Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "267028326")) {
            return ((Integer) ipChange.ipc$dispatch("267028326", new Object[]{this, context, str})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            ParcelFileDescriptor e = e(context, str);
            if (e != null) {
                i = new ExifInterface(e.getFileDescriptor()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                wt2 wt2Var = wt2.INSTANCE;
                xj.a(e, null);
            }
        } catch (Exception e2) {
            FileUploader.C3645a c3645a = FileUploader.Companion;
            c3645a.h("MoImageDecodeHelper:readImageRotation:" + e2);
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public final Bitmap i(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "384474481")) {
            return (Bitmap) ipChange.ipc$dispatch("384474481", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        if (i == 1 || i == 0 || bitmap == null) {
            return bitmap;
        }
        int i2 = 90;
        switch (i) {
            case 1:
            default:
                i2 = 0;
                break;
            case 2:
                i2 = 0;
                z = true;
                break;
            case 3:
                i2 = 180;
                break;
            case 4:
                i2 = 180;
                z = true;
                break;
            case 5:
                i2 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                z = true;
                break;
            case 6:
                break;
            case 7:
                z = true;
                break;
            case 8:
                i2 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                break;
        }
        Matrix matrix = new Matrix();
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
        }
        if (i2 != 0) {
            matrix.postRotate(i2);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
