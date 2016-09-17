package ru.innopolis.yorsogettingxbox.repository;

import android.support.annotation.NonNull;

import java.util.List;

import ru.innopolis.yorsogettingxbox.models.Deal;
import rx.Observable;

public interface DataRepository {

    @NonNull
    Observable<List<Deal>> getDeals();

    Observable<Deal> putDeal(Deal deal);

}
