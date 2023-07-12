package tb;

import android.text.TextUtils;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.badge.listener.BadgeListenerManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class aa implements BadgeListenerManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private ConcurrentHashMap<String, List<DMBadgeListener>> a = new ConcurrentHashMap<>();

    @Override // cn.damai.common.badge.listener.BadgeListenerManager
    public void notifyFailListener(List<String> list, String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1018620982")) {
            ipChange.ipc$dispatch("-1018620982", new Object[]{this, list, str, str2});
        } else if (wh2.e(list) != 0) {
            for (String str3 : list) {
                List<DMBadgeListener> list2 = this.a.get(str3);
                if (list2 != null) {
                    ArrayList arrayList = new ArrayList();
                    synchronized (this) {
                        arrayList.addAll(list2);
                    }
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        ((DMBadgeListener) it.next()).badgeQueryFail(list, str, str2);
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                }
            }
        }
    }

    @Override // cn.damai.common.badge.listener.BadgeListenerManager
    public void notifyListener(String str, BadgeNodeItem badgeNodeItem) {
        List<DMBadgeListener> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627506578")) {
            ipChange.ipc$dispatch("-627506578", new Object[]{this, str, badgeNodeItem});
        } else if (str != null && badgeNodeItem != null && (list = this.a.get(str)) != null) {
            ArrayList<DMBadgeListener> arrayList = new ArrayList();
            synchronized (this) {
                arrayList.addAll(list);
            }
            for (DMBadgeListener dMBadgeListener : arrayList) {
                dMBadgeListener.badgeChanged(str, badgeNodeItem);
            }
        }
    }

    @Override // cn.damai.common.badge.listener.BadgeListenerManager
    public void registerListener(String str, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232575765")) {
            ipChange.ipc$dispatch("232575765", new Object[]{this, str, dMBadgeListener});
        } else if (TextUtils.isEmpty(str) || dMBadgeListener == null) {
        } else {
            List<DMBadgeListener> list = this.a.get(str);
            synchronized (this) {
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(str, list);
                }
                if (!list.contains(dMBadgeListener)) {
                    list.add(dMBadgeListener);
                }
            }
        }
    }

    @Override // cn.damai.common.badge.listener.BadgeListenerManager
    public void unRegisterListener(String str, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344372494")) {
            ipChange.ipc$dispatch("1344372494", new Object[]{this, str, dMBadgeListener});
        } else if (TextUtils.isEmpty(str) || dMBadgeListener == null) {
        } else {
            List<DMBadgeListener> list = this.a.get(str);
            synchronized (this) {
                if (list != null) {
                    if (list.contains(dMBadgeListener)) {
                        list.remove(dMBadgeListener);
                    }
                }
            }
        }
    }

    @Override // cn.damai.common.badge.listener.BadgeListenerManager
    public void unRegisterListener(List<String> list, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103354375")) {
            ipChange.ipc$dispatch("1103354375", new Object[]{this, list, dMBadgeListener});
        } else if (wh2.e(list) != 0 && dMBadgeListener != null) {
            for (String str : list) {
                unRegisterListener(str, dMBadgeListener);
            }
        }
    }

    @Override // cn.damai.common.badge.listener.BadgeListenerManager
    public void registerListener(List<String> list, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266514994")) {
            ipChange.ipc$dispatch("-1266514994", new Object[]{this, list, dMBadgeListener});
        } else if (wh2.e(list) != 0 && dMBadgeListener != null) {
            for (String str : list) {
                registerListener(str, dMBadgeListener);
            }
        }
    }
}
