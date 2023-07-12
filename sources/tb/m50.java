package tb;

import android.os.Environment;
import com.taobao.downloader.download.IDownloader;
import com.taobao.downloader.download.IListener;
import com.taobao.downloader.download.protocol.DLConnection;
import com.taobao.downloader.download.protocol.DLInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.fp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m50 implements IDownloader {
    public static final int ST_CANCELED = 2;
    public static final int ST_PAUSED = 1;
    private w21 a;
    private fp1 b;
    private int c;

    private boolean a() {
        Throwable th;
        DLInputStream dLInputStream;
        DLConnection dLConnection;
        DLInputStream dLInputStream2;
        RandomAccessFile randomAccessFile = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            dLConnection = b();
            try {
                this.b.f.e += System.currentTimeMillis() - currentTimeMillis;
                if (dLConnection == null) {
                    if (dLConnection != null) {
                        try {
                            dLConnection.disConnect();
                        } catch (Throwable th2) {
                            ka0.d("Downloader", "on exception", th2, new Object[0]);
                        }
                    }
                    return false;
                }
                try {
                    try {
                        dLInputStream2 = dLConnection.getInputStream();
                        if (dLInputStream2 != null) {
                            try {
                                RandomAccessFile c = this.a.c();
                                if (c != null) {
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    boolean f = f(dLInputStream2, c);
                                    this.b.f.f += System.currentTimeMillis() - currentTimeMillis2;
                                    if (!f) {
                                        if (c != null) {
                                            try {
                                                c.close();
                                            } catch (IOException e) {
                                                ka0.d("Downloader", "on exception", e, new Object[0]);
                                            }
                                        }
                                        if (dLInputStream2 != null) {
                                            try {
                                                dLInputStream2.close();
                                            } catch (Throwable th3) {
                                                ka0.d("Downloader", "on exception", th3, new Object[0]);
                                            }
                                        }
                                        try {
                                            dLConnection.disConnect();
                                        } catch (Throwable th4) {
                                            ka0.d("Downloader", "on exception", th4, new Object[0]);
                                        }
                                        return false;
                                    } else if (this.a.e()) {
                                        w21 w21Var = this.a;
                                        if (ui0.e(w21Var.d, w21Var.e)) {
                                            this.b.a = 10;
                                            if (c != null) {
                                                try {
                                                    c.close();
                                                } catch (IOException e2) {
                                                    ka0.d("Downloader", "on exception", e2, new Object[0]);
                                                }
                                            }
                                            if (dLInputStream2 != null) {
                                                try {
                                                    dLInputStream2.close();
                                                } catch (Throwable th5) {
                                                    ka0.d("Downloader", "on exception", th5, new Object[0]);
                                                }
                                            }
                                            try {
                                                dLConnection.disConnect();
                                            } catch (Throwable th6) {
                                                ka0.d("Downloader", "on exception", th6, new Object[0]);
                                            }
                                            return true;
                                        }
                                        this.b.e.a(-11, this.a.e.getParentFile().canWrite() ? 104 : 105, "rename tmp file error").e = true;
                                        if (c != null) {
                                            try {
                                                c.close();
                                            } catch (IOException e3) {
                                                ka0.d("Downloader", "on exception", e3, new Object[0]);
                                            }
                                        }
                                        if (dLInputStream2 != null) {
                                            try {
                                                dLInputStream2.close();
                                            } catch (Throwable th7) {
                                                ka0.d("Downloader", "on exception", th7, new Object[0]);
                                            }
                                        }
                                        try {
                                            dLConnection.disConnect();
                                        } catch (Throwable th8) {
                                            ka0.d("Downloader", "on exception", th8, new Object[0]);
                                        }
                                        return false;
                                    } else {
                                        this.a.d.delete();
                                        this.b.e.a(this.a.a(), 106, "download invalid");
                                        if (c != null) {
                                            try {
                                                c.close();
                                            } catch (IOException e4) {
                                                ka0.d("Downloader", "on exception", e4, new Object[0]);
                                            }
                                        }
                                        if (dLInputStream2 != null) {
                                            try {
                                                dLInputStream2.close();
                                            } catch (Throwable th9) {
                                                ka0.d("Downloader", "on exception", th9, new Object[0]);
                                            }
                                        }
                                        try {
                                            dLConnection.disConnect();
                                        } catch (Throwable th10) {
                                            ka0.d("Downloader", "on exception", th10, new Object[0]);
                                        }
                                        return false;
                                    }
                                }
                                throw new FileNotFoundException("outputStream is null");
                            } catch (FileNotFoundException e5) {
                                ka0.d("Downloader", "getRandomAccessFile", e5, new Object[0]);
                                this.b.e.a(-11, 103, dLConnection.getErrorMsg()).e = true;
                                if (0 != 0) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e6) {
                                        ka0.d("Downloader", "on exception", e6, new Object[0]);
                                    }
                                }
                                if (dLInputStream2 != null) {
                                    try {
                                        dLInputStream2.close();
                                    } catch (Throwable th11) {
                                        ka0.d("Downloader", "on exception", th11, new Object[0]);
                                    }
                                }
                                try {
                                    dLConnection.disConnect();
                                } catch (Throwable th12) {
                                    ka0.d("Downloader", "on exception", th12, new Object[0]);
                                }
                                return false;
                            }
                        }
                        try {
                            throw new IOException("inputstream is null");
                        } catch (IOException e7) {
                            e = e7;
                            ka0.d("Downloader", "conn.getinputstream exception", e, new Object[0]);
                            this.b.e.a(-12, 205, dLConnection.getErrorMsg()).c = true;
                            if (dLInputStream2 != null) {
                                try {
                                    dLInputStream2.close();
                                } catch (Throwable th13) {
                                    ka0.d("Downloader", "on exception", th13, new Object[0]);
                                }
                            }
                            try {
                                dLConnection.disConnect();
                            } catch (Throwable th14) {
                                ka0.d("Downloader", "on exception", th14, new Object[0]);
                            }
                            return false;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        dLInputStream2 = null;
                    }
                } catch (Throwable th15) {
                    th = th15;
                    if (0 != 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e9) {
                            ka0.d("Downloader", "on exception", e9, new Object[0]);
                        }
                    }
                    if (dLInputStream != null) {
                        try {
                            dLInputStream.close();
                        } catch (Throwable th16) {
                            ka0.d("Downloader", "on exception", th16, new Object[0]);
                        }
                    }
                    if (dLConnection != null) {
                        try {
                            dLConnection.disConnect();
                        } catch (Throwable th17) {
                            ka0.d("Downloader", "on exception", th17, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th18) {
                th = th18;
                dLInputStream = null;
            }
        } catch (Throwable th19) {
            th = th19;
            dLInputStream = null;
            dLConnection = null;
        }
    }

    private DLConnection b() {
        w21 w21Var = this.a;
        DLConnection b = ij2.b(w21Var.b.e, w21Var.a);
        try {
            w21 w21Var2 = this.a;
            b.openConnection(w21Var2.c, w21Var2.a);
            b.addRequestProperty(HttpHeaderConstant.F_REFER, "download_" + this.a.b.f.a);
            long b2 = this.a.b();
            if (0 != b2) {
                String str = "bytes=" + b2 + "-";
                ka0.g("Downloader", "getConnection", "add request property range", str);
                b.addRequestProperty("Range", str);
                this.b.f.d = true;
            } else {
                this.b.f.d = false;
            }
            try {
                b.connect();
                try {
                    int statusCode = b.getStatusCode();
                    if (this.a.f(b.getDownloadLength(), statusCode)) {
                        return b;
                    }
                    this.b.e.a(-12, statusCode, b.getErrorMsg()).c = true;
                    return null;
                } catch (Exception e) {
                    ka0.d("Downloader", "conn.getstatuscode exception", e, new Object[0]);
                    this.b.e.a(-12, 204, b.getErrorMsg()).c = true;
                    return null;
                }
            } catch (IOException e2) {
                ka0.d("Downloader", "conn.conn exception", e2, new Object[0]);
                this.b.e.a(-12, 203, b.getErrorMsg()).c = true;
                return null;
            }
        } catch (IOException e3) {
            ka0.d("Downloader", "conn.open exception", e3, new Object[0]);
            this.b.e.a(-12, 202, b.getErrorMsg()).c = true;
            return null;
        }
    }

    private String c(Throwable th) {
        if ((th instanceof RuntimeException) && th.getMessage() != null && th.getMessage().length() < 20) {
            return th.getClass().getSimpleName() + ":" + th.getMessage();
        }
        return th.getClass().getSimpleName();
    }

    private int d() {
        int i = this.c;
        if (i > 0) {
            if ((i & 1) == 1) {
                return 1;
            }
            if ((i & 2) == 2) {
                if (this.a.d.exists()) {
                    this.a.d.delete();
                }
                return 2;
            }
            return 0;
        }
        return 0;
    }

    private boolean e(long j) {
        return Environment.getExternalStorageDirectory().getFreeSpace() >= j;
    }

    private boolean f(DLInputStream dLInputStream, RandomAccessFile randomAccessFile) {
        if (dLInputStream != null && randomAccessFile != null) {
            this.b.c = this.a.d.length();
            FileChannel channel = randomAccessFile.getChannel();
            try {
                channel.position(randomAccessFile.length());
                byte[] bArr = new byte[ij2.c()];
                while (true) {
                    int d = d();
                    if (d > 0) {
                        this.b.e.a(-20, d, "");
                        return false;
                    }
                    try {
                        int read = dLInputStream.read(bArr);
                        if (-1 == read) {
                            return true;
                        }
                        this.b.d = true;
                        try {
                            channel.write(ByteBuffer.wrap(bArr, 0, read));
                            fp1 fp1Var = this.b;
                            long j = read;
                            fp1Var.c += j;
                            fp1Var.f.i += j;
                            fp1Var.b();
                        } catch (IOException e) {
                            ka0.d("Downloader", "fc.write exception", e, new Object[0]);
                            this.b.e.a(-11, 102, c(e)).e = true;
                            return false;
                        }
                    } catch (Exception e2) {
                        ka0.d("Downloader", "input.read exception", e2, new Object[0]);
                        this.b.e.a(-12, 201, c(e2)).d = true;
                        return false;
                    }
                }
            } catch (IOException e3) {
                ka0.d("Downloader", "fc.position exception", e3, new Object[0]);
                this.b.e.a(-11, 101, c(e3)).e = true;
                return false;
            }
        } else {
            fp1.a aVar = this.b.e;
            StringBuilder sb = new StringBuilder();
            sb.append("savedataParam:");
            sb.append(dLInputStream == null);
            sb.append("|");
            sb.append(randomAccessFile == null);
            aVar.a(-19, 0, sb.toString());
            return false;
        }
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void cancel() {
        this.c |= 2;
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void download(id2 id2Var, IListener iListener) {
        int d;
        fp1 fp1Var;
        this.a = new w21(id2Var);
        this.b = new fp1(iListener);
        try {
            d = d();
        } finally {
            try {
                return;
            } finally {
            }
        }
        if (d > 0) {
            this.b.e.a(-20, d, "");
        } else {
            this.a.g();
            if (this.a.d()) {
                fp1Var = this.b;
                fp1Var.a = 11;
                fp1Var.a(this.a);
            } else if (this.a.e()) {
                w21 w21Var = this.a;
                if (ui0.e(w21Var.d, w21Var.e)) {
                    this.b.a = 11;
                } else {
                    this.b.e.a(-11, this.a.e.getParentFile().canWrite() ? 104 : 105, "rename tmp file error").e = true;
                }
            } else if (!e(id2Var.e.b)) {
                fp1 fp1Var2 = this.b;
                fp1.a aVar = fp1Var2.e;
                aVar.a = false;
                aVar.f = -21;
                w21 w21Var2 = this.a;
                jq1 jq1Var = w21Var2.b.f;
                jq1Var.l = 0;
                jq1Var.d = 0;
                fp1Var2.a(w21Var2);
                return;
            } else {
                a();
                return;
            }
        }
        fp1Var = this.b;
        fp1Var.a(this.a);
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void pause() {
        this.c |= 1;
    }
}
