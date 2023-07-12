package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class ac implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
