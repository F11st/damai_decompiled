package io.flutter.plugins.deviceinfo;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alimm.xadsdk.request.builder.IRequestConst;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String[] EMPTY_STRING_LIST = new String[0];
    private final ContentResolver contentResolver;
    private final PackageManager packageManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodCallHandlerImpl(ContentResolver contentResolver, PackageManager packageManager) {
        this.contentResolver = contentResolver;
        this.packageManager = packageManager;
    }

    @SuppressLint({"HardwareIds"})
    private String getAndroidId() {
        return Settings.Secure.getString(this.contentResolver, "android_id");
    }

    private String[] getSystemFeatures() {
        FeatureInfo[] systemAvailableFeatures = this.packageManager.getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return EMPTY_STRING_LIST;
        }
        String[] strArr = new String[systemAvailableFeatures.length];
        for (int i = 0; i < systemAvailableFeatures.length; i++) {
            strArr[i] = systemAvailableFeatures[i].name;
        }
        return strArr;
    }

    private boolean isEmulator() {
        if (!Build.getBRAND().startsWith("generic") || !android.os.Build.DEVICE.startsWith("generic")) {
            String str = android.os.Build.FINGERPRINT;
            if (!str.startsWith("generic") && !str.startsWith("unknown")) {
                String str2 = android.os.Build.HARDWARE;
                if (!str2.contains("goldfish") && !str2.contains("ranchu")) {
                    String model = Build.getMODEL();
                    if (!model.contains("google_sdk") && !model.contains("Emulator") && !model.contains("Android SDK built for x86") && !Build.getMANUFACTURER().contains("Genymotion")) {
                        String product = Build.getPRODUCT();
                        if (!product.contains("sdk_google") && !product.contains("google_sdk") && !product.contains(C3834a.C3835a.a) && !product.contains("sdk_x86") && !product.contains("vbox86p") && !product.contains("emulator") && !product.contains("simulator")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getAndroidDeviceInfo")) {
            HashMap hashMap = new HashMap();
            hashMap.put("board", android.os.Build.BOARD);
            hashMap.put("bootloader", android.os.Build.BOOTLOADER);
            hashMap.put("brand", Build.getBRAND());
            hashMap.put("device", android.os.Build.DEVICE);
            hashMap.put("display", android.os.Build.DISPLAY);
            hashMap.put("fingerprint", android.os.Build.FINGERPRINT);
            hashMap.put("hardware", android.os.Build.HARDWARE);
            hashMap.put("host", android.os.Build.HOST);
            hashMap.put("id", android.os.Build.ID);
            hashMap.put("manufacturer", Build.getMANUFACTURER());
            hashMap.put("model", Build.getMODEL());
            hashMap.put("product", Build.getPRODUCT());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                hashMap.put("supported32BitAbis", Arrays.asList(android.os.Build.SUPPORTED_32_BIT_ABIS));
                hashMap.put("supported64BitAbis", Arrays.asList(android.os.Build.SUPPORTED_64_BIT_ABIS));
                hashMap.put("supportedAbis", Arrays.asList(android.os.Build.SUPPORTED_ABIS));
            } else {
                String[] strArr = EMPTY_STRING_LIST;
                hashMap.put("supported32BitAbis", Arrays.asList(strArr));
                hashMap.put("supported64BitAbis", Arrays.asList(strArr));
                hashMap.put("supportedAbis", Arrays.asList(strArr));
            }
            hashMap.put(IRequestConst.TAGS, android.os.Build.TAGS);
            hashMap.put("type", android.os.Build.TYPE);
            hashMap.put("isPhysicalDevice", Boolean.valueOf(!isEmulator()));
            hashMap.put("androidId", getAndroidId());
            hashMap.put("systemFeatures", Arrays.asList(getSystemFeatures()));
            HashMap hashMap2 = new HashMap();
            if (i >= 23) {
                hashMap2.put("baseOS", Build.VERSION.BASE_OS);
                hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
                hashMap2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
            }
            hashMap2.put("codename", Build.VERSION.CODENAME);
            hashMap2.put("incremental", Build.VERSION.INCREMENTAL);
            hashMap2.put("release", Build.VERSION.getRELEASE());
            hashMap2.put("sdkInt", Integer.valueOf(i));
            hashMap.put("version", hashMap2);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }
}
