package tb;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import cn.damai.common.askpermission.OnGrantListener;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ir1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnGrantListener a;
        final /* synthetic */ Activity b;
        final /* synthetic */ String c;

        /* compiled from: Taobao */
        /* renamed from: tb.ir1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC0455a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0455a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-15788466")) {
                    ipChange.ipc$dispatch("-15788466", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f(a.this.b);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(a aVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "953792557")) {
                    ipChange.ipc$dispatch("953792557", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        a(OnGrantListener onGrantListener, Activity activity, String str) {
            this.a = onGrantListener;
            this.b = activity;
            this.c = str;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1952189381")) {
                ipChange.ipc$dispatch("1952189381", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2006131130")) {
                ipChange.ipc$dispatch("2006131130", new Object[]{this});
                return;
            }
            OnGrantListener onGrantListener = this.a;
            if (onGrantListener != null) {
                onGrantListener.onGranted();
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-53370189")) {
                ipChange.ipc$dispatch("-53370189", new Object[]{this, strArr});
            } else {
                gr1.a(this.b, this.c, Arrays.asList(strArr), false, new DialogInterface$OnClickListenerC0455a(), new b(this));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnGrantListener a;
        final /* synthetic */ Activity b;
        final /* synthetic */ String c;

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-256328595")) {
                    ipChange.ipc$dispatch("-256328595", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f(b.this.b);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.ir1$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC0456b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0456b(b bVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "713252428")) {
                    ipChange.ipc$dispatch("713252428", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        b(OnGrantListener onGrantListener, Activity activity, String str) {
            this.a = onGrantListener;
            this.b = activity;
            this.c = str;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "927495460")) {
                ipChange.ipc$dispatch("927495460", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2037150937")) {
                ipChange.ipc$dispatch("2037150937", new Object[]{this});
                return;
            }
            OnGrantListener onGrantListener = this.a;
            if (onGrantListener != null) {
                onGrantListener.onGranted();
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1989030476")) {
                ipChange.ipc$dispatch("-1989030476", new Object[]{this, strArr});
            } else {
                gr1.a(this.b, this.c, Arrays.asList(strArr), false, new a(), new DialogInterface$OnClickListenerC0456b(this));
            }
        }
    }

    public static void a(Activity activity, boolean z, String str, String str2, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568421142")) {
            ipChange.ipc$dispatch("568421142", new Object[]{activity, Boolean.valueOf(z), str, str2, onGrantListener});
            return;
        }
        try {
            b(activity, z, new String[]{str}, str2, onGrantListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Activity activity, boolean z, String[] strArr, String str, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584788275")) {
            ipChange.ipc$dispatch("-584788275", new Object[]{activity, Boolean.valueOf(z), strArr, str, onGrantListener});
            return;
        }
        try {
            String format = String.format("%1$s%2$s", e(Arrays.asList(strArr)), str);
            new Permission(mu0.a(), new PermissionModel(strArr, "权限使用说明", null, format)).a(new a(onGrantListener, activity, format)).b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(Fragment fragment, boolean z, String[] strArr, String str, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482396697")) {
            ipChange.ipc$dispatch("-1482396697", new Object[]{fragment, Boolean.valueOf(z), strArr, str, onGrantListener});
            return;
        }
        try {
            b(fragment.getActivity(), z, strArr, str, onGrantListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Activity activity, boolean z, String[] strArr, String str, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529708723")) {
            ipChange.ipc$dispatch("-1529708723", new Object[]{activity, Boolean.valueOf(z), strArr, str, onGrantListener});
            return;
        }
        try {
            new Permission(activity, new PermissionModel(strArr, "权限使用说明", null, str)).a(new b(onGrantListener, activity, str)).b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String e(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744837753")) {
            return (String) ipChange.ipc$dispatch("-744837753", new Object[]{list});
        }
        String[] b2 = mr1.b(list);
        StringBuilder sb = new StringBuilder();
        sb.append("授权获取");
        for (String str : b2) {
            sb.append(str);
            sb.append("、");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("权限，");
        return sb.toString();
    }

    public static boolean f(Context context, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576803634")) {
            return ((Boolean) ipChange.ipc$dispatch("576803634", new Object[]{context, list})).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        AppOpsManager appOpsManager = null;
        for (String str : list) {
            int checkSelfPermission = PermissionChecker.checkSelfPermission(context, str);
            if (checkSelfPermission == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (!TextUtils.isEmpty(permissionToOp)) {
                if (appOpsManager == null) {
                    appOpsManager = (AppOpsManager) context.getSystemService("appops");
                }
                if (appOpsManager != null) {
                    checkSelfPermission = appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                }
                if (checkSelfPermission != 0 && checkSelfPermission != 4) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "65781497")) {
            return ((Boolean) ipChange.ipc$dispatch("65781497", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return i(new String[]{str});
    }

    public static boolean h(List<String> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1350463712") ? ((Boolean) ipChange.ipc$dispatch("1350463712", new Object[]{list})).booleanValue() : f(mu0.a(), list);
    }

    public static boolean i(String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-65317544")) {
            return ((Boolean) ipChange.ipc$dispatch("-65317544", new Object[]{strArr})).booleanValue();
        }
        if (strArr != null) {
            return h(Arrays.asList(strArr));
        }
        return false;
    }
}
