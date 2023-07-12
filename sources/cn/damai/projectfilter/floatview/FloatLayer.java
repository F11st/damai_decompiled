package cn.damai.projectfilter.floatview;

import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.bean.Type;
import tb.lj0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface FloatLayer<T> {
    lj0 getFilterUt();

    FloatListener getListener();

    Type getType();

    View getView();

    void hide();

    void setFilterUt(lj0 lj0Var);

    void setListener(FloatListener floatListener);

    void show(@Nullable T t);
}
