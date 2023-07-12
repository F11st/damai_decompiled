package cn.damai.tetris.component.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VideoInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 3419910089794360719L;
    public String coverUrl;
    public String height;
    public String sourceLabel;
    public String status;
    public String url;
    public String videoTime;
    public String width;

    public String formatVideoTime() {
        int j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94771129")) {
            return (String) ipChange.ipc$dispatch("-94771129", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.videoTime) && (j = jm1.j(this.videoTime, -1)) > 0) {
            int i = (j % 60000) / 1000;
            int i2 = (j % 3600000) / 60000;
            int i3 = j / 3600000;
            StringBuilder sb = new StringBuilder();
            if (i3 > 0) {
                sb.append(i3);
                sb.append(":");
            }
            if (i2 <= 9) {
                sb.append("0");
            }
            sb.append(i2);
            sb.append(":");
            if (i <= 9) {
                sb.append("0");
            }
            sb.append(i);
            return sb.toString();
        }
        return null;
    }

    public boolean isVideoUnderReviewStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1953736909") ? ((Boolean) ipChange.ipc$dispatch("-1953736909", new Object[]{this})).booleanValue() : TextUtils.equals("0", this.status);
    }
}
