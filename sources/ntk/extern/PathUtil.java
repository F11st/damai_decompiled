package ntk.extern;

import androidx.annotation.Keep;
import com.youku.core.context.YoukuContext;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public final class PathUtil {
    public static String getSystemRootPath() {
        return YoukuContext.getApplication().getFilesDir().getAbsolutePath();
    }
}
