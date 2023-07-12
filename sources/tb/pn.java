package tb;

import android.content.Context;
import android.view.View;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.view.DMTagView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class pn extends cp2<DmInfo> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DMTagView d;
    @Nullable
    private View e;

    public pn(@Nullable Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1131506144") ? ((Integer) ipChange.ipc$dispatch("1131506144", new Object[]{this})).intValue() : R$layout.live_content_detail_dm;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085530195")) {
            ipChange.ipc$dispatch("-1085530195", new Object[]{this});
            return;
        }
        this.d = (DMTagView) this.b.findViewById(R$id.dm_tag_view);
        this.e = this.b.findViewById(R$id.live_content_dm_layout);
    }

    public void d(@Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578267161")) {
            ipChange.ipc$dispatch("578267161", new Object[]{this, dmInfo});
        } else if (dmInfo == null) {
            c(false);
        } else {
            View view = this.e;
            b41.f(view);
            view.setTag(dmInfo);
            DMTagView dMTagView = this.d;
            b41.f(dMTagView);
            dMTagView.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName);
            ArrayList<String> arrayList = dmInfo.dmTags;
            if (arrayList != null) {
                DMTagView dMTagView2 = this.d;
                b41.f(dMTagView2);
                dMTagView2.setDmTagData(arrayList);
            }
            c(true);
        }
    }

    @Override // tb.cp2, android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267460947")) {
            ipChange.ipc$dispatch("267460947", new Object[]{this, view});
            return;
        }
        b41.i(view, "v");
        super.onClick(view);
    }
}
