package cn.damai.homepage.ui.dynamicx.tagview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMDXHomeTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView tagName;

    public DMDXHomeTagView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62834766")) {
            ipChange.ipc$dispatch("62834766", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.homepage_menu_tag, this);
        this.tagName = (TextView) findViewById(R$id.homepage_menu_item_tag);
    }

    public void setTagName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996727402")) {
            ipChange.ipc$dispatch("-1996727402", new Object[]{this, str});
            return;
        }
        TextView textView = this.tagName;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTagNameTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1979369947")) {
            ipChange.ipc$dispatch("1979369947", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.tagName;
        if (textView == null || i == 0) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setTagNameTextSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262758747")) {
            ipChange.ipc$dispatch("-262758747", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.tagName;
        if (textView == null || i <= 0) {
            return;
        }
        textView.setTextSize(i);
    }

    public DMDXHomeTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMDXHomeTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
