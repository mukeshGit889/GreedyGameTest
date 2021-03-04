package com.greedygametest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.greedygametest.R;
import com.greedygametest.activities.IconSetsDetail;
import com.greedygametest.databinding.IconSetsFragmentRowBinding;
import com.greedygametest.modles.autherIconPkg.Iconset;

import java.util.List;

public class AutherSetAdapter extends RecyclerView.Adapter<AutherSetAdapter.MyViewHolder> {
    private Context context;
    private IconSetsFragmentRowBinding iconSetsFragmentRowBinding;
    private List<Iconset> iconsetList;
    private String autherName="Unavailable";

    public AutherSetAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = null;
        layoutInflater = LayoutInflater.from(parent.getContext());
        iconSetsFragmentRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.icon_sets_fragment_row, parent, false);
        return new MyViewHolder(iconSetsFragmentRowBinding);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(v ->
                {
                    Intent send = new Intent(context, IconSetsDetail.class);
                    send.putExtra("iconId", ""+iconsetList.get(position).getIconsetId());
                    context.startActivity(send);
                }
        );
        holder.iconSetsFragmentRowBinding.tvAutherNameId.setText(autherName);
        holder.iconSetsFragmentRowBinding.tvIconNameId.setText(iconsetList.get(position).getName());
        holder.iconSetsFragmentRowBinding.tvLicenceId.setText(iconsetList.get(position).getLicense().getName());
        holder.iconSetsFragmentRowBinding.tvPriceId.setText(context.getResources().getString(R.string.unAvailable));
        if (iconsetList.get(position).getIsPremium()) {
            holder.iconSetsFragmentRowBinding.tvFreeId.setText(context.getResources().getString(R.string.true_));
        } else {
            holder.iconSetsFragmentRowBinding.tvFreeId.setText(context.getResources().getString(R.string.false_));
        }

    }
    public void allIconSetslist(List<Iconset> iconsetList,String autherName) {
        this.iconsetList = iconsetList;
        this.autherName = autherName;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return iconsetList == null ? 0 : iconsetList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private IconSetsFragmentRowBinding iconSetsFragmentRowBinding;

        public MyViewHolder(final IconSetsFragmentRowBinding itemBinding) {
            super(itemBinding.getRoot());
            iconSetsFragmentRowBinding = itemBinding;
        }
    }


}
