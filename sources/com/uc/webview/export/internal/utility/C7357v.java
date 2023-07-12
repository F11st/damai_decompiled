package com.uc.webview.export.internal.utility;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.v */
/* loaded from: classes11.dex */
final class C7357v implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith("uc_temp_dec_");
    }
}
