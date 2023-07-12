package com.youku.live.dsl.danmaku;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.ui.widget.DanmakuView;
import com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp;
import com.youku.live.dsl.danmaku.youku.YoukuDanmakuControllerImp;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDanmakuFactoryImp implements IDanmakuFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.danmaku.IDanmakuFactory
    public IDanmakuController createController(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038229304")) {
            return (IDanmakuController) ipChange.ipc$dispatch("-1038229304", new Object[]{this, context});
        }
        DanmakuView danmakuView = new DanmakuView(context);
        IDanmaControllerImp iDanmaControllerImp = new IDanmaControllerImp(context);
        iDanmaControllerImp.setDanmakuView(danmakuView);
        return iDanmaControllerImp;
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuFactory
    public IDanmakuController createController(Context context, DanmakuControllerConfig danmakuControllerConfig) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752609717")) {
            return (IDanmakuController) ipChange.ipc$dispatch("-1752609717", new Object[]{this, context, danmakuControllerConfig});
        }
        if (danmakuControllerConfig != null && (num = danmakuControllerConfig.style) != null && num.intValue() == 0) {
            return new YoukuDanmakuControllerImp(context).initWithControllerConfig(danmakuControllerConfig);
        }
        return createController(context);
    }
}
