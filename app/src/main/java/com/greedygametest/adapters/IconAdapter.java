package com.greedygametest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.greedygametest.R;
import com.greedygametest.activities.IconSetsDetail;
import com.greedygametest.activities.IconsDetail;
import com.greedygametest.databinding.IconsFragmentRowBinding;
import com.greedygametest.modles.getAllIconPkg.Icon;

import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.MyViewHolder> {
    private Context context;
    private IconsFragmentRowBinding iconsFragmentRowBinding;
    private List<Icon> getAllIconList;

    public IconAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        iconsFragmentRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.icons_fragment_row, parent, false);
        return new MyViewHolder(iconsFragmentRowBinding);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(v ->
                {
                    Intent send = new Intent(context, IconsDetail.class);
                    send.putExtra("iconId", "" + getAllIconList.get(position).getIconId());
                    send.putExtra("iconImg", "" + getAllIconList.get(position).getRasterSizes().get(8).getFormats()
                            .get(0).getPreviewUrl());
                    send.putExtra("iconDownloadUrl", "" + getAllIconList.get(position).getRasterSizes().get(8).getFormats()
                            .get(0).getDownloadUrl());
                    context.startActivity(send);
                }
        );

        holder.iconsFragmentRowBinding.tvAutherNameId.setText(context.getResources().getString(R.string.unAvailable));
        holder.iconsFragmentRowBinding.tvIconNameId.setText(getAllIconList.get(position).getTags().get(0));
        holder.iconsFragmentRowBinding.tvLicenceId.setText(context.getResources().getString(R.string.unAvailable));
        holder.iconsFragmentRowBinding.tvPriceId.setText(context.getResources().getString(R.string.unAvailable));
        holder.iconsFragmentRowBinding.tvTypeId.setText(context.getResources().getString(R.string.unAvailable));
        if (getAllIconList.get(position).getIsPremium()) {
            holder.iconsFragmentRowBinding.tvFreeId.setText(context.getResources().getString(R.string.true_));
        } else {
            holder.iconsFragmentRowBinding.tvFreeId.setText(context.getResources().getString(R.string.false_));
        }
        Glide.with(context)
                .load(getAllIconList.get(position).getRasterSizes().get(8).getFormats()
                        .get(0).getPreviewUrl())
                .placeholder(R.drawable.logo)
                .into(holder.iconsFragmentRowBinding.ivIconId);


       /* holder.tvbottleLayer.setText(datumCartList.get(position).getProductDescription());
        holder.tvBottleName.setText(datumCartList.get(position).getProductName());
        holder.tvbottleOrderDate.setText("Rs " + datumCartList.get(position).getRate());

        Glide.with(context)
                .load(ApiClient.imageUrl + datumCartList.get(position).getProductImage())
                .placeholder(R.drawable.placeholder)
                .into(holder.ivProduct);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (entryFlag.equalsIgnoreCase("skip")) {
                    Constants.goToScreenWithoutFinish(context, LoginActivity.class);
                } else {
                    AppSession.setStringPreferences(context, "productId", datumCartList.get(position).getProductId());
                    Intent intent = new Intent(context, SingleProductDetail.class);
                    context.startActivity(intent);
                }

            }
        });*/
    }

    public void allIconSetslist(List<Icon> getAllIconList) {
        this.getAllIconList = getAllIconList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return getAllIconList == null ? 0 : getAllIconList.size();

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private IconsFragmentRowBinding iconsFragmentRowBinding;

        public MyViewHolder(final IconsFragmentRowBinding itemBinding) {
            super(itemBinding.getRoot());
            iconsFragmentRowBinding = itemBinding;
        }
    }


}
