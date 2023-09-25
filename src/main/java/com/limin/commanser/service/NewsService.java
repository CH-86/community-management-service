package com.limin.commanser.service;

import com.limin.commanser.dto.NewsDto;
import com.limin.commanser.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 新闻、公告服务接口
 *
 * @author Administrator
 * 2021.03.18 02:22
 */
public interface NewsService {
    /*
     * 分页查询所有新闻公告信息
     * @param params
     * @return NewsDto>
     */
    List<NewsDto> findAll(Map<Object,Object> params);

    /*
     * 根据ID查询新闻公告
     * @param news
     * @return NewsDto
     */
    NewsDto findById(Integer newsId);

    /*
     * 新闻公告列表总记录条数
     * @return Integer
     */
    Integer findTotal(Integer newsType);
    /*
     * 新闻公告发布社团管理员
     * 、系统管理员有权限删除新闻
     */
    void removeById(Integer newsId);

    /*
     * 发布新闻、公告
     * @param news
     *
     */
    void add(News news);


    /*
     * 新闻、公告发布的社团管理员、或者系统管理员能修改新闻信息
     * @param news
     *
     */
    void modifyInfo(News news);

    /*
     * 管理员审核新闻信息
     * 公告是管理员自己的不必审核
     * @param news
     *
     */
    void approvalNews(News news);

    /*
     *统计查询某个社团有多少新闻数据
     * @param []
     * @return java.util.List<com.limin.commanser.entity.News>
     */
    Integer findAllByCommunityIdStatistics(@Param("communityId") Integer communityId);

}
