package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BigGiftNumLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_COLUMN = 5;
    private LinearLayout mNumGroup;

    public BigGiftNumLayout(Context context) {
        this(context, null);
    }

    private int getNumResId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993685850")) {
            return ((Integer) ipChange.ipc$dispatch("-1993685850", new Object[]{this, str})).intValue();
        }
        switch (ParseUtils.parse2Int(str)) {
            case 0:
                return R.C7941drawable.dago_pgc_frameanim_count_num0;
            case 1:
                return R.C7941drawable.dago_pgc_frameanim_count_num1;
            case 2:
                return R.C7941drawable.dago_pgc_frameanim_count_num2;
            case 3:
                return R.C7941drawable.dago_pgc_frameanim_count_num3;
            case 4:
                return R.C7941drawable.dago_pgc_frameanim_count_num4;
            case 5:
                return R.C7941drawable.dago_pgc_frameanim_count_num5;
            case 6:
                return R.C7941drawable.dago_pgc_frameanim_count_num6;
            case 7:
                return R.C7941drawable.dago_pgc_frameanim_count_num7;
            case 8:
                return R.C7941drawable.dago_pgc_frameanim_count_num8;
            case 9:
                return R.C7941drawable.dago_pgc_frameanim_count_num9;
            default:
                return -1;
        }
    }

    public void setNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212388836")) {
            ipChange.ipc$dispatch("-212388836", new Object[]{this, str});
            return;
        }
        char[] charArray = str.toCharArray();
        int dip2px = DensityUtil.dip2px(getContext(), 1.0f);
        for (int i = 0; i < charArray.length; i++) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-bignum", "numChar.length = " + charArray[i]);
            int numResId = getNumResId(String.valueOf(charArray[i]));
            ((ILog) Dsl.getService(ILog.class)).d("liulei-bignum", "numChar.length id = " + numResId);
            if (numResId > 0) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(numResId);
                ((ILog) Dsl.getService(ILog.class)).d("liulei-bignum", "setImageResource");
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px * 24, dip2px * 23);
                layoutParams.bottomMargin = dip2px * 8;
                this.mNumGroup.addView(imageView, layoutParams);
                ((ILog) Dsl.getService(ILog.class)).d("liulei-bignum", "addView 44444");
            }
        }
    }

    public BigGiftNumLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BigGiftNumLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_big_gift_num_layout, (ViewGroup) this, true);
        this.mNumGroup = (LinearLayout) findViewById(R.id.id_num_group);
    }
}
