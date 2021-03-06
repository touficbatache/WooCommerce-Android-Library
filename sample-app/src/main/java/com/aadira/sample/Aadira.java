package com.aadira.sample;

import android.app.Application;

import com.aadira.library.Enums.SigningMethod;
import com.aadira.library.Main.WCBuilder;
import com.aadira.library.Main.WooCommerce;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by kumardivyarajat on 20/02/16.
 */
public class Aadira extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        WCBuilder builder = new WCBuilder();
        builder.setIsHttps(false);
        builder.setBaseUrl("www.aadira.com");
        builder.setSigning_method(SigningMethod.HMACSHA1);
        builder.setWc_key("ck_b1c74943c7ad59d34ee8477a210d12cfaff14406");
        builder.setWc_secret("cs_c9233d13c31eb3117b3cfdcc53e4ddc358e3545d");
        WooCommerce.getInstance().initialize(builder);

        LeakCanary.install(this);

        System.out.println(WooCommerce.getInstance().toString());
    }
}
