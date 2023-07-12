package com.alibaba.pictures.share;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.aliweex.adapter.module.WXUserTrackModule;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.taobao.login4android.constants.LoginConstants;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.sb2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ShareManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private static Application a;
    @Nullable
    private static IWBAPI c;
    @NotNull
    public static final ShareManager INSTANCE = new ShareManager();
    @NotNull
    private static C3629a b = new C3629a();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$EnvModeEnum;", "", "", "envMode", "I", "getEnvMode", "()I", "<init>", "(Ljava/lang/String;II)V", "ONLINE", "PREPARE", "TEST", "TEST_SANDBOX", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public enum EnvModeEnum {
        ONLINE(0),
        PREPARE(1),
        TEST(2),
        TEST_SANDBOX(3);
        
        private final int envMode;

        EnvModeEnum(int i) {
            this.envMode = i;
        }

        public final int getEnvMode() {
            return this.envMode;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IApplyPermission;", "", "Lcom/alibaba/pictures/share/ShareManager$IApplyPermission$IPermissionListener;", "iPermissionListener", "Landroid/app/Activity;", "activity", "Ltb/wt2;", "requestStoragePermission", "IPermissionListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IApplyPermission {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IApplyPermission$IPermissionListener;", "", "Ltb/wt2;", "onPermissionGranted", "onPermissionDenied", "share_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes8.dex */
        public interface IPermissionListener {
            void onPermissionDenied();

            void onPermissionGranted();
        }

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.pictures.share.ShareManager$IApplyPermission$a */
        /* loaded from: classes8.dex */
        public static final class C3628a {
            public static /* synthetic */ void a(IApplyPermission iApplyPermission, IPermissionListener iPermissionListener, Activity activity, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        activity = null;
                    }
                    iApplyPermission.requestStoragePermission(iPermissionListener, activity);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestStoragePermission");
            }
        }

        void requestStoragePermission(@NotNull IPermissionListener iPermissionListener, @Nullable Activity activity);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\t\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IBitmapManager;", "", "", "url", "Landroid/graphics/Bitmap;", "bitmap", "Ltb/wt2;", "saveBitmap", "getBitmap", Constants.TAG_CLEAR_STRING, "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IBitmapManager {
        void clear();

        @Nullable
        Bitmap getBitmap(@Nullable String str);

        void saveBitmap(@Nullable String str, @Nullable Bitmap bitmap);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J8\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J8\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J&\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IDogCat;", "", "", "ctrlName", "spm", "", "args", "Ltb/wt2;", "click", "Landroid/view/View;", "view", WXUserTrackModule.EXPOSE, "eventName", "custom", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IDogCat {
        void click(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

        void click(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

        void custom(@NotNull String str, @NotNull Map<String, String> map);

        void expose(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

        void expose(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J5\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IDownloadImage;", "", "", "url", "Lcom/alibaba/pictures/share/ShareManager$IDownloadImage$IDownloadListener;", "iDownloadListener", "Ltb/wt2;", "download", "", "width", "height", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/alibaba/pictures/share/ShareManager$IDownloadImage$IDownloadListener;)V", "IDownloadListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IDownloadImage {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IDownloadImage$IDownloadListener;", "", "Landroid/graphics/Bitmap;", "bitmap", "Ltb/wt2;", "onSuccess", "onFailed", "share_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes8.dex */
        public interface IDownloadListener {
            void onFailed();

            void onSuccess(@Nullable Bitmap bitmap);
        }

        void download(@Nullable String str, @NotNull IDownloadListener iDownloadListener);

        void download(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @NotNull IDownloadListener iDownloadListener);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IOrangeConfig;", "", "", "getShareChannelConfig", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IOrangeConfig {
        @NotNull
        String getShareChannelConfig();
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\rJ?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IReport;", "", "", "index", "", "reason", "targetId", "targetType", "Lcom/alibaba/pictures/share/ShareManager$IReport$IReportListener;", "iReportListener", "Ltb/wt2;", "report", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/alibaba/pictures/share/ShareManager$IReport$IReportListener;)V", "IReportListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IReport {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IReport$IReportListener;", "", "Ltb/wt2;", "onSuccess", "onFailed", "share_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes8.dex */
        public interface IReportListener {
            void onFailed();

            void onSuccess();
        }

        void report(int i, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull IReportListener iReportListener);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareInit;", "", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IShareInit {
        void init();
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareMenu;", "", "Lcom/alibaba/pictures/share/ShareManager$IShareMenu$IShareListener;", "iReportListener", "Ltb/wt2;", "share", "IShareListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IShareMenu {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareMenu$IShareListener;", "", "Ltb/wt2;", "onSuccess", "onException", "share_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes8.dex */
        public interface IShareListener {
            void onException();

            void onSuccess();
        }

        void share(@NotNull IShareListener iShareListener);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareMonitor;", "", "Lcom/alibaba/pictures/share/common/share/ShareChannel;", "shareChannel", "", "status", "", "msg", "Ltb/wt2;", "shareResult", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IShareMonitor {
        void shareResult(@NotNull ShareChannel shareChannel, int i, @Nullable String str);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IToast;", "", "", "msg", "", "isLongTime", "Ltb/wt2;", LoginConstants.SHOW_TOAST, "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IToast {
        void showToast(@Nullable String str, boolean z);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.ShareManager$a */
    /* loaded from: classes8.dex */
    public static final class C3629a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String A;
        private boolean b;
        @Nullable
        private Integer d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private String g;
        @Nullable
        private String h;
        @Nullable
        private String n;
        @Nullable
        private IApplyPermission p;
        @Nullable
        private IShareMenu q;
        @Nullable
        private IReport r;
        @Nullable
        private IDownloadImage s;
        @Nullable
        private IOrangeConfig t;
        @Nullable
        private IShareMonitor u;
        @Nullable
        private IToast v;
        @Nullable
        private IDogCat w;
        @Nullable
        private String x;
        @Nullable
        private IBitmapManager y;
        private int a = 1;
        @NotNull
        private EnvModeEnum c = EnvModeEnum.ONLINE;
        @Nullable
        private String i = "";
        @Nullable
        private String j = "";
        @Nullable
        private String k = "";
        @Nullable
        private String l = "";
        @Nullable
        private String m = "";
        @Nullable
        private String o = "";
        private float z = 0.8f;

        public final void A(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371907778")) {
                ipChange.ipc$dispatch("-1371907778", new Object[]{this, str});
            } else {
                this.o = str;
            }
        }

        public final void B(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2037195820")) {
                ipChange.ipc$dispatch("2037195820", new Object[]{this, num});
            } else {
                this.d = num;
            }
        }

        public final void C(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1878681796")) {
                ipChange.ipc$dispatch("1878681796", new Object[]{this, str});
            } else {
                this.f = str;
            }
        }

        public final void D(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1244799496")) {
                ipChange.ipc$dispatch("-1244799496", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.a = i;
            }
        }

        public final void E(@Nullable IApplyPermission iApplyPermission) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-350815369")) {
                ipChange.ipc$dispatch("-350815369", new Object[]{this, iApplyPermission});
            } else {
                this.p = iApplyPermission;
            }
        }

        public final void F(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-108356047")) {
                ipChange.ipc$dispatch("-108356047", new Object[]{this, str});
            } else {
                this.g = str;
            }
        }

        public final void G(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "317491937")) {
                ipChange.ipc$dispatch("317491937", new Object[]{this, Boolean.valueOf(z)});
            } else {
                this.b = z;
            }
        }

        public final void H(@Nullable IDownloadImage iDownloadImage) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2033050229")) {
                ipChange.ipc$dispatch("-2033050229", new Object[]{this, iDownloadImage});
            } else {
                this.s = iDownloadImage;
            }
        }

        public final void I(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1800358746")) {
                ipChange.ipc$dispatch("1800358746", new Object[]{this, str});
            } else {
                this.A = str;
            }
        }

        public final void J(@Nullable IDogCat iDogCat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1968881480")) {
                ipChange.ipc$dispatch("1968881480", new Object[]{this, iDogCat});
            } else {
                this.w = iDogCat;
            }
        }

        public final void K(@Nullable IToast iToast) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1584103978")) {
                ipChange.ipc$dispatch("1584103978", new Object[]{this, iToast});
            } else {
                this.v = iToast;
            }
        }

        public final void L(@Nullable IOrangeConfig iOrangeConfig) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "976161601")) {
                ipChange.ipc$dispatch("976161601", new Object[]{this, iOrangeConfig});
            } else {
                this.t = iOrangeConfig;
            }
        }

        public final void M(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1132986828")) {
                ipChange.ipc$dispatch("-1132986828", new Object[]{this, str});
            } else {
                this.l = str;
            }
        }

        public final void N(@Nullable IReport iReport) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-415622591")) {
                ipChange.ipc$dispatch("-415622591", new Object[]{this, iReport});
            } else {
                this.r = iReport;
            }
        }

        public final void O(@Nullable IShareMenu iShareMenu) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-800782219")) {
                ipChange.ipc$dispatch("-800782219", new Object[]{this, iShareMenu});
            } else {
                this.q = iShareMenu;
            }
        }

        public final void P(@Nullable IShareMonitor iShareMonitor) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1242733663")) {
                ipChange.ipc$dispatch("-1242733663", new Object[]{this, iShareMonitor});
            } else {
                this.u = iShareMonitor;
            }
        }

        public final void Q(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "94252831")) {
                ipChange.ipc$dispatch("94252831", new Object[]{this, str});
            } else {
                this.i = str;
            }
        }

        public final void R(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1900639656")) {
                ipChange.ipc$dispatch("1900639656", new Object[]{this, str});
            } else {
                this.j = str;
            }
        }

        public final void S(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-225075275")) {
                ipChange.ipc$dispatch("-225075275", new Object[]{this, str});
            } else {
                this.m = str;
            }
        }

        public final void T(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1146124847")) {
                ipChange.ipc$dispatch("-1146124847", new Object[]{this, str});
            } else {
                this.n = str;
            }
        }

        @Nullable
        public final String a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2048273096") ? (String) ipChange.ipc$dispatch("-2048273096", new Object[]{this}) : this.o;
        }

        public final float b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "449304256") ? ((Float) ipChange.ipc$dispatch("449304256", new Object[]{this})).floatValue() : this.z;
        }

        @Nullable
        public final Integer c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "47067998") ? (Integer) ipChange.ipc$dispatch("47067998", new Object[]{this}) : this.d;
        }

        @Nullable
        public final String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-718544142") ? (String) ipChange.ipc$dispatch("-718544142", new Object[]{this}) : this.f;
        }

        public final int e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1645570990") ? ((Integer) ipChange.ipc$dispatch("-1645570990", new Object[]{this})).intValue() : this.a;
        }

        @Nullable
        public final IApplyPermission f() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "177071015") ? (IApplyPermission) ipChange.ipc$dispatch("177071015", new Object[]{this}) : this.p;
        }

        @Nullable
        public final String g() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2094540211") ? (String) ipChange.ipc$dispatch("-2094540211", new Object[]{this}) : this.g;
        }

        @Nullable
        public final String h() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "880699086") ? (String) ipChange.ipc$dispatch("880699086", new Object[]{this}) : this.x;
        }

        @Nullable
        public final IDownloadImage i() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1204684775") ? (IDownloadImage) ipChange.ipc$dispatch("1204684775", new Object[]{this}) : this.s;
        }

        @NotNull
        public final EnvModeEnum j() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1127805751") ? (EnvModeEnum) ipChange.ipc$dispatch("1127805751", new Object[]{this}) : this.c;
        }

        @Nullable
        public final String k() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1173852004") ? (String) ipChange.ipc$dispatch("-1173852004", new Object[]{this}) : this.A;
        }

        @Nullable
        public final IBitmapManager l() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "237710216") ? (IBitmapManager) ipChange.ipc$dispatch("237710216", new Object[]{this}) : this.y;
        }

        @Nullable
        public final IDogCat m() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-56344302") ? (IDogCat) ipChange.ipc$dispatch("-56344302", new Object[]{this}) : this.w;
        }

        @Nullable
        public final IToast n() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1953563800") ? (IToast) ipChange.ipc$dispatch("-1953563800", new Object[]{this}) : this.v;
        }

        @Nullable
        public final IOrangeConfig o() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2077826149") ? (IOrangeConfig) ipChange.ipc$dispatch("2077826149", new Object[]{this}) : this.t;
        }

        @Nullable
        public final String p() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "15589250") ? (String) ipChange.ipc$dispatch("15589250", new Object[]{this}) : this.l;
        }

        @Nullable
        public final IReport q() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-592480803") ? (IReport) ipChange.ipc$dispatch("-592480803", new Object[]{this}) : this.r;
        }

        @Nullable
        public final IShareMonitor r() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "838603087") ? (IShareMonitor) ipChange.ipc$dispatch("838603087", new Object[]{this}) : this.u;
        }

        @Nullable
        public final String s() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1025008951") ? (String) ipChange.ipc$dispatch("1025008951", new Object[]{this}) : this.i;
        }

        @Nullable
        public final String t() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-432598898") ? (String) ipChange.ipc$dispatch("-432598898", new Object[]{this}) : this.j;
        }

        @Nullable
        public final String u() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-47163281") ? (String) ipChange.ipc$dispatch("-47163281", new Object[]{this}) : this.k;
        }

        @Nullable
        public final String v() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1645137762") ? (String) ipChange.ipc$dispatch("1645137762", new Object[]{this}) : this.e;
        }

        @Nullable
        public final String w() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1707444705") ? (String) ipChange.ipc$dispatch("1707444705", new Object[]{this}) : this.m;
        }

        @Nullable
        public final String x() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1492931667") ? (String) ipChange.ipc$dispatch("-1492931667", new Object[]{this}) : this.n;
        }

        @Nullable
        public final String y() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1441538941") ? (String) ipChange.ipc$dispatch("1441538941", new Object[]{this}) : this.h;
        }

        public final boolean z() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2114738655") ? ((Boolean) ipChange.ipc$dispatch("-2114738655", new Object[]{this})).booleanValue() : this.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.ShareManager$b */
    /* loaded from: classes8.dex */
    public static final class C3630b implements SdkListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3630b() {
        }

        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitFailure(@NotNull Exception exc) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-951341549")) {
                ipChange.ipc$dispatch("-951341549", new Object[]{this, exc});
                return;
            }
            b41.i(exc, "e");
            sb2.e(null, "SDK初始化失败回调" + exc, 1, null);
        }

        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-17877702")) {
                ipChange.ipc$dispatch("-17877702", new Object[]{this});
            } else {
                sb2.e(null, "DK初始化成功回调", 1, null);
            }
        }
    }

    private ShareManager() {
    }

    @Nullable
    public final Application a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "333999721") ? (Application) ipChange.ipc$dispatch("333999721", new Object[]{this}) : a;
    }

    @NotNull
    public final C3629a b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1355317784") ? (C3629a) ipChange.ipc$dispatch("1355317784", new Object[]{this}) : b;
    }

    @Nullable
    public final IWBAPI c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "184449590") ? (IWBAPI) ipChange.ipc$dispatch("184449590", new Object[]{this}) : c;
    }

    public final void d(@NotNull Application application, @NotNull Function1<? super C3629a, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460235393")) {
            ipChange.ipc$dispatch("460235393", new Object[]{this, application, function1});
            return;
        }
        b41.i(application, "application");
        b41.i(function1, "configBlock");
        a = application;
        C3629a c3629a = b;
        function1.invoke(c3629a);
        b = c3629a;
        e(application);
        sb2.e(null, "ShareManager init", 1, null);
    }

    public final void e(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645467448")) {
            ipChange.ipc$dispatch("-1645467448", new Object[]{this, application});
            return;
        }
        b41.i(application, "application");
        AuthInfo authInfo = new AuthInfo(application, b.s(), b.t(), b.u());
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(application);
        c = createWBAPI;
        if (createWBAPI != null) {
            createWBAPI.registerApp(application, authInfo, new C3630b());
        }
    }

    public final boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-572108559") ? ((Boolean) ipChange.ipc$dispatch("-572108559", new Object[]{this})).booleanValue() : b.z();
    }
}
