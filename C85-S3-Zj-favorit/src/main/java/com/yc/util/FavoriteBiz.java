package com.yc.util;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.bean.TagFavorite;
import com.yc.dao.FavoriteMapper;
import com.yc.dao.TagFacoriteMapper;
import com.yc.dao.TagMapper;
import com.yc.util.MyBatisHelper;

public class FavoriteBiz {

	public void addFavorite(Favorite f) {
		/**
		 * 核心业务 Favorite 1 淘宝 taobao.com 购物网站 购物，生活 
		 * 2网易 163.com 常用网站 军事，生活，
		 * 
		 * Tag 1 购物 1 2 生活 2 3 军事 1
		 * 
		 * TagFavorite//中间表 
		 * 1 1 
		 * 2 1 
		 * 3 2 
		 * 2 2
		 * 
		 * 1添加链接到Favorite 2.拆分ftages 3.直接修改数量 如果为0则不存在 为1直接增加
		 */
		SqlSession session = MyBatisHelper.openSession();
		FavoriteMapper fm = session.getMapper(FavoriteMapper.class);
		TagMapper tm = session.getMapper(TagMapper.class);
		TagFacoriteMapper tfm = session.getMapper(TagFacoriteMapper.class);
		try {
			fm.insert(f);
			String tags[] = f.getFtages().split("[,，;；]");
			for (String tag : tags) {
				Tag t = new Tag();
				if (tm.updateCount(tag) == 0) {
					t.setTname(tag);
					tm.insert(t);
				} else {
					t = tm.selectByName(tag);
				}
				TagFavorite tf = new TagFavorite();
				tf.setTid(t.getTid());
				tf.setFid(f.getFid());
				tfm.insert(tf);
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}

}
