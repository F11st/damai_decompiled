package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.pictures.share.qqshare.QQShareActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class cy1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.cy1$a */
    /* loaded from: classes8.dex */
    public static final class C9019a implements ShareManager.IApplyPermission.IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context b;
        final /* synthetic */ ShareContent c;
        final /* synthetic */ boolean d;

        C9019a(Context context, ShareContent shareContent, boolean z) {
            this.b = context;
            this.c = shareContent;
            this.d = z;
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionDenied() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1133673045")) {
                ipChange.ipc$dispatch("1133673045", new Object[]{this});
            } else {
                ShareUtil.n("保存图片异常，请授予存储权限");
            }
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1860480479")) {
                ipChange.ipc$dispatch("1860480479", new Object[]{this});
            } else {
                cy1.this.c(this.b, this.c, this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Context context, ShareContent shareContent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891447412")) {
            ipChange.ipc$dispatch("-891447412", new Object[]{this, context, shareContent, Boolean.valueOf(z)});
            return;
        }
        Intent intent = new Intent(context, QQShareActivity.class);
        intent.putExtra("IsQQZone", z);
        intent.putExtra("ShareParams", shareContent);
        context.startActivity(intent);
    }

    public final void b(@NotNull Context context, @Nullable ShareContent shareContent, boolean z, @Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532175337")) {
            ipChange.ipc$dispatch("-1532175337", new Object[]{this, context, shareContent, Boolean.valueOf(z), shareChannel});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (!b41.d(Environment.getExternalStorageState(), "mounted")) {
            ShareUtil.n("请插入外部SD存储卡，否则无法进行分享");
            if (z) {
                vf.a(ShareChannel.QZONE, 1003);
            } else {
                vf.a(ShareChannel.QQ, 1003);
            }
        } else if (e7.a("com.tencent.mobileqq")) {
            if (z) {
                c(context, shareContent, z);
                return;
            }
            ShareManager.IApplyPermission f = ShareManager.INSTANCE.b().f();
            if (f != null) {
                f.requestStoragePermission(new C9019a(context, shareContent, z), (Activity) context);
            }
        } else {
            String string = context.getString(R$string.qq_not_install);
            b41.h(string, "context.getString(R.string.qq_not_install)");
            ShareUtil.n(string);
            if (z) {
                vf.a(ShareChannel.QZONE, ShareException.APP_UNINSTALL);
            } else {
                vf.a(ShareChannel.QQ, ShareException.APP_UNINSTALL);
            }
        }
    }
}
