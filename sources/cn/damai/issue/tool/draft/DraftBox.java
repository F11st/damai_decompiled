package cn.damai.issue.tool.draft;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import cn.damai.issue.bean.DraftBean;
import cn.damai.issue.bean.DraftMd5NameAssembler;
import cn.damai.issue.listener.OnCheckDraftListener;
import cn.damai.issue.listener.OnDialogListener;
import cn.damai.issue.listener.OnDraftListener;
import cn.damai.issue.tool.IDraftContentProvider;
import cn.damai.issue.tool.file.DraftStoreImpl;
import cn.damai.issue.tool.file.IDraftStore;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import tb.cb1;
import tb.i41;
import tb.wc0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DraftBox implements IDraftBox, Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DRAFT_SAVE_DURATION = 5000;
    public static final String TAG = "DraftBox";
    private DraftBean mCurrentDraft;
    private final DraftMd5NameAssembler mDraftName;
    private final IDraftContentProvider mDraftProvider;
    private final IDraftStore mDraftStore = new DraftStoreImpl();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* renamed from: cn.damai.issue.tool.draft.DraftBox$a */
    /* loaded from: classes5.dex */
    public class C1303a implements OnDraftListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnCheckDraftListener a;

        C1303a(OnCheckDraftListener onCheckDraftListener) {
            this.a = onCheckDraftListener;
        }

        @Override // cn.damai.issue.listener.OnDraftListener
        public void onDraft(@Nullable DraftBean draftBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-668385642")) {
                ipChange.ipc$dispatch("-668385642", new Object[]{this, draftBean});
                return;
            }
            DraftBox.this.mCurrentDraft = draftBean;
            if (draftBean != null && draftBean.isValidDraft()) {
                this.a.onHasDraft(draftBean);
            } else {
                this.a.onNoneDraft();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.issue.tool.draft.DraftBox$b */
    /* loaded from: classes5.dex */
    public class C1304b implements OnDialogListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DraftBean a;
        final /* synthetic */ OnDialogListener b;

        C1304b(DraftBean draftBean, OnDialogListener onDialogListener) {
            this.a = draftBean;
            this.b = onDialogListener;
        }

        @Override // cn.damai.issue.listener.OnDialogListener
        public void onDialogClick(DialogInterface dialogInterface, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-231737610")) {
                ipChange.ipc$dispatch("-231737610", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                i41.w();
            } else {
                i41.v();
            }
            DraftBox.this.quitAutoDraft();
            if (z) {
                if (!this.a.equals(DraftBox.this.mCurrentDraft)) {
                    DraftBox.this.mDraftStore.saveAsync(this.a);
                }
            } else {
                DraftBox.this.mCurrentDraft = null;
                DraftBox.this.mDraftStore.deleteAsync(new DraftBean(DraftBox.this.mDraftName.getDraftMd5FileName()));
            }
            this.b.onDialogClick(dialogInterface, z);
        }
    }

    public DraftBox(DraftMd5NameAssembler draftMd5NameAssembler, IDraftContentProvider iDraftContentProvider) {
        this.mDraftName = draftMd5NameAssembler;
        this.mDraftProvider = iDraftContentProvider;
    }

    private DraftBean createRealTimeDraft() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2006545675") ? (DraftBean) ipChange.ipc$dispatch("2006545675", new Object[]{this}) : new DraftBean(this.mDraftName.getDraftMd5FileName(), this.mDraftProvider.getDraftInput(), this.mDraftProvider.getDraftTheme(), this.mDraftProvider.getDraftThemeId(), this.mDraftProvider.getDraftCircle(), this.mDraftProvider.getDraftCircleList(), this.mDraftProvider.getDraftStoreId(), this.mDraftProvider.getDraftItemType(), this.mDraftProvider.getDraftExtra());
    }

    private boolean isProviderActivityOk() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481683985")) {
            return ((Boolean) ipChange.ipc$dispatch("1481683985", new Object[]{this})).booleanValue();
        }
        Activity draftActivity = this.mDraftProvider.getDraftActivity();
        return (draftActivity == null || draftActivity.isFinishing()) ? false : true;
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public boolean checkBackPressed(OnDialogListener onDialogListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796813390")) {
            return ((Boolean) ipChange.ipc$dispatch("1796813390", new Object[]{this, onDialogListener})).booleanValue();
        }
        if (isProviderActivityOk()) {
            DraftBean createRealTimeDraft = createRealTimeDraft();
            if (createRealTimeDraft.isValidDraft()) {
                wc0.f(this.mDraftProvider.getDraftActivity(), new C1304b(createRealTimeDraft, onDialogListener));
                return true;
            }
            DraftBean draftBean = this.mCurrentDraft;
            if (draftBean != null && draftBean.isValidDraft()) {
                quitAutoDraft();
                this.mDraftStore.deleteAsync(this.mCurrentDraft);
            }
            return false;
        }
        return false;
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void checkCacheDraft(OnCheckDraftListener onCheckDraftListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490495593")) {
            ipChange.ipc$dispatch("490495593", new Object[]{this, onCheckDraftListener});
            return;
        }
        cb1.c(TAG, "checkCacheDraft");
        this.mDraftStore.queryAsync(this.mDraftName.getDraftMd5FileName(), new C1303a(onCheckDraftListener));
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void deleteCurDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259213735")) {
            ipChange.ipc$dispatch("1259213735", new Object[]{this});
            return;
        }
        cb1.c(TAG, "deleteCurDraft");
        DraftBean draftBean = this.mCurrentDraft;
        if (draftBean != null) {
            this.mDraftStore.deleteAsync(draftBean);
            this.mCurrentDraft = null;
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void notifyPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1168370166")) {
            ipChange.ipc$dispatch("1168370166", new Object[]{this});
            return;
        }
        cb1.c(TAG, "publishSuccess");
        deleteCurDraft();
        quitAutoDraft();
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void quitAutoDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686414708")) {
            ipChange.ipc$dispatch("686414708", new Object[]{this});
            return;
        }
        cb1.c(TAG, "quitAutoDraft");
        this.mHandler.removeCallbacks(this);
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-65226224")) {
            ipChange.ipc$dispatch("-65226224", new Object[]{this});
            return;
        }
        cb1.c(TAG, "release");
        quitAutoDraft();
        this.mDraftStore.quitSafely();
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970747916")) {
            ipChange.ipc$dispatch("1970747916", new Object[]{this});
        } else if (isProviderActivityOk()) {
            DraftBean createRealTimeDraft = createRealTimeDraft();
            if (createRealTimeDraft.isValidDraft()) {
                if (!createRealTimeDraft.equals(this.mCurrentDraft)) {
                    this.mDraftStore.saveAsync(createRealTimeDraft);
                }
                this.mCurrentDraft = createRealTimeDraft;
            } else {
                DraftBean draftBean = this.mCurrentDraft;
                if (draftBean != null) {
                    this.mDraftStore.deleteAsync(draftBean);
                }
                this.mCurrentDraft = null;
            }
            this.mHandler.postDelayed(this, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void startAutoDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654093379")) {
            ipChange.ipc$dispatch("654093379", new Object[]{this});
            return;
        }
        cb1.c(TAG, "startAutoDraft");
        if (isProviderActivityOk()) {
            this.mHandler.postDelayed(this, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }
}
