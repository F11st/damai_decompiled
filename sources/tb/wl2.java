package tb;

import android.view.View;
import cn.damai.tetris.component.home.bean.BannerResultBean;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.bean.HomeStarTourBean;
import cn.damai.tetris.component.home.bean.HomeTitleBean;
import cn.damai.tetris.component.home.bean.WarningMessageBean;
import cn.damai.tetris.component.home.viewholder.AnnouncementViewHolder;
import cn.damai.tetris.component.home.viewholder.BannerViewHolder;
import cn.damai.tetris.component.home.viewholder.RankTopViewHolder;
import cn.damai.tetris.component.home.viewholder.RecentShowViewHolder;
import cn.damai.tetris.component.home.viewholder.StarTourViewHolder;
import cn.damai.tetris.component.home.viewholder.VideoViewHolderV2;
import cn.damai.tetris.component.home.viewholder.WantSeeViewHolder;
import cn.damai.tetris.component.home.viewholder.WaterFlowTitleViewHolder;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.tetris.mvp.ViewHolderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class wl2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static HashMap<String, ViewHolderData> a;

    static {
        HashMap<String, ViewHolderData> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put(xl2.DM_HOME_BANNER_CID, new ViewHolderData(BannerViewHolder.class, BannerResultBean.class));
        a.put("dm_home_warningmessage", new ViewHolderData(AnnouncementViewHolder.class, WarningMessageBean.class));
        a.put("dm_home_mustseerank3", new ViewHolderData(RankTopViewHolder.class, HomePageRankBean.class));
        a.put("dm_home_wantsee", new ViewHolderData(WantSeeViewHolder.class, HomePageRecentBean.class));
        a.put("dm_home_recentproject", new ViewHolderData(RecentShowViewHolder.class, HomePageRecentBean.class));
        a.put("dm_home_tour", new ViewHolderData(StarTourViewHolder.class, HomeStarTourBean.class));
        a.put("dm_home_video", new ViewHolderData(VideoViewHolderV2.class, HomePageVideoBean.class));
        a.put("dm_home_weinituijian_title", new ViewHolderData(WaterFlowTitleViewHolder.class, HomeTitleBean.class));
    }

    public static CommonViewHolder a(String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279824872")) {
            return (CommonViewHolder) ipChange.ipc$dispatch("-1279824872", new Object[]{str, view});
        }
        ViewHolderData viewHolderData = a.get(str);
        CommonViewHolder commonViewHolder = null;
        if (viewHolderData == null) {
            return null;
        }
        try {
            CommonViewHolder commonViewHolder2 = (CommonViewHolder) viewHolderData.viewHolder.getDeclaredConstructor(View.class).newInstance(view);
            try {
                commonViewHolder2.setTClass(viewHolderData.bean);
                return commonViewHolder2;
            } catch (Exception e) {
                e = e;
                commonViewHolder = commonViewHolder2;
                e.printStackTrace();
                return commonViewHolder;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
