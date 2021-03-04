package com.greedygametest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.greedygametest.R;
import com.greedygametest.databinding.IconSetsFragmentRowBinding;
import com.greedygametest.databinding.IconsFragmentRowBinding;

public class IconSetsDetailAdapter extends RecyclerView.Adapter<IconSetsDetailAdapter.MyViewHolder> {
    private Context context;
    private IconsFragmentRowBinding iconSetsFragmentRowBinding;

    public IconSetsDetailAdapter(Context context) {
        this.context = context;
        //  entryFlag = AppSession.getStringPreferences(context, "loginEntry");
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        iconSetsFragmentRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.icons_fragment_row, parent, false);
        return new MyViewHolder(iconSetsFragmentRowBinding);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position)
    {


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

    public void allIconSetslist() {
       /* this.datumCartList = datumCartList;
        notifyDataSetChanged();*/
    }

    @Override
    public int getItemCount() {
        // return datumCartList == null ? 0 : datumCartList.size();
        return 10;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(final IconsFragmentRowBinding itemBinding) {
            super(itemBinding.getRoot());
        }
    }


}
