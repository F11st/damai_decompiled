package com.uc.webview.export.internal.utility;

import cn.damai.h5container.H5MainActivity;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.hs2;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.a */
/* loaded from: classes11.dex */
public final class C7321a {

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.a$a */
    /* loaded from: classes11.dex */
    public static class C7322a extends Exception {
        public C7322a(String str) {
            super(str);
        }

        public C7322a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.a$b */
    /* loaded from: classes11.dex */
    public static class C7323b extends C7324c {
        private byte[] a;

        public C7323b(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.a = bArr;
        }

        @Override // com.uc.webview.export.internal.utility.C7321a.C7324c, java.security.cert.Certificate
        public final byte[] getEncoded() throws CertificateEncodingException {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.a$c */
    /* loaded from: classes11.dex */
    static class C7324c extends X509Certificate {
        private final X509Certificate a;

        public C7324c(X509Certificate x509Certificate) {
            this.a = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            this.a.checkValidity();
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            return this.a.getBasicConstraints();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            return this.a.getCriticalExtensionOIDs();
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.a.getEncoded();
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String str) {
            return this.a.getExtensionValue(str);
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            return this.a.getIssuerDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            return this.a.getIssuerUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            return this.a.getKeyUsage();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            return this.a.getNonCriticalExtensionOIDs();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            return this.a.getNotAfter();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            return this.a.getNotBefore();
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            return this.a.getPublicKey();
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            return this.a.getSerialNumber();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            return this.a.getSigAlgName();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            return this.a.getSigAlgOID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            return this.a.getSigAlgParams();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            return this.a.getSignature();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            return this.a.getSubjectDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            return this.a.getSubjectUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return this.a.getTBSCertificate();
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            return this.a.getVersion();
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            return this.a.hasUnsupportedCriticalExtension();
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            return this.a.toString();
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.a.verify(publicKey);
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            this.a.checkValidity(date);
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.a.verify(publicKey, str);
        }
    }

    public static boolean a(String str) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                long length = randomAccessFile2.length();
                if (length > 2147483647L) {
                    randomAccessFile2.close();
                    return false;
                }
                try {
                    MappedByteBuffer map = randomAccessFile2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, length);
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    int a = (int) a(map, b(map));
                    e(a(map, c(map, a), a));
                    randomAccessFile2.close();
                    return true;
                } catch (IOException e) {
                    if (e.getCause() instanceof OutOfMemoryError) {
                        randomAccessFile2.close();
                        return false;
                    }
                    throw new IOException("Failed to memory-map APK", e);
                }
            } catch (C7322a unused) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (C7322a unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static X509Certificate[][] b(String str) throws C7322a, SecurityException, IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, UploadQueueMgr.MSGTYPE_REALTIME);
        } catch (Throwable th) {
            th = th;
        }
        try {
            X509Certificate[][] a = a(randomAccessFile);
            randomAccessFile.close();
            return a;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private static int c(int i) {
        if (i != 1) {
            if (i == 2) {
                return 64;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
        return 32;
    }

    private static byte[] d(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static ByteBuffer e(ByteBuffer byteBuffer) throws C7322a {
        f(byteBuffer);
        ByteBuffer a = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (a.hasRemaining()) {
            i++;
            if (a.remaining() >= 8) {
                long j = a.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i2 = (int) j;
                    int position = a.position() + i2;
                    if (i2 <= a.remaining()) {
                        if (a.getInt() == 1896449818) {
                            return b(a, i2 - 4);
                        }
                        a.position(position);
                    } else {
                        throw new C7322a("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a.remaining());
                    }
                } else {
                    throw new C7322a("APK Signing Block entry #" + i + " size out of range: " + j);
                }
            } else {
                throw new C7322a("Insufficient data to read size of APK Signing Block entry #" + i);
            }
        }
        throw new C7322a("No APK Signature Scheme v2 block in APK Signing Block");
    }

    private static void f(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer c(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return b(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    private static String b(int i) {
        if (i != 1) {
            if (i == 2) {
                return MessageDigestAlgorithms.SHA_512;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
        return MessageDigestAlgorithms.SHA_256;
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 >= position && i2 <= limit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i);
    }

    private static int c(ByteBuffer byteBuffer, int i) throws C7322a {
        f(byteBuffer);
        if (i >= 32) {
            if (byteBuffer.getLong(i - 16) == 2334950737559900225L && byteBuffer.getLong(i - 8) == 3617552046287187010L) {
                long j = byteBuffer.getLong(i - 24);
                if (j < 24 || j > 2147483639) {
                    throw new C7322a("APK Signing Block size out of range: " + j);
                }
                int i2 = (int) j;
                int i3 = i - (i2 + 8);
                if (i3 >= 0) {
                    long j2 = byteBuffer.getLong(i3);
                    if (j2 == i2) {
                        return i3;
                    }
                    throw new C7322a("APK Signing Block sizes in header and footer do not match: " + j2 + " vs " + i2);
                }
                throw new C7322a("APK Signing Block offset out of range: " + i3);
            }
            throw new C7322a("No APK Signing Block before ZIP Central Directory");
        }
        throw new C7322a("APK too small for APK Signing Block. ZIP Central Directory offset: " + i);
    }

    private static int b(ByteBuffer byteBuffer) throws C7322a {
        int i;
        AbstractC7359x.a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            System.out.println("File size smaller than EOCD min size");
        } else {
            int i2 = capacity - 22;
            int min = Math.min(i2, 65535);
            for (int i3 = 0; i3 < min; i3++) {
                i = i2 - i3;
                if (byteBuffer.getInt(i) == 101010256 && (byteBuffer.getShort(i + 20) & hs2.MAX_VALUE) == i3) {
                    break;
                }
            }
        }
        i = -1;
        if (i != -1) {
            return i;
        }
        throw new C7322a("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static X509Certificate[][] a(RandomAccessFile randomAccessFile) throws C7322a, SecurityException, IOException {
        long length = randomAccessFile.length();
        if (length <= 2147483647L) {
            try {
                MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, length);
                map.load();
                return a(map);
            } catch (IOException e) {
                if (e.getCause() instanceof OutOfMemoryError) {
                    throw new C7322a("Failed to memory-map APK", e);
                }
                throw new IOException("Failed to memory-map APK", e);
            }
        }
        throw new IOException("File too large: " + randomAccessFile.length() + " bytes");
    }

    public static X509Certificate[][] a(ByteBuffer byteBuffer) throws C7322a, SecurityException {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        int b = b(slice);
        int a = (int) a(slice, b);
        int c = c(slice, a);
        return a(slice, e(a(slice, c, a)), c, a, b);
    }

    private static X509Certificate[][] a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer c = c(byteBuffer2);
                int i4 = 0;
                while (c.hasRemaining()) {
                    i4++;
                    try {
                        arrayList.add(a(c(c), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i4 + " block", e);
                    }
                }
                if (i4 > 0) {
                    if (!hashMap.isEmpty()) {
                        a(hashMap, byteBuffer, i, i2, i3);
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x004e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] a(java.nio.ByteBuffer r22, java.util.Map<java.lang.Integer, byte[]> r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.C7321a.a(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static void a(Map<Integer, byte[]> map, ByteBuffer byteBuffer, int i, int i2, int i3) throws SecurityException {
        int intValue;
        if (!map.isEmpty()) {
            ByteBuffer a = a(byteBuffer, 0, i);
            ByteBuffer a2 = a(byteBuffer, i2, i3);
            byte[] bArr = new byte[byteBuffer.capacity() - i3];
            byteBuffer.position(i3);
            byteBuffer.get(bArr);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(byteBuffer.order());
            long j = i;
            AbstractC7359x.a(wrap);
            int position = wrap.position() + 16;
            if (j >= 0 && j <= 4294967295L) {
                wrap.putInt(wrap.position() + position, (int) j);
                int[] iArr = new int[map.size()];
                int i4 = 0;
                for (Integer num : map.keySet()) {
                    iArr[i4] = num.intValue();
                    i4++;
                }
                try {
                    Map<Integer, byte[]> a3 = a(iArr, new ByteBuffer[]{a, a2, wrap});
                    for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
                        if (!MessageDigest.isEqual(entry.getValue(), a3.get(Integer.valueOf(entry.getKey().intValue())))) {
                            throw new SecurityException(b(intValue) + " digest of contents did not verify");
                        }
                    }
                    return;
                } catch (DigestException e) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e);
                }
            }
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        throw new SecurityException("No digests provided");
    }

    private static Map<Integer, byte[]> a(int[] iArr, ByteBuffer[] byteBufferArr) throws DigestException {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            i3 += ((byteBufferArr[i2].remaining() + 1048576) - 1) / 1048576;
            i2++;
        }
        HashMap hashMap = new HashMap(i3);
        for (int i4 : iArr) {
            byte[] bArr = new byte[(c(i4) * i3) + 5];
            bArr[0] = 90;
            a(i3, bArr);
            hashMap.put(Integer.valueOf(i4), bArr);
        }
        byte[] bArr2 = new byte[5];
        bArr2[0] = -91;
        int i5 = 0;
        int i6 = 0;
        for (i = 3; i5 < i; i = 3) {
            ByteBuffer byteBuffer = byteBufferArr[i5];
            while (byteBuffer.hasRemaining()) {
                ByteBuffer b = b(byteBuffer, Math.min(byteBuffer.remaining(), 1048576));
                for (int i7 : iArr) {
                    String b2 = b(i7);
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(b2);
                        b.clear();
                        a(b.remaining(), bArr2);
                        messageDigest.update(bArr2);
                        messageDigest.update(b);
                        int c = c(i7);
                        int digest = messageDigest.digest((byte[]) hashMap.get(Integer.valueOf(i7)), (i6 * c) + 5, c);
                        if (digest != c) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                        }
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(b2 + " digest not supported", e);
                    }
                }
                i6++;
            }
            i5++;
        }
        HashMap hashMap2 = new HashMap(iArr.length);
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            byte[] bArr3 = (byte[]) entry.getValue();
            String b3 = b(intValue);
            try {
                hashMap2.put(Integer.valueOf(intValue), MessageDigest.getInstance(b3).digest(bArr3));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(b3 + " digest not supported", e2);
            }
        }
        return hashMap2;
    }

    private static int a(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i != 770) {
                        switch (i) {
                            case 257:
                            case H5MainActivity.REQUEST_CORP /* 259 */:
                                return 1;
                            case 258:
                            case H5MainActivity.REQUEST_REALNAME /* 260 */:
                                return 2;
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                        }
                    }
                    return 2;
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        } else if (i2 >= i) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(i);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        } else {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
    }

    private static void a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) ((i >>> 24) & 255);
    }

    private static long a(ByteBuffer byteBuffer, int i) throws C7322a {
        AbstractC7359x.a(byteBuffer);
        int i2 = i - 20;
        if (!(i2 >= 0 && byteBuffer.getInt(i2) == 117853008)) {
            ByteBuffer a = a(byteBuffer, i, byteBuffer.capacity());
            AbstractC7359x.a(a);
            long a2 = AbstractC7359x.a(a, a.position() + 16);
            long j = i;
            if (a2 < j) {
                AbstractC7359x.a(a);
                if (AbstractC7359x.a(a, a.position() + 12) + a2 == j) {
                    return a2;
                }
                throw new C7322a("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            throw new C7322a("ZIP Central Directory offset out of range: " + a2 + ". ZIP End of Central Directory offset: " + i);
        }
        throw new C7322a("ZIP64 APK not supported");
    }
}
