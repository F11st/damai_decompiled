package cn.damai.commonbusiness.zoomimage;

import android.os.Bundle;
import android.os.Parcelable;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ZoomImageActivity extends BaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    String imageUrl = "";

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217278668")) {
            ipChange.ipc$dispatch("1217278668", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1530089570") ? ((Integer) ipChange.ipc$dispatch("-1530089570", new Object[]{this})).intValue() : R$layout.zoomimage_activity;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053786066")) {
            ipChange.ipc$dispatch("-2053786066", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1945545647")) {
            ipChange.ipc$dispatch("1945545647", new Object[]{this});
            return;
        }
        this.imageUrl = getIntent().getStringExtra("imageurl");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(this.imageUrl);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", 0);
        DMNav.from(this).withExtras(bundle).toUri(cs.e());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521647147")) {
            ipChange.ipc$dispatch("1521647147", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-208934510")) {
            return (String) ipChange.ipc$dispatch("-208934510", new Object[]{this});
        }
        return null;
    }
}
