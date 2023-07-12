package cn.damai.onearch.component.banner;

import com.youku.arch.v3.adapter.VBaseAdapter;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface LoopBannerContract {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Presenter {
        void onPageChanged(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface View {
        void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter);
    }
}
