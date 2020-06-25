package com.piaoshen.libs.pays;

import com.piaoshen.libs.alipay.AlipayUtils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.LinearLayout;
import dc.android.base.activity.BridgeActivity;
import dc.common.Logger;

/**
 * @author senrsl
 * @ClassName: TestAlipayActivity
 * @Package: com.piaoshen.libs.pays
 * @CreateTime: 2019/8/15 7:38 PM
 */
public class TestAlipayActivity extends BridgeActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, TestAlipayActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initLayout() {
        super.initLayout();
        setLayout(true, generateLayout(), true, Color.GREEN);
    }

    @Override
    protected void initData() {
        super.initData();

        AlipayUtils.pay(this, "fsdfsfasf", cb);
    }

    private LinearLayout generateLayout() {
        LinearLayout layout = new LinearLayout(this);


        return layout;
    }

    @Override
    protected void onPause() {
        super.onPause();
        AlipayUtils.destroy();
    }

    private IPayCallback cb = new IPayCallback() {
        @Override
        public void onSuss() {
            Logger.w(TestAlipayActivity.this, "onSuss");
        }

        @Override
        public void onCancel() {
            Logger.w(TestAlipayActivity.this, "onCancel");
        }

        @Override
        public void onErr(int code, String msg) {
            Logger.w(TestAlipayActivity.this, "onErr", code, msg);
        }
    };
}
