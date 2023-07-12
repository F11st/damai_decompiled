package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Cgroup extends ProcFile {
    public final ArrayList<ControlGroup> groups;

    private Cgroup(String str) throws IOException {
        super(str);
        String[] split = this.content.split(StringUtils.LF);
        this.groups = new ArrayList<>();
        for (String str2 : split) {
            try {
                this.groups.add(new ControlGroup(str2));
            } catch (Exception unused) {
            }
        }
    }

    public static Cgroup get(int i) throws IOException {
        return new Cgroup(String.format(Locale.ENGLISH, "/proc/%d/cgroup", Integer.valueOf(i)));
    }

    public ControlGroup getGroup(String str) {
        Iterator<ControlGroup> it = this.groups.iterator();
        while (it.hasNext()) {
            ControlGroup next = it.next();
            for (String str2 : next.subsystems.split(",")) {
                if (str2.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }
}
