package cn.cyj.factory_method.ad.impl;

import cn.cyj.factory_method.ad.AdService;

/**
 * 广点通广告
 */
public class GDTAdService implements AdService {

    @Override
    public void load() {
        System.out.println("加载广点通广告");
    }

    @Override
    public void show() {
        System.out.println("播放广点通广告");
    }
}
