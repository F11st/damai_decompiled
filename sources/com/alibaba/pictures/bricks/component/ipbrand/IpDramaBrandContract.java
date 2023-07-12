package com.alibaba.pictures.bricks.component.ipbrand;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.alibaba.pictures.bricks.bean.IpDramaBrandArchBean;
import com.alibaba.pictures.bricks.bean.VideoAlbum;
import com.alibaba.pictures.bricks.component.artist.BaccountInfo;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpDramaBrandContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        IpDramaBrandArchBean getIpDramaBrandArchBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void artistTrackClick(String str, int i);

        void artistTrackExpose(android.view.View view, String str, int i);

        void contentTrackClick(String str);

        void contentTrackExpose(String str);

        void gotoIpDramaBrandPage();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface View extends IContract.View {
        void artistView(String str, ArrayList<BaccountInfo> arrayList);

        RelativeLayout getContentLayout();

        LinearLayout getTopLayout();

        void informationView(String str, ArrayList<VideoAlbum> arrayList);

        void ipBrandCenterView(IpDramaBrandArchBean ipDramaBrandArchBean);

        void ipBrandLeftView(String str, String str2, boolean z);

        void ipBrandRightView(String str, String str2);

        void setBottomLine(boolean z);
    }
}
