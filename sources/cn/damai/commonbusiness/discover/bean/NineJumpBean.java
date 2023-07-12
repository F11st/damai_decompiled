package cn.damai.commonbusiness.discover.bean;

import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class NineJumpBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATUS_HAS_VIDEO = 20;
    public static final int STATUS_NONE_VIDEO = 18;
    public static final int STATUS_VIDEO_UNDER_REVIEW = 19;
    private final List<GridBean> gridList;
    public final ArrayList<PicInfo> picInfoList;
    public final ArrayList<VideoInfo> videoInfoList;
    public final int videoStatus;

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NineJumpBean(java.util.List<java.lang.String> r6, cn.damai.tetris.component.discover.bean.VideoInfo r7) {
        /*
            r5 = this;
            r5.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 1
            r0.<init>(r1)
            r5.videoInfoList = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 9
            r1.<init>(r2)
            r5.picInfoList = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.gridList = r1
            if (r7 == 0) goto L60
            boolean r1 = r7.isVideoUnderReviewStatus()
            if (r1 == 0) goto L2a
            r0 = 19
            cn.damai.commonbusiness.discover.bean.GridBean r7 = cn.damai.commonbusiness.discover.bean.GridBean.fromVideo2(r7)
            goto L63
        L2a:
            java.lang.String r1 = r7.coverUrl
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L60
            java.lang.String r1 = r7.url
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L60
            r1 = 20
            cn.damai.commonbusiness.discover.bean.GridBean r2 = cn.damai.commonbusiness.discover.bean.GridBean.fromVideo2(r7)
            cn.damai.commonbusiness.imagebrowse.bean.VideoInfo r3 = new cn.damai.commonbusiness.imagebrowse.bean.VideoInfo
            r3.<init>()
            java.lang.String r4 = r7.coverUrl
            r3.setPicUrl(r4)
            java.lang.String r4 = r7.url
            r3.setVideoUrl(r4)
            cn.damai.commonbusiness.imagebrowse.bean.VideoInfo$VideoType r4 = cn.damai.commonbusiness.imagebrowse.bean.VideoInfo.VideoType.VIDEO_URL
            r3.setType(r4)
            java.lang.String r7 = r7.sourceLabel
            r3.setSourceLabel(r7)
            r0.add(r3)
            r7 = r2
            r0 = 20
            goto L63
        L60:
            r0 = 18
            r7 = 0
        L63:
            r5.videoStatus = r0
            boolean r0 = tb.cb2.d(r6)
            if (r0 != 0) goto L89
            java.util.Iterator r0 = r6.iterator()
        L6f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L89
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            cn.damai.commonbusiness.imagebrowse.bean.PicInfo r2 = new cn.damai.commonbusiness.imagebrowse.bean.PicInfo
            r2.<init>()
            r2.setPicUrl(r1)
            java.util.ArrayList<cn.damai.commonbusiness.imagebrowse.bean.PicInfo> r1 = r5.picInfoList
            r1.add(r2)
            goto L6f
        L89:
            java.util.List r6 = cn.damai.commonbusiness.discover.bean.GridBean.formImgList(r6)
            if (r7 == 0) goto L94
            java.util.List<cn.damai.commonbusiness.discover.bean.GridBean> r0 = r5.gridList
            r0.add(r7)
        L94:
            boolean r7 = tb.cb2.d(r6)
            if (r7 != 0) goto L9f
            java.util.List<cn.damai.commonbusiness.discover.bean.GridBean> r7 = r5.gridList
            r7.addAll(r6)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.discover.bean.NineJumpBean.<init>(java.util.List, cn.damai.tetris.component.discover.bean.VideoInfo):void");
    }

    public int computePosition2NextPage(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-97014205") ? ((Integer) ipChange.ipc$dispatch("-97014205", new Object[]{this, Integer.valueOf(i)})).intValue() : this.videoStatus != 19 ? i : i - 1;
    }

    public List<GridBean> getGridList(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091665316")) {
            return (List) ipChange.ipc$dispatch("-2091665316", new Object[]{this, Boolean.valueOf(z)});
        }
        List arrayList = new ArrayList();
        if (!cb2.d(this.gridList)) {
            arrayList.addAll(this.gridList);
            int size = arrayList.size();
            if (z && arrayList.size() > 3) {
                List subList = arrayList.subList(0, 3);
                ((GridBean) subList.get(subList.size() - 1)).countRightBottomTag = size - 3;
                arrayList = subList;
            }
            GridBean.ensureItemCountMemberVar(arrayList);
        }
        return arrayList;
    }
}
