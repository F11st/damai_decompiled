package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.KeyBoardBean;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftKeyBoardAdapter extends MultiItemCommonAdapter<KeyBoardBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public GiftKeyBoardAdapter(Context context, List<KeyBoardBean> list) {
        super(context, list, new MultiItemTypeSupport<KeyBoardBean>() { // from class: com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftKeyBoardAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.MultiItemTypeSupport
            public int getViewTypeCount() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1087067926")) {
                    return ((Integer) ipChange.ipc$dispatch("-1087067926", new Object[]{this})).intValue();
                }
                return 3;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.MultiItemTypeSupport
            public int getItemViewType(int i, KeyBoardBean keyBoardBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1700382311")) {
                    return ((Integer) ipChange.ipc$dispatch("1700382311", new Object[]{this, Integer.valueOf(i), keyBoardBean})).intValue();
                }
                int i2 = keyBoardBean.type;
                if (i2 == 0) {
                    return 0;
                }
                return i2 == 1 ? 1 : 2;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.MultiItemTypeSupport
            public int getLayoutId(int i, KeyBoardBean keyBoardBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-910026918")) {
                    return ((Integer) ipChange.ipc$dispatch("-910026918", new Object[]{this, Integer.valueOf(i), keyBoardBean})).intValue();
                }
                int i2 = keyBoardBean.type;
                if (i2 == 0) {
                    return R.layout.dago_pgc_ykl_send_gift_keyboard_num_0;
                }
                if (i2 == 1) {
                    return R.layout.dago_pgc_ykl_send_gift_keyboard_num_1;
                }
                return R.layout.dago_pgc_ykl_send_gift_keyboard_num_2;
            }
        });
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter
    public void convert(CommonViewHolder commonViewHolder, int i, KeyBoardBean keyBoardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1352920764")) {
            ipChange.ipc$dispatch("1352920764", new Object[]{this, commonViewHolder, Integer.valueOf(i), keyBoardBean});
        } else if (commonViewHolder.getLayoutId() == R.layout.dago_pgc_ykl_send_gift_keyboard_num_0) {
            ((TextView) commonViewHolder.getView(R.id.id_tv)).setText(keyBoardBean.name);
            View view = commonViewHolder.getView(R.id.id_v_sp);
            int i2 = (i + 1) % 3;
            if (i2 == 0) {
                if (i != getCount() - 1) {
                    view.setVisibility(8);
                    return;
                } else if (i2 == 0) {
                    view.setVisibility(8);
                    return;
                } else {
                    view.setVisibility(0);
                    return;
                }
            }
            view.setVisibility(0);
        } else if (commonViewHolder.getLayoutId() == R.layout.dago_pgc_ykl_send_gift_keyboard_num_1) {
            View view2 = commonViewHolder.getView(R.id.id_v_sp);
            int i3 = (i + 1) % 3;
            if (i3 == 0) {
                if (i != getCount() - 1) {
                    view2.setVisibility(8);
                    return;
                } else if (i3 == 0) {
                    view2.setVisibility(8);
                    return;
                } else {
                    view2.setVisibility(0);
                    return;
                }
            }
            view2.setVisibility(0);
        } else if (commonViewHolder.getLayoutId() == R.layout.dago_pgc_ykl_send_gift_keyboard_num_2) {
            View view3 = commonViewHolder.getView(R.id.id_v_sp);
            int i4 = (i + 1) % 3;
            if (i4 == 0) {
                if (i != getCount() - 1) {
                    view3.setVisibility(8);
                    return;
                } else if (i4 == 0) {
                    view3.setVisibility(8);
                    return;
                } else {
                    view3.setVisibility(0);
                    return;
                }
            }
            view3.setVisibility(0);
        }
    }
}
