package rkr.binatestation.shopping.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import rkr.binatestation.shopping.BuildConfig;
import rkr.binatestation.shopping.utils.Constants;


/**
 * Created by RKR on 12-11-2015.
 * VolleySingleTon.
 */
public class VolleySingleTon {
    /**
     * assignment of domain urls
     * the variable isLocal define if the project work in local domain or in live server domains
     */
    private static final String BASE_URL_RELEASE = "http://www.piclo.in/app/";
    private static final String BASE_URL_IMAGE_RELEASE = "http://www.piclo.in/images/gallery/";

    private static final String BASE_URL_DEBUG = "http://binatestation.com/piclo/app/";
    private static final String BASE_URL_IMAGE_DEBUG = "http://binatestation.com/piclo/images/gallery/";

    /**
     * static variable for maintain single Volley queue
     */
    private static VolleySingleTon sInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleySingleTon(Context context) {
        mRequestQueue = getRequestQueue(context);

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    /**
     * synchronised method to ensure only single instance
     */
    public static synchronized VolleySingleTon getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VolleySingleTon(context);
        }
        return sInstance;
    }

    /**
     * static method used to get the domain url for the images
     */

    public static String getDomainUrlForImage() {
        if (BuildConfig.DEBUG) {
            return BASE_URL_IMAGE_DEBUG;
        } else {
            return BASE_URL_IMAGE_RELEASE;
        }
    }

    /**
     * static method used to get the domain url for APIs
     */
    public static String getDomainUrl() {
        if (BuildConfig.DEBUG) {
            return BASE_URL_DEBUG;
        } else {
            return BASE_URL_RELEASE;
        }
    }

    /**
     * static method used to get the single request queue
     *
     * @param context the context from where this is calling
     */

    private RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mRequestQueue;
    }

    /**
     * static method used to add request to the request queue
     */
    public <T> void addToRequestQueue(Context context, Request<T> req) {
        req.setRetryPolicy(new DefaultRetryPolicy(Constants.socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue(context).add(req);
    }

    /**
     * static method used to get the image loader
     */

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
