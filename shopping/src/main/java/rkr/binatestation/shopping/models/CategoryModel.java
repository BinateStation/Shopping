package rkr.binatestation.shopping.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RKR on 02-03-2017.
 * CategoryModel.
 */

public class CategoryModel implements Parcelable {

    public static final Parcelable.Creator<CategoryModel> CREATOR
            = new Parcelable.Creator<CategoryModel>() {
        public CategoryModel createFromParcel(Parcel in) {
            return new CategoryModel(in);
        }

        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };

    private long categoryId;
    private String categoryName;

    public CategoryModel(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    private CategoryModel(Parcel in) {
        categoryId = in.readLong();
        categoryName = in.readString();
    }

    public static CategoryModel getDummyCategory() {
        return new CategoryModel(0, "Category Name");
    }

    @Override
    public String toString() {
        return getCategoryName();
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(categoryId);
        out.writeString(categoryName);
    }
}
