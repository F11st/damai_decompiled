package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.a;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tb.z90;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HttpDnsProvider {
    private static final String TAG = "HttpDnsProvider";
    private int mCurrStrategyPos = 0;
    private List<IConnStrategy> mStrategys = new ArrayList();

    public HttpDnsProvider(String str) {
        HttpDispatcher.f().b(new HttpDispatcher.IDispatchEventListener() { // from class: com.taobao.accs.net.HttpDnsProvider.1
            @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
            public void onEvent(z90 z90Var) {
                ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: com.taobao.accs.net.HttpDnsProvider.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.a().saveData();
                    }
                }, 2000L, TimeUnit.MILLISECONDS);
            }
        });
        getAvailableStrategy(str);
    }

    public void forceUpdateStrategy(String str) {
        a.a().forceRefreshStrategy(str);
    }

    public List<IConnStrategy> getAvailableStrategy(String str) {
        List<IConnStrategy> connStrategyListByHost;
        if ((this.mCurrStrategyPos == 0 || this.mStrategys.isEmpty()) && (connStrategyListByHost = a.a().getConnStrategyListByHost(str)) != null && !connStrategyListByHost.isEmpty()) {
            this.mStrategys.clear();
            for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                ConnType l = ConnType.l(iConnStrategy.getProtocol());
                if (l.f() == ConnType.TypeLevel.SPDY && l.k()) {
                    this.mStrategys.add(iConnStrategy);
                }
            }
        }
        return this.mStrategys;
    }

    public IConnStrategy getStrategy() {
        return getStrategy(this.mStrategys);
    }

    public int getStrategyPos() {
        return this.mCurrStrategyPos;
    }

    public void updateStrategyPos() {
        this.mCurrStrategyPos++;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "updateStrategyPos StrategyPos:" + this.mCurrStrategyPos, new Object[0]);
        }
    }

    public IConnStrategy getStrategy(List<IConnStrategy> list) {
        if (list != null && !list.isEmpty()) {
            int i = this.mCurrStrategyPos;
            if (i < 0 || i >= list.size()) {
                this.mCurrStrategyPos = 0;
            }
            return list.get(this.mCurrStrategyPos);
        }
        ALog.d(TAG, "strategys null or 0", new Object[0]);
        return null;
    }
}
