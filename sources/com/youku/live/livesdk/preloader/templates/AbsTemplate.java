package com.youku.live.livesdk.preloader.templates;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.model.template.TemplateModel;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AbsTemplate implements ITemplate {
    private static transient /* synthetic */ IpChange $ipChange;
    private String landscapeLayout;
    private TemplateModel landscapeModel;
    private String portraitLayout;
    private TemplateModel portraitModel;

    public AbsTemplate(String str, String str2, TemplateModel templateModel, TemplateModel templateModel2) {
        this.landscapeLayout = str;
        this.portraitLayout = str2;
        this.landscapeModel = templateModel;
        this.portraitModel = templateModel2;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getLandscapeLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608180435") ? (String) ipChange.ipc$dispatch("-1608180435", new Object[]{this}) : this.landscapeLayout;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getLandscapeModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1723418406") ? (TemplateModel) ipChange.ipc$dispatch("1723418406", new Object[]{this}) : this.landscapeModel;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getPortraitLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1274599987") ? (String) ipChange.ipc$dispatch("1274599987", new Object[]{this}) : this.portraitLayout;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getPortraitModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-864927060") ? (TemplateModel) ipChange.ipc$dispatch("-864927060", new Object[]{this}) : this.portraitModel;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122600306")) {
            ipChange.ipc$dispatch("1122600306", new Object[]{this});
        }
    }
}
