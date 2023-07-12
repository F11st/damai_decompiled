package com.alibaba.pictures.bricks.component.script.more;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.footer.SectionFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ScriptFooterView extends SectionFooterView {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;

    public ScriptFooterView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R$id.footer_content);
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterView, com.alibaba.pictures.bricks.component.footer.SectionFooterContract.View
    public void renderContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1837755397")) {
            ipChange.ipc$dispatch("1837755397", new Object[]{this, str});
        } else {
            this.content.setText(str);
        }
    }
}
