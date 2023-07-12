package android.taobao.windvane.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVFileUtils {
    private static final String TAG = "WVFileUtils";
    private static String sAuthority;

    private static void getFileList(File file, ArrayList<String> arrayList) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                getFileList(file2, arrayList);
            }
            return;
        }
        arrayList.add(file.getAbsolutePath());
    }

    public static ArrayList<String> getFileListbyDir(File file) {
        TaoLog.i(TAG, file.getPath());
        ArrayList<String> arrayList = new ArrayList<>();
        getFileList(file, arrayList);
        return arrayList;
    }

    public static Uri getFileUri(Context context, File file) {
        if (file != null && context != null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    String str = sAuthority;
                    if (TextUtils.isEmpty(str)) {
                        str = context.getPackageName() + ".interactProvider";
                    }
                    return FileProvider.getUriForFile(context, str, file);
                }
                return Uri.fromFile(file);
            } catch (Throwable th) {
                TaoLog.w("WVUtils", "Failed to get file uri:" + th.getMessage());
            }
        }
        return null;
    }

    public static void setAuthority(String str) {
        sAuthority = str;
    }
}
