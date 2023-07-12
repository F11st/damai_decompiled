package com.youku.arch.solid.util;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ta.utdid2.android.utils.SystemProperties;
import com.youku.arch.solid.Solid;
import java.io.File;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tb.y90;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AbiUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "Solid.AbiUtils";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum AbiType {
        UN_KNOW(-1),
        ABI_32(32),
        ABI_64(64);
        
        public final int code;

        AbiType(int i) {
            this.code = i;
        }
    }

    public static AbiType checkAbiType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-531716334")) {
            return (AbiType) ipChange.ipc$dispatch("-531716334", new Object[0]);
        }
        if (!isSpecial32Device() && getCpuArchValueFromApk() != AbiType.ABI_32) {
            return AbiType.ABI_64;
        }
        return AbiType.ABI_32;
    }

    public static String getCpuAbi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094533650")) {
            return (String) ipChange.ipc$dispatch("-1094533650", new Object[0]);
        }
        String str = SystemProperties.get("ro.product.cpu.abi");
        if (TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT >= 21) {
                str = Build.SUPPORTED_ABIS[0];
            } else {
                str = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return getCpuArchValueFromNativeLibraryDir() + "";
        }
        return str;
    }

    public static AbiType getCpuArchValueFromApk() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655593759")) {
            return (AbiType) ipChange.ipc$dispatch("-1655593759", new Object[0]);
        }
        AbiType abiType = AbiType.ABI_64;
        Application application = Solid.getInstance().getConfig().getApplication();
        if (application == null) {
            Log.e(TAG, "context is null");
            return abiType;
        }
        Set<String> supportedAbis = getSupportedAbis(application.getApplicationInfo());
        String cpuAbi = getCpuAbi();
        return supportedAbis.contains(cpuAbi) ? (!cpuAbi.startsWith("arm64") && cpuAbi.startsWith("arm")) ? AbiType.ABI_32 : abiType : (!supportedAbis.contains("arm64-v8a") && supportedAbis.contains("armeabi-v7a")) ? AbiType.ABI_32 : abiType;
    }

    public static AbiType getCpuArchValueFromNativeLibraryDir() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720360818")) {
            return (AbiType) ipChange.ipc$dispatch("-720360818", new Object[0]);
        }
        Application application = Solid.getInstance().getConfig().getApplication();
        if (application == null) {
            Log.e(TAG, "context is null");
            return AbiType.ABI_64;
        }
        String str = application.getApplicationInfo().nativeLibraryDir;
        AbiType abiType = AbiType.ABI_64;
        if (TextUtils.isEmpty(str)) {
            return abiType;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return abiType;
            }
            return (Build.VERSION.SDK_INT < 21 || !name.toLowerCase().startsWith("arm64")) ? AbiType.ABI_32 : abiType;
        }
        return abiType;
    }

    private static Set<String> getSupportedAbis(ApplicationInfo applicationInfo) {
        String[] strArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771409221")) {
            return (Set) ipChange.ipc$dispatch("-1771409221", new Object[]{applicationInfo});
        }
        HashSet<String> hashSet = new HashSet();
        String str = applicationInfo.sourceDir;
        if (str != null) {
            hashSet.add(str);
        }
        if (Build.VERSION.SDK_INT >= 21 && (strArr = applicationInfo.splitSourceDirs) != null) {
            hashSet.addAll(Arrays.asList(strArr));
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : hashSet) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(str2).entries();
                while (entries.hasMoreElements()) {
                    File parentFile = new File(entries.nextElement().getName()).getParentFile();
                    if (parentFile != null && parentFile.getPath().startsWith("lib/")) {
                        hashSet2.add(parentFile.getName());
                    }
                }
            } catch (Exception unused) {
            }
        }
        return hashSet2;
    }

    public static boolean isLibraryPath64() {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1854857896")) {
            return ((Boolean) ipChange.ipc$dispatch("-1854857896", new Object[0])).booleanValue();
        }
        String property = System.getProperty("java.library.path");
        Log.e(TAG, "System nativeLibraryDirectories = " + property);
        if (TextUtils.isEmpty(property)) {
            Log.e(TAG, "nativeLibraryDirectories is empty");
            return false;
        }
        for (String str : property.split(":")) {
            Log.e(TAG, "native path = " + str);
            if (!TextUtils.isEmpty(str) && str.contains("64")) {
                Log.e(TAG, "vivo 5.1 device is 64");
                return true;
            }
        }
        Log.e(TAG, "vivo 5.1 device is 32");
        return false;
    }

    public static boolean isLibraryPath64ForVivo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131403355")) {
            return ((Boolean) ipChange.ipc$dispatch("-1131403355", new Object[0])).booleanValue();
        }
        if (!"vivo".equalsIgnoreCase(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND())) {
            Log.e(TAG, "not vivo device");
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("release = ");
        String release = Build.VERSION.getRELEASE();
        sb.append(release);
        Log.e(TAG, sb.toString());
        if (!release.equals("5.1.1") && !release.equals(y90.VER_CODE_OLD)) {
            Log.e(TAG, "not 5.1 device");
            return true;
        }
        return isLibraryPath64();
    }

    public static boolean isSpecial32Device() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1630631672") ? ((Boolean) ipChange.ipc$dispatch("-1630631672", new Object[0])).booleanValue() : !isLibraryPath64ForVivo() || isXiaomiX86();
    }

    public static boolean isXiaomiX86() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2010732091")) {
            return ((Boolean) ipChange.ipc$dispatch("2010732091", new Object[0])).booleanValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("brand = ");
        String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
        sb.append(brand);
        Log.e(TAG, sb.toString());
        if (TextUtils.isEmpty(android.os.Build.BOARD)) {
            return false;
        }
        if (!brand.toLowerCase().contains("xiaomi")) {
            Log.e(TAG, "not xiaomi device");
            return false;
        }
        return getCpuAbi().startsWith(DeviceUtils.ABI_X86);
    }
}
