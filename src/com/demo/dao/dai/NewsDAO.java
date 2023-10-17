package com.demo.dao.dai;

import java.util.List;

import com.demo.entity.News;

public interface NewsDAO {
	public boolean addNews(News news);		//添加通知内容
	public boolean updateNewsByInform(News news);		//修改通知内容
	public boolean deleteNews(News news);
	public News findNewsByNno(String nno);		//根据活动编号搜索通知
	public List<News> findNews();
}
