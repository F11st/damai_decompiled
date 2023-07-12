package cn.damai.tetris.v2.adpater;

import android.view.View;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.gaiax.GaiaXDefaultModel;
import cn.damai.tetris.gaiax.GaiaXDefaultPresenter;
import cn.damai.tetris.gaiax.GaiaXDefaultView;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VDefaultGenericGaiaXViewHolder extends VGenericGaiaXViewHolder {
    public VDefaultGenericGaiaXViewHolder(View view, IContext iContext) {
        super(view, iContext, null);
        this.d = new GaiaXDefaultPresenter(new GaiaXDefaultView(view), GaiaXDefaultModel.class.getName(), (ja) iContext);
    }
}
