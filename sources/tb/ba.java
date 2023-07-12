package tb;

import cn.damai.common.badge.bean.BadgeDTO;
import cn.damai.common.badge.bean.BadgeMarkResponse;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.badge.bean.BadgeQueryResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ba {
    private static transient /* synthetic */ IpChange $ipChange;

    public static List<BadgeNodeItem> a(BadgeMarkResponse badgeMarkResponse) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309424811")) {
            return (List) ipChange.ipc$dispatch("-309424811", new Object[]{badgeMarkResponse});
        }
        if (badgeMarkResponse != null && badgeMarkResponse.getBadgeDTOList() != null) {
            ArrayList arrayList = new ArrayList();
            for (BadgeDTO badgeDTO : badgeMarkResponse.getBadgeDTOList()) {
                if (badgeDTO != null) {
                    BadgeNodeItem badgeNodeItem = new BadgeNodeItem();
                    badgeNodeItem.setNodeId(badgeDTO.getNodeId());
                    badgeNodeItem.setCount(badgeDTO.getCount());
                    badgeNodeItem.setVersion(badgeDTO.getBadgeUpdateTime());
                    badgeNodeItem.setElimination(!"IMMEDIATELY".equals(badgeDTO.getElimination()) ? 1 : 0);
                    if ("BUBBLE".equals(badgeDTO.getStyle())) {
                        i = 0;
                    } else {
                        i = "TEXT".equals(badgeDTO.getStyle()) ? 2 : 1;
                    }
                    badgeNodeItem.setStyle(i);
                    badgeNodeItem.setText(badgeDTO.getText());
                    badgeNodeItem.setExt(badgeDTO.getExt());
                    arrayList.add(badgeNodeItem);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static List<BadgeNodeItem> b(BadgeQueryResponse badgeQueryResponse) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479002209")) {
            return (List) ipChange.ipc$dispatch("-1479002209", new Object[]{badgeQueryResponse});
        }
        if (badgeQueryResponse != null && badgeQueryResponse.getBadgeDTOList() != null) {
            ArrayList arrayList = new ArrayList();
            for (BadgeDTO badgeDTO : badgeQueryResponse.getBadgeDTOList()) {
                if (badgeDTO != null) {
                    BadgeNodeItem badgeNodeItem = new BadgeNodeItem();
                    badgeNodeItem.setNodeId(badgeDTO.getNodeId());
                    badgeNodeItem.setCount(badgeDTO.getCount());
                    badgeNodeItem.setVersion(badgeDTO.getBadgeUpdateTime());
                    badgeNodeItem.setElimination(!"IMMEDIATELY".equals(badgeDTO.getElimination()) ? 1 : 0);
                    if ("BUBBLE".equals(badgeDTO.getStyle())) {
                        i = 0;
                    } else {
                        i = "TEXT".equals(badgeDTO.getStyle()) ? 2 : 1;
                    }
                    badgeNodeItem.setStyle(i);
                    badgeNodeItem.setText(badgeDTO.getText());
                    badgeNodeItem.setExt(badgeDTO.getExt());
                    arrayList.add(badgeNodeItem);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
