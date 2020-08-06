package com.yc.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.bean.TagFavorite;
import com.yc.util.FavoriteBiz;
import com.yc.util.MyBatisHelper;

public class BaseTest {

	@Test
	public void test() {
		SqlSession session = MyBatisHelper.openSession();
		FavoriteMapper fm = session.getMapper(FavoriteMapper.class);
		TagMapper tm = session.getMapper(TagMapper.class);
		TagFacoriteMapper tfm = session.getMapper(TagFacoriteMapper.class);
		Favorite f = new Favorite();
		f.setFlabel("淘宝");
		f.setFurl("taobao.com");
		f.setFdesc("败家网站");
		f.setFtages("购物,生活");
		fm.insert(f);

		Tag t = new Tag();
		t.setTname("淘宝");
		t.setTcount(1);
		tm.insert(t);

		TagFavorite tf = new TagFavorite();
		tf.setTid(1);
		tf.setFid(1);
		tfm.insert(tf);

		session.commit();
		session.close();
	}

	@Test
	public void test2() {
		FavoriteBiz fb = new FavoriteBiz();
		Favorite f = new Favorite();
		f.setFlabel("淘宝");
		f.setFurl("taobao.com");
		f.setFdesc("败家网站");
		f.setFtages("购物,生活");
		fb.addFavorite(f);
	}

	@Test
	public void test3() {
		FavoriteBiz fb = new FavoriteBiz();
		Favorite f = new Favorite();
		f.setFlabel("网易");
		f.setFurl("163.com");
		f.setFdesc("常用网站");
		f.setFtages("门户,军事,生活");
		fb.addFavorite(f);
	}

	@Test
	public void test4() {
		SqlSession session = MyBatisHelper.openSession();
		TagMapper tm = session.getMapper(TagMapper.class);
		//tm.selectAll();

	}

}
