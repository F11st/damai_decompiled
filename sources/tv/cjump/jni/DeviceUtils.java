package tv.cjump.jni;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DeviceUtils {
    public static final String ABI_MIPS = "mips";
    public static final String ABI_X86 = "x86";
    private static ARCH a = ARCH.Unknown;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum ARCH {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    public static synchronized ARCH a() {
        RandomAccessFile randomAccessFile;
        ?? r3;
        synchronized (DeviceUtils.class) {
            byte[] bArr = new byte[20];
            File file = new File(Environment.getRootDirectory(), "lib/libc.so");
            if (file.canRead()) {
                RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
                    } catch (FileNotFoundException e) {
                        e = e;
                    } catch (IOException e2) {
                        e = e2;
                    }
                    try {
                        randomAccessFile.readFully(bArr);
                        r3 = 8;
                        r3 = 8;
                        r3 = 8;
                        r3 = 8;
                        int i = bArr[18] | (bArr[19] << 8);
                        if (i == 3) {
                            a = ARCH.X86;
                        } else if (i == 8) {
                            a = ARCH.MIPS;
                        } else if (i == 40) {
                            a = ARCH.ARM;
                        } else if (i != 183) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("libc.so is unknown arch: ");
                            sb.append(Integer.toHexString(i));
                            Log.e("NativeBitmapFactory", sb.toString());
                            r3 = sb;
                        } else {
                            a = ARCH.ARM64;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e4) {
                                e = e4;
                                e.printStackTrace();
                                return a;
                            }
                        }
                        return a;
                    } catch (IOException e5) {
                        e = e5;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e6) {
                                e = e6;
                                e.printStackTrace();
                                return a;
                            }
                        }
                        return a;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        randomAccessFile2 = r3;
                    } catch (IOException e8) {
                        e = e8;
                        e.printStackTrace();
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return a;
    }

    public static String b() {
        return Build.getCPU_ABI();
    }

    public static String c() {
        try {
            Field declaredField = android.os.Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d() {
        return Build.getMANUFACTURER().equalsIgnoreCase("MagicBox") && Build.getPRODUCT().equalsIgnoreCase("MagicBox");
    }

    public static boolean e() {
        return Build.getMANUFACTURER().equalsIgnoreCase("Xiaomi") && Build.getPRODUCT().equalsIgnoreCase("dredd");
    }

    public static boolean f() {
        return e() || d();
    }

    public static boolean g() {
        return (i("armeabi-v7a") || i("armeabi")) && ARCH.ARM.equals(a());
    }

    public static boolean h() {
        return i(ABI_X86) || ARCH.X86.equals(a());
    }

    public static boolean i(String str) {
        try {
            String b = b();
            if (TextUtils.isEmpty(b) || !b.equalsIgnoreCase(str)) {
                String c = c();
                if (TextUtils.isEmpty(c)) {
                    return false;
                }
                return c.equalsIgnoreCase(str);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
