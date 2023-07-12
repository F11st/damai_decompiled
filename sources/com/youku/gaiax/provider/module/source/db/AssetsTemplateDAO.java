package com.youku.gaiax.provider.module.source.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.youku.arch.v3.data.Constants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H'J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH'¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/AssetsTemplateDAO;", "", "Lcom/youku/gaiax/provider/module/source/db/YKAssetsTemplateEntity;", Constants.TEMPLATE, "Ltb/wt2;", "insert", "", "appVersion", "", "getAllTemplatesWithAppVersion", "", "templateBiz", "templateId", "getTemplate", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface AssetsTemplateDAO {
    @Query("SELECT template_id, template_biz, template_local_url, template_app_version FROM yk_assets_template_v1 WHERE template_app_version==:appVersion")
    @NotNull
    List<YKAssetsTemplateEntity> getAllTemplatesWithAppVersion(long j);

    @Query("SELECT template_id, template_biz, template_local_url, template_app_version FROM yk_assets_template_v1 WHERE template_biz==:templateBiz AND template_id=:templateId")
    @NotNull
    List<YKAssetsTemplateEntity> getTemplate(@NotNull String str, @NotNull String str2);

    @Insert(onConflict = 1)
    void insert(@NotNull YKAssetsTemplateEntity yKAssetsTemplateEntity);
}
