package android.taobao.windvane.runtimepermission;

import android.content.Context;
import android.taobao.windvane.jsbridge.IPermissionDeniedCallBack;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class PermissionChecker {
    public static final String PERMISSION_ALLOW = "allow";
    public static final String PERMISSION_DENY = "deny";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class PermissionCheckTask {
        private Context context;
        private IPermissionDeniedCallBack permissionDeniedCallBack;
        private Runnable permissionGrantedRunnable;
        private String[] permissions;

        public void execute() {
            String[] strArr;
            ArrayList arrayList = new ArrayList();
            for (String str : this.permissions) {
                try {
                    if (ContextCompat.checkSelfPermission(this.context, str) != 0) {
                        arrayList.add(str);
                    }
                } catch (Throwable unused) {
                    this.permissionGrantedRunnable.run();
                    return;
                }
            }
            if (arrayList.size() == 0) {
                this.permissionGrantedRunnable.run();
            } else {
                this.permissionDeniedCallBack.onPermissionDenied(arrayList);
            }
        }

        public PermissionCheckTask setTaskOnPermissionDenied(IPermissionDeniedCallBack iPermissionDeniedCallBack) {
            this.permissionDeniedCallBack = iPermissionDeniedCallBack;
            return this;
        }

        public PermissionCheckTask setTaskOnPermissionGranted(Runnable runnable) {
            Objects.requireNonNull(runnable, "permissionGrantedRunnable is null");
            this.permissionGrantedRunnable = runnable;
            return this;
        }
    }

    public static synchronized PermissionCheckTask buildPermissionTask(Context context, String[] strArr) {
        PermissionCheckTask permissionCheckTask;
        synchronized (PermissionChecker.class) {
            if (context != null) {
                if (strArr != null && strArr.length != 0) {
                    permissionCheckTask = new PermissionCheckTask();
                    permissionCheckTask.context = context;
                    permissionCheckTask.permissions = strArr;
                } else {
                    throw new NullPointerException("permissions can not be null");
                }
            } else {
                throw new NullPointerException("context can not be null");
            }
        }
        return permissionCheckTask;
    }

    public static Map<String, String> checkPermissions(Context context, String[] strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, str.contains("permission") ? str : "android.permission." + str);
            }
        }
        HashMap hashMap2 = new HashMap();
        for (String str2 : hashMap.keySet()) {
            try {
                if (ContextCompat.checkSelfPermission(context, (String) hashMap.get(str2)) != 0) {
                    hashMap2.put(str2, PERMISSION_DENY);
                } else {
                    hashMap2.put(str2, PERMISSION_ALLOW);
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap2;
    }
}
