package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Status extends ProcFile {
    private Status(String str) throws IOException {
        super(str);
    }

    public static Status get(int i) throws IOException {
        return new Status(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i)));
    }

    public int getGid() {
        try {
            return Integer.parseInt(getValue("Gid").split("\\s+")[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public int getUid() {
        try {
            return Integer.parseInt(getValue("Uid").split("\\s+")[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getValue(String str) {
        String[] split;
        for (String str2 : this.content.split(StringUtils.LF)) {
            if (str2.startsWith(str + ":")) {
                return str2.split(str + ":")[1].trim();
            }
        }
        return null;
    }
}
