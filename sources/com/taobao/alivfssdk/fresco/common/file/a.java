package com.taobao.alivfssdk.fresco.common.file;

import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a {
    public static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                z &= b(file2);
            }
        }
        return z;
    }

    public static boolean b(File file) {
        if (file.isDirectory()) {
            a(file);
        }
        return file.delete();
    }

    public static void c(File file, FileTreeVisitor fileTreeVisitor) throws IOException {
        d(file, fileTreeVisitor, 0);
    }

    public static void d(File file, FileTreeVisitor fileTreeVisitor, int i) {
        if (i > 10) {
            return;
        }
        fileTreeVisitor.preVisitDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    d(file2, fileTreeVisitor, i + 1);
                } else {
                    fileTreeVisitor.visitFile(file2);
                }
            }
        }
        fileTreeVisitor.postVisitDirectory(file);
    }
}
