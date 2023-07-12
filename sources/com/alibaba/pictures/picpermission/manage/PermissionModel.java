package com.alibaba.pictures.picpermission.manage;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.resource.widget.YKActionSheet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/alibaba/pictures/picpermission/manage/PermissionModel;", "", "", "", "permission", "[Ljava/lang/String;", "getPermission", "()[Ljava/lang/String;", "setPermission", "([Ljava/lang/String;)V", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "", "iconResId", "Ljava/lang/Integer;", "getIconResId", "()Ljava/lang/Integer;", "setIconResId", "(Ljava/lang/Integer;)V", YKActionSheet.ACTION_STYLE_DESCRIBE, "getDescribe", "setDescribe", "<init>", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PermissionModel {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String describe;
    @Nullable
    private Integer iconResId;
    @NotNull
    private String[] permission;
    @Nullable
    private String title;

    public PermissionModel(@NotNull String[] strArr, @Nullable String str, @Nullable Integer num, @Nullable String str2) {
        b41.i(strArr, "permission");
        this.permission = strArr;
        this.title = str;
        this.iconResId = num;
        this.describe = str2;
    }

    @Nullable
    public final String getDescribe() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1529552947") ? (String) ipChange.ipc$dispatch("1529552947", new Object[]{this}) : this.describe;
    }

    @Nullable
    public final Integer getIconResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2137493609") ? (Integer) ipChange.ipc$dispatch("-2137493609", new Object[]{this}) : this.iconResId;
    }

    @NotNull
    public final String[] getPermission() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "149504344") ? (String[]) ipChange.ipc$dispatch("149504344", new Object[]{this}) : this.permission;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1727067610") ? (String) ipChange.ipc$dispatch("-1727067610", new Object[]{this}) : this.title;
    }

    public final void setDescribe(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289173259")) {
            ipChange.ipc$dispatch("289173259", new Object[]{this, str});
        } else {
            this.describe = str;
        }
    }

    public final void setIconResId(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643565947")) {
            ipChange.ipc$dispatch("643565947", new Object[]{this, num});
        } else {
            this.iconResId = num;
        }
    }

    public final void setPermission(@NotNull String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016298046")) {
            ipChange.ipc$dispatch("-1016298046", new Object[]{this, strArr});
            return;
        }
        b41.i(strArr, "<set-?>");
        this.permission = strArr;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491879184")) {
            ipChange.ipc$dispatch("491879184", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }
}
