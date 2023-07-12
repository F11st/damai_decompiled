package com.taobao.tao.log.godeye.memorydump.dump;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MemoryFileZip {
    public static void deleteFile(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }
}
