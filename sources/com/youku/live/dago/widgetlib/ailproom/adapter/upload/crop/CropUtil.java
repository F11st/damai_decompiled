package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.TLogConstant;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CropUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DEBUG = false;
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";
    private static final String TAG = "CropUtil";

    public static int calculateBitmapSampleSize(Context context, Uri uri) throws IOException {
        InputStream openInputStream;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1832750109")) {
            return ((Integer) ipChange.ipc$dispatch("1832750109", new Object[]{context, uri})).intValue();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
        } catch (Throwable th) {
            th = th;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
            closeSilently(openInputStream);
            int maxImageSize = getMaxImageSize(context);
            while (true) {
                if (options.outHeight / i <= maxImageSize && options.outWidth / i <= maxImageSize) {
                    return i;
                }
                i <<= 1;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = openInputStream;
            closeSilently(inputStream);
            throw th;
        }
    }

    public static void closeSilently(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686598278")) {
            ipChange.ipc$dispatch("-1686598278", new Object[]{closeable});
        } else if (closeable == null) {
        } else {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean copyExifRotation(File file, File file2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78936850")) {
            return ((Boolean) ipChange.ipc$dispatch("-78936850", new Object[]{file, file2})).booleanValue();
        }
        if (file != null && file2 != null) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static Bitmap decodeRegionCrop(Context context, Uri uri, Rect rect, int i, int i2, int i3) {
        InputStream inputStream;
        Rect rect2 = rect;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "2072573940")) {
            return (Bitmap) ipChange.ipc$dispatch("2072573940", new Object[]{context, uri, rect2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        InputStream inputStream2 = null;
        r5 = null;
        Bitmap bitmap = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException | IOException | OutOfMemoryError unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            int width = newInstance.getWidth();
            int height = newInstance.getHeight();
            if (i3 != 0) {
                Matrix matrix = new Matrix();
                matrix.setRotate(-i3);
                RectF rectF = new RectF();
                matrix.mapRect(rectF, new RectF(rect2));
                rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            }
            int maxImageSize = getMaxImageSize(context);
            int i4 = 1;
            while (true) {
                if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) / i4 <= maxImageSize && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) / i4 <= maxImageSize) {
                    break;
                }
                i4 <<= 1;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i4;
            Bitmap decodeRegion = newInstance.decodeRegion(rect2, options);
            Matrix matrix2 = new Matrix();
            if (i3 != 0) {
                matrix2.postRotate(i3);
                z = true;
            }
            if (i <= 0 || i2 <= 0) {
                z2 = z;
            } else {
                RotateBitmap rotateBitmap = new RotateBitmap(decodeRegion, i3);
                matrix2.postScale(i / rotateBitmap.getWidth(), i2 / rotateBitmap.getHeight());
            }
            if (z2) {
                decodeRegion = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
            }
            bitmap = decodeRegion;
        } catch (FileNotFoundException | IOException | IllegalArgumentException | OutOfMemoryError unused2) {
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            closeSilently(inputStream2);
            throw th;
        }
        closeSilently(inputStream);
        return bitmap;
    }

    public static int getExifRotation(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790156625")) {
            return ((Integer) ipChange.ipc$dispatch("790156625", new Object[]{file})).intValue();
        }
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                }
                return 90;
            }
            return 180;
        } catch (IOException unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
        if (r3 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
        if (r3 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
        r3.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File getFromMediaUri(android.content.Context r9, android.net.Uri r10) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.CropUtil.$ipChange
            java.lang.String r1 = "108324843"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r9
            r9 = 1
            r2[r9] = r10
            java.lang.Object r9 = r0.ipc$dispatch(r1, r2)
            java.io.File r9 = (java.io.File) r9
            return r9
        L1a:
            r0 = 0
            if (r10 != 0) goto L1e
            return r0
        L1e:
            java.lang.String r1 = r10.getScheme()
            java.lang.String r2 = "file"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L34
            java.io.File r9 = new java.io.File
            java.lang.String r10 = r10.getPath()
            r9.<init>(r10)
            return r9
        L34:
            java.lang.String r1 = r10.getScheme()
            java.lang.String r2 = "content"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Laa
            java.lang.String r1 = "_data"
            java.lang.String r2 = "_display_name"
            java.lang.String[] r5 = new java.lang.String[]{r1, r2}
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L91 java.lang.SecurityException -> L93 java.lang.IllegalArgumentException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r10
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L91 java.lang.SecurityException -> L93 java.lang.IllegalArgumentException -> L9a
            if (r3 == 0) goto L8e
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            if (r4 == 0) goto L8e
            java.lang.String r4 = r10.toString()     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            java.lang.String r5 = "content://com.google.android.gallery3d"
            boolean r4 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            if (r4 == 0) goto L6d
            int r1 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            goto L71
        L6d:
            int r1 = r3.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
        L71:
            r2 = -1
            if (r1 == r2) goto L8e
            java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            if (r2 != 0) goto L8e
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            r3.close()
            return r2
        L87:
            r9 = move-exception
            r0 = r3
            goto La4
        L8a:
            goto L94
        L8c:
            r0 = r3
            goto L9a
        L8e:
            if (r3 == 0) goto Laa
            goto L96
        L91:
            r9 = move-exception
            goto La4
        L93:
            r3 = r0
        L94:
            if (r3 == 0) goto Laa
        L96:
            r3.close()
            goto Laa
        L9a:
            java.io.File r9 = getFromMediaUriPfd(r9, r10)     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto La3
            r0.close()
        La3:
            return r9
        La4:
            if (r0 == 0) goto La9
            r0.close()
        La9:
            throw r9
        Laa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.CropUtil.getFromMediaUri(android.content.Context, android.net.Uri):java.io.File");
    }

    private static File getFromMediaUriPfd(Context context, Uri uri) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        String tempFilename;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359928299")) {
            return (File) ipChange.ipc$dispatch("-359928299", new Object[]{context, uri});
        }
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor());
            try {
                tempFilename = getTempFilename(context);
                fileOutputStream = new FileOutputStream(tempFilename);
            } catch (IOException unused) {
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (IOException unused2) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    File file = new File(tempFilename);
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream);
                    return file;
                }
            }
        } catch (IOException unused3) {
            closeSilently(fileInputStream);
            closeSilently(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            closeSilently(fileInputStream2);
            closeSilently(fileOutputStream);
            throw th;
        }
    }

    private static int getMaxImageSize(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "268315838")) {
            return ((Integer) ipChange.ipc$dispatch("268315838", new Object[]{context})).intValue();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        Point point = new Point();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
        return (int) Math.sqrt(Math.pow(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), 2.0d) + Math.pow(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), 2.0d));
    }

    private static String getTempFilename(Context context) throws IOException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "293821714") ? (String) ipChange.ipc$dispatch("293821714", new Object[]{context}) : File.createTempFile("image", TLogConstant.RUBBISH_DIR, context.getCacheDir()).getAbsolutePath();
    }

    public static boolean saveOutput(Context context, Uri uri, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "95250226") ? ((Boolean) ipChange.ipc$dispatch("95250226", new Object[]{context, uri, bitmap})).booleanValue() : saveOutput(context, uri, bitmap, 100);
    }

    public static boolean saveOutput(Context context, Uri uri, Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342180967")) {
            return ((Boolean) ipChange.ipc$dispatch("-1342180967", new Object[]{context, uri, bitmap, Integer.valueOf(i)})).booleanValue();
        }
        if (uri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = context.getContentResolver().openOutputStream(uri);
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, outputStream);
                }
                return true;
            } catch (FileNotFoundException unused) {
            } finally {
                closeSilently(outputStream);
            }
        }
        return false;
    }
}
