package tb;

import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.wannasee.bean.TimeLineStyle;
import cn.damai.commonbusiness.wannasee.viewholder.TimeLineDecorate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ao2 implements TimeLineDecorate {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private TextView c;

    public ao2(View view) {
        View findViewById = view.findViewById(R$id.id_time_line_layout);
        this.b = findViewById.findViewById(R$id.time_line_top);
        this.a = findViewById.findViewById(R$id.time_line_bottom);
        this.c = (TextView) findViewById.findViewById(R$id.time_line_title);
    }

    @Override // cn.damai.commonbusiness.wannasee.viewholder.TimeLineDecorate
    public void setTimeStyle(TimeLineStyle timeLineStyle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156582558")) {
            ipChange.ipc$dispatch("1156582558", new Object[]{this, timeLineStyle});
        } else if (timeLineStyle == null) {
        } else {
            this.b.setVisibility(timeLineStyle.isFirst ? 4 : 0);
            this.c.setText(timeLineStyle.title);
        }
    }
}
