package com.worldline.breadcrumbview.app;

import com.worldline.breadcrumbview.BreadcrumbView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BreadcrumbView breadcrumbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        breadcrumbView = (BreadcrumbView) findViewById(R.id.breadcrumbView);
        findViewById(R.id.breadcrumb0).setOnClickListener(this);
        findViewById(R.id.breadcrumb1).setOnClickListener(this);
        findViewById(R.id.breadcrumb2).setOnClickListener(this);
        findViewById(R.id.breadcrumb3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.breadcrumb0:
                breadcrumbView.selectStep(0);
                break;
            case R.id.breadcrumb1:
                breadcrumbView.selectStep(1);
                break;
            case R.id.breadcrumb2:
                breadcrumbView.selectStep(2);
                break;
            case R.id.breadcrumb3:
                breadcrumbView.selectStep(3);
        }
    }
}
