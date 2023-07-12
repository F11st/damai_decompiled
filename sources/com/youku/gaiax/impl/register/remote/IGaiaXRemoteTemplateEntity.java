package com.youku.gaiax.impl.register.remote;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0002H&¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/IGaiaXRemoteTemplateEntity;", "", "", "getLocalPath", "getTemplateBiz", "getTemplateId", "", "getSupportMinVersion", "getSupportMaxVersion", "getReleaseStatus", "", "getTemplateVersion", "getTemplatePlatform", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IGaiaXRemoteTemplateEntity {
    @NotNull
    String getLocalPath();

    @NotNull
    String getReleaseStatus();

    long getSupportMaxVersion();

    long getSupportMinVersion();

    @NotNull
    String getTemplateBiz();

    @NotNull
    String getTemplateId();

    @NotNull
    String getTemplatePlatform();

    int getTemplateVersion();
}
