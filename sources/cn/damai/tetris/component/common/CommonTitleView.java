package cn.damai.tetris.component.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.CommonTitleContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CommonTitleView extends AbsView<CommonTitleContract.Presenter> implements CommonTitleContract.View<CommonTitleContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView mTipTv;
    private View morell;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.CommonTitleView$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1799a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC1799a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1652235122")) {
                ipChange.ipc$dispatch("-1652235122", new Object[]{this, view});
            } else {
                NavProxy.from(CommonTitleView.this.getContext().getActivity()).toUri(Uri.parse(this.a));
            }
        }
    }

    public CommonTitleView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mTipTv = (TextView) view.findViewById(R$id.tv_project_tip);
        this.morell = view.findViewById(R$id.common_title_morell);
    }

    @Override // cn.damai.tetris.component.common.CommonTitleContract.View
    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649186881")) {
            ipChange.ipc$dispatch("1649186881", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.morell.setVisibility(0);
            this.morell.setOnClickListener(new View$OnClickListenerC1799a(str));
        } else {
            this.morell.setVisibility(8);
        }
    }

    @Override // cn.damai.tetris.component.common.CommonTitleContract.View
    public void setTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114102753")) {
            ipChange.ipc$dispatch("114102753", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mTipTv.setText(str);
        }
    }
}
