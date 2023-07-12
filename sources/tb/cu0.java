package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.component.girl.mvp.ColumnPresenter;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class cu0 extends zc1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String C_NAME = "xiannv_card_";
    private static cu0 a;

    public static cu0 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940747077")) {
            return (cu0) ipChange.ipc$dispatch("-1940747077", new Object[0]);
        }
        if (a == null) {
            a = new cu0();
        }
        return a;
    }

    public void b(ColumnPresenter columnPresenter, View view, int i, int i2, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556149202")) {
            ipChange.ipc$dispatch("-1556149202", new Object[]{this, columnPresenter, view, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        hashMap.put(PushConstants.SUB_TAGS_STATUS_NAME, str3);
        if (columnPresenter != null) {
            try {
                columnPresenter.userTrack(TrackType.expose, view, columnPresenter.getModel().getTrackInfo().trackB, columnPresenter.getModel().getTrackInfo().trackC + i, "item_" + i2, hashMap, false);
            } catch (Exception unused) {
            }
        }
    }
}
