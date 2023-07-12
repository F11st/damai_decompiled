package cn.damai.evaluate.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMEvaluateProjectCardView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private DMPosterView ivProjectImage;
    private TextView tvProjectDesc;
    private TextView tvProjectName;

    public DMEvaluateProjectCardView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934602723")) {
            ipChange.ipc$dispatch("-934602723", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.evaluate_project_layout, this);
        this.ivProjectImage = (DMPosterView) inflate.findViewById(R$id.evaluate_project_image);
        this.tvProjectName = (TextView) inflate.findViewById(R$id.evaluate_project_name);
        this.tvProjectDesc = (TextView) inflate.findViewById(R$id.evaluate_project_desc);
    }

    public void setData(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195925866")) {
            ipChange.ipc$dispatch("1195925866", new Object[]{this, str, str2, str3});
        } else {
            setData(str, str2, str3, 0);
        }
    }

    public DMEvaluateProjectCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setData(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580974375")) {
            ipChange.ipc$dispatch("-1580974375", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        if (i == 1) {
            this.ivProjectImage.getLayoutParams().width = q60.a(this.context, 41.0f);
            this.ivProjectImage.getLayoutParams().height = q60.a(this.context, 41.0f);
            this.ivProjectImage.setImageDrawable(getResources().getDrawable(R$drawable.store_defult_img));
        } else if (i == 2) {
            this.ivProjectImage.getLayoutParams().width = q60.a(this.context, 41.0f);
            this.ivProjectImage.getLayoutParams().height = q60.a(this.context, 55.0f);
            this.ivProjectImage.setImageDrawable(getResources().getDrawable(R$drawable.uikit_default_image_bg_grey));
        } else {
            this.ivProjectImage.getLayoutParams().width = q60.a(this.context, 32.0f);
            this.ivProjectImage.getLayoutParams().height = q60.a(this.context, 42.0f);
            this.ivProjectImage.setPlaceholder(R$drawable.uikit_default_image_bg_grey);
        }
        this.ivProjectImage.requestLayout();
        this.ivProjectImage.setImageUrl(str);
        this.tvProjectName.setText(str2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tvProjectName.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            if (this.tvProjectDesc.getVisibility() == 8) {
                if (layoutParams != null) {
                    layoutParams.removeRule(15);
                    layoutParams.addRule(10);
                }
                this.tvProjectDesc.setVisibility(0);
            }
            this.tvProjectDesc.setText(str3);
        } else if (this.tvProjectDesc.getVisibility() == 0) {
            if (layoutParams != null) {
                layoutParams.removeRule(10);
                layoutParams.addRule(15);
            }
            this.tvProjectDesc.setVisibility(8);
        }
    }

    public DMEvaluateProjectCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
