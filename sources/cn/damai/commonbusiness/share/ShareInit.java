package cn.damai.commonbusiness.share;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import com.alibaba.pictures.moimage.DownloadImgListener;
import com.alibaba.pictures.moimage.MoImageDownloader;
import com.alibaba.pictures.moimage.MoImageLoadException;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gr1;
import tb.kr1;
import tb.mm2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ShareInit {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ShareInit INSTANCE = new ShareInit();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.ShareInit$a */
    /* loaded from: classes.dex */
    public static final class C0873a implements DownloadImgListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShareManager.IDownloadImage.IDownloadListener a;

        C0873a(ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
            this.a = iDownloadListener;
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        /* renamed from: a */
        public void onDownloaded(@Nullable String str, @NotNull Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1067889563")) {
                ipChange.ipc$dispatch("1067889563", new Object[]{this, str, bitmap});
                return;
            }
            b41.i(bitmap, "source");
            this.a.onSuccess(bitmap);
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        public void onFail(@NotNull MoImageLoadException moImageLoadException, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1234604314")) {
                ipChange.ipc$dispatch("1234604314", new Object[]{this, moImageLoadException, str});
                return;
            }
            b41.i(moImageLoadException, "exception");
            this.a.onFailed();
        }
    }

    private ShareInit() {
    }

    public final void a(@Nullable String str, @NotNull ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298826117")) {
            ipChange.ipc$dispatch("298826117", new Object[]{this, str, iDownloadListener});
            return;
        }
        b41.i(iDownloadListener, "iDownloadListener");
        MoImageDownloader.g(MoImageDownloader.Companion.a(), str, null, null, 6, null).c(new C0873a(iDownloadListener));
    }

    public final void b(@NotNull final Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909395100")) {
            ipChange.ipc$dispatch("1909395100", new Object[]{this, application});
            return;
        }
        b41.i(application, "application");
        com.alibaba.pictures.share.ShareManager.INSTANCE.d(application, new Function1<ShareManager.C3629a, wt2>() { // from class: cn.damai.commonbusiness.share.ShareInit$init$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$a */
            /* loaded from: classes.dex */
            public static final class C0874a implements ShareManager.IApplyPermission {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ Application a;

                /* compiled from: Taobao */
                /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$a$a */
                /* loaded from: classes.dex */
                public static final class C0875a implements IPermissionListener {
                    private static transient /* synthetic */ IpChange $ipChange;
                    final /* synthetic */ ShareManager.IApplyPermission.IPermissionListener a;
                    final /* synthetic */ Activity b;

                    C0875a(ShareManager.IApplyPermission.IPermissionListener iPermissionListener, Activity activity) {
                        this.a = iPermissionListener;
                        this.b = activity;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void c(Activity activity, DialogInterface dialogInterface, int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1738337069")) {
                            ipChange.ipc$dispatch("1738337069", new Object[]{activity, dialogInterface, Integer.valueOf(i)});
                            return;
                        }
                        dialogInterface.dismiss();
                        kr1.f(activity);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void d(DialogInterface dialogInterface, int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1123071866")) {
                            ipChange.ipc$dispatch("1123071866", new Object[]{dialogInterface, Integer.valueOf(i)});
                        } else {
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
                    public void onPermissionDenied(@NotNull String[] strArr) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-831646505")) {
                            ipChange.ipc$dispatch("-831646505", new Object[]{this, strArr});
                            return;
                        }
                        b41.i(strArr, "permission");
                        this.a.onPermissionDenied();
                    }

                    @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
                    public void onPermissionGranted() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1906944844")) {
                            ipChange.ipc$dispatch("1906944844", new Object[]{this});
                        } else {
                            this.a.onPermissionGranted();
                        }
                    }

                    @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
                    public void onShowRationale(@NotNull String[] strArr) {
                        List g0;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1998028063")) {
                            ipChange.ipc$dispatch("-1998028063", new Object[]{this, strArr});
                            return;
                        }
                        b41.i(strArr, "deniedPermissions");
                        Activity activity = this.b;
                        if (activity == null) {
                            return;
                        }
                        g0 = ArraysKt___ArraysKt.g0(strArr);
                        final Activity activity2 = this.b;
                        gr1.a(activity, "授权获取存储权限，用于为您保存图片至本地", g0, false, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE  
                              (r1v1 'activity' android.app.Activity)
                              ("￦ﾎﾈ￦ﾝﾃ￨ﾎﾷ￥ﾏﾖ￥ﾭﾘ￥ﾂﾨ￦ﾝﾃ￩ﾙﾐ￯ﾼﾌ￧ﾔﾨ￤ﾺﾎ￤ﾸﾺ￦ﾂﾨ￤﾿ﾝ￥ﾭﾘ￥ﾛﾾ￧ﾉﾇ￨ﾇﾳ￦ﾜﾬ￥ﾜﾰ")
                              (r3v0 'g0' java.util.List)
                              false
                              (wrap: android.content.DialogInterface$OnClickListener : 0x002a: CONSTRUCTOR  (r5v0 android.content.DialogInterface$OnClickListener A[REMOVE]) = (r8v1 'activity2' android.app.Activity A[DONT_INLINE]) call: tb.qb2.<init>(android.app.Activity):void type: CONSTRUCTOR)
                              (wrap: tb.rb2 : 0x002d: SGET  (r6v0 tb.rb2 A[REMOVE]) =  tb.rb2.a tb.rb2)
                             type: STATIC call: tb.gr1.a(android.content.Context, java.lang.CharSequence, java.util.List, boolean, android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnClickListener):void in method: cn.damai.commonbusiness.share.ShareInit.init.1.a.a.onShowRationale(java.lang.String[]):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:272)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: tb.qb2, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 23 more
                            */
                        /*
                            this = this;
                            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.share.ShareInit$init$1.C0874a.C0875a.$ipChange
                            java.lang.String r1 = "-1998028063"
                            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                            if (r2 == 0) goto L17
                            r2 = 2
                            java.lang.Object[] r2 = new java.lang.Object[r2]
                            r3 = 0
                            r2[r3] = r7
                            r3 = 1
                            r2[r3] = r8
                            r0.ipc$dispatch(r1, r2)
                            return
                        L17:
                            java.lang.String r0 = "deniedPermissions"
                            tb.b41.i(r8, r0)
                            android.app.Activity r1 = r7.b
                            if (r1 != 0) goto L21
                            return
                        L21:
                            java.util.List r3 = kotlin.collections.C8202e.g0(r8)
                            r4 = 0
                            android.app.Activity r8 = r7.b
                            tb.qb2 r5 = new tb.qb2
                            r5.<init>(r8)
                            tb.rb2 r6 = tb.rb2.a
                            java.lang.String r2 = "授权获取存储权限，用于为您保存图片至本地"
                            tb.gr1.a(r1, r2, r3, r4, r5, r6)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.share.ShareInit$init$1.C0874a.C0875a.onShowRationale(java.lang.String[]):void");
                    }
                }

                C0874a(Application application) {
                    this.a = application;
                }

                @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission
                public void requestStoragePermission(@NotNull ShareManager.IApplyPermission.IPermissionListener iPermissionListener, @Nullable Activity activity) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "819346954")) {
                        ipChange.ipc$dispatch("819346954", new Object[]{this, iPermissionListener, activity});
                        return;
                    }
                    b41.i(iPermissionListener, "iPermissionListener");
                    PermissionModel permissionModel = new PermissionModel(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, "存储权限说明", Integer.valueOf(R$drawable.permission_store_pic), "授权获取存储权限，用于为您保存图片至本地");
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(permissionModel);
                    new Permission(this.a, linkedList).a(new C0875a(iPermissionListener, activity)).b();
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$b */
            /* loaded from: classes.dex */
            public static final class C0876b implements ShareManager.IShareMenu {
                private static transient /* synthetic */ IpChange $ipChange;

                C0876b() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IShareMenu
                public void share(@NotNull ShareManager.IShareMenu.IShareListener iShareListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "47314584")) {
                        ipChange.ipc$dispatch("47314584", new Object[]{this, iShareListener});
                    } else {
                        b41.i(iShareListener, "iReportListener");
                    }
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$c */
            /* loaded from: classes.dex */
            public static final class C0877c implements ShareManager.IOrangeConfig {
                private static transient /* synthetic */ IpChange $ipChange;

                C0877c() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IOrangeConfig
                @NotNull
                public String getShareChannelConfig() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "-1929682047") ? (String) ipChange.ipc$dispatch("-1929682047", new Object[]{this}) : "12654";
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$d */
            /* loaded from: classes.dex */
            public static final class C0878d implements ShareManager.IReport {
                private static transient /* synthetic */ IpChange $ipChange;

                C0878d() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IReport
                public void report(int i, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull ShareManager.IReport.IReportListener iReportListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-317057432")) {
                        ipChange.ipc$dispatch("-317057432", new Object[]{this, Integer.valueOf(i), str, str2, num, iReportListener});
                        return;
                    }
                    b41.i(str, "reason");
                    b41.i(iReportListener, "iReportListener");
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$e */
            /* loaded from: classes.dex */
            public static final class C0879e implements ShareManager.IShareMonitor {
                private static transient /* synthetic */ IpChange $ipChange;

                C0879e() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IShareMonitor
                public void shareResult(@NotNull ShareChannel shareChannel, int i, @Nullable String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1295741072")) {
                        ipChange.ipc$dispatch("-1295741072", new Object[]{this, shareChannel, Integer.valueOf(i), str});
                    } else {
                        b41.i(shareChannel, "shareChannel");
                    }
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$f */
            /* loaded from: classes.dex */
            public static final class C0880f implements ShareManager.IToast {
                private static transient /* synthetic */ IpChange $ipChange;

                C0880f() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IToast
                public void showToast(@Nullable String str, boolean z) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "118139740")) {
                        ipChange.ipc$dispatch("118139740", new Object[]{this, str, Boolean.valueOf(z)});
                    } else if (str != null) {
                        ToastUtil.i(str);
                    }
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$g */
            /* loaded from: classes.dex */
            public static final class C0881g implements ShareManager.IDogCat {
                private static transient /* synthetic */ IpChange $ipChange;

                C0881g() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDogCat
                public void click(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1786134386")) {
                        ipChange.ipc$dispatch("-1786134386", new Object[]{this, view, str, str2, map});
                        return;
                    }
                    b41.i(view, "view");
                    b41.i(str, "ctrlName");
                    b41.i(str2, "spm");
                    b41.i(map, "args");
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDogCat
                public void click(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1077934498")) {
                        ipChange.ipc$dispatch("1077934498", new Object[]{this, str, str2, map});
                        return;
                    }
                    b41.i(str, "ctrlName");
                    b41.i(str2, "spm");
                    b41.i(map, "args");
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDogCat
                public void custom(@NotNull String str, @NotNull Map<String, String> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1328411879")) {
                        ipChange.ipc$dispatch("-1328411879", new Object[]{this, str, map});
                        return;
                    }
                    b41.i(str, "eventName");
                    b41.i(map, "args");
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDogCat
                public void expose(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "951093006")) {
                        ipChange.ipc$dispatch("951093006", new Object[]{this, view, str, str2, map});
                        return;
                    }
                    b41.i(view, "view");
                    b41.i(str, "ctrlName");
                    b41.i(str2, "spm");
                    b41.i(map, "args");
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDogCat
                public void expose(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1456094430")) {
                        ipChange.ipc$dispatch("-1456094430", new Object[]{this, str, str2, map});
                        return;
                    }
                    b41.i(str, "ctrlName");
                    b41.i(str2, "spm");
                    b41.i(map, "args");
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$h */
            /* loaded from: classes.dex */
            public static final class C0882h implements ShareManager.IDownloadImage {
                private static transient /* synthetic */ IpChange $ipChange;

                C0882h() {
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage
                public void download(@Nullable String str, @NotNull ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1645296653")) {
                        ipChange.ipc$dispatch("1645296653", new Object[]{this, str, iDownloadListener});
                        return;
                    }
                    b41.i(iDownloadListener, "iDownloadListener");
                    ShareInit.INSTANCE.a(str, iDownloadListener);
                }

                @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage
                public void download(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @NotNull ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1794063827")) {
                        ipChange.ipc$dispatch("-1794063827", new Object[]{this, str, num, num2, iDownloadListener});
                        return;
                    }
                    b41.i(iDownloadListener, "iDownloadListener");
                    ShareInit.INSTANCE.a(str, iDownloadListener);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(ShareManager.C3629a c3629a) {
                invoke2(c3629a);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShareManager.C3629a c3629a) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "903527688")) {
                    ipChange2.ipc$dispatch("903527688", new Object[]{this, c3629a});
                    return;
                }
                b41.i(c3629a, "$this$init");
                c3629a.D(2);
                c3629a.C("大麦");
                c3629a.B(Integer.valueOf(R$drawable.damai_small_logo));
                c3629a.G(AppConfig.v());
                c3629a.F(mm2.c().a());
                String h = mm2.c().h();
                if (h == null) {
                    h = "";
                }
                c3629a.Q(h);
                c3629a.R(mm2.d);
                String f = mm2.c().f();
                if (f == null) {
                    f = "";
                }
                c3629a.M(f);
                String k = mm2.c().k();
                c3629a.S(k != null ? k : "");
                c3629a.T("/pages/home/index?url=");
                c3629a.A("2015092200310865");
                c3629a.I(application.getPackageName() + ".interactProvider");
                c3629a.E(new C0874a(application));
                c3629a.O(new C0876b());
                c3629a.L(new C0877c());
                c3629a.N(new C0878d());
                c3629a.P(new C0879e());
                c3629a.K(new C0880f());
                c3629a.J(new C0881g());
                c3629a.H(new C0882h());
            }
        });
    }
}
