package cn.damai.tetris.core;

import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.msg.IMessage;
import cn.damai.tetris.v2.structure.section.ISection;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IPresenter<M extends IModel, V extends IView, N extends BaseNode> extends IMessage {
    public static final int SYSTEM_MSG_DESTORY = 11004;
    public static final int SYSTEM_MSG_PAUSE = 11003;
    public static final int SYSTEM_MSG_RESUME = 11005;
    public static final int SYSTEM_MSG_START = 11002;
    public static final int SYSTEM_MSG_VISIBLEHINT = 11001;

    M createModel(N n);

    ja getContext();

    M getModel();

    ISection getSection();

    void init();

    void setSection(ISection iSection);

    void setView(V v);
}
