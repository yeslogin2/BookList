package com.example.cy123.booklist;

import android.os.AsyncTask;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends BaseActivity {

    private ImageView todayImage;
    private TextView todayText;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_drawerlayout);

        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_zh_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_white));
        toolbar.inflateMenu(R.menu.toolbar_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar.OnMenuItemClickListener onMenuItemClickListener =
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_action_search:
                                Toast.makeText(MainActivity.this, "going to search",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                };
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_content);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);

        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        todayImage = (ImageView)findViewById(R.id.today_image);
        todayText = (TextView)findViewById(R.id.today_text);

        String url = "http://www.chengyang.link";

        Picasso.with(getApplicationContext())
                .load(url + "/img/hummingbird-copy.jpg")
                .into(todayImage);


        new TodayTask(todayText).execute(url);
    }

    private class TodayTask extends AsyncTask<String, Void, String> {
        TextView textView;

        public TodayTask(TextView textView){
            this.textView = textView;
        }

        protected String doInBackground(String... addresses){
            String s = null;
            InputStream in = null;
            byte[] buffer = new byte[2048];
            try{
                URL url = new URL(addresses[0] + "/booklist/today_article.txt");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.connect();
                in = connection.getInputStream();

                int readBytes = 0;
                StringBuilder stringBuilder = new StringBuilder();
                while((readBytes = in.read(buffer)) > 0){
                    stringBuilder.append(new String(buffer, 0, readBytes));
                }

                s = stringBuilder.toString();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return s;
            }
        }

        @Override
        protected void onPostExecute(String result){
            textView.setText(result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
