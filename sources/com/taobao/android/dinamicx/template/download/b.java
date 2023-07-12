package com.taobao.android.dinamicx.template.download;

import android.content.res.AssetManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import tb.nz;
import tb.r10;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    public static String[] a(String str) {
        AssetManager assets;
        if (TextUtils.isEmpty(str) || (assets = DinamicXEngine.i().getAssets()) == null) {
            return null;
        }
        try {
            return assets.list(str);
        } catch (IOException unused) {
            return null;
        }
    }

    static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(2048);
        } catch (Throwable th2) {
            byteArrayOutputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            try {
                inputStream.close();
            } catch (IOException unused5) {
            }
            throw th;
        }
    }

    public static byte[] c(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(r10.ASSET_DIR)) {
            return d(str);
        }
        return e(str);
    }

    private static byte[] d(String str) throws IOException {
        return b(DinamicXEngine.i().getAssets().open(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r0 != r2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        return java.util.Arrays.copyOf(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] e(java.lang.String r7) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            long r1 = r0.length()
            java.lang.String r7 = "Required array size too large"
            r3 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L5f
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r0)
            int r0 = (int) r1
            byte[] r1 = new byte[r0]
            r2 = 0
        L1b:
            int r4 = r0 - r2
            int r4 = r3.read(r1, r2, r4)
            if (r4 <= 0) goto L25
            int r2 = r2 + r4
            goto L1b
        L25:
            if (r4 < 0) goto L54
            int r4 = r3.read()
            if (r4 >= 0) goto L2e
            goto L54
        L2e:
            r5 = 2147483639(0x7ffffff7, float:NaN)
            int r6 = r5 - r0
            if (r0 > r6) goto L3e
            int r0 = r0 << 1
            r5 = 8192(0x2000, float:1.148E-41)
            int r0 = java.lang.Math.max(r0, r5)
            goto L43
        L3e:
            if (r0 == r5) goto L4e
            r0 = 2147483639(0x7ffffff7, float:NaN)
        L43:
            byte[] r1 = java.util.Arrays.copyOf(r1, r0)
            int r5 = r2 + 1
            byte r4 = (byte) r4
            r1[r2] = r4
            r2 = r5
            goto L1b
        L4e:
            java.lang.OutOfMemoryError r0 = new java.lang.OutOfMemoryError
            r0.<init>(r7)
            throw r0
        L54:
            r3.close()
            if (r0 != r2) goto L5a
            goto L5e
        L5a:
            byte[] r1 = java.util.Arrays.copyOf(r1, r2)
        L5e:
            return r1
        L5f:
            java.lang.OutOfMemoryError r0 = new java.lang.OutOfMemoryError
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.template.download.b.e(java.lang.String):byte[]");
    }

    public static JSONObject f(String str) {
        byte[] bArr;
        try {
            bArr = c(r10.ASSET_DIR + str + r10.ASSET_PRESET_TEMPLATE_INFOLIST);
        } catch (Throwable unused) {
            if (DinamicXEngine.x()) {
                nz.u("DXTemplateInfoManager", str + "未使用内置模板索引文件");
            }
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            try {
                return JSON.parseObject(new String(bArr));
            } catch (Throwable th) {
                if (DinamicXEngine.x()) {
                    nz.e("DXTemplateInfoManager", th, str + "内置模板索引文件格式错误");
                }
            }
        }
        return null;
    }

    public static boolean g(DXTemplateItem dXTemplateItem, byte[] bArr, String str, IDXUnzipCallback iDXUnzipCallback, @NonNull e eVar) {
        boolean z;
        if (dXTemplateItem != null && bArr != null && iDXUnzipCallback != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new ByteArrayInputStream(bArr)));
                loop0: while (true) {
                    z = false;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break loop0;
                        }
                        try {
                            byte[] bArr2 = new byte[8192];
                            String name = nextEntry.getName();
                            if (!nextEntry.getName().contains("../") && !nextEntry.isDirectory()) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                StringBuilder sb = new StringBuilder();
                                try {
                                    sb.append(str);
                                    sb.append(name);
                                    String sb2 = sb.toString();
                                    File file = new File(new File(sb2).getParent());
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    while (true) {
                                        int read = zipInputStream.read(bArr2, 0, 8192);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (dXTemplateItem.packageInfo == null) {
                                        dXTemplateItem.packageInfo = new DXTemplatePackageInfo();
                                    }
                                    if (r10.DX_MAIN_TEMPLATE_NAME.equalsIgnoreCase(name)) {
                                        dXTemplateItem.packageInfo.mainFilePath = sb2;
                                    } else {
                                        DXTemplatePackageInfo dXTemplatePackageInfo = dXTemplateItem.packageInfo;
                                        if (dXTemplatePackageInfo.subFilePathDict == null) {
                                            dXTemplatePackageInfo.subFilePathDict = new HashMap();
                                        }
                                        dXTemplateItem.packageInfo.subFilePathDict.put(name, sb2);
                                    }
                                    hashMap.put(sb2, byteArray);
                                    byteArrayOutputStream.flush();
                                    z = true;
                                } catch (Throwable th) {
                                    th = th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    e.a aVar = new e.a("Downloader", "Downloader_download", 60001);
                    aVar.e = ry.a(th);
                    eVar.c.add(aVar);
                }
                zipInputStream.close();
            } catch (Throwable th3) {
                hashMap.clear();
                e.a aVar2 = new e.a("Downloader", "Downloader_download", 60001);
                aVar2.e = ry.a(th3);
                eVar.c.add(aVar2);
                z = false;
            }
            if (z) {
                DXTemplatePackageInfo dXTemplatePackageInfo2 = dXTemplateItem.packageInfo;
                if (dXTemplatePackageInfo2 != null && !TextUtils.isEmpty(dXTemplatePackageInfo2.mainFilePath)) {
                    iDXUnzipCallback.onUnzipFinished(dXTemplateItem, hashMap);
                } else {
                    e.a aVar3 = new e.a("Downloader", "Downloader_download", 60001);
                    aVar3.e = "模板zip中缺少main.dx";
                    eVar.c.add(aVar3);
                    return false;
                }
            }
            return z;
        }
        eVar.c.add(new e.a("Downloader", "Downloader_download", 60002));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean h(java.lang.String r5, byte[] r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            java.io.File r5 = new java.io.File
            java.lang.String r1 = r0.getParent()
            r5.<init>(r1)
            boolean r1 = r5.exists()
            if (r1 != 0) goto L17
            r5.mkdir()
        L17:
            r5 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            r1.write(r6)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L64
            r5 = 1
            r1.close()     // Catch: java.io.IOException -> L29
        L29:
            return r5
        L2a:
            r5 = move-exception
            goto L33
        L2c:
            r6 = move-exception
            r1 = r5
            r5 = r6
            goto L65
        L30:
            r6 = move-exception
            r1 = r5
            r5 = r6
        L33:
            boolean r6 = r0.exists()     // Catch: java.lang.Throwable -> L64
            if (r6 == 0) goto L3c
            r0.delete()     // Catch: java.lang.Throwable -> L64
        L3c:
            com.taobao.android.dinamicx.e r6 = new com.taobao.android.dinamicx.e     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "DinamicX_File"
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L64
            com.taobao.android.dinamicx.e$a r0 = new com.taobao.android.dinamicx.e$a     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "Template"
            java.lang.String r3 = "Template_Write"
            r4 = 60021(0xea75, float:8.4107E-41)
            r0.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = tb.ry.a(r5)     // Catch: java.lang.Throwable -> L64
            r0.e = r5     // Catch: java.lang.Throwable -> L64
            java.util.List<com.taobao.android.dinamicx.e$a> r5 = r6.c     // Catch: java.lang.Throwable -> L64
            r5.add(r0)     // Catch: java.lang.Throwable -> L64
            com.taobao.android.dinamicx.monitor.DXAppMonitor.n(r6)     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L62
            r1.close()     // Catch: java.io.IOException -> L62
        L62:
            r5 = 0
            return r5
        L64:
            r5 = move-exception
        L65:
            if (r1 == 0) goto L6a
            r1.close()     // Catch: java.io.IOException -> L6a
        L6a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.template.download.b.h(java.lang.String, byte[]):boolean");
    }
}
