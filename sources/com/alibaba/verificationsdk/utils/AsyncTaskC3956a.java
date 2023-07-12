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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import tb.ra1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.verificationsdk.utils.a */
/* loaded from: classes8.dex */
public class AsyncTaskC3956a extends AsyncTask<Void, Integer, Long> {
    private URL a;
    private File b;
    private ProgressDialog c;
    private C3958b e;
    private Context f;
    private DownloadListener g;
    private int d = 0;
    private int h = 8192;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.verificationsdk.utils.a$a */
    /* loaded from: classes8.dex */
    class DialogInterface$OnCancelListenerC3957a implements DialogInterface.OnCancelListener {
        DialogInterface$OnCancelListenerC3957a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AsyncTaskC3956a.this.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.verificationsdk.utils.a$b */
    /* loaded from: classes8.dex */
    public final class C3958b extends FileOutputStream {
        public C3958b(File file) throws FileNotFoundException {
            super(file);
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            super.write(bArr, i, i2);
            AsyncTaskC3956a.b(AsyncTaskC3956a.this, i2);
            AsyncTaskC3956a asyncTaskC3956a = AsyncTaskC3956a.this;
            asyncTaskC3956a.publishProgress(Integer.valueOf(asyncTaskC3956a.d));
        }
    }

    public AsyncTaskC3956a(String str, String str2, Context context, DownloadListener downloadListener) {
        this.f = context;
        this.g = downloadListener;
        if (context != null) {
            this.c = new ProgressDialog(this.f);
        } else {
            this.c = null;
        }
        try {
            this.a = new URL(str);
            String name = new File(this.a.getFile()).getName();
            this.b = new File(str2, name);
            ra1.b("DownLoaderTask", "out=" + str2 + ", name=" + name + ",mUrl.getFile()=" + this.a.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ int b(AsyncTaskC3956a asyncTaskC3956a, int i) {
        int i2 = asyncTaskC3956a.d + i;
        asyncTaskC3956a.d = i2;
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

    private long f() {
        URLConnection openConnection;
        int contentLength;
        int i = 0;
        try {
            openConnection = this.a.openConnection();
            contentLength = openConnection.getContentLength();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.b.exists() && contentLength == this.b.length()) {
            ra1.b("DownLoaderTask", "file " + this.b.getName() + " already exits!!");
            return 0L;
        }
        this.e = new C3958b(this.b);
        publishProgress(0, Integer.valueOf(contentLength));
        i = d(openConnection.getInputStream(), this.e);
        if (i != contentLength && contentLength != -1) {
            ra1.a("DownLoaderTask", "Download incomplete bytesCopied=" + i + ", length" + contentLength);
        }
        this.e.close();
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e */
    public Long doInBackground(Void... voidArr) {
        return Long.valueOf(f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: g */
    public void onPostExecute(Long l) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.c.dismiss();
        }
        DownloadListener downloadListener = this.g;
        if (downloadListener != null) {
            downloadListener.downloadFinished(this.b);
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
            int intValue = numArr[1].intValue();
            if (intValue == -1) {
                this.c.setIndeterminate(true);
                return;
            } else {
                this.c.setMax(intValue);
                return;
            }
        }
        progressDialog.setProgress(numArr[0].intValue());
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            progressDialog.setTitle("Downloading...");
            this.c.setMessage(this.b.getName());
            this.c.setProgressStyle(1);
            this.c.setOnCancelListener(new DialogInterface$OnCancelListenerC3957a());
            this.c.show();
        }
        DownloadListener downloadListener = this.g;
        if (downloadListener != null) {
            downloadListener.downloadStart();
        }
    }
}
