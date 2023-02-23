package cn.cyj.factory_method.ad.impl;

import cn.cyj.factory_method.ad.AdService;

/**
 * 穿山甲广告
 */
public class PangleAdService implements AdService {

    @Override
    public void load() {
        System.out.println("加载穿山甲广告");
    }

    @Override
    public void show() {
        System.out.println("播放穿山甲广告");
    }
}
