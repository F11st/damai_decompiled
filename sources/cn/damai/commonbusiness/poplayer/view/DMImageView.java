package cn.damai.commonbusiness.poplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.common.image.C0504a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMImageView(Context context) {
        super(context);
    }

    public void setImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805389134")) {
            ipChange.ipc$dispatch("805389134", new Object[]{this, str});
        } else {
            C0504a.b().c(str).g(this);
        }
    }

    public DMImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
