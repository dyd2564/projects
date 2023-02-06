package com.jafa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jafa.domain.SampleVO;

@Component
public class SampleDao {

	public List<SampleVO> list() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(SampleVO.builder().id(1L).title("샘플제목01").content("샘플내용01").build());
		list.add(SampleVO.builder().id(2L).title("샘플제목02").content("샘플내용02").build());
		list.add(SampleVO.builder().id(3L).title("샘플제목03").content("샘플내용03").build());
		return list;
	}

}
