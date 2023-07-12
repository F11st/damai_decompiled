package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
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
/* loaded from: classes4.dex */
public class rp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BIT32 = 7;
    public static final int BIT64 = 8;
    public static final int UNKNOWN = -1;
    private static int a = -1;

    @NonNull
    public static int a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23212501")) {
            return ((Integer) ipChange.ipc$dispatch("-23212501", new Object[]{context})).intValue();
        }
        if (e(context) == 8) {
            return 8;
        }
        return d();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(android.content.Context r4) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.rp.$ipChange
            java.lang.String r1 = "-1213985108"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1b
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            return r4
        L1b:
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()
            java.util.Set r4 = f(r4)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 7
            if (r0 < r1) goto L66
            java.lang.String[] r0 = android.os.Build.SUPPORTED_64_BIT_ABIS
            int r0 = r0.length
            if (r0 != 0) goto L30
            return r2
        L30:
            r0 = 8
            if (r4 == 0) goto L65
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L3b
            goto L65
        L3b:
            java.util.Iterator r4 = r4.iterator()
        L3f:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "arm64-v8a"
            boolean r3 = r3.endsWith(r1)
            if (r3 != 0) goto L63
            java.lang.String r3 = "x86_64"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L63
            java.lang.String r3 = "mips64"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L3f
        L63:
            return r0
        L64:
            return r2
        L65:
            return r0
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.rp.b(android.content.Context):int");
    }

    private static int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196426611")) {
            return ((Integer) ipChange.ipc$dispatch("1196426611", new Object[]{str})).intValue();
        }
        if (str == null) {
            return -1;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return (Build.VERSION.SDK_INT < 21 || !file.getName().toLowerCase().startsWith("arm64")) ? 7 : 8;
        }
        return -1;
    }

    public static int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959151957")) {
            return ((Integer) ipChange.ipc$dispatch("959151957", new Object[0])).intValue();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String str = Build.SUPPORTED_ABIS[0];
            if (str.toLowerCase().startsWith("arm64") || str.toLowerCase().startsWith("x86_64") || str.toLowerCase().startsWith("mips64")) {
                return 8;
            }
            return (str.toLowerCase().startsWith("armeabi") || str.toLowerCase().startsWith("armeabi-v7a") || str.toLowerCase().startsWith(DeviceUtils.ABI_X86)) ? 7 : -1;
        }
        return 7;
    }

    public static int e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216064017")) {
            return ((Integer) ipChange.ipc$dispatch("216064017", new Object[]{context})).intValue();
        }
        int i = a;
        if (i != -1) {
            return i;
        }
        int c = c(context.getApplicationInfo().nativeLibraryDir);
        if (c == -1) {
            c = b(context);
        }
        a = c;
        Log.d("CpuArch", "getCpuArchValue " + c);
        return c;
    }

    private static Set<String> f(ApplicationInfo applicationInfo) {
        String[] strArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252377905")) {
            return (Set) ipChange.ipc$dispatch("1252377905", new Object[]{applicationInfo});
        }
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
}
