package android.taobao.windvane.packageapp.zipapp.data;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WMLWrapData {
    File rootDir;
    String storage;

    public File getRootDir() {
        return this.rootDir;
    }

    public String getStorage() {
        return this.storage;
    }

    public void setRootDir(File file) {
        this.rootDir = file;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("file:");
        File file = this.rootDir;
        sb.append(file != null ? file.getPath() : "error file, ");
        sb.append("storage: ");
        sb.append(this.storage);
        return sb.toString();
    }
}
