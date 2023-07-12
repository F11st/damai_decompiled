package tb;

import android.text.TextUtils;
import cn.damai.common.util.C0535a;
import cn.damai.issue.bean.DraftBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class vc0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DIR_DRAFT = "draft_dir";

    public boolean a(DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647665953")) {
            return ((Boolean) ipChange.ipc$dispatch("1647665953", new Object[]{this, draftBean})).booleanValue();
        }
        try {
            if (TextUtils.isEmpty(draftBean.draftMd5FileName)) {
                return false;
            }
            return C0535a.e(new File(b(), draftBean.draftMd5FileName));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public File b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893147656")) {
            return (File) ipChange.ipc$dispatch("-1893147656", new Object[]{this});
        }
        File file = new File(mu0.a().getFilesDir(), DIR_DRAFT);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public File c(DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054795817")) {
            return (File) ipChange.ipc$dispatch("2054795817", new Object[]{this, draftBean});
        }
        File[] listFiles = b().listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        for (File file : listFiles) {
            if (TextUtils.equals(draftBean.draftMd5FileName, file.getName())) {
                return file;
            }
        }
        return null;
    }

    public boolean d(DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254109553")) {
            return ((Boolean) ipChange.ipc$dispatch("-1254109553", new Object[]{this, draftBean})).booleanValue();
        }
        try {
            a(draftBean);
            File file = new File(b(), draftBean.draftMd5FileName);
            byte[] generateDraftBytes = draftBean.generateDraftBytes();
            if (generateDraftBytes != null) {
                return C0535a.a(generateDraftBytes, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
