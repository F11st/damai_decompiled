package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.util.Log;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.b */
/* loaded from: classes8.dex */
public class C2246b implements SpanClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String b = "b";
    private HtmlParserManager.OnSpanClickListener a;

    public C2246b(HtmlParserManager.OnSpanClickListener onSpanClickListener) {
        this.a = onSpanClickListener;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.SpanClickListener
    public void onSpanClick(int i, String str) {
        HtmlParserManager.OnSpanClickListener onSpanClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223544406")) {
            ipChange.ipc$dispatch("-1223544406", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        String str2 = b;
        Log.d(str2, "span click type is " + i + " source is:" + str);
        if (i == 14 && (onSpanClickListener = this.a) != null) {
            onSpanClickListener.onSpanClick(0, str);
        }
    }
}
