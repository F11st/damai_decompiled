package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class yn extends cp2<ContentTour.ContentTopic> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView d;
    private View e;

    public yn(Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2004716392") ? ((Integer) ipChange.ipc$dispatch("2004716392", new Object[]{this})).intValue() : R$layout.live_content_detail_theme;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125191477")) {
            ipChange.ipc$dispatch("125191477", new Object[]{this});
            return;
        }
        this.d = (TextView) this.b.findViewById(R$id.live_content_detail_theme);
        View findViewById = this.b.findViewById(R$id.live_content_theme_layout);
        this.e = findViewById;
        findViewById.setOnClickListener(this);
    }

    public void d(ContentTour.ContentTopic contentTopic) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802746445")) {
            ipChange.ipc$dispatch("1802746445", new Object[]{this, contentTopic});
        } else if (contentTopic != null && !TextUtils.isEmpty(contentTopic.name)) {
            this.e.setTag(contentTopic);
            this.d.setText(contentTopic.name);
            getLiveUt().o(this.d, contentTopic.name, contentTopic.id);
            c(true);
        } else {
            c(false);
        }
    }

    @Override // tb.cp2, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702674123")) {
            ipChange.ipc$dispatch("1702674123", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        ContentTour.ContentTopic contentTopic = (ContentTour.ContentTopic) view.getTag();
        if (contentTopic == null) {
            return;
        }
        cn.damai.common.user.c.e().x(getLiveUt().H(contentTopic.name, contentTopic.id));
        Bundle bundle = new Bundle();
        bundle.putString("themeId", contentTopic.id);
        DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_THEME));
    }
}
