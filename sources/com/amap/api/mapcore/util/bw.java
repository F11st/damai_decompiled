package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bw {
    private b a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public boolean a = false;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface c {
        void a();

        void a(long j);
    }

    public bw(bt btVar, bs bsVar) {
        this.a = new b(btVar, bsVar);
    }

    public void a() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void b() {
        b bVar = this.a;
        if (bVar != null) {
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private String a;
        private String b;
        private bs c;
        private a d = new a();
        private String e;

        public b(bt btVar, bs bsVar) {
            this.c = null;
            this.a = btVar.B();
            this.b = btVar.C();
            this.c = bsVar;
        }

        public void a(String str) {
            if (str.length() > 1) {
                this.e = str;
            }
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.e;
        }

        public bs d() {
            return this.c;
        }

        public a e() {
            return this.d;
        }

        public void f() {
            this.d.a = true;
        }

        public String a() {
            return this.a;
        }
    }

    private static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        final bs d = bVar.d();
        if (d != null) {
            d.q();
        }
        String a2 = bVar.a();
        String b2 = bVar.b();
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(b2)) {
            File file = new File(a2);
            if (!file.exists()) {
                if (bVar.e().a) {
                    if (d != null) {
                        d.s();
                        return;
                    }
                    return;
                } else if (d != null) {
                    d.r();
                    return;
                } else {
                    return;
                }
            }
            File file2 = new File(b2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            c cVar = new c() { // from class: com.amap.api.mapcore.util.bw.1
                @Override // com.amap.api.mapcore.util.bw.c
                public void a(long j) {
                    try {
                        bs bsVar = bs.this;
                        if (bsVar != null) {
                            bsVar.a(j);
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.amap.api.mapcore.util.bw.c
                public void a() {
                    bs bsVar = bs.this;
                    if (bsVar != null) {
                        bsVar.r();
                    }
                }
            };
            try {
                if (bVar.e().a && d != null) {
                    d.s();
                }
                a(file, file2, cVar, bVar);
                if (bVar.e().a) {
                    if (d != null) {
                        d.s();
                    }
                } else if (d != null) {
                    d.b(bVar.c());
                }
            } catch (Throwable unused) {
                if (bVar.e().a) {
                    if (d != null) {
                        d.s();
                    }
                } else if (d != null) {
                    d.r();
                }
            }
        } else if (bVar.e().a) {
            if (d != null) {
                d.s();
            }
        } else if (d != null) {
            d.r();
        }
    }

    private static void a(File file, File file2, c cVar, b bVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        a e = bVar.e();
        long j = 0;
        if (cVar != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        if (e != null && e.a) {
                            zipInputStream.closeEntry();
                            zipInputStream.close();
                            checkedInputStream.close();
                            fileInputStream.close();
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            if (!a(nextEntry.getName())) {
                                cVar.a();
                                break;
                            } else {
                                stringBuffer.append(nextEntry.getName());
                                stringBuffer.append(";");
                            }
                        }
                        j += nextEntry.getSize();
                        zipInputStream.closeEntry();
                    } else {
                        break;
                    }
                }
                bVar.a(stringBuffer.toString());
                zipInputStream.close();
                checkedInputStream.close();
                fileInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, j, cVar, e);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j, c cVar, a aVar) throws Exception {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar != null && aVar.a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!a(nextEntry.getName())) {
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            File file2 = new File(str);
            a(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                i += a(file2, zipInputStream, i, j, cVar, aVar);
            }
            zipInputStream.closeEntry();
        }
    }

    private static boolean a(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    private static int a(File file, ZipInputStream zipInputStream, long j, long j2, c cVar, a aVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                if (aVar != null && aVar.a) {
                    bufferedOutputStream.close();
                    return i;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && cVar != null) {
                    long j3 = ((i + j) * 100) / j2;
                    if (aVar == null || !aVar.a) {
                        cVar.a(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        a(parentFile);
        parentFile.mkdir();
    }
}
