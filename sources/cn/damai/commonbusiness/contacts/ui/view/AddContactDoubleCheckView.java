package cn.damai.commonbusiness.contacts.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddContactDoubleCheckView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mCardNumDataTv;
    private TextView mCardNumTipTv;
    private TextView mCardTypeDataTv;
    private TextView mCardTypeTipTv;
    private TextView mNameDataTv;
    private TextView mNameTipTv;
    private TextView mRenewalNumberDataTv;
    private LinearLayout mRenewalNumberLl;
    private TextView mRenewalNumberTipTv;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        String a;
        String b;

        public void a(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2140327539")) {
                ipChange.ipc$dispatch("-2140327539", new Object[]{this, str});
            } else {
                this.b = str;
            }
        }

        public void b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-266390849")) {
                ipChange.ipc$dispatch("-266390849", new Object[]{this, str});
            } else {
                this.a = str;
            }
        }
    }

    public AddContactDoubleCheckView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452661197")) {
            ipChange.ipc$dispatch("452661197", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.add_contacts_double_check_view, this);
        this.mNameTipTv = (TextView) findViewById(R$id.tv_name_tip);
        this.mNameDataTv = (TextView) findViewById(R$id.tv_name_data);
        this.mCardTypeTipTv = (TextView) findViewById(R$id.tv_card_type_tip);
        this.mCardTypeDataTv = (TextView) findViewById(R$id.tv_card_type_data);
        this.mCardNumTipTv = (TextView) findViewById(R$id.tv_card_num_tips);
        this.mCardNumDataTv = (TextView) findViewById(R$id.tv_card_num_data);
        this.mRenewalNumberLl = (LinearLayout) findViewById(R$id.ll_renewal_number);
        this.mRenewalNumberTipTv = (TextView) findViewById(R$id.tv_renewal_number_tips);
        this.mRenewalNumberDataTv = (TextView) findViewById(R$id.tv_renewal_number_data);
    }

    public void setData(List<a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249773697")) {
            ipChange.ipc$dispatch("-249773697", new Object[]{this, list});
        } else if (list.size() >= 3) {
            this.mNameTipTv.setText(list.get(0).a == null ? "" : list.get(0).a);
            this.mNameDataTv.setText(list.get(0).b == null ? "" : list.get(0).b);
            this.mCardTypeTipTv.setText(list.get(1).a == null ? "" : list.get(1).a);
            this.mCardTypeDataTv.setText(list.get(1).b == null ? "" : list.get(1).b);
            this.mCardNumTipTv.setText(list.get(2).a == null ? "" : list.get(2).a);
            this.mCardNumDataTv.setText(list.get(2).b == null ? "" : list.get(2).b);
            if (list.size() > 3) {
                this.mRenewalNumberLl.setVisibility(0);
                this.mRenewalNumberTipTv.setText(list.get(3).a == null ? "" : list.get(3).a);
                this.mRenewalNumberDataTv.setText(list.get(3).b != null ? list.get(3).b : "");
                return;
            }
            this.mRenewalNumberLl.setVisibility(8);
        }
    }

    public AddContactDoubleCheckView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddContactDoubleCheckView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
