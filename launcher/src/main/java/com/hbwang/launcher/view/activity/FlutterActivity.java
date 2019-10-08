//package com.hbwang.launcher.view.activity;
//
//import android.arch.lifecycle.Lifecycle;
//import android.arch.lifecycle.LifecycleOwner;
//import android.arch.lifecycle.LifecycleRegistry;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.RelativeLayout;
//
//import com.hbwang.hbwangframwork.R;
//
////import io.flutter.facade.Flutter;
//import io.flutter.facade.Flutter;
//import io.flutter.view.FlutterView;
//
//
///**
// * ----------Dragon be here!----------/
// * Created by HBWang on 2019/5/14-17:45
// */
//public class FlutterActivity extends AppCompatActivity implements LifecycleOwner {
//    private LifecycleRegistry mLifecycleRegistry=new LifecycleRegistry(FlutterActivity.this);
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.flutter_activity);
//        RelativeLayout frameLayout =findViewById(R.id.rl_container);
//        FlutterView route = Flutter.createView(this, getLifecycle(), "route");
//        frameLayout.addView(route);
//    }
//
//
//    @NonNull
//    @Override
//    public Lifecycle getLifecycle() {
//        return mLifecycleRegistry;
//    }
//}
