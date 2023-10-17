package com.demo.service.ebi;

import java.util.List;

import com.demo.entity.News;

public interface NewsService {
	public boolean addNews(News news);		//添加通知内容
	public boolean updateNewsByInform(News news);		//修改通知内容
	public boolean deleteNews(News news);
	public List<News> findNews();
	public News findNewsByNno(String nno);
	
}
