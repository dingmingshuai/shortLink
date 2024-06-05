package com.nageoffer.shortlink.project.service;



/**
 * ClassName:UrlTitleService
 * Description:
 * URL标题接口层
 * @Author DubPAN
 * @Create2024/6/4 20:56
 * @Version 1.0
 */
public interface UrlTitleService {
    /**
     * 根据URL获取标题
     * @param url 目标网站地址
     * @return 网站标题
     */
    String getTitleByUrl(String url);
}
