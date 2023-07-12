package com.taomai.android.h5container.api;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.jsbridge.api.WVImage;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/taomai/android/h5container/api/TMImage;", "Landroid/taobao/windvane/jsbridge/api/WVImage;", "", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "Ltb/wt2;", "saveImage", "action", "", "execute", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMImage extends WVImage {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a implements IPermissionListener {
        final /* synthetic */ WVCallBackContext b;
        final /* synthetic */ String c;

        a(WVCallBackContext wVCallBackContext, String str) {
            this.b = wVCallBackContext;
            this.c = str;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            b41.i(strArr, "permission");
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", com.alibaba.security.realidentity.jsbridge.a.al);
            WVCallBackContext wVCallBackContext = this.b;
            b41.f(wVCallBackContext);
            wVCallBackContext.error(wVResult);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            TMImage.this.saveImage(this.c, this.b);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            b41.i(strArr, "deniedPermissions");
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", com.alibaba.security.realidentity.jsbridge.a.al);
            WVCallBackContext wVCallBackContext = this.b;
            b41.f(wVCallBackContext);
            wVCallBackContext.error(wVResult);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b implements ImageTool.ImageSaveCallback {
        final /* synthetic */ WVCallBackContext a;

        b(WVCallBackContext wVCallBackContext) {
            this.a = wVCallBackContext;
        }

        @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
        public void error(@NotNull String str) {
            b41.i(str, "msg");
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", str);
            WVCallBackContext wVCallBackContext = this.a;
            if (wVCallBackContext != null) {
                wVCallBackContext.error(wVResult);
            }
        }

        @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
        public void success() {
            WVCallBackContext wVCallBackContext = this.a;
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveImage(String str, WVCallBackContext wVCallBackContext) {
        try {
            String optString = new JSONObject(str).optString("url", "");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ImageTool.saveImageToDCIM(this.mContext, optString, new b(wVCallBackContext));
        } catch (JSONException e) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", e.getMessage());
            if (wVCallBackContext != null) {
                wVCallBackContext.error(wVResult);
            }
        }
    }

    @Override // android.taobao.windvane.jsbridge.api.WVImage, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (TextUtils.equals(str, "saveImage")) {
            try {
                Context context = getContext();
                b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
                new Permission(context, new PermissionModel(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, null, null, null)).a(new a(wVCallBackContext, str2)).b();
                return true;
            } catch (Exception e) {
                TaoLog.d(WVAPI.PluginName.API_IMAGE, "Run whith some exception!");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
