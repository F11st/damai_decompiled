package cn.damai.seat.contract;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.HeadBean;
import java.util.List;
import tb.g92;
import tb.sm1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface BaseSeatView {
    boolean dismissFragment(Fragment fragment, ViewGroup viewGroup);

    ViewGroup getFragmentContainer();

    ViewGroup getMainView();

    void hideErrorView();

    boolean isErrorPageShown();

    void showBottomToast(String str);

    void showErrorTips(String str);

    void showErrorView(String str, String str2, String str3, sm1 sm1Var);

    void showFragment(Fragment fragment, ViewGroup viewGroup);

    void showHeader(@NonNull HeadBean headBean);

    void showLoading(boolean z);

    void showPriceList(List<? extends PriceLevel> list, g92 g92Var, PriceLevel priceLevel);

    void showPromotionFragment(PromotionDataBean promotionDataBean);
}
