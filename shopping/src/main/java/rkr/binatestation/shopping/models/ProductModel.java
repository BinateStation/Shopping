package rkr.binatestation.shopping.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RKR on 02-03-2017.
 * ProductModel.
 */

public class ProductModel implements Parcelable {
    public static final Parcelable.Creator<ProductModel> CREATOR
            = new Parcelable.Creator<ProductModel>() {
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    private long productId;
    private String productName;
    private String imageUrl = "http://relaxon30a.com/wp-content/uploads/2013/11/Bag_of_Groceries.jpg";
    private CategoryModel categoryModel;

    public static ProductModel getDummyProduct() {
        return new ProductModel(0, "Product Name", "http://relaxon30a.com/wp-content/uploads/2013/11/Bag_of_Groceries.jpg", CategoryModel.getDummyCategory());
    }

    public ProductModel(long productId, String productName, String imageUrl, CategoryModel categoryModel) {
        this.productId = productId;
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.categoryModel = categoryModel;
    }

    public static ProductModel getDummyProduct() {
        return new ProductModel(0, "Product Name", "http://relaxon30a.com/wp-content/uploads/2013/11/Bag_of_Groceries.jpg", CategoryModel.getDummyCategory());
    }

    public static ProductModel getDummyProduct() {
        return new ProductModel(0, "Product Name", "http://relaxon30a.com/wp-content/uploads/2013/11/Bag_of_Groceries.jpg", CategoryModel.getDummyCategory());
    }

    public static ProductModel getDummyProduct() {
        return new ProductModel(0, "Product Name", "http://relaxon30a.com/wp-content/uploads/2013/11/Bag_of_Groceries.jpg", CategoryModel.getDummyCategory());
    }

    private ProductModel(Parcel in) {
        productId = in.readLong();
        productName = in.readString();
        imageUrl = in.readString();
        categoryModel = in.readParcelable(CategoryModel.class.getClassLoader());
    }

    @Override
    public String toString() {
        return getProductName();
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(productId);
        out.writeString(productName);
        out.writeString(imageUrl);
        out.writeParcelable(categoryModel, flags);
    }
}

