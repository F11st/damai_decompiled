package com.youku.live.dago.widgetlib.interactive.gift.lottery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class OtherPersonLotteryTextView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView mLotteryTimeView;

    public OtherPersonLotteryTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061094801")) {
            ipChange.ipc$dispatch("2061094801", new Object[]{this});
            return;
        }
        LayoutInflater.from(this.mContext).inflate(R.layout.dago_pgc_gift_lottery_other_person_text_layout, this);
        this.mLotteryTimeView = (TextView) findViewById(R.id.lottery_times_text);
    }

    public void display(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1866217762")) {
            ipChange.ipc$dispatch("1866217762", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.mLotteryTimeView.setText(String.format("中%1$d倍大奖 x %2$d个", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public OtherPersonLotteryTextView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }
}
