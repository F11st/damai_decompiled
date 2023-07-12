package com.ta.audid.utils;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean checkFileExistOnly(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (Exception e) {
            UtdidLogger.se(TAG, e, new Object[0]);
            return false;
        }
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                return deleteFile(str);
            }
            return deleteDirectory(str);
        }
        return false;
    }

    private static boolean deleteDirectory(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    z = deleteFile(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    if (listFiles[i].isDirectory() && !(z = deleteDirectory(listFiles[i].getAbsolutePath()))) {
                        break;
                    }
                }
            }
            if (z) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    private static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static void isDirExist(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    UtdidLogger.sd(TAG, "path exists", str);
                } else {
                    UtdidLogger.sd(TAG, "mkdirs path", str, "created", Boolean.valueOf(file.mkdirs()));
                }
            }
        } catch (Exception e) {
            UtdidLogger.se(TAG, e, new Object[0]);
        }
    }

    public static String readFile(String str) {
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(str));
                try {
                    char[] cArr = new char[100];
                    StringBuilder sb = new StringBuilder("");
                    while (true) {
                        int read = inputStreamReader2.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(cArr, 0, read);
                    }
                    String sb2 = sb.toString();
                    try {
                        inputStreamReader2.close();
                    } catch (Exception e) {
                        UtdidLogger.se(TAG, e, new Object[0]);
                    }
                    return sb2;
                } catch (Exception e2) {
                    e = e2;
                    inputStreamReader = inputStreamReader2;
                    UtdidLogger.se(TAG, e, new Object[0]);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e3) {
                            UtdidLogger.se(TAG, e3, new Object[0]);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader = inputStreamReader2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e4) {
                            UtdidLogger.se(TAG, e4, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static boolean saveFile(String str, String str2) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                fileWriter = new FileWriter(new File(str));
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e) {
                            UtdidLogger.se(TAG, e, new Object[0]);
                        }
                        try {
                            fileWriter.close();
                        } catch (Exception e2) {
                            UtdidLogger.se(TAG, e2, new Object[0]);
                        }
                        return true;
                    } catch (Exception e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        UtdidLogger.se(TAG, e, new Object[0]);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e4) {
                                UtdidLogger.se(TAG, e4, new Object[0]);
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e5) {
                                UtdidLogger.se(TAG, e5, new Object[0]);
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e6) {
                                UtdidLogger.se(TAG, e6, new Object[0]);
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e7) {
                                UtdidLogger.se(TAG, e7, new Object[0]);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Exception e9) {
                e = e9;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
