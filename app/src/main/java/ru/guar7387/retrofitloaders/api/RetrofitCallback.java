package ru.guar7387.retrofitloaders.api;

import retrofit.Callback;
import retrofit.Response;

/**
 * @author Artur Vasilov
 */
public abstract class RetrofitCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Response<T> response) {
    }

    @Override
    public void onFailure(Throwable t) {
    }
}
