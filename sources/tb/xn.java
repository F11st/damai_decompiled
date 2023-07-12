package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xn extends cp2<ContentDetail> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView d;
    private View e;

    public xn(Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833303570") ? ((Integer) ipChange.ipc$dispatch("1833303570", new Object[]{this})).intValue() : R$layout.live_content_detail_text;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504980257")) {
            ipChange.ipc$dispatch("-504980257", new Object[]{this});
            return;
        }
        this.e = this.b.findViewById(R$id.live_content_detail_highlight_tag);
        this.d = (TextView) this.b.findViewById(R$id.live_content_detail_text);
    }

    public void d(ContentDetail contentDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656951066")) {
            ipChange.ipc$dispatch("-1656951066", new Object[]{this, contentDetail});
        } else if (contentDetail == null) {
            c(false);
        } else {
            ArrayList<ContentDetail.ContentText> arrayList = contentDetail.content;
            if (arrayList != null && wh2.e(arrayList) > 0 && arrayList.get(0) != null && !TextUtils.isEmpty(arrayList.get(0).value)) {
                ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    if (TextUtils.isEmpty(contentDetail.relateTitle)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m62.a(mu0.a(), 15.0f);
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m62.a(mu0.a(), 9.0f);
                    }
                }
                this.d.setText(arrayList.get(0).value.replaceAll("\n{2,}", StringUtils.LF).trim());
                this.e.setVisibility(contentDetail.isFeature() ? 0 : 8);
                c(true);
                return;
            }
            c(false);
        }
    }
}
