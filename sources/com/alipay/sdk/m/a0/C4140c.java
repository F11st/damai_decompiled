package com.alipay.sdk.m.a0;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.a0.c */
/* loaded from: classes12.dex */
public final class C4140c implements FileFilter {
    public final /* synthetic */ C4139b a;

    public C4140c(C4139b c4139b) {
        this.a = c4139b;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
