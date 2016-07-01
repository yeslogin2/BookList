package com.example.cy123.booklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cy123.booklist.Model.Book;
import com.example.cy123.booklist.Utils.GetBook;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by cy123 on 2016/7/1.
 */
public class BookShowActivity extends BaseActivity {

    private final int SHOW_BOOK = 1;

    private Book mBook;
    TextView title, author, publisher, pubdate, author_intro, summary, catalog;
    private ImageView imageView;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_BOOK:
                    Intent intent = getIntent();
                    title.setText(intent.getStringExtra("TITLE"));
                    author.setText(intent.getStringExtra("AUTHOR"));
                    publisher.setText(mBook.getPublisher());
                    pubdate.setText(mBook.getPubdate());
                    author_intro.setText("作者简介： "+mBook.getAuthor_intro());
                    summary.setText("摘要： "+mBook.getSummary());
                    catalog.setText("目录： "+mBook.getCatalog());
                    String imageUrl = mBook.getImage();
                    imageUrl = imageUrl.replace("mpic", "lpic");
                    Picasso.with(getApplicationContext())
                            .load(imageUrl)
                            .into(imageView);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_bookshow);

        Toolbar toolbar = (Toolbar)findViewById(R.id.bookshow_toolbar1);
        assert toolbar != null;
        setSupportActionBar(toolbar);

        Button backButton = (Button) findViewById(R.id.bookshow_back_button);
        assert backButton != null;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookShowActivity.this.finish();
            }
        });

        title = (TextView)findViewById(R.id.bookshow_title);
        author = (TextView)findViewById(R.id.bookshow_author);
        publisher = (TextView)findViewById(R.id.bookshow_publisher);
        pubdate = (TextView)findViewById(R.id.bookshow_pubdate);
        author_intro = (TextView)findViewById(R.id.bookshow_author_intro);
        summary = (TextView)findViewById(R.id.bookshow_summary);
        catalog = (TextView)findViewById(R.id.bookshow_catalog);
        imageView = (ImageView)findViewById(R.id.bookshow_image);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mBook = GetBook.loadBook(getIntent().getStringExtra("BOOKSHOW_URL"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = SHOW_BOOK;
                handler.sendMessage(msg);

            }
        }).start();

    }

    public static void actionStart(Context context,
                                   String bookUrl, String title, String author){
        Intent intent = new Intent(context, BookShowActivity.class);
        intent.putExtra("BOOKSHOW_URL", bookUrl);
        intent.putExtra("TITLE", title);
        intent.putExtra("AUTHOR", author);
        context.startActivity(intent);
    }
}
