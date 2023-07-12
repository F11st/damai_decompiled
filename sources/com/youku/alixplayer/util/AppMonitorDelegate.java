package com.youku.alixplayer.util;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.youku.alixplayer.util.SystemDelegate;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AppMonitorDelegate implements SystemDelegate.IPlayerBridge {
    private Set<String> mSeenMetrics = new HashSet();

    @Override // com.youku.alixplayer.util.SystemDelegate.IPlayerBridge
    public void handle(SystemDelegate.BridgeParam bridgeParam) {
        double d;
        String string = bridgeParam.getString();
        String string2 = bridgeParam.getString();
        DimensionValueSet create = DimensionValueSet.create();
        MeasureValueSet create2 = MeasureValueSet.create();
        int i = bridgeParam.getInt();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            String string3 = bridgeParam.getString();
            int type = bridgeParam.getType();
            if (type == 1) {
                d = bridgeParam.getInt();
            } else if (type == 2) {
                d = bridgeParam.getLong();
            } else if (type == 3) {
                d = bridgeParam.getFloat();
            } else if (type != 4) {
                if (type == 6) {
                    create.setValue(string3, bridgeParam.getString());
                }
                i = i2;
            } else {
                d = bridgeParam.getDouble();
            }
            create2.setValue(string3, d);
            i = i2;
        }
        if (!this.mSeenMetrics.contains(string + ":" + string2)) {
            AppMonitor.register(string, string2, MeasureSet.create(create2.getMap().keySet()), DimensionSet.create(create.getMap().keySet()), true);
            this.mSeenMetrics.add(string + ":" + string2);
        }
        AppMonitor.Stat.commit(string, string2, create, create2);
    }
}
