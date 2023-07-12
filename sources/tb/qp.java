package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.taobao.update.datasource.UpdateDataSource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qp {
    public static final int BIT32 = -1;
    public static final int BIT64 = 8;
    public static final int UNKNOWN = -1;
    private static int a = -1;

    private static int a(String str) {
        if (str == null) {
            return -1;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return (Build.VERSION.SDK_INT < 21 || !file.getName().toLowerCase().startsWith("arm64")) ? -1 : 8;
        }
        return -1;
    }

    private static Set<String> b(ApplicationInfo applicationInfo) {
        String[] strArr;
        HashSet<String> hashSet = new HashSet();
        hashSet.add(applicationInfo.sourceDir);
        if (Build.VERSION.SDK_INT >= 21 && (strArr = applicationInfo.splitSourceDirs) != null) {
            hashSet.addAll(Arrays.asList(strArr));
        }
        HashSet hashSet2 = new HashSet();
        for (String str : hashSet) {
            ZipFile zipFile = null;
            try {
                try {
                    ZipFile zipFile2 = new ZipFile(str);
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        while (entries.hasMoreElements()) {
                            File parentFile = new File(entries.nextElement().getName()).getParentFile();
                            if (parentFile != null && parentFile.getPath().startsWith("lib/")) {
                                hashSet2.add(parentFile.getName());
                            }
                        }
                        try {
                            zipFile2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        zipFile = zipFile2;
                        e.printStackTrace();
                        if (zipFile != null) {
                            zipFile.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return hashSet2;
    }

    @NonNull
    public static int getCpuArch() {
        if (getCurrentRuntimeCpuArchValue(UpdateDataSource.sContext) == 8) {
            return 8;
        }
        return getCurrentCpuArchValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getCpuArchValueFromApk(android.content.Context r4) {
        /*
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()
            java.util.Set r4 = b(r4)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = -1
            r2 = 21
            if (r0 < r2) goto L4b
            java.lang.String[] r0 = android.os.Build.SUPPORTED_64_BIT_ABIS
            int r0 = r0.length
            if (r0 != 0) goto L15
            return r1
        L15:
            r0 = 8
            if (r4 == 0) goto L4a
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L20
            goto L4a
        L20:
            java.util.Iterator r4 = r4.iterator()
        L24:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L49
            java.lang.Object r2 = r4.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "arm64-v8a"
            boolean r3 = r3.endsWith(r2)
            if (r3 != 0) goto L48
            java.lang.String r3 = "x86_64"
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L48
            java.lang.String r3 = "mips64"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L24
        L48:
            return r0
        L49:
            return r1
        L4a:
            return r0
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qp.getCpuArchValueFromApk(android.content.Context):int");
    }

    public static int getCurrentCpuArchValue() {
        if (Build.VERSION.SDK_INT >= 21) {
            String str = Build.SUPPORTED_ABIS[0];
            if (str.toLowerCase().startsWith("arm64") || str.toLowerCase().startsWith("x86_64") || str.toLowerCase().startsWith("mips64")) {
                return 8;
            }
            if (str.toLowerCase().startsWith("armeabi") || str.toLowerCase().startsWith("armeabi-v7a")) {
                return -1;
            }
            str.toLowerCase().startsWith(DeviceUtils.ABI_X86);
            return -1;
        }
        return -1;
    }

    public static int getCurrentRuntimeCpuArchValue(Context context) {
        int i = a;
        if (i != -1) {
            return i;
        }
        int a2 = a(context.getApplicationInfo().nativeLibraryDir);
        if (a2 == -1) {
            a2 = getCpuArchValueFromApk(context);
        }
        a = a2;
        Log.d("CpuArch", "getCpuArchValue " + a2);
        return a2;
    }
}
