package com.example.tonyyoung.find;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import org.json.JSONObject;

import java.util.ArrayList;
// search Book from library
public class searchBook extends AppCompatActivity {

    public EditText book;
    public TextView txv;
    public Button searchButton;
    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        book = (EditText) findViewById(R.id.bookInput);
        txv = (TextView) findViewById(R.id.book_info_display);
        txv.setText("eg: python programming");
        searchButton = (Button) findViewById(R.id.button23);
        searchButton.setOnClickListener(new MyListener());
        ArrayList<Book> bookList;
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
    }
    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            search();
        }
    }

    public void search() {

        String str = book.getText().toString().trim();
        if (str.length() == 0) {
            txv.setText("Cannot be blank");
        } else {
            txv.setText("Waiting...");
            attemptSearch();
        }
    }

    private void attemptSearch() {
        book.setError(null);
        new Thread(new searchHandler()).start();

    }
    public class searchHandler implements Runnable {
        @Override
        public void run() {

            final String data = WebService.executeSearch("SearchServlet", book.getText().toString());
            Book book = parseJSONWithGSON(data);
            final String information = "<p>" + book.getTitle() +" "+ book.getAuthorName() + "<img src = "+ book.getImageLink() + ">";

                    final URLImageParser imageGetter = new URLImageParser(txv);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    txv.setText(Html.fromHtml(information, imageGetter, null));
                }
            });
        }
    }

    private Book parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        Book b = gson.fromJson(jsonData, Book.class);
        return b;
    }

    public class URLImageParser implements Html.ImageGetter {
        TextView mTextView;
        public URLImageParser(TextView textView) {
            this.mTextView = textView;
        }
        @Override
        public Drawable getDrawable(String source) {
            final URLDrawable urlDrawable = new URLDrawable();
            ImageLoader.getInstance().loadImage(source,
                    new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                            urlDrawable.bitmap = loadedImage;
                            urlDrawable.setBounds(0, 0, loadedImage.getWidth(), loadedImage.getHeight());
                            mTextView.invalidate();
                            mTextView.setText(mTextView.getText());
                        }
                    });
            return urlDrawable;
        }
    }
    public class URLDrawable extends BitmapDrawable {
        protected Bitmap bitmap;
        @Override
        public void draw(Canvas canvas) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0, 0, getPaint());
            }
        }
    }


}
