package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TrueLoveMedalView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView mTrueLoveBgIv;
    private TextView mTrueLoveLevelTv;
    private TextView mTrueLoveNameTv;

    public TrueLoveMedalView(Context context) {
        this(context, null);
    }

    private String getTrueLoveLevelFromId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040253065")) {
            return (String) ipChange.ipc$dispatch("1040253065", new Object[]{this, Integer.valueOf(i)});
        }
        int i2 = i - 817;
        return i2 >= 1 ? String.valueOf(i2) : String.valueOf(1);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627114114")) {
            ipChange.ipc$dispatch("-627114114", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ykl_truelove_medal, (ViewGroup) this, true);
        this.mTrueLoveBgIv = (ImageView) findViewById(R.id.truelove_bg_iv);
        this.mTrueLoveLevelTv = (TextView) findViewById(R.id.truelove_level_tv);
        this.mTrueLoveNameTv = (TextView) findViewById(R.id.truelove_name_tv);
    }

    public void setData(BitmapDrawable bitmapDrawable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271649666")) {
            ipChange.ipc$dispatch("-271649666", new Object[]{this, bitmapDrawable, str});
        } else if (bitmapDrawable == null || TextUtils.isEmpty(str)) {
        } else {
            this.mTrueLoveBgIv.setImageDrawable(bitmapDrawable);
            this.mTrueLoveLevelTv.setText("");
            this.mTrueLoveNameTv.setText(str);
        }
    }

    public TrueLoveMedalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrueLoveMedalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
