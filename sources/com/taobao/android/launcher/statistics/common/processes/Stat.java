package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.Locale;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Stat extends ProcFile {
    private final String[] fields;

    private Stat(String str) throws IOException {
        super(str);
        this.fields = this.content.split("\\s+");
    }

    public static Stat get(int i) throws IOException {
        return new Stat(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(i)));
    }

    public long arg_end() {
        return Long.parseLong(this.fields[48]);
    }

    public long arg_start() {
        return Long.parseLong(this.fields[47]);
    }

    public long blocked() {
        return Long.parseLong(this.fields[31]);
    }

    public long cguest_time() {
        return Long.parseLong(this.fields[43]);
    }

    public long cmajflt() {
        return Long.parseLong(this.fields[12]);
    }

    public long cminflt() {
        return Long.parseLong(this.fields[10]);
    }

    public long cnswap() {
        return Long.parseLong(this.fields[36]);
    }

    public long cstime() {
        return Long.parseLong(this.fields[16]);
    }

    public long cutime() {
        return Long.parseLong(this.fields[15]);
    }

    public long delayacct_blkio_ticks() {
        return Long.parseLong(this.fields[41]);
    }

    public long end_data() {
        return Long.parseLong(this.fields[45]);
    }

    public long endcode() {
        return Long.parseLong(this.fields[26]);
    }

    public long env_end() {
        return Long.parseLong(this.fields[50]);
    }

    public long env_start() {
        return Long.parseLong(this.fields[49]);
    }

    public int exit_code() {
        return Integer.parseInt(this.fields[51]);
    }

    public int exit_signal() {
        return Integer.parseInt(this.fields[37]);
    }

    public int flags() {
        return Integer.parseInt(this.fields[8]);
    }

    public String getComm() {
        return this.fields[1].replace(jn1.BRACKET_START_STR, "").replace(jn1.BRACKET_END_STR, "");
    }

    public int getPid() {
        return Integer.parseInt(this.fields[0]);
    }

    public long guest_time() {
        return Long.parseLong(this.fields[42]);
    }

    public long itrealvalue() {
        return Long.parseLong(this.fields[20]);
    }

    public long kstkeip() {
        return Long.parseLong(this.fields[29]);
    }

    public long kstkesp() {
        return Long.parseLong(this.fields[28]);
    }

    public long majflt() {
        return Long.parseLong(this.fields[11]);
    }

    public long minflt() {
        return Long.parseLong(this.fields[9]);
    }

    public int nice() {
        return Integer.parseInt(this.fields[18]);
    }

    public long nswap() {
        return Long.parseLong(this.fields[35]);
    }

    public long num_threads() {
        return Long.parseLong(this.fields[19]);
    }

    public int pgrp() {
        return Integer.parseInt(this.fields[4]);
    }

    public int policy() {
        return Integer.parseInt(this.fields[40]);
    }

    public int ppid() {
        return Integer.parseInt(this.fields[3]);
    }

    public long priority() {
        return Long.parseLong(this.fields[17]);
    }

    public int processor() {
        return Integer.parseInt(this.fields[38]);
    }

    public long rss() {
        return Long.parseLong(this.fields[23]);
    }

    public long rsslim() {
        return Long.parseLong(this.fields[24]);
    }

    public int rt_priority() {
        return Integer.parseInt(this.fields[39]);
    }

    public int session() {
        return Integer.parseInt(this.fields[5]);
    }

    public long sigcatch() {
        return Long.parseLong(this.fields[33]);
    }

    public long sigignore() {
        return Long.parseLong(this.fields[32]);
    }

    public long signal() {
        return Long.parseLong(this.fields[30]);
    }

    public long start_brk() {
        return Long.parseLong(this.fields[46]);
    }

    public long start_data() {
        return Long.parseLong(this.fields[44]);
    }

    public long startcode() {
        return Long.parseLong(this.fields[25]);
    }

    public long startstack() {
        return Long.parseLong(this.fields[27]);
    }

    public long starttime() {
        return Long.parseLong(this.fields[21]);
    }

    public char state() {
        return this.fields[2].charAt(0);
    }

    public long stime() {
        return Long.parseLong(this.fields[14]);
    }

    public int tpgid() {
        return Integer.parseInt(this.fields[7]);
    }

    public int tty_nr() {
        return Integer.parseInt(this.fields[6]);
    }

    public long utime() {
        return Long.parseLong(this.fields[13]);
    }

    public long vsize() {
        return Long.parseLong(this.fields[22]);
    }

    public long wchan() {
        return Long.parseLong(this.fields[34]);
    }
}
