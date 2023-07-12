package anet.channel.strategy;

import android.content.Context;
import java.util.List;
import tb.ym;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IStrategyInstance {
    void forceRefreshStrategy(String str);

    boolean getAbStrategyStatusByHost(String str, String str2);

    String getCNameByHost(String str);

    String getClientIp();

    List<IConnStrategy> getConnStrategyListByHost(String str);

    List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter);

    List<IConnStrategy> getConnStrategyListWithoutWait(String str);

    String getFormalizeUrl(String str);

    List<IConnStrategy> getIpv4ConnStrategyListByHost(String str, boolean z, int i);

    @Deprecated
    String getSchemeByHost(String str);

    String getSchemeByHost(String str, String str2);

    String getUnitByHost(String str);

    void initialize(Context context);

    void notifyConnEvent(String str, IConnStrategy iConnStrategy, ym ymVar);

    void registerListener(IStrategyListener iStrategyListener);

    void saveData();

    void switchEnv();

    void unregisterListener(IStrategyListener iStrategyListener);
}
