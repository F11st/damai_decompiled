package com.alibaba.pictures.picpermission;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.exception.PicPermissionException;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.picpermission.manage.PicPermissionManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedList;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Permission {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3622a Companion = new C3622a(null);
    private final Context a;
    private final String[] b;
    private final Queue<PermissionModel> c;
    private final PermissionModel d;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.picpermission.Permission$a */
    /* loaded from: classes7.dex */
    public static final class C3622a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3622a() {
        }

        public /* synthetic */ C3622a(k50 k50Var) {
            this();
        }
    }

    public Permission(@NotNull Context context, @Nullable String[] strArr, @Nullable Queue<PermissionModel> queue, @Nullable PermissionModel permissionModel) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = strArr;
        this.c = queue;
        this.d = permissionModel;
        if (queue != null) {
            PicPermissionManager.Companion.init(queue, context);
        } else if (strArr != null) {
            PicPermissionManager.Companion.init(strArr, context);
        } else if (permissionModel != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(permissionModel);
            PicPermissionManager.Companion.init(linkedList, context);
        } else {
            throw new PicPermissionException("queue 和 list 不能都为空！");
        }
    }

    @NotNull
    public final Permission a(@NotNull IPermissionListener iPermissionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679675757")) {
            return (Permission) ipChange.ipc$dispatch("1679675757", new Object[]{this, iPermissionListener});
        }
        b41.i(iPermissionListener, "listener");
        PicPermissionManager.Companion.setPermissionListener(iPermissionListener);
        return this;
    }

    public final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846869235")) {
            ipChange.ipc$dispatch("-846869235", new Object[]{this});
        } else {
            c(false);
        }
    }

    public final void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483096729")) {
            ipChange.ipc$dispatch("-483096729", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            if (b41.d(Looper.myLooper(), Looper.getMainLooper())) {
                PicPermissionManager.Companion.instance().start();
            } else if (z) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alibaba.pictures.picpermission.Permission$start$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public final void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1084907353")) {
                            ipChange2.ipc$dispatch("1084907353", new Object[]{this});
                        } else {
                            PicPermissionManager.Companion.instance().start();
                        }
                    }
                });
            } else {
                PicPermissionManager.Companion.release();
                throw new UnsupportedOperationException("不可在子线程调用，请增加参数 toMainThread = true");
            }
        } catch (RuntimeException e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e("Permission", message);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Permission(@NotNull Context context, @NotNull Queue<PermissionModel> queue) {
        this(context, null, queue, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(queue, "queue");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Permission(@NotNull Context context, @NotNull PermissionModel permissionModel) {
        this(context, null, null, permissionModel);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(permissionModel, "permission");
    }
}
