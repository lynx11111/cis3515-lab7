package com.example.bookcase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BookDetailsFragment extends Fragment {


    public BookDetailsFragment() {
        // Required empty public constructor
    }

    TextView tv;
    String bookPicked;
    public static final String BOOK_KEY = "bookTitle";

    public static BookDetailsFragment newInstance(String book) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BOOK_KEY, book);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            bookPicked = getArguments().getString(BOOK_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_details, container, false);
        tv = v.findViewById(R.id.tvTitle);
        //tv.setText(bookPicked);
        bookPicked(bookPicked);

        return v;
    }


    public void bookPicked (String bookPicked){
        //Log.d("Book", bookSelected);
        tv.setText(bookPicked);
    }




}
