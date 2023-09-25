package com.limin.commanser.service.impl;

import com.limin.commanser.dto.NewsDto;
import com.limin.commanser.entity.News;
import com.limin.commanser.mapper.NewsMapper;
import com.limin.commanser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 新闻、公告服务实现类
 *
 * @author Administrator
 * 2021.03.18 09:18
 */
@Service
public class NewsServiceImpl implements NewsService {
    private final NewsMapper newsMapper;

    @Autowired
    NewsServiceImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public List<NewsDto> findAll(Map<Object, Object> params) {
        return newsMapper.findAll(params);
    }

    @Override
    public NewsDto findById(Integer newsId) {
        return newsMapper.findById(newsId);
    }

    @Override
    public Integer findTotal(Integer newsType) {
        return newsMapper.findTotal(newsType);
    }

    @Override
    public void removeById(Integer newsId) {
        newsMapper.removeById(newsId);
    }

    @Override
    public void add(News news) {
        newsMapper.add(news);
    }

    @Override
    public void modifyInfo(News news) {
        newsMapper.modifyInfo(news);
    }

    @Override
    public void approvalNews(News news) {
        newsMapper.approvalNews(news);
    }

    @Override
    public Integer findAllByCommunityIdStatistics(Integer communityId) {
        return newsMapper.findAllByCommunityIdStatistics(communityId);
    }
}
