package me.ele.altriax.launcher.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXTLog {
    public static String ALTRIAX_T_LOG_FORMAT = "%-20s  %-60s  %-1s  %-25s  %s\n";
    @NonNull
    private final String content;
    private final long currentTime = System.currentTimeMillis();
    @Nullable
    private final String other;
    @Nullable
    private final String state;
    @NonNull
    private final String tag;

    public AltriaXTLog(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        this.tag = str;
        this.content = str2;
        this.state = str3;
        this.other = str4;
    }

    @NonNull
    public String getContent() {
        return this.content;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    @Nullable
    public String getOther() {
        return this.other;
    }

    @Nullable
    public String getState() {
        return this.state;
    }

    @NonNull
    public String getTag() {
        return this.tag;
    }
}
