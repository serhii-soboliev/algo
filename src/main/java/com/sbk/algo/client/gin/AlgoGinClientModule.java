package com.sbk.algo.client.gin;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Singleton;
import com.sbk.algo.client.Algo;
import com.sbk.algo.client.activity.GraphActivity;
import com.sbk.algo.client.activity.SortingActivity;
import com.sbk.algo.client.gin.providers.ActivityManagerProvider;
import com.sbk.algo.client.gin.providers.PlaceControllerProvider;
import com.sbk.algo.client.gin.providers.PlaceHistoryHandlerProvider;
import com.sbk.algo.client.history.AlgoActivityMapper;
import com.sbk.algo.client.history.AlgoHistoryMapper;
import com.sbk.algo.client.layout.AlgoLayout;
import com.sbk.algo.client.place.SortingPlace;
import com.sbk.algo.client.resources.AlgoResources;
import com.sbk.algo.client.view.implementation.GraphView;
import com.sbk.algo.client.view.implementation.SortingView;
import com.sbk.algo.client.view.interfaces.IGraphView;
import com.sbk.algo.client.view.interfaces.ISortingView;

/**
 * Created by sobik on 06/11/2014.
 */
public class AlgoGinClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        //general
        bind(AlgoLayout.class).asEagerSingleton();
        bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();
        bind(ActivityMapper.class).to(AlgoActivityMapper.class).in(Singleton.class);
        bind(PlaceController.class).toProvider(PlaceControllerProvider.class).asEagerSingleton();
        bind(PlaceHistoryMapper.class).to(AlgoHistoryMapper.class).in(Singleton.class);
        bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).asEagerSingleton();
        bind(ActivityManager.class).toProvider(ActivityManagerProvider.class).asEagerSingleton();
        bind(Place.class).to(SortingPlace.class);
        bind(AlgoResources.class).asEagerSingleton();
        //activities;
        bind(SortingActivity.class).in(Singleton.class);
        bind(GraphActivity.class).in(Singleton.class);
        //views

        bind(ISortingView.class).to(SortingView.class).in(Singleton.class);
        bind(IGraphView.class).to(GraphView.class).in(Singleton.class);
//        bind(GraphView.class).in(Singleton.class);
//        bind(SortingView.class).in(Singleton.class);

        requestStaticInjection(Algo.class);
    }

}
