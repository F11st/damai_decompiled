package com.alibaba.pictures.bricks.component.artist;

import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        BaccountInfo getArtist();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void gotoHome();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface View extends IContract.View {
        void renderArtistAvatar(String str);

        void renderArtistName(String str);

        void renderFansCount(String str);

        void renderPerformanceCount(int i);
    }
}
