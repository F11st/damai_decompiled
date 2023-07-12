package com.taomai.android.h5container.api;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVScreen;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/taomai/android/h5container/api/TMScreen;", "Landroid/taobao/windvane/jsbridge/api/WVScreen;", "", "action", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMScreen extends WVScreen {

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
            wVResult.addData("msg", "no permission");
            this.b.error(wVResult);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            TMScreen.this.capture(this.b, this.c);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            b41.i(strArr, "deniedPermissions");
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", "no permission");
            this.b.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.api.WVScreen, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@NotNull String str, @Nullable String str2, @NotNull WVCallBackContext wVCallBackContext) {
        b41.i(str, "action");
        b41.i(wVCallBackContext, WXBridgeManager.METHOD_CALLBACK);
        if (b41.d("capture", str)) {
            if (this.mContext != null) {
                Context context = getContext();
                b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
                new Permission(context, new PermissionModel(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, null, null, null)).a(new a(wVCallBackContext, str2)).b();
            }
        } else if (b41.d("getOrientation", str)) {
            getOrientation(wVCallBackContext, str2);
        } else if (!b41.d("setOrientation", str)) {
            return false;
        } else {
            setOrientation(wVCallBackContext, str2);
        }
        return true;
    }
}
