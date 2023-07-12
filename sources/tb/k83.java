package tb;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import java.io.File;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class k83 {
    private static volatile String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            synchronized (k83.class) {
                if (TextUtils.isEmpty(a)) {
                    String b = b(context);
                    a = b;
                    if (TextUtils.isEmpty(b)) {
                        a = c(context);
                    }
                }
            }
        }
        return a;
    }

    private static String b(Context context) {
        try {
            File file = new File(q33.a(context), "efsid");
            if (file.exists()) {
                return z43.a(file);
            }
            return null;
        } catch (Exception e) {
            w63.c(Constants.TAG, "get uuid error", e);
            return null;
        }
    }

    private static String c(Context context) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            try {
                str = UUID.randomUUID().toString();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        }
        try {
            File a2 = q33.a(context);
            File file = new File(a2, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            z43.e(file, str);
            if (file.renameTo(new File(a2, "efsid"))) {
                file.delete();
            }
        } catch (Exception e) {
            w63.c(Constants.TAG, "save uuid '" + str + "' error", e);
        }
        return str;
    }
}
