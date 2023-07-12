package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Thread extends ProcFile {
    public final String name;
    public final int tid;

    private Thread(int i, String str) throws IOException {
        super(str);
        this.tid = i;
        this.name = this.content.trim();
    }

    public static Thread get(int i, int i2) throws IOException {
        return new Thread(i2, String.format(Locale.ENGLISH, "/proc/%d/task/%d/comm", Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // java.io.File
    public String toString() {
        return "[tid:" + this.tid + ", name:\"" + this.name + "\"]";
    }
}
