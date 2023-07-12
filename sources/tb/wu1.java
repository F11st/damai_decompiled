package tb;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.IProcedureManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wu1 implements IProcedureManager {
    public static wu1 b = new wu1();
    private IProcedureManager a;

    private wu1() {
    }

    public wu1 a(IProcedureManager iProcedureManager) {
        this.a = iProcedureManager;
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getActivityProcedure(Activity activity) {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getActivityProcedure(activity);
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getCurrentActivityProcedure() {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getCurrentActivityProcedure();
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getCurrentFragmentProcedure() {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getCurrentFragmentProcedure();
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getCurrentProcedure() {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getCurrentProcedure();
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getFragmentProcedure(Fragment fragment) {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getFragmentProcedure(fragment);
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getLauncherProcedure() {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getLauncherProcedure();
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getProcedure(View view) {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getProcedure(view);
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getRootProcedure() {
        IProcedureManager iProcedureManager = this.a;
        if (iProcedureManager == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureManager.getRootProcedure();
    }
}
