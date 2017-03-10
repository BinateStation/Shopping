package rkr.binatestation.shopping.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

import rkr.binatestation.shopping.R;
import rkr.binatestation.shopping.models.ProductModel;
import rkr.binatestation.shopping.network.VolleySingleTon;

/**
 * Created by RKR on 02-03-2017.
 * ProductListAdapter.
 */

public class ProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ProductModel> mProductModelList = new ArrayList<>();

    public void setProductModelList(List<ProductModel> productModelList) {
        this.mProductModelList = productModelList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            ProductModel productModel = ProductModel.getDummyProduct();
            viewHolder.mProductImageView.setImageUrl(
                    productModel.getImageUrl(),
                    VolleySingleTon.getInstance(viewHolder.mProductImageView.getContext())
                            .getImageLoader()
            );
            viewHolder.mProductNameTextView.setText(productModel.getProductName());
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private NetworkImageView mProductImageView;
        private TextView mProductNameTextView;
        private TextView mProductPriceTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mProductImageView = (NetworkImageView) itemView.findViewById(R.id.a_product_image);
            mProductNameTextView = (TextView) itemView.findViewById(R.id.a_product_name);
            mProductPriceTextView = (TextView) itemView.findViewById(R.id.a_product_price);
        }
    }
}
