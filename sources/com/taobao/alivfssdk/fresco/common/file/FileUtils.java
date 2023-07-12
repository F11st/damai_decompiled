package com.taobao.alivfssdk.fresco.common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import tb.bu1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FileUtils {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class CreateDirectoryException extends IOException {
        public CreateDirectoryException(String str) {
            super(str);
        }

        public CreateDirectoryException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class FileDeleteException extends IOException {
        public FileDeleteException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ParentDirNotFoundException extends FileNotFoundException {
        public ParentDirNotFoundException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class RenameException extends IOException {
        public RenameException(String str) {
            super(str);
        }

        public RenameException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static void a(File file) throws CreateDirectoryException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!file.delete()) {
                throw new CreateDirectoryException(file.getAbsolutePath(), new FileDeleteException(file.getAbsolutePath()));
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new CreateDirectoryException(file.getAbsolutePath());
        }
    }

    public static void b(File file, File file2) throws RenameException {
        bu1.a(file);
        bu1.a(file2);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        Throwable th = null;
        if (!file2.exists()) {
            if (file.getParentFile().exists()) {
                if (!file.exists()) {
                    th = new FileNotFoundException(file.getAbsolutePath());
                }
            } else {
                th = new ParentDirNotFoundException(file.getAbsolutePath());
            }
        } else {
            th = new FileDeleteException(file2.getAbsolutePath());
        }
        throw new RenameException("Unknown error renaming " + file.getAbsolutePath() + " to " + file2.getAbsolutePath(), th);
    }
}
