package cn.damai.tetris.component.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ThemeBean extends Extra {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentCount;
    public String desc;
    public String id;
    public String ipvuv;
    public String name;
    public String pic;
    public String themePrize;

    public boolean hasPrize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-968739204") ? ((Boolean) ipChange.ipc$dispatch("-968739204", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.themePrize);
    }
}
