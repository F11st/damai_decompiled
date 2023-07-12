package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ug2 {
    public static final int STORAGE_PERMISSION_DUMMY_REQUEST_CODE = 239;
    private static final String a = "ug2";

    public void a(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            Activity a2 = co.a(context);
            if (a2 == null) {
                Log.w(a, "An Activity Context is required, aborting storage permission request.");
            } else {
                a2.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, STORAGE_PERMISSION_DUMMY_REQUEST_CODE);
            }
        }
    }
}
