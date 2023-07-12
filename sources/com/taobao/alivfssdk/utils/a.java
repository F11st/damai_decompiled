package com.taobao.alivfssdk.utils;

import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a {
    public static void a(File file) throws IOException {
        if (file != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                throw new IllegalStateException(file.getAbsolutePath() + " already exists and is not a directory");
            } else if (file.mkdirs()) {
                return;
            } else {
                throw new IOException("Couldn't create directory " + file.getPath());
            }
        }
        throw new IllegalStateException("Failed to get external storage files directory");
    }
}
