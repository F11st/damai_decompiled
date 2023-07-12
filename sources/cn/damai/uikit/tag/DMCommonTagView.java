package cn.damai.uikit.tag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import cn.damai.uikit.tag.DMCommonTagView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.DisplayUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMCommonTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int NORMAL_TAG_FONT_SIZE = 10;
    public static final int SMALL_TAG_FONT_SIZE = 8;
    private boolean isNewHomepage;
    private Context mContext;
    private TextView mPrefix;
    private ImageView mPrefixImg;
    private ImageView mTagImage;
    private TextView mTagName;
    private ViewGroup twoPartTagContainer;
    public static int SMALL_TAG_HEIGHT = DisplayUtil.dip2px(AppInfoProviderProxy.getApplication(), 12.0f);
    public static int NORMAL_TAG_HEIGHT = DisplayUtil.dip2px(AppInfoProviderProxy.getApplication(), 15.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.tag.DMCommonTagView$a */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C2559a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DMTagType.values().length];
            a = iArr;
            try {
                iArr[DMTagType.TAG_TYPE_PREFERENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DMTagType.TAG_TYPE_BUSINESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DMTagType.TAG_TYPE_RANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DMTagType.TAG_TYPE_SERVICES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DMTagType.TAG_TYPE_MEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DMTagType.TAG_TYPE_ONEONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_EARLYBIRD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_2PART.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_FF866E.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_VIP_PRIVILEGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_VIP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT_HOME.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public DMCommonTagView(@NonNull Context context) {
        super(context);
        this.isNewHomepage = false;
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482697862")) {
            ipChange.ipc$dispatch("-1482697862", new Object[]{this, context});
            return;
        }
        if (this.isNewHomepage) {
            LayoutInflater.from(context).inflate(R$layout.bricks_common_tags_layout_home, this);
            setPadding(0, 0, 0, 0);
        } else {
            LayoutInflater.from(context).inflate(R$layout.bricks_common_tags_layout, this);
            s60 s60Var = s60.INSTANCE;
            setPadding(0, s60Var.b(this.mContext, 3), s60Var.b(this.mContext, 3), s60Var.b(this.mContext, 3));
        }
        this.mTagName = (TextView) findViewById(R$id.tv_tag_name);
        this.mTagImage = (ImageView) findViewById(R$id.image_tag);
        this.mPrefix = (TextView) findViewById(R$id.tv_tag_name_prefix);
        this.mPrefixImg = (ImageView) findViewById(R$id.iv_tag_name_prefix);
        this.twoPartTagContainer = (ViewGroup) findViewById(R$id.ll_2_part_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTagImage$0(SuccessEvent successEvent) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312134153")) {
            ipChange.ipc$dispatch("1312134153", new Object[]{this, successEvent});
        } else if (successEvent != null && (bitmap = successEvent.bitmap) != null) {
            this.mTagImage.getLayoutParams().width = s60.INSTANCE.b(this.mContext, (bitmap.getWidth() * 16) / successEvent.bitmap.getHeight());
            this.mTagImage.setImageBitmap(successEvent.bitmap);
        } else {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTagImage$1(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2090717173")) {
            ipChange.ipc$dispatch("2090717173", new Object[]{this, failEvent});
        } else {
            setVisibility(8);
        }
    }

    public void adjustTagHeight(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928294369")) {
            ipChange.ipc$dispatch("-928294369", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.twoPartTagContainer.getLayoutParams().height = SMALL_TAG_HEIGHT;
            this.mTagName.getLayoutParams().height = SMALL_TAG_HEIGHT;
            this.mTagImage.getLayoutParams().height = SMALL_TAG_HEIGHT;
            this.mTagName.setTextSize(1, 8.0f);
            this.mPrefix.setTextSize(1, 8.0f);
        } else {
            this.twoPartTagContainer.getLayoutParams().height = NORMAL_TAG_HEIGHT;
            this.mTagName.getLayoutParams().height = NORMAL_TAG_HEIGHT;
            this.mTagImage.getLayoutParams().height = NORMAL_TAG_HEIGHT;
            this.mTagName.setTextSize(1, 10.0f);
            this.mPrefix.setTextSize(1, 10.0f);
        }
    }

    public TextView getTagView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-267402962") ? (TextView) ipChange.ipc$dispatch("-267402962", new Object[]{this}) : this.mTagName;
    }

    public DMCommonTagView setHasPandding(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-765122295")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("-765122295", new Object[]{this, Boolean.valueOf(z)});
        }
        if (z) {
            s60 s60Var = s60.INSTANCE;
            setPadding(0, s60Var.b(this.mContext, 6), s60Var.b(this.mContext, 3), 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
        return this;
    }

    public void setImgHeight(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46791963")) {
            ipChange.ipc$dispatch("46791963", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public void setTagAutoTextSize(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328567866")) {
            ipChange.ipc$dispatch("-328567866", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            TextViewCompat.setAutoSizeTextTypeWithDefaults(this.mTagName, 1);
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this.mTagName, DisplayUtil.dip2px(this.mContext, 5.0f), DisplayUtil.dip2px(this.mContext, 8.0f), 2, 0);
        } else {
            TextViewCompat.setAutoSizeTextTypeWithDefaults(this.mTagName, 0);
        }
    }

    public DMCommonTagView setTagContent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050495491")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("-2050495491", new Object[]{this, str, str2});
        }
        if (this.mTagName != null && !TextUtils.isEmpty(str2)) {
            this.mTagName.setText(str2);
        }
        if (this.mPrefix != null && !TextUtils.isEmpty(str)) {
            this.mPrefix.setText(str);
        }
        return this;
    }

    public DMCommonTagView setTagImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805182057")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("805182057", new Object[]{this, str});
        }
        if (this.mTagImage != null) {
            ImageLoaderProviderProxy.getProxy().load(str, new IImageSuccListener() { // from class: tb.xq
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    DMCommonTagView.this.lambda$setTagImage$0(successEvent);
                }
            }, new IImageFailListener() { // from class: tb.wq
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    DMCommonTagView.this.lambda$setTagImage$1(failEvent);
                }
            });
        }
        return this;
    }

    public DMCommonTagView setTagName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89569875")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("-89569875", new Object[]{this, str});
        }
        TextView textView = this.mTagName;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public void setTagNameImgHeight(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228225120")) {
            ipChange.ipc$dispatch("-1228225120", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ImageView imageView = this.mPrefixImg;
        if (imageView == null || imageView.getLayoutParams() == null) {
            return;
        }
        this.mPrefixImg.getLayoutParams().width = i;
        this.mPrefixImg.getLayoutParams().height = i2;
    }

    public DMCommonTagView setTagType(DMTagType dMTagType) {
        int intrinsicWidth;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295282811")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("-295282811", new Object[]{this, dMTagType});
        }
        if (this.mTagName != null && this.mTagImage != null) {
            this.mPrefixImg.setVisibility(8);
            this.mTagName.setVisibility(0);
            this.mTagImage.setVisibility(8);
            switch (C2559a.a[dMTagType.ordinal()]) {
                case 1:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_bg);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.white));
                    break;
                case 2:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_business_bg);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.color_FF2869));
                    break;
                case 3:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_rank_bg);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.color_FF993A));
                    break;
                case 4:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_services_bg);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.color_6A7A99));
                    break;
                case 5:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_member_bg);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.white));
                    break;
                case 6:
                    this.mTagName.setVisibility(8);
                    this.mTagImage.setVisibility(0);
                    break;
                case 7:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_bg);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.white));
                    break;
                case 8:
                    this.mTagName.setVisibility(8);
                    this.mTagImage.setVisibility(0);
                    this.mTagImage.setImageResource(R$drawable.bricks_icon_homepage_market_earlybird);
                    break;
                case 9:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_postfixbg);
                    this.mTagName.setTextColor(Color.parseColor("#FF7292"));
                    this.mPrefix.setVisibility(0);
                    break;
                case 10:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_bg_vip_new);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.white));
                    break;
                case 11:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_bg_vip_new);
                    this.mTagName.setTextColor(this.mContext.getResources().getColor(R$color.white));
                    break;
                case 12:
                    this.mTagName.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_postfixbg_vip);
                    this.mTagName.setTextColor(Color.parseColor("#FF6666"));
                    this.mPrefix.setVisibility(8);
                    this.mPrefixImg.setVisibility(0);
                    this.mPrefixImg.setImageResource(R$drawable.bricks_common_promotion_tagview_vip);
                    break;
                case 13:
                case 14:
                    this.mTagName.setVisibility(8);
                    this.mTagImage.setVisibility(0);
                    if (dMTagType == DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT_HOME) {
                        this.mTagImage.setImageResource(R$drawable.bricks_common_promotion_tagview_wednesday_discount_home);
                    } else {
                        this.mTagImage.setImageResource(R$drawable.bricks_common_promotion_tagview_wednesday_discount);
                    }
                    if (this.mTagImage.getDrawable() != null && this.mTagImage.getDrawable().getIntrinsicWidth() > 0 && (intrinsicWidth = (this.mTagImage.getLayoutParams().height * this.mTagImage.getDrawable().getIntrinsicWidth()) / this.mTagImage.getDrawable().getIntrinsicHeight()) > 0) {
                        this.mTagImage.getLayoutParams().width = intrinsicWidth;
                    }
                    this.mPrefix.setVisibility(8);
                    break;
            }
        }
        return this;
    }

    public DMCommonTagView(@NonNull Context context, boolean z) {
        super(context);
        this.isNewHomepage = false;
        this.mContext = context;
        this.isNewHomepage = z;
        initView(context);
    }

    public DMCommonTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMCommonTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNewHomepage = false;
        this.mContext = context;
        initView(context);
    }
}
