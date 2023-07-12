package cn.damai.launcher.splash.model.bean;

import java.io.File;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AdFileResult implements Serializable {
    public final File cacheAdFile;
    public final boolean isHasCacheAdFile;

    public AdFileResult(boolean z, File file) {
        this.isHasCacheAdFile = z;
        this.cacheAdFile = file;
    }
}
