package tb;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import com.alibaba.wireless.security.aopsdk.replace.android.content.pm.PackageManager;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.google.vr.cardboard.R$string;
import com.google.vr.cardboard.R$style;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class h5 {
    public static final int FLAG_VR_MODE_ENABLE_FALLBACK = 1;
    public static final int NMR1_SDK_LEVEL = 25;
    public static final int N_SDK_LEVEL = 24;
    private static final String a = "h5";
    private static int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.google.vr.vrcore"));
            intent.setPackage("com.android.vending");
            try {
                this.a.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Log.e(h5.a, "Google Play Services is not installed, unable to download VrCore.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.startActivity(new Intent("android.settings.VR_LISTENER_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private static int b(Context context) {
        boolean z;
        Iterator it = PackageManager.getInstalledApplications(context.getPackageManager(), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((ApplicationInfo) it.next()).packageName.equals("com.google.vr.vrcore")) {
                z = true;
                break;
            }
        }
        if (z) {
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_vr_listeners");
            return (string == null || !string.contains(new ComponentName("com.google.vr.vrcore", "com.google.vr.vrcore.common.VrCoreListenerService").flattenToString())) ? -2 : 0;
        }
        return -1;
    }

    private static boolean c(Context context, int i) {
        if (i == -1) {
            k(context, R$string.dialog_vr_core_not_installed, R$string.go_to_playstore_button, new a(context));
            return false;
        } else if (i == -2) {
            k(context, R$string.dialog_vr_core_not_enabled, R$string.go_to_vr_listeners_settings_button, new b(context));
            return false;
        } else {
            return true;
        }
    }

    private static boolean d() {
        return b >= 24 || Build.VERSION.SDK_INT >= 24;
    }

    private static boolean e() {
        return b >= 25 || "NMR1".equals(Build.VERSION.CODENAME) || Build.VERSION.SDK_INT >= 25;
    }

    public static boolean f(Context context) {
        return d() && context.getPackageManager().hasSystemFeature("android.software.vr.mode");
    }

    public static boolean g(Activity activity, boolean z) {
        if (d()) {
            if (!((PowerManager) activity.getSystemService("power")).isSustainedPerformanceModeSupported()) {
                Log.d(a, "Sustained performance mode is not supported on this device.");
                return false;
            }
            Window window = activity.getWindow();
            if (window == null) {
                Log.e(a, "Activity does not have a window");
                return false;
            }
            window.setSustainedPerformanceMode(z);
            return true;
        }
        return false;
    }

    public static boolean h(Activity activity, boolean z) {
        return i(activity, z, 1);
    }

    public static boolean i(Activity activity, boolean z, int i) {
        if (!f(activity)) {
            if (d()) {
                Log.d(a, "VR mode is not supported on this N device.");
            }
            return false;
        }
        try {
            activity.setVrModeEnabled(z, new ComponentName("com.google.vr.vrcore", "com.google.vr.vrcore.common.VrCoreListenerService"));
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            String str = a;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("No VR service component: ");
            sb.append(valueOf);
            Log.w(str, sb.toString());
            if ((i & 1) != 0 && c(activity, b(activity))) {
                Log.w(a, "Failed to handle missing VrCore package.");
            }
            return false;
        } catch (UnsupportedOperationException e2) {
            String str2 = a;
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 23);
            sb2.append("Failed to set VR mode: ");
            sb2.append(valueOf2);
            Log.w(str2, sb2.toString());
            return false;
        }
    }

    public static void j(int i) {
        if (d()) {
            try {
                try {
                    ActivityManager.class.getMethod("setVrThread", Integer.TYPE).invoke(null, Integer.valueOf(i));
                } catch (IllegalAccessException | RuntimeException | InvocationTargetException e) {
                    String str = a;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                    sb.append("Failed to invoke setVrThread: ");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                }
            } catch (NoSuchMethodException | RuntimeException e2) {
                if (e()) {
                    String str2 = a;
                    String valueOf2 = String.valueOf(e2);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 38);
                    sb2.append("Failed to acquire setVrThread method: ");
                    sb2.append(valueOf2);
                    Log.e(str2, sb2.toString());
                    return;
                }
                String str3 = a;
                String valueOf3 = String.valueOf(e2);
                StringBuilder sb3 = new StringBuilder(valueOf3.length() + 38);
                sb3.append("Failed to acquire setVrThread method: ");
                sb3.append(valueOf3);
                Log.w(str3, sb3.toString());
            }
        }
    }

    private static void k(Context context, int i, int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R$style.GvrDialogTheme);
        builder.setMessage(i).setTitle(R$string.dialog_title_warning).setPositiveButton(i2, onClickListener).setNegativeButton(R$string.cancel_button, new c());
        builder.create().show();
    }
}
