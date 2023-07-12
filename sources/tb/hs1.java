package tb;

import android.content.Context;
import android.os.Environment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class hs1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CACHE = "damai/cache_photo";
    public static final String filename = "/damai_temp.jpg";

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884120934")) {
            return (String) ipChange.ipc$dispatch("884120934", new Object[]{context});
        }
        return b(context) + filename;
    }

    public static String b(Context context) {
        String absolutePath;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "93451157")) {
            return (String) ipChange.ipc$dispatch("93451157", new Object[]{context});
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            absolutePath = context.getExternalCacheDir().getAbsolutePath();
        } else {
            absolutePath = context.getCacheDir().getAbsolutePath();
        }
        File file = new File(absolutePath + File.separator + CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
