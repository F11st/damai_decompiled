package cn.damai.trade;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.model.TrackInfoList;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListBean;
import cn.damai.trade.newtradeorder.ui.orderlist.net.OrderRefundRequest;
import cn.damai.trade.refund.model.Refund;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cm2;
import tb.m62;
import tb.wh2;
import tb.zo1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RefundActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView choose_seat_icon;
    private ImageView iv_project_image;
    private LinearLayout ll_trace;
    private LinearLayout ll_trace_info;
    private StringBuilder mBuilder = new StringBuilder();
    private OrderListBean mOrderBean;
    private TextView mOrderCodeTv;
    private TextView mPlayTimeTv;
    private TextView mProjectNameTv;
    private TextView tv_ticket_num;
    private TextView tv_total_money;

    private void loadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974891386")) {
            ipChange.ipc$dispatch("1974891386", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.mOrderBean = (OrderListBean) intent.getParcelableExtra("order");
        }
        if (this.mOrderBean != null) {
            TextView textView = this.mOrderCodeTv;
            int i = R$string.damai_refund_order_number;
            textView.setText(cm2.c(this, i, "" + this.mOrderBean.orderId));
            this.mProjectNameTv.setText(this.mOrderBean.projectName);
            this.mPlayTimeTv.setText(this.mOrderBean.playTime);
            this.iv_project_image.setTag(this.mOrderBean.projectPicUrl);
            C0504a.b().c(this.mOrderBean.projectPicUrl).g(this.iv_project_image);
            this.tv_ticket_num.setText(String.valueOf(this.mOrderBean.quantity));
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
            this.mBuilder.append("¥");
            this.mBuilder.append(this.mOrderBean.totalAmount);
            this.tv_total_money.setText(this.mBuilder.toString());
            this.iv_project_image.setBackgroundColor(16777215);
            this.iv_project_image.setImageBitmap(null);
            if (this.mOrderBean.selfPre != null) {
                this.choose_seat_icon.setVisibility(0);
            } else {
                this.choose_seat_icon.setVisibility(8);
            }
            getRefundProgress();
        }
    }

    private void loadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985924255")) {
            ipChange.ipc$dispatch("985924255", new Object[]{this});
            return;
        }
        this.mOrderCodeTv = (TextView) findViewById(R$id.tv_order_code);
        this.iv_project_image = (ImageView) findViewById(R$id.iv_project_image);
        this.choose_seat_icon = (TextView) findViewById(R$id.choose_seat_icon);
        this.mProjectNameTv = (TextView) findViewById(R$id.tv_project_name);
        this.tv_ticket_num = (TextView) findViewById(R$id.tv_ticket_num);
        this.tv_total_money = (TextView) findViewById(R$id.tv_total_money);
        this.mPlayTimeTv = (TextView) findViewById(R$id.tv_yanchu_time);
        this.ll_trace_info = (LinearLayout) findViewById(R$id.ll_trace_info);
        this.ll_trace = (LinearLayout) findViewById(R$id.ll_trace);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1847633496") ? ((Integer) ipChange.ipc$dispatch("1847633496", new Object[]{this})).intValue() : R$layout.refund_activity;
    }

    public void getRefundProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162304827")) {
            ipChange.ipc$dispatch("-1162304827", new Object[]{this});
            return;
        }
        onLoadStart();
        OrderRefundRequest orderRefundRequest = new OrderRefundRequest();
        orderRefundRequest.id = String.valueOf(this.mOrderBean.orderId);
        orderRefundRequest.sign = zo1.a(zo1.c(String.valueOf(this.mOrderBean.orderId)));
        orderRefundRequest.request(new DMMtopRequestListener<Refund>(Refund.class) { // from class: cn.damai.trade.RefundActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "647963278")) {
                    ipChange2.ipc$dispatch("647963278", new Object[]{this, str, str2});
                    return;
                }
                RefundActivity.this.onLoadFinish();
                if (TextUtils.isEmpty(str2)) {
                    ToastUtil.a().g(RefundActivity.this);
                } else {
                    ToastUtil.i(str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(Refund refund) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-597497841")) {
                    ipChange2.ipc$dispatch("-597497841", new Object[]{this, refund});
                    return;
                }
                RefundActivity.this.onLoadFinish();
                RefundActivity.this.loadRefundProgress(refund);
            }
        });
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1476214987")) {
            ipChange.ipc$dispatch("-1476214987", new Object[]{this});
            return;
        }
        super.initView();
        loadView();
        loadData();
    }

    public void loadRefundProgress(Refund refund) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103699455")) {
            ipChange.ipc$dispatch("1103699455", new Object[]{this, refund});
        } else if (refund != null && wh2.e(refund.trackInfoList) > 0) {
            this.ll_trace_info.removeAllViews();
            int e = wh2.e(refund.trackInfoList) - 1;
            for (int i = e; i > -1; i--) {
                View inflate = this.mInflater.inflate(R$layout.order_refund_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_time);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_line);
                TextView textView3 = (TextView) inflate.findViewById(R$id.tv_trace_detail);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_trace_flow_icon);
                TrackInfoList trackInfoList = refund.trackInfoList.get(i);
                textView3.setText(trackInfoList.Info);
                textView.setText(trackInfoList.Time);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ImageView) inflate.findViewById(R$id.iv_line)).getLayoutParams();
                if (i == e) {
                    layoutParams.setMargins(0, m62.a(this, 36.0f), 0, 0);
                    imageView.setBackgroundResource(R$drawable.refund_greendot_pic_3x);
                    textView.setTextColor(-8404632);
                    textView3.setTextColor(-8404632);
                } else {
                    layoutParams.setMargins(0, 0, 0, 0);
                    imageView.setBackgroundResource(R$drawable.refund_graydot_pic_3x);
                    textView.setTextColor(-7303024);
                    textView3.setTextColor(-7303024);
                }
                if (i == 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                }
                this.ll_trace_info.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
            }
            this.ll_trace.setVisibility(0);
        } else {
            this.ll_trace.setVisibility(8);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1859874100") ? (String) ipChange.ipc$dispatch("-1859874100", new Object[]{this}) : cm2.b(this, R$string.damai_refund_progress_refund_title);
    }
}
