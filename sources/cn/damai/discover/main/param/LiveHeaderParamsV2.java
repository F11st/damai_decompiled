package cn.damai.discover.main.param;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LiveHeaderParamsV2 extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1907611840") ? (String) ipChange.ipc$dispatch("-1907611840", new Object[]{this}) : "discoveryLive";
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "953265757") ? (String) ipChange.ipc$dispatch("953265757", new Object[]{this}) : "2.0";
    }
}
