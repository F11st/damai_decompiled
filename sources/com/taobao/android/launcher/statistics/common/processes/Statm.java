package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Statm extends ProcFile {
    public final String[] fields;

    private Statm(String str) throws IOException {
        super(str);
        this.fields = this.content.split("\\s+");
    }

    public static Statm get(int i) throws IOException {
        return new Statm(String.format(Locale.ENGLISH, "/proc/%d/statm", Integer.valueOf(i)));
    }

    public long getResidentSetSize() {
        return Long.parseLong(this.fields[1]) * 1024;
    }

    public long getSize() {
        return Long.parseLong(this.fields[0]) * 1024;
    }
}
