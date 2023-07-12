package tb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.bean.IFeedProjectBean;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ry0 implements OnItemBindListener<IFeedProjectBean<WaterFlowRecommendItem>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private String b;

    public ry0(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
    /* renamed from: a */
    public void exposeItem(View view, IFeedProjectBean<WaterFlowRecommendItem> iFeedProjectBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678702143")) {
            ipChange.ipc$dispatch("678702143", new Object[]{this, view, iFeedProjectBean, Integer.valueOf(i)});
            return;
        }
        WaterFlowRecommendItem raw = iFeedProjectBean.getRaw();
        if (raw != null) {
            MarketTagBean gotTopTag = raw.gotTopTag(true);
            String str = gotTopTag != null ? gotTopTag.type : null;
            py0 I = py0.I();
            String str2 = this.b;
            String str3 = raw.projectId;
            I.X(view, str2, str3, raw.alg, raw.scm, raw.cardType, str3, raw.index, str);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: b */
    public void onItemClick(IFeedProjectBean<WaterFlowRecommendItem> iFeedProjectBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308574644")) {
            ipChange.ipc$dispatch("1308574644", new Object[]{this, iFeedProjectBean, Integer.valueOf(i)});
            return;
        }
        WaterFlowRecommendItem raw = iFeedProjectBean.getRaw();
        if (raw == null || this.a == null) {
            return;
        }
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        py0 I = py0.I();
        String str = this.b;
        String str2 = raw.projectId;
        e.x(I.M(str, str2, raw.alg, raw.scm, raw.cardType, str2, raw.pageNum, raw.index, raw.title, raw.schema));
        if (wh2.j(raw.schema)) {
            Bundle bundle = new Bundle();
            bundle.putString("from_page", "homepage");
            bundle.putString("projectImage", raw.projectPic);
            bundle.putString("id", raw.projectId);
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.b));
            return;
        }
        DMNav.from(this.a).toUri(raw.schema);
    }
}
