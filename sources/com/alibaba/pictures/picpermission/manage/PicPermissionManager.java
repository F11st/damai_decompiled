package com.alibaba.pictures.picpermission.manage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.alibaba.pictures.picpermission.custom.ICustomConfig;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.custom.IUtHandler;
import com.alibaba.pictures.picpermission.exception.PicPermissionException;
import com.alibaba.pictures.picpermission.mantle.DefaultUtHandler;
import com.alibaba.pictures.picpermission.mantle.MantleTipsView;
import com.alibaba.pictures.picpermission.mantle.PermissionBaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.ab;
import tb.b41;
import tb.k50;
import tb.ka;
import tb.kr1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\u00020\u0001:\u0001TB9\b\u0002\u0012\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;\u0012\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010?\u0012\u000e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0+¢\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R,\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00104\u001a\b\u0012\u0004\u0012\u00020\u0018038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010\u0012R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010.R$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/alibaba/pictures/picpermission/manage/PicPermissionManager;", "", "Ltb/wt2;", "reportDenied", "start", "proceed", "Lcom/alibaba/pictures/picpermission/custom/ICustomConfig;", "customConfig", "Lcom/alibaba/pictures/picpermission/custom/ICustomConfig;", "Lcom/alibaba/pictures/picpermission/custom/IPermissionListener;", "listener", "Lcom/alibaba/pictures/picpermission/custom/IPermissionListener;", "getListener", "()Lcom/alibaba/pictures/picpermission/custom/IPermissionListener;", "setListener", "(Lcom/alibaba/pictures/picpermission/custom/IPermissionListener;)V", "", "finishHandle", "Z", "getFinishHandle", "()Z", "setFinishHandle", "(Z)V", "Ljava/util/ArrayList;", "", "deniedPermissions", "Ljava/util/ArrayList;", "getDeniedPermissions", "()Ljava/util/ArrayList;", "Ljava/util/HashSet;", "totalDeniedPermissions", "Ljava/util/HashSet;", "getTotalDeniedPermissions", "()Ljava/util/HashSet;", "setTotalDeniedPermissions", "(Ljava/util/HashSet;)V", "Lcom/alibaba/pictures/picpermission/custom/IUtHandler;", "customUtHandler", "Lcom/alibaba/pictures/picpermission/custom/IUtHandler;", "getCustomUtHandler", "()Lcom/alibaba/pictures/picpermission/custom/IUtHandler;", "setCustomUtHandler", "(Lcom/alibaba/pictures/picpermission/custom/IUtHandler;)V", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "lastPermissionActivity", "Ljava/lang/ref/WeakReference;", "getLastPermissionActivity", "()Ljava/lang/ref/WeakReference;", "setLastPermissionActivity", "(Ljava/lang/ref/WeakReference;)V", "", "permissionRecord", "Ljava/util/List;", "getPermissionRecord", "()Ljava/util/List;", "setPermissionRecord", "(Ljava/util/List;)V", "isProcessingPermission", "Ljava/util/Queue;", "Lcom/alibaba/pictures/picpermission/manage/PermissionModel;", "permissionQueue", "Ljava/util/Queue;", "", "permissions", "[Ljava/lang/String;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/ka;", "customTipsView", "Ltb/ka;", "getCustomTipsView", "()Ltb/ka;", "setCustomTipsView", "(Ltb/ka;)V", "Ltb/ab;", "customRationalBehavior", "Ltb/ab;", "getCustomRationalBehavior", "()Ltb/ab;", "setCustomRationalBehavior", "(Ltb/ab;)V", "<init>", "(Ljava/util/Queue;[Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "Companion", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PicPermissionManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static ab defaultRationalBehavior;
    private static PicPermissionManager instance;
    private final WeakReference<Context> context;
    private ICustomConfig customConfig;
    @Nullable
    private ab customRationalBehavior;
    @Nullable
    private ka customTipsView;
    @NotNull
    private IUtHandler customUtHandler;
    @NotNull
    private final ArrayList<String> deniedPermissions;
    private boolean finishHandle;
    private boolean isProcessingPermission;
    @Nullable
    private WeakReference<Activity> lastPermissionActivity;
    @Nullable
    private IPermissionListener listener;
    private final Queue<PermissionModel> permissionQueue;
    @NotNull
    private List<String> permissionRecord;
    private final String[] permissions;
    @NotNull
    private HashSet<String> totalDeniedPermissions;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u001e\u0010\u0017\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J%\u0010\u0017\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0007J\b\u0010\u001b\u001a\u00020\u0004H\u0007R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001e¨\u0006!"}, d2 = {"Lcom/alibaba/pictures/picpermission/manage/PicPermissionManager$Companion;", "", "Ltb/ab;", "customRationalBehavior", "Ltb/wt2;", "setDefaultRationalBehavior", "", "title", SocialConstants.PARAM_APP_DESC, "usePlatformDefaultRationalBehavior", "setCustomRationalBehavior", "Ltb/ka;", "customView", "setCustomView", "Lcom/alibaba/pictures/picpermission/custom/IPermissionListener;", "listener", "setPermissionListener", "Ljava/util/Queue;", "Lcom/alibaba/pictures/picpermission/manage/PermissionModel;", "list", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/pictures/picpermission/manage/PicPermissionManager;", UCCore.LEGACY_EVENT_INIT, "", "([Ljava/lang/String;Landroid/content/Context;)Lcom/alibaba/pictures/picpermission/manage/PicPermissionManager;", "instance", "release", "defaultRationalBehavior", "Ltb/ab;", "Lcom/alibaba/pictures/picpermission/manage/PicPermissionManager;", "<init>", "()V", "permission_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final PicPermissionManager init(@NotNull Queue<PermissionModel> queue, @NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "10497058")) {
                return (PicPermissionManager) ipChange.ipc$dispatch("10497058", new Object[]{this, queue, context});
            }
            b41.i(queue, "list");
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            if (PicPermissionManager.instance == null) {
                PicPermissionManager.instance = new PicPermissionManager(queue, null, new WeakReference(context), null);
            }
            PicPermissionManager picPermissionManager = PicPermissionManager.instance;
            b41.f(picPermissionManager);
            return picPermissionManager;
        }

        @JvmStatic
        @NotNull
        public final PicPermissionManager instance() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "82259519")) {
                return (PicPermissionManager) ipChange.ipc$dispatch("82259519", new Object[]{this});
            }
            if (PicPermissionManager.instance == null) {
                PicPermissionManager.instance = new PicPermissionManager(null, null, new WeakReference(null), null);
            }
            PicPermissionManager picPermissionManager = PicPermissionManager.instance;
            b41.f(picPermissionManager);
            return picPermissionManager;
        }

        @JvmStatic
        public final void release() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1167504649")) {
                ipChange.ipc$dispatch("-1167504649", new Object[]{this});
            } else {
                PicPermissionManager.instance = null;
            }
        }

        public final void setCustomRationalBehavior(@NotNull ab abVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "703535693")) {
                ipChange.ipc$dispatch("703535693", new Object[]{this, abVar});
                return;
            }
            b41.i(abVar, "customRationalBehavior");
            if (PicPermissionManager.instance != null) {
                PicPermissionManager picPermissionManager = PicPermissionManager.instance;
                b41.f(picPermissionManager);
                picPermissionManager.setCustomRationalBehavior(abVar);
                return;
            }
            throw new PicPermissionException("PicPermissionManager need init first!");
        }

        @JvmStatic
        public final void setCustomView(@NotNull ka kaVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "989376071")) {
                ipChange.ipc$dispatch("989376071", new Object[]{this, kaVar});
                return;
            }
            b41.i(kaVar, "customView");
            if (PicPermissionManager.instance != null) {
                PicPermissionManager picPermissionManager = PicPermissionManager.instance;
                b41.f(picPermissionManager);
                picPermissionManager.setCustomTipsView(kaVar);
                return;
            }
            throw new PicPermissionException("PicPermissionManager need init first!");
        }

        public final void setDefaultRationalBehavior(@NotNull ab abVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "145379147")) {
                ipChange.ipc$dispatch("145379147", new Object[]{this, abVar});
                return;
            }
            b41.i(abVar, "customRationalBehavior");
            PicPermissionManager.defaultRationalBehavior = abVar;
        }

        @JvmStatic
        public final void setPermissionListener(@NotNull IPermissionListener iPermissionListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1031625515")) {
                ipChange.ipc$dispatch("1031625515", new Object[]{this, iPermissionListener});
                return;
            }
            b41.i(iPermissionListener, "listener");
            if (PicPermissionManager.instance != null) {
                PicPermissionManager picPermissionManager = PicPermissionManager.instance;
                b41.f(picPermissionManager);
                picPermissionManager.setListener(iPermissionListener);
                return;
            }
            throw new PicPermissionException("PicPermissionManager need init first!");
        }

        public final void usePlatformDefaultRationalBehavior(@NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "774636697")) {
                ipChange.ipc$dispatch("774636697", new Object[]{this, str, str2});
                return;
            }
            b41.i(str, "title");
            b41.i(str2, SocialConstants.PARAM_APP_DESC);
            if (PicPermissionManager.defaultRationalBehavior != null) {
                if (PicPermissionManager.instance != null) {
                    ab abVar = PicPermissionManager.defaultRationalBehavior;
                    if (abVar != null) {
                        abVar.a(str, str2);
                    }
                    PicPermissionManager picPermissionManager = PicPermissionManager.instance;
                    b41.f(picPermissionManager);
                    picPermissionManager.setCustomRationalBehavior(PicPermissionManager.defaultRationalBehavior);
                    return;
                }
                throw new PicPermissionException("PicPermissionManager need init first!");
            }
            throw new PicPermissionException("should setDefaultRationalBehavior first!");
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PicPermissionManager init(@NotNull String[] strArr, @NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2116257233")) {
                return (PicPermissionManager) ipChange.ipc$dispatch("2116257233", new Object[]{this, strArr, context});
            }
            b41.i(strArr, "list");
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            if (PicPermissionManager.instance == null) {
                PicPermissionManager.instance = new PicPermissionManager(null, strArr, new WeakReference(context), null);
            }
            PicPermissionManager picPermissionManager = PicPermissionManager.instance;
            b41.f(picPermissionManager);
            return picPermissionManager;
        }
    }

    private PicPermissionManager(Queue<PermissionModel> queue, String[] strArr, WeakReference<Context> weakReference) {
        this.permissionQueue = queue;
        this.permissions = strArr;
        this.context = weakReference;
        this.deniedPermissions = new ArrayList<>();
        this.totalDeniedPermissions = new HashSet<>();
        this.customTipsView = new MantleTipsView();
        this.customUtHandler = new DefaultUtHandler();
        this.permissionRecord = new ArrayList();
        try {
            Object f = a.j("com.alibaba.nissy.PicPermissionCustomConfig").b().f();
            b41.h(f, "Reflect.on(\"com.alibaba.…omConfig\").create().get()");
            ICustomConfig iCustomConfig = (ICustomConfig) f;
            this.customConfig = iCustomConfig;
            if (iCustomConfig == null) {
                b41.A("customConfig");
            }
            String customTipsViewClassName = iCustomConfig.getCustomTipsViewClassName();
            ICustomConfig iCustomConfig2 = this.customConfig;
            if (iCustomConfig2 == null) {
                b41.A("customConfig");
            }
            String customUtHandler = iCustomConfig2.getCustomUtHandler();
            boolean z = true;
            if (customUtHandler.length() > 0) {
                Object f2 = a.j(customUtHandler).b().f();
                b41.h(f2, "Reflect.on(customUt).create().get()");
                this.customUtHandler = (IUtHandler) f2;
            }
            if (customTipsViewClassName.length() <= 0) {
                z = false;
            }
            if (z) {
                this.customTipsView = (ka) a.j(customTipsViewClassName).b().f();
            }
        } catch (Throwable th) {
            Log.e("PicPermission", "get CustomConfig error Throwable: " + th);
        }
    }

    @JvmStatic
    @NotNull
    public static final PicPermissionManager init(@NotNull Queue<PermissionModel> queue, @NotNull Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1747931478") ? (PicPermissionManager) ipChange.ipc$dispatch("-1747931478", new Object[]{queue, context}) : Companion.init(queue, context);
    }

    @JvmStatic
    @NotNull
    public static final PicPermissionManager init(@NotNull String[] strArr, @NotNull Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "188581465") ? (PicPermissionManager) ipChange.ipc$dispatch("188581465", new Object[]{strArr, context}) : Companion.init(strArr, context);
    }

    @JvmStatic
    @NotNull
    public static final PicPermissionManager instance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1026709191") ? (PicPermissionManager) ipChange.ipc$dispatch("1026709191", new Object[0]) : Companion.instance();
    }

    @JvmStatic
    public static final void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197348481")) {
            ipChange.ipc$dispatch("-197348481", new Object[0]);
        } else {
            Companion.release();
        }
    }

    private final void reportDenied() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013968299")) {
            ipChange.ipc$dispatch("-2013968299", new Object[]{this});
        } else if (this.listener == null) {
        } else {
            if (!this.totalDeniedPermissions.isEmpty()) {
                IPermissionListener iPermissionListener = this.listener;
                if (iPermissionListener != null) {
                    Object[] array = this.totalDeniedPermissions.toArray(new String[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    iPermissionListener.onShowRationale((String[]) array);
                    return;
                }
                return;
            }
            IPermissionListener iPermissionListener2 = this.listener;
            if (iPermissionListener2 != null) {
                Object[] array2 = this.deniedPermissions.toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                iPermissionListener2.onPermissionDenied((String[]) array2);
            }
        }
    }

    @JvmStatic
    public static final void setCustomView(@NotNull ka kaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863560497")) {
            ipChange.ipc$dispatch("-1863560497", new Object[]{kaVar});
        } else {
            Companion.setCustomView(kaVar);
        }
    }

    @JvmStatic
    public static final void setPermissionListener(@NotNull IPermissionListener iPermissionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134145629")) {
            ipChange.ipc$dispatch("-1134145629", new Object[]{iPermissionListener});
        } else {
            Companion.setPermissionListener(iPermissionListener);
        }
    }

    @Nullable
    public final ab getCustomRationalBehavior() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1826891961") ? (ab) ipChange.ipc$dispatch("-1826891961", new Object[]{this}) : this.customRationalBehavior;
    }

    @Nullable
    public final ka getCustomTipsView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1527213675") ? (ka) ipChange.ipc$dispatch("-1527213675", new Object[]{this}) : this.customTipsView;
    }

    @NotNull
    public final IUtHandler getCustomUtHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1683209228") ? (IUtHandler) ipChange.ipc$dispatch("-1683209228", new Object[]{this}) : this.customUtHandler;
    }

    @NotNull
    public final ArrayList<String> getDeniedPermissions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1266401045") ? (ArrayList) ipChange.ipc$dispatch("-1266401045", new Object[]{this}) : this.deniedPermissions;
    }

    public final boolean getFinishHandle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "117737273") ? ((Boolean) ipChange.ipc$dispatch("117737273", new Object[]{this})).booleanValue() : this.finishHandle;
    }

    @Nullable
    public final WeakReference<Activity> getLastPermissionActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "46922506") ? (WeakReference) ipChange.ipc$dispatch("46922506", new Object[]{this}) : this.lastPermissionActivity;
    }

    @Nullable
    public final IPermissionListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-739021168") ? (IPermissionListener) ipChange.ipc$dispatch("-739021168", new Object[]{this}) : this.listener;
    }

    @NotNull
    public final List<String> getPermissionRecord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2023885591") ? (List) ipChange.ipc$dispatch("2023885591", new Object[]{this}) : this.permissionRecord;
    }

    @NotNull
    public final HashSet<String> getTotalDeniedPermissions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1580408536") ? (HashSet) ipChange.ipc$dispatch("-1580408536", new Object[]{this}) : this.totalDeniedPermissions;
    }

    public final void proceed() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1728588152")) {
            ipChange.ipc$dispatch("1728588152", new Object[]{this});
            return;
        }
        Context context = this.context.get();
        WeakReference<Activity> weakReference = this.lastPermissionActivity;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (context == null) {
            if (activity != null) {
                activity.finish();
            }
            Companion.release();
            return;
        }
        Queue<PermissionModel> queue = this.permissionQueue;
        if (queue != null) {
            if (queue.size() > 0) {
                PermissionModel poll = this.permissionQueue.poll();
                b41.f(poll);
                PermissionModel permissionModel = poll;
                if (kr1.e(permissionModel.getPermission(), context)) {
                    new PermissionBaseActivity();
                    Intent intent = new Intent(context, PermissionBaseActivity.class);
                    intent.putExtra("permissions", permissionModel.getPermission());
                    intent.putExtra(PermissionBaseActivity.EXTRA_TIPS_TITLE, permissionModel.getTitle());
                    intent.putExtra(PermissionBaseActivity.EXTRA_TIPS_ICON, permissionModel.getIconResId());
                    intent.putExtra(PermissionBaseActivity.EXTRA_TIPS_DESCRIBE, permissionModel.getDescribe());
                    intent.putExtra(PermissionBaseActivity.EXTRA_TIPS_SHOW_MANTLE, true);
                    intent.putExtra(PermissionBaseActivity.EXTRA_IS_THE_LAST, this.permissionQueue.size() == 0);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                String[] permission = permissionModel.getPermission();
                int length = permission.length;
                while (i < length) {
                    String str = permission[i];
                    if (ContextCompat.checkSelfPermission(context, str) != 0) {
                        this.deniedPermissions.add(str);
                    }
                    i++;
                }
                proceed();
                return;
            }
            this.isProcessingPermission = false;
            if (this.deniedPermissions.isEmpty()) {
                IPermissionListener iPermissionListener = this.listener;
                if (iPermissionListener != null) {
                    iPermissionListener.onPermissionGranted();
                }
            } else {
                reportDenied();
            }
            Companion.release();
        } else if (this.permissions != null) {
            Log.d("MMMMM", "非蒙层处理");
            if (kr1.e(this.permissions, context) && !this.finishHandle) {
                new PermissionBaseActivity();
                Intent intent2 = new Intent(context, PermissionBaseActivity.class);
                intent2.putExtra("permissions", this.permissions);
                intent2.putExtra(PermissionBaseActivity.EXTRA_TIPS_SHOW_MANTLE, false);
                intent2.putExtra(PermissionBaseActivity.EXTRA_IS_THE_LAST, true);
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return;
            }
            this.isProcessingPermission = false;
            String[] strArr = this.permissions;
            int length2 = strArr.length;
            while (i < length2) {
                String str2 = strArr[i];
                if (ContextCompat.checkSelfPermission(context, str2) != 0) {
                    this.deniedPermissions.add(str2);
                }
                i++;
            }
            if (this.deniedPermissions.isEmpty()) {
                IPermissionListener iPermissionListener2 = this.listener;
                if (iPermissionListener2 != null) {
                    iPermissionListener2.onPermissionGranted();
                }
            } else {
                reportDenied();
            }
            Companion.release();
        } else {
            Companion.release();
        }
    }

    public final void setCustomRationalBehavior(@Nullable ab abVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389862597")) {
            ipChange.ipc$dispatch("389862597", new Object[]{this, abVar});
        } else {
            this.customRationalBehavior = abVar;
        }
    }

    public final void setCustomTipsView(@Nullable ka kaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037922953")) {
            ipChange.ipc$dispatch("-2037922953", new Object[]{this, kaVar});
        } else {
            this.customTipsView = kaVar;
        }
    }

    public final void setCustomUtHandler(@NotNull IUtHandler iUtHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926706582")) {
            ipChange.ipc$dispatch("-1926706582", new Object[]{this, iUtHandler});
            return;
        }
        b41.i(iUtHandler, "<set-?>");
        this.customUtHandler = iUtHandler;
    }

    public final void setFinishHandle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106173259")) {
            ipChange.ipc$dispatch("2106173259", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.finishHandle = z;
        }
    }

    public final void setLastPermissionActivity(@Nullable WeakReference<Activity> weakReference) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707176430")) {
            ipChange.ipc$dispatch("707176430", new Object[]{this, weakReference});
        } else {
            this.lastPermissionActivity = weakReference;
        }
    }

    public final void setListener(@Nullable IPermissionListener iPermissionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235588532")) {
            ipChange.ipc$dispatch("1235588532", new Object[]{this, iPermissionListener});
        } else {
            this.listener = iPermissionListener;
        }
    }

    public final void setPermissionRecord(@NotNull List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104383893")) {
            ipChange.ipc$dispatch("104383893", new Object[]{this, list});
            return;
        }
        b41.i(list, "<set-?>");
        this.permissionRecord = list;
    }

    public final void setTotalDeniedPermissions(@NotNull HashSet<String> hashSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2013724494")) {
            ipChange.ipc$dispatch("2013724494", new Object[]{this, hashSet});
            return;
        }
        b41.i(hashSet, "<set-?>");
        this.totalDeniedPermissions = hashSet;
    }

    public final void start() {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286351996")) {
            ipChange.ipc$dispatch("-286351996", new Object[]{this});
        } else if (this.isProcessingPermission) {
        } else {
            if (Build.VERSION.SDK_INT >= 23 && this.context.get() != null) {
                this.isProcessingPermission = true;
                proceed();
                return;
            }
            WeakReference<Activity> weakReference = this.lastPermissionActivity;
            if (weakReference != null && (activity = weakReference.get()) != null) {
                activity.finish();
            }
            Companion.release();
        }
    }

    public /* synthetic */ PicPermissionManager(Queue queue, String[] strArr, WeakReference weakReference, k50 k50Var) {
        this(queue, strArr, weakReference);
    }
}
