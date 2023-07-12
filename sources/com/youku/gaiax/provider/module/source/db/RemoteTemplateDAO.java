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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH'J6\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH'J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH'J6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH'¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/RemoteTemplateDAO;", "", "Lcom/youku/gaiax/provider/module/source/db/YKTemplateEntity;", Constants.TEMPLATE, "Ltb/wt2;", "insert", "", "getAll", "", "templateId", "", "templateVer", "templateBiz", "templateStatus", "getTemplateWithStatus", "", "appVersion", "platform", "getTemplateWithStatusAndAppVersion", "status", "getAllTemplatesWithStatusAndAppVersion", "getTemplatesWithStatusAndAppVersion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface RemoteTemplateDAO {
    @Query("SELECT template_id,template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType   FROM yk_template_v2 ")
    @NotNull
    List<YKTemplateEntity> getAll();

    @Query("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType FROM yk_template_v2 WHERE template_release_status=:status AND template_support_min_version<=:appVersion AND template_support_max_version>=:appVersion AND template_platform=:platform GROUP BY template_id")
    @NotNull
    List<YKTemplateEntity> getAllTemplatesWithStatusAndAppVersion(@NotNull String str, long j, @NotNull String str2);

    @Query("SELECT template_id,template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=:templateId AND template_version=:templateVer AND template_biz=:templateBiz AND template_release_status=:templateStatus")
    @NotNull
    List<YKTemplateEntity> getTemplateWithStatus(@NotNull String str, int i, @NotNull String str2, @NotNull String str3);

    @Query("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=:templateId AND template_biz=:templateBiz AND template_release_status=:templateStatus AND template_support_min_version<=:appVersion AND template_support_max_version>=:appVersion AND template_platform=:platform")
    @NotNull
    List<YKTemplateEntity> getTemplateWithStatusAndAppVersion(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4);

    @Query("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=:templateId AND template_biz=:templateBiz AND template_release_status=:templateStatus AND template_support_min_version<=:appVersion AND template_support_max_version>=:appVersion AND template_platform=:platform")
    @NotNull
    List<YKTemplateEntity> getTemplatesWithStatusAndAppVersion(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4);

    @Insert(onConflict = 1)
    void insert(@NotNull YKTemplateEntity yKTemplateEntity);
}
