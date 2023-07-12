package tb;

import android.view.View;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class ka {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View a;

    @Nullable
    public final View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "95040873") ? (View) ipChange.ipc$dispatch("95040873", new Object[]{this}) : this.a;
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1532952058")) {
            return ((Integer) ipChange.ipc$dispatch("1532952058", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void c(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160259236")) {
            ipChange.ipc$dispatch("160259236", new Object[]{this, view});
        } else {
            b41.i(view, "view");
        }
    }

    public final void d(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "975096831")) {
            ipChange.ipc$dispatch("975096831", new Object[]{this, view});
        } else {
            this.a = view;
        }
    }

    public void e(@NotNull PermissionModel permissionModel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292395912")) {
            ipChange.ipc$dispatch("292395912", new Object[]{this, permissionModel, Boolean.valueOf(z)});
        } else {
            b41.i(permissionModel, "permission");
        }
    }
}
