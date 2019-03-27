package com.example.bookcase;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



public class BookListFragment extends Fragment {


    public BookListFragment() {
        // Required empty public constructor
    }

    ListView listView;
    Context c;
    public BookInterface listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<String> Books = new ArrayList<>();
        Books.add("Ender's Game");
        Books.add("My Brother Sam is Dead");
        Books.add("The Martian");
        Books.add("Among The Hidden");
        Books.add("Ready Player One");
        Books.add("One Flew Over The Cuckoo's Nest");
        Books.add("The Book of Basketball");
        Books.add("Fever 1793");
        Books.add("The Road");
        Books.add("Night");
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_book_list, container, false);
        listView = v.findViewById(R.id.BookListView);

        Resources res = this.getResources();
        final String[] booksArr = res.getStringArray(R.array.bookArr);
        listView.setAdapter(new ArrayAdapter<>(c, android.R.layout.simple_list_item_1, booksArr));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String bookTitle = (String) parent.getItemAtPosition(position);
                ((BookInterface) c).bookPicked(bookTitle);
            }
        });

        //BookListView.setAdapter(stringArrayAdapter);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BookInterface) {
            listener = (BookInterface) context;
        } else {
            throw new RuntimeException(context.toString());
        }
        this.c = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface BookInterface {
        void bookPicked(String bookTitle);
    }

}
