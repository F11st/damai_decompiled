package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.IDXDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e01 implements IDXDownloader {
    public byte[] a(String str, String str2, DXTemplateItem dXTemplateItem) {
        if (TextUtils.isEmpty(str)) {
            s00.e(str + "下载链接为空");
            try {
                C6368e c6368e = new C6368e(str2);
                C6368e.C6369a c6369a = new C6368e.C6369a("Downloader", "Downloader_download", C6368e.DX_TEMPLATE_DOWNLOAD_ERROR_60023);
                c6369a.e = "下载链接为空" + str;
                c6368e.b = dXTemplateItem;
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
            } catch (Throwable th) {
                ry.b(th);
            }
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    httpURLConnection.disconnect();
                    inputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            try {
                C6368e c6368e2 = new C6368e(str2);
                C6368e.C6369a c6369a2 = new C6368e.C6369a("Downloader", "Downloader_download", C6368e.DX_TEMPLATE_DOWNLOAD_ERROR_60024);
                c6369a2.e = "url: " + str + " stack: " + ry.a(e);
                c6368e2.b = dXTemplateItem;
                c6368e2.c.add(c6369a2);
                DXAppMonitor.n(c6368e2);
            } catch (Throwable th2) {
                ry.b(th2);
            }
            return null;
        }
    }

    @Override // com.taobao.android.dinamicx.template.download.IDXDownloader
    public byte[] download(String str) {
        return a(str, null, null);
    }
}
