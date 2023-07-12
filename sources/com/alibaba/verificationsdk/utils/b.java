package com.alibaba.verificationsdk.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import tb.ra1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class b extends AsyncTask<Void, Integer, Long> {
    private final File a;
    private final File b;
    private final ProgressDialog c;
    private final Context e;
    private boolean f;
    private ZIPExtracListener g;
    private int d = 0;
    private int h = 8192;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.verificationsdk.utils.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0179b extends FileOutputStream {
        public C0179b(File file) throws FileNotFoundException {
            super(file);
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            super.write(bArr, i, i2);
            b.b(b.this, i2);
            b bVar = b.this;
            bVar.publishProgress(Integer.valueOf(bVar.d));
        }
    }

    public b(String str, String str2, Context context, boolean z, ZIPExtracListener zIPExtracListener) {
        this.a = new File(str);
        File file = new File(str2);
        this.b = file;
        this.g = zIPExtracListener;
        if (!file.exists() && !file.mkdirs()) {
            ra1.a("ZipExtractorTask", "Failed to make directories:" + file.getAbsolutePath());
        }
        this.e = context;
        if (context != null) {
            this.c = new ProgressDialog(context);
        } else {
            this.c = null;
        }
        this.f = z;
    }

    static /* synthetic */ int b(b bVar, int i) {
        int i2 = bVar.d + i;
        bVar.d = i2;
        return i2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0044 -> B:25:0x0047). Please submit an issue!!! */
    private int d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[this.h];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, this.h);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, this.h);
        int i = 0;
        while (true) {
            try {
                try {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, this.h);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                        i += read;
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        bufferedInputStream.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        bufferedInputStream.close();
        return i;
    }

    private long f(ZipFile zipFile) {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        long j = 0;
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getSize() >= 0) {
                j += nextElement.getSize();
            }
        }
        return j;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b5: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:39:0x00b5 */
    private long i() {
        ZipFile zipFile;
        IOException e;
        ZipException e2;
        ZipFile zipFile2;
        C0179b c0179b;
        long j = 0;
        ZipFile zipFile3 = null;
        try {
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            try {
                zipFile = new ZipFile(this.a);
            } catch (ZipException e4) {
                zipFile = null;
                e2 = e4;
            } catch (IOException e5) {
                zipFile = null;
                e = e5;
            } catch (Throwable th) {
                th = th;
                try {
                    zipFile3.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                throw th;
            }
            try {
                publishProgress(0, Integer.valueOf((int) f(zipFile)));
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        File file = new File(this.b, nextElement.getName());
                        if (!file.getParentFile().exists()) {
                            ra1.a("ZipExtractorTask", "make=" + file.getParentFile().getAbsolutePath());
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            Context context = this.e;
                        }
                        j += d(zipFile.getInputStream(nextElement), c0179b);
                        new C0179b(file).close();
                    }
                }
                zipFile.close();
            } catch (ZipException e7) {
                e2 = e7;
                e2.printStackTrace();
                zipFile.close();
                return j;
            } catch (IOException e8) {
                e = e8;
                e.printStackTrace();
                zipFile.close();
                return j;
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            zipFile3 = zipFile2;
            zipFile3.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e */
    public Long doInBackground(Void... voidArr) {
        return Long.valueOf(i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: g */
    public void onPostExecute(Long l) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.c.dismiss();
        }
        ZIPExtracListener zIPExtracListener = this.g;
        if (zIPExtracListener != null) {
            zIPExtracListener.unzipFinished(this.a, this.b);
        }
        isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: h */
    public void onProgressUpdate(Integer... numArr) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog == null) {
            return;
        }
        if (numArr.length > 1) {
            this.c.setMax(numArr[1].intValue());
            return;
        }
        progressDialog.setProgress(numArr[0].intValue());
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            progressDialog.setTitle("Extracting");
            this.c.setMessage(this.a.getName());
            this.c.setProgressStyle(1);
            this.c.setOnCancelListener(new a());
            this.c.show();
        }
        ZIPExtracListener zIPExtracListener = this.g;
        if (zIPExtracListener != null) {
            zIPExtracListener.unzipStart();
        }
    }
}
