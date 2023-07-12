package com.taobao.android.launcher.statistics.common.processes;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AndroidAppProcess extends AndroidProcess {
    public final boolean foreground;
    public final int uid;
    private static final boolean SYS_SUPPORTS_SCHEDGROUPS = new File("/dev/cpuctl/tasks").exists();
    private static final Pattern PROCESS_NAME_PATTERN = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class NotAndroidAppProcessException extends Exception {
        public NotAndroidAppProcessException(int i) {
            super(String.format(Locale.ENGLISH, "The process %d does not belong to any application", Integer.valueOf(i)));
        }
    }

    public AndroidAppProcess(int i) throws IOException, NotAndroidAppProcessException {
        super(i);
        int uid;
        boolean z;
        String str = this.name;
        if (str != null && PROCESS_NAME_PATTERN.matcher(str).matches() && new File("/data/data", getPackageName()).exists()) {
            if (SYS_SUPPORTS_SCHEDGROUPS) {
                Cgroup cgroup = cgroup();
                ControlGroup group = cgroup.getGroup("cpuacct");
                ControlGroup group2 = cgroup.getGroup("cpu");
                if (Build.VERSION.SDK_INT >= 21) {
                    if (group2 != null && group != null && group.group.contains("pid_")) {
                        z = !group2.group.contains("bg_non_interactive");
                        try {
                            uid = Integer.parseInt(group.group.split("/")[1].replace("uid_", ""));
                        } catch (Exception unused) {
                            uid = status().getUid();
                        }
                    } else {
                        throw new NotAndroidAppProcessException(i);
                    }
                } else if (group2 != null && group != null && group2.group.contains("apps")) {
                    z = !group2.group.contains("bg_non_interactive");
                    try {
                        String str2 = group.group;
                        uid = Integer.parseInt(str2.substring(str2.lastIndexOf("/") + 1));
                    } catch (Exception unused2) {
                        uid = status().getUid();
                    }
                } else {
                    throw new NotAndroidAppProcessException(i);
                }
            } else {
                Stat stat = stat();
                Status status = status();
                boolean z2 = stat.policy() == 0;
                uid = status.getUid();
                z = z2;
            }
            this.foreground = z;
            this.uid = uid;
            return;
        }
        throw new NotAndroidAppProcessException(i);
    }

    public PackageInfo getPackageInfo(Context context, int i) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(getPackageName(), i);
    }

    public String getPackageName() {
        return this.name.split(":")[0];
    }

    protected AndroidAppProcess(Parcel parcel) {
        super(parcel);
        this.foreground = parcel.readByte() != 0;
        this.uid = parcel.readInt();
    }
}
