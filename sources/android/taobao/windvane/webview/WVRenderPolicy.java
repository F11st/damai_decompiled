package android.taobao.windvane.webview;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVRenderPolicy {
    public static void disableAccessibility(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean shouldDisableHardwareRenderInLayer() {
        String manufacturer;
        String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        return (model != null && model.contains("GT-I95") && (manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER()) != null && manufacturer.equals("samsung")) && (Build.VERSION.SDK_INT == 18);
    }
}
