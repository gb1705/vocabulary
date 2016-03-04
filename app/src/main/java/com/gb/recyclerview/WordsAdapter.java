package com.gb.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gb.vocab.R;
import com.gb.vocab.Word;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {

    private List<Word> wordList;
    final String ImageUrl = "http://appsculture.com/vocab/images/";
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView word_txt, meaning_txt;
        public ImageView thumbnailImageView;


        public MyViewHolder(View view) {
            super(view);
            word_txt = (TextView) view.findViewById(R.id.word);
            meaning_txt = (TextView) view.findViewById(R.id.meaning);
            thumbnailImageView = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }


    public WordsAdapter(List<Word> wordList, Context mContext) {
        this.wordList = wordList;
        for(Iterator<Word> itr = this.wordList.iterator();itr.hasNext();)
        {
            Word element = itr.next();
            if(element.getRatio()<0)
            {
                itr.remove();
            }
        }
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.words_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Word word = wordList.get(position);
        if (word.getRatio() > 0) {
            holder.word_txt.setText(word.getWord());
            holder.meaning_txt.setText(word.getMeaning());
            setupImage(ImageUrl + word.getId() + ".png", holder.thumbnailImageView);
        }



    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public void setupImage(String url, ImageView imageView) {
        Picasso.with(mContext)
                .load(url)
                .into(imageView);
    }

}
