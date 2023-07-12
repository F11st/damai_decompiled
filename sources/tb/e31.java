package tb;

import android.text.TextUtils;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e31 extends el2 {
    public String path;
    public String workDir;

    public String getPatchPath() {
        if (this.context == null) {
            return null;
        }
        if (TextUtils.isEmpty(this.workDir)) {
            this.workDir = new File(this.context.getExternalCacheDir(), lu2.HOTPATCH).getAbsolutePath();
        }
        return this.workDir;
    }
}
