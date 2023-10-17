package com.demo.service.ebo;

import java.util.List;

import com.demo.dao.dai.NewsDAO;
import com.demo.entity.News;
import com.demo.service.ebi.NewsService;

public class NewsServiceImpl implements NewsService{
	private NewsDAO ndao;
	public NewsDAO getNdao() {
		return ndao;
	}

	public void setNdao(NewsDAO ndao) {
		this.ndao = ndao;
	}

	@Override
	public boolean addNews(News news) {
		return ndao.addNews(news);
	}

	@Override
	public boolean updateNewsByInform(News news) {
		return ndao.updateNewsByInform(news);
	}

	@Override
	public List<News> findNews() {
		List<News> list=ndao.findNews();
		return list;
	}

	@Override
	public News findNewsByNno(String nno) {
		return ndao.findNewsByNno(nno);
	}

	@Override
	public boolean deleteNews(News news) {
		return ndao.deleteNews(news);
	}


}
