package android.taobao.windvane.runtimepermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class PermissionProposer {
    private static PermissionRequestTask sCurrentPermissionRequestTask;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class PermissionRequestTask {
        private Context context;
        private String explain;
        private Runnable permissionDeniedRunnable;
        private Runnable permissionGrantedRunnable;
        private String[] permissions;

        private void destroy() {
            this.context = null;
            this.permissionGrantedRunnable = null;
            this.permissionDeniedRunnable = null;
        }

        public void execute() {
            String[] strArr;
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                if (i >= 18) {
                    if (ContextCompat.checkSelfPermission(this.context, this.permissions[0]) == 0) {
                        this.permissionGrantedRunnable.run();
                        return;
                    } else {
                        this.permissionDeniedRunnable.run();
                        return;
                    }
                }
                try {
                    this.permissionGrantedRunnable.run();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            String[] strArr2 = this.permissions;
            if (strArr2.length == 1 && strArr2[0].equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                if (!Settings.canDrawOverlays(this.context)) {
                    Intent intent = new Intent();
                    intent.setClass(this.context, PermissionActivity.class);
                    intent.putExtra("permissions", this.permissions);
                    PermissionRequestTask unused = PermissionProposer.sCurrentPermissionRequestTask = this;
                    this.context.startActivity(intent);
                    return;
                }
                this.permissionGrantedRunnable.run();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : this.permissions) {
                try {
                    if (ContextCompat.checkSelfPermission(this.context, str) != 0) {
                        arrayList.add(str);
                    }
                } catch (Throwable unused2) {
                    this.permissionGrantedRunnable.run();
                    return;
                }
            }
            if (arrayList.size() == 0) {
                this.permissionGrantedRunnable.run();
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClass(this.context, PermissionActivity.class);
            if (!(this.context instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            intent2.putExtra("permissions", this.permissions);
            intent2.putExtra("explain", this.explain);
            PermissionRequestTask unused3 = PermissionProposer.sCurrentPermissionRequestTask = this;
            this.context.startActivity(intent2);
        }

        public Context getContext() {
            return this.context;
        }

        void onPermissionGranted(boolean z) {
            if (z) {
                Runnable runnable = this.permissionGrantedRunnable;
                if (runnable != null) {
                    runnable.run();
                }
            } else {
                Runnable runnable2 = this.permissionDeniedRunnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
            destroy();
        }

        public PermissionRequestTask setRationalStr(String str) {
            this.explain = str;
            return this;
        }

        public PermissionRequestTask setTaskOnPermissionDenied(Runnable runnable) {
            this.permissionDeniedRunnable = runnable;
            return this;
        }

        public PermissionRequestTask setTaskOnPermissionGranted(Runnable runnable) {
            Objects.requireNonNull(runnable, "permissionGrantedRunnable is null");
            this.permissionGrantedRunnable = runnable;
            return this;
        }
    }

    public static synchronized PermissionRequestTask buildPermissionTask(Context context, String[] strArr) {
        PermissionRequestTask permissionRequestTask;
        synchronized (PermissionProposer.class) {
            if (context != null) {
                if (strArr != null && strArr.length != 0) {
                    permissionRequestTask = new PermissionRequestTask();
                    permissionRequestTask.context = context;
                    permissionRequestTask.permissions = strArr;
                } else {
                    throw new NullPointerException("permissions can not be null");
                }
            } else {
                throw new NullPointerException("context can not be null");
            }
        }
        return permissionRequestTask;
    }

    public static synchronized PermissionRequestTask buildSystemAlertPermissionTask(Activity activity) {
        PermissionRequestTask buildPermissionTask;
        synchronized (PermissionProposer.class) {
            buildPermissionTask = buildPermissionTask(activity, new String[]{"android.permission.SYSTEM_ALERT_WINDOW"});
        }
        return buildPermissionTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onActivityResult(int i, int i2, Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionRequestTask permissionRequestTask = sCurrentPermissionRequestTask;
            permissionRequestTask.onPermissionGranted(Settings.canDrawOverlays(permissionRequestTask.getContext()));
        }
        sCurrentPermissionRequestTask = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionRequestTask permissionRequestTask = sCurrentPermissionRequestTask;
        if (permissionRequestTask != null) {
            permissionRequestTask.onPermissionGranted(verifyPermissions(iArr));
            sCurrentPermissionRequestTask = null;
        }
    }

    private static boolean verifyPermissions(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
