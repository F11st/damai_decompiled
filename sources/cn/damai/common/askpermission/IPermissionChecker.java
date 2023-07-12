package cn.damai.common.askpermission;

import android.content.Context;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IPermissionChecker {
    boolean hasPermission(Context context, List<String> list);

    boolean hasPermission(Context context, String... strArr);
}
