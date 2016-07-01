package com.example.cy123.booklist.Utils;

import com.example.cy123.booklist.Model.Book;
import com.example.cy123.booklist.Model.BookShortCut;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cy123 on 2016/6/29.
 */
public class GetBook {
    public static List<BookShortCut> loadBookCuts(String keyWord) throws IOException {
        String urlStr = "https://api.douban.com/v2/book/search?q="
                +keyWord
                +"&fields=id,title,url,author";
        String bookCutJsonStr = StringLoader.loadWithString(urlStr);

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(bookCutJsonStr).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("books");
        List<BookShortCut> bookShortCuts = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonElement e = jsonArray.get(i);
            bookShortCuts.add(gson.fromJson(e, BookShortCut.class));
        }

        return bookShortCuts;
    }

    public static Book loadBook(String url) throws IOException {
        String fieldStr =
                "?fields=image,publisher,pubdate,author_intro,summary,catalog";
        String bookJsonStr = StringLoader.loadWithString(url + fieldStr);

        Gson gson = new Gson();
        return gson.fromJson(bookJsonStr, Book.class);
    }
}
