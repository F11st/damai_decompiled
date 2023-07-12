package com.uploader.implement.a.c;

import android.text.TextUtils;
import android.util.Pair;
import com.uploader.export.IUploaderTask;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.h43;
import tb.k33;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b {
    public static Pair<k33, h43> a(IUploaderTask iUploaderTask) {
        if (iUploaderTask != null) {
            try {
                if (!TextUtils.isEmpty(iUploaderTask.getFilePath()) && !TextUtils.isEmpty(iUploaderTask.getBizType())) {
                    h43 h43Var = new h43();
                    h43Var.a = iUploaderTask.getFilePath();
                    h43Var.e = iUploaderTask.getBizType();
                    h43Var.h = iUploaderTask.getMetaInfo();
                    iUploaderTask.getFileType();
                    File file = new File(h43Var.a);
                    if (!file.exists()) {
                        return new Pair<>(new k33("200", "3", "!file.exists()", false), null);
                    }
                    if (file.length() == 0) {
                        return new Pair<>(new k33("200", "9", "file.length() == 0", false), null);
                    }
                    h43Var.b = file;
                    h43Var.c = file.getName();
                    Pair<String, byte[]> b = b(file);
                    h43Var.g = (String) b.first;
                    h43Var.k = (byte[]) b.second;
                    h43Var.d = UUID.randomUUID().toString().replaceAll("-", "");
                    h43Var.f = file.length();
                    h43Var.j = file.lastModified();
                    return new Pair<>(null, h43Var);
                }
            } catch (Exception e) {
                if (com.uploader.implement.a.d(16)) {
                    com.uploader.implement.a.b(16, "ProtocolUtils", "createFileDescription", e);
                }
                return new Pair<>(new k33("200", "4", e.toString(), false), null);
            }
        }
        return new Pair<>(new k33("200", "4", "task getFilePath == null || getBizType == null", false), null);
    }

    public static Pair<String, byte[]> b(File file) throws Exception {
        ByteBuffer allocate;
        try {
            allocate = ByteBuffer.allocate(204800);
        } catch (OutOfMemoryError unused) {
            allocate = ByteBuffer.allocate(131072);
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                int i = 0;
                while (true) {
                    try {
                        int read = fileInputStream2.getChannel().read(allocate);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(allocate.array(), allocate.arrayOffset(), read);
                        allocate.clear();
                        i++;
                    } catch (NoSuchAlgorithmException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                Pair<String, byte[]> pair = new Pair<>(d(messageDigest.digest()), i == 1 ? allocate.array() : null);
                try {
                    fileInputStream2.close();
                } catch (Exception unused3) {
                }
                return pair;
            } catch (NoSuchAlgorithmException e3) {
                throw e3;
            } catch (Exception e4) {
                throw e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private static String d(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
