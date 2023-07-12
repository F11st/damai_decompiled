package cn.damai.commonbusiness.photoselect.imageselected;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.user.C0525a;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.photoselect.imageselected.adapter.ImageAdapter;
import cn.damai.commonbusiness.photoselect.imageselected.constant.Constants;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel;
import cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import tb.a21;
import tb.ir1;
import tb.is1;
import tb.kg2;
import tb.mr1;
import tb.s11;
import tb.vo0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImageSelectorActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int FOLDER_REQUEST_CODE = 100;
    private static final int PERMISSION_REQUEST_CODE = 17;
    private static final int REQUEST_CODE_TAKE_PHOTO = 101;
    private RelativeLayout bottomBar;
    private LinearLayout btnConfirm;
    private FrameLayout btnPreview;
    private LinearLayout btn_folder;
    private boolean isSingle;
    private boolean isToSettings = false;
    private ImageAdapter mAdapter;
    private long mDate;
    private String mFileName;
    private vo0 mFolder;
    private ArrayList<vo0> mFolders;
    private GridLayoutManager mLayoutManager;
    private int mMaxCount;
    private ArrayList<String> mSelectedImages;
    private File mTempFile;
    private RecyclerView rvImage;
    private View status_bar_gap;
    private TextView tvConfirm;
    private TextView tvConfirmNum;
    private TextView tvFolderName;
    private TextView tvPreview;
    private TextView tv_title_video;
    private String type;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0731a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0731a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "421571105")) {
                ipChange.ipc$dispatch("421571105", new Object[]{this, view});
            } else {
                ImageSelectorActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0732b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0732b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1762105822")) {
                ipChange.ipc$dispatch("-1762105822", new Object[]{this, view});
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(ImageSelectorActivity.this.mAdapter.l());
            ImageSelectorActivity.this.toPreviewActivity(arrayList, 0);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$c */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0733c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0733c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "349184547")) {
                ipChange.ipc$dispatch("349184547", new Object[]{this, view});
            } else {
                ImageSelectorActivity.this.confirm();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$d */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0734d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0734d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834492380")) {
                ipChange.ipc$dispatch("-1834492380", new Object[]{this, view});
                return;
            }
            ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
            ImageSelectFolderActivity.openActivity(imageSelectorActivity, 100, imageSelectorActivity.mAdapter.l(), ImageSelectorActivity.this.mFolders);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$e */
    /* loaded from: classes4.dex */
    public class C0735e implements ImageAdapter.OnImageSelectListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0735e() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.ImageAdapter.OnImageSelectListener
        public void OnImageSelect(Image image, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1287379560")) {
                ipChange.ipc$dispatch("-1287379560", new Object[]{this, image, Boolean.valueOf(z), Integer.valueOf(i)});
            } else {
                ImageSelectorActivity.this.setSelectImageCount(i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$f */
    /* loaded from: classes4.dex */
    public class C0736f implements ImageAdapter.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0736f() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.ImageAdapter.OnItemClickListener
        public void OnItemClick(Image image, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "689627163")) {
                ipChange.ipc$dispatch("689627163", new Object[]{this, image, Integer.valueOf(i)});
            } else if ("3".equals(image.getType())) {
                ImageSelectorActivity.this.openCamera();
            } else {
                ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
                imageSelectorActivity.toPreviewActivity(imageSelectorActivity.mAdapter.k(), i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$g */
    /* loaded from: classes4.dex */
    public class C0737g implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0737g() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "819126551")) {
                ipChange.ipc$dispatch("819126551", new Object[]{this});
                return;
            }
            is1.f().g("picture_upload");
            if (Build.VERSION.SDK_INT >= 24) {
                ImageSelectorActivity.this.takePhotoBiggerThan7();
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
            File externalCacheDir = ImageSelectorActivity.this.getExternalCacheDir();
            imageSelectorActivity.mTempFile = new File(externalCacheDir, format + ".jpg");
            intent.putExtra("output", Uri.fromFile(ImageSelectorActivity.this.mTempFile));
            ImageSelectorActivity.this.startActivityForResult(intent, 101);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity$h */
    /* loaded from: classes4.dex */
    public class C0738h implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0738h() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "308592374")) {
                ipChange.ipc$dispatch("308592374", new Object[]{this});
            } else {
                ImageSelectorActivity.this.loadDataForSdCard();
            }
        }
    }

    private void checkPermissionAndLoadImages() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956484763")) {
            ipChange.ipc$dispatch("-1956484763", new Object[]{this});
        } else if (Environment.getExternalStorageState().equals("mounted")) {
            String[] strArr = mr1.STORAGE;
            if (ir1.i(strArr)) {
                loadDataForSdCard();
            } else {
                ir1.d(this, false, strArr, "该相册需要赋予访问存储的权限，请到“设置”>“应用”>“权限”中配置权限。", new C0738h());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425514183")) {
            ipChange.ipc$dispatch("425514183", new Object[]{this});
            return;
        }
        ImageAdapter imageAdapter = this.mAdapter;
        if (imageAdapter == null) {
            return;
        }
        ArrayList<Image> l = imageAdapter.l();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Image> it = l.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPath());
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra(s11.SELECT_RESULT, arrayList);
        intent.putParcelableArrayListExtra("imagelist", l);
        setResult(-1, intent);
        finish();
    }

    private void initImageList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704898046")) {
            ipChange.ipc$dispatch("704898046", new Object[]{this});
            return;
        }
        if (getResources().getConfiguration().orientation == 1) {
            this.mLayoutManager = new GridLayoutManager(this, MediaUtils.e);
        } else {
            this.mLayoutManager = new GridLayoutManager(this, 5);
        }
        this.rvImage.setLayoutManager(this.mLayoutManager);
        ImageAdapter imageAdapter = new ImageAdapter(this, this.mMaxCount, this.isSingle);
        this.mAdapter = imageAdapter;
        this.rvImage.setAdapter(imageAdapter);
        ((SimpleItemAnimator) this.rvImage.getItemAnimator()).setSupportsChangeAnimations(false);
        ArrayList<vo0> arrayList = this.mFolders;
        if (arrayList != null && !arrayList.isEmpty()) {
            setFolder(this.mFolders.get(0));
        }
        this.mAdapter.u(new C0735e());
        this.mAdapter.v(new C0736f());
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466663873")) {
            ipChange.ipc$dispatch("-466663873", new Object[]{this});
            return;
        }
        findViewById(R$id.btn_back).setOnClickListener(new View$OnClickListenerC0731a());
        this.btnPreview.setOnClickListener(new View$OnClickListenerC0732b());
        this.btnConfirm.setOnClickListener(new View$OnClickListenerC0733c());
        findViewById(R$id.btn_folder).setOnClickListener(new View$OnClickListenerC0734d());
        this.rvImage.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1569673615")) {
                    ipChange2.ipc$dispatch("-1569673615", new Object[]{this, recyclerView, Integer.valueOf(i)});
                } else {
                    super.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-621668722")) {
                    ipChange2.ipc$dispatch("-621668722", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    super.onScrolled(recyclerView, i, i2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadDataForSdCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750771347")) {
            ipChange.ipc$dispatch("-750771347", new Object[]{this});
        } else if ("2".equals(this.type)) {
            loadVideoForSdCard();
        } else {
            loadImageForSDCard(false);
        }
    }

    private void loadImageForSDCard(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565600506")) {
            ipChange.ipc$dispatch("-565600506", new Object[]{this, Boolean.valueOf(z)});
        } else {
            ImageModel.loadImageForSDCard(this, new ImageModel.DataCallback() { // from class: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.10
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel.DataCallback
                public void onSuccess(ArrayList<vo0> arrayList) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1926029558")) {
                        ipChange2.ipc$dispatch("1926029558", new Object[]{this, arrayList});
                        return;
                    }
                    ImageSelectorActivity.this.mFolders = arrayList;
                    ImageSelectorActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.10.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1162622720")) {
                                ipChange3.ipc$dispatch("-1162622720", new Object[]{this});
                            } else if (ImageSelectorActivity.this.mFolders == null || ImageSelectorActivity.this.mFolders.isEmpty()) {
                            } else {
                                Image image = new Image();
                                image.setType("3");
                                image.setPath("take_picture");
                                if (wh2.e(((vo0) ImageSelectorActivity.this.mFolders.get(0)).b()) > 0) {
                                    ((vo0) ImageSelectorActivity.this.mFolders.get(0)).b().add(0, image);
                                } else {
                                    ArrayList<Image> arrayList2 = new ArrayList<>();
                                    arrayList2.add(image);
                                    ((vo0) ImageSelectorActivity.this.mFolders.get(0)).d(arrayList2);
                                }
                                ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
                                imageSelectorActivity.setFolder((vo0) imageSelectorActivity.mFolders.get(0));
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                if (z) {
                                    Image image2 = ((vo0) ImageSelectorActivity.this.mFolders.get(0)).b().get(1);
                                    image2.setShowNum(ImageSelectorActivity.this.mAdapter.l().size() + 1);
                                    ImageSelectorActivity.this.mAdapter.l().add(image2);
                                    ImageSelectorActivity.this.mAdapter.notifyDataSetChanged();
                                    ImageSelectorActivity imageSelectorActivity2 = ImageSelectorActivity.this;
                                    imageSelectorActivity2.setSelectImageCount(imageSelectorActivity2.mAdapter.l().size());
                                }
                                ImageSelectorActivity.this.setSelectImage();
                            }
                        }
                    });
                }
            });
        }
    }

    private void loadVideoForSdCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092820110")) {
            ipChange.ipc$dispatch("1092820110", new Object[]{this});
            return;
        }
        startProgressDialog();
        MediaUtils.c().f(this, new ImageModel.DataCallback() { // from class: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel.DataCallback
            public void onSuccess(final ArrayList<vo0> arrayList) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2039171977")) {
                    ipChange2.ipc$dispatch("-2039171977", new Object[]{this, arrayList});
                    return;
                }
                ImageSelectorActivity.this.stopProgressDialog();
                ImageSelectorActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.11.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1033540001")) {
                            ipChange3.ipc$dispatch("-1033540001", new Object[]{this});
                            return;
                        }
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2 == null || arrayList2.size() <= 0 || arrayList.get(0) == null) {
                            return;
                        }
                        ArrayList<Image> b = ((vo0) arrayList.get(0)).b();
                        if (b != null && b.size() > 0 && ImageSelectorActivity.this.mAdapter != null) {
                            ImageSelectorActivity.this.rvImage.scrollToPosition(0);
                            ImageSelectorActivity.this.mAdapter.q(b);
                        }
                        ImageSelectorActivity.this.setSelectImage();
                    }
                });
            }
        });
    }

    public static void openActivity(Activity activity, int i, boolean z, int i2, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641236396")) {
            ipChange.ipc$dispatch("-1641236396", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), arrayList});
            return;
        }
        Intent intent = new Intent(activity, ImageSelectorActivity.class);
        intent.putExtra(Constants.MAX_SELECT_COUNT, i2);
        intent.putExtra(Constants.IS_SINGLE, z);
        intent.putStringArrayListExtra("selected", arrayList);
        activity.startActivityForResult(intent, i);
    }

    private Uri saveAppDCIMFils(Bitmap bitmap, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546379399")) {
            return (Uri) ipChange.ipc$dispatch("-546379399", new Object[]{this, bitmap, str});
        }
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", "DCIM/DM/");
        } else {
            contentValues.put("_data", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());
        }
        contentValues.put("mime_type", "image/jpeg");
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream openOutputStream = getContentResolver().openOutputStream(insert);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, openOutputStream);
            openOutputStream.flush();
            openOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolder(vo0 vo0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035323416")) {
            ipChange.ipc$dispatch("2035323416", new Object[]{this, vo0Var});
        } else if (vo0Var == null || this.mAdapter == null || vo0Var.equals(this.mFolder)) {
        } else {
            this.mFolder = vo0Var;
            this.tvFolderName.setText(vo0Var.c());
            this.rvImage.scrollToPosition(0);
            this.mAdapter.q(vo0Var.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectImage() {
        ImageAdapter imageAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880389626")) {
            ipChange.ipc$dispatch("-880389626", new Object[]{this});
        } else if ("2".equals(this.type)) {
            setSelectImageCount(0);
        } else {
            ArrayList<String> arrayList = this.mSelectedImages;
            if (arrayList == null || (imageAdapter = this.mAdapter) == null) {
                return;
            }
            imageAdapter.w(arrayList);
            this.mSelectedImages = null;
            if (this.mAdapter.l() != null && this.mAdapter.l().size() > 0) {
                setSelectImageCount(this.mAdapter.l().size());
            } else {
                setSelectImageCount(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectImageCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069785746")) {
            ipChange.ipc$dispatch("-1069785746", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.btnConfirm.setEnabled(false);
            this.btnPreview.setEnabled(false);
            this.btnConfirm.setBackgroundResource(R$drawable.submit_unable_btn_h36);
            this.tvPreview.setTextColor(Color.parseColor("#66666666"));
            this.tvConfirmNum.setVisibility(8);
        } else {
            this.btnConfirm.setEnabled(true);
            this.btnPreview.setEnabled(true);
            this.btnConfirm.setBackgroundResource(R$drawable.submit_enable_btn_h36);
            this.tvPreview.setTextColor(Color.parseColor("#666666"));
            TextView textView = this.tvConfirmNum;
            textView.setText(i + "");
            this.tvConfirmNum.setVisibility(0);
        }
    }

    private void setStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-121392029")) {
            ipChange.ipc$dispatch("-121392029", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.status_bar_gap;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.status_bar_gap.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            View view2 = this.status_bar_gap;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private void startAppSettings() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711726399")) {
            ipChange.ipc$dispatch("-1711726399", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhotoBiggerThan7() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70323348")) {
            ipChange.ipc$dispatch("-70323348", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        long time = new Date().getTime();
        this.mDate = time;
        this.mFileName = simpleDateFormat.format(Long.valueOf(time));
        File externalCacheDir = getExternalCacheDir();
        this.mTempFile = new File(externalCacheDir, this.mFileName + ".jpg");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("_data", this.mTempFile.getAbsolutePath());
        Uri insert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        intent.putExtra("output", insert);
        startActivityForResult(intent, 101);
        Log.d("xxtag", "path   ======  " + this.mTempFile.getAbsolutePath());
        Log.d("xxtag", "uri from insert: ======  " + insert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toPreviewActivity(ArrayList<Image> arrayList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133485852")) {
            ipChange.ipc$dispatch("-1133485852", new Object[]{this, arrayList, Integer.valueOf(i)});
        } else if (arrayList == null || arrayList.isEmpty()) {
        } else {
            PreviewActivity.openActivity(this, arrayList, this.mAdapter.l(), this.isSingle, this.mMaxCount, i, this.type);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411236917")) {
            ipChange.ipc$dispatch("-411236917", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1424508609") ? ((Integer) ipChange.ipc$dispatch("-1424508609", new Object[]{this})).intValue() : R$layout.activity_image_select;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222874652")) {
            ipChange.ipc$dispatch("1222874652", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625269647")) {
            ipChange.ipc$dispatch("625269647", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737223598")) {
            ipChange.ipc$dispatch("1737223598", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        this.mMaxCount = intent.getIntExtra(Constants.MAX_SELECT_COUNT, 0);
        this.isSingle = intent.getBooleanExtra(Constants.IS_SINGLE, false);
        this.mSelectedImages = intent.getStringArrayListExtra("selected");
        this.type = intent.getStringExtra("type");
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<vo0> arrayList;
        int intExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664902165")) {
            ipChange.ipc$dispatch("664902165", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 18) {
            if (intent != null && intent.getBooleanExtra(Constants.IS_CONFIRM, false)) {
                confirm();
                return;
            }
            this.mAdapter.notifyDataSetChanged();
            setSelectImageCount(this.mAdapter.l().size());
        } else if (i == 100) {
            if (intent == null || (arrayList = this.mFolders) == null || arrayList.isEmpty() || this.mFolders.size() <= (intExtra = intent.getIntExtra("position", 0))) {
                return;
            }
            setFolder(this.mFolders.get(intExtra));
        } else if (i2 == -1 && i == 101) {
            try {
                a21.d(this, this.mTempFile);
                if (Build.VERSION.SDK_INT <= 29) {
                    saveAppDCIMFils(BitmapFactory.decodeFile(this.mTempFile.getAbsolutePath()), this.mFileName);
                }
                loadImageForSDCard(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1723357814")) {
            ipChange.ipc$dispatch("-1723357814", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager == null || this.mAdapter == null) {
            return;
        }
        int i = configuration.orientation;
        if (i == 1) {
            gridLayoutManager.setSpanCount(MediaUtils.e);
        } else if (i == 2) {
            gridLayoutManager.setSpanCount(5);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614144052")) {
            ipChange.ipc$dispatch("-614144052", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        removeHeadTitleView();
        this.status_bar_gap = findViewById(R$id.title_bar_space_view);
        this.tv_title_video = (TextView) findViewById(R$id.tv_title_video);
        this.btn_folder = (LinearLayout) findViewById(R$id.btn_folder);
        this.rvImage = (RecyclerView) findViewById(R$id.rv_image);
        this.bottomBar = (RelativeLayout) findViewById(R$id.rl_bottom_bar);
        this.tvConfirmNum = (TextView) findViewById(R$id.tv_confirm_num);
        this.tvConfirm = (TextView) findViewById(R$id.tv_confirm);
        this.tvPreview = (TextView) findViewById(R$id.tv_preview);
        this.btnConfirm = (LinearLayout) findViewById(R$id.btn_confirm);
        this.btnPreview = (FrameLayout) findViewById(R$id.btn_preview);
        this.tvFolderName = (TextView) findViewById(R$id.tv_folder_name);
        setStatusBarColor();
        initListener();
        initImageList();
        checkPermissionAndLoadImages();
        if ("2".equals(this.type)) {
            this.tv_title_video.setVisibility(0);
            this.btn_folder.setVisibility(8);
            this.bottomBar.setVisibility(8);
        } else {
            this.tv_title_video.setVisibility(8);
            this.btn_folder.setVisibility(0);
            this.bottomBar.setVisibility(0);
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("select_pic"));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829542069")) {
            ipChange.ipc$dispatch("-1829542069", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792840042")) {
            ipChange.ipc$dispatch("1792840042", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625107228")) {
            ipChange.ipc$dispatch("-625107228", new Object[]{this});
            return;
        }
        super.onStart();
        if (this.isToSettings) {
            this.isToSettings = false;
            checkPermissionAndLoadImages();
        }
    }

    public void openCamera() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711682124")) {
            ipChange.ipc$dispatch("-1711682124", new Object[]{this});
        } else {
            ir1.b(this, false, mr1.CAMERA, "用于选取、上传、发布及分享图片/视频", new C0737g());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-732887693") ? (String) ipChange.ipc$dispatch("-732887693", new Object[]{this}) : "";
    }

    public static void openActivity(Activity activity, int i, boolean z, int i2, String str, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343287222")) {
            ipChange.ipc$dispatch("-343287222", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, arrayList});
            return;
        }
        Intent intent = new Intent(activity, ImageSelectorActivity.class);
        intent.putExtra(Constants.MAX_SELECT_COUNT, i2);
        intent.putExtra(Constants.IS_SINGLE, z);
        intent.putStringArrayListExtra("selected", arrayList);
        intent.putExtra("type", str);
        activity.startActivityForResult(intent, i);
    }
}
