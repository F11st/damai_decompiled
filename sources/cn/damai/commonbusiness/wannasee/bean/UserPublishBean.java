package cn.damai.commonbusiness.wannasee.bean;

import cn.damai.user.userhome.bean.MinepublishCheckBean;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UserPublishBean implements Serializable {
    public MinepublishCheckBean target;

    public UserPublishBean(MinepublishCheckBean minepublishCheckBean) {
        this.target = minepublishCheckBean;
    }
}
