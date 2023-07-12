package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.e;
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
                com.taobao.android.dinamicx.e eVar = new com.taobao.android.dinamicx.e(str2);
                e.a aVar = new e.a("Downloader", "Downloader_download", com.taobao.android.dinamicx.e.DX_TEMPLATE_DOWNLOAD_ERROR_60023);
                aVar.e = "下载链接为空" + str;
                eVar.b = dXTemplateItem;
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
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
                com.taobao.android.dinamicx.e eVar2 = new com.taobao.android.dinamicx.e(str2);
                e.a aVar2 = new e.a("Downloader", "Downloader_download", com.taobao.android.dinamicx.e.DX_TEMPLATE_DOWNLOAD_ERROR_60024);
                aVar2.e = "url: " + str + " stack: " + ry.a(e);
                eVar2.b = dXTemplateItem;
                eVar2.c.add(aVar2);
                DXAppMonitor.n(eVar2);
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
