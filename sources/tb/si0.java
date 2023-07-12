package tb;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class si0 {
    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String c(String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(str));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[100];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            String sb2 = sb.toString();
            try {
                inputStreamReader.close();
            } catch (Exception e) {
                Logger.h("", e, new Object[0]);
            }
            return sb2;
        } catch (Exception unused2) {
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e2) {
                    Logger.h("", e2, new Object[0]);
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e3) {
                    Logger.h("", e3, new Object[0]);
                }
            }
            throw th;
        }
    }

    public static boolean d(String str, String str2) {
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
                            Logger.h("", e, new Object[0]);
                        }
                        try {
                            fileWriter.close();
                        } catch (Exception e2) {
                            Logger.h("", e2, new Object[0]);
                        }
                        return true;
                    } catch (Exception e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        Logger.h("", e, new Object[0]);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e4) {
                                Logger.h("", e4, new Object[0]);
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e5) {
                                Logger.h("", e5, new Object[0]);
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
                                Logger.h("", e6, new Object[0]);
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e7) {
                                Logger.h("", e7, new Object[0]);
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
