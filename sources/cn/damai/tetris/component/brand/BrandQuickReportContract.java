package cn.damai.tetris.component.brand;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.tetris.component.brand.bean.BrandQuickReportContentBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import cn.damai.uikit.view.DMPosterView;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface BrandQuickReportContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        String getBrandNew();

        ArrayList<BrandQuickReportContentBean> getContents();

        String getLatestPublishTimeStr();

        String getSchema();

        String getTotal();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        android.view.View getBlackHolder();

        RelativeLayout getBrandLayout();

        TextView getBrandNew();

        LinearLayout getLlMore();

        RelativeLayout getNormalItemOne();

        DMPosterView getNormalItemOneImg();

        TextView getNormalItemOneIpvuv();

        TextView getNormalItemOneTitle();

        RelativeLayout getNormalItemTwo();

        DMPosterView getNormalItemTwoImg();

        TextView getNormalItemTwoIpvuv();

        TextView getNormalItemTwoTitle();

        DMPosterView getSpecialImg();

        TextView getSpecialIpvuv();

        RelativeLayout getSpecialItem();

        TextView getSpecialTitle();

        TextView getUpdateTime();

        TextView getUpdateTimePoint();
    }
}
