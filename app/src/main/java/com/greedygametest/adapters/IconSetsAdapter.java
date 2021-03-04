package com.greedygametest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.greedygametest.R;
import com.greedygametest.activities.IconSetsDetail;
import com.greedygametest.modles.getIPublicIconPkg.Iconset;

import java.util.List;

public class IconSetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Iconset> iconsetList;
    private static final int LOADING = 0;
    private static final int ITEM = 1;
    private boolean isLoadingAdded = false;

    public IconSetsAdapter(Context context) {
        this.context = context;
    }

    public void clear() {
        isLoadingAdded = false;
        int size = iconsetList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                iconsetList.remove(0);
            }
            notifyItemRangeRemoved(0, size);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater layoutInflater = null;
        layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, layoutInflater);
                break;
            case LOADING:
                View viewLoading = layoutInflater.inflate(R.layout.item_loading, parent, false);
                viewHolder = new IconSetsAdapter.LoadingViewHolder(viewLoading);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.update_icon_sets_ragment_row, parent, false);
        viewHolder = new IconSetsAdapter.MyViewHolder(v1);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == iconsetList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;

    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Iconset());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;
        int position = iconsetList.size() - 1;
        Iconset result = getItem(position);
        if (result != null) {
            iconsetList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Iconset getItem(int position) {
        return iconsetList.get(position);
    }


    public void add(Iconset iconset) {
        iconsetList.add(iconset);
        notifyItemInserted(iconsetList.size() - 1);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        switch (getItemViewType(position)) {
            case ITEM:
                MyViewHolder movieViewHolder = (MyViewHolder) holder;
                movieViewHolder.tvAutherName.setText(iconsetList.get(position).getAuthor().getName());
                movieViewHolder.tvIconName.setText(iconsetList.get(position).getName());
                movieViewHolder.tvLicence.setText(iconsetList.get(position).getPrices().get(0).getLicense().getName());
                movieViewHolder.tvPrice.setText(String.valueOf("₹" + iconsetList.get(position).getPrices().get(0).getPrice()));
                if (iconsetList.get(position).getIsPremium()) {
                    movieViewHolder.tvFree.setText(context.getResources().getString(R.string.true_));
                } else {
                    movieViewHolder.tvFree.setText(context.getResources().getString(R.string.false_));
                }
                break;

            case LOADING:
                LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
                loadingViewHolder.progressBar.setVisibility(View.VISIBLE);
                break;
        }

        holder.itemView.setOnClickListener(v ->
                {
                    Intent send = new Intent(context, IconSetsDetail.class);
                    send.putExtra("iconId", "" + iconsetList.get(position).getIconsetId());
                    context.startActivity(send);
                }
        );

    }

    public void allIconSetslist(List<Iconset> iconsetList) {
        this.iconsetList = iconsetList;
        notifyDataSetChanged();
    }


    public void setmList(List<Iconset> iconsetList) {
        for (Iconset iconset : iconsetList) {
            add(iconset);
        }
    }

    @Override
    public int getItemCount() {
       return iconsetList == null ? 0 : iconsetList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView tvAutherName, tvIconName, tvLicence, tvPrice, tvFree;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvAutherName = (AppCompatTextView) itemView.findViewById(R.id.tvAutherNameId);
            tvIconName = itemView.findViewById(R.id.tvIconNameId);
            tvLicence = itemView.findViewById(R.id.tvLicenceId);
            tvPrice = itemView.findViewById(R.id.tvPriceId);
            tvFree = itemView.findViewById(R.id.tvFreeId);
            // iconSetsFragmentRowBinding = itemBinding;
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);

        }
    }

}
