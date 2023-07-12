package cn.damai.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.common.uploader.AusResult;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.C0535a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.bean.FeedBack;
import cn.damai.mine.bean.FeedBackResult;
import cn.damai.mine.presenter.FeedBackSubmitRequest;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.uploader.FileUploadListener;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.UploadErrorCode;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import tb.C9796v;
import tb.cb1;
import tb.cm2;
import tb.ir1;
import tb.jn1;
import tb.kg1;
import tb.ko;
import tb.m62;
import tb.mr1;
import tb.q11;
import tb.q50;
import tb.uu2;
import tb.vf1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FeedBackActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int RESULT_IMAGE = 1000;
    private LinearLayout mAddImageContainer;
    private FrameLayout mAddImageLayout;
    private EditText mContentEd;
    public DMProgressDialog mDMProgressDialog;
    private String mFeedBackHit;
    private String mFeedBackId;
    private String mFeedBackTitle;
    private FileUploader mFeedbackUploader;
    private String mFilePath;
    private FlowLayout mFlowLayout;
    private int mScreenHeight;
    private String mScreenShotExtra;
    private String mScreenShotFromPage;
    private String mScreenShotModule;
    private int mScreenWidth;
    private TextView mSelectQuestView;
    private Button mSubmitBtn;
    private boolean mTextChangeLast;
    private boolean mTextChangePre;
    private TextView mTvDesc;
    private String mUploadContent;
    private final int MAX_TEXT_COUNT = 450;
    private ArrayList<String> mPaths = new ArrayList<>();
    private ArrayList<FrameLayout> mImageLayouts = new ArrayList<>();
    private List<AusResult> mARupReplyData = new ArrayList();
    private int mReplyTime = 0;
    private int mUploadPicSize = 0;
    private List<FeedBack> mFeedBackList = new ArrayList();
    View.OnClickListener mQuestTypeListener = new View$OnClickListenerC1374a();
    private TextWatcher mTextWatcherListener = new C1376c();
    private View.OnClickListener mDeleteClickListener = new View$OnClickListenerC1377d();
    private FileUploadListener mSubmitListener = new C1378e();
    private Handler mSubmitHandler = new HandlerC1379f();
    private String[] picFormArray = {"jpg", "png", "jpeg", "gif", "bmp", "dib", "jfif", "tif", "tiff", "ico"};

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1374a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1374a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "979522894")) {
                ipChange.ipc$dispatch("979522894", new Object[]{this, view});
                return;
            }
            FeedBack feedBack = (FeedBack) view.getTag();
            if (feedBack == null) {
                return;
            }
            FeedBackActivity feedBackActivity = FeedBackActivity.this;
            feedBackActivity.updateUnQuestTypeView(feedBackActivity.mSelectQuestView);
            FeedBackActivity.this.mSelectQuestView = (TextView) view;
            FeedBackActivity feedBackActivity2 = FeedBackActivity.this;
            feedBackActivity2.updateQuestTypeView(feedBackActivity2.mSelectQuestView);
            FeedBackActivity.this.mFeedBackId = feedBack.name;
            FeedBackActivity.this.mFeedBackTitle = feedBack.title;
            FeedBackActivity.this.mFeedBackHit = feedBack.desc;
            FeedBackActivity.this.mContentEd.setHint(FeedBackActivity.this.mFeedBackHit);
            C0529c.e().x(vf1.x().q0(feedBack.index));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$b */
    /* loaded from: classes6.dex */
    public class C1375b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1375b() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1244147472")) {
                ipChange.ipc$dispatch("1244147472", new Object[]{this});
            } else {
                FeedBackActivity.this.doSelectFile();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$c */
    /* loaded from: classes15.dex */
    public class C1376c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C1376c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-487606649")) {
                ipChange.ipc$dispatch("-487606649", new Object[]{this, editable});
                return;
            }
            FeedBackActivity.this.mTextChangePre = editable.length() > 0;
            if (FeedBackActivity.this.mTextChangePre != FeedBackActivity.this.mTextChangeLast) {
                FeedBackActivity feedBackActivity = FeedBackActivity.this;
                feedBackActivity.mTextChangeLast = feedBackActivity.mTextChangePre;
                FeedBackActivity feedBackActivity2 = FeedBackActivity.this;
                feedBackActivity2.updateSubmitState(feedBackActivity2.mTextChangePre);
            }
            if (editable.length() > 450) {
                FeedBackActivity.this.mContentEd.setText(editable.subSequence(0, 450));
                FeedBackActivity.this.mContentEd.setSelection(450);
                ToastUtil.i("最多输入450字哟~");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-274333156")) {
                ipChange.ipc$dispatch("-274333156", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1195563844")) {
                ipChange.ipc$dispatch("-1195563844", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$d */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1377d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1377d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1276540591")) {
                ipChange.ipc$dispatch("-1276540591", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (wh2.e(FeedBackActivity.this.mPaths) > intValue) {
                FeedBackActivity.this.mPaths.remove(intValue);
                FeedBackActivity.this.updateImageLayout();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$e */
    /* loaded from: classes6.dex */
    public class C1378e extends q50 {
        private static transient /* synthetic */ IpChange $ipChange;

        C1378e() {
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onAllSuccess(@NonNull List<uu2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1794740399")) {
                ipChange.ipc$dispatch("-1794740399", new Object[]{this, list});
            } else {
                FeedBackActivity.this.onAllUploadFinish(list);
            }
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NonNull UploadErrorCode uploadErrorCode, @NonNull List<uu2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "251413064")) {
                ipChange.ipc$dispatch("251413064", new Object[]{this, uploadErrorCode, list});
            } else {
                FeedBackActivity.this.onAllUploadFinish(list);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$f */
    /* loaded from: classes15.dex */
    public class HandlerC1379f extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC1379f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1762436124")) {
                ipChange.ipc$dispatch("1762436124", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            if (message.what != 4) {
                return;
            }
            FeedBackActivity.this.deleteFile();
            FeedBackActivity.this.setResult(-1);
            FeedBackActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.FeedBackActivity$g */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnDismissListenerC1380g implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnDismissListenerC1380g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-598891093")) {
                ipChange.ipc$dispatch("-598891093", new Object[]{this, dialogInterface});
                return;
            }
            FeedBackActivity.this.setBtnEnable(true);
            if (FeedBackActivity.this.mReplyTime < FeedBackActivity.this.mUploadPicSize) {
                FeedBackActivity.this.mFeedbackUploader.p();
            }
        }
    }

    private void addUTClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777592562")) {
            ipChange.ipc$dispatch("777592562", new Object[]{this, str});
            return;
        }
        if (this.mFeedBackId == null) {
            this.mFeedBackId = "0";
        }
        if (this.mFeedBackTitle == null) {
            this.mFeedBackTitle = "意见反馈";
        }
        C0529c e = C0529c.e();
        vf1 x = vf1.x();
        e.x(x.u(this.mFeedBackId + JSMethod.NOT_SET + this.mFeedBackTitle, str));
    }

    private void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796934659")) {
            ipChange.ipc$dispatch("796934659", new Object[]{this});
            return;
        }
        EditText editText = this.mContentEd;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120858985")) {
            ipChange.ipc$dispatch("1120858985", new Object[]{this});
            return;
        }
        try {
            String m = C0535a.m();
            if (TextUtils.isEmpty(m)) {
                return;
            }
            String str = m + "/feedback";
            this.mFilePath = str;
            C0535a.f(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSelectFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "512055661")) {
            ipChange.ipc$dispatch("512055661", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void error(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-873453434")) {
            ipChange.ipc$dispatch("-873453434", new Object[]{this, str, str2});
            return;
        }
        stopDMProgressDialog();
        if (TextUtils.isEmpty(str2)) {
            str2 = cm2.b(this, R$string.damai_faq_submit_failure_toast);
        }
        ToastUtil.i(str2);
    }

    private void getIntentData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111479966")) {
            ipChange.ipc$dispatch("111479966", new Object[]{this});
            return;
        }
        this.mPaths.clear();
        if (getIntent() == null || (extras = getIntent().getExtras()) == null) {
            return;
        }
        if (extras.containsKey(SocialConstants.PARAM_APP_DESC)) {
            String string = extras.getString(SocialConstants.PARAM_APP_DESC, getResources().getString(R$string.damai_faq_input_your_feedback_hint));
            this.mFeedBackHit = string;
            this.mContentEd.setHint(string);
        } else if (extras.containsKey("descInfo")) {
            String string2 = extras.getString("descInfo", "");
            this.mContentEd.setText(string2);
            this.mContentEd.setSelection(string2.length());
        }
        if (extras.containsKey("name")) {
            this.mFeedBackId = extras.getString("name", "0");
        }
        if (extras.containsKey("title")) {
            this.mFeedBackTitle = extras.getString("title", "");
        }
        if (ir1.i(mr1.STORAGE) && extras.containsKey("screenView")) {
            reduceImage(extras.getString("screenView"), false);
        }
        if (extras.containsKey("data")) {
            ArrayList parcelableArrayList = extras.getParcelableArrayList("data");
            this.mFeedBackList.clear();
            this.mFeedBackList.addAll(parcelableArrayList);
            initQuestType();
        }
        if (extras.containsKey("fromPage")) {
            this.mScreenShotFromPage = extras.getString("fromPage");
        }
        if (extras.containsKey("module")) {
            this.mScreenShotModule = extras.getString("module");
        }
        if (extras.containsKey("extra")) {
            this.mScreenShotExtra = extras.getString("extra");
        }
    }

    private void initEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922543952")) {
            ipChange.ipc$dispatch("1922543952", new Object[]{this});
            return;
        }
        this.mAddImageLayout.setOnClickListener(this);
        this.mSubmitBtn.setOnClickListener(this);
        this.mContentEd.addTextChangedListener(this.mTextWatcherListener);
        String m = C0535a.m();
        if (TextUtils.isEmpty(m)) {
            return;
        }
        try {
            String str = m + "/feedback";
            this.mFilePath = str;
            C0535a.t(str, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initImageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287094518")) {
            ipChange.ipc$dispatch("-287094518", new Object[]{this});
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.mScreenWidth = i;
        this.mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        int a = (i - m62.a(this, 38.0f)) / 4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        this.mAddImageLayout.setLayoutParams(layoutParams);
        this.mImageLayouts.clear();
        for (int i2 = 0; i2 < 3; i2++) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R$layout.merg_add_image, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            this.mAddImageContainer.addView(frameLayout);
            frameLayout.setVisibility(8);
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) frameLayout.findViewById(R$id.image_tag);
            dMIconFontTextView.setTag(Integer.valueOf(i2));
            dMIconFontTextView.setOnClickListener(this.mDeleteClickListener);
            this.mImageLayouts.add(frameLayout);
        }
    }

    private void initQuestType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614187246")) {
            ipChange.ipc$dispatch("1614187246", new Object[]{this});
            return;
        }
        int e = wh2.e(this.mFeedBackList);
        if (e > 0) {
            this.mTvDesc.setVisibility(0);
            this.mFlowLayout.setVisibility(0);
        } else {
            this.mTvDesc.setVisibility(8);
            this.mFlowLayout.setVisibility(8);
        }
        this.mFlowLayout.removeAllViews();
        int i = -1;
        for (int i2 = 0; i2 < e; i2++) {
            FeedBack feedBack = this.mFeedBackList.get(i2);
            if (!TextUtils.isEmpty(feedBack.subTitle)) {
                i++;
                View inflate = this.mInflater.inflate(R$layout.feed_back_quest, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_quest);
                textView.setText(feedBack.subTitle);
                if (feedBack.name.equals(this.mFeedBackId)) {
                    this.mSelectQuestView = textView;
                    updateQuestTypeView(textView);
                } else {
                    updateUnQuestTypeView(textView);
                }
                this.mFlowLayout.addView(inflate);
                feedBack.index = i;
                textView.setTag(feedBack);
                textView.setOnClickListener(this.mQuestTypeListener);
            }
        }
    }

    private boolean isPicVerify(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076739087")) {
            return ((Boolean) ipChange.ipc$dispatch("1076739087", new Object[]{this, str})).booleanValue();
        }
        for (int i = 0; i < this.picFormArray.length; i++) {
            if (str.toLowerCase().endsWith(this.picFormArray[i])) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAllUploadFinish(List<uu2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511914197")) {
            ipChange.ipc$dispatch("1511914197", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            for (uu2 uu2Var : list) {
                if (uu2Var.d() != null) {
                    AusResult ausResult = uu2Var.d().getBizResult() != null ? (AusResult) ko.e().parseJson(uu2Var.d().getBizResult(), (Class<Object>) AusResult.class) : null;
                    if (ausResult == null) {
                        ausResult = new AusResult();
                    }
                    String fileUrl = uu2Var.d().getFileUrl();
                    if (fileUrl != null) {
                        try {
                            String j = q11.INSTANCE.j(Uri.parse(fileUrl), fileUrl);
                            if (j != null) {
                                fileUrl = j;
                            }
                            ausResult.url = fileUrl;
                        } catch (Exception e) {
                            cb1.d(e);
                        }
                    }
                    this.mARupReplyData.add(ausResult);
                }
            }
            requestSubmitFeedBack();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
        if (r6 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        r4.mPaths.add(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void reduceImage(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.mine.activity.FeedBackActivity.$ipChange
            java.lang.String r1 = "1183215141"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1e
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r5 = 2
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r2[r5] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L1e:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L7d
            boolean r0 = r4.isPicVerify(r5)
            if (r0 == 0) goto L7d
            if (r6 == 0) goto L75
            r6 = 0
            java.lang.String r0 = r4.mFilePath     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            if (r0 != 0) goto L5a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r0.<init>()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r1 = r4.mFilePath     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r0.append(r1)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r1 = "/"
            r0.append(r1)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r1 = cn.damai.common.util.C0535a.k(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r0.append(r1)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            cn.damai.common.util.C0535a.d(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            android.graphics.Bitmap r6 = cn.damai.common.util.C0535a.i(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            cn.damai.common.util.C0535a.u(r6, r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r5 = r0
        L5a:
            if (r6 == 0) goto L69
        L5c:
            r6.recycle()
            goto L69
        L60:
            r5 = move-exception
            goto L6f
        L62:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto L69
            goto L5c
        L69:
            java.util.ArrayList<java.lang.String> r6 = r4.mPaths
            r6.add(r5)
            goto L7a
        L6f:
            if (r6 == 0) goto L74
            r6.recycle()
        L74:
            throw r5
        L75:
            java.util.ArrayList<java.lang.String> r6 = r4.mPaths
            r6.add(r5)
        L7a:
            r4.updateImageLayout()
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.mine.activity.FeedBackActivity.reduceImage(java.lang.String, boolean):void");
    }

    private void requestSubmitFeedBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558417838")) {
            ipChange.ipc$dispatch("1558417838", new Object[]{this});
            return;
        }
        FeedBackSubmitRequest feedBackSubmitRequest = new FeedBackSubmitRequest();
        feedBackSubmitRequest.content = this.mUploadContent;
        if (wh2.e(this.mARupReplyData) > 0) {
            feedBackSubmitRequest.imageAddrs = JSON.toJSONString(this.mARupReplyData);
        }
        feedBackSubmitRequest.resolution = this.mScreenHeight + jn1.MUL + this.mScreenWidth;
        feedBackSubmitRequest.bizIdentifiers = this.mFeedBackId;
        if (!TextUtils.isEmpty(this.mScreenShotFromPage)) {
            feedBackSubmitRequest.fromPage = this.mScreenShotFromPage;
        }
        if (!TextUtils.isEmpty(this.mScreenShotModule)) {
            feedBackSubmitRequest.module = this.mScreenShotModule;
        }
        if (!TextUtils.isEmpty(this.mScreenShotExtra)) {
            feedBackSubmitRequest.extra = this.mScreenShotExtra;
        }
        feedBackSubmitRequest.request(new DMMtopResultRequestListener<FeedBackResult>(FeedBackResult.class) { // from class: cn.damai.mine.activity.FeedBackActivity.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "698193338")) {
                    ipChange2.ipc$dispatch("698193338", new Object[]{this, str, str2});
                } else {
                    FeedBackActivity.this.error(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(FeedBackResult feedBackResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1785118494")) {
                    ipChange2.ipc$dispatch("1785118494", new Object[]{this, feedBackResult});
                } else {
                    FeedBackActivity.this.returnFeedBack(feedBackResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnFeedBack(FeedBackResult feedBackResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969340858")) {
            ipChange.ipc$dispatch("-1969340858", new Object[]{this, feedBackResult});
            return;
        }
        stopDMProgressDialog();
        if (feedBackResult == null || !feedBackResult.isSuccess) {
            return;
        }
        ToastUtil.i(getString(R$string.damai_faq_submit_success_toast));
        this.mSubmitHandler.sendEmptyMessageDelayed(4, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBtnEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895275199")) {
            ipChange.ipc$dispatch("-895275199", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mAddImageLayout.setEnabled(z);
        this.mSubmitBtn.setEnabled(z);
    }

    private void submitFeedBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643224045")) {
            ipChange.ipc$dispatch("-1643224045", new Object[]{this});
            return;
        }
        String obj = this.mContentEd.getText().toString();
        if (wh2.j(obj)) {
            ToastUtil.i(getString(R$string.damai_faq_input_feedback_toast));
            return;
        }
        this.mUploadPicSize = wh2.e(this.mPaths);
        String str = obj + Constants.WAVE_SEPARATOR + this.mUploadPicSize;
        this.mUploadContent = str;
        addUTClick(str);
        startDMProgressDialog();
        this.mARupReplyData.clear();
        this.mReplyTime = 0;
        if (this.mUploadPicSize == 0) {
            requestSubmitFeedBack();
            return;
        }
        FileUploader fileUploader = this.mFeedbackUploader;
        if (fileUploader != null) {
            fileUploader.C(null);
        }
        FileUploader q = FileUploader.q("feedback_oss");
        this.mFeedbackUploader = q;
        q.C(this.mSubmitListener).y().G(this.mPaths);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367945570")) {
            ipChange.ipc$dispatch("-1367945570", new Object[]{this});
            return;
        }
        int e = wh2.e(this.mPaths);
        for (int i = 0; i < 3; i++) {
            FrameLayout frameLayout = this.mImageLayouts.get(i);
            ImageView imageView = (ImageView) frameLayout.findViewById(R$id.image_bg);
            if (i < e) {
                frameLayout.setVisibility(0);
                kg1 j = kg1.q(this).j(String.format("file://%1$s", this.mPaths.get(i)));
                int i2 = R$drawable.uikit_default_image_bg_gradient;
                j.n(i2).e(i2).g(imageView);
            } else {
                frameLayout.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateQuestTypeView(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811272322")) {
            ipChange.ipc$dispatch("1811272322", new Object[]{this, textView});
            return;
        }
        textView.setTextColor(ContextCompat.getColor(this, R$color.white));
        textView.setBackgroundResource(R$drawable.bg_border_corner_red);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubmitState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129980138")) {
            ipChange.ipc$dispatch("1129980138", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mSubmitBtn.setEnabled(true);
            this.mSubmitBtn.setBackgroundResource(R$drawable.feedback_submit_button_bg);
            this.mSubmitBtn.setTextColor(ContextCompat.getColor(this, R$color.white));
        } else {
            this.mSubmitBtn.setEnabled(false);
            this.mSubmitBtn.setBackgroundResource(R$drawable.photo_select_normal);
            this.mSubmitBtn.setTextColor(ContextCompat.getColor(this, R$color.color_666666));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnQuestTypeView(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632080233")) {
            ipChange.ipc$dispatch("632080233", new Object[]{this, textView});
            return;
        }
        textView.setTextColor(ContextCompat.getColor(this, R$color.color_888888));
        textView.setBackgroundResource(R$drawable.bg_border_corner_ff_no_trans);
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259582344")) {
            ipChange.ipc$dispatch("-1259582344", new Object[]{this, Integer.valueOf(i)});
        } else {
            onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "232274546") ? ((Integer) ipChange.ipc$dispatch("232274546", new Object[]{this})).intValue() : R$layout.faq_activity;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324062885")) {
            ipChange.ipc$dispatch("-324062885", new Object[]{this});
            return;
        }
        this.base_header_title.setText(getResources().getString(R$string.damai_faq_feedback_title));
        this.mTvDesc = (TextView) findViewById(R$id.tv_desc);
        this.mFlowLayout = (FlowLayout) findViewById(R$id.fl_desc);
        EditText editText = (EditText) findViewById(R$id.et_content);
        this.mContentEd = editText;
        editText.setHint(getResources().getString(R$string.damai_faq_input_your_feedback_hint));
        this.mSubmitBtn = (Button) findViewById(R$id.btn_submit);
        this.mAddImageLayout = (FrameLayout) findViewById(R$id.fl_add_image);
        this.mAddImageContainer = (LinearLayout) findViewById(R$id.ll_add_image);
        this.mTvDesc.setVisibility(8);
        updateSubmitState(false);
        initImageView();
        initEvent();
        getIntentData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559041918")) {
            ipChange.ipc$dispatch("-559041918", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1000) {
            reduceImage(C0535a.l(getApplicationContext(), intent.getData()), true);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281445602")) {
            ipChange.ipc$dispatch("-281445602", new Object[]{this});
            return;
        }
        deleteFile();
        Handler handler = this.mSubmitHandler;
        if (handler != null) {
            handler.removeMessages(4);
            this.mSubmitHandler = null;
        }
        super.onBackPressed();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774134655")) {
            ipChange.ipc$dispatch("-1774134655", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.fl_add_image) {
            if (wh2.e(this.mPaths) < 3) {
                ir1.b(this, false, mr1.STORAGE, "用于选取图片进行问题反馈", new C1375b());
            } else {
                ToastUtil.i("最多上传3张图片哟~");
            }
        } else if (id == R$id.btn_submit) {
            submitFeedBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759159039")) {
            ipChange.ipc$dispatch("1759159039", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().t());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504486938")) {
            ipChange.ipc$dispatch("1504486938", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        setIntent(intent);
        clearData();
        getIntentData();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565055130")) {
            return (String) ipChange.ipc$dispatch("-565055130", new Object[]{this});
        }
        return null;
    }

    public void startDMProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926582694")) {
            ipChange.ipc$dispatch("-1926582694", new Object[]{this});
        } else if (isFinishing()) {
        } else {
            if (this.mDMProgressDialog == null) {
                DMProgressDialog a = new DMProgressDialog(this.mContext).a();
                this.mDMProgressDialog = a;
                a.setOnDismissListener(new DialogInterface$OnDismissListenerC1380g());
            }
            this.mDMProgressDialog.show();
            setBtnEnable(false);
        }
    }

    public void stopDMProgressDialog() {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "528242192")) {
            ipChange.ipc$dispatch("528242192", new Object[]{this});
        } else if (isFinishing() || (dMProgressDialog = this.mDMProgressDialog) == null) {
        } else {
            dMProgressDialog.dismiss();
            this.mDMProgressDialog = null;
        }
    }
}
