package tb;

import android.annotation.SuppressLint;
import com.android.alibaba.ip.common.PatchInfo;
import com.android.alibaba.ip.common.PatchResult;
import com.android.alibaba.ip.server.InstantPatcher;
import com.taobao.update.instantpatch.InstantPatchUpdater;
import com.taobao.update.instantpatch.flow.PatchChecker;
import com.taobao.update.instantpatch.model.InstantUpdateInfo;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xq1 {
    private e31 a;

    public xq1(e31 e31Var) {
        this.a = e31Var;
    }

    @SuppressLint({"NewApi"})
    public void install(InstantUpdateInfo instantUpdateInfo) {
        PatchResult patchResult = new PatchResult();
        PatchInfo createPatchInfo = InstantPatchUpdater.instance().createPatchInfo(instantUpdateInfo);
        try {
            InstantPatcher.create(this.a.context).setiPatchVerifier(new PatchChecker());
            patchResult = InstantPatcher.create(this.a.context).handlePatches(this.a.path, createPatchInfo);
        } catch (IOException e) {
            e.printStackTrace();
            patchResult.resCode = 3;
        }
        switch (patchResult.resCode) {
            case 0:
                this.a.success = true;
                return;
            case 1:
                this.a.success = true;
                return;
            case 2:
                e31 e31Var = this.a;
                e31Var.success = false;
                e31Var.errorCode = 2;
                e31Var.errorMsg = "patch verify failed";
                return;
            case 3:
                e31 e31Var2 = this.a;
                e31Var2.success = false;
                e31Var2.errorCode = 3;
                e31Var2.errorMsg = patchResult.msg;
                return;
            case 4:
                e31 e31Var3 = this.a;
                e31Var3.success = false;
                e31Var3.errorCode = 4;
                e31Var3.errorMsg = "patch has no dex";
                return;
            case 5:
                e31 e31Var4 = this.a;
                e31Var4.success = false;
                e31Var4.errorCode = 5;
                e31Var4.errorMsg = "patch is mismatch";
                return;
            case 6:
                e31 e31Var5 = this.a;
                e31Var5.success = false;
                e31Var5.errorCode = 6;
                e31Var5.errorMsg = patchResult.msg;
                return;
            default:
                return;
        }
    }
}
