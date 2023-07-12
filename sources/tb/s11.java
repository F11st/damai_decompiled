package tb;

import android.app.Activity;
import cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity;
import cn.damai.commonbusiness.photoselect.imageselected.PreviewDeleteActivity;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class s11 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SELECT_RESULT = "select_result";

    public static void a(Activity activity, int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384735477")) {
            ipChange.ipc$dispatch("-1384735477", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        } else {
            c(activity, i, z, i2, null);
        }
    }

    public static void b(Activity activity, int i, boolean z, int i2, String str, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206096203")) {
            ipChange.ipc$dispatch("-1206096203", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, arrayList});
        } else {
            ImageSelectorActivity.openActivity(activity, i, z, i2, str, arrayList);
        }
    }

    public static void c(Activity activity, int i, boolean z, int i2, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007231359")) {
            ipChange.ipc$dispatch("1007231359", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), arrayList});
        } else {
            ImageSelectorActivity.openActivity(activity, i, z, i2, arrayList);
        }
    }

    public static void d(Activity activity, ArrayList<Image> arrayList, ArrayList<Image> arrayList2, boolean z, int i, int i2, String str, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1312741124")) {
            ipChange.ipc$dispatch("-1312741124", new Object[]{activity, arrayList, arrayList2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)});
        } else if (arrayList == null || arrayList.isEmpty()) {
        } else {
            PreviewDeleteActivity.openDeleteActivity(activity, arrayList, arrayList2, z, i, i2, str, i3);
        }
    }
}
