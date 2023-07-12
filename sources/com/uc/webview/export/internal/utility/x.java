package com.uc.webview.export.internal.utility;

import com.taobao.update.instantpatch.flow.PatchChecker;
import com.uc.webview.export.cyclone.UCCyclone;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
abstract class x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    public static boolean a(String str) throws Exception {
        int indexOf;
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
        int i = 0;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    return false;
                }
                int i2 = i + 1;
                if (i <= 1024) {
                    String name = nextEntry.getName();
                    if (!name.contains("../")) {
                        if (name.contains("META-INF") && name.endsWith(".SF")) {
                            byte[] bArr = new byte[16384];
                            StringBuilder sb = new StringBuilder();
                            int i3 = 0;
                            while (true) {
                                int read = zipInputStream.read(bArr, 0, 16384);
                                if (read == -1) {
                                    String sb2 = sb.toString();
                                    int indexOf2 = sb2.indexOf(PatchChecker.ApkSignatureSchemeV2Verifier.SF_ATTRIBUTE_ANDROID_APK_SIGNED_NAME);
                                    if (indexOf2 < 0 || (sb2.indexOf(Integer.toString(2), indexOf2 + 20) - indexOf2) - 20 < 0 || indexOf >= 5) {
                                        return false;
                                    }
                                    UCCyclone.close(zipInputStream);
                                    return true;
                                }
                                i3 += read;
                                if (i3 <= 4194304) {
                                    sb.append(new String(bArr, 0, read));
                                } else {
                                    throw new IOException("Zip contents is too big.");
                                }
                            }
                        } else {
                            i = i2;
                        }
                    } else {
                        throw new IOException("unsecurity zipfile!");
                    }
                } else {
                    throw new IOException("Too many files in zip");
                }
            } finally {
                UCCyclone.close(zipInputStream);
            }
        }
    }
}
