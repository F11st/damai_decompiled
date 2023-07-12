package cn.damai.tetris.component.brand;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import cn.damai.tetris.component.brand.bean.BrandHeaderInfoBean;
import cn.damai.tetris.component.brand.bean.CommonCard;
import cn.damai.tetris.component.brand.bean.ProjectVideoBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface BrandHeaderContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        ActivityInfo getActivityDO();

        List<CommonCard> getCoupons();

        BrandHeaderInfoBean getHeaderInfo();

        List<ProjectVideoBean> getProjectVideoBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        AttentionView getAttentionView();

        android.view.View getCover();

        TextView getDesc2();

        ImageView getHeader();

        ImageView getImgBg();

        ImageView getImgBg1();

        ImageView getImgBg2();

        MagicIndicator getIndicator();

        RecyclerView getRecyclerView();

        android.view.View getShareBtn();

        TextView getSubTitle();

        TextView getTitle();

        DmViewPager getViewPager();
    }
}
