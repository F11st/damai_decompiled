package com.squareup.okhttp.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;
import okio.h;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() { // from class: com.squareup.okhttp.internal.io.FileSystem.1
        @Override // com.squareup.okhttp.internal.io.FileSystem
        public Sink appendingSink(File file) throws FileNotFoundException {
            try {
                return h.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return h.a(file);
            }
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public boolean exists(File file) throws IOException {
            return file.exists();
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public Sink sink(File file) throws FileNotFoundException {
            try {
                return h.f(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return h.f(file);
            }
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public Source source(File file) throws FileNotFoundException {
            return h.j(file);
        }
    };

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file) throws IOException;

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
