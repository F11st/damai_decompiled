package com.taobao.monitor.network;

import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import tb.e30;
import tb.pb1;
import tb.vj1;
import tb.xu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploadStorage {
    private static volatile UploadStorage c;
    private String a;
    private UploadLifecycle b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface UploadLifecycle {
        String onDataLoaded(File file, String str);

        void onEnd();

        void onSend(String str, String str2);

        void onStart(boolean z);
    }

    private UploadStorage() {
    }

    public static UploadStorage a() {
        if (c == null) {
            synchronized (UploadStorage.class) {
                if (c == null) {
                    c = new UploadStorage();
                }
            }
        }
        return c;
    }

    private String b(File file) {
        String name = file.getName();
        if (TextUtils.isEmpty(name)) {
            return this.a + "/error";
        }
        return this.a + "/" + name.split(JSMethod.NOT_SET)[0];
    }

    private String c(File file) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (sb.length() > 0) {
                                sb.append(StringUtils.LF);
                            }
                            sb.append(readLine);
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return sb.toString();
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(UploadLifecycle uploadLifecycle) {
        this.b = uploadLifecycle;
    }

    public void f(boolean z) {
        UploadLifecycle uploadLifecycle = this.b;
        if (uploadLifecycle != null) {
            uploadLifecycle.onStart(z);
        }
        File d = xu1.d();
        if (d.exists() && d.isDirectory()) {
            File[] listFiles = d.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    pb1.a("UploadStorage", "开始上传文件：", file.getName());
                    try {
                        String c2 = c(file);
                        file.delete();
                        UploadLifecycle uploadLifecycle2 = this.b;
                        if (uploadLifecycle2 != null) {
                            c2 = uploadLifecycle2.onDataLoaded(file, c2);
                        }
                        String b = b(file);
                        vj1.b().send(b, c2);
                        UploadLifecycle uploadLifecycle3 = this.b;
                        if (uploadLifecycle3 != null) {
                            uploadLifecycle3.onSend(b, c2);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (z) {
                            file.delete();
                            e30.a("UploadStorage", "上传文件失败：", file.getName());
                        }
                    }
                }
                UploadLifecycle uploadLifecycle4 = this.b;
                if (uploadLifecycle4 != null) {
                    uploadLifecycle4.onEnd();
                    return;
                }
                return;
            }
            UploadLifecycle uploadLifecycle5 = this.b;
            if (uploadLifecycle5 != null) {
                uploadLifecycle5.onEnd();
                return;
            }
            return;
        }
        UploadLifecycle uploadLifecycle6 = this.b;
        if (uploadLifecycle6 != null) {
            uploadLifecycle6.onEnd();
        }
    }
}
