package com.example.bookcase;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    TextView tv;
    ImageView imageView;
    String bookSelected;
    String title;
    String author;
    String publish;
    public static final String BOOK_KEY = "myBook";
    Book pagerBooks;

    public static BookDetailsFragment newInstance(Book bookList) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BOOK_KEY, bookList);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            pagerBooks = getArguments().getParcelable(BOOK_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_details, container, false);
        tv = view.findViewById(R.id.bookTitle);
        imageView = view.findViewById(R.id.bookImage);
        if(getArguments() != null) {
            displayBook(pagerBooks);
        }

        return view;
    }

    public void displayBook(Book bookObj){
        author = bookObj.getAuthor();
        title = bookObj.getTitle(); publish = bookObj.getPublished();
        tv.setText(" \"" + title + "\" "); tv.append(" " + author); tv.append(" " + publish);
        tv.setTextSize(30);
        tv.setTextColor(Color.BLACK);
        String imageURL = bookObj.getCoverURL();
        Picasso.get().load(imageURL).into(imageView);
    }



}
