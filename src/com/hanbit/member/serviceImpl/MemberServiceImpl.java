package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;


public class MemberServiceImpl implements MemberService{
	//값을 공유하기 위한 생성자 설정
		Map<String,MemberBean> map;
		MemberBean member;
		
		public MemberServiceImpl() {
			map = new HashMap<>();
			member = new MemberBean();
		}
		@Override
		public void addMember(MemberBean member) {
				map.put(member.getId(), member);
		}

		@Override
		public int countMembers() {
			return map.size();
		}
		
		@Override
		public List<MemberBean> getMembers() {
			List<MemberBean> list = new ArrayList<>();
			Set<String> keys = map.keySet();
			for(String s:keys){
				list.add(map.get(s));
			}
			return list;
		}
		
		@Override
		public MemberBean findByid(String id) {
			return map.get(id);
		}
		
		@Override
		public List<MemberBean> findName(String name) {
			List<MemberBean> temp = new ArrayList<>();
			Set<String> keys = map.keySet();
			for(String s:keys){
				if(name.equals(map.get(s).getName())) {
					temp.add(map.get(s));
				}
			}
			return temp;
			
		}
		
		@Override
		public void updatePass(MemberBean bean) {
			Set<String> keys = map.keySet();
			for(String s:keys){
				if(bean.getId().equals(map.get(s).getId())){
					if(!bean.getName().equals("")){
						map.get(s).setName(bean.getName());
					}
					if(!bean.getPwd().equals("")){
						map.get(s).setPwd(bean.getPwd());
					}
					if(!bean.getSsn().equals("")){
						map.get(s).setSsn(bean.getSsn());
					}
					//!bean.getSsn().equals("") ? map.get(s).setSsn(bean.getSsn()) : System.out.println("");
				}
			}
				
		}	
		@Override
		public void deleteId(String deleteId) {
			map.remove(deleteId);
		}

}
