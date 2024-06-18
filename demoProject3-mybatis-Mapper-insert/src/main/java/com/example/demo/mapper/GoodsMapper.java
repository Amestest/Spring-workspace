package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Goods;

/* 완벽한 기능을 작성하는 공간이 아니라
 * Mapper.xml에 작성한 id 리스트를 모두 리스트만 작성하는 공간이기 때문에
 * interface 로 작성
 * mapper.xml에 어떤 파일이 존재한다. 존재하는 리스트 작성란
 * @Mapper라는 어노테이션을 활용해서 SpringBoot가 Mapper를 찾을 수 있도록 설정
 * */
@Mapper //sql에 사용할 리스트 목록
public interface GoodsMapper {
	void insertGoods(Goods goods);
}
