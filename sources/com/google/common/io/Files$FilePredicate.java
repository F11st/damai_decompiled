package com.google.common.io;

import com.google.common.base.Predicate;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
enum Files$FilePredicate implements Predicate<File> {
    IS_DIRECTORY { // from class: com.google.common.io.Files$FilePredicate.1
        @Override // java.lang.Enum
        public String toString() {
            return "Files.isDirectory()";
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(File file) {
            return file.isDirectory();
        }
    },
    IS_FILE { // from class: com.google.common.io.Files$FilePredicate.2
        @Override // java.lang.Enum
        public String toString() {
            return "Files.isFile()";
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(File file) {
            return file.isFile();
        }
    };

    /* synthetic */ Files$FilePredicate(a aVar) {
        this();
    }
}
