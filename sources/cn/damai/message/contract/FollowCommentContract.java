package cn.damai.message.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.message.bean.MessageList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface FollowCommentContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void getMessageItemList(Map<String, String> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        void followCommentNotify(String str);

        void returnMessageItemListFailures(String str, String str2);

        void returnMessageItemListSuccess(MessageList messageList);
    }
}
