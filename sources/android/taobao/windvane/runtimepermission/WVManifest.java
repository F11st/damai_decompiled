package android.taobao.windvane.runtimepermission;

import android.content.Context;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
class WVManifest {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static final class Permission {
        public static final HashMap<String, String> sPermissionMapping;

        static {
            HashMap<String, String> hashMap = new HashMap<>();
            sPermissionMapping = hashMap;
            hashMap.put("android.permission.READ_CONTACTS", "OP_READ_CONTACTS");
            hashMap.put("android.permission.CAMERA", "OP_CAMERA");
            hashMap.put("android.permission.WRITE_SETTINGS", "OP_WRITE_SETTINGS");
            hashMap.put("android.permission.ACCESS_COARSE_LOCATION", "OP_COARSE_LOCATION");
            hashMap.put("android.permission.ACCESS_FINE_LOCATION", "OP_FINE_LOCATION");
            hashMap.put("android.permission.VIBRATE", "OP_VIBRATE");
            hashMap.put("android.permission.SYSTEM_ALERT_WINDOW", "OP_SYSTEM_ALERT_WINDOW");
            hashMap.put("android.permission.RECORD_AUDIO", "OP_RECORD_AUDIO");
            hashMap.put("android.permission.WAKE_LOCK", "OP_WAKE_LOCK");
        }

        Permission() {
        }

        public static boolean isPermissionGranted(Context context, String[] strArr) {
            Object systemService = context.getSystemService("appops");
            try {
                Class<?> cls = systemService.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("checkOpNoThrow", cls2, cls2, String.class);
                declaredMethod.setAccessible(true);
                for (String str : strArr) {
                    String str2 = sPermissionMapping.get(str);
                    if (str2 != null) {
                        Field declaredField = systemService.getClass().getDeclaredField(str2);
                        declaredField.setAccessible(true);
                        if (((Integer) declaredMethod.invoke(systemService, Integer.valueOf(((Integer) declaredField.get(systemService)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() != 0) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    WVManifest() {
    }
}
