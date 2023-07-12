package cn.damai.tetris.component.brand;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import cn.damai.tetris.component.brand.bean.BrandInfoBean;
import cn.damai.tetris.component.brand.bean.IpBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import cn.damai.uikit.view.round.RoundImageView2;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface BrandIpContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        ArrayList<IpBean> getBeanList();

        BrandInfoBean getBrandInfo();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup get2ItemView();

        ViewGroup get3ItemView();

        android.view.View getDynNews();

        ViewFlipper getFlipper();

        ImageView getHeader();

        RoundImageView2 getImgBg();

        TextView getSubTitle();

        TextView getTitle();
    }
}
