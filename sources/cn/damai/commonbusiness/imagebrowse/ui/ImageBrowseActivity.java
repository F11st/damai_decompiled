package cn.damai.commonbusiness.imagebrowse.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.imagebrowse.adapter.ImageBrowseAdapter;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import tb.cb1;
import tb.i11;
import tb.ir1;
import tb.iu0;
import tb.mr1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImageBrowseActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = ImageBrowseActivity.class.getSimpleName();
    private ImageBrowseAdapter adapter;
    private TextView cursor;
    private DMIconFontTextView mBackView;
    private int mCurPosition;
    private View.OnClickListener mOnImageDownloadClickListener;
    private ImageBrowseAdapter.OnImageLongClickListener mOnImageLongClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private List<PicInfo> mPicInfoList;
    private String mProjectId;
    private TextView mTitleView;
    private DMIconFontTextView mTvImageDownload;
    private TextView mTvPicDesc;
    private DmViewPager viewerPager;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity$7  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass7 implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Bitmap a;

        AnonymousClass7(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1163356454")) {
                ipChange.ipc$dispatch("-1163356454", new Object[]{this});
            } else {
                iu0.b().a(new Runnable() { // from class: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity.7.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1432768350")) {
                            ipChange2.ipc$dispatch("1432768350", new Object[]{this});
                            return;
                        }
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        Bitmap bitmap = anonymousClass7.a;
                        if (bitmap == null) {
                            return;
                        }
                        String saveBitmapToDcimDir = ShareUtil.saveBitmapToDcimDir(ImageBrowseActivity.this, bitmap);
                        if (!TextUtils.isEmpty(saveBitmapToDcimDir)) {
                            ImageBrowseActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(saveBitmapToDcimDir))));
                            ImageBrowseActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity.7.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-152850575")) {
                                        ipChange3.ipc$dispatch("-152850575", new Object[]{this});
                                    } else {
                                        ToastUtil.a().e(ImageBrowseActivity.this, "已保存到本地相册");
                                    }
                                }
                            });
                            return;
                        }
                        ImageBrowseActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity.7.1.2
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-349364080")) {
                                    ipChange3.ipc$dispatch("-349364080", new Object[]{this});
                                } else {
                                    ToastUtil.a().e(ImageBrowseActivity.this, "保存失败");
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0716a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0716a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "834834111")) {
                ipChange.ipc$dispatch("834834111", new Object[]{this, view});
            } else {
                ImageBrowseActivity.this.onBackPressed();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0717b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0717b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "762447553")) {
                ipChange.ipc$dispatch("762447553", new Object[]{this, view});
                return;
            }
            ImageBrowseActivity imageBrowseActivity = ImageBrowseActivity.this;
            imageBrowseActivity.saveImageToLocalGallery(imageBrowseActivity.mCurPosition);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity$c */
    /* loaded from: classes4.dex */
    public class C0718c implements ImageBrowseAdapter.OnImageLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0718c() {
        }

        @Override // cn.damai.commonbusiness.imagebrowse.adapter.ImageBrowseAdapter.OnImageLongClickListener
        public void onLongClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714743465")) {
                ipChange.ipc$dispatch("-1714743465", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            String str = ImageBrowseActivity.TAG;
            cb1.b(str, "long click to save image, position = " + i);
            ImageBrowseActivity.this.saveImageToLocalGallery(i);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity$d */
    /* loaded from: classes4.dex */
    public class C0719d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0719d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "973048181")) {
                ipChange.ipc$dispatch("973048181", new Object[]{this, c0501d});
            } else {
                ToastUtil.a().e(ImageBrowseActivity.this, "保存失败");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity$e */
    /* loaded from: classes4.dex */
    public class C0720e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0720e() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-237908150")) {
                ipChange.ipc$dispatch("-237908150", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                ImageBrowseActivity.this.saveToLocal(bitmap);
            }
        }
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856785857")) {
            ipChange.ipc$dispatch("-856785857", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        this.mProjectId = intent.getStringExtra("projectId");
        Serializable serializableExtra = intent.getSerializableExtra("pic_info");
        if (serializableExtra != null) {
            this.mPicInfoList = (List) serializableExtra;
        }
        this.mCurPosition = intent.getIntExtra("position", -1);
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777206854")) {
            ipChange.ipc$dispatch("-777206854", new Object[]{this});
            return;
        }
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: cn.damai.commonbusiness.imagebrowse.ui.ImageBrowseActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1044068206")) {
                    ipChange2.ipc$dispatch("-1044068206", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "139331377")) {
                    ipChange2.ipc$dispatch("139331377", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1265052067")) {
                    ipChange2.ipc$dispatch("-1265052067", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                ImageBrowseActivity.this.mCurPosition = i;
                ImageBrowseActivity.this.setImagePositionIndicator();
                ImageBrowseActivity.this.updateImageIntroduce();
            }
        };
        this.mOnImageDownloadClickListener = new View$OnClickListenerC0717b();
        this.mOnImageLongClickListener = new C0718c();
    }

    private void initPosterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037311425")) {
            ipChange.ipc$dispatch("-1037311425", new Object[]{this});
            return;
        }
        this.cursor = (TextView) findViewById(R$id.image_browse_position_tv);
        setImagePositionIndicator();
        this.viewerPager = (DmViewPager) findViewById(R$id.image_browse_viewer);
        ImageBrowseAdapter imageBrowseAdapter = new ImageBrowseAdapter(this, this.mPicInfoList);
        this.adapter = imageBrowseAdapter;
        this.viewerPager.setAdapter(imageBrowseAdapter);
        this.mTvPicDesc = (TextView) findViewById(R$id.image_intro_tv);
        this.mTvImageDownload = (DMIconFontTextView) findViewById(R$id.download_image_tv);
        updateImageIntroduce();
    }

    private void initTitleBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764938858")) {
            ipChange.ipc$dispatch("-1764938858", new Object[]{this});
            return;
        }
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.image_browse_back_tv);
        this.mBackView = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new View$OnClickListenerC0716a());
        this.mTitleView = (TextView) findViewById(R$id.image_browse_title_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageToLocalGallery(int i) {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407588602")) {
            ipChange.ipc$dispatch("1407588602", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<PicInfo> list = this.mPicInfoList;
        if (list == null || i >= list.size() || (picInfo = this.mPicInfoList.get(i)) == null || TextUtils.isEmpty(picInfo.getPicUrl())) {
            return;
        }
        C0504a.b().c(picInfo.getPicUrl()).n(new C0720e()).e(new C0719d()).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImagePositionIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564528700")) {
            ipChange.ipc$dispatch("564528700", new Object[]{this});
            return;
        }
        List<PicInfo> list = this.mPicInfoList;
        if (list == null || list.size() <= 1) {
            return;
        }
        TextView textView = this.cursor;
        textView.setText((this.mCurPosition + 1) + "/" + this.mPicInfoList.size());
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266512575")) {
            ipChange.ipc$dispatch("266512575", new Object[]{this});
            return;
        }
        this.viewerPager.addOnPageChangeListener(this.mOnPageChangeListener);
        this.viewerPager.setCurrentItem(this.mCurPosition);
        this.mTvImageDownload.setOnClickListener(this.mOnImageDownloadClickListener);
        this.adapter.c(this.mOnImageLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageIntroduce() {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516969740")) {
            ipChange.ipc$dispatch("-1516969740", new Object[]{this});
            return;
        }
        List<PicInfo> list = this.mPicInfoList;
        if (list == null || this.mCurPosition >= list.size() || (picInfo = this.mPicInfoList.get(this.mCurPosition)) == null) {
            return;
        }
        String picTitle = picInfo.getPicTitle();
        TextView textView = this.mTitleView;
        if (TextUtils.isEmpty(picTitle)) {
            picTitle = "";
        }
        textView.setText(picTitle);
        String picDesc = picInfo.getPicDesc();
        this.mTvPicDesc.setText(TextUtils.isEmpty(picDesc) ? "" : picDesc);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900701545")) {
            ipChange.ipc$dispatch("1900701545", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "377441505") ? ((Integer) ipChange.ipc$dispatch("377441505", new Object[]{this})).intValue() : R$layout.activity_image_browse_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248753338")) {
            ipChange.ipc$dispatch("1248753338", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427508913")) {
            ipChange.ipc$dispatch("1427508913", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "560713036")) {
            ipChange.ipc$dispatch("560713036", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtraData();
        initTitleBar();
        initPosterView();
        initListeners();
        setupListeners();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519565874")) {
            ipChange.ipc$dispatch("1519565874", new Object[]{this, view});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784660334")) {
            ipChange.ipc$dispatch("784660334", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(i11.g().f(this.mProjectId));
    }

    public void saveToLocal(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "302200600")) {
            ipChange.ipc$dispatch("302200600", new Object[]{this, bitmap});
        } else {
            ir1.b(this, false, mr1.STORAGE, "用于为您保存图片/视频至本地", new AnonymousClass7(bitmap));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705732715")) {
            return (String) ipChange.ipc$dispatch("-1705732715", new Object[]{this});
        }
        return null;
    }
}
