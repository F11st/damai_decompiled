package com.youku.httpcommunication;

import java.io.File;
import java.io.FileOutputStream;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class Utils$2 extends Thread {
    final /* synthetic */ String val$content;
    final /* synthetic */ String val$filename;

    Utils$2(String str, String str2) {
        this.val$filename = str;
        this.val$content = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File file;
        File file2;
        Exception e;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    file2 = new File(C7926c.a);
                    try {
                        if (!file2.exists()) {
                            C7924a.b("HttpCommunication.Utils", "make dir " + file2.mkdir());
                        }
                        file = new File(C7926c.a, this.val$filename);
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(this.val$content.getBytes("utf-8"));
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                C7924a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e);
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                C7926c.a(file2, file);
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        C7924a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e3);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        file = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                file2 = null;
                e = e6;
                file = null;
            }
        } catch (Exception e7) {
            C7924a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e7);
        }
        C7926c.a(file2, file);
    }
}
