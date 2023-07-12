package com.taomai.android.h5container.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVContextUtil;
import android.taobao.windvane.webview.WVWebChromeClient;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J0\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0017"}, d2 = {"Lcom/taomai/android/h5container/webview/TaoMaiWebChromeClient;", "Landroid/taobao/windvane/webview/WVWebChromeClient;", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "onShowFileChooser", "handleOnShowFileChooser", "Landroid/webkit/PermissionRequest;", "request", "Ltb/wt2;", "onPermissionRequest", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public class TaoMaiWebChromeClient extends WVWebChromeClient {
    @NotNull
    public static final C7026a Companion = new C7026a(null);
    public static final int FILE_CHOOSER_REQUEST_CODE = 15;

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$a */
    /* loaded from: classes11.dex */
    public static final class C7026a {
        private C7026a() {
        }

        public /* synthetic */ C7026a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$b */
    /* loaded from: classes11.dex */
    static final class DialogInterface$OnClickListenerC7027b implements DialogInterface.OnClickListener {
        final /* synthetic */ PermissionRequest a;

        DialogInterface$OnClickListenerC7027b(PermissionRequest permissionRequest) {
            this.a = permissionRequest;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.a.grant(new String[]{com.uc.webview.export.PermissionRequest.RESOURCE_VIDEO_CAPTURE});
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$c */
    /* loaded from: classes11.dex */
    static final class DialogInterface$OnClickListenerC7028c implements DialogInterface.OnClickListener {
        final /* synthetic */ PermissionRequest a;

        DialogInterface$OnClickListenerC7028c(PermissionRequest permissionRequest) {
            this.a = permissionRequest;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.a.deny();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$d */
    /* loaded from: classes11.dex */
    static final class DialogInterface$OnClickListenerC7029d implements DialogInterface.OnClickListener {
        final /* synthetic */ PermissionRequest a;

        DialogInterface$OnClickListenerC7029d(PermissionRequest permissionRequest) {
            this.a = permissionRequest;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.a.grant(new String[]{com.uc.webview.export.PermissionRequest.RESOURCE_AUDIO_CAPTURE});
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$e */
    /* loaded from: classes11.dex */
    static final class DialogInterface$OnClickListenerC7030e implements DialogInterface.OnClickListener {
        final /* synthetic */ PermissionRequest a;

        DialogInterface$OnClickListenerC7030e(PermissionRequest permissionRequest) {
            this.a = permissionRequest;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.a.deny();
        }
    }

    public TaoMaiWebChromeClient(@Nullable Context context) {
        super(context);
    }

    public final boolean handleOnShowFileChooser(@Nullable final WebView webView, @Nullable final ValueCallback<Uri[]> valueCallback, @Nullable final WebChromeClient.FileChooserParams fileChooserParams) {
        if (fileChooserParams == null || valueCallback == null) {
            return false;
        }
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$handleOnShowFileChooser$1
                @Override // java.lang.Runnable
                public final void run() {
                    TaoLog.d("TaoMaiWebChromeClient", " onShowFileChooser permission granted");
                    Intent createIntent = fileChooserParams.createIntent();
                    WebView webView2 = webView;
                    b41.f(webView2);
                    Context realContext = WVContextUtil.getRealContext(webView2.getContext());
                    if (realContext instanceof Activity) {
                        ((Activity) realContext).startActivityForResult(Intent.createChooser(createIntent, "choose"), 15);
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: com.taomai.android.h5container.webview.TaoMaiWebChromeClient$handleOnShowFileChooser$2
                @Override // java.lang.Runnable
                public final void run() {
                    TaoLog.d("TaoMaiWebChromeClient", " onShowFileChooser permission denied");
                    valueCallback.onReceiveValue(null);
                }
            }).execute();
            return true;
        } catch (Throwable th) {
            TaoLog.e("TaoMaiWebChromeClient", th.getMessage());
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(@Nullable PermissionRequest permissionRequest) {
        String[] resources;
        if (permissionRequest == null || (resources = permissionRequest.getResources()) == null) {
            return;
        }
        for (String str : resources) {
            if (b41.d(str, com.uc.webview.export.PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                new AlertDialog.Builder(this.mContext).setTitle("当前页面申请使用你的摄像头").setPositiveButton("同意", new DialogInterface$OnClickListenerC7027b(permissionRequest)).setNegativeButton("拒绝", new DialogInterface$OnClickListenerC7028c(permissionRequest)).show();
                return;
            }
            if (b41.d(str, com.uc.webview.export.PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                new AlertDialog.Builder(this.mContext).setTitle("当前页面申请录音").setPositiveButton("同意", new DialogInterface$OnClickListenerC7029d(permissionRequest)).setNegativeButton("拒绝", new DialogInterface$OnClickListenerC7030e(permissionRequest)).show();
            } else {
                permissionRequest.deny();
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}
