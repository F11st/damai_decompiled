package cn.damai.projectfiltercopy.floatview;

import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.bean.Type;
import tb.kj0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface FloatLayer<T> {
    kj0 getFilterUt();

    FloatListener getListener();

    Type getType();

    View getView();

    void hide();

    void setFilterUt(kj0 kj0Var);

    void setListener(FloatListener floatListener);

    void show(@Nullable T t);
}
