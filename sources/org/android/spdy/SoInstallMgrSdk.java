package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    static Context mContext;

    private static String _cpuType() {
        String _getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (_getFieldReflectively == null || _getFieldReflectively.length() == 0 || _getFieldReflectively.equals(NetworkUtil.NETWORK_CLASS_UNKNOWN)) {
            _getFieldReflectively = ARMEABI;
        }
        return _getFieldReflectively.toLowerCase();
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception unused) {
            return NetworkUtil.NETWORK_CLASS_UNKNOWN;
        }
    }

    static boolean _loadUnzipSo(String str, int i, ClassLoader classLoader) {
        try {
            if (isExist(str, i)) {
                if (classLoader == null) {
                    System.load(_targetSoFile(str, i));
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    Method declaredMethod = Runtime.class.getDeclaredMethod("load", String.class, ClassLoader.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(runtime, _targetSoFile(str, i), classLoader);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Error e3) {
            e3.printStackTrace();
            return false;
        }
    }

    static String _targetSoFile(String str, int i) {
        Context context = mContext;
        if (context == null) {
            return "";
        }
        String str2 = "/data/data/" + context.getPackageName() + "/files";
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            str2 = filesDir.getPath();
        }
        return str2 + "/lib" + str + "bk" + i + ".so";
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i) {
        return initSo(str, i, null);
    }

    static boolean isExist(String str, int i) {
        return new File(_targetSoFile(str, i)).exists();
    }

    static void removeSoIfExit(String str, int i) {
        File file = new File(_targetSoFile(str, i));
        if (file.exists()) {
            file.delete();
        }
    }

    static boolean unZipSelectedFiles(String str, int i, ClassLoader classLoader) throws ZipException, IOException {
        Context context;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        String str2 = "lib/armeabi/lib" + str + ".so";
        try {
            context = mContext;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (context == null) {
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (!name.contains("..") && !name.contains("\\") && !name.contains("%")) {
                if (nextElement.getName().startsWith(str2)) {
                    InputStream inputStream = null;
                    FileChannel fileChannel2 = null;
                    try {
                        removeSoIfExit(str, i);
                        InputStream inputStream2 = zipFile.getInputStream(nextElement);
                        try {
                            fileOutputStream = context.openFileOutput(SolidMonitor.CHECK_TYPE_LIB + str + "bk" + i + ".so", 0);
                        } catch (Throwable th) {
                            th = th;
                            fileChannel = null;
                            fileOutputStream = null;
                        }
                        try {
                            fileChannel2 = fileOutputStream.getChannel();
                            byte[] bArr = new byte[1024];
                            int i2 = 0;
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read > 0) {
                                    fileChannel2.write(ByteBuffer.wrap(bArr, 0, read));
                                    i2 += read;
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            inputStream2.close();
                            if (fileChannel2 != null) {
                                try {
                                    fileChannel2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            zipFile.close();
                            if (i2 > 0) {
                                return _loadUnzipSo(str, i, classLoader);
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel = fileChannel2;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            zipFile.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileChannel = null;
                        fileOutputStream = null;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean initSo(java.lang.String r7, int r8, java.lang.ClassLoader r9) {
        /*
            r0 = 1
            r1 = 0
            if (r9 != 0) goto L8
            java.lang.System.loadLibrary(r7)     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            goto L3b
        L8:
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r1] = r5     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            java.lang.Class<java.lang.ClassLoader> r5 = java.lang.ClassLoader.class
            r4[r0] = r5     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            java.lang.Class<java.lang.Runtime> r5 = java.lang.Runtime.class
            java.lang.String r6 = "loadLibrary"
            java.lang.reflect.Method r4 = r5.getDeclaredMethod(r6, r4)     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            r4.setAccessible(r0)     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            r3[r1] = r7     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            r3[r0] = r9     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            r4.invoke(r2, r3)     // Catch: java.lang.Error -> L2c java.lang.UnsatisfiedLinkError -> L31 java.lang.Exception -> L36
            goto L3b
        L2c:
            r0 = move-exception
            r0.printStackTrace()
            goto L3a
        L31:
            r0 = move-exception
            r0.printStackTrace()
            goto L3a
        L36:
            r0 = move-exception
            r0.printStackTrace()
        L3a:
            r0 = 0
        L3b:
            if (r0 != 0) goto L81
            boolean r2 = isExist(r7, r8)     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            if (r2 == 0) goto L4d
            boolean r2 = _loadUnzipSo(r7, r8, r9)     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            if (r2 == 0) goto L4a
            return r2
        L4a:
            removeSoIfExit(r7, r8)     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
        L4d:
            java.lang.String r2 = _cpuType()     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            java.lang.String r3 = "mips"
            boolean r3 = r2.equalsIgnoreCase(r3)     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            if (r3 != 0) goto L81
            java.lang.String r3 = "x86"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            if (r2 == 0) goto L62
            goto L81
        L62:
            boolean r7 = unZipSelectedFiles(r7, r8, r9)     // Catch: java.io.IOException -> L68 java.util.zip.ZipException -> L6d java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            r1 = r7
            goto L82
        L68:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            goto L81
        L6d:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Error -> L72 java.lang.UnsatisfiedLinkError -> L77 java.lang.Exception -> L7c
            goto L81
        L72:
            r7 = move-exception
            r7.printStackTrace()
            goto L82
        L77:
            r7 = move-exception
            r7.printStackTrace()
            goto L82
        L7c:
            r7 = move-exception
            r7.printStackTrace()
            goto L82
        L81:
            r1 = r0
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SoInstallMgrSdk.initSo(java.lang.String, int, java.lang.ClassLoader):boolean");
    }
}
