package cn.damai.uikit.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMCertInfoTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] backGround;
    private LinearLayout mBackground;
    private TextView mContent;
    private int position;
    private int stylePointer;
    private int[] textColor;
    private float[] textSize;

    public DMCertInfoTagView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548046399")) {
            ipChange.ipc$dispatch("-1548046399", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.cert_info_tag_layout, this);
        this.mBackground = (LinearLayout) findViewById(R$id.cert_info_tag_layout);
        this.mContent = (TextView) findViewById(R$id.homepage_tv_title_cert_info);
    }

    private void updateStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132587651")) {
            ipChange.ipc$dispatch("-2132587651", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mContent.setTextSize(2, this.textSize[i]);
        this.mContent.setTextColor(getResources().getColor(this.textColor[i]));
        this.mBackground.setBackgroundResource(this.backGround[i]);
        invalidate();
    }

    public void setPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1722883904")) {
            ipChange.ipc$dispatch("1722883904", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = (i & 1) + i;
        int i3 = i2 <= 3 ? i2 : 0;
        this.stylePointer = i3;
        this.mContent.setTextSize(2, this.textSize[i3]);
        updateStyle(this.stylePointer);
    }

    public void setWhiteMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392426530")) {
            ipChange.ipc$dispatch("1392426530", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int i = this.stylePointer;
        if (z) {
            i++;
        }
        updateStyle(i);
    }

    public DMCertInfoTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMCertInfoTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textSize = new float[]{10.0f, 10.0f, 7.0f, 7.0f};
        int i2 = R$color.color_9c9ca5;
        this.textColor = new int[]{i2, R$color.color_ccffffff, i2, R$color.color_ffffff};
        this.backGround = new int[]{R$drawable.cert_info_tag, R$drawable.cert_info_white_tag, R$drawable.cert_info_tag_left, R$drawable.cert_info_white_tag_left};
        this.stylePointer = 0;
        initView(context);
    }
}
