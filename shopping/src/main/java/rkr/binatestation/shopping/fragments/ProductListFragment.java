package rkr.binatestation.shopping.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rkr.binatestation.shopping.R;
import rkr.binatestation.shopping.adapters.ProductListAdapter;
import rkr.binatestation.shopping.models.CategoryModel;

/**
 * A simple {@link Fragment} subclass that lists the
 * Products under the specified Category in a Horizontal Recycler View. *
 */
public class ProductListFragment extends Fragment {

    private static final String TAG = "ProductListFragment";
    private static final String KEY_CATEGORY = "category";

    private ProductListAdapter mProductListAdapter;
    private CategoryModel mCategoryModel;

    public ProductListFragment() {
        // Required empty public constructor
    }

    public static ProductListFragment newInstance(CategoryModel categoryModel) {
        Log.d(TAG, "newInstance() called with: categoryModel = [" + categoryModel + "]");
        Bundle args = new Bundle();
        args.putParcelable(KEY_CATEGORY, categoryModel);
        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mCategoryModel = bundle.getParcelable(KEY_CATEGORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView categoryNameTextView = (TextView) view.findViewById(R.id.f_product_list_category_name);
        RecyclerView productListRecyclerView = (RecyclerView) view.findViewById(R.id.f_product_list_recycler_view);

        productListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        if (mCategoryModel != null) {
            categoryNameTextView.setText(mCategoryModel.getCategoryName());
            productListRecyclerView.setAdapter(mProductListAdapter = new ProductListAdapter());
        }

    }
}
