package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class yh1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L17;
     */
    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<cn.damai.tetris.v2.common.Node> convert(cn.damai.tetris.core.mtop.BaseResponse r5, cn.damai.tetris.core.BaseSection r6, cn.damai.tetris.core.mtop.GlobalConfig r7, tb.C9039db r8) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.yh1.$ipChange
            java.lang.String r1 = "1504091277"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L23
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r5 = 2
            r2[r5] = r6
            r5 = 3
            r2[r5] = r7
            r5 = 4
            r2[r5] = r8
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.util.List r5 = (java.util.List) r5
            return r5
        L23:
            cn.damai.tetris.core.NodeData r0 = r6.getItem()
            if (r0 == 0) goto L74
            cn.damai.tetris.core.StyleInfo r1 = r6.getStyle()
            cn.damai.tetris.component.drama.bean.CardTitleBean r1 = cn.damai.tetris.component.drama.bean.CardTitleBean.fromTetrisStyle(r1)
            java.lang.String r2 = r1.title
            java.lang.String r3 = "mainTitle"
            r0.put(r3, r2)
            java.lang.String r2 = r1.url
            java.lang.String r3 = "url"
            r0.put(r3, r2)
            java.lang.String r1 = r1.subTitle
            java.lang.String r2 = "moreText"
            r0.put(r2, r1)
            if (r7 == 0) goto L53
            java.lang.String r1 = r7.pageName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L53
            java.lang.String r1 = r7.pageName
            goto L55
        L53:
            java.lang.String r1 = "category_music"
        L55:
            cn.damai.tetris.core.TrackInfo r2 = r6.getTrackInfo()
            if (r2 == 0) goto L68
            java.lang.String r3 = "spmc"
            java.lang.String r2 = r2.getString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L68
            goto L6a
        L68:
            java.lang.String r2 = "hotmusic"
        L6a:
            java.lang.String r3 = "spmB"
            r0.put(r3, r1)
            java.lang.String r1 = "spmC"
            r0.put(r1, r2)
        L74:
            tb.g32 r0 = new tb.g32
            r0.<init>()
            java.util.List r5 = r0.convert(r5, r6, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.yh1.convert(cn.damai.tetris.core.mtop.BaseResponse, cn.damai.tetris.core.BaseSection, cn.damai.tetris.core.mtop.GlobalConfig, tb.db):java.util.List");
    }
}
