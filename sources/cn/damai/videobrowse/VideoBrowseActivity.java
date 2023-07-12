package cn.damai.videobrowse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.videobrowse.fragment.ImageFragment;
import cn.damai.videobrowse.view.ControlScrollViewPager;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb1;
import tb.cb2;
import tb.ir1;
import tb.iu0;
import tb.kg2;
import tb.mr1;
import tb.tx2;
import tb.ys;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class VideoBrowseActivity extends DamaiBaseActivity implements ImageFragment.OnImageLongClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = VideoBrowseActivity.class.getSimpleName();
    private TextView cursor;
    private DMIconFontTextView mBackView;
    private int mCurPosition;
    private int mCurScreenOrientation;
    private LinearLayout mLvIntroduceInfo;
    private View.OnClickListener mOnImageDownloadClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private List<PicInfo> mPicInfoList;
    private int mPicNum;
    private String mProjectId;
    private RelativeLayout mRvTitleBar;
    private DMIconFontTextView mTvImageDownload;
    private TextView mTvIntro;
    private String mVideoId;
    private VideoImageAdapter mVideoImageAdapter;
    private List<VideoInfo> mVideoInfoList;
    private int mVideoNum;
    private ControlScrollViewPager mViewerPager;
    private View status_bar_gap;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.VideoBrowseActivity$6  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass6 implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Bitmap a;

        AnonymousClass6(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1738543144")) {
                ipChange.ipc$dispatch("-1738543144", new Object[]{this});
            } else {
                iu0.b().a(new Runnable() { // from class: cn.damai.videobrowse.VideoBrowseActivity.6.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-96610468")) {
                            ipChange2.ipc$dispatch("-96610468", new Object[]{this});
                            return;
                        }
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        Bitmap bitmap = anonymousClass6.a;
                        if (bitmap == null) {
                            return;
                        }
                        String saveBitmapToDcimDir = ShareUtil.saveBitmapToDcimDir(VideoBrowseActivity.this, bitmap);
                        if (!TextUtils.isEmpty(saveBitmapToDcimDir)) {
                            VideoBrowseActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(saveBitmapToDcimDir))));
                            VideoBrowseActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.videobrowse.VideoBrowseActivity.6.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-1007079441")) {
                                        ipChange3.ipc$dispatch("-1007079441", new Object[]{this});
                                    } else {
                                        ToastUtil.a().e(VideoBrowseActivity.this, "已保存到本地相册");
                                    }
                                }
                            });
                            return;
                        }
                        VideoBrowseActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.videobrowse.VideoBrowseActivity.6.1.2
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-1203592946")) {
                                    ipChange3.ipc$dispatch("-1203592946", new Object[]{this});
                                } else {
                                    ToastUtil.a().e(VideoBrowseActivity.this, "保存失败");
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.VideoBrowseActivity$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2782a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2782a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1161579906")) {
                ipChange.ipc$dispatch("1161579906", new Object[]{this, view});
            } else {
                VideoBrowseActivity.this.onBackPressed();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.VideoBrowseActivity$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2783b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2783b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PicInfo picInfo;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1089193348")) {
                ipChange.ipc$dispatch("1089193348", new Object[]{this, view});
            } else if (VideoBrowseActivity.this.mCurPosition < VideoBrowseActivity.this.mVideoNum || VideoBrowseActivity.this.mCurPosition >= VideoBrowseActivity.this.mVideoNum + VideoBrowseActivity.this.mPicNum || (picInfo = (PicInfo) VideoBrowseActivity.this.mPicInfoList.get(VideoBrowseActivity.this.mCurPosition - VideoBrowseActivity.this.mVideoNum)) == null || TextUtils.isEmpty(picInfo.getPicUrl())) {
            } else {
                VideoBrowseActivity.this.saveImageToLocalGallery(picInfo.getPicUrl());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.VideoBrowseActivity$c */
    /* loaded from: classes9.dex */
    public class C2784c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2784c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-688540361")) {
                ipChange.ipc$dispatch("-688540361", new Object[]{this, c0501d});
            } else {
                ToastUtil.a().e(VideoBrowseActivity.this, "保存失败");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.VideoBrowseActivity$d */
    /* loaded from: classes9.dex */
    public class C2785d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2785d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1085579660")) {
                ipChange.ipc$dispatch("1085579660", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                VideoBrowseActivity.this.saveToLocal(bitmap);
            }
        }
    }

    private void fixStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883469736")) {
            ipChange.ipc$dispatch("-883469736", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.status_bar_gap;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.status_bar_gap.setVisibility(0);
            }
            kg2.f(this, true, R$color.white);
            kg2.e(this);
        } else {
            kg2.f(this, false, R$color.white);
            View view2 = this.status_bar_gap;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private String getCurVideoId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372636966")) {
            return (String) ipChange.ipc$dispatch("1372636966", new Object[]{this});
        }
        if (this.mCurPosition < this.mVideoNum) {
            VideoInfo videoInfo = null;
            List<VideoInfo> list = this.mVideoInfoList;
            if (list != null && list.size() > 0) {
                videoInfo = this.mVideoInfoList.get(this.mCurPosition);
            }
            return videoInfo != null ? videoInfo.getVid() : "";
        }
        return "";
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557486116")) {
            ipChange.ipc$dispatch("-557486116", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        this.mProjectId = intent.getStringExtra("projectId");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("pic_info");
        this.mPicInfoList = parcelableArrayListExtra;
        if (cb2.d(parcelableArrayListExtra)) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("pic_info_map");
            if (!cb2.d(arrayList)) {
                this.mPicInfoList = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl((String) ((HashMap) it.next()).get("img"));
                    this.mPicInfoList.add(picInfo);
                }
            }
        }
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("video_info");
        this.mVideoInfoList = parcelableArrayListExtra2;
        if (cb2.d(parcelableArrayListExtra2)) {
            ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("video_info_map");
            if (!cb2.d(arrayList2)) {
                this.mVideoInfoList = new ArrayList();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    HashMap hashMap = (HashMap) it2.next();
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.setPicUrl((String) hashMap.get("img"));
                    videoInfo.setVideoUrl((String) hashMap.get("url"));
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                    this.mVideoInfoList.add(videoInfo);
                }
            }
        }
        this.mCurPosition = intent.getIntExtra("position", -1);
        List<VideoInfo> list = this.mVideoInfoList;
        if (list != null && !list.isEmpty()) {
            this.mVideoNum = this.mVideoInfoList.size();
        }
        List<PicInfo> list2 = this.mPicInfoList;
        if (list2 != null && !list2.isEmpty()) {
            this.mPicNum = this.mPicInfoList.size();
        }
        this.mCurScreenOrientation = 1;
        try {
            int i = this.mCurPosition;
            if (i < 0 || this.mVideoNum < i + 1) {
                return;
            }
            VideoInfo videoInfo2 = this.mVideoInfoList.get(i);
            String vid = videoInfo2.getVid();
            this.mVideoId = vid;
            if (TextUtils.isEmpty(vid)) {
                this.mVideoId = videoInfo2.getVideoUrl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477907113")) {
            ipChange.ipc$dispatch("-477907113", new Object[]{this});
            return;
        }
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: cn.damai.videobrowse.VideoBrowseActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1183229295")) {
                    ipChange2.ipc$dispatch("1183229295", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                String str = VideoBrowseActivity.TAG;
                cb1.b(str, "onPageScrolled(), state = " + i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-585821938")) {
                    ipChange2.ipc$dispatch("-585821938", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    return;
                }
                String str = VideoBrowseActivity.TAG;
                cb1.b(str, "onPageScrolled(), positionOffset = " + f + ", positionOffsetPixels = " + i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1415754618")) {
                    ipChange2.ipc$dispatch("1415754618", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                String str = VideoBrowseActivity.TAG;
                cb1.b(str, "onPageSelected(), position = " + i);
                VideoBrowseActivity.this.mCurPosition = i;
                VideoBrowseActivity.this.setImagePositionIndicator();
                VideoBrowseActivity.this.updateIntroduceContent();
            }
        };
        this.mOnImageDownloadClickListener = new View$OnClickListenerC2783b();
    }

    private void initPosterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348954046")) {
            ipChange.ipc$dispatch("-348954046", new Object[]{this});
            return;
        }
        this.cursor = (TextView) findViewById(R$id.video_image_browse_position_tv);
        setImagePositionIndicator();
        this.mViewerPager = (ControlScrollViewPager) findViewById(R$id.video_image_browse_viewer);
        VideoImageAdapter videoImageAdapter = new VideoImageAdapter(getSupportFragmentManager(), this.mProjectId, this.mVideoInfoList, this.mPicInfoList);
        this.mVideoImageAdapter = videoImageAdapter;
        this.mViewerPager.setAdapter(videoImageAdapter);
        this.mViewerPager.setScroll(true);
        this.mLvIntroduceInfo = (LinearLayout) findViewById(R$id.video_image_info_rv);
        this.mTvIntro = (TextView) findViewById(R$id.video_image_intro_tv);
        this.mTvImageDownload = (DMIconFontTextView) findViewById(R$id.image_download_tv);
        updateIntroduceContent();
    }

    private void initTitleViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196299170")) {
            ipChange.ipc$dispatch("-196299170", new Object[]{this});
            return;
        }
        this.status_bar_gap = findViewById(R$id.status_bar_gap);
        this.mRvTitleBar = (RelativeLayout) findViewById(R$id.video_image_browse_title_bar);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.video_image_browse_back_tv);
        this.mBackView = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new View$OnClickListenerC2782a());
        fixStatusBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageToLocalGallery(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169876688")) {
            ipChange.ipc$dispatch("1169876688", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            C0504a.b().c(str).n(new C2785d()).e(new C2784c()).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImagePositionIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939297191")) {
            ipChange.ipc$dispatch("-939297191", new Object[]{this});
        } else if (this.mVideoNum + this.mPicNum > 1) {
            TextView textView = this.cursor;
            textView.setText((this.mCurPosition + 1) + "/" + (this.mVideoNum + this.mPicNum));
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954869954")) {
            ipChange.ipc$dispatch("954869954", new Object[]{this});
            return;
        }
        this.mViewerPager.addOnPageChangeListener(this.mOnPageChangeListener);
        this.mViewerPager.setCurrentItem(this.mCurPosition);
        this.mTvImageDownload.setOnClickListener(this.mOnImageDownloadClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIntroduceContent() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121148705")) {
            ipChange.ipc$dispatch("121148705", new Object[]{this});
            return;
        }
        str = "";
        int i = this.mCurPosition;
        int i2 = this.mVideoNum;
        if (i < i2) {
            VideoInfo videoInfo = null;
            List<VideoInfo> list = this.mVideoInfoList;
            if (list != null && list.size() > 0) {
                videoInfo = this.mVideoInfoList.get(this.mCurPosition);
            }
            str = videoInfo != null ? videoInfo.getTitle() : "";
            this.mTvImageDownload.setVisibility(8);
        } else {
            int i3 = this.mPicNum;
            if (i3 > 0 && i < i3 + i2) {
                PicInfo picInfo = this.mPicInfoList.get(i - i2);
                str = picInfo != null ? picInfo.getPicDesc() : "";
                this.mLvIntroduceInfo.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.mTvIntro.setVisibility(8);
            this.mLvIntroduceInfo.setVisibility(8);
            return;
        }
        this.mTvIntro.setVisibility(0);
        this.mLvIntroduceInfo.setVisibility(0);
        this.mTvIntro.setText(str);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987179180")) {
            ipChange.ipc$dispatch("1987179180", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-708279362") ? ((Integer) ipChange.ipc$dispatch("-708279362", new Object[]{this})).intValue() : R$layout.activity_video_image_browse_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951144829")) {
            ipChange.ipc$dispatch("1951144829", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726808654")) {
            ipChange.ipc$dispatch("1726808654", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101206927")) {
            ipChange.ipc$dispatch("101206927", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtraData();
        initTitleViews();
        initPosterView();
        initListeners();
        setupListeners();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084348266")) {
            ipChange.ipc$dispatch("2084348266", new Object[]{this});
        } else if (ys.d().e()) {
            tx2.g().i("fullscreen", Constants.Event.RETURN, false, this.mProjectId, getCurVideoId(), z20.E());
        } else {
            tx2.g().i("top", Constants.Event.RETURN, true, this.mProjectId, getCurVideoId(), z20.E());
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283009461")) {
            ipChange.ipc$dispatch("-1283009461", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        cb1.b(TAG, "onCreate()");
        setDamaiUTKeyBuilder(tx2.g().f(this.mProjectId, this.mVideoId, z20.E()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181721675")) {
            ipChange.ipc$dispatch("181721675", new Object[]{this});
            return;
        }
        super.onDestroy();
        cb1.b(TAG, "onDestroy()");
    }

    @Override // cn.damai.videobrowse.fragment.ImageFragment.OnImageLongClickListener
    public void onImageLongClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489145406")) {
            ipChange.ipc$dispatch("1489145406", new Object[]{this, str});
        } else {
            saveImageToLocalGallery(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772865231")) {
            ipChange.ipc$dispatch("1772865231", new Object[]{this});
            return;
        }
        super.onPause();
        cb1.b(TAG, "onPause()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772033816")) {
            ipChange.ipc$dispatch("772033816", new Object[]{this});
            return;
        }
        super.onResume();
        cb1.b(TAG, "onResume()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815970019")) {
            ipChange.ipc$dispatch("1815970019", new Object[]{this});
            return;
        }
        super.onStart();
        cb1.b(TAG, "onStart()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205718237")) {
            ipChange.ipc$dispatch("-205718237", new Object[]{this});
            return;
        }
        super.onStop();
        cb1.b(TAG, "onStop()");
    }

    public void saveToLocal(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459585755")) {
            ipChange.ipc$dispatch("1459585755", new Object[]{this, bitmap});
        } else {
            ir1.b(this, false, mr1.STORAGE, "用于为您保存图片至本地", new AnonymousClass6(bitmap));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1085408690")) {
            return (String) ipChange.ipc$dispatch("1085408690", new Object[]{this});
        }
        return null;
    }
}
