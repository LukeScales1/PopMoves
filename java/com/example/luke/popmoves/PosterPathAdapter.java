package com.example.luke.popmoves;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PosterPathAdapter extends RecyclerView.Adapter<PosterPathAdapter.NumberViewHolder>  {
    private static final String TAG = PosterPathAdapter.class.getSimpleName();

    final private GridItemClickListener mOnClickListener;
    private static int viewHolderCount;
    private int mNumberItems;


    public interface GridItemClickListener {
        void onGridItemClick(int clickedItemIndex);
    }

    public PosterPathAdapter(int numberOfItems, GridItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.pic_grid_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);



        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {

        // Will display the position in the list, ie 0 through getItemCount() - 1
//        ImageView gridItemPic = null;
//        // Will display which ViewHolder is displaying this data
//        ImageView gridItemPic1 = null;
//
//        gridItemPic = (ImageView) gridItemPic.findViewById(R.id.iv_item_pic);;
//        gridItemPic1 = (ImageView) gridItemPic1.findViewById(R.id.iv_item_pic1);
//
//        Context context = gridItemPic.getContext();
//            Picasso.with(context).load("http://image.tmdb.org/t/p/w500/" + String.valueOf(position)).into(gridItemPic);
//            Context context1 = gridItemPic.getContext();
//            Picasso.with(context1).load("http://image.tmdb.org/t/p/w500/" + String.valueOf(position)).into(gridItemPic1);
    }

    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        ImageView gridItemPic;
        // Will display which ViewHolder is displaying this data
        ImageView gridItemPic1;


        public NumberViewHolder(View itemView) {
            super(itemView);

//            gridItemPic = (ImageView) itemView.findViewById(R.id.iv_item_pic);
//            gridItemPic1 = (ImageView) itemView.findViewById(R.id.iv_item_pic1);
//
            itemView.setOnClickListener(this);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         * @param gridIndex Position of the item in the grid
         */
        void bind(int gridIndex) {
//            gridItemPic.setText(String.valueOf(gridIndex));
            Context context = gridItemPic.getContext();
            Picasso.with(context).load("http://image.tmdb.org/t/p/w500/" + String.valueOf(gridIndex)).into(gridItemPic);
            Context context1 = gridItemPic1.getContext();
            Picasso.with(context1).load("http://image.tmdb.org/t/p/w500/" + String.valueOf(gridIndex + 1)).into(gridItemPic1);
        }


        // COMPLETED (6) Override onClick, passing the clicked item's position (getAdapterPosition()) to mOnClickListener via its onListItemClick method
        /**
         * Called whenever a user clicks on an item in the list.
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onGridItemClick(clickedPosition);
        }
    }
}

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Movie moviePoster = getItem(position);
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.pic_grid_item, parent, false);
//        }
//        ImageView iconView = (ImageView) convertView.findViewById(R.id.iv_item_pic);
//        Context context = iconView.getContext();
//        Picasso.with(context).load("http://image.tmdb.org/t/p/w500/" + moviePoster.posterPath).into(iconView);
//
////        TextView versionNameView = (TextView) convertView.findViewById(R.id.flavor_text);
////        versionNameView.setText(movieData.versionName
////                + " - " + movieData.versionNumber );
//
//        return convertView;
//    }
//}
