package com.alibaba.security.common.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g {
    private static String a = "g";
    private static String b;
    private static String c;

    public static String a() {
        return b;
    }

    private static String b(Context context) {
        if (Environment.getExternalStorageState().equals("mounted") && context.getExternalCacheDir() != null) {
            c = context.getExternalCacheDir().getAbsolutePath() + File.separator + "gesture";
        } else {
            c = context.getFilesDir().getAbsolutePath() + File.separator + "gesture";
        }
        return c;
    }

    private static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static byte[] d(String str) throws IOException {
        byte[] bArr;
        FileInputStream fileInputStream = null;
        byte[] bArr2 = null;
        fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    fileInputStream2.close();
                    return bArr2;
                } catch (Exception unused) {
                    bArr = bArr2;
                    fileInputStream = fileInputStream2;
                    com.alibaba.security.common.c.a.b();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused2) {
            bArr = null;
        }
    }

    public static String a(String str, Context context) {
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream;
        String str2 = c(str) + str.substring(str.lastIndexOf("."));
        if (Environment.getExternalStorageState().equals("mounted") && context.getExternalCacheDir() != null) {
            c = context.getExternalCacheDir().getAbsolutePath() + File.separator + "gesture";
        } else {
            c = context.getFilesDir().getAbsolutePath() + File.separator + "gesture";
        }
        String str3 = c;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str3, str2);
        if (file2.exists()) {
            return file2.getPath();
        }
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception unused) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    th = th2;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    String path = file2.getPath();
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    return path;
                } catch (Exception unused4) {
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return "";
                        } catch (IOException unused6) {
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    throw th;
                }
            }
            return "";
        } catch (Exception unused9) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            inputStream = null;
        }
    }

    public static byte[] b(String str) {
        try {
            File file = new File(str);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bArr, 0, length);
            bufferedInputStream.close();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, Context context) {
        FileOutputStream fileOutputStream;
        String valueOf = String.valueOf((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
        if (Environment.getExternalStorageState().equals("mounted") && context.getExternalCacheDir() != null) {
            b = context.getExternalCacheDir().getAbsolutePath() + File.separator + "verify";
        } else {
            b = context.getFilesDir().getAbsolutePath() + File.separator + "verify";
        }
        String str = b;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str, valueOf);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (IOException unused) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            String path = file2.getPath();
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
            return path;
        } catch (IOException unused3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static String a(Context context) {
        if (Environment.getExternalStorageState().equals("mounted") && context.getExternalCacheDir() != null) {
            b = context.getExternalCacheDir().getAbsolutePath() + File.separator + "verify";
        } else {
            b = context.getFilesDir().getAbsolutePath() + File.separator + "verify";
        }
        return b;
    }

    public static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 50 && i >= 0) {
            byteArrayOutputStream.reset();
            i -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0 || i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth(), bitmap.getHeight());
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap != createBitmap) {
                bitmap.recycle();
                return createBitmap;
            }
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap a(String str) {
        if (str != null && new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = a(options);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                return BitmapFactory.decodeStream(new FileInputStream(str), null, options);
            } catch (Exception unused) {
                com.alibaba.security.common.c.a.b();
            }
        }
        return null;
    }

    private static int a(BitmapFactory.Options options) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = 1;
        if (i > 480 || i2 > 800) {
            int i4 = i / 2;
            int i5 = i2 / 2;
            while (i4 / i3 > 480 && i5 / i3 > 800) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public static void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    public static String a(Context context, String str, String str2) {
        try {
            byte[] d = d(str2);
            if (d != null) {
                String a2 = c.a(str);
                Key a3 = c.a(Base64.decode(a2, 0));
                Cipher cipher = Cipher.getInstance(c.b);
                byte[] bArr = new byte[8];
                for (int i = 0; i < 8 && i < a2.getBytes().length; i++) {
                    bArr[i] = a2.getBytes()[i];
                }
                cipher.init(2, a3, new IvParameterSpec(bArr));
                return a(cipher.doFinal(d), context);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
