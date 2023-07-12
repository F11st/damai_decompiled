package com.youku.skinmanager.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
        return false;
    }

    public static boolean deleteFiles(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return deleteFiles(new File(str), TextUtils.isEmpty(str2) ? null : new File(str2).getParentFile());
    }

    public static String getMD5(String str) {
        int i;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0141: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:62:0x0141 */
    public static String unZipFolder(String str, String str2) {
        FileOutputStream fileOutputStream;
        ZipInputStream zipInputStream;
        FileOutputStream fileOutputStream2;
        ZipInputStream zipInputStream2;
        Log.v(TAG, getMD5(str));
        ZipInputStream zipInputStream3 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(str));
                String str3 = "";
                fileOutputStream2 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.startsWith("__MACOSX") && !name.contains("../")) {
                            if (nextEntry.isDirectory()) {
                                File file = new File(str2 + File.separator + name);
                                StringBuilder sb = new StringBuilder();
                                sb.append("entryName = ");
                                sb.append(name);
                                Log.d(TAG, sb.toString());
                                file.mkdirs();
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = name;
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                String str4 = File.separator;
                                sb2.append(str4);
                                sb2.append(name);
                                File file2 = new File(sb2.toString());
                                if (!file2.exists()) {
                                    Log.d(TAG, "create the file:" + str2 + str4 + name);
                                    file2.getParentFile().mkdirs();
                                    file2.createNewFile();
                                }
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, 0, read);
                                        fileOutputStream3.flush();
                                    }
                                    fileOutputStream3.close();
                                    fileOutputStream2 = fileOutputStream3;
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream2 = fileOutputStream3;
                                    e.printStackTrace();
                                    Log.e(TAG, e.getLocalizedMessage());
                                    if (zipInputStream != null) {
                                        try {
                                            zipInputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            return null;
                                        }
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    new File(str).delete();
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    zipInputStream3 = zipInputStream;
                                    fileOutputStream = fileOutputStream3;
                                    if (zipInputStream3 != null) {
                                        try {
                                            zipInputStream3.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    new File(str).delete();
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                zipInputStream.close();
                String absolutePath = new File(str2 + File.separator + str3).getAbsolutePath();
                try {
                    zipInputStream.close();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    new File(str).delete();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return absolutePath;
            } catch (Exception e6) {
                e = e6;
                zipInputStream = null;
                fileOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            zipInputStream3 = zipInputStream2;
        }
    }

    public static boolean deleteFiles(File file, File file2) {
        File[] listFiles;
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file2 == null || !file2.getAbsolutePath().equalsIgnoreCase(file3.getAbsolutePath())) {
                        deleteFile(file3);
                    }
                }
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
