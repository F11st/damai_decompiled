package cn.damai.message.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.message.bean.MessageList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface MessageContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void deleteMessage(Map<String, String> map);

        public abstract void getMessageItemList(Map<String, String> map, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        void deleteMessageFailure(String str, String str2);

        void deleteMessageSuccess();

        void returnMessageItemListFailures(String str, String str2);

        void returnMessageItemListSuccess(MessageList messageList);
    }
}
