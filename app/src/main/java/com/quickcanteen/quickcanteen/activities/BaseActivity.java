package com.quickcanteen.quickcanteen.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.quickcanteen.quickcanteen.R;


/**
 * Created by 11022 on 2017/5/13.
 */
public class BaseActivity extends AppCompatActivity {
    private TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //toolBarTitle = (TextView) findViewById(R.id.toolBar).findViewById(R.id.topToolBarTitle);
    }

    protected void initView() {
        toolBarTitle = (TextView) findViewById(R.id.top_toolbar).findViewById(R.id.topToolBarTitle);
    }

    protected void setToolBarTitleText(String titleText) {
        toolBarTitle.setText(titleText);
    }

    static public void initializeTop(final AppCompatActivity activity, boolean isShownReturnButton, String title) {
        android.support.v7.widget.Toolbar toolBar = (android.support.v7.widget.Toolbar) (activity.findViewById(R.id.top_toolbar));
        TextView topToolBarTitle = (TextView) (activity.findViewById(R.id.top_toolbar).findViewById(R.id.topToolBarTitle));
        if (isShownReturnButton) {
            toolBar.setTitle(title);
            topToolBarTitle.setText("");
            activity.setSupportActionBar(toolBar);
            //activity.getSupportActionBar().setTitle(title);
            activity.getSupportActionBar().setHomeButtonEnabled(true);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //toolBar.setNavigationIcon(R.drawable.return_img);
            toolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        } else {
            toolBar.setTitle("");
            topToolBarTitle.setText(title);
            activity.setSupportActionBar(toolBar);
        }
    }

}
