package com.uc.webview.export.cyclone.update;

import android.text.TextUtils;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class UpdateFlagMarker {
    private static final String FINISH = "2e67cdbeb4ec133dcc8204d930aa7145";
    private static final String FINISH_OLD = "95b70b3ec9f6407a92becf890996088d";
    private static final String START = "299772b0fd1634653ae3c31f366de3f8";
    private static final String START_OLD = "c34d62af061f389f7e4c9f0e835f7a54";
    private File mDir;
    private String mNeedCheckFile;

    public UpdateFlagMarker(File file, String str) {
        this.mDir = file;
        this.mNeedCheckFile = str;
    }

    public static File getFinishFlag(File file) {
        return new File(file, FINISH);
    }

    public static File getStartFlag(File file) {
        return new File(file, START);
    }

    private boolean hasFile(String str) {
        return new File(this.mDir, str).exists();
    }

    private boolean hasFinishFlag() {
        return hasFile(FINISH) || hasFile(FINISH_OLD);
    }

    private boolean hasStartFlag() {
        return hasFile(START) || hasFile(START_OLD);
    }

    public static boolean isFinished(File file, String str) {
        return new UpdateFlagMarker(file, str).isFinished();
    }

    public final boolean markFinished() {
        try {
            new File(this.mDir, FINISH).createNewFile();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean markStart() {
        try {
            new File(this.mDir, FINISH).delete();
            new File(this.mDir, START).createNewFile();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isFinished() {
        if (this.mDir.exists()) {
            if (!hasStartFlag() || hasFinishFlag()) {
                return TextUtils.isEmpty(this.mNeedCheckFile) || hasFile(this.mNeedCheckFile);
            }
            return false;
        }
        return false;
    }
}
