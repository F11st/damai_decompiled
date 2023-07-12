package com.taomai.android.h5container.api;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVLocation;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/taomai/android/h5container/api/TMLocation;", "Landroid/taobao/windvane/jsbridge/api/WVLocation;", "", "action", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "param", "Ltb/wt2;", "getLocation", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMLocation extends WVLocation {

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.api.TMLocation$a */
    /* loaded from: classes11.dex */
    public static final class C6988a implements IPermissionListener {
        final /* synthetic */ WVCallBackContext b;
        final /* synthetic */ String c;

        C6988a(WVCallBackContext wVCallBackContext, String str) {
            this.b = wVCallBackContext;
            this.c = str;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            b41.i(strArr, "permission");
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", "no permission");
            WVCallBackContext wVCallBackContext = this.b;
            b41.f(wVCallBackContext);
            wVCallBackContext.error(wVResult);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            TMLocation.this.requestLocation(this.b, this.c);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            b41.i(strArr, "deniedPermissions");
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", "no permission");
            WVCallBackContext wVCallBackContext = this.b;
            b41.f(wVCallBackContext);
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.api.WVLocation, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        return super.execute(str, str2, wVCallBackContext);
    }

    @Override // android.taobao.windvane.jsbridge.api.WVLocation
    public synchronized void getLocation(@Nullable WVCallBackContext wVCallBackContext, @Nullable String str) {
        try {
            Context context = getContext();
            b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
            new Permission(context, new PermissionModel(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, null, null, null)).a(new C6988a(wVCallBackContext, str)).b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
