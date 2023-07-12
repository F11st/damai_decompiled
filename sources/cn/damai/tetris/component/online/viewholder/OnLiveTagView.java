package cn.damai.tetris.component.online.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OnLiveTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mLiveName;
    private RelativeLayout mLiveTagLayout;

    public OnLiveTagView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599657339")) {
            ipChange.ipc$dispatch("1599657339", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.onlive_tag_view, this);
        this.mLiveName = (TextView) findViewById(R$id.online_tag_view_name);
        this.mLiveTagLayout = (RelativeLayout) findViewById(R$id.online_tag_layout);
    }

    public void setLiveType(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891747764")) {
            ipChange.ipc$dispatch("1891747764", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.mLiveName;
        if (textView != null) {
            if (z) {
                textView.setText("直播");
                this.mLiveTagLayout.setBackgroundResource(R$drawable.onlive_ing_tag);
                return;
            }
            textView.setText("回看");
            this.mLiveTagLayout.setBackgroundResource(R$drawable.onlive_playback_tag);
        }
    }

    public OnLiveTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        initView(context);
    }

    public OnLiveTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
