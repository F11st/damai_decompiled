package tb;

import android.app.DownloadManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.taobao.downloader.download.IDownloader;
import com.taobao.downloader.download.IListener;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class er implements IDownloader {
    private long a;
    private ContentObserver b;
    private IListener c;
    private id2 d;
    private static DownloadManager e = (DownloadManager) um.a.getSystemService("download");
    public static final Uri CONTENT_URI = Uri.parse("content://downloads/my_downloads");

    /* compiled from: Taobao */
    /* renamed from: tb.er$a */
    /* loaded from: classes11.dex */
    class C9110a extends ContentObserver {
        C9110a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            er.this.e();
        }
    }

    private void b() {
        if (this.b != null) {
            um.a.getContentResolver().unregisterContentObserver(this.b);
        }
    }

    private boolean c() {
        return um.a.checkCallingOrSelfPermission("android.permission.DOWNLOAD_WITHOUT_NOTIFICATION") == 0;
    }

    private boolean d(long j) {
        return Environment.getExternalStorageDirectory().getFreeSpace() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.a <= 0) {
            return;
        }
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(this.a);
        Cursor query2 = e.query(query);
        if (query2 == null || !query2.moveToFirst()) {
            return;
        }
        int i = query2.getInt(query2.getColumnIndex("status"));
        int columnIndex = query2.getColumnIndex("reason");
        int columnIndex2 = query2.getColumnIndex("title");
        int columnIndex3 = query2.getColumnIndex("total_size");
        int columnIndex4 = query2.getColumnIndex("bytes_so_far");
        String string = query2.getString(columnIndex2);
        int i2 = query2.getInt(columnIndex3);
        int i3 = query2.getInt(columnIndex4);
        query2.getInt(columnIndex);
        this.c.onProgress(i3);
        ka0.c("DMDownloader", "queryDownloadStatus", "tag", string + StringUtils.LF + "Downloaded " + i3 + " / " + i2);
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            return;
                        }
                        ka0.c("DMDownloader", "queryDownloadStatus", "STATUS_FAILED");
                        return;
                    }
                    String string2 = query2.getString(query2.getColumnIndex("local_filename"));
                    if (!TextUtils.isEmpty(string2)) {
                        this.d.d = string2;
                    }
                    id2 id2Var = this.d;
                    id2Var.a = true;
                    this.c.onResult(id2Var);
                    b();
                    return;
                }
                ka0.c("DMDownloader", "queryDownloadStatus", "STATUS_PAUSED");
            }
            ka0.c("DMDownloader", "queryDownloadStatus", "STATUS_RUNNING");
        }
        ka0.c("DMDownloader", "queryDownloadStatus", "STATUS_PENDING");
        ka0.c("DMDownloader", "queryDownloadStatus", "STATUS_RUNNING");
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void cancel() {
        e.remove(this.a);
        b();
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void download(id2 id2Var, IListener iListener) {
        this.c = iListener;
        this.d = id2Var;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(id2Var.e.a));
        int i = id2Var.f.c;
        int i2 = (i & 2) == 2 ? 1 : 0;
        if ((i & 1) == 1 || (i & 4) == 4) {
            i2 |= 2;
        }
        request.setAllowedNetworkTypes(i2);
        if ((id2Var.f.c & 4) != 4 && Build.VERSION.SDK_INT > 16) {
            request.setAllowedOverMetered(false);
        }
        if (!TextUtils.isEmpty(id2Var.f.h)) {
            request.setTitle(id2Var.f.h);
            request.setDescription(id2Var.f.i);
        }
        String a = id2Var.a();
        request.setDestinationUri(Uri.fromFile(new File(id2Var.g + "/" + a)));
        id2 id2Var2 = this.d;
        id2Var2.d = id2Var.g + "/" + a;
        if (!id2Var.f.j) {
            request.setVisibleInDownloadsUi(false);
            if (c()) {
                request.setNotificationVisibility(2);
            }
        } else {
            request.setNotificationVisibility(this.d.f.k);
        }
        if (!d(id2Var.e.b)) {
            id2Var.a = false;
            id2Var.b = -21;
            id2Var.c = "手机剩余空间不足";
            jq1 jq1Var = id2Var.f;
            jq1Var.l = 0;
            jq1Var.d = 0;
            this.c.onResult(id2Var);
            return;
        }
        this.a = e.enqueue(request);
        this.b = new C9110a(null);
        um.a.getContentResolver().registerContentObserver(CONTENT_URI, true, this.b);
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void pause() {
        b();
    }
}
