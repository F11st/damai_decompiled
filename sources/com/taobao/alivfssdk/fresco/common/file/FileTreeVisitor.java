package com.taobao.alivfssdk.fresco.common.file;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface FileTreeVisitor {
    void postVisitDirectory(File file);

    void preVisitDirectory(File file);

    void visitFile(File file);
}
