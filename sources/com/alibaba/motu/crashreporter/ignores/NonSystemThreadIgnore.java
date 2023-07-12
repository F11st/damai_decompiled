package com.alibaba.motu.crashreporter.ignores;

import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class NonSystemThreadIgnore implements UncaughtExceptionIgnore {
    Pattern NON_NAME_THREAD = Pattern.compile("Thread-\\d+");

    @Override // com.alibaba.motu.crashreporter.ignores.UncaughtExceptionIgnore
    public String getName() {
        return "NonSystemThreadIgnore";
    }

    @Override // com.alibaba.motu.crashreporter.ignores.UncaughtExceptionIgnore
    public boolean uncaughtExceptionIgnore(Thread thread, Throwable th) {
        String name = thread.getName();
        return StringUtils.isBlank(name) || this.NON_NAME_THREAD.matcher(name).find() || thread.isDaemon();
    }
}
