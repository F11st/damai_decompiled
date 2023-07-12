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
    private C4489b a;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.bw$a */
    /* loaded from: classes10.dex */
    public static class C4488a {
        public boolean a = false;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.bw$c */
    /* loaded from: classes10.dex */
    public interface InterfaceC4490c {
        void a();

        void a(long j);
    }

    public bw(bt btVar, bs bsVar) {
        this.a = new C4489b(btVar, bsVar);
    }

    public void a() {
        C4489b c4489b = this.a;
        if (c4489b != null) {
            c4489b.f();
        }
    }

    public void b() {
        C4489b c4489b = this.a;
        if (c4489b != null) {
            a(c4489b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.bw$b */
    /* loaded from: classes10.dex */
    public static class C4489b {
        private String a;
        private String b;
        private bs c;
        private C4488a d = new C4488a();
        private String e;

        public C4489b(bt btVar, bs bsVar) {
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

        public C4488a e() {
            return this.d;
        }

        public void f() {
            this.d.a = true;
        }

        public String a() {
            return this.a;
        }
    }

    private static void a(C4489b c4489b) {
        if (c4489b == null) {
            return;
        }
        final bs d = c4489b.d();
        if (d != null) {
            d.q();
        }
        String a = c4489b.a();
        String b = c4489b.b();
        if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(b)) {
            File file = new File(a);
            if (!file.exists()) {
                if (c4489b.e().a) {
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
            File file2 = new File(b);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            InterfaceC4490c interfaceC4490c = new InterfaceC4490c() { // from class: com.amap.api.mapcore.util.bw.1
                @Override // com.amap.api.mapcore.util.bw.InterfaceC4490c
                public void a(long j) {
                    try {
                        bs bsVar = bs.this;
                        if (bsVar != null) {
                            bsVar.a(j);
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.amap.api.mapcore.util.bw.InterfaceC4490c
                public void a() {
                    bs bsVar = bs.this;
                    if (bsVar != null) {
                        bsVar.r();
                    }
                }
            };
            try {
                if (c4489b.e().a && d != null) {
                    d.s();
                }
                a(file, file2, interfaceC4490c, c4489b);
                if (c4489b.e().a) {
                    if (d != null) {
                        d.s();
                    }
                } else if (d != null) {
                    d.b(c4489b.c());
                }
            } catch (Throwable unused) {
                if (c4489b.e().a) {
                    if (d != null) {
                        d.s();
                    }
                } else if (d != null) {
                    d.r();
                }
            }
        } else if (c4489b.e().a) {
            if (d != null) {
                d.s();
            }
        } else if (d != null) {
            d.r();
        }
    }

    private static void a(File file, File file2, InterfaceC4490c interfaceC4490c, C4489b c4489b) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        C4488a e = c4489b.e();
        long j = 0;
        if (interfaceC4490c != null) {
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
                                interfaceC4490c.a();
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
                c4489b.a(stringBuffer.toString());
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
        a(file2, zipInputStream2, j, interfaceC4490c, e);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j, InterfaceC4490c interfaceC4490c, C4488a c4488a) throws Exception {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (c4488a != null && c4488a.a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!a(nextEntry.getName())) {
                if (interfaceC4490c != null) {
                    interfaceC4490c.a();
                    return;
                }
                return;
            }
            File file2 = new File(str);
            a(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                i += a(file2, zipInputStream, i, j, interfaceC4490c, c4488a);
            }
            zipInputStream.closeEntry();
        }
    }

    private static boolean a(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    private static int a(File file, ZipInputStream zipInputStream, long j, long j2, InterfaceC4490c interfaceC4490c, C4488a c4488a) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                if (c4488a != null && c4488a.a) {
                    bufferedOutputStream.close();
                    return i;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && interfaceC4490c != null) {
                    long j3 = ((i + j) * 100) / j2;
                    if (c4488a == null || !c4488a.a) {
                        interfaceC4490c.a(j3);
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
