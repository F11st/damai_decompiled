package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.middletier.R;
import com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.uc.webview.export.media.MessageID;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ExtContainerActivity extends Activity {
    private static ActivityManager C;
    long f;
    IBXWebview a = null;
    Handler b = null;
    long c = 0;
    String d = "";
    String e = "?action=close";
    String g = "";
    String h = "";
    String i = null;
    String j = null;
    boolean k = false;
    boolean l = false;
    boolean m = false;
    boolean n = true;
    boolean o = false;
    boolean p = false;
    boolean q = true;
    boolean r = false;
    boolean s = true;
    boolean t = false;
    boolean u = false;
    float v = 1.0f;
    int w = 0;
    volatile int x = 0;
    volatile int y = 0;
    volatile int z = 0;
    volatile int A = 0;
    private long B = -1;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private class DownloadCompleteReceiver extends BroadcastReceiver {
        private DownloadCompleteReceiver() {
        }

        private File a(Context context, long j) {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            File file = null;
            if (j != -1) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(j);
                query.setFilterByStatus(8);
                Cursor query2 = downloadManager.query(query);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        String string = query2.getString(query2.getColumnIndex("local_uri"));
                        if (!TextUtils.isEmpty(string)) {
                            file = new File(Uri.parse(string).getPath());
                        }
                    }
                    query2.close();
                }
            }
            return file;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri uri;
            if (intent != null) {
                try {
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    if (longExtra == ExtContainerActivity.this.B && "android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                        ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                        if (extContainerActivity.r) {
                            extContainerActivity.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                        } else if (extContainerActivity.t) {
                            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                            String mimeTypeForDownloadedFile = downloadManager.getMimeTypeForDownloadedFile(longExtra);
                            if (TextUtils.isEmpty(mimeTypeForDownloadedFile)) {
                                mimeTypeForDownloadedFile = "*/*";
                            }
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.addFlags(268435456);
                            int i = Build.VERSION.SDK_INT;
                            if (i < 23) {
                                uri = downloadManager.getUriForDownloadedFile(longExtra);
                            } else if (i < 24) {
                                uri = Uri.fromFile(a(context, longExtra));
                            } else {
                                ExtContainerActivity.this.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                                uri = null;
                            }
                            if (uri != null) {
                                intent2.setDataAndType(uri, mimeTypeForDownloadedFile);
                                ExtContainerActivity.this.startActivity(intent2);
                            }
                        }
                    }
                } catch (Exception e) {
                    ExtContainerActivity.this.a(true, 2305, "", 0L, e.getMessage(), "");
                }
            }
            ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
            boolean z = extContainerActivity2.k;
            extContainerActivity2.a(z, 0, "", 0L, "onReceive", "" + ExtContainerActivity.this.B);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private class DownloadSerice implements IBXWebview.IBXDownloadService {
        private DownloadSerice() {
        }

        @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview.IBXDownloadService
        public long startDownload(String str, String str2) {
            int i;
            int i2;
            ExtContainerActivity extContainerActivity;
            AlertDialog.Builder positiveButton;
            int i3 = 0;
            try {
                extContainerActivity = ExtContainerActivity.this;
                extContainerActivity.i = str;
                extContainerActivity.j = str2;
            } catch (Exception e) {
                e = e;
                i = 0;
            }
            if (!extContainerActivity.n) {
                if (extContainerActivity.o) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str));
                    ExtContainerActivity.this.startActivity(intent);
                } else {
                    i = extContainerActivity.p ? 0 : 0;
                }
                i2 = 0;
                ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
                boolean z = extContainerActivity2.k;
                extContainerActivity2.a(z, 0, "", 0L, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i2 + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                return ExtContainerActivity.this.B;
            }
            final HashMap<String, String> installedMarketPackageName = AppStoreUtils.getInstalledMarketPackageName(extContainerActivity);
            i = installedMarketPackageName.size();
            try {
            } catch (Exception e2) {
                e = e2;
                ExtContainerActivity.this.a(true, 2304, "", 0L, e.getMessage(), "");
                i3 = i;
                i2 = 0;
                ExtContainerActivity extContainerActivity22 = ExtContainerActivity.this;
                boolean z2 = extContainerActivity22.k;
                extContainerActivity22.a(z2, 0, "", 0L, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i2 + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                return ExtContainerActivity.this.B;
            }
            if (installedMarketPackageName.size() > 1) {
                final String[] strArr = new String[installedMarketPackageName.size()];
                int i4 = 0;
                for (String str3 : installedMarketPackageName.keySet()) {
                    strArr[i4] = str3;
                    i4++;
                }
                positiveButton = new AlertDialog.Builder(ExtContainerActivity.this).setTitle(R.string.sg_app_store_select).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.DownloadSerice.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i5) {
                        ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                        AppStoreUtils.toMarket(extContainerActivity3, ExtContainerActivity.getPackageNameWrapper(extContainerActivity3), (String) installedMarketPackageName.get(strArr[i5]));
                    }
                });
            } else if (installedMarketPackageName.size() == 1) {
                ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                AppStoreUtils.toMarket(extContainerActivity3, ExtContainerActivity.getPackageNameWrapper(extContainerActivity3), installedMarketPackageName.get(installedMarketPackageName.keySet().iterator().next()));
                i3 = i;
                i2 = 0;
                ExtContainerActivity extContainerActivity222 = ExtContainerActivity.this;
                boolean z22 = extContainerActivity222.k;
                extContainerActivity222.a(z22, 0, "", 0L, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i2 + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                return ExtContainerActivity.this.B;
            } else {
                extContainerActivity = ExtContainerActivity.this;
                if (!extContainerActivity.p) {
                    positiveButton = new AlertDialog.Builder(ExtContainerActivity.this).setMessage(R.string.sg_app_store_not_exist).setPositiveButton(R.string.sg_dialog_ok, (DialogInterface.OnClickListener) null);
                }
            }
            positiveButton.create().show();
            i3 = i;
            i2 = 0;
            ExtContainerActivity extContainerActivity2222 = ExtContainerActivity.this;
            boolean z222 = extContainerActivity2222.k;
            extContainerActivity2222.a(z222, 0, "", 0L, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i2 + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
            return ExtContainerActivity.this.B;
            i2 = extContainerActivity.a(str, str2);
            i3 = i;
            ExtContainerActivity extContainerActivity22222 = ExtContainerActivity.this;
            boolean z2222 = extContainerActivity22222.k;
            extContainerActivity22222.a(z2222, 0, "", 0L, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i2 + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
            return ExtContainerActivity.this.B;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, String str2) {
        if (ContextCompat.checkSelfPermission(getApplication(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            b(str, str2);
            return 1;
        } else if (this.s) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1139);
            return 2;
        } else {
            new AlertDialog.Builder(this).setMessage(R.string.sg_permission_failed).setPositiveButton(R.string.sg_dialog_ok, (DialogInterface.OnClickListener) null).create().show();
            return 3;
        }
    }

    private String a(String str) throws MalformedURLException {
        String[] split;
        String query = new URL(str).getQuery();
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(query)) {
            sb.append(str);
            if (!str.endsWith("?")) {
                sb.append("?");
            }
            sb.append("tmd_nc=1");
            return sb.toString();
        }
        String str2 = null;
        for (String str3 : query.split("&")) {
            if (str3.startsWith("http_referer=")) {
                this.d = str3.substring(13);
                str2 = str3;
            } else if (!str3.equalsIgnoreCase("native=1")) {
                sb.append(str3);
                sb.append("&");
            }
        }
        sb.append("tmd_nc=1");
        if (str2 != null) {
            sb.append("&");
            sb.append(str2);
        }
        return str.replace(query, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.u = true;
        if (isFinishing()) {
            return;
        }
        if (!isTaskRoot() || Build.VERSION.SDK_INT < 21) {
            finish();
        } else {
            finishAndRemoveTask();
        }
    }

    private long b(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setVisibleInDownloadsUi(true);
        request.setAllowedOverRoaming(true);
        request.setAllowedNetworkTypes(2);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str2, getMIMEType(str)));
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        if (this.q) {
            Toast.makeText(this, "开始下载更新包", 0).show();
        }
        long enqueue = downloadManager.enqueue(request);
        this.B = enqueue;
        return enqueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context) {
        try {
            if (C == null) {
                C = (ActivityManager) context.getSystemService("activity");
            }
            ActivityManager activityManager = C;
            if (activityManager != null) {
                String packageName = context.getPackageName();
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && runningTasks.size() > 0) {
                    ComponentName componentName = runningTasks.get(0).topActivity;
                    if (!packageName.equals(componentName.getPackageName()) || !context.getPackageManager().getActivityInfo(componentName, 0).processName.equals(context.getApplicationInfo().processName)) {
                        return false;
                    }
                    if (!ExtContainerActivity.class.getName().equals(componentName.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getMIMEType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static String getPackageNameWrapper(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception unused) {
            return null;
        }
    }

    void a(int i, String str, String str2, String str3, boolean z, boolean z2, int i2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f;
        if (z2) {
            a(z2, 0, str, currentTimeMillis, str2, str3);
        }
        if (this.l) {
            Intent intent = new Intent(IUIBridge.INTENT_SEND_LOG);
            intent.setPackage(getApplicationContext().getPackageName());
            intent.putExtra(IUIBridge.KEY_UI_LOG, "{mn:100155,ec:" + i + ",msg:" + str + ",tc:" + currentTimeMillis + ",cp:" + str2 + ",ext:" + str3 + ",sid:" + this.c + ",bxuid:" + this.h + "}");
            intent.putExtra(IUIBridge.KEY_UI_LOG_WAY, 6);
            intent.putExtra(IUIBridge.KEY_UI_LOG_SEND, z);
            intent.putExtra(IUIBridge.KEY_UI_INFO, i2 + "&" + this.h);
            intent.putExtra(IUIBridge.KEY_IS_SAMPLE, this.l);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    void a(long j, String str, int i) {
        Intent intent = new Intent(str);
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra(IUIBridge.KEY_SESSION_ID, j);
        intent.putExtra(IUIBridge.KEY_UI_RESULT, i);
        intent.putExtra(IUIBridge.KEY_IS_SAMPLE, this.l);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    void a(boolean z, int i, String str, long j, String str2, String str3) {
        if (z) {
            String num = Integer.toString(100155);
            String str4 = this.g;
            UserTrackMethodJniBridge.addUtRecord(num, i, 7, str4, j, str, str2, str3, "" + this.c, this.h);
        }
    }

    void b(boolean z, int i, String str, long j, String str2, String str3) {
        if (z) {
            String num = Integer.toString(100169);
            String str4 = this.g;
            UserTrackMethodJniBridge.addUtRecord(num, i, 7, str4, j, str, str2, str3, "" + this.c, this.h);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.l && this.y == 0) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && this.z == 0) {
                        this.z = 1;
                    }
                } else if (this.y == 0) {
                    this.y = 1;
                    a(0, "", "Dispatchtouchevent", "" + this.x + "" + this.z + "" + this.y, false, true, 21);
                }
            } else if (this.x == 0) {
                this.x = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.m) {
            return;
        }
        super.onBackPressed();
        this.A = 4;
        a();
        a(this.c, IUIBridge.INTENT_ACTIVITY_RESULT, 4);
        a(0, "", "Onbackpressed", "" + this.m, false, this.k, 19);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0210  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.u = true;
        super.onDestroy();
        IBXWebview iBXWebview = this.a;
        if (iBXWebview != null) {
            try {
                iBXWebview.bxDestroy();
                this.a = null;
            } catch (Exception unused) {
            }
        }
        a(0, "", "", "Ondestroy" + this.A, this.A == 0, true, 22);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        a(0, "", MessageID.onPause, MessageID.onPause, false, this.k, 14);
        this.b.postDelayed(new Runnable() { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                if (!extContainerActivity.u && ExtContainerActivity.b((Context) extContainerActivity)) {
                    ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
                    extContainerActivity2.A = 5;
                    extContainerActivity2.a(extContainerActivity2.c, IUIBridge.INTENT_ACTIVITY_RESULT, 1);
                    ExtContainerActivity.this.b();
                    ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                    extContainerActivity3.a(0, "", MessageID.onPause, "", false, extContainerActivity3.k, 20);
                }
            }
        }, 1000L);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2;
        if (i == 1139) {
            if (iArr.length > 0 && iArr[0] == 0) {
                b(this.i, this.j);
                i2 = 1;
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(this).setMessage("应用更新需要授予存储权限，请到设置中开启存储权限").setPositiveButton("确定", (DialogInterface.OnClickListener) null).setNegativeButton(WXModalUIModule.CANCEL, (DialogInterface.OnClickListener) null).create().show();
                i2 = 2;
            } else {
                new AlertDialog.Builder(this).setMessage("应用更新需要授予存储权限，请到设置中开启存储权限").setPositiveButton("确定", (DialogInterface.OnClickListener) null).create().show();
                i2 = 3;
            }
            boolean z = this.k;
            a(z, 0, "", 0L, "onRequestPermissionsResult", "" + i2);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a(this.c, IUIBridge.INTENT_ACTIVITY_CREATE, 1);
        a(0, "", "onResume", "onResume", false, this.k, 13);
    }
}
