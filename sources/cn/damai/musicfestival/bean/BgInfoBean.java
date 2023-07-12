package cn.damai.musicfestival.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class BgInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final float DEFAULT_ASPECT_RATIO = 0.712f;
    public String height;
    public String mapUrl;
    public String width;

    @JSONField(serialize = false)
    public float getAspectRatio() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393584541")) {
            return ((Float) ipChange.ipc$dispatch("1393584541", new Object[]{this})).floatValue();
        }
        try {
            int parseInt = Integer.parseInt(this.height);
            int parseInt2 = Integer.parseInt(this.width);
            if (parseInt2 <= 0 || parseInt <= 0) {
                return 0.712f;
            }
            return parseInt / parseInt2;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.712f;
        }
    }
}
