package cn.damai.message.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.message.bean.MessageGroupResponse;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface MessageGroupContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void getMessageGroupList(Map<String, String> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        void returnMessageGroupListFailure(String str, String str2);

        void returnMessageGroupListSuccess(MessageGroupResponse messageGroupResponse);
    }
}
