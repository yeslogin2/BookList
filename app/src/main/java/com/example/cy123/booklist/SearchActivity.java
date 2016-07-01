package com.example.cy123.booklist;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.cy123.booklist.Model.BookCutAdapter;
import com.example.cy123.booklist.Model.BookShortCut;
import com.example.cy123.booklist.Utils.GetBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cy123 on 2016/6/25.
 */
public class SearchActivity extends BaseActivity {

    public static final int SHOW_BOOKCUTS_LIST = 1;

    private Button backButton;
    private EditText searchText;
    private List<BookShortCut> bookShortCuts = new ArrayList<>();
    private BookCutAdapter adapter;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_BOOKCUTS_LIST:
                    adapter.clear();
                    adapter.addAll(bookShortCuts);
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_action_search:

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String searchKeyWord = searchText.getText().toString();
                                try {
                                    bookShortCuts =
                                            GetBook.loadBookCuts(searchKeyWord);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Message message = new Message();
                                message.what = SHOW_BOOKCUTS_LIST;
                                handler.sendMessage(message);
                            }
                        }).start();

                }

                return false;
            }
        });

        backButton = (Button)findViewById(R.id.search_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });

        searchText = (EditText)findViewById(R.id.search_editText);

        ListView listView = (ListView) findViewById(R.id.search_result_listView);
        adapter = new BookCutAdapter(SearchActivity.this, bookShortCuts);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookShortCut bookShortCut = bookShortCuts.get(position);
                String bookUrl = bookShortCut.getUrl();
                String title = bookShortCut.getTitle();
                String author = bookShortCut.getAuthorString();
                BookShowActivity.actionStart(SearchActivity.this,
                        bookUrl, title, author);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

}
