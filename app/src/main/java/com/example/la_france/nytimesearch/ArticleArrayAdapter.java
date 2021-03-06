package com.example.la_france.nytimesearch;


import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by La-France on 7/26/2016.
 */
        public class ArticleArrayAdapter extends ArrayAdapter<Article> {
            public ArticleArrayAdapter (Context context, List<Article> articles) {

                super(context, android.R.layout.simple_list_item_1, articles);
            }
            public View getView(int position, View convertView, ViewGroup parent){
                //return super.getView(position, convertView, parent);
                Article article = this.getItem(position);

                if(convertView == null){
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(R.layout.item_article_result, parent, false);
                }
                ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);

                imageView.setImageResource(0);

                TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
                tvTitle.setText(article.getHeadline());

                String thumbnail = article.getThumbNail();
                if(!TextUtils.isEmpty(thumbnail)){
                    Picasso.with(getContext()).load(thumbnail).into(imageView);
                }
                return convertView;
            }





        }

