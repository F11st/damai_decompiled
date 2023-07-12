package com.alibaba.android.ultron.vfw.template;

import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;
import tb.kd0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ITemplateProvider {
    boolean checkTemplate(IDMComponent iDMComponent);

    void downloadTemplates(List<kd0> list, TemplateDownloadListener templateDownloadListener);
}
