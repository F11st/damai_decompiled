package cn.damai.common.badge;

import cn.damai.common.badge.bean.BadgeNodeItem;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface DMBadgeListener {
    void badgeChanged(String str, BadgeNodeItem badgeNodeItem);

    void badgeQueryFail(List<String> list, String str, String str2);
}
