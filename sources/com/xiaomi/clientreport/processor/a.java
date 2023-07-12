package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.taobao.windvane.jsbridge.api.WVFile;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ab;
import com.xiaomi.push.af;
import com.xiaomi.push.bp;
import com.xiaomi.push.bt;
import com.xiaomi.push.i;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements IEventProcessor {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f21a;

    public a(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        com.xiaomi.channel.commonutils.logger.b.d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> a(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
        L15:
            int r9 = r5.read(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = -1
            if (r9 != r4) goto L1d
            goto L66
        L1d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L25
        L21:
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L25:
            int r9 = com.xiaomi.push.af.a(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r7 = -573785174(0xffffffffddccbbaa, float:-1.8440715E18)
            if (r9 == r7) goto L2f
            goto L21
        L2f:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r9 != r4) goto L36
            goto L66
        L36:
            if (r9 == r1) goto L3e
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
        L3a:
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L3e:
            int r9 = com.xiaomi.push.af.a(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = 1
            if (r9 < r4) goto L63
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L4a
            goto L63
        L4a:
            byte[] r4 = new byte[r9]     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            int r6 = r5.read(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r6 == r9) goto L55
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            goto L3a
        L55:
            java.lang.String r9 = r8.bytesToString(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L15
        L63:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            goto L3a
        L66:
            com.xiaomi.push.ab.a(r5)
            goto L79
        L6a:
            r9 = move-exception
            r4 = r5
            goto L7a
        L6d:
            r9 = move-exception
            r4 = r5
            goto L73
        L70:
            r9 = move-exception
            goto L7a
        L72:
            r9 = move-exception
        L73:
            com.xiaomi.channel.commonutils.logger.b.a(r9)     // Catch: java.lang.Throwable -> L70
            com.xiaomi.push.ab.a(r4)
        L79:
            return r0
        L7a:
            com.xiaomi.push.ab.a(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.a.a(java.lang.String):java.util.List");
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        ab.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        com.xiaomi.clientreport.manager.a a = com.xiaomi.clientreport.manager.a.a(this.a);
        EventClientReport a2 = a.a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.toJsonString());
        a(arrayList);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String b = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            File file = new File(b + ".lock");
            ab.m659a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b), true));
                } catch (Exception e) {
                    e = e;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    ab.a(bufferedOutputStream2);
                    a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            try {
                int i = 0;
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                        if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                            if (!bt.m708a(this.a, b)) {
                                int length = aVarArr.length - i;
                                com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                ab.a(bufferedOutputStream);
                                a(randomAccessFile, fileLock);
                                return aVarArr2;
                            }
                            bufferedOutputStream.write(af.a(-573785174));
                            bufferedOutputStream.write(af.a(stringToBytes.length));
                            bufferedOutputStream.write(stringToBytes);
                            bufferedOutputStream.flush();
                            i++;
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                ab.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
            ab.a(bufferedOutputStream);
            a(randomAccessFile, fileLock);
            return null;
        }
        ab.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File externalFilesDir = this.a.getExternalFilesDir("event");
        String a = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a;
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (bt.m708a(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        int i;
        RandomAccessFile randomAccessFile;
        bt.a(this.a, "event", "eventUploading");
        File[] m709a = bt.m709a(this.a, "eventUploading");
        if (m709a == null || m709a.length <= 0) {
            return;
        }
        int length = m709a.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        while (i < length) {
            File file2 = m709a[i];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                ab.a(randomAccessFile2);
                i = file == null ? i + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (file2.length() > WVFile.FILE_MAX_SIZE) {
                    com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                    a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                    file2.delete();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    ab.a(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath + ".lock");
                    try {
                        ab.m659a(file3);
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                    } catch (Exception e4) {
                        e = e4;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        a(a(absolutePath));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        ab.a(randomAccessFile);
                        file3.delete();
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e7) {
                                com.xiaomi.channel.commonutils.logger.b.a(e7);
                            }
                        }
                        ab.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                com.xiaomi.channel.commonutils.logger.b.a(e8);
                            }
                        }
                        ab.a(randomAccessFile2);
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo594a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f21a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f21a.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f21a.put(a, arrayList);
        }
    }

    public void a(List<String> list) {
        bt.a(this.a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m595a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0) {
                return;
            }
        } while (aVarArr[0] != null);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f21a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f21a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f21a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m595a(aVarArr);
                }
            }
        }
        this.f21a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.a).m591a().isEventEncrypted()) {
                return bp.b(bArr);
            }
            String a2 = bt.a(this.a);
            if (!TextUtils.isEmpty(a2) && (a = bt.a(a2)) != null && a.length > 0) {
                try {
                    return bp.b(Base64.decode(i.a(a, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f21a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.a).m591a().isEventEncrypted()) {
            String a2 = bt.a(this.a);
            byte[] m704a = bp.m704a(str);
            if (!TextUtils.isEmpty(a2) && m704a != null && m704a.length > 1 && (a = bt.a(a2)) != null) {
                try {
                    if (a.length > 1) {
                        return i.b(a, Base64.encode(m704a, 2));
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            return null;
        }
        return bp.m704a(str);
    }
}
