package com.alibaba.pictures.share.qqshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gl2;
import tb.vf;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/share/qqshare/QQShareActivity;", "Landroid/app/Activity;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class QQShareActivity extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    private Tencent a;
    private boolean b;
    private ShareContent c;
    @NotNull
    private IUiListener d = new C3644a();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.qqshare.QQShareActivity$a */
    /* loaded from: classes8.dex */
    public static final class C3644a implements IUiListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3644a() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-405068635")) {
                ipChange.ipc$dispatch("-405068635", new Object[]{this});
                return;
            }
            vf.a(QQShareActivity.this.b ? ShareChannel.QZONE : ShareChannel.QQ, 1001);
            QQShareActivity.this.finish();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(@NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2132386462")) {
                ipChange.ipc$dispatch("-2132386462", new Object[]{this, obj});
                return;
            }
            b41.i(obj, "o");
            vf.b(QQShareActivity.this.b ? ShareChannel.QZONE : ShareChannel.QQ);
            QQShareActivity.this.finish();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(@NotNull UiError uiError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "31778133")) {
                ipChange.ipc$dispatch("31778133", new Object[]{this, uiError});
                return;
            }
            b41.i(uiError, "uiError");
            String str = uiError.errorMessage;
            b41.h(str, "uiError.errorMessage");
            ShareUtil.n(str);
            vf.a(QQShareActivity.this.b ? ShareChannel.QZONE : ShareChannel.QQ, uiError.errorCode);
            QQShareActivity.this.finish();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1581582540")) {
                ipChange.ipc$dispatch("-1581582540", new Object[]{this, Integer.valueOf(i)});
            } else {
                vf.a(QQShareActivity.this.b ? ShareChannel.QZONE : ShareChannel.QQ, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final Context context, ShareContent shareContent) {
        String title;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741849502")) {
            ipChange.ipc$dispatch("-1741849502", new Object[]{this, context, shareContent});
            return;
        }
        String str = null;
        if (TextUtils.isEmpty(shareContent != null ? shareContent.getTitle() : null)) {
            if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
                title = "";
            } else {
                if (shareContent != null) {
                    title = shareContent.getContent();
                }
                title = null;
            }
        } else {
            if (shareContent != null) {
                title = shareContent.getTitle();
            }
            title = null;
        }
        if (title != null && title.length() > 30) {
            title = title.substring(0, 29);
            b41.h(title, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
            str = "";
        } else if (shareContent != null) {
            str = shareContent.getContent();
        }
        if (str != null && str.length() > 40) {
            str = str.substring(0, 39);
            b41.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        String i = i(shareContent);
        if (TextUtils.isEmpty(i)) {
            finish();
        } else if (shareContent != null && shareContent.getShareType() == 1) {
            final Bundle bundle = new Bundle();
            bundle.putInt("req_type", 5);
            bundle.putString("imageLocalUrl", i);
            bundle.putString("appName", ShareManager.INSTANCE.b().d());
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQContactRequest$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
                    r0 = r4.this$0.a;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r4 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.share.qqshare.QQShareActivity$doQQContactRequest$3.$ipChange
                        java.lang.String r1 = "-649447830"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        if (r2 == 0) goto L14
                        r2 = 1
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r3 = 0
                        r2[r3] = r4
                        r0.ipc$dispatch(r1, r2)
                        return
                    L14:
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        boolean r0 = r0.isFinishing()
                        if (r0 != 0) goto L33
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.Tencent r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.c(r0)
                        if (r0 == 0) goto L33
                        android.content.Context r1 = r2
                        android.app.Activity r1 = (android.app.Activity) r1
                        android.os.Bundle r2 = r3
                        com.alibaba.pictures.share.qqshare.QQShareActivity r3 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.IUiListener r3 = r3.h()
                        r0.shareToQQ(r1, r2, r3)
                    L33:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQContactRequest$3.run():void");
                }
            });
        } else if ((shareContent == null || shareContent.getShareType() != 2) && (shareContent == null || shareContent.getShareType() != 3)) {
        } else {
            final Bundle bundle2 = new Bundle();
            bundle2.putInt("req_type", 1);
            bundle2.putString("title", title);
            bundle2.putString("appName", ShareManager.INSTANCE.b().d());
            bundle2.putString("summary", str);
            bundle2.putString("targetUrl", shareContent.getUrl());
            bundle2.putString("imageUrl", i);
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQContactRequest$4
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
                    r0 = r4.this$0.a;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r4 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.share.qqshare.QQShareActivity$doQQContactRequest$4.$ipChange
                        java.lang.String r1 = "-845961335"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        if (r2 == 0) goto L14
                        r2 = 1
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r3 = 0
                        r2[r3] = r4
                        r0.ipc$dispatch(r1, r2)
                        return
                    L14:
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        boolean r0 = r0.isFinishing()
                        if (r0 != 0) goto L33
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.Tencent r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.c(r0)
                        if (r0 == 0) goto L33
                        android.content.Context r1 = r2
                        android.app.Activity r1 = (android.app.Activity) r1
                        android.os.Bundle r2 = r3
                        com.alibaba.pictures.share.qqshare.QQShareActivity r3 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.IUiListener r3 = r3.h()
                        r0.shareToQQ(r1, r2, r3)
                    L33:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQContactRequest$4.run():void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final Context context, ShareContent shareContent) {
        String title;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1819291946")) {
            ipChange.ipc$dispatch("1819291946", new Object[]{this, context, shareContent});
            return;
        }
        if (TextUtils.isEmpty(shareContent != null ? shareContent.getTitle() : null)) {
            if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
                title = "";
            } else {
                if (shareContent != null) {
                    title = shareContent.getContent();
                }
                title = null;
            }
        } else {
            if (shareContent != null) {
                title = shareContent.getTitle();
            }
            title = null;
        }
        if (title != null && title.length() > 200) {
            title = title.substring(0, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
            b41.h(title, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        String content = TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null) ? "" : shareContent != null ? shareContent.getContent() : null;
        if (content != null && content.length() > 600) {
            content = content.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
            b41.h(content, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> imgUrls = shareContent != null ? shareContent.getImgUrls() : null;
        Objects.requireNonNull(imgUrls, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList2 = (ArrayList) imgUrls;
        if (shareContent.getShareType() == 1) {
            final Bundle bundle = new Bundle();
            bundle.putInt("req_type", 3);
            bundle.putString("summary", title);
            Bitmap e = ShareUtil.e(this, shareContent);
            String f = ShareUtil.f(this, e, true);
            ShareUtil.m(e);
            if (!((f == null || f.length() == 0) ? true : true)) {
                arrayList.add(f);
            }
            if (arrayList.isEmpty()) {
                finish();
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
                    r0 = r4.this$0.a;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r4 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$3.$ipChange
                        java.lang.String r1 = "1351926546"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        if (r2 == 0) goto L14
                        r2 = 1
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r3 = 0
                        r2[r3] = r4
                        r0.ipc$dispatch(r1, r2)
                        return
                    L14:
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        boolean r0 = r0.isFinishing()
                        if (r0 != 0) goto L33
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.Tencent r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.c(r0)
                        if (r0 == 0) goto L33
                        android.content.Context r1 = r2
                        android.app.Activity r1 = (android.app.Activity) r1
                        android.os.Bundle r2 = r3
                        com.alibaba.pictures.share.qqshare.QQShareActivity r3 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.IUiListener r3 = r3.h()
                        r0.publishToQzone(r1, r2, r3)
                    L33:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$3.run():void");
                }
            });
        } else if (shareContent.getShareType() != 2 && shareContent.getShareType() != 3) {
            final Bundle bundle2 = new Bundle();
            bundle2.putInt("req_type", 3);
            bundle2.putString("summary", title);
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$5
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
                    r0 = r4.this$0.a;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r4 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$5.$ipChange
                        java.lang.String r1 = "958899536"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        if (r2 == 0) goto L14
                        r2 = 1
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r3 = 0
                        r2[r3] = r4
                        r0.ipc$dispatch(r1, r2)
                        return
                    L14:
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        boolean r0 = r0.isFinishing()
                        if (r0 != 0) goto L33
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.Tencent r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.c(r0)
                        if (r0 == 0) goto L33
                        android.content.Context r1 = r2
                        android.app.Activity r1 = (android.app.Activity) r1
                        android.os.Bundle r2 = r3
                        com.alibaba.pictures.share.qqshare.QQShareActivity r3 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.IUiListener r3 = r3.h()
                        r0.publishToQzone(r1, r2, r3)
                    L33:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$5.run():void");
                }
            });
        } else {
            final Bundle bundle3 = new Bundle();
            bundle3.putInt("req_type", 1);
            bundle3.putString("title", title);
            bundle3.putString("summary", content);
            bundle3.putString("targetUrl", shareContent.getUrl());
            if (!arrayList.isEmpty()) {
                arrayList.addAll(arrayList);
            } else {
                Bitmap e2 = ShareUtil.e(this, shareContent);
                String f2 = ShareUtil.f(this, e2, true);
                ShareUtil.m(e2);
                if (!((f2 == null || f2.length() == 0) ? true : true)) {
                    arrayList.add(f2);
                }
            }
            bundle3.putStringArrayList("imageUrl", arrayList);
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$4
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
                    r0 = r4.this$0.a;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r4 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$4.$ipChange
                        java.lang.String r1 = "1155413041"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        if (r2 == 0) goto L14
                        r2 = 1
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r3 = 0
                        r2[r3] = r4
                        r0.ipc$dispatch(r1, r2)
                        return
                    L14:
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        boolean r0 = r0.isFinishing()
                        if (r0 != 0) goto L33
                        com.alibaba.pictures.share.qqshare.QQShareActivity r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.Tencent r0 = com.alibaba.pictures.share.qqshare.QQShareActivity.c(r0)
                        if (r0 == 0) goto L33
                        android.content.Context r1 = r2
                        android.app.Activity r1 = (android.app.Activity) r1
                        android.os.Bundle r2 = r3
                        com.alibaba.pictures.share.qqshare.QQShareActivity r3 = com.alibaba.pictures.share.qqshare.QQShareActivity.this
                        com.tencent.tauth.IUiListener r3 = r3.h()
                        r0.shareToQzone(r1, r2, r3)
                    L33:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.qqshare.QQShareActivity$doQQZoneRequest$4.run():void");
                }
            });
        }
    }

    private final String i(ShareContent shareContent) {
        boolean F;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1110849431")) {
            return (String) ipChange.ipc$dispatch("-1110849431", new Object[]{this, shareContent});
        }
        List<String> imgUrls = shareContent != null ? shareContent.getImgUrls() : null;
        Bitmap e = ShareUtil.e(this, shareContent);
        if ((imgUrls == null || imgUrls.isEmpty()) && e == null) {
            return null;
        }
        if (!(imgUrls == null || imgUrls.isEmpty()) && !TextUtils.equals(imgUrls.get(0), ShareManager.INSTANCE.b().h())) {
            if (shareContent.getShareType() != 2 && shareContent.getShareType() != 3) {
                if (shareContent.getShareType() == 1) {
                    F = C8604o.F(imgUrls.get(0), "http", false, 2, null);
                    if (!F) {
                        return imgUrls.get(0);
                    }
                }
            } else {
                return imgUrls.get(0);
            }
        }
        if (e != null) {
            return ShareUtil.g(this, e, false, 4, null);
        }
        return null;
    }

    @NotNull
    public final IUiListener h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-850618256") ? (IUiListener) ipChange.ipc$dispatch("-850618256", new Object[]{this}) : this.d;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129447588")) {
            ipChange.ipc$dispatch("-129447588", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            Tencent.onActivityResultData(i, i2, intent, this.d);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611060891")) {
            ipChange.ipc$dispatch("-611060891", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        ShareManager shareManager = ShareManager.INSTANCE;
        this.a = Tencent.createInstance(shareManager.b().p(), getApplicationContext(), shareManager.b().k());
        this.b = getIntent().getBooleanExtra("IsQQZone", false);
        Serializable serializableExtra = getIntent().getSerializableExtra("ShareParams");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.alibaba.pictures.share.common.share.ShareContent");
        this.c = (ShareContent) serializableExtra;
        Tencent.setIsPermissionGranted(true);
        if (this.b) {
            gl2.INSTANCE.b(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$onCreate$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    ShareContent shareContent;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1143812821")) {
                        ipChange2.ipc$dispatch("-1143812821", new Object[]{this});
                        return;
                    }
                    QQShareActivity qQShareActivity = QQShareActivity.this;
                    shareContent = qQShareActivity.c;
                    qQShareActivity.g(qQShareActivity, shareContent);
                }
            });
        } else {
            gl2.INSTANCE.b(new Runnable() { // from class: com.alibaba.pictures.share.qqshare.QQShareActivity$onCreate$2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    ShareContent shareContent;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1340326326")) {
                        ipChange2.ipc$dispatch("-1340326326", new Object[]{this});
                        return;
                    }
                    QQShareActivity qQShareActivity = QQShareActivity.this;
                    shareContent = qQShareActivity.c;
                    qQShareActivity.f(qQShareActivity, shareContent);
                }
            });
        }
    }
}
