package com.taomai.android.h5container.utils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.util.TaoLog;
import android.util.AndroidRuntimeException;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.alixplayer.MsgID;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageTool {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ImageSaveCallback {
        void error(String str);

        void success();
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.utils.ImageTool$a */
    /* loaded from: classes11.dex */
    static class C7021a extends HttpConnectListener<HttpResponse> {
        final /* synthetic */ Context a;
        final /* synthetic */ ImageSaveCallback b;

        C7021a(Context context, ImageSaveCallback imageSaveCallback) {
            this.a = context;
            this.b = imageSaveCallback;
        }

        @Override // android.taobao.windvane.connect.HttpConnectListener
        public void onError(int i, String str) {
            ImageSaveCallback imageSaveCallback = this.b;
            if (imageSaveCallback != null) {
                imageSaveCallback.error("error get resource, code=[" + i + "],msg=[" + str + jn1.ARRAY_END_STR);
            }
        }

        @Override // android.taobao.windvane.connect.HttpConnectListener
        public void onFinish(HttpResponse httpResponse, int i) {
            try {
                if (httpResponse.isSuccess() && "mounted".equals(Environment.getExternalStorageState())) {
                    if (ImageTool.g(this.a, BitmapFactory.decodeStream(new ByteArrayInputStream(httpResponse.getData())))) {
                        ImageSaveCallback imageSaveCallback = this.b;
                        if (imageSaveCallback != null) {
                            imageSaveCallback.success();
                            return;
                        }
                        return;
                    }
                }
                ImageSaveCallback imageSaveCallback2 = this.b;
                if (imageSaveCallback2 != null) {
                    imageSaveCallback2.error("bad resource");
                }
            } catch (Exception e) {
                ImageSaveCallback imageSaveCallback3 = this.b;
                if (imageSaveCallback3 != null) {
                    imageSaveCallback3.error(e.getMessage());
                }
            } catch (OutOfMemoryError e2) {
                ImageSaveCallback imageSaveCallback4 = this.b;
                if (imageSaveCallback4 != null) {
                    imageSaveCallback4.error(e2.getMessage());
                }
            }
        }
    }

    public static Uri a(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex("_id"));
            Uri parse = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(parse, "" + i);
        }
        File file = new File(str);
        if (file.exists()) {
            return j(context, file, String.format("%d_temp.jpg", Long.valueOf(System.currentTimeMillis())), "temp");
        }
        return null;
    }

    public static void b(String str, final ImageView imageView) {
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            if (str.startsWith("data:")) {
                try {
                    byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1).getBytes(), 0);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    if (imageView != null) {
                        imageView.setImageBitmap(decodeByteArray);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    if (imageView != null) {
                        imageView.setImageBitmap(null);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        ConnectManager.getInstance().connect(str, new HttpConnectListener<HttpResponse>() { // from class: com.taomai.android.h5container.utils.ImageTool.3
            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str2) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taomai.android.h5container.utils.ImageTool.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageView imageView2 = imageView;
                        if (imageView2 != null) {
                            imageView2.setImageBitmap(null);
                        }
                    }
                });
            }

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onFinish(HttpResponse httpResponse, int i) {
                try {
                    if (httpResponse.isSuccess() && "mounted".equals(Environment.getExternalStorageState())) {
                        final Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(httpResponse.getData()));
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taomai.android.h5container.utils.ImageTool.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageView imageView2 = imageView;
                                if (imageView2 != null) {
                                    imageView2.setImageBitmap(decodeStream);
                                }
                            }
                        });
                    }
                } catch (Exception | OutOfMemoryError e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static int c(Context context, String str, Uri uri) {
        ExifInterface exifInterface;
        if (str == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (uri == null) {
                    uri = a(context, str);
                }
                if (uri == null) {
                    return 0;
                }
                exifInterface = new ExifInterface(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor());
            } else {
                exifInterface = new ExifInterface(str);
            }
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap d(String str, int i) {
        if (i > 10240) {
            i = MsgID.MEDIA_INFO_VIDEO_START_RECOVER;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 <= i3) {
            i2 = i3;
        }
        int round = Math.round(i2 / i);
        options.inSampleSize = round >= 1 ? round : 1;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap e(Context context, String str, int i, Uri uri) throws IOException {
        if (i > 10240) {
            i = MsgID.MEDIA_INFO_VIDEO_START_RECOVER;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (Build.VERSION.SDK_INT < 29) {
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 <= i3) {
                i2 = i3;
            }
            int round = Math.round(i2 / i);
            options.inSampleSize = round >= 1 ? round : 1;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } else if (uri == null && (uri = a(context, str)) == null) {
            return null;
        } else {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME);
            FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 <= i5) {
                i4 = i5;
            }
            int round2 = Math.round(i4 / i);
            options.inSampleSize = round2 >= 1 ? round2 : 1;
            options.inJustDecodeBounds = false;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            openFileDescriptor.close();
            return decodeFileDescriptor;
        }
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap != createBitmap ? createBitmap : bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static boolean g(Context context, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (h(context, bitmap)) {
                return true;
            }
            TaoLog.e(com.alipay.ma.util.ImageTool.TAG, "save image failed");
            return false;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), String.valueOf(System.currentTimeMillis()));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00d4: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:43:0x00d4 */
    @SuppressLint({"NewApi"})
    private static boolean h(Context context, Bitmap bitmap) {
        ParcelFileDescriptor parcelFileDescriptor;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", String.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + File.separator + "wv_save_image");
        Uri contentUri = MediaStore.Images.Media.getContentUri("external_primary");
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(contentUri, contentValues);
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                if (insert == null) {
                    new AndroidRuntimeException("android Q: save image error for uri is null").printStackTrace();
                    return false;
                }
                parcelFileDescriptor = contentResolver.openFileDescriptor(insert, WXComponent.PROP_FS_WRAP_CONTENT, null);
                try {
                    fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.flush();
                            fileOutputStream3.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    }
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    throw th;
                }
                try {
                    if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                        new AndroidRuntimeException("android Q: save image failed").printStackTrace();
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            parcelFileDescriptor.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    }
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    contentResolver.update(insert, contentValues, null, null);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        parcelFileDescriptor.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return true;
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    contentResolver.delete(insert, null, null);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    return false;
                }
            } catch (IOException e7) {
                e = e7;
                parcelFileDescriptor = null;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                parcelFileDescriptor = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream3 = fileOutputStream2;
        }
    }

    public static void i(Context context, String str, ImageSaveCallback imageSaveCallback) {
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            if (str.startsWith("data:")) {
                try {
                    byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1).getBytes(), 0);
                    if (!g(context, BitmapFactory.decodeByteArray(decode, 0, decode.length)) || imageSaveCallback == null) {
                        return;
                    }
                    imageSaveCallback.success();
                    return;
                } catch (Throwable th) {
                    if (imageSaveCallback != null) {
                        imageSaveCallback.error(th.getMessage());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        ConnectManager.getInstance().connect(str, new C7021a(context, imageSaveCallback));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri j(android.content.Context r4, java.io.File r5, java.lang.String r6, java.lang.String r7) {
        /*
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "description"
            java.lang.String r2 = "This is an image"
            r0.put(r1, r2)
            java.lang.String r1 = "_display_name"
            r0.put(r1, r6)
            java.lang.String r6 = "mime_type"
            java.lang.String r1 = "image/png"
            r0.put(r6, r1)
            java.lang.String r6 = "title"
            java.lang.String r1 = "Image.png"
            r0.put(r6, r1)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "Pictures/"
            r6.append(r1)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "relative_path"
            r0.put(r7, r6)
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.content.ContentResolver r4 = r4.getContentResolver()
            android.net.Uri r6 = r4.insert(r6, r0)
            r7 = 0
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L8d
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L8d
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L8d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L8d
            if (r6 == 0) goto L56
            java.io.OutputStream r4 = r4.openOutputStream(r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            goto L57
        L52:
            r4 = move-exception
            goto L80
        L54:
            r4 = r0
            goto L8f
        L56:
            r4 = r0
        L57:
            if (r4 == 0) goto L72
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
        L5d:
            int r2 = r1.read(r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            r3 = -1
            if (r2 == r3) goto L68
            r4.write(r5, r7, r2)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            goto L5d
        L68:
            r4.flush()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            goto L72
        L6c:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L80
        L70:
            goto L8f
        L72:
            r7 = 1
            if (r4 == 0) goto L78
            r4.close()     // Catch: java.lang.Exception -> L78
        L78:
            r1.close()     // Catch: java.lang.Exception -> L7c
            goto L99
        L7c:
            goto L99
        L7e:
            r4 = move-exception
            r1 = r0
        L80:
            if (r0 == 0) goto L87
            r0.close()     // Catch: java.lang.Exception -> L86
            goto L87
        L86:
        L87:
            if (r1 == 0) goto L8c
            r1.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            throw r4
        L8d:
            r4 = r0
            r1 = r4
        L8f:
            if (r4 == 0) goto L96
            r4.close()     // Catch: java.lang.Exception -> L95
            goto L96
        L95:
        L96:
            if (r1 == 0) goto L99
            goto L78
        L99:
            if (r7 == 0) goto L9c
            goto L9d
        L9c:
            r6 = r0
        L9d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taomai.android.h5container.utils.ImageTool.j(android.content.Context, java.io.File, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static Bitmap k(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width > height ? width : height;
        if (i2 > i) {
            float f = i / i2;
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return bitmap;
    }
}
