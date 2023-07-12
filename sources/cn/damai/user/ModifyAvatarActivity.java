package cn.damai.user;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import cn.damai.baseview.CustomDialog;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.uploader.AusResult;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$style;
import cn.damai.user.crop.Crop;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;
import tb.cb2;
import tb.hs1;
import tb.ir1;
import tb.jn1;
import tb.ko;
import tb.ls;
import tb.mr1;
import tb.q50;
import tb.s11;
import tb.t60;
import tb.uu2;
import tb.wh2;
import tb.yr2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ModifyAvatarActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String FROM_MODIFY_BIG_IMG = "modify_big_img";
    public static String FROM_MODIFY_USERR_HEAD = "modify_user_header";
    public static String FROM_WHERE = "from_where";
    public static String IMG_CORP_TYPE = "IMG_CORP_TYPE";
    public static int IMG_CORP_TYPE_169 = 1;
    public static String MODIFY_AVATAR = "imgurl";
    private static final int REQUEST_ALBUM = 257;
    private static final int REQUEST_CORP = 259;
    private static final int REQUEST_MERGE = 260;
    private static final int REQUEST_TAKE_PHOTO = 258;
    CustomDialog dialog;
    String from;
    ImageView img;
    String imgurl;
    Uri mCutUri;
    String mtopApi;
    String nickName;
    boolean useAus = true;
    boolean imggallery = false;
    public int corpType = 0;
    private int height = 16;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class UploadRequest extends DMBaseMtopRequest {
        private static transient /* synthetic */ IpChange $ipChange;
        public String bucketName;
        public String key;
        public String loginKey;

        UploadRequest() {
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public String getApiName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-227507195") ? (String) ipChange.ipc$dispatch("-227507195", new Object[]{this}) : ModifyAvatarActivity.this.mtopApi;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public DMBaseMtopRequest.HttpMethod getHttpMethod() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "666874805") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("666874805", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public boolean getNeedEcode() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1996623560")) {
                return ((Boolean) ipChange.ipc$dispatch("1996623560", new Object[]{this})).booleanValue();
            }
            return false;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public boolean getNeedSession() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "119752004")) {
                return ((Boolean) ipChange.ipc$dispatch("119752004", new Object[]{this})).booleanValue();
            }
            return false;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public String getVersion() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1940229528") ? (String) ipChange.ipc$dispatch("1940229528", new Object[]{this}) : "1.0";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements CustomDialog.OnDialogClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.ModifyAvatarActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0092a implements OnGrantListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0092a() {
            }

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-357586444")) {
                    ipChange.ipc$dispatch("-357586444", new Object[]{this});
                } else {
                    s11.c(ModifyAvatarActivity.this, 257, true, 1, new ArrayList());
                }
            }
        }

        a() {
        }

        @Override // cn.damai.baseview.CustomDialog.OnDialogClickListener
        public void onAlbum() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "824431277")) {
                ipChange.ipc$dispatch("824431277", new Object[]{this});
                return;
            }
            ModifyAvatarActivity modifyAvatarActivity = ModifyAvatarActivity.this;
            ir1.b(modifyAvatarActivity, false, mr1.STORAGE, modifyAvatarActivity.getPermissionPostFix(), new C0092a());
        }

        @Override // cn.damai.baseview.CustomDialog.OnDialogClickListener
        public void onDismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-742818062")) {
                ipChange.ipc$dispatch("-742818062", new Object[]{this});
            } else {
                ModifyAvatarActivity.this.finish();
            }
        }

        @Override // cn.damai.baseview.CustomDialog.OnDialogClickListener
        public void onPhoto() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1981917174")) {
                ipChange.ipc$dispatch("-1981917174", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class b extends q50 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // tb.q50
        public void a(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-162230012")) {
                ipChange.ipc$dispatch("-162230012", new Object[]{this, uu2Var});
                return;
            }
            super.a(uu2Var);
            ToastUtil.a().j(ModifyAvatarActivity.this, "上传图片失败,请重试.");
            ModifyAvatarActivity.this.setResult(100);
            ModifyAvatarActivity.this.finish();
        }

        @Override // tb.q50
        public void b(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-390319317")) {
                ipChange.ipc$dispatch("-390319317", new Object[]{this, uu2Var});
                return;
            }
            super.b(uu2Var);
            if (uu2Var == null) {
                return;
            }
            if (uu2Var.d() != null && uu2Var.d().getBizResult() != null) {
                AusResult ausResult = (AusResult) ko.e().parseJson(uu2Var.d().getBizResult(), (Class<Object>) AusResult.class);
                if (ausResult != null) {
                    ModifyAvatarActivity.this.uploadByMtop(ausResult.ossBucketName, ausResult.ossObjectKey);
                    cn.damai.common.image.a.b().c(ls.a(this.a)).g(ModifyAvatarActivity.this.img);
                    return;
                }
                a(uu2Var);
                return;
            }
            a(uu2Var);
        }
    }

    private Uri convert(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "350882008")) {
            return (Uri) ipChange.ipc$dispatch("350882008", new Object[]{this, str});
        }
        ContentResolver contentResolver = getContentResolver();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jn1.BRACKET_START_STR);
        stringBuffer.append("_data");
        stringBuffer.append("=");
        stringBuffer.append("'" + str + "'");
        stringBuffer.append(jn1.BRACKET_END_STR);
        Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, stringBuffer.toString(), null, null);
        if (query == null) {
            return null;
        }
        query.moveToFirst();
        while (!query.isAfterLast()) {
            i = query.getInt(query.getColumnIndex("_id"));
            query.moveToNext();
        }
        if (i == 0) {
            return null;
        }
        return Uri.parse("content://media/external/images/media/" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPermissionPostFix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "257502096") ? (String) ipChange.ipc$dispatch("257502096", new Object[]{this}) : TextUtils.equals(FROM_MODIFY_BIG_IMG, this.from) ? "用于选取、更新背景图" : TextUtils.equals(FROM_MODIFY_USERR_HEAD, this.from) ? "用于选取、更新头像" : "用于选取、更新图片";
    }

    private void gotoCropActivity(Uri uri) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259474089")) {
            ipChange.ipc$dispatch("259474089", new Object[]{this, uri});
            return;
        }
        File file = new File(getExternalCacheDir(), "cutcamera.png");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mCutUri = Uri.fromFile(file);
        int i2 = 16;
        if (Build.getMANUFACTURER().contains("HUAWEI")) {
            i = (this.height * 9999) / 16;
            i2 = 9998;
        } else {
            i = this.height;
        }
        Crop.b(uri, Uri.fromFile(file)).e(i2, i).c(this);
    }

    private void showPhotoDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1515427539")) {
            ipChange.ipc$dispatch("-1515427539", new Object[]{this});
            return;
        }
        CustomDialog customDialog = new CustomDialog(this, R$style.custom_dialog_style_nobg);
        this.dialog = customDialog;
        customDialog.e(new a());
        this.dialog.show();
        this.dialog.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadByMtop(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2116840748")) {
            ipChange.ipc$dispatch("-2116840748", new Object[]{this, str, str2});
            return;
        }
        UploadRequest uploadRequest = new UploadRequest();
        uploadRequest.bucketName = str;
        uploadRequest.key = str2;
        uploadRequest.loginKey = z20.q();
        DMMtopRequestListener<JSONObject> dMMtopRequestListener = new DMMtopRequestListener<JSONObject>(JSONObject.class) { // from class: cn.damai.user.ModifyAvatarActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "721370054")) {
                    ipChange2.ipc$dispatch("721370054", new Object[]{this, str3, str4});
                    return;
                }
                ModifyAvatarActivity.this.stopProgressDialog();
                ToastUtil.a().j(ModifyAvatarActivity.this, str4);
                ModifyAvatarActivity.this.setResult(100);
                ModifyAvatarActivity.this.finish();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(JSONObject jSONObject) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1204979833")) {
                    ipChange2.ipc$dispatch("-1204979833", new Object[]{this, jSONObject});
                    return;
                }
                ModifyAvatarActivity.this.stopProgressDialog();
                ModifyAvatarActivity.this.setResult(-1);
                ModifyAvatarActivity.this.finish();
            }
        };
        startProgressDialog();
        uploadRequest.request(dMMtopRequestListener);
    }

    private void uploadPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1289756683")) {
            ipChange.ipc$dispatch("1289756683", new Object[]{this, str});
            return;
        }
        ArrayList arrayList = new ArrayList();
        b bVar = new b(str);
        arrayList.add(str);
        if (TextUtils.isEmpty(this.from)) {
            return;
        }
        if (this.from.equals(FROM_MODIFY_BIG_IMG)) {
            FileUploader.q("damai_bgimg_oss").C(bVar).D(str);
        } else if (this.from.equals(FROM_MODIFY_USERR_HEAD)) {
            FileUploader.q("perico_oss").C(bVar).D(str);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975194248")) {
            ipChange.ipc$dispatch("1975194248", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2058753438") ? ((Integer) ipChange.ipc$dispatch("-2058753438", new Object[]{this})).intValue() : R$layout.modify_avatar;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1258845863")) {
            ipChange.ipc$dispatch("-1258845863", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001345010")) {
            ipChange.ipc$dispatch("1001345010", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097664363")) {
            ipChange.ipc$dispatch("1097664363", new Object[]{this});
            return;
        }
        this.img = (ImageView) findViewById(R$id.image_avatar);
        this.imgurl = getIntent().getStringExtra(MODIFY_AVATAR);
        this.from = getIntent().getStringExtra(FROM_WHERE);
        this.nickName = getIntent().getStringExtra("nickName");
        String stringExtra = getIntent().getStringExtra("mtopapi");
        this.mtopApi = stringExtra;
        if (wh2.j(stringExtra)) {
            this.useAus = false;
        }
        this.imggallery = getIntent().getBooleanExtra("imggallery", false);
        if (!wh2.j(this.imgurl)) {
            cn.damai.common.image.a.b().c(this.imgurl).g(this.img);
        }
        this.corpType = getIntent().getIntExtra(IMG_CORP_TYPE, 0);
        int c = yr2.c(this, DisplayMetrics.getheightPixels(t60.b(this)) / 2, 0, 375, 375);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.img.getLayoutParams();
        layoutParams.height = c;
        layoutParams.width = c;
        if (this.corpType == IMG_CORP_TYPE_169) {
            this.height = 9;
            int c2 = yr2.c(this, DisplayMetrics.getheightPixels(t60.b(this)) / 2, 0, 9, 16);
            layoutParams.height = (c2 * 9) / 16;
            layoutParams.width = c2;
        }
        this.img.setLayoutParams(layoutParams);
        setLeftNothing();
        this.base_head_title_view.setBackgroundColor(getResources().getColor(R$color.color_111111));
        this.base_header_title.setTextSize(16.0f);
        this.base_header_title.setTextColor(getResources().getColor(R$color.color_ffffff));
        if (this.imggallery) {
            return;
        }
        showPhotoDialog();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String path;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644299410")) {
            ipChange.ipc$dispatch("1644299410", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i != 6709) {
                switch (i) {
                    case 257:
                        if (intent == null) {
                            return;
                        }
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(s11.SELECT_RESULT);
                        if (cb2.d(stringArrayListExtra) || stringArrayListExtra.get(0) == null) {
                            return;
                        }
                        gotoCropActivity(convert(stringArrayListExtra.get(0)));
                        return;
                    case 258:
                        gotoCropActivity(Uri.fromFile(new File(hs1.a(this.mContext))));
                        return;
                    case 259:
                        break;
                    default:
                        return;
                }
            }
            Uri uri = this.mCutUri;
            if (uri == null || (path = uri.getPath()) == null || !this.useAus) {
                return;
            }
            uploadPic(path);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358884622")) {
            ipChange.ipc$dispatch("1358884622", new Object[]{this});
            return;
        }
        CustomDialog customDialog = this.dialog;
        if (customDialog != null) {
            customDialog.dismiss();
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1672580369")) {
            ipChange.ipc$dispatch("-1672580369", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("imggallery", false);
        this.imggallery = booleanExtra;
        if (booleanExtra) {
            return;
        }
        setDamaiUTKeyBuilder(new a.b().i("img_edit"));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16295288")) {
            ipChange.ipc$dispatch("-16295288", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158595213")) {
            ipChange.ipc$dispatch("1158595213", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1768491252")) {
            ipChange.ipc$dispatch("1768491252", new Object[]{this});
            return;
        }
        super.onResume();
        if (!this.imggallery) {
            if (getIntent() == null || wh2.j(getIntent().getStringExtra("title"))) {
                return;
            }
            setTitleContent(getIntent().getStringExtra("title"));
            return;
        }
        setTitleContent("查看头像");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "928578902") ? (String) ipChange.ipc$dispatch("928578902", new Object[]{this}) : "设置头像";
    }
}
