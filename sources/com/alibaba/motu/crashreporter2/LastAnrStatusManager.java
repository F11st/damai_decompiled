package com.alibaba.motu.crashreporter2;

import android.content.Context;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
class LastAnrStatusManager {
    private static final String IDLE_FILE = "anr.idle";
    private File idleFile;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class Holder {
        static final LastAnrStatusManager INSTANCE = new LastAnrStatusManager();

        private Holder() {
        }
    }

    public static LastAnrStatusManager instance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearIdle() {
        try {
            File file = this.idleFile;
            if (file == null || !file.exists()) {
                return;
            }
            this.idleFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIdle() {
        try {
            File file = this.idleFile;
            if (file != null) {
                return file.exists();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void makeIdle() {
        try {
            File file = this.idleFile;
            if (file == null || file.exists()) {
                return;
            }
            this.idleFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LastAnrStatusManager() {
        try {
            Context context = Global.getContext();
            File dir = context.getDir("anr_" + Global.getProcessName(), 0);
            if (!dir.exists()) {
                dir.mkdir();
            }
            this.idleFile = new File(dir, IDLE_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
