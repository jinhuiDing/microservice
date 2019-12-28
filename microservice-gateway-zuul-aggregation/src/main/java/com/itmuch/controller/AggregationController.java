package com.itmuch.controller;

import com.google.common.collect.Maps;
import com.itmuch.pojo.User;
import com.itmuch.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * @description: AggregationController
 * @author: ding
 * @date: 2019/12/15 10:16
 * @version: 1.0
 */

@RestController
public class AggregationController {

    @Autowired
    AggregationService aggregationService;
    private Logger log = LoggerFactory.getLogger(AggregationController.class);


    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id) {
        Observable<HashMap<String, User>> result = this.aggregateObservable(id);
        return this.toDeferredResult(result);
    }

    private DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {

        DeferredResult<HashMap<String, User>> result = new DeferredResult<>();
        //订阅
        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                log.info("完成.....");
            }

            @Override
            public void onError(Throwable e) {
                log.error("发生错误.....", e);
            }

            @Override
            public void onNext(HashMap<String, User> stringUserHashMap) {
                result.setResult(stringUserHashMap);
            }

        });
        return result;
    }

    private Observable<HashMap<String, User>> aggregateObservable(Long id) {

        //合并两个或者多个Observables发射出的数据项,根据指定的函数变换他们

        return Observable.zip(
                this.aggregationService.getUserById(id),
                this.aggregationService.getMovieUserByUserId(id),
                (user, movieUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("movieUser", movieUser);
                    return map;
                }
        );
    }

}
