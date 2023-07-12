package cn.damai.common.badge.listener;

import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface BadgeListenerManager {
    void notifyFailListener(List<String> list, String str, String str2);

    void notifyListener(String str, BadgeNodeItem badgeNodeItem);

    void registerListener(String str, DMBadgeListener dMBadgeListener);

    void registerListener(List<String> list, DMBadgeListener dMBadgeListener);

    void unRegisterListener(String str, DMBadgeListener dMBadgeListener);

    void unRegisterListener(List<String> list, DMBadgeListener dMBadgeListener);
}
