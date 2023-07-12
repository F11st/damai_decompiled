package com.taobao.android.launcher.statistics.common.processes;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Parcel;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AndroidProcess {
    public final String name;
    public final int pid;

    public AndroidProcess(int i) throws IOException {
        this.pid = i;
        this.name = getProcessName(i);
    }

    private String getProcessName(int i) throws IOException {
        String str;
        try {
            str = ProcFile.readFile(String.format(Locale.ENGLISH, "/proc/%d/cmdline", Integer.valueOf(i))).trim();
        } catch (IOException unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return Stat.get(i).getComm();
            } catch (Exception unused2) {
                throw new IOException(String.format(Locale.ENGLISH, "Error reading /proc/%d/stat", Integer.valueOf(i)));
            }
        }
        return str;
    }

    public String attr_current() throws IOException {
        return read("attr/current");
    }

    public Cgroup cgroup() throws IOException {
        return Cgroup.get(this.pid);
    }

    public String cmdline() throws IOException {
        return read("cmdline");
    }

    public Debug.MemoryInfo getMemoryInfo(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{this.pid});
        if (processMemoryInfo.length == 1) {
            return processMemoryInfo[0];
        }
        return null;
    }

    public List<Thread> getThreads() {
        File[] listFiles = new File(String.format(Locale.ENGLISH, "/proc/%d/task", Integer.valueOf(this.pid))).listFiles();
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(Thread.get(this.pid, parseInt));
                    } catch (IOException e) {
                        AndroidProcesses.log(e, "Error reading from /proc/%d/task/%d.", Integer.valueOf(this.pid), Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public int oom_adj() throws IOException {
        return Integer.parseInt(read("oom_adj"));
    }

    public int oom_score() throws IOException {
        return Integer.parseInt(read("oom_score"));
    }

    public int oom_score_adj() throws IOException {
        return Integer.parseInt(read("oom_score_adj"));
    }

    public String read(String str) throws IOException {
        return ProcFile.readFile(String.format(Locale.ENGLISH, "/proc/%d/%s", Integer.valueOf(this.pid), str));
    }

    public Stat stat() throws IOException {
        return Stat.get(this.pid);
    }

    public Statm statm() throws IOException {
        return Statm.get(this.pid);
    }

    public Status status() throws IOException {
        return Status.get(this.pid);
    }

    public String wchan() throws IOException {
        return read("wchan");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AndroidProcess(Parcel parcel) {
        this.name = parcel.readString();
        this.pid = parcel.readInt();
    }
}
