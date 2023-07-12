package tb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;
import com.google.vr.cardboard.R$string;
import com.google.vr.cardboard.R$style;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ht2 {
    public static ug2 a = new ug2();
    public static AlertDialog.Builder b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.google.com/daydream?p=daydream_help_menu")));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this.a, R$string.no_browser_text, 1).show();
                dialogInterface.cancel();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class c implements DialogInterface.OnCancelListener {
        final /* synthetic */ Runnable a;

        c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        final /* synthetic */ Context a;

        d(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://google.com/cardboard/cfg")));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this.a, R$string.no_browser_text, 1).show();
            }
        }
    }

    private static AlertDialog.Builder a(Context context) {
        AlertDialog.Builder builder = b;
        return builder != null ? builder : new AlertDialog.Builder(context, R$style.GvrDialogTheme);
    }

    public static void b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setAction("com.google.vrtoolkit.cardboard.CONFIGURE");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        Integer num = null;
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (op1.a(str)) {
                int i = resolveInfo.priority;
                if (op1.b(context, str)) {
                    i++;
                }
                if (num == null) {
                    num = Integer.valueOf(i);
                } else if (i > num.intValue()) {
                    num = Integer.valueOf(i);
                    arrayList.clear();
                } else if (i >= num.intValue()) {
                }
                Intent intent2 = new Intent(intent);
                intent2.setClassName(str, resolveInfo.activityInfo.name);
                arrayList.add(intent2);
            }
        }
        if (!az2.c(context)) {
            a.a(context);
        }
        if (arrayList.isEmpty()) {
            e(context);
            return;
        }
        if (arrayList.size() == 1) {
            intent = (Intent) arrayList.get(0);
        }
        context.startActivity(intent);
    }

    public static AlertDialog c(Context context, int i, int i2, Runnable runnable) {
        a aVar = new a(context);
        AlertDialog.Builder a2 = a(context);
        a2.setTitle(i).setMessage(i2).setCancelable(false).setPositiveButton(R$string.dialog_button_open_help_center, aVar).setNegativeButton(R$string.dialog_button_got_it, new b());
        if (runnable != null) {
            a2.setOnCancelListener(new c(runnable));
        }
        AlertDialog create = a2.create();
        create.setCanceledOnTouchOutside(false);
        return d(context, create);
    }

    private static AlertDialog d(Context context, AlertDialog alertDialog) {
        alertDialog.getWindow().setFlags(8, 8);
        alertDialog.show();
        Activity a2 = co.a(context);
        if (a2 != null) {
            alertDialog.getWindow().getDecorView().setSystemUiVisibility(a2.getWindow().getDecorView().getSystemUiVisibility());
        }
        alertDialog.getWindow().clearFlags(8);
        return alertDialog;
    }

    private static void e(Context context) {
        d dVar = new d(context);
        AlertDialog.Builder a2 = a(context);
        a2.setTitle(R$string.dialog_title).setMessage(R$string.dialog_message_no_cardboard).setPositiveButton(R$string.go_to_playstore_button, dVar).setNegativeButton(R$string.cancel_button, (DialogInterface.OnClickListener) null);
        d(context, a2.create());
    }
}
