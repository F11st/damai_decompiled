package com.tencent.open.utils;

import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b {
    private static final n a = new n(101010256);
    private static final o b = new o(38651);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        Properties a;
        byte[] b;

        private a() {
            this.a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (b.b.equals(new o(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int b = new o(bArr3).b();
                if ((bArr.length - length) - 2 < b) {
                    return;
                }
                byte[] bArr4 = new byte[b];
                wrap.get(bArr4);
                this.a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - b) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + jn1.ARRAY_END_STR);
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.a + ", otherData=" + Arrays.toString(this.b) + jn1.ARRAY_END_STR;
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a2 = a(randomAccessFile);
            if (a2 == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a();
            aVar.a(a2);
            String property = aVar.a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            } else if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                break;
            } else {
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            }
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b2 = new o(bArr).b();
            if (b2 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b2];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
