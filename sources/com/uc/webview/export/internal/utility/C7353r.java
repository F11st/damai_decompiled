package com.uc.webview.export.internal.utility;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.r */
/* loaded from: classes11.dex */
final class C7353r implements FileFilter {
    private Pattern a = Pattern.compile("cpu[0-9]+", 0);

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return this.a.matcher(file.getName()).matches();
    }
}
