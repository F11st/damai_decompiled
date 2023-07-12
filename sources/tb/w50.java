package tb;

import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.tetris.R$id;
import cn.damai.tetris.R$layout;
import cn.damai.tetris.core.BaseLayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class w50 extends a1<BaseLayer> {
    private static transient /* synthetic */ IpChange $ipChange;

    public w50(ViewGroup viewGroup, int i) {
        super(viewGroup, i);
    }

    @Override // tb.a1
    public int b(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1672471763") ? ((Integer) ipChange.ipc$dispatch("-1672471763", new Object[]{this, Integer.valueOf(i)})).intValue() : R$layout.tetris_core_defalut_layer_wrapper;
    }

    @Override // tb.a1
    public ViewGroup c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891778543")) {
            return (ViewGroup) ipChange.ipc$dispatch("-891778543", new Object[]{this, Integer.valueOf(i)});
        }
        return null;
    }

    @Override // tb.a1
    public void e(BaseLayer baseLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246008946")) {
            ipChange.ipc$dispatch("-1246008946", new Object[]{this, baseLayer});
            return;
        }
        if (baseLayer.getStyle() != null) {
            int i = baseLayer.getStyle().padding;
            d().setPadding(i, i, i, i);
        }
        TextView textView = (TextView) d().findViewById(R$id.tetris_layer_wrapper_title);
        if (textView != null) {
            if (baseLayer.getItem() != null) {
                String string = baseLayer.getItem().getString("title");
                if (string != null && !string.isEmpty()) {
                    textView.setVisibility(0);
                    textView.setText(string);
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(8);
        }
    }
}
