package com.limin.commanser.controller;

import com.github.pagehelper.PageHelper;
import com.limin.commanser.dto.NewsDto;
import com.limin.commanser.entity.News;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新闻、公告控制器
 *
 * @author Administrator
 * 2021.03.18 09:22
 */
@RestController
public class NewsController {
    private final NewsService newsService;

    @Autowired
    NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    /*
     * 获取新闻、公告信息列表
     * @param pageNum
     * @param pageSize
     * @param order
     * @param newsType
     *              0： 新闻
     *              1： 公告
     * @param communityId 新闻、公告所属社团
     * @return Result
     */
    @GetMapping("/news")
    public Result findNewsInfosPaging(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize,
                                      @RequestParam(value = "order", required = false, defaultValue = "DESC") String order,
                                      @RequestParam("newsType") Integer newsType,
                                      @RequestParam(value = "communityId", required = false) Integer communityId,
                                      @RequestParam(value = "newsStatus",required = false) Integer newsStatus) {
        PageHelper.startPage(pageNum,pageSize);
        Map<Object, Object> params = new HashMap<>();
        params.put("order", order);
        params.put("newsType", newsType);
        params.put("communityId", communityId);
        params.put("newsStatus", newsStatus);
        List<NewsDto> newsDtoList = newsService.findAll(params);
        return ResultGenerator.genOkResult(newsDtoList);
    }

    /*
     * 根据ID 查询新闻、公告信息
     * @param newsId
     * @return Result
     */
    @GetMapping("/news/{newsId}")
    public Result findNewsInfoById(@PathVariable("newsId") Integer newsId) {
        newsService.findById(newsId);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 发布新闻信息
     * 如果当前用户是系统管理员 则发布 公告 1 或者新闻 0
     * 如果当前用户是社团管理员 则发布 新闻 0
     * 普通用户没权限
     * @param news `
     * @return Result
     */
    @PostMapping("/news")
    public Result addNews(@RequestBody News news) {

        //todo 上传图片到服务器
        newsService.add(news);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 新闻、公告发布的社团管理员、或者系统管理员能修改新闻信息
     * @param news
     * @return Result
     */
    @PutMapping("/news")
    public Result modifyNews(@RequestBody News news) {
        newsService.modifyInfo(news);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 管理员审核新闻、公告
     * @param newsId
     * @param newsStatus
     * @return Result
     */
    @PutMapping("/news/approval")
    public Result approvalNews(@RequestParam("newsId") Integer newsId, @RequestParam("newsStatus") Integer newsStatus) {
        News news = new News();
        news.setNewsId(newsId);
        news.setNewsStatus(newsStatus);
        newsService.approvalNews(news);
        return ResultGenerator.genOkResult("审核成功");
    }

    /**
     * 查询新闻、公告总记录条数
     * @return Result
     */
    @GetMapping("/news/total/{newsType}")
    public Result findTotal(@PathVariable("newsType") Integer newsType){
        return ResultGenerator.genOkResult(newsService.findTotal(newsType));
    }

    /*
     *根据ID删除新闻
     * @param []
     * @return com.limin.commanser.result.Result
     */
    @DeleteMapping("/news/{newsId}")
    public Result removeNewsById(@PathVariable("newsId") Integer newsId){
        newsService.removeById(newsId);
        return ResultGenerator.genOkResult("ok");
    }
}
