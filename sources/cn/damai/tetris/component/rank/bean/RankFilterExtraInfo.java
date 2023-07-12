package cn.damai.tetris.component.rank.bean;

import android.text.TextUtils;
import android.util.Pair;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RankFilterExtraInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String rankProjectLayerId;
    public String rankProjectSectionId;
    public String spmB;
    public boolean hasProject = false;
    public boolean shouldShowOtherCityTip = false;

    public static Pair<BaseLayer, BaseSection> findRankProjectBs(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831933132")) {
            return (Pair) ipChange.ipc$dispatch("831933132", new Object[]{baseResponse});
        }
        if (baseResponse == null || cb2.d(baseResponse.layers)) {
            return null;
        }
        Iterator<BaseLayer> it = baseResponse.layers.iterator();
        while (it.hasNext()) {
            BaseLayer next = it.next();
            List<BaseSection> sections = next.getSections();
            if (!cb2.d(sections)) {
                for (BaseSection baseSection : sections) {
                    if (TextUtils.equals("dm_rank_square_project_vertical_list", baseSection.getComponentId())) {
                        return new Pair<>(next, baseSection);
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:12|(2:14|(8:16|17|18|(1:29)|21|22|(1:28)(1:26)|27))|35|17|18|(0)|29|21|22|(1:24)|28|27) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        r3 = r2;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        r2.printStackTrace();
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.damai.tetris.component.rank.bean.RankFilterExtraInfo obtainFromBaseRes(cn.damai.tetris.core.mtop.BaseResponse r8) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.component.rank.bean.RankFilterExtraInfo.$ipChange
            java.lang.String r1 = "-1937233209"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r8
            java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
            cn.damai.tetris.component.rank.bean.RankFilterExtraInfo r8 = (cn.damai.tetris.component.rank.bean.RankFilterExtraInfo) r8
            return r8
        L17:
            cn.damai.tetris.component.rank.bean.RankFilterExtraInfo r0 = new cn.damai.tetris.component.rank.bean.RankFilterExtraInfo
            r0.<init>()
            android.util.Pair r1 = findRankProjectBs(r8)
            if (r1 == 0) goto L8c
            java.lang.Object r2 = r1.second     // Catch: java.lang.Exception -> L56
            cn.damai.tetris.core.BaseSection r2 = (cn.damai.tetris.core.BaseSection) r2     // Catch: java.lang.Exception -> L56
            cn.damai.tetris.core.NodeData r2 = r2.getItem()     // Catch: java.lang.Exception -> L56
            if (r2 == 0) goto L5c
            java.lang.String r5 = "cityId"
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Exception -> L56
            java.lang.String r6 = "itemDOList"
            com.alibaba.fastjson.JSONArray r2 = r2.getJSONArray(r6)     // Catch: java.lang.Exception -> L56
            if (r2 == 0) goto L42
            int r2 = r2.size()     // Catch: java.lang.Exception -> L56
            if (r2 <= 0) goto L42
            r2 = 1
            goto L43
        L42:
            r2 = 0
        L43:
            java.lang.String r6 = "0"
            boolean r5 = android.text.TextUtils.equals(r6, r5)     // Catch: java.lang.Exception -> L51
            if (r5 == 0) goto L4e
            if (r2 == 0) goto L4e
            goto L4f
        L4e:
            r3 = 0
        L4f:
            r4 = r2
            goto L5d
        L51:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L58
        L56:
            r2 = move-exception
            r3 = 0
        L58:
            r2.printStackTrace()
            r4 = r3
        L5c:
            r3 = 0
        L5d:
            cn.damai.tetris.core.mtop.GlobalConfig r2 = r8.globalConfig
            if (r2 == 0) goto L70
            java.lang.String r2 = r2.pageName
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L70
            cn.damai.tetris.core.mtop.GlobalConfig r8 = r8.globalConfig
            java.lang.String r8 = r8.pageName
            r0.spmB = r8
            goto L74
        L70:
            java.lang.String r8 = "ranklist_square"
            r0.spmB = r8
        L74:
            r0.hasProject = r4
            java.lang.Object r8 = r1.first
            cn.damai.tetris.core.BaseLayer r8 = (cn.damai.tetris.core.BaseLayer) r8
            java.lang.String r8 = r8.getLayerId()
            r0.rankProjectLayerId = r8
            java.lang.Object r8 = r1.second
            cn.damai.tetris.core.BaseSection r8 = (cn.damai.tetris.core.BaseSection) r8
            java.lang.String r8 = r8.getSectionId()
            r0.rankProjectSectionId = r8
            r0.shouldShowOtherCityTip = r3
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.rank.bean.RankFilterExtraInfo.obtainFromBaseRes(cn.damai.tetris.core.mtop.BaseResponse):cn.damai.tetris.component.rank.bean.RankFilterExtraInfo");
    }

    public static RankFilterExtraInfo obtainFromSection(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805110721")) {
            return (RankFilterExtraInfo) ipChange.ipc$dispatch("1805110721", new Object[]{iSection});
        }
        RankFilterExtraInfo rankFilterExtraInfo = null;
        if (iSection != null) {
            try {
                if (iSection.getItem() != null) {
                    rankFilterExtraInfo = (RankFilterExtraInfo) m61.d(iSection.getItem().getJSONObject("itemInfo"), RankFilterExtraInfo.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rankFilterExtraInfo == null ? new RankFilterExtraInfo() : rankFilterExtraInfo;
    }
}
