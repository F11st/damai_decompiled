package com.taomai.android.h5container.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.view.PopupWindowController;
import android.view.View;
import android.widget.Toast;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.taomai.android.h5container.utils.ImageTool;
import com.uc.webview.export.WebView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.yk2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class WebViewLongClickHandler {
    private boolean a;
    private String b;
    private PopupWindowController c;
    private final String[] d;
    private final View.OnClickListener e;
    private final WVUCWebView f;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a implements View.OnLongClickListener {
        final /* synthetic */ Context b;

        a(Context context) {
            this.b = context;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@Nullable View view) {
            WebView.HitTestResult hitTestResult;
            try {
                hitTestResult = WebViewLongClickHandler.this.f.getHitTestResult();
            } catch (Exception e) {
                TaoLog.e("WVUCWebView", "getHitTestResult error:" + e.getMessage());
                hitTestResult = null;
            }
            if (hitTestResult == null || !WebViewLongClickHandler.this.j()) {
                return false;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVUCWebView", "Long click on WebView, " + hitTestResult.getExtra());
            }
            if (hitTestResult.getType() == 8 || hitTestResult.getType() == 5) {
                WebViewLongClickHandler.this.b = hitTestResult.getExtra();
                WebViewLongClickHandler webViewLongClickHandler = WebViewLongClickHandler.this;
                webViewLongClickHandler.c = new PopupWindowController(this.b, webViewLongClickHandler.f, WebViewLongClickHandler.this.d, WebViewLongClickHandler.this.e);
                PopupWindowController popupWindowController = WebViewLongClickHandler.this.c;
                b41.f(popupWindowController);
                popupWindowController.show();
                return true;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static final class b implements View.OnClickListener {

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public static final class a implements IPermissionListener {
            final /* synthetic */ Context b;

            a(Context context) {
                this.b = context;
            }

            @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
            public void onPermissionDenied(@NotNull String[] strArr) {
                b41.i(strArr, "permission");
                WebViewLongClickHandler.this.n();
            }

            @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
            public void onPermissionGranted() {
                Context context = this.b;
                if (context == null) {
                    return;
                }
                WebViewLongClickHandler.this.m(context);
            }

            @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
            public void onShowRationale(@NotNull String[] strArr) {
                b41.i(strArr, "deniedPermissions");
                WebViewLongClickHandler.this.n();
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!(WebViewLongClickHandler.this.d.length == 0)) {
                String str = WebViewLongClickHandler.this.d[0];
                b41.h(view, "v");
                if (b41.d(str, view.getTag())) {
                    try {
                        Context _getContext = WebViewLongClickHandler.this.f._getContext();
                        b41.h(_getContext, WPKFactory.INIT_KEY_CONTEXT);
                        new Permission(_getContext, new PermissionModel(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, null, null, null)).a(new a(_getContext)).b();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            PopupWindowController popupWindowController = WebViewLongClickHandler.this.c;
            if (popupWindowController != null) {
                popupWindowController.hide();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class c implements ImageTool.ImageSaveCallback {
        c() {
        }

        @Override // com.taomai.android.h5container.utils.ImageTool.ImageSaveCallback
        public void error(@Nullable String str) {
            WebViewLongClickHandler.this.n();
        }

        @Override // com.taomai.android.h5container.utils.ImageTool.ImageSaveCallback
        public void success() {
            WebViewLongClickHandler.this.o();
        }
    }

    public WebViewLongClickHandler(@NotNull WVUCWebView wVUCWebView) {
        b41.i(wVUCWebView, "webView");
        this.f = wVUCWebView;
        this.a = true;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.d = strArr;
        this.e = new b();
    }

    private final void l(Runnable runnable) {
        try {
            if (b41.d(Looper.getMainLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Context context) {
        ImageTool.i(context.getApplicationContext(), this.b, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        l(new Runnable() { // from class: com.taomai.android.h5container.utils.WebViewLongClickHandler$toastSaveFail$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Toast.makeText(yk2.a, EnvUtil.isCN() ? "图片保存到相册失败" : "Failed to save picture", 1).show();
                } catch (Exception e) {
                    TaoLog.e("WVUCWebView", "NOTIFY_SAVE_IMAGE_FAIL fail " + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        l(new Runnable() { // from class: com.taomai.android.h5container.utils.WebViewLongClickHandler$toastSaveSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Toast.makeText(yk2.a, EnvUtil.isCN() ? "图片保存到相册成功" : "Success to save picture", 1).show();
                } catch (Exception e) {
                    TaoLog.e("WVUCWebView", "NOTIFY_SAVE_IMAGE_SUCCESS fail " + e.getMessage());
                }
            }
        });
    }

    public final boolean j() {
        return this.a;
    }

    public final void k() {
        Context _getContext = this.f._getContext();
        if (_getContext != null) {
            this.f.setOnLongClickListener(new a(_getContext));
        }
    }
}
