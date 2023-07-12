package tb;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class w42 {
    private static final Set<String> a;

    static {
        Set<String> g;
        g = kotlin.collections.e0.g("M", "L", "H", "V", "C", ExifInterface.LATITUDE_SOUTH, "Q", "R", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", WXComponent.PROP_FS_MATCH_PARENT, NotifyType.LIGHTS, "h", "v", com.huawei.hms.opendevice.c.a, "s", "q", UploadQueueMgr.MSGTYPE_REALTIME, "a", "z");
        a = g;
    }
}
