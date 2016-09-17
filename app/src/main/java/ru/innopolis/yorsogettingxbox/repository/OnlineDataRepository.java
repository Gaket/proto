package ru.innopolis.yorsogettingxbox.repository;

import android.support.annotation.NonNull;

import java.util.List;

import ru.innopolis.yorsogettingxbox.models.Deal;
import ru.innopolis.yorsogettingxbox.network.ApiFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OnlineDataRepository implements DataRepository {

    @NonNull
    @Override
    public Observable<List<Deal>> getDeals() {
        return ApiFactory.getDealsApiService()
                .deals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Deal> putDeal(Deal deal) {
        return ApiFactory.getDealsApiService()
                .newDeal(deal)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
